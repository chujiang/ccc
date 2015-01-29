package com.kingnod.etraining.organization.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.export.util.Exporters;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserProperties;
import com.kingnod.etraining.organization.entity.UserPropertyData;
import com.kingnod.etraining.organization.entity.UserPropertyOption;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserPropertiesService;
import com.kingnod.etraining.organization.service.UserPropertyOptionService;
import com.kingnod.etraining.organization.service.UserService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "site-option", "namespace", "/org"}),
@Result(name = "exportPage", location = "/WEB-INF/content/org/org-user-export.jsp", params = { "actionName", "org-user-export", "namespace", "/org", "siteId", "${siteId}", "parentId", "${parentId}"})
}
)

public class OrgUserExportAction extends FilterableEntityAction<Site, Long> {

    @Autowired
    private SiteService siteService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserPropertiesService userPropertiesService;
    @Autowired
    private UserPropertyOptionService userPropertyOptionService;
    

    private Long siteId;		//站点ID
    private Long parentId;		//父节点ID
    
    
    public String filterDefines() {
        return "org.siteFilterItems";
    }
    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    protected Object getEntityService() {
        return this.siteService;
    }
    
    
    public void export() throws Throwable{
    	// 1.获取组织列表
    	List<Organization> orgList = organizationService.getOrganizationsForExport(siteId);
    	
    	// 2.获取用户列表
    	List<User> userList = userService.getUsersForExport(siteId);
    	
    	// 3.获取用户扩展属性列表
    	List<UserProperties> propertyList = userPropertiesService.findListBySiteId(siteId);
    	
    	// 4.将组织用户信息写入excel表
    	if(ListUtils.isNotEmpty(orgList) || ListUtils.sizeIsEmpty(userList)) {
    		toExcel(orgList, userList, propertyList);
    	}
    	
    	// 5.下载
    	download();
    }
    
    
    /**
     * 写入excel文件
     * @param orgList
     * @param userList
     * @return
     * @throws Exception 
     * @throws  
     */
	private String toExcel(List<Organization> orgList, List<User> userList, List<UserProperties> propertyList) throws Exception {
		InputStream templateFile = null;
		String exportFile = SysParameterUtils.getString("sys.export_temp_path") + "/orgUserExport.xls"; // 准备写入数据的文件
		Workbook tempWorkbook = null;
		WritableWorkbook wwb = null;
		try {
			templateFile = Exporters.class.getClassLoader().getResourceAsStream("template/orgUserExportTemplate.xls"); // 模板文件
			if (null != templateFile) {
				tempWorkbook = Workbook.getWorkbook(templateFile);
				wwb = Workbook.createWorkbook(new File(exportFile), tempWorkbook);

				// ********************写第一张表（组织表）********************
				WritableSheet sheet1 = wwb.getSheet(0);
				for (int i = 0; i < orgList.size(); i++) {
					Organization org = orgList.get(i);
					int rowNum = i + 1;
					Label c1 = new Label(0, rowNum, StringUtils.isBlank(org.getParentShortName()) ? "root" : org.getParentShortName());
					sheet1.addCell(c1);
					Label c2 = new Label(1, rowNum, org.getShortName());
					sheet1.addCell(c2);
					Label c3 = new Label(2, rowNum, org.getName());
					sheet1.addCell(c3);
					Label c4 = new Label(3, rowNum, org.getDescription());
					sheet1.addCell(c4);
					Label c5 = new Label(4, rowNum, org.getManagerLoginName());
					sheet1.addCell(c5);
				}

				// ********************写第二张表（用户表）********************
				WritableSheet sheet2 = wwb.getSheet(1);
				// 写用户表扩展属性列头
				for (int i = 0; propertyList != null && i < propertyList.size(); i++) {
					UserProperties userProperties = propertyList.get(i);
					Label extTitle = new Label(10 + i, 0, userProperties.getName());
					sheet2.addCell(extTitle);
				}
				// 写用户信息
				for (int i = 0; i < userList.size(); i++) {
					User user = userList.get(i);
					int rowNum = i + 1;
					Label c1 = new Label(0, rowNum, user.getShortName());
					sheet2.addCell(c1);
					Label c2 = new Label(1, rowNum, user.getLoginName());
					sheet2.addCell(c2);
					Label c3 = new Label(2, rowNum, user.getPassword());
					sheet2.addCell(c3);
					Label c4 = new Label(3, rowNum, user.getFullName());
					sheet2.addCell(c4);
					Label c5 = new Label(4, rowNum, user.getNickName());
					sheet2.addCell(c5);
					Label c6 = new Label(5, rowNum, user.getEmail());
					sheet2.addCell(c6);
					Label c7 = new Label(6, rowNum, user.getManagerLoginName());
					sheet2.addCell(c7);
					Label c8 = new Label(7, rowNum, user.getAdministrator() == true ? "是" : "否");
					sheet2.addCell(c8);
					Label c9 = new Label(8, rowNum, "A".equalsIgnoreCase(user.getStatus()) ? "有效" : "锁定");
					sheet2.addCell(c9);
					Label c10 = new Label(9, rowNum, DateUtils.format(user.getValidityDate(), "yyyy-MM-dd") + "");
					sheet2.addCell(c10);

					UserPropertyData propertyData = user.getPropertyData(); // 用户对象中包含的子对象：用户属性对象
					for (int j = 0; propertyList != null && j < propertyList.size(); j++) {
						UserProperties userProperties = propertyList.get(j);
						String propertyName = userProperties.getPropertyName(); // 属性对应的字段名
						String propertyValue = BeanUtils.getProperty(propertyData, propertyName); // 属性对应的字段值
						if (StringUtils.isNotBlank(propertyValue)) {
							String type = userProperties.getType(); // 属性类型
							if ("T".equals(type) || "A".equals(type) || "D".equals(type)) { // 1.文本框、文本域、日期框，导出原值

							} else if ("S".equals(type) || "R".equals(type)) { // 2.下拉框、单选框，根据ID获取文本值
								UserPropertyOption option = userPropertyOptionService.getUserPropertyOption(NumberUtils.toLong(propertyValue));
								if (null != option)
									propertyValue = option.getName();
							} else if ("C".equals(type)) { // 3.复选框，根据ID获取多个值，并用逗号隔开
								String checkBoxValue = "";
								for (String id : propertyValue.split(",")) {
									UserPropertyOption option = userPropertyOptionService.getUserPropertyOption(NumberUtils.toLong(id));
									if (null != option)
										checkBoxValue = checkBoxValue + option.getName() + ",";
								}
								propertyValue = OrgUserImportAction.deleteLastChar(checkBoxValue);
							} else if ("C".equals(type)) { // 4.用户，根据ID去org_user表取出登录名
								User tmpUser = userService.getUser(NumberUtils.toLong(propertyValue));
								if (null != tmpUser)
									propertyValue = tmpUser.getLoginName();
							}
							Label tmpCell = new Label(10 + j, rowNum, propertyValue);
							sheet2.addCell(tmpCell);
						}
					}
				}

				wwb.write();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (null != wwb)
				wwb.close();
			if (null != tempWorkbook)
				tempWorkbook.close();
			if (null != templateFile){
				templateFile.close();
			}
		}

		return null;
	}
    
    /**
     * 下载
     */
	public void download() {
		FileInputStream in = null;
		try {
			// 获得响应客户的输出流：
			OutputStream o = response.getOutputStream();
			// 输出文件用的字节数组,每次发送500个字节到输出流：
			byte b[] = new byte[500];
			// 下载的文件：
			String path = SysParameterUtils.getString("sys.export_temp_path");
			File fileLoad = new File(path, "orgUserExport.xls");
			// 客户使用保存文件的对话框：
			Site site = siteService.getSite(siteId);
			response.setHeader("Content-disposition", "attachment;filename="
					+ URLEncoder.encode(site.getName() + "组织用户信息",StringUtils.ENCODING_UTF8) + "_" + DateUtils.currentDate("yyyy-MM-dd") + ".xls");
			// 通知客户文件的MIME类型：
			response.setContentType("application/vnd.ms-excel");
			// 通知客户文件的长度：
			long fileLength = fileLoad.length();
			String length = String.valueOf(fileLength);
			response.setHeader("Content_Length", length);
			// 读取文件book.zip,并发送给客户下载:
			in = new FileInputStream(fileLoad);
			int n = 0;
			while ((n = in.read(b)) != -1) {
				o.write(b, 0, n);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			try{if(null != in){in.close();}}catch(Exception e){}finally{in = null;}
		}
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
    
}