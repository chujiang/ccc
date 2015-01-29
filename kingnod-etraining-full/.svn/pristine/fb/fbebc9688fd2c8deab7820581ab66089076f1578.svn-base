package com.kingnod.etraining.course.samplerte.server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.struts2.components.UIBean;

import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.course.server.models.FolderNode;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import freemarker.template.utility.StringUtil;

public class FtpServer {
	
	private static final Logger log = LoggerFactory.getLogger(FtpServer.class);

	private FTPClient ftp = null;
	/**
	 * Ftp服务器
	 */
	private URL server;
	/**
	 * 用户名
	 */
	private String uname;
	/**
	 * 密码
	 */
	private String password;
	
	private String rootPath;

	// 这个数字的初始值不能为0
	private int maxNodeID;

	// private Document document ;

	public FtpServer(URL server, String uname, String password)
			throws Exception {
		this.server = server;
		this.uname = uname;
		this.password = password;
		// 初始化
		ftp = new FTPClient();
	}
	
	public int getPort(){
		return -1 == this.server.getPort()?21:this.server.getPort();
	}
	
	/**
	 * 连接FTP服务器
	 * 
	 * @param server
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public FTPClient connectFTPServer() throws Exception {
		String[] a = {server.getHost(),String.valueOf(server.getPort()),uname,password};
		try {
			ftp.configure(getFTPClientConfig());
			ftp.connect(this.server.getHost(), this.server.getPort()==0?21:this.server.getPort());
			if (!ftp.login(this.uname, this.password)) {
				ftp.logout();
				ftp = null;
				return ftp;
			}

			// 文件类型,默认是ASCII
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.setControlEncoding("UTF-8");
			// 设置被动模式
			ftp.enterLocalPassiveMode();
			FTPClientConfig conf = new FTPClientConfig(
					FTPClientConfig.SYST_UNIX);
			conf.setServerLanguageCode("zh");
			ftp.configure(conf);
			ftp.setConnectTimeout(2000);
			ftp.setBufferSize(1024);
			// 响应信息
			int replyCode = ftp.getReplyCode();
			if ((!FTPReply.isPositiveCompletion(replyCode))) {
				// 关闭Ftp连接
				closeFTPClient();
				// 释放空间
				ftp = null;
				throw Exceptions.createAppException("crs001006",a);
			} else {
				return ftp;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ftp.disconnect();
			ftp = null;
			throw Exceptions.createAppException("crs001006",a);
		}
	}

	/**
	 * 配置FTP连接参数
	 * 
	 * @return
	 * @throws Exception
	 */
	public FTPClientConfig getFTPClientConfig() throws Exception {
		String systemKey = FTPClientConfig.SYST_UNIX;
		String serverLanguageCode = "zh";
		FTPClientConfig conf = new FTPClientConfig(systemKey);
		conf.setServerLanguageCode(serverLanguageCode);
		conf.setDefaultDateFormatStr("yyyy-MM-dd");
		return conf;
	}

