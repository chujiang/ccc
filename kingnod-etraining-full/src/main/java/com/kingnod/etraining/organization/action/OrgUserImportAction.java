package com.kingnod.etraining.organization.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Cell;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.io.IOUtils;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserProperties;
import com.kingnod.etraining.organization.entity.UserPropertyData;
import com.kingnod.etraining.organization.entity.UserPropertyOption;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserPropertiesService;
import com.kingnod.etraining.organization.service.UserPropertyDataService;
import com.kingnod.etraining.organization.service.UserPropertyOptionService;
import com.kingnod.etraining.organization.service.UserService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "org-user-import", "namespace", "/org"}),
@Result(name = "importPage", location = "/WEB-INF/content/org/org-user-import.jsp", params = { "actionName", "org-user-import", "namespace", "/org", "siteId", "${siteId}", "parentId", "${parentId}"})
}
)

public class OrgUserImportAction extends FilterableEntityAction<Site, Long> {

    @Autowired
    private SiteService siteService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserPropertiesService userPropertiesService;
    @Autowired
    private UserPropertyDataService userPropertyDataService;
    @Autowired
    private UserPropertyOptionService userPropertyOptionService;
    

    private File importFile;	//用户上传的导入文件
    private Long siteId;		//站点ID
    private Long parentId;		//父节点ID
    private String userPropertyNames;				//导入文件中用户表的扩展属性对应的字段名
    private List<UserProperties> userPropertyList;	//导入文件中用户表的扩展属性对应的属性集合
    

    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    public String filterDefines() {
        return "org.siteFilterItems";
    }
    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    protected Object getEntityService() {
        return this.siteService;
    }
    
    
    /**
     * 弹出导入页面
     * @return
     */
    public String importPage() {
    	return "importPage";
    }

    
    /**
     * 下载报表模板
     */
    public void download() {
    	InputStream inputStream = OrgUserImportAction.class.getResourceAsStream("/template/orgUserImportTemplate.xls");
		try {
			download(inputStream, URLEncoder.encode("导入模板.xls",StringUtils.ENCODING_UTF8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }
    
    
    /**
     * 下载导入失败文件
     */
    public void downloadErrorFile() {
    	String path =SysParameterUtils.getString("sys.export_temp_path");
    	try {
			download(path, "orgUserImportResult.xls", URLEncoder.encode("导入结果.xls",StringUtils.ENCODING_UTF8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }
    
    
    /**
     * 下载文件
     * @param fileName
     */
	public void download(String path, String fileName, String saveAsName) {
		FileInputStream in = null;
		try {
			// 获得响应客户的输出流：
			OutputStream o = response.getOutputStream();
			// 输出文件用的字节数组,每次发送500个字节到输出流：
			byte b[] = new byte[500];
			// 下载的文件：
			File fileLoad = new File(path, fileName);
			// 客户使用保存文件的对话框：
			response.setHeader("Content-disposition", "attachment;filename=" + saveAsName);
			// 通知客户文件的MIME类型：
			response.setContentType("application/vnd.ms-excel");
			// 通知客户文件的长度：
			long fileLength = fileLoad.length();
			String length = String.valueOf(fileLength);
			response.setHeader("Content_Length", length);
			// 读取文件,并发送给客户下载:
			in = new FileInputStream(fileLoad);
			int n = 0;
			while ((n = in.read(b)) != -1) {
				o.write(b, 0, n);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (Exception e) {
			} finally {
				in = null;
			}
		}
	}
	
	
	/**
	 * 下载文件，根据输入流
	 * @param inputStream
	 * @param saveAsName
	 */
	public void download(InputStream inputStream, String saveAsName) {
		OutputStream outputStream=null;
		try {
			outputStream = response.getOutputStream();			
			response.setHeader("Content-disposition", "attachment;filename=" + saveAsName);
			response.setContentType("application/vnd.ms-excel");			 
			IOUtils.bufferedCopy(inputStream, outputStream); 
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			IOUtils.close(inputStream, outputStream); 
		}
	}
	
	
	/**
	 * 获取导入文件，然后校验、解析、导入、并将导入错误信息写入excel文件
	 * @return
	 * @throws Throwable 
	 */
	public String importSave() throws Throwable {
		String checkInfo = checkImportFile(importFile);
		if(StringUtils.isNotBlank(checkInfo)) {
			request.setAttribute("checkInfo", checkInfo);
		} else {
			List<Organization> orgList = getOrgUserList(importFile, 0);
			List<User> userList = getOrgUserList(importFile, 1);
			Map errOrgMap = updateOrganization(orgList);
			Map errUserMap = updateUser(userList, orgList);
			toExcel(importFile,errOrgMap, errUserMap);
			request.setAttribute("checkInfo", "组织信息：成功"+(orgList.size() - errOrgMap.size())+"条，失败"+errOrgMap.size()+"条；用户信息：成功"+(userList.size() - errUserMap.size())+"条，失败"+errUserMap.size()+"条");
			request.setAttribute("operationFlag", "true");
			if(errOrgMap.size()>0 || errUserMap.size()>0) {
				request.setAttribute("importCompleted", "false");
			} else if(errOrgMap.size() == 0 && errUserMap.size() == 0) {
				request.setAttribute("importCompleted", "true");
			}
		}
		return "importPage";
	}
	
	
	/**
	 * 将错误的组织用户信息写入excel文件供用户下载 
	 * @param errOrgMap
	 * @param errUserMap
	 */
	private void toExcel(File importFile, Map errOrgMap, Map errUserMap) {
		String exportPath =SysParameterUtils.getString("sys.export_temp_path");
		File exportFile = new File(exportPath + "/orgUserImportResult.xls"); 
		try {
			Workbook wbk = Workbook.getWorkbook(importFile);
    		WritableWorkbook wwb = Workbook.createWorkbook(exportFile, wbk);
    		
			WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 10,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.RED);						// 定义格式 字体 下划线 斜体 粗体 颜色
			WritableCellFormat wcf = new WritableCellFormat(wf); 	// 单元格定义

    		// 写第一张表（组织表）
    		WritableSheet sheet1 = wwb.getSheet(0);
    		int orgCols = sheet1.getColumns();
    		sheet1.setColumnView(orgCols, 50); 
    		Label orgErrTitle = new Label(orgCols, 0, "错误信息");
		    sheet1.addCell(orgErrTitle);
    		Set orgSet =errOrgMap.keySet();
			Iterator orgIt = orgSet.iterator();
			while (orgIt.hasNext()) {
				int rowNum = (Integer) orgIt.next();
			    String errMsg = (String) errOrgMap.get(rowNum);
			    Label msgCell = new Label(orgCols, rowNum, errMsg, wcf);
			    sheet1.addCell(msgCell);
			}
			// 写第二张表（用户表）
    		WritableSheet sheet2 = wwb.getSheet(1);
    		int userCols = sheet2.getColumns();
    		sheet2.setColumnView(userCols, 50); 
    		Label userErrTitle = new Label(userCols, 0, "错误信息");
		    sheet2.addCell(userErrTitle);
    		Set userSet =errUserMap.keySet();
			Iterator userIt = userSet.iterator();
			while (userIt.hasNext()) {
				int rowNum = (Integer) userIt.next();
			    String errMsg = (String) errUserMap.get(rowNum);
			    Label msgCell = new Label(userCols, rowNum, errMsg, wcf);
			    sheet2.addCell(msgCell);
			}
    		wwb.write(); 
            wwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 校验用户上传的excel导入文件是否合法
	 * @param importFile
	 * @return
	 * @throws Exception
	 */
	private String checkImportFile(File importFile) throws Exception {
		//获得用户上传的excel文件
		Workbook workBook = Workbook.getWorkbook(importFile);
		//模板文件列头规范
		String orgTempTitles = "父组织编码,组织编码,名称,描述,部门经理（登录名）";	//组织总字段
		String orgTempTitlesNotNull = "0,1,2";							//非空字段序号
		String userTempTitles = "所属组织（编码）,登录名,密码,姓名,昵称,邮箱,上级领导（登录名）,是否管理员（是/否）,使用状态（锁定/有效）,使用有效期";	//用户总字段
		String userTempTitlesNotNull = "0,1,2,3";						//非空字段序号
		
		//****************第一张工作表（组织表）校验****************
		// 1.校验列头
		Sheet sheet1 = workBook.getSheet(0);
//		String orgTitles = "";
//		for (int i = 0; i < orgTempTitles.split(",").length; i++) {	// 获取列头
//			Cell cell = sheet1.getCell(i, 0);
//			orgTitles = orgTitles + StringUtils.trim(cell.getContents()) + ",";
//		}
//		if (!orgTempTitles.equals(deleteLastChar(orgTitles))) {	//判断列头是否正确
//			return "组织表表头有误";
//		}
		
		// 2.判断组织表中，必填字段是否为空
		int orgRows = sheet1.getRows();
		int orgCols = sheet1.getColumns();
		String orgCodeErr = "";
		String orgEmptyInfo = "";
		for(int i=1; i<orgRows; i++) {	//从第二行开始逐行校验
			for(String index : orgTempTitlesNotNull.split(",")) {
				Cell tmpCell = sheet1.getCell(NumberUtils.toInt(index), i);	//校验非空单元格
				if(StringUtils.isEmpty(tmpCell.getContents())) {
					orgEmptyInfo = orgEmptyInfo + (i+1) + ",";
					break;
				}
			}
			Cell parentOrgCell =  sheet1.getCell(0, i);
			Cell orgCell = sheet1.getCell(1, i);
			if(StringUtils.trim(parentOrgCell.getContents()).length()>10 || StringUtils.trim(orgCell.getContents()).length()>10 ) {
				orgCodeErr = orgCodeErr + (i+1) + ",";
			}
		}
		if(StringUtils.isNotEmpty(orgEmptyInfo)) {
			return "组织表中第" + deleteLastChar(orgEmptyInfo) + "行有空数据，请检查";
		}
		if(StringUtils.isNotEmpty(orgCodeErr)) {
			return "组织表中第" + deleteLastChar(orgCodeErr) + "行有组织编码长度大于10，请检查";
		}
		
		// 3.判断组织编码列是否有重复
		String orgShortNames = "";
		for(int i = 1; i<orgRows; i++) {	//集合所有组织编码
			String tmpName = sheet1.getCell(1, i).getContents();
			orgShortNames = orgShortNames + tmpName + ",";
		}
		if(StringUtils.isEmpty(orgShortNames)) {
			return "组织表数据为空";
		} else {
			orgShortNames = deleteLastChar(orgShortNames);
			String sameOrgShortName = findSameString(orgShortNames);
			if(StringUtils.isNotEmpty(sameOrgShortName)) {
				return "组织表中组织名称“" + sameOrgShortName + "”有重复，请检查";
			}
		}
		
		
		//****************第二张工作表（用户表）校验****************
		// 1.校验列头
		Sheet sheet2 = workBook.getSheet(1);
//		String userTitles = "";
//		for (int i = 0; i < 10; i++) {	// 获取列头
//			Cell cell = sheet2.getCell(i, 0);
//			userTitles = userTitles + StringUtils.trim(cell.getContents()) + ",";
//		}
//		if (userTempTitles.equals(deleteLastChar(userTitles))) {	//判断列头是否正确
//			return "用户表表头有误";
//		}
		
		// 2.判断用户表中，必填字段是否为空
		int userRows = sheet2.getRows();
		int userCols = sheet2.getColumns();
		orgCodeErr = "";
		for(int i=1; i<userRows; i++) {	//从第二行开始逐行校验
			for(String index : userTempTitlesNotNull.split(",")) {
				Cell tmpCell = sheet2.getCell(NumberUtils.toInt(index), i);	//校验非空单元格
				if(StringUtils.isEmpty(tmpCell.getContents())) {
					orgEmptyInfo = orgEmptyInfo + (i+1) + ",";
					break;
				}
			}
			Cell orgCell = sheet2.getCell(0, i);
			if(StringUtils.trim(orgCell.getContents()).length()>10) {
				orgCodeErr = orgCodeErr + (i+1) + ",";
			}
		}
		if(StringUtils.isNotEmpty(orgEmptyInfo)) {
			return "用户表中第" + deleteLastChar(orgEmptyInfo) + "行有空数据，请检查";
		}
		if(StringUtils.isNotEmpty(orgCodeErr)) {
			return "用户表中第" + deleteLastChar(orgCodeErr) + "行有组织编码长度大于10，请检查";
		}
		
		// 3.判断登录名列是否有重复
		String userNames = "";
		for(int i = 1; i<userRows; i++) {	//集合所有用户名
			String tmpName = sheet2.getCell(1, i).getContents();
			userNames = userNames + tmpName + ",";
		}
		if(StringUtils.isEmpty(userNames)) {
			return "用户表数据为空";
		} else {
			userNames = deleteLastChar(userNames);
			String sameUserName = findSameString(userNames);
			if(StringUtils.isNotEmpty(sameUserName)) {
				return "用户表中用户名“" + sameUserName + "”有重复，请检查";
			}
		}
		
		//4.判断用户扩展属性是否正确
	    String nameErr = "";		//错误列头
	    String names = "";			//所有列头
	    String propertyNames = "";	//列头对应的ORG_USER_PROPERTY_DATA表的字段名
	    List<UserProperties> allProperties = new ArrayList();	//列头属性集合
	    for(int j=10; j<userCols; j++) {
			Cell cellExpand = sheet2.getCell(j, 0);
			String name = StringUtils.trim(cellExpand.getContents());
			UserProperties tmpProperty = getUserProperty(siteId, name);
			if(null == tmpProperty) {
				nameErr = nameErr + name + ",";
			} else {
				String propertyName = tmpProperty.getPropertyName();
				propertyNames = propertyNames + propertyName + ",";
			}
			names = names + name + ",";
			allProperties.add(tmpProperty);
	    }
	    String samePropertyName = findSameString(deleteLastChar(names));	//找出重复的列头，例如用户加了两个“入职日期”列
	    this.userPropertyNames = propertyNames;
	    this.userPropertyList = allProperties;
	    if(StringUtils.isNotEmpty(nameErr)) {
	    	return "用户表中“" + deleteLastChar(nameErr) + "”列未配置，请先配置用户属性或修改导入文件";
	    } else if(StringUtils.isNotEmpty(samePropertyName)) {
	    	return "用户表中“" + samePropertyName + "”列重复，请检查";
	    }

		return "";
	}

	/**
	 * 解析导入文件，获取所有组织和用户信息记录
	 * @param importFile
	 * @return
	 * @throws Throwable 
	 * @throws BiffException 
	 */
	public List getOrgUserList(File importFile, int sheetNo) throws BiffException, Throwable {
		List list = null;
		Workbook workBook = Workbook.getWorkbook(importFile);
		List<Organization> orgList = new ArrayList(); 
		List<User> userList = new ArrayList(); 
		
		Sheet sheet = workBook.getSheet(sheetNo);

		if(sheetNo == 0) {	//第一张工作表（组织表）
			int row = sheet.getRows();
			for (int i = 1; i < row; i++) {
				Organization org = new Organization();
				Cell c1 = sheet.getCell(0, i);
				Cell c2 = sheet.getCell(1, i);
				Cell c3 = sheet.getCell(2, i);
				Cell c4 = sheet.getCell(3, i);
				Cell c5 = sheet.getCell(4, i);
				
				org.setParentShortName(c1.getContents());	//父组织编码
				org.setShortName(c2.getContents());			//组织编码
				org.setName(c3.getContents());				//名称
				org.setDescription(c4.getContents());		//描述
			    org.setManagerLoginName(c5.getContents());	//部门经理（登录名）
			    org.setParentId(parentId);			//父组织ID，右击目录树时获得
			    org.setSiteId(siteId);				//所在站点，右击目录树时获得
			    
			    orgList.add(org);
			    list = orgList;
			}
		}
		if(sheetNo == 1) {	//第二张工作表（用户表）
			int row = sheet.getRows();
			int col = sheet.getColumns();
			for (int i = 1; i < row; i++) {
				User user = new User();
				Cell c1 = sheet.getCell(0, i);
				Cell c2 = sheet.getCell(1, i);
				Cell c3 = sheet.getCell(2, i);
				Cell c4 = sheet.getCell(3, i);
				Cell c5 = sheet.getCell(4, i);
				Cell c6 = sheet.getCell(5, i);
				Cell c7 = sheet.getCell(6, i);
				Cell c8 = sheet.getCell(7, i);
				Cell c9 = sheet.getCell(8, i);
				Cell c10 = sheet.getCell(9, i);
				
				user.setShortName(StringUtils.trim(c1.getContents()));			//所属组织（编码）
				user.setLoginName(StringUtils.trim(c2.getContents()));			//登录名
				user.setPassword(StringUtils.trim(c3.getContents()));			//密码
				user.setFullName(StringUtils.trim(c4.getContents()));			//姓名
			    user.setNickName(StringUtils.trim(c5.getContents()));			//昵称
			    user.setEmail(StringUtils.trim(c6.getContents()));				//邮箱
			    user.setManagerLoginName(StringUtils.trim(c7.getContents()));	//上级领导（登录名）
			    user.setAdministrator("是".equals(StringUtils.trim(c8.getContents())));			//是否管理员
			    user.setStatus("有效".equals(StringUtils.trim(c9.getContents())) ? "A" : "L");	//使用状态
			    if(StringUtils.isNotBlank(StringUtils.trim(c10.getContents()))) {
				    if (c10 instanceof DateCell) {												//使用有效期
				    	DateCell dr = (DateCell) c10;
				    	user.setValidityDate(dr.getDate());
				    } else {
				    	user.setValidityDate(DateUtils.parse(StringUtils.trim(c10.getContents()), "yyyy-MM-dd"));	
				    }
			    }
			    user.setSiteId(siteId);															//所在站点，右击目录树时获得
//			    if (StringUtils.isNotBlank(userPropertyNames)) {								//获取扩展属性
			    	UserPropertyData userPropertyData = userPropertyDataService.getIdByLoginName(StringUtils.trim(c2.getContents()), siteId);
			    	if(userPropertyData == null) {
			    		userPropertyData = new UserPropertyData();
			    	}
				    String[] extProperties = StringUtils.split(userPropertyNames,",");
				    int j = 10;
				    for (String extP : extProperties) {
				    	UserProperties userProp = userPropertyList.get(j-10);
				    	String value = getPropertyOptionValue(userProp, StringUtils.trim(sheet.getCell(j,i).getContents()));
				    	BeanUtils.setProperty(userPropertyData, extP, value);
				    	j++;
				    }
				    user.setPropertyData(userPropertyData);
//			    }
			    
			    userList.add(user);
			    list = userList;
			}
			
		}
		return list;
	}


	/**
	 * 更新组织表信息
	 * @param orgList
	 * @return
	 */
	public Map updateOrganization(List<Organization> orgList) {
		int successCnt = 0;								// 成功更新记录数
		Map errOrgMap = new HashMap<Integer, String>();	// 错误的组织信息集合，Map<第N行，错误信息>
		if(ListUtils.isNotEmpty(orgList)) {
			// 1、导入组织表中的三列：组织编码、名称、描述，如果组织编码已经存在，则更新，否则则新增
			for(int i=0; i<orgList.size(); i++) {
				Organization orgNew = orgList.get(i);
				int importCode = 0;
				PagingResult<Organization> orgOldList = organizationService.findOrganization(Cnd.builder(Organization.class).andEQ("shortName", orgNew.getShortName()).andEQ("siteId", orgNew.getSiteId()).buildCriteria());
				if(ListUtils.isNotEmpty(orgOldList.getResult())) {
					Organization orgOld = orgOldList.getResult().get(0);
					orgOld.setShortName(orgNew.getShortName());
					orgOld.setName(orgNew.getName());
					orgOld.setDescription(orgNew.getDescription());
					orgOld.setSiteId(orgNew.getSiteId());
					orgOld.setParentId(orgNew.getParentId());
					importCode = organizationService.saveOrganization(orgOld, true);
				} else {
					importCode = organizationService.saveOrganization(orgNew, true);
				}
				if(importCode > 0) {	//导入成功
					successCnt++;
				} else {				//导入失败
					if(importCode == -1) {
						errOrgMap.put(i+1, "组织名称重复");
					} else if(importCode == -2) {
						errOrgMap.put(i+1, "组织编码重复");
					} else {
						errOrgMap.put(i+1, "其它错误");
					}
				}
			}
			// 2、以上三列导入完毕后，再将组织表的“父组织编码”更新到org_organization表中的parent_id字段
			String errOrgIds = "";					//为第3步准备
			List<Long> orgIds = new ArrayList();	//为第4步准备
			for(int i=0; i<orgList.size(); i++) {
				Organization orgNew = orgList.get(i);
				PagingResult<Organization> orgOldList = organizationService.findOrganization(Cnd.builder(Organization.class).andEQ("shortName", orgNew.getShortName()).andEQ("siteId", orgNew.getSiteId()).buildCriteria());
				if(ListUtils.isNotEmpty(orgOldList.getResult())) {
					Organization orgOld = orgOldList.getResult().get(0);
					if("root".equalsIgnoreCase(orgNew.getParentShortName())) {	//如果父组织为“root”，则保存到根节点
						orgOld.setParentId(orgNew.getParentId());
					} else {
						PagingResult<Organization> orgParentList = organizationService.findOrganization(Cnd.builder(Organization.class).andEQ("shortName", orgNew.getParentShortName()).andEQ("siteId", orgNew.getSiteId()).buildCriteria());
						if(ListUtils.isNotEmpty(orgParentList.getResult())) {	//如果父组织存在，获取父组织ID
							Organization orgParent = orgParentList.getResult().get(0);
							orgOld.setParentId(orgParent.getId());
						} else {												//如果父组织不存在，该记录将无法导入，需要在第3步删除第1步已经新增的记录
							if(!errOrgMap.containsKey(i+1)) {
								errOrgMap.put(i+1, "找不到父组织编码");
							}
							errOrgIds = errOrgIds + orgOld.getId() + ",";
							continue;
						}
					}
					organizationService.saveOrganization(orgOld, true);
					orgIds.add(orgOld.getId());
				}
			}
			// 3、删除掉第1步已经录入但第2步校验时找不到父组织的记录
			errOrgIds = deleteLastChar(errOrgIds);
			if(StringUtils.isNotBlank(errOrgIds))
				organizationService.deleteOrganizationByIds(StringUtils.splitTo(errOrgIds, ",", Long.class));
			
			// 4、以上执行完毕后，需要更新每个组织的下属组织数量，执行这步才能在菜单上正常显示层次
			for(Long orgId : orgIds) {
				organizationService.resetOrganizationCount(orgId);
				Organization organization = organizationService.getOrganization(orgId);
				organizationService.resetOrganizationHierarchy(organization);
			}
		}
		return errOrgMap;
	}
	
	
	/**
	 * 更新用户表信息
	 * @param userList
	 * @return
	 */
	public Map updateUser(List<User> userList, List<Organization> orgList) {
		int successCnt = 0;									// 成功更新记录数
		Map errUserMap = new HashMap<Integer, String>();	// 错误的用户信息集合，Map<第N行，错误信息>
		if(ListUtils.isNotEmpty(userList)) {
			// 1、导入用户表中的9列：所属组织（编码）、登录名、密码、姓名、昵称、邮箱、是否管理员、使用状态、使用有效期，如果登录名已经存在，则更新，否则则新增
			for(int i=0; i<userList.size(); i++) {
				User userNew = userList.get(i);
				Organization tmpOrg = getOrgByShortName(userNew.getShortName());
				if(null != tmpOrg) {
					PagingResult<User> userOldList = userService.findUser(Cnd.builder(User.class).andEQ("loginName", userNew.getLoginName()).andEQ("siteId", userNew.getSiteId()).buildCriteria());
					if(ListUtils.isNotEmpty(userOldList.getResult())) {	//如果用户已经存在，则执行修改；否则执行新增
						User userOld = userOldList.getResult().get(0);
						userOld.setOrganizationId(tmpOrg.getId());
						userOld.setLoginName(userNew.getLoginName());
						userOld.setPassword(userNew.getPassword());
						userOld.setFullName(userNew.getFullName());
						userOld.setNickName(userNew.getNickName());
						userOld.setEmail(userNew.getEmail());
						userOld.setAdministrator(userNew.getAdministrator());
						userOld.setStatus(userNew.getStatus());
						userOld.setValidityDate(userNew.getValidityDate());
						//用户属性
						UserPropertyData propertyData = userNew.getPropertyData();
						Long userId = propertyData.getUserId()==null ? userOld.getId() : propertyData.getUserId();
						propertyData.setUserId(userId);
						userOld.setPropertyData(propertyData);
						userService.saveUser(userOld);
					} else {
						userNew.setOrganizationId(tmpOrg.getId());
						userService.saveUser(userNew);
					}
					successCnt++;
				} else {
					errUserMap.put(i+1, "组织编码不存在");
				}
			}
			// 2、以上9列导入完毕后，再将用户表的“上级领导（登录名）”更新到org_user表中的manager_id字段
			for(User userNew : userList) {
				PagingResult<User> userOldList = userService.findUser(Cnd.builder(User.class).andEQ("loginName", userNew.getLoginName()).andEQ("siteId", userNew.getSiteId()).buildCriteria());
				if(ListUtils.isNotEmpty(userOldList.getResult())) {
					User userOld = userOldList.getResult().get(0);
					PagingResult<User> userManagerList = userService.findUser(Cnd.builder(User.class).andEQ("loginName", userNew.getManagerLoginName()).andEQ("siteId", userNew.getSiteId()).buildCriteria());
					if(ListUtils.isNotEmpty(userManagerList.getResult())) {
						User userManager = userManagerList.getResult().get(0);
						userOld.setManagerId(userManager.getId());
						userService.saveUser(userOld);
					}
				}
			}
			// 3、以上两步更新完用户表后，再更新组织表中“部门经理”字段
			for(Organization orgNew : orgList) {
				PagingResult<Organization> orgOldList = organizationService.findOrganization(Cnd.builder(Organization.class).andEQ("shortName", orgNew.getShortName()).andEQ("siteId", orgNew.getSiteId()).buildCriteria());
				if(ListUtils.isNotEmpty(orgOldList.getResult())) {
					Organization orgOld = orgOldList.getResult().get(0);
					PagingResult<User> managerList = userService.findUser(Cnd.builder(User.class).andEQ("loginName", orgNew.getManagerLoginName()).andEQ("siteId", orgNew.getSiteId()).buildCriteria());
					if(ListUtils.isNotEmpty(managerList.getResult())) {
						User manager = managerList.getResult().get(0);
						orgOld.setManagerId(manager.getId());
						organizationService.saveOrganization(orgOld);
					}
				}
			}
		}
		return errUserMap;
	}
	
	
	/**
	 * 根据组织编码，获取组织对象
	 * @param shortName
	 * @return
	 */
	public Organization getOrgByShortName(String shortName) {
		if(StringUtils.isNotEmpty(shortName)) {
			List<Organization> orgList = organizationService.findOrganization(Cnd.builder(Organization.class).andEQ("shortName", shortName).andEQ("siteId", siteId).buildCriteria()).getResult();
			if(ListUtils.isNotEmpty(orgList)) {
				return orgList.get(0);
			}
		}
		return null;
	}
	
	
	/**
	 * 查询某个站点下的用户属性
	 * @param siteId
	 * @param propertyName
	 * @return
	 */
	private UserProperties getUserProperty(Long siteId, String propertyName) {
		List<UserProperties> propertyList = userPropertiesService.findUserProperties(Cnd.builder(UserProperties.class).andEQ("siteId", siteId).andEQ("name", propertyName).buildCriteria()).getResult();
		if(ListUtils.isNotEmpty(propertyList)){
			return propertyList.get(0);
		}
		return null;
	}
	
	
	/**
	 * 根据用户属性、单元格的值,返回org_user_property_data对应的值
	 * @param userProp
	 * @param cellValue
	 * @return
	 */
	private String getPropertyOptionValue(UserProperties userProp, String cellValue) {
		String type = userProp.getType();
		if("T".equals(type) || "A".equals(type) || "D".equals(type)) {	//文本框、文本域、日期框返回原值	
			return cellValue;
		} else if("S".equals(type) || "R".equals(type)) {	//下拉框、单选框返回对应的选项ID值
			List<UserPropertyOption> optionList = userPropertyOptionService.findUserPropertyOption(Cnd.builder(UserPropertyOption.class).andEQ("propertyId", userProp.getId()).andEQ("name", cellValue).buildCriteria()).getResult();
			if(ListUtils.isNotEmpty(optionList)) {
				UserPropertyOption option = optionList.get(0);
				return option.getId().toString();
			}
		} else if("C".equals(type)) {	//复选框，多个ID值拼接，如：555,556,557
			String[] cellValueArr = cellValue.split(",");
			String checkBoxIds = "";
			for(String checkBoxValue : cellValueArr) {
				List<UserPropertyOption> optionList = userPropertyOptionService.findUserPropertyOption(Cnd.builder(UserPropertyOption.class).andEQ("propertyId", userProp.getId()).andEQ("name", checkBoxValue).buildCriteria()).getResult();
				if(ListUtils.isNotEmpty(optionList)) {
					UserPropertyOption option = optionList.get(0);
					checkBoxIds = checkBoxIds + option.getId() + ",";
				}
			}
			return deleteLastChar(checkBoxIds);
		} else if("U".equals(type)) {	//用户框
			
		}
		return "";
	}

	
	/**
	 * 剔除最后一个“,”字符，如传入“aaa,bbb,ccc,”则返回“aaa,bbb,ccc”
	 * @param str
	 * @return
	 */
	public static String deleteLastChar(String str) {
		if(StringUtils.isNotEmpty(str) && StringUtils.substring(str, str.length()-1).equals(",")) {
			return str.substring(0, str.length()-1);
		} else {
			return str;
		}
	}
	
	
	/**
	 * 抓取数组中存在重复的值，如传入“aaa,bbb,ccc,aaa”，将返回“aaa”
	 * @param strArr
	 * @return
	 */
	public static String findSameString(String str) {
		String sameStr = "";
		if(StringUtils.isNotEmpty(str)) {
			String[] strArr = str.split(",");
			String lastStr = str;
			for(String preStr : strArr) {
				if(lastStr.indexOf(",") != -1) 
					lastStr = lastStr.substring(lastStr.indexOf(",")+1);
				else
					lastStr = "";
				for(String allStr : lastStr.split(",")) {
					if(preStr.equalsIgnoreCase(allStr)) {
						sameStr = sameStr + preStr + ",";
						break;
					}
				}
				
			}
		}
		return deleteLastChar(sameStr);
	}
	

	public File getImportFile() {
		return importFile;
	}

	public void setImportFile(File importFile) {
		this.importFile = importFile;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getUserPropertyNames() {
		return userPropertyNames;
	}

	public void setUserPropertyNames(String userPropertyNames) {
		this.userPropertyNames = userPropertyNames;
	}

	public List<UserProperties> getUserPropertyList() {
		return userPropertyList;
	}

	public void setUserPropertyList(List<UserProperties> userPropertyList) {
		this.userPropertyList = userPropertyList;
	}
	
}