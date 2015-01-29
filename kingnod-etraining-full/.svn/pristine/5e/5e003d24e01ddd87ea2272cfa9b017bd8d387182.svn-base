package com.kingnod.etraining.common.ui.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.io.IOUtils;

/**
 * 主要应用于引入公共资源 测试 存在缓存问题，改变文件内容时依然读缓存内容
 * 
 * @author maxudong   
 */

public class ResourceReferenceServlet extends HttpServlet {
 
	private static final long serialVersionUID = -4072642718929498589L;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * debug为true时，使用物理路径进行读取文件
	 */
	private  static final String RESOURCE_DIR ="/WEB-INF/classes/" ;

	/**
	 * 调试模式为true时，表示使用ServletContext.getRealPath()取得物理绝对路径来读取文件，开发时可用此模式。
	 * 注意：如果使用war包并且不解压的方式进行布署文件则不能使用true，否则会找不到文件
	 */
	protected Boolean debug = false;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.debug = StringUtils.isTrue(config.getInitParameter("debug"));
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (logger.isDebugEnabled())
			logger.debug("*****  ResourceReferenceServlet  begin  ***************");

		String servletPath = request.getServletPath().replace("resource", "page");
		String pathInfo = request.getPathInfo(); 

		// 主要用于路径提取文件信息
		if (pathInfo.indexOf(".") == -1) { 
			pathInfo = pathInfo + "." + servletPath.substring(servletPath.lastIndexOf("/") + 1);
		}
 
		outputResourseFile(request, response, servletPath + pathInfo);
		
		if (logger.isDebugEnabled())
			logger.debug("*****  ResourceReferenceServlet  end  ***************");

	}

	/**
	 * 根据解析完的文件路径，读取文件并输出文件到响应流中
	 * 
	 * @param response
	 * @param outoutFile 资源路径
	 */
	@SuppressWarnings("deprecation")
	protected void outputResourseFile(HttpServletRequest request, HttpServletResponse response, String outoutFile) {
		if (logger.isDebugEnabled())
			logger.debug(String.format("Current Resource Path:%s", outoutFile));
		
		InputStream in = null;
		OutputStream out = null;  

		try {
			// 设置文件头及缓存信息
			response.setContentType("application/x-javascript; charset=UTF-8");
			response.addHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Expires", "0");
 
			//如果debug为false时，从类资源路径读取文件，否则使用物理绝对路径进行读取
			if ( debug ) { 
				String path = request.getRealPath(RESOURCE_DIR+ outoutFile);  
				in = IOUtils.fileIn(new File(path));
			} else {
				if(!StringUtils.isEmpty(outoutFile) && outoutFile.startsWith("/")){
					outoutFile = outoutFile.substring(1);
				}
				in = ResourceReferenceServlet.class.getClassLoader().getResourceAsStream(outoutFile);
			}				 
			out = response.getOutputStream(); 
			IOUtils.bufferedCopy(in, out);	

		} catch (Exception e) { 
			logger.error("*****  ResourceReferenceServlet  getResources error :"+ e.getMessage());
			response.reset();
		} finally {
			 IOUtils.close(in,out);
		}

	}

}
