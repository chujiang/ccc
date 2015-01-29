package com.kingnod.etraining.course.contentpackage;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;

import org.jdom.Element;
import org.jdom.Namespace;

import com.kingnod.etraining.course.metadata.MD_Core;
import com.kingnod.etraining.course.parsexmlutil.XMLDocument;




public class CP_Core {

	/**
	 * The CP Manifest name
	 */
	public static final String MANIFEST_NAME = "imsmanifest.xml";

	// Element and Attribute Names
    public static final String MANIFEST = "manifest";
    public static final String ORGANIZATIONS = "organizations";
    public static final String RESOURCES = "resources";
    public static final String DEFAULT = "default";
    public static final String ORGANIZATION = "organization";
    public static final String ITEM = "item";
    public static final String PARAMETERS = "parameters";
    public static final String RESOURCE = "resource";
    public static final String BASE = "base";
    public static final String FILE = "file";
    public static final String TYPE = "type";
    public static final String HREF = "href";
    public static final String METADATA = "metadata";
    public static final String IDENTIFIER = "identifier";
    public static final String IDENTIFIERREF = "identifierref";
    public static final String STRUCTURE = "structure";
    public static final String TITLE = "title";
    public static final String DEPENDENCY = "dependency";
    public static final String VERSION = "version";
    public static final String SCHEMA = "schema";
    public static final String SCHEMAVERSION = "schemaversion";
    public static final String ISVISIBLE = "isvisible";

    /**
     * The JDOM Document that forms the Content Package that we shall be working on
     */
    private XMLDocument _doc;

    /**
     * Constructor
     */
    public CP_Core(XMLDocument doc) {
        _doc = doc;
    }

    /**
     * @return the CP Root Folder which is the containing folder of imsmanifest.xml
     */
    public File getRootFolder() {
        File file = _doc.getFile();
        return file == null ? null : file.getParentFile();
    }
    
    /**
     * Destroy this Document
     */
    public void destroy() {
        _doc = null;
    }

    // =============================================================================
    // ELEMENT FINDING/NAVIGATION HANDLING
    // =============================================================================

    
    /**
     * @return The Root manifest element
     */
    public Element getRootManifestElement() {
        return _doc.getRootElement();
    }
    
    /**
     * @param sourceElement
     * @return The Element referenced by identifierref in sourceElement.
     * The search digs downward from sourceElement - this is important.
     * This will be either a Resource or a sub-Manifest.
     */
    public Element getReferencedElement(Element sourceElement) {
        String idref = sourceElement.getAttributeValue(IDENTIFIERREF);

        if(idref != null) {
            Element manifest = getParentManifestElement(sourceElement);
            if(manifest != null) {
                // Search the Resources first
                Element[] resources = getElementsInManifest(manifest, RESOURCE, _doc.getRootNamespace());
                for(int i = 0; i < resources.length; i++) {
                    String id = resources[i].getAttributeValue(IDENTIFIER);
                    if(id != null) {
                        if(idref.equals(id)) return resources[i];
                    }
                }

                // Search for a sub-Manifest
                Element[] submanifests = getElementsInManifest(manifest, MANIFEST, _doc.getRootNamespace());
                for(int i = 0; i < submanifests.length; i++) {
                    String id = submanifests[i].getAttributeValue(IDENTIFIER);
                    if(id != null && idref.equals(id)) return submanifests[i];
                }
            }
        }

        return null;
    }

    /**
     * @param element The element to test
     * @return True if element has an identifierref attribute
     */
    public boolean isReferencingElement(Element element) {
        String idref = element.getAttributeValue(IDENTIFIERREF);
        return idref != null && !idref.equals("");
    }

    /**
     * Get all available Identifiers from resources and sub-Manifests that an element can legally reference.
     * For an <item> element this will be resources and sub-manifests.
     * For a <dependency> element this will be resources, not including its parent <resource>.
     * 
     * @param element The Element that wishes to reference other Elements.
     * Must be either <item>, or <dependency> 
     * @return all available Identifiers from resources and sub-manifests that an element can legally reference.
     */
    public String[] getReferencedIdentifersAllowed(Element element) {
        Vector v = new Vector();

        Element[] elements = getReferencedElementsAllowed(element);
        for(int i = 0; i < elements.length; i++) {
            String id = elements[i].getAttributeValue(IDENTIFIER);
            if(id != null && !id.equals("")) {
                v.add(id);
            }
        }

        String[] ids = new String[v.size()];
        v.copyInto(ids);
        return ids;
    }

