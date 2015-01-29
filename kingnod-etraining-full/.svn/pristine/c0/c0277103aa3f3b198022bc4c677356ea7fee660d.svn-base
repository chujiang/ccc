package com.kingnod.etraining.course.parsexmlutil;

import org.jdom.Element;

/**
 * Clipboard for transferring XMLDocument Elements
 *
 * @author Phillip Beauvoir
 * @version $Id: XMLDocumentClipboard.java,v 1.3 2007/07/15 20:27:46 phillipus Exp $
 */
public class XMLDocumentClipboard {

    // Some flags for moving/copying Elements
    public static final int ACTION_COPY = 0x1;
    public static final int ACTION_MOVE = 0x2;
    public static final int ACTION_CUT = 0x4;
    public static final int ACTION_DELETE = 0x8;
    public static final int ACTION_PASTE = 0x10;

    private static Element _element = null;
    private static int _action = 0x0;

    public static void addCutElement(Element element) {
        _element = element;
        _action = ACTION_CUT;
    }

    public static void addCopiedElement(Element element) {
        _element = element;
        _action = ACTION_COPY;
    }

    public static Element getElement() {
        return _element;
    }

    public static boolean isCopiedElement() {
        return _action == ACTION_COPY;
    }

    public static boolean isCutElement() {
        return _action == ACTION_CUT;
    }

}