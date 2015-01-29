package com.kingnod.etraining.course.parsexmlutil;

import org.jdom.Element;

public class XMLDocumentListenerEvent {
    private Object _source;
    private XMLDocument _doc;
    private Element _element;
    private boolean _doSelect;

    public XMLDocumentListenerEvent(Object source, XMLDocument xmlDocument, Element element, boolean doSelect) {
        _source = source;
        _doc = xmlDocument;
        _element = element;
        _doSelect = doSelect;
    }

    public Object getSource() {
        return _source;
    }

    public XMLDocument getXMLDocument() {
        return _doc;
    }

    public Element getElement() {
        return _element;
    }

    public boolean doSelect() {
        return _doSelect;
    }
}