    /**
     * Get all available Elements (resources and sub-manifests) that an element can legally reference.
     * For an <item> element this will be resources and sub-manifests.
     * For a <dependency> element this will be resources, not including its parent <resource>.
     * 
     * @param element The Element that wishes to reference other Elements.
     * Must be either <item>, or <dependency> 
     * @return All available Elements (Resources and sub-Manifests) that an element can legally reference.
     */
    public Element[] getReferencedElementsAllowed(Element element) {
        Vector v = new Vector();

        String elementName = element.getName();
        
        // Only Items and Dependency Elements allowed
        
        if(elementName.equals(ITEM)) {
            // Get Parent Manifest Element
            Element manifest = getParentManifestElement(element);
            if(manifest != null) {
                // Search the Resources first
                Element[] resources = getElementsInManifest(manifest, RESOURCE, _doc.getRootNamespace());
                for(int i = 0; i < resources.length; i++) {
                    String id = resources[i].getAttributeValue(IDENTIFIER);
                    if(id != null && !id.equals("")) {
                        v.add(resources[i]);
                    }
                }
                
                // Items can reference sub-Manifests
                Element[] submanifests = getElementsInManifest(manifest, MANIFEST, _doc.getRootNamespace());
                for(int i = 0; i < submanifests.length; i++) {
                    String id = submanifests[i].getAttributeValue(IDENTIFIER);
                    if(id != null && !id.equals("")) {
                        v.add(submanifests[i]);
                    }
                }
            }
        }
        
        else if(elementName.equals(DEPENDENCY)) {
            // Get Parent Manifest Element
            Element manifest = getParentManifestElement(element);
            if(manifest != null) {
                // Search the Resources
                Element[] resources = getElementsInManifest(manifest, RESOURCE, _doc.getRootNamespace());
                for(int i = 0; i < resources.length; i++) {
                    String id = resources[i].getAttributeValue(IDENTIFIER);
                    if(id != null && !id.equals("")) {
                        // This is a <dependency> element, so don't add its parent <resource>
                        if(!resources[i].equals(element.getParent())) {
                            v.add(resources[i]);
                        }
                    }
                }
            }
        }
        
        Element[] elements = new Element[v.size()];
        v.copyInto(elements);
        return elements;
    }

    /**
     * @param manifestElement
     * @param elementName Name of element
     * @param ns Namespace
     * @return all sub-Elements of type elementName from a given parent Manifest
     * This does a deep recursive search.
     */
    public Element[] getElementsInManifest(Element manifestElement, String elementName, Namespace ns) {
        Vector v = new Vector();
        _getElementsInManifest(manifestElement, v, elementName, ns);
        Element[] elements = new Element[v.size()];
        v.copyInto(elements);
        return elements;
    }

    private void _getElementsInManifest(Element parent, Vector v, String elementName, Namespace ns) {
        Iterator it = parent.getChildren().iterator();
        while(it.hasNext()) {
            Element child = (Element)it.next();
            if(child.getName().equals(elementName) && child.getNamespace().equals(ns)) {
                v.add(child);
            }
            _getElementsInManifest(child, v, elementName, ns);
        }
    }

    /**
     * @param element
     * @return the local parent "manifest" Element for a given Element
     * If element is the manifest, will return that
     */
    public Element getParentManifestElement(Element element) {
        while(!element.getName().equals(MANIFEST)) {
            element = (Element) element.getParent();
            if(element == null) return null;
        }
        return element;
    }

    /**
     * @param parent
     * @param identifier
     * @return an Element by its IDENTIFIER attribute starting at parent element
     * This will do a deep recursive search from parent Element
     */
    public Element getElementByIdentifier(Element parent, String identifier) {
        String id = parent.getAttributeValue(IDENTIFIER);
        if(id != null && id.equals(identifier)) return parent;
        
        Iterator it = parent.getChildren().iterator();
        while(it.hasNext()) {
            Element child = (Element)it.next();
            if(_doc.isDocumentNamespace(child)) {
                Element e = getElementByIdentifier(child, identifier);
                if(e != null) return e;
            }
        }

        return null;
    }

    /**
     * @param orgsElement
     * @return all ORGANIZATION elements in orgsElement
     */
    public Element[] getOrganizations(Element orgsElement) {
        Vector v = new Vector();

        Iterator it = orgsElement.getChildren(ORGANIZATION, orgsElement.getNamespace()).iterator();
        while(it.hasNext()) {
            Element orgElement = (Element)it.next();
            v.add(orgElement);
        }

        Element[] orgs = new Element[v.size()];
        v.copyInto(orgs);
        return orgs;
    }

    public String getTitle(Element parent){
    	 Vector v = new Vector();
    	 String child  = "";
    	child = parent.getChildTextTrim(TITLE, parent.getNamespace());
    	if("" == child || null == child){
    		child  = ((Element) parent.getChildren(this.ITEM,parent.getNamespace()).get(0)).getChildTextTrim(TITLE, parent.getNamespace());
    	}
    	return child;
    }
    
    /**
     * @param orgsElement
     * @return all ORGANIZATION elements in an ORGANIZATIONS element that can be referenced
     * i.e they have IDENTIFIER attributes
     */
    public Element[] getOrganizationsAllowed(Element orgsElement) {
        Vector v = new Vector();

        Element[] orgs = getOrganizations(orgsElement);
        for(int i = 0; i < orgs.length; i++) {
            String id = orgs[i].getAttributeValue(IDENTIFIER);
            if(id != null && !id.equals("")) v.add(orgs[i]);
        }

        Element[] new_orgs = new Element[v.size()];
        v.copyInto(new_orgs);
        return new_orgs;
    }

    /**
     * @param orgsElement
     * @return the default Organization for an ORGANIZATIONS element
     * If there is a DEFAULT ref in the ORGANIZATIONS element will return that
     * otherwise return first ORGANIZATION Element if found
     */
    public Element getDefaultOrganization(Element orgsElement) {
        Element element = null;

        if(orgsElement != null && orgsElement.getName().equals(ORGANIZATIONS)) {
            // Get ORGANIZATION by default attribute ref
            String defOrg = orgsElement.getAttributeValue(DEFAULT);
            if(defOrg != null) element = getElementByIdentifier(orgsElement, defOrg);
            // Not found so get first ORGANIZATION Element
            if(element == null) element = orgsElement.getChild(ORGANIZATION, orgsElement.getNamespace());
        }

        return element;
    }

    /**
     * @param name
     * @return True if name is the "lom" element name
     */
    public boolean isMetadataRoot(String name) {
        return name.equals(MD_Core.ROOT_NAME) || name.equals(MD_Core.OLD_ROOT_NAME);
    }

    /**
     * @param name
     * @return True if name is the "metadata" element
     */
    public boolean isMetadataElement(String name) {
        return name.equals(METADATA);
    }

   
    
    /**
     * @param element
     * @return An actual BASE reference for an Element taking into account xml:base
     */
    public String getElementBase(Element element) {
        String totalBase = "";
        
        do {
            String base = element.getAttributeValue(BASE, Namespace.XML_NAMESPACE);
            if(base != null) {
                totalBase = base + totalBase;
                if(base.startsWith("/") || base.startsWith("http:")) break; // Stop at absolute URL
            }
            element = (Element) element.getParent();
        }
        while(element != null);

        return totalBase.equals("") ? null : totalBase;
    }

    /**
     * @param element
     * @return the parameters attribute of an element
     */
    public String getParameters(Element element) {
        String params = element.getAttributeValue(PARAMETERS);

        if(params != null && !params.equals("")) {
            char c = params.charAt(0);
            if((c != '?') && (c != '#')) params = "?" + params;
        }

        return params;
    }

    /**
     * @param href
     * @param resourcesElement The RESOURCES Element
     * @return a Resource Element given its HREF - the first one found
     */
    public Element getResourceElementByHREF(String href, Element resourcesElement) {
        // Got to be the Resources Element
        if(RESOURCES.equals(resourcesElement.getName()) == false) return null;
        
        Iterator it = resourcesElement.getChildren(RESOURCE, resourcesElement.getNamespace()).iterator();
        while(it.hasNext()) {
            Element resource = (Element) it.next();
            String tmp = resource.getAttributeValue(HREF);
            if(tmp != null) {
                // Ignore these chars on compare
                tmp = tmp.replaceAll("%20", " ");
                href = href.replaceAll("%20", " ");
                if(tmp.equalsIgnoreCase(href)) return resource;
            }
        }
        
        return null;
    }

    /**
     * @param href
     * @param resourceElement The RESOURCE Element
     * @return a File Element given its HREF - the first one found
     */
    public Element getFileElementByHREF(String href, Element resourceElement) {
        // Got to be the Resource Element
        if(RESOURCE.equals(resourceElement.getName()) == false) return null;

        Iterator it = resourceElement.getChildren(FILE, resourceElement.getNamespace()).iterator();
        while(it.hasNext()) {
            Element file = (Element) it.next();
            String tmp = file.getAttributeValue(HREF);
            if(tmp != null) {
                // Ignore these chars on compare
                tmp = tmp.replaceAll("%20", " ");
                href = href.replaceAll("%20", " ");
                if(tmp.equalsIgnoreCase(href)) return file;
            }
        }
        return null;
    }

    /**
     * Find the local "resources" Element for a given Element position.  This is because there may
     * be more than one with sub-manifests
     * @param element The starting element position
     * @return The element if found, else null
     */
    public Element getResourcesElement(Element element) {
        if(element.getName().equals(RESOURCES)) return element;
        Element manifest = getParentManifestElement(element);
        return manifest == null ? null : manifest.getChild(RESOURCES, element.getNamespace());
    }

}