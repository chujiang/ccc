package com.kingnod.etraining.course.contentpackage;

import com.kingnod.etraining.course.parsexmlutil.XMLDocument;

/**
 * Core ADL SCORM 1.2 Content Package Methods and Functionality
 *
 * @author Phillip Beauvoir
 * @version $Id: SCORM12_Core.java,v 1.3 2007/07/15 20:29:50 phillipus Exp $
 */
public class SCORM12_Core
extends CP_Core
{
    // Element and Attribute Names
    public static final String LOCATION = "location";
    public static final String PREREQUISITES = "prerequisites";
    public static final String MAXTIMEALLOWED = "maxtimeallowed";
    public static final String TIMELIMITACTION = "timelimitaction";
    public static final String DATAFROMLMS = "datafromlms";
    public static final String MASTERYSCORE = "masteryscore";
    public static final String SCORMTYPE = "scormtype";
    public static final String SCO = "sco";
    public static final String ASSET = "asset";

    public SCORM12_Core(XMLDocument doc) {
        super(doc);
    }

}