	/**
	 * 向FTP根目录上传文件
	 * 
	 * @param localFile
	 * @param newName
	 *            新文件名
	 * @throws Exception
	 */
	public Boolean uploadFile(String localPath, String remotePath)
			throws Exception {
		String localFile = new String(localPath.getBytes("UTF-8"), "UTF-8");
		String newName = new String(remotePath.getBytes("UTF-8"), "UTF-8");
		InputStream input = null;
		boolean success = false;
		try {
			File file = null;
			if (checkFileExist(localFile)) {
				file = new File(localFile);
			}
			input = new FileInputStream(file);
			remotePath.replaceAll("/", File.separator);
			String[] split = StringUtil.split(newName, File.separator, true);
			for (String path : split) {
				if (null != path.trim() && !path.trim().equals("")
						&& path.trim().indexOf(".") < 0) {
					// ftp.changeToParentDirectory();
					FTPFile[] listNames = ftp.listDirectories();
					FTPFile existsFile = existsFile(listNames, new File(path));
					if (null == existsFile) {
						createFold(path);
					} else {
						this.changeDirectory(path);
					}

				}
			}
			success = uploadFile(input, newName);
			if (!success) {
				throw Exceptions.createAppException("crs001007");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}

	/**
	 * 向FTP根目录上传文件
	 * 
	 * @param input
	 * @param newName
	 *            新文件名
	 * @throws Exception
	 */
	public Boolean uploadFile(InputStream input, String newName)
			throws Exception {
		boolean success = false;
		try {
			success = ftp.storeFile(new String(newName.getBytes("UTF-8"),"iso-8859-1"), input);
			if (!success) {
				throw Exceptions.createAppException("crs001007");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}

	/**
	 * 向FTP指定路径上传文件
	 * 
	 * @param localFile
	 * @param newName
	 *            新文件名
	 * @param remoteFoldPath
	 * @throws Exception
	 */
	public Boolean uploadFile(String localFile, String newName,
			String remoteFoldPath) throws Exception {

		InputStream input = null;
		boolean success = false;
		try {
			File file = null;
			if (checkFileExist(localFile)) {
				file = new File(localFile);
			}
			input = new FileInputStream(file);

			// 改变当前路径到指定路径
			if (!this.changeDirectory(remoteFoldPath)) {
				throw Exceptions.createAppException("crs001008");
			}
			success = ftp.storeFile(newName, input);
			if (!success) {
				throw Exceptions.createAppException("crs001007");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}

	/**
	 * 向FTP指定路径上传文件
	 * 
	 * @param input
	 * @param newName
	 *            新文件名
	 * @param remoteFoldPath
	 * @throws Exception
	 */
	public Boolean uploadFile(InputStream input, String newName,
			String remoteFoldPath) throws Exception {
		boolean success = false;
		try {
			// 改变当前路径到指定路径
			if (!this.changeDirectory(remoteFoldPath)) {
				throw Exceptions.createAppException("crs001008");
			}
			success = ftp.storeFile(newName, input);
			if (!success) {
				throw Exceptions.createAppException("crs001007");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}

	/**
	 * 用递归上传文件夹
	 * 
	 * @param fileName
	 * @param uploadPath
	 * @return
	 * @throws Exception
	 */
	public boolean uploadAll(String name, String rpath) throws Exception {
		String fileName = new String(name.getBytes("UTF-8"), "UTF-8");
		String uploadPath = new String(rpath.getBytes("UTF-8"), "UTF-8");
		boolean success = false;
		File file = new File(fileName);
		if (!file.exists()) {
			return success;
		} else {
			String replace = StringUtils.replace(uploadPath,"/",File.separator);
			String[] split = StringUtil.split(replace, File.separator, true);
			for (String path : split) {
				if (null != path.trim() && !path.trim().equals("")) {
					FTPFile[] listNames = ftp.listDirectories();
					FTPFile existsFile = existsFile(listNames, new File(path));
					if (null == existsFile) {
						createFold(path);
					} else {
						changeDirectory(path);
					}
				}
			}
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					if (f.isDirectory()) {

						uploadAll(f.getPath(), f.getName());

					} else {
						uploadFile(f.getPath(), f.getName());
					}
				}
			} else {
				uploadFile(file.getPath(), file.getName());
			}
			ftp.changeToParentDirectory();
			// System.err.println(uploadPath);
		}
		return true;
	}

	/**
	 * 从FTP服务器下载文件
	 * 
	 * @param remotePath
	 *            FTP路径(不包含文件名)
	 * @param fileName
	 *            下载文件名
	 * @param localPath
	 *            本地路径
	 */
	public Boolean downloadFile(String remotePath, String fileName,
			String localPath) throws Exception {

		BufferedOutputStream output = null;
		boolean success = false;
		try {
			// 检查本地路径
			this.checkFileExist(localPath);
			// 改变工作路径
			if (!this.changeDirectory(remotePath)) {
				throw Exceptions.createAppException("crs001008");
			}
			// 列出当前工作路径下的文件列表
			List<FTPFile> fileList = this.getFileList();
			if (fileList == null || fileList.size() == 0) {
				throw Exceptions.createAppException("crs001009");
			}
			for (FTPFile ftpfile : fileList) {
				if (ftpfile.getName().equals(fileName)) {
					File localFilePath = new File(localPath + File.separator
							+ ftpfile.getName());
					output = new BufferedOutputStream(new FileOutputStream(
							localFilePath));
					success = ftp.retrieveFile(ftpfile.getName(), output);
				}
			}
			if (!success) {
				throw Exceptions.createAppException("crs001010");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			if (output != null) {
				output.close();
			}
		}
		return success;
	}

	public List<FolderNode> getFolderNodeList(List<FolderNode> folderNodeList,
			String pNodeName, FolderNode pNode) throws Exception {
		if (getMaxNodeID() <= 0) {
			throw new Exception("MaxNodeID must be greater than 0");
		}
		FTPFile[] listDirectories = null;
		if (null == pNodeName.trim() || pNodeName.trim().equals("")) {
			listDirectories = ftp.listDirectories();
		} else {
			listDirectories = ftp.listDirectories(new String(pNodeName
					.getBytes("UTF-8"), "iso-8859-1"));
		}
		for (FTPFile ftpFile : listDirectories) {
			String name = "";
			FolderNode node = new FolderNode(
					String.valueOf(this.getMaxNodeID()),
					String.valueOf(pNode == null ? 0 : pNode.getId()),
					new String(ftpFile.getName().getBytes("UTF-8"), "UTF-8"),
					true);
			node.setPath(pNodeName.concat(File.separator).concat(
					ftpFile.getName()));
			node.setIcon(Struts2Utils.getRequest().getContextPath()
					+ "/img/tree/site.gif");
			node.setRoot(true);// 设置根节点不能拖拽
			node.setChildNode(true);// 设置根节点的可以添加子节点
			node.setEditable(false);// 设置根节点不可以编辑和删除
			node.setNodeType(FolderNode.COURSE_FOLDER);
			folderNodeList.add(node);
			// ++i;
			this.setMaxNodeID(getMaxNodeID() + 1);
			if (null == pNode) {
				name = node.getName();
			} else {
				name = pNodeName.concat(File.separator).concat(node.getName());
			}
			if (ftp.listDirectories(new String(name.getBytes("UTF-8"),
					"iso-8859-1")).length > 0) {
				getFolderNodeList(folderNodeList, name, node);
			}
		}
		return folderNodeList;
	}
	
	public static String encodes(String content){
		try {
			return new String(content.getBytes("UTF-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}
		return "";
	}

	public List<FolderNode> getDirectoriesNameList(List<FolderNode> folderNodeList, String pNode, int id) throws Exception {
		FTPFile[] listDirectories = null;
		boolean isParent = false;
		boolean isHomology = false;
		String workingDir = this.server.getPath();
		if (null != pNode && "" != pNode) {
			workingDir = workingDir + "/" + pNode;
		}
		listDirectories = ftp.listDirectories(encodes(workingDir));
		for (FTPFile ftpFile : listDirectories) {
			this.ftp.changeWorkingDirectory(encodes(workingDir + "/" + ftpFile.getName()));
			String[] fileNames = this.ftp.listNames(encodes(workingDir + "/" + ftpFile.getName()));
			boolean isCourseFolder = false;
			List<String> fileNameList = Arrays.asList(fileNames);
			if(fileNameList.contains("imsmanifest.xml") || fileNameList.contains("isCourse.txt")){
				isCourseFolder = true;
			}
			
			FolderNode node = new FolderNode(String.valueOf(this.getMaxNodeID()), String.valueOf(id), new String(
					ftpFile.getName().getBytes("UTF-8"), "UTF-8"), isParent);
			node.setPath(pNode == "" ? ftpFile.getName() : pNode.concat(File.separator).concat(ftpFile.getName()));
			node.setIcon(Struts2Utils.getRequest().getContextPath() + "/img/tree/folder_Open.png");
			if(isCourseFolder){
				node.setIcon(Struts2Utils.getRequest().getContextPath() + "/img/tree/course.png");
			}
			node.setRoot(true);// 设置根节点不能拖拽
			node.setChildNode(true);// 设置根节点的可以添加子节点
			node.setEditable(false);// 设置根节点不可以编辑和删除
			node.setNodeType(isCourseFolder?FolderNode.COURSEWARE:FolderNode.COURSE_FOLDER);
			node.setClick(isCourseFolder?false:true);
			node.setParent(isCourseFolder?false:true);
			folderNodeList.add(node);
			this.setMaxNodeID(getMaxNodeID() + 1);
		}
		this.ftp.changeWorkingDirectory(encodes(workingDir));
		return folderNodeList;
	}

	/**
	 * 从FTP服务器获取文件流
	 * 
	 * @param remoteFilePath
	 * @return
	 * @throws Exception
	 */
	public InputStream downloadFile(String remoteFilePath) throws Exception {

		return ftp.retrieveFileStream(remoteFilePath);
	}

	/**
	 * 获取FTP服务器上指定路径下的文件列表
	 * 
	 * @param filePath
	 * @return
	 */
	public List<FTPFile> getFtpServerFileList(String remotePath)
			throws Exception {

		FTPListParseEngine engine = ftp.initiateListParsing(remotePath);
		List<FTPFile> ftpfiles = Arrays.asList(engine.getNext(25));

		return ftpfiles;
	}

	/**
	 * 获取FTP服务器上[指定路径]下的文件列表
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<FTPFile> getFileList(String remotePath) throws Exception {

		List<FTPFile> ftpfiles = Arrays.asList(ftp.listFiles(new String(remotePath
				.getBytes("UTF-8"), "iso-8859-1")));


		return ftpfiles;
	}

	/**
	 * 获取FTP服务器[当前工作路径]下的文件列表
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<FTPFile> getFileList() throws Exception {
		ftp.changeToParentDirectory();
		List<FTPFile> ftpfiles = Arrays.asList(ftp.listFiles());

		return ftpfiles;
	}

	/**
	 * 切换FTP服务器工作路径到根路径
	 * 
	 * @param remoteFoldPath
	 */
	public Boolean changeParentDirectory() throws Exception {

		return ftp.changeToParentDirectory();
	}

	/**
	 * 改变FTP服务器工作路径
	 * 
	 * @param remoteFoldPath
	 */
	public Boolean changeDirectory(String remoteFoldPath) throws Exception {

		return ftp.changeWorkingDirectory(new String(remoteFoldPath
				.getBytes("UTF-8"), "iso-8859-1"));
	}

	/**
	 * 删除文件
	 * 
	 * @param remoteFilePath
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteFtpServerFile(String remoteFilePath) throws Exception {

		return ftp.deleteFile(encodes(remoteFilePath));
	}

	/**
	 * 创建目录
	 * 
	 * @param remoteFoldPath
	 * @return
	 */
	public boolean createFold(String remoteFoldPath) throws Exception {
		boolean flag = ftp.makeDirectory(new String(remoteFoldPath
				.getBytes("UTF-8"), "iso-8859-1"));
		ftp.setControlEncoding("UTF-8");
		flag = changeDirectory(remoteFoldPath);
		if (!flag) {
			throw Exceptions.createAppException("crs0010011");
		}
		return false;
	}

	/**
	 * 删除目录
	 * 
	 * @param remoteFoldPath
	 * @return
	 * @throws Exception
	 */
	public boolean deleteFold(String remoteFoldPath) throws Exception {

		return ftp.removeDirectory(encodes(remoteFoldPath));
	}

	/**
	 * 删除目录以及文件
	 * 
	 * @param remoteFoldPath
	 * @return
	 */
	public boolean deleteFoldAndsubFiles(String remoteFoldPath)
			throws Exception {
		remoteFoldPath = encodes(remoteFoldPath);
		boolean success = false;
		List<FTPFile> list = this.getFileList(remoteFoldPath);
		if (list == null || list.size() == 0) {
			return deleteFold(remoteFoldPath);
		}
		for (FTPFile ftpFile : list) {

			String name = ftpFile.getName();
			if (ftpFile.isDirectory()) {
				success = deleteFoldAndsubFiles(remoteFoldPath + "/" + name);
				if (!success)
					break;
			} else {
				success = deleteFtpServerFile(remoteFoldPath + "/" + name);
				if (!success)
					break;
			}
		}
		if (!success)
			return false;
		success = deleteFold(remoteFoldPath);
		return success;
	}

	/**
	 * 检查本地路径是否存在
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public boolean checkFileExist(String filePath) throws Exception {
		boolean flag = false;
		File file = new File(filePath);
		if (!file.exists()) {
			throw Exceptions.createAppException("crs0010012");
		} else {
			flag = true;
		}
		return flag;
	}

	
	public boolean checkRemoteRootPath(String FolderName)
	    {
		 FolderName = encodes(FolderName);
		 FolderName = FolderName.replaceFirst("/", "");
			try {
				List<FTPFile> fileList = getFileList();
				  for(FTPFile ff : fileList){
			        	if(ff.getName().equals(FolderName)){
			        		return true;
			        	}
			        }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	        return false;
	    }

	public boolean checkRemoteFilesOrPath(String FolderName)
    {
	 FolderName = encodes(FolderName);
	 FolderName = FolderName.replaceFirst("/", "");
        
		try {
			List<FTPFile> fileList = getFileList(FolderName);
			if(fileList.size()>0){
				return true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        return false;
    }
	/**
	 * 返回上级目录
	 * 
	 */
	public void toParentDir(String[] remoteDirs) {
		try {
			for (int i = 0; i < remoteDirs.length; i++) {
				this.ftp.changeToParentDirectory();
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	private FTPFile existsFile(FTPFile[] remoteFiles, File file) {
		for (FTPFile remoteFile : remoteFiles) {
			if (file.getName().equals(remoteFile.getName())) {
				return remoteFile;
			}
		}
		return null;
	}

	/**
	 * 关闭FTP连接
	 * 
	 * @param ftp
	 * @throws Exception
	 */
	public void closeFTPClient(FTPClient ftp) throws Exception {

		try {
			if (ftp.isConnected())
				ftp.logout();
			ftp.disconnect();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw Exceptions.createAppException("crs0010013");
		}
	}

	/**
	 * 关闭FTP连接
	 * 
	 * @throws Exception
	 */
	public void closeFTPClient() throws Exception {

		this.closeFTPClient(this.ftp);
	}
	
	public boolean isConnected(){
		return this.ftp.isConnected();
	}
	
	public boolean isAvailable(){
		return this.ftp.isAvailable();
	}
	/**
	 * Get Attribute Method
	 * 
	 */
	public FTPClient getFtp() {
		return ftp;
	}

	public URL getServer() {
		return server;
	}

	public String getUname() {
		return uname;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Set Attribute Method
	 * 
	 */
	public void setFtp(FTPClient ftp) {
		this.ftp = ftp;
	}

	public void setServer(URL server) {
		this.server = server;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMaxNodeID(int maxNodeID) {
		this.maxNodeID = maxNodeID;
	}

	public int getMaxNodeID() {
		return maxNodeID;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
	

	/**
	 * 主方法(测试)
	 * 
	 * 问题：上传时命名的新文件名不能有中文，否则上传失败.
	 * 
	 * @param args
	 */
//	 public static void main(String[] args) {
//	 try {
//	 FtpServer fu = new FtpServer(new URL("ftp://192.16.8.243:21/course"), "admin", "admin");
//	 fu.connectFTPServer();
//	 fu.getFileList(new String("C:\\Users\\a\\Desktop\\中文css.pdf".getBytes("UTF-8"), "iso-8859-1"));

//	 设置PassiveMode传输
//	 fu.ftp.enterLocalPassiveMode();
	// 设置以二进制流的方式传输
//	 fu.ftp.setFileType(FTP.BINARY_FILE_TYPE);
//	 fu.ftp.setControlEncoding("UTF-8");
//	 FTPClientConfig conf = new
//	 FTPClientConfig(FTPClientConfig.SYST_UNIX);
//	 conf.setServerLanguageCode("zh");
//	 fu.ftp.configure(conf);
//	 fu.deleteFtpServerFile("//test//LS00803.zip");
//	 fu.deleteFoldAndsubFiles("//test//LS00803.zip");
//	 fu.uploadFile(
//	 new FileInputStream(new
//	 File("C:\\Users\\a\\Desktop\\中文css.pdf")),
//	 "\\course\\中文css");

	// fu.uploadAll(
	// "D:\\kingnode项目资料\\课件样板\\标准课件\\LS00803.zip",
	// "\\test");
	// fu.uploadAll("E:\\学习资源\\源码\\FTP\\src", "\\test\\long\\源码\\src");
	// List<FolderNode> folderNodeList = fu.getFolderNodeList(new
	// ArrayList<FolderNode>(),null);
	// fu.ftp.cwd("test");
	// fu.ftp.changeWorkingDirectory("test");
	// fu.ftp.listNames();
	// FTPFile[] listDirectories = fu.ftp.listFiles();
	// FTPFile[] listDirectories2 = fu.ftp.listDirectories();
	// System.out.println("xx@@@@");
	// FTPFile[] listDirectories = fu.ftp.listDirectories("test/long");
	// FTPFile f1 = listDirectories[0];
	// System.out.println(new String(f1.getName().getBytes("iso-8859-1"),
	// "UTF-8"));
	// int i = 1;
	// fu.setMaxNodeID(i);
	// fu.ftp.changeWorkingDirectory("/long");
	// List<FolderNode> directoriesNameList = fu.getFolderNodeList(new
	// ArrayList<FolderNode>(),"",null);
	// FTPFile[] listDirectories = fu.ftp.listDirectories();
	// for (FTPFile f : listDirectories) {
	// System.out.println(f.getName());
	// }
	// for (FolderNode f : listDirectories) {
	// System.out.println("ID: " + f.getId() + "    " +"文件名: " +
	// f.getName()+"   "+"PID: " + f.getpId());
	// }
	// Element fatherElement = fu.getCurrentElement();
	// fu.createDirectoryXML("/", fatherElement);
	// fu.saveXML();
//	 fu.closeFTPClient();
//	 } catch (Exception e) {
//	 System.out.println("异常信息：" + e.getMessage());
//	 }finally{
//		 
//	 }
//	 }

}
