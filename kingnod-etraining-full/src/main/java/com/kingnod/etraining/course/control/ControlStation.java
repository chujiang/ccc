package com.kingnod.etraining.course.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;

import com.kingnod.etraining.course.contentpackage.CP_Core;
import com.kingnod.etraining.course.exception.DocumentHandlerException;
import com.kingnod.etraining.course.exception.NoItemFoundException;
import com.kingnod.etraining.course.exception.SchemaValidationException;
import com.kingnod.etraining.course.parsescorm.SchemaValidator;
import com.kingnod.etraining.course.parsescorm.ScormPackageHandler;
import com.kingnod.etraining.course.utils.ZipUtils;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class ControlStation implements IControlStation {
	
	  protected static Logger log = LoggerFactory.getLogger(ControlStation.class);
    protected static ControlStation _sharedInstance;    
    public static final String HTTP_PROTOCOL = "http://";
 
    private ControlStation(){}
 
    public static ControlStation getSharedInstance() {
	    if(_sharedInstance == null) _sharedInstance = new ControlStation();
	    return _sharedInstance;
	}
    
	public boolean isValidManifest(File file,File unZipPath) throws IOException, JDOMException, DocumentHandlerException {
		File manifestFile = null;
	    
	    if(isZip(file)) {
			// need to grab the manifest out of the zip file
	        File tempFile = File.createTempFile("~rld-", ".xml");
	        // Make sure we delete it on exit
	        tempFile.deleteOnExit();
	        manifestFile = findManifest(file, tempFile);
	        if(manifestFile == null) return false;
		}
		else {
		    manifestFile = file;
		}
	    ScormPackageHandler handler = null;
		try {
			handler = new ScormPackageHandler(manifestFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return handler.isSCORM12Manifest();
	}
	
	public boolean parseManifest(File zipFile,File man,String folder,Long folderId,Long contentServerId) throws NoItemFoundException, JDOMException, IOException {
	    ScormPackageHandler handler = new ScormPackageHandler(man);
		return handler.buildSettings(zipFile,folder,folderId,contentServerId);		
	}	
	
	public void setupValidateAgainstSchema(String schemaName,
            File manifest, String validationPath) throws Exception {
		
        File SOURCE_SCHEMA_FOLDER = new File(validationPath);
        validatePackageAgainstSchema("ims_xml.xsd", SOURCE_SCHEMA_FOLDER,manifest);

    }
	
	public void validatePackageAgainstSchema(String schemaName, File destinationFolder, File manifest)
							throws SchemaValidationException, IOException, SAXException, ParserConfigurationException {
//		replaceSchema(schemaName, destinationFolder, sourceFolder);
		SchemaValidator validator = new SchemaValidator(manifest);
		validator.validate(new File(destinationFolder,schemaName));
		if (validator.hasErrors()){
			String allMessages = "";
			String[] messages = validator.getErrorMessages();
			for(int i = 0; i < messages.length; i++){
				allMessages += messages[i] + System.getProperty("line.separator");
			}
			throw new SchemaValidationException(allMessages);
		}
	}	
	
	public boolean isZip(File aFile) {
		if (aFile.getName().toLowerCase().endsWith(ScormPackageHandler.ARCHIVE_EXTENSION))
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check if imsmanifest.xml file exists in a zip file.
	 * @param zipFile
	 * @returns the file if found, null if not found
	 */
	public File findManifest(File zipFile, File tempFile) throws FileNotFoundException, IOException {
		return ZipUtils.extractZipEntry(zipFile, CP_Core.MANIFEST_NAME, tempFile);
	}
	
	/**
	 * Calls ZipUtils() Unzips an archive into a specified folder
	 * @param file
	 * @param destinationFolder
	 * @param mon
	 * @return true or false if successful
	 */
	public void unpackZip(File file, File destinationFolder) throws IOException {	    
		ZipUtils.unpackZip(file, destinationFolder);
	}
	



		
	/**
	 * Method to launch a scorm package
	 * @param thePackage - which package to launch
	 */
//	public void startPackage(String thePackage) {	    
//	    NativeLauncher.launchURL(getLaunchURL(thePackage));
//	}
	
	  
// 
//	public void resetPackage(File path) throws NoItemFoundException, JDOMException, IOException {	
//			File man = new File(path, CP_Core.MANIFEST_NAME);
//			ScormPackageHandler handler = new ScormPackageHandler(man);
//			handler.buildSettings(path);	
//	}

}