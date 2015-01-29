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
package com.kingnod.etraining.course.server.models;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import com.kingnod.etraining.course.parsexmlutil.XMLDocument;



/**
 * This class is responsible for creating the xml file which persists the current state of the package
 * 
 * @author Paul Sharples
 * @version $Id: SequencerModel.java,v 1.3 2007/07/15 20:28:49 phillipus Exp $
 */
public class SequencerModel extends XMLDocument {

    public static final String ROOT_NODE_NAME = "navigation";
    public static final String ORG_NODE = "organization";
    public static final String ITEM_NODE = "item";
    public static final String ITEM_IDENTIFIER = "id";
    public static final String ITEM_NOT_ATTEMPTED = "not attempted";
    public static final String ITEM_COMPLETED = "completed";
    public static final String ITEM_INCOMPLETE = "incomplete";
    public static final String ITEM_PASSED = "passed";
    public static final String ITEM_FAILED = "failed";
    public static final String MANIFEST_MODIFIED = "manifest_last_modified";
    
    /**
     *  A vector used to house which items have been added to the navigation
     *  - used to determine which nodes have been deleted since last import
     */
    Vector _items = new Vector();
        

    

    public void setDefaultOrg(String orgName){
        getDocument().getRootElement().setAttribute("default", orgName);
    }
    
    public String getDefaultOrg(){
        return getDocument().getRootElement().getAttributeValue("default");
    }

    public void setManifestModifiedDate(long lastModified){
        Element root = getDocument().getRootElement();
        if (root.getChild(MANIFEST_MODIFIED)==null){
            Element time = new Element(MANIFEST_MODIFIED);
            time.setText(Long.toString(lastModified));
            root.addContent(time);
        }
        else{
            root.getChild(MANIFEST_MODIFIED).setText(Long.toString(lastModified));
        }
    }
    
    public String getManifestModifiedDate(){
        return getDocument().getRootElement().getChild(MANIFEST_MODIFIED).getText();
    }
    
    /**
     * Method to return all of the items found during a parse of the manifest
     * @return
     */
    protected String[] getItems(){
        String[] legitimateIds = new String[_items.size()];
	    _items.copyInto(legitimateIds);	    
	    return legitimateIds;
    }
    
  
    
    /**
     * Method to get all item identifiers under a given organization
     * @param org
     * @return - has table with idenitifer and current status
     */
    public Hashtable getItemsAsHash(String org){
        Hashtable hash = new Hashtable();
        List itemList = getDocument().getRootElement().getChildren(ITEM_NODE);
        Iterator itemListElement = itemList.iterator();
		while (itemListElement.hasNext()) {
		    Element anItem = (Element) itemListElement.next();
		    if(anItem.getAttributeValue(ORG_NODE).equals(org)){
		        hash.put(anItem.getAttributeValue(ITEM_IDENTIFIER), anItem.getText());
		    }
		}
		if (!hash.isEmpty()){
		    return hash;
		}
		else {
		    return null;
		}
    }
 
    /**
     * Method to add a new item (or update an existing item) to the
     * navigation file - used to persist package status
     * @param itemId
     * @param orgId
     * @param value
     */
    public void addTrackedItem(String itemId, String orgId, String value){                        
        boolean itemFound = false;
        
        // check to see if the item is there already, if so reset it
        List itemList = getDocument().getRootElement().getChildren(ITEM_NODE);
        if (itemList !=null && !itemList.isEmpty()){
            Iterator itemListElement = itemList.iterator();
    		while (itemListElement.hasNext()) {
    		    Element anItem = (Element) itemListElement.next();			
    			if(anItem.getAttributeValue(ITEM_IDENTIFIER).equals(itemId)){
    			    anItem.setText(value);
    			    _items.add(itemId);
    			    itemFound = true;
    			}
    		}
        }
        // otherwise add it as a new node.
        if (itemFound == false) {
            Element node = new Element (ITEM_NODE);
            node.setText(value);        
            node.setAttribute(ITEM_IDENTIFIER, itemId);
            node.setAttribute(ORG_NODE, orgId);
            getDocument().getRootElement().addContent(node);
            _items.add(itemId);            
        }
             
    }

    
 
 
    /**
     * Utility method which takes a string(item) and a string array
     * The method searches the string array for the value in item,
     * if it exists returns true, otherwise false.
     * @param item
     * @param legitimateItems
     * @return
     */
    protected boolean doesItemExist(String item, String[] legitimateItems){           
        for (int i=0; i<legitimateItems.length;i++){
            if(legitimateItems[i].equals(item)){
                return true;
            }
        }
        return false;
    }
}
