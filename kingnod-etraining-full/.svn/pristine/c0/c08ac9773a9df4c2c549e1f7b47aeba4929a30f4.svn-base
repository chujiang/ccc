package com.kingnod.etraining.course.parsexmlutil;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;

public class XMLPath {
 
    public static String XMLPATHSEPARATOR = "/";

    public static String XMLATTSEPARATOR = "@";

    private String _path;


    public XMLPath(String path) {
        _path = path;
    }

    public XMLPath(XMLPath xmlPath) {
        _path = xmlPath.getPath();
    }


    public String getPath() {
        return _path;
    }

    public XMLPath appendElementName(String elementName) {
        if(elementName != null && !"".equals(elementName)) {
            _path += XMLPATHSEPARATOR + elementName;
        }
        return this;
    }

    public XMLPath prependElementName(String elementName) {
        _path = elementName + XMLPATHSEPARATOR + _path;
        return this;
    }


    public XMLPath appendAttributeName(String attributeName) {
        _path += XMLATTSEPARATOR + attributeName;
        return this;
    }

    public StringTokenizer getElements() {
        String path = getElementsPart();  // Don't return the attribute part if there is one
        return new StringTokenizer(path, XMLPATHSEPARATOR);
    }

    public boolean isAttribute() {
        return _path.indexOf(XMLATTSEPARATOR) != -1;
    }

    public String getAttributePart() {
        int index = _path.indexOf(XMLATTSEPARATOR);
        if(index != -1) {
            return _path.substring(index + 1);
        }
        else return null;
    }

    public String getElementsPart() {
        int index = _path.indexOf(XMLATTSEPARATOR);
        if(index != -1) {
            return _path.substring(0, index);
        }
        else return _path;
    }

    public String getRootPart() {
        int index = _path.indexOf(XMLPATHSEPARATOR);
        if(index != -1) {
            return _path.substring(0, index);
        }
        else return _path;
    }

    public String getLastPart() {
        if(isAttribute()) {
            return getAttributePart();
        }
        
        int index = _path.lastIndexOf(XMLPATHSEPARATOR);
        if(index != -1) {
            return _path.substring(index + 1);
        }
        else return _path;
    }

    public boolean equals(XMLPath xmlPath) {
        return _path.equals(xmlPath.getPath());
    }

    public boolean endsWith(XMLPath xmlPath) {
        return _path.endsWith(xmlPath.getPath());
    }

    public String toString() {
        return _path;
    }

    public static XMLPath getXMLPathForElement(Element element) {
        if(element == null) {
            return null;
        }
        
        String name = element.getName();
        
        Element parent;
        while((parent = (Element) element.getParent()) != null) {
            /*
             * If the parent element has a different namespace to this element's,
             * then add a namespace prefix to this element at this point
             */ 
            if(!parent.getNamespace().equals(element.getNamespace())) {
                String prefix = element.getNamespacePrefix();
                /*
                 * If there is no namespace prefix found on this element
                 * it might be declared in the root element as an additional namespace
                 */
                if("".equals(prefix)) {
                    if(element.getDocument() != null) {
                        Iterator it = element.getDocument().getRootElement().getAdditionalNamespaces().iterator();
                        while(it.hasNext()) {
                            Namespace ns = (Namespace)it.next();
                            if(ns.equals(element.getNamespace())) {
                                prefix = ns.getPrefix();
                                if(!"".equals(prefix)) {
                                    name = prefix + ":" + name;
                                }
                            }
                        }
                    }
                }
                else {  // If we have a prefix
                    name = prefix + ":" + name;
                }
            }
            
            name = parent.getName() + XMLPATHSEPARATOR + name;
            element = parent;
        }

        XMLPath xmlPath = new XMLPath(name);
        return xmlPath;
    }

    public static XMLPath getXMLPathForAttribute(Attribute attribute) {
        if(attribute == null) return null;
        
        Element parent = attribute.getParent();
        if(parent != null) {
            XMLPath xmlPath = getXMLPathForElement(attribute.getParent());
        	xmlPath.appendAttributeName(attribute.getQualifiedName());
        	return xmlPath;
        }
        else {
            XMLPath xmlPath = new XMLPath(attribute.getQualifiedName());
            return xmlPath;
        }
    }
}