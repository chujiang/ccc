package com.kingnod.etraining.report.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.etraining.report.RepotConstant;
import com.lowagie.text.pdf.BaseFont;

public class HtmlToPdfReport {

	/**
	 * 
	 * @param htmlUrl
	 *            html文件
	 * @param pdfUrl
	 *            生成pdf路径
	 */
	public void htmlToPdf(String htmlUrl, String pdfUrl) {
//		String fmt = SysParameterUtils.getString("sys.date_format");
//		String dateString = DateUtils.format(new Date(), fmt);
		try {
			// String urlhtml = new File(htmlUrl).toURI().toURL().toString();
			URL url = new URL(htmlUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			ByteArrayOutputStream tidyOut = new ByteArrayOutputStream();

//			String urlpdf = new File(pdfUrl).toURI().toURL().toURI().toString();
			String urlpdf = SysParameterUtils.getString("sys.attachment_location");
			OutputStream os = new FileOutputStream(urlpdf+"/"+pdfUrl);
			ITextRenderer renderer = new ITextRenderer();
			ITextFontResolver fontResolver = renderer.getFontResolver();
			fontResolver.addFont(RepotConstant.FONT_STYE_ZH, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			renderer.setDocumentFromString(htmlSrc(htmlUrl));
			renderer.getSharedContext().setBaseURL("file:/d:/etraining/files/");
			renderer.layout();
			renderer.createPDF(os);
			tidyOut.close();
			os.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			// throw Exceptions.createAppException("222");
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return 获得页面源代码
	 */
	public String htmlSrc(String url) {
		String content = "";
		StringBuffer resultBuffer = new StringBuffer(); 
		try {
			HttpClient httpclient = new DefaultHttpClient();

			// Prepare a request object
			HttpGet httpget = new HttpGet(url);

			// Execute the request
			HttpResponse response = httpclient.execute(httpget);

			// Examine the response status
			System.out.println(response.getStatusLine());

			// Get hold of the response entity
			HttpEntity entity = response.getEntity();

			// If the response does not enclose an entity, there is no need
			// to worry about connection release
			if (entity != null) {
				InputStream instream = entity.getContent();
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
					 String inputLine = null; 
					while ((inputLine = reader.readLine()) != null) {  
		                resultBuffer.append(inputLine);  
		            }  
				} catch (IOException ex) {
					throw ex;
				} catch (RuntimeException ex) {
					httpget.abort();
					throw ex;

				} finally {

					// Closing the input stream will trigger connection release
					instream.close();

				}

				// When HttpClient instance is no longer needed,
				// shut down the connection manager to ensure
				// immediate deallocation of all system resources
				//httpclient.getConnectionManager().shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBuffer.toString();

	}
	
	

}
