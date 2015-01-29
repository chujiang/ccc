package com.kingnod.etraining.course.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.JDOMException;

import com.kingnod.etraining.course.exception.DocumentHandlerException;
import com.kingnod.etraining.course.exception.NoItemFoundException;

/**
 * Interface for methods that a ControlStation must implement.
 * These methods are concerned with handling a content package.
 * 
 * @author Paul Sharples
 * @version $Id: IControlStation.java,v 1.3 2007/07/15 20:28:49 phillipus Exp $
 */
public interface IControlStation {
    
    /**
     * check for valid manifest
     * @throws IOException 
     * @throws JDOMException 
     * @throws DocumentHandlerException 
     */
    public boolean isValidManifest(File file,File unZipFile) throws IOException, JDOMException, DocumentHandlerException;

    /**
     * parse the manifest - load the content into something - ie JDOM
     * @param man
     * @return 
     * @throws NoItemFoundException
     * @throws JDOMException
     * @throws IOException
     */
    public boolean parseManifest(File zipFile,File man,String folder,Long folderId,Long contentServerId) throws NoItemFoundException, JDOMException, IOException ;
    
    /**
     * check if a file ref is a zip
     * @param aFile
     * @return
     */
    public boolean isZip(File aFile);
}
