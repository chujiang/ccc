package com.kingnod.etraining.course.parsexmlutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public final class XMLUtils {

    public static Namespace XSI_Namespace = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");

    public static Namespace XSI_NamespaceOLD = Namespace.getNamespace("xsi", "http://www.w3.org/2000/10/XMLSchema-instance");

    public static String XSI_SchemaLocation = "schemaLocation";

	public static void write2XMLFile(Document doc, File file) throws IOException {
		XMLOutputter outputter = new XMLOutputter();
		// This gets rid of junk characters (but also carriage returns...)
		//outputter.setTextNormalize(true);
		
		// Create parent folder if it doesn't exist
		File parent = file.getParentFile();
		if(parent != null) {
		    parent.mkdirs();
		}
		
		FileOutputStream out = new FileOutputStream(file);
		outputter.output(doc, out);
		out.close();
	}

	public static String write2XMLString(Document doc) throws IOException {
		XMLOutputter outputter = new XMLOutputter();
		// This gets rid of junk characters (but also carriage returns...)
		//outputter.setTextNormalize(true);
		StringWriter out = new StringWriter();
		outputter.output(doc, out);
		out.close();
		return out.toString();
	}
	
	public static Document readXMLFile(File file, String schemaNamespace, String schemaLocation) throws IOException, JDOMException {
		Document doc = null;
		SAXBuilder builder = new SAXBuilder(true);
		builder.setFeature("http://apache.org/xml/features/validation/schema", true);
		builder.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation",
				schemaNamespace + " " + schemaLocation);
		// This allows UNC mapped locations to load
		doc = builder.build(new FileInputStream(file));
		return doc;
	}

	public static Document readXMLFile(File file) throws IOException, JDOMException {
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();
		// This allows UNC mapped locations to load
		doc = builder.build(new FileInputStream(file));
		return doc;
	}

	public static Document readXMLString(String xmlString) throws JDOMException, IOException {
	    SAXBuilder builder = new SAXBuilder();
	    return builder.build(new StringReader(xmlString));
	}

    public static void replaceNamespaces(Element element, Namespace oldNamespace, Namespace newNamespace) {
        if(element.getNamespace().equals(oldNamespace)) {
        	element.setNamespace(newNamespace);
        }
    
        Iterator children = element.getChildren().iterator();
        while(children.hasNext()) {
            Element child = (Element)children.next();
            replaceNamespaces(child, oldNamespace, newNamespace);
        }
    }

    public static String getSchemaLocation(Document doc, Namespace ns) {
        if(doc.hasRootElement() && ns != null) {
            String namespaceURI = ns.getURI();
            if(namespaceURI != null) {
                Element root = doc.getRootElement();
    
                // Get Schema Location
                String str = root.getAttributeValue(XSI_SchemaLocation, XSI_Namespace);
                // Try an older one
                if(str == null) {
                    str = root.getAttributeValue(XSI_SchemaLocation, XSI_NamespaceOLD);
                }
    
                if(str != null) {
                    int index = str.indexOf(namespaceURI);
                    if(index != -1) {
                        str = str.substring(index + namespaceURI.length());
                        StringTokenizer t = new StringTokenizer(str, " ");
                        try {
                            return t.nextToken();
                        }
                        catch(NoSuchElementException ex) {
                            return null;
                        }
                    }
                }
            }
        }
    
        return null;
    }
	
    
    /**
     * @return The root Namespace in the Document or null if not found
     */
    public static Namespace getDocumentNamespace(Document doc) {
        Namespace ns = null;
        if(doc.hasRootElement()) {
            ns = doc.getRootElement().getNamespace();
        }
        return ns;
    }

    public static Namespace getDocumentNamespace(Document doc, String prefix) {
        Namespace ns = null;
        if(doc.hasRootElement()) {
            ns = doc.getRootElement().getNamespace(prefix);
        }
        return ns;
    }

    public static boolean containsNamespace(Document doc, Namespace ns) {
        return containsNamespace(doc.getRootElement(), ns);
    }

    public static boolean containsNamespace(Element element, Namespace ns) {
        // Element Namespace?
        if(ns.equals(element.getNamespace())) {
            return true;
        }

        // Additional Namespace?
        Iterator it = element.getAdditionalNamespaces().iterator();
        while(it.hasNext()) {
            Namespace ns1 = (Namespace)it.next();
            if(ns1.equals(ns)) {
                return true;
            }
        }

        // Recurse children
        Iterator i = element.getChildren().iterator();
        while(i.hasNext()) {
            Element child = (Element) i.next();
            boolean found = containsNamespace(child, ns);
            if(found) {
                return true;
            }
        }
        
        return false;
    }

    public static boolean isMemberOfSameDocument(Element element1, Element element2) {
        Document doc1 = element1.getDocument();
        Document doc2 = element2.getDocument();
        if(doc1 == null || doc2 == null) {
            return false;
        }
        return doc1.equals(doc2);
    }
	
}