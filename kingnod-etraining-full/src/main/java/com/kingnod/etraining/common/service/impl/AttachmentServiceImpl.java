package com.kingnod.etraining.common.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.dao.AttachmentDAO;
import com.kingnod.etraining.common.entity.Attachment;
import com.kingnod.etraining.common.service.AttachmentService;

@org.springframework.stereotype.Service
public class AttachmentServiceImpl implements AttachmentService {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected AttachmentDAO attachmentDAO;


    public Attachment getAttachment(Long id) {
        return attachmentDAO.get(id);
    }

    public int saveAttachment(Attachment attachment) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)attachment;
        if(null != idEntity.getId() && null != attachmentDAO.get(idEntity.getId())){
            count = attachmentDAO.update(attachment);
        }else{
            count = attachmentDAO.insert(attachment);
        }
        return count;
    }
    
    public String getAttachmentUrl(Attachment attachment){
    	String rootPath = SysParameterUtils.getString("sys.attachment_server_root_path");
    	return String.format("%s/segment%s/%s.%s", rootPath, attachment.getSegmentNo(), attachment.getPhysicsName(), attachment.getExt());
    }
    
    public String getAttachmentUrl(Long id){
    	if(id == null)
    	{
    		logger.error("Can't find attachment: id = " + id);
    		return Struts2Utils.getContextPath() + "/images/rq-03.png";    		
    	}
    	Attachment attachment = getAttachment(id);
    	if(null == attachment){
    		logger.error("Can't find attachment: id = " + id);
    		return Struts2Utils.getContextPath() + "/images/rq-03.png";
    	}
    	return getAttachmentUrl(attachment);
    }
    
    public int uploadAttachment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int count = 0;
    	String serverPath = SysParameterUtils.getString("sys.attachment_location");// 获取服务器路径
		String tmpPath = serverPath + "/tmpUploadsFolder/";
		String savePath = serverPath + "/uploadsFolder/";
		File tmpDir = new File(tmpPath);
		File saveDir = new File(savePath);
		if (!tmpDir.isDirectory())
			tmpDir.mkdir();
		if (!saveDir.isDirectory())
			saveDir.mkdir();
		//BufferedOutputStream out = null;
    	try {
			if (ServletFileUpload.isMultipartContent(request)) {
				response.setCharacterEncoding("utf-8");// 务必，防止返回文件名是乱码
				DiskFileItemFactory dff = new DiskFileItemFactory();// 创建该对象
				dff.setRepository(tmpDir);// 指定上传文件的临时目录
				dff.setSizeThreshold(1024000);// 指定在内存中缓存数据大小,单位为byte
				ServletFileUpload sfu = new ServletFileUpload(dff);// 创建该对象
				sfu.setFileSizeMax(50000000000L);// 指定单个上传文件的最大尺寸
				sfu.setSizeMax(1000000000000L);// 指定一次上传多个文件的总尺寸
				FileItemIterator fii = sfu.getItemIterator(request);// 解析request
																	// 请求,并返回FileItemIterator集合
				while (fii.hasNext()) {
					FileItemStream fis = fii.next();// 从集合中获得一个文件流
					if (!fis.isFormField() && fis.getName().length() > 0) {// 过滤掉表单中非文件域
						String fileName = fis.getName();// 获取文件名
						String extName = FilenameUtils.getExtension(fileName);
						
						BufferedInputStream in = new BufferedInputStream(fis.openStream());// 获得文件输入流
						String uuidName = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();// 用UUID生成文件名
						
						Long maxSegmentNo = attachmentDAO.maxSegmentNo(null);
						int countByMaxSegmentNo = attachmentDAO.countByCriteria(Cnd.builder(Attachment.class).andEQ("segmentNo", maxSegmentNo).buildCriteria());
						
						if(countByMaxSegmentNo > 1024){
							maxSegmentNo = maxSegmentNo + 1;
						}
						
						File fileDir = new File(String.format("%s%ssegment%s", saveDir, File.separatorChar, maxSegmentNo));
						if (!fileDir.isDirectory())
							fileDir.mkdir();

						File filePath = new File(String.format("%s%s%s.%s", fileDir.getPath(), File.separatorChar, uuidName, extName));
						long fileSize = 0;
						//out = new BufferedOutputStream(new FileOutputStream(filePath));// 获得文件输出流
						//fileSize = in.available();
						//Streams.copy(in, out, true);// 开始把文件写到你指定的上传文件夹
						
						String server = SysParameterUtils.getString("sys.attachment_ftp_root_path");
						URL serverUrl = new URL(server);
						FTPClient ftpClient = new FTPClient();
						ftpClient = connectFTPServer(ftpClient);
						if(!ftpClient.changeWorkingDirectory(String.format("%s/segment%s", serverUrl.getPath(), maxSegmentNo))){
							ftpClient.makeDirectory(String.format("%s/segment%s", serverUrl.getPath(), maxSegmentNo));
						}
						uploadFile(ftpClient, in, String.format("%s/segment%s/%s.%s", serverUrl.getPath(), maxSegmentNo, uuidName, extName));
						ftpClient.disconnect();
						
						
						Attachment attachment = new Attachment();
						attachment.setName(fileName);
						attachment.setExt(extName);
						attachment.setPhysicsName(uuidName);
						attachment.setSegmentNo(maxSegmentNo);
						attachment.setStatus(Attachment.STATUS_TEMP);
						attachment.setFileSize(filePath.getTotalSpace());
						saveAttachment(attachment);

						JsonConfig jsonconfig = new JsonConfig();
						jsonconfig.registerJsonBeanProcessor(Attachment.class, new JsonBeanProcessor() {
							public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
								Attachment entity = (Attachment)bean;
								JSONObject jsonObj = new JSONObject();
								jsonObj.element("id", entity.getId())
								.element("name", entity.getName())
								.element("ext", entity.getExt())
								.element("fileSize", entity.getFileSize())
								.element("segmentNo", entity.getSegmentNo())
								.element("physicsName", entity.getPhysicsName())
								.element("url", getAttachmentUrl(entity))
								.element("status", entity.getStatus());
								return jsonObj;
							}
						});
						JSON json = JSONSerializer.toJSON(ListUtils.of(attachment), jsonconfig);
						// jquery上传方式返回
						response.getWriter().print(json.toString());// 成功
					}
				}
				
			}
		} catch (Exception e) {
			response.getWriter().print("upload fail");// 失败
			logger.error(e.getMessage(), e);
		} finally{
			//if(null != out){
			//	try{out.close();}catch(Exception e){}finally{out = null;}
			//}
		}
		return count;
    }
    
    public int removeAttachment(Long... ids) {
    	String server = SysParameterUtils.getString("sys.attachment_ftp_root_path");
    	for(Long id:ids){
    		Attachment attachment = getAttachment(id);
    		try{
    			URL serverUrl = new URL(server);
    			FTPClient ftpClient = new FTPClient();
    			ftpClient = connectFTPServer(ftpClient);
    			ftpClient.deleteFile(String.format("%s/segment%s/%s", serverUrl.getPath(), attachment.getSegmentNo(), attachment.getPhysicsName()));
    			ftpClient.disconnect();
    		}catch(Exception e){
    			logger.error(e.getMessage(), e);
    		}
    	}
    	return attachmentDAO.deleteById(ids);
    }

    public int deleteAttachment(Attachment attachment) {
        return attachmentDAO.delete(attachment);
    }

    public int deleteAttachmentByIds(Long[] ids) {
        return attachmentDAO.deleteById(ids);
    }

    public PagingResult<Attachment> findAttachment(Criteria criteria) {
        return attachmentDAO.findPagingResult(criteria);
    }
    
    private FTPClient connectFTPServer(FTPClient ftp) throws Exception {
    	String server = SysParameterUtils.getString("sys.attachment_ftp_root_path");
		String userName = SysParameterUtils.getString("sys.attachment_ftp_user_name");
		String password = SysParameterUtils.getString("sys.attachment_ftp_password");
		URL serverUrl = new URL(server);
		try {
			
			String systemKey = FTPClientConfig.SYST_UNIX;
			String serverLanguageCode = "zh";
			FTPClientConfig conf = new FTPClientConfig(systemKey);
			conf.setServerLanguageCode(serverLanguageCode);
			conf.setDefaultDateFormatStr("yyyy-MM-dd");
			
			ftp.configure(conf);
			ftp.connect(serverUrl.getHost(), serverUrl.getPort());
			if (!ftp.login(userName, password)) {
				ftp.logout();
				ftp = null;
				return ftp;
			}
			ftp.changeWorkingDirectory(serverUrl.getPath());
			// 文件类型,默认是ASCII
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.setControlEncoding("UTF-8");
			// 设置被动模式
			ftp.enterLocalPassiveMode();
			
			ftp.setConnectTimeout(2000);
			ftp.setBufferSize(1024);
			// 响应信息
			int replyCode = ftp.getReplyCode();
			if ((!FTPReply.isPositiveCompletion(replyCode))) {
				// 关闭Ftp连接
				closeFTPClient(ftp);
				// 释放空间
				ftp = null;
				throw new Exception("登录FTP服务器失败,请检查![Server:" + server + "、" + "User:" + userName + "、" + "Password:" + password);
			} else {
				return ftp;
			}
		} catch (Exception e) {
			ftp.disconnect();
			ftp = null;
			throw e;
		}
	}

	private void closeFTPClient(FTPClient ftp) {
		try {
			if (ftp.isConnected())
				ftp.logout();
			ftp.disconnect();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
    
	public Boolean uploadFile(FTPClient ftp, InputStream input, String newName) throws Exception {
		boolean success = false;
		try {
			success = ftp.storeFile(newName, input);
			if (!success) {
				throw new Exception("文件上传失败!");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}
    
}