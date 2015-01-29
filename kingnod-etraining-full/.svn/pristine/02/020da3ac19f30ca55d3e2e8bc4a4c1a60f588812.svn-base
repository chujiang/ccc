/**
 *  RELOAD TOOLS
 *
 *  Copyright (c) 2003 Oleg Liber, Bill Olivier, Phillip Beauvoir, Paul Sharples
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *  Project Management Contact:
 *
 *  Oleg Liber
 *  Bolton University
 *  Deane Road
 *  Bolton BL3 5AB
 *  UK
 *
 *  e-mail:   o.liber@bolton.ac.uk
 *
 *
 *  Technical Contact:
 *
 *  Phillip Beauvoir
 *  e-mail:   p.beauvoir@dadabeatnik.com
 *
 *  Paul Sharples
 *  e-mail:   p.sharples@bolton.ac.uk
 *
 *  Web:      http://www.reload.ac.uk
 *
 */

package com.kingnod.etraining.course.parsescorm;

import java.util.Vector;

import org.jdom.Element;
import org.jdom.Namespace;

import com.kingnod.etraining.course.contentpackage.SCORM12_Core;
import com.kingnod.etraining.course.parsexmlutil.XMLDocument;
import com.kingnod.etraining.course.server.models.SequencerModel;

/**
 * A class used to interrogate the manifest.  
 * Used to show the tree in the organizations panel and
 * to figure out which items are scos/assets
 * @author Paul Sharples
 * @version $Id: NavigationViewer.java,v 1.3 2007/07/15 20:28:49 phillipus Exp $
 */
public class NavigationViewer extends XMLDocument {
    
    
    public static final String NONE = "none";
    
    /**
     * Our instance of core scorm methods 
     */
    protected SCORM12_Core _scormCore;

    /**
     * An instance of the disk version of the sequencer model.
     */
    protected SequencerModel _sequencerModel;
    
    /**
     * Accessor method to return the scomrCore instance.
     * @return
     */
    public SCORM12_Core getScormCore(){
        return _scormCore;
    }
    
 
    /**
     * A method to get the default organization identifer (string) from the manifest file
     * @return
     */
    public String getDefaultOrg(){
        String defOrg = _sequencerModel.getDefaultOrg();       
        if (defOrg!=null){
            return defOrg;
        }
        else {
            return "";        
        }       
    }

    /**
     * REturn the default organization element
     * @param organizationsNode
     * @return
     */
    public Element getDefaultOrgElement(Element organizationsNode){
        return _scormCore.getElementByIdentifier(organizationsNode, getDefaultOrg());
    }
    
    
    /**
     * Method to ascertain which organization is the default, by index
     * @param index
     * @return
     */
    public boolean getDefaultOrgByIndex(int index){
        String theDefaultOrg = getDefaultOrg();
        Element[] orgs = getOrganizationList();
            if (orgs[index].getAttributeValue(SCORM12_Core.IDENTIFIER).equals(theDefaultOrg)){
              return true;
            }
        return false;
    }

    
    /**
     * Wrapper method - to see if an element references another element
     * @param element
     * @return
     */
    public boolean isReferencingElement(Element element){
        return _scormCore.isReferencingElement(element);
    }
    
    /**
     * Method to ascertain if an item is a sco, asset or does not
     * have a referenced resource
     * @param element
     * @return
     */
    public String findScoType(Element element){
        if (element.getName() == SCORM12_Core.ITEM){
            if (!isReferencingElement(element)){
                return NONE;
            }
            else {
                Element referencedElement = _scormCore.getReferencedElement(element);
                // does this reference a resource or submanifest
                if(referencedElement.getName().equals(SCORM12_Core.MANIFEST)){
                    return SCORM12_Core.MANIFEST;
                }
                String scoType = referencedElement.getAttributeValue(SCORM12_Core.SCORMTYPE, SCORM12_DocumentHandler.ADLCP_NAMESPACE_12);                
                if (scoType != null) {                    
                    return scoType;
                }
                else {
                    return SCORM12_Core.ASSET;
                }
            }                                               
        }
        return NONE;
    }

    /**
     * Wrapper method
     * @param element
     * @param attribute
     * @param ns
     * @return
     */
    public String getNamedAttributeFromElement(Element element, String attribute, Namespace ns){
        return element.getAttributeValue(attribute, ns);        
    }
    
    /**
     * Return the title of the element
     * @param element
     * @return
     */
    public String getTitleOfElement(Element element){
        if (element.getName().equals(SCORM12_Core.ORGANIZATION) || element.getName().equals(SCORM12_Core.ITEM)) {
            Element titleElement = element.getChild(SCORM12_Core.TITLE, getRootElement().getNamespace());
            if (titleElement != null){
                return titleElement.getText();
            }
        }
        return null;
    }
    
    /**
     * A method to get an array of all the organization elements in the
     * navigation file.
     * @return an array of <org> elements
     */
    public Element[] getOrganizationList() {
        // need to work on a copy here...
        Element manifestRoot = (Element)getRootElement().clone();
        Element orgsNode = manifestRoot.getChild(SCORM12_Core.ORGANIZATIONS, getRootElement().getNamespace());       
        return _scormCore.getOrganizations(orgsNode);
    }



 
    /**
     * Return the prerequisite string
     * @param element
     * @return
     */
    public String getPrerequisites(Element element){               
        if(element != null && isDocumentNamespace(element)) {
			// SCORM <prerequisite> elements
			Element prereq = element.getChild(SCORM12_Core.PREREQUISITES, SCORM12_DocumentHandler.ADLCP_NAMESPACE_12);
			if(prereq != null) {
				String script = prereq.getText();
				if(script != null && !script.equals("")) {
					return script;
				}    
			}
        }
        return null;
    }
    
  
  
    /**
     * Method to return all of the identifiers for scos found in a package
     */
    public String[] getAllScoIdentifiers(){       
        Vector v = new Vector();
        Element[] element = _scormCore.getElementsInManifest(this.getRootElement(), SCORM12_Core.ITEM, getRootElement().getNamespace());
        for(int i=0;i<element.length;i++){
            if (findScoType(element[i]).equals(SCORM12_Core.SCO)){                
                v.add(element[i].getAttributeValue(SCORM12_Core.IDENTIFIER));
            }
        }
        String[] ids = new String[v.size()];
        v.copyInto(ids);
        return ids;
    }
    
}