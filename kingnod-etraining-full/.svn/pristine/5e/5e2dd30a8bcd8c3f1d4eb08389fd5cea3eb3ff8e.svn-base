package com.kingnod.etraining.report.util;



import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import oracle.xml.parser.v2.XMLDocument;
import org.w3c.dom.Element;

public class GenerateXMLfile
{

    private XMLDocument doc;
    private Element eleRoot;
    private String columnNames[];

    public GenerateXMLfile()
    {
        doc = new XMLDocument();
    }

    public void CreateXML(String filePathName, List dataList)
    {
        addFileHead();
        columnNames = (String[])dataList.get(0);
        for(int i = 1; i < dataList.size(); i++)
            addFileBody((String[])dataList.get(i));

        try
        {
            FileOutputStream fos = new FileOutputStream(filePathName);
            doc.print(fos, "UTF-8");
            fos.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void addFileBody(String dataList[])
    {
        try
        {
            Element ROW = doc.createElement("ROW");
            eleRoot.appendChild(ROW);
            for(int i = 0; i < dataList.length; i++)
                appElement(ROW, columnNames[i], dataList[i]);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void appElement(Element ele, String eleName, String value)
    {
        try
        {
            Element eleChild = doc.createElement(eleName);
            ele.appendChild(eleChild);
            eleChild.appendChild(doc.createTextNode(value));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void addFileHead()
    {
        try
        {
            eleRoot = doc.createElement("ROWSET");
            doc.appendChild(eleRoot);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void appendChild(Element parent, String childName)
    {
        Element child = doc.createElement(childName);
        parent.appendChild(child);
    }

    public static void main(String args1[])
    {
    }
}
