package com.kingnod.etraining.common.export.xmlpublish;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.xml.parser.v2.XMLDocument;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.w3c.dom.Element;

import com.kingnod.core.util.Lang;
import com.kingnod.core.util.ObjectUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.io.IOUtils;
import com.kingnod.core.util.reflect.BeanUtils;
import com.kingnod.etraining.organization.entity.User;
/**
 * xml数据集，用于传给xmlpublish所需的xml数据集。
 * @author Sam
 *
 */
public class XmlDataSet {
	/**
	 * xml 文档对象
	 */
	private XMLDocument doc;
	
	/**
	 * xml根结点
	 */
	private Element root;
	
	private XmlDataSet(String rootName) {
		doc = new XMLDocument();
		root = doc.createElement(rootName);
		doc.appendChild(root);
	}
	
	public static XmlDataSet create(String rootName) {
		return new XmlDataSet(rootName);
	}
	
	public static XmlDataSet create() {
		return create("DataSet");
	}
	
	/**
	 * 添加一个元素到根结点中
	 * @param element
	 * @return
	 */
	public Element add(Element element) {
		root.appendChild(element);
		return element;
	}
	
	/**
	 * 根据一个实体对象集生成一个element并添加到根结点中。 
	 *
	 * @param elementName xml元素名
	 * @param childNodeName 子元素名
	 * @param dataset 要添加的实体对象集数据
	 * @param fields 实体的属性
	 * @return
	 */
	public Element add(String elementName,String childNodeName,List dataset,String...fields) {
		return add(root,elementName,childNodeName,dataset,fields);
	}
	
	public Element add(List dataset,String...fields) {
		return add("RowSet","Row",dataset,fields);
	}
	
	public Element add(Element parent,String elementName,String childNodeName,List dataset,String...fields) {
		Element rowset = doc.createElement(elementName);
		if ( ListUtils.isNotEmpty(dataset) ) {
			for (Iterator iter = dataset.iterator(); iter.hasNext();) {
				Element row = doc.createElement(childNodeName);
				Object record = iter.next();
				if (record instanceof List) {
					List cells = (List)record;
					for (int i = 0; i < cells.size(); i++ ) {
						Element cell = doc.createElement("CELL_"+i);
						cell.setTextContent(ObjectUtils.toString(cells.get(i)));
						row.appendChild(cell);
					}
				} else if (record instanceof Map) {
					Set keyset = ((Map)record).keySet();
					for (Iterator keyIter = keyset.iterator(); keyIter.hasNext();) {
						Object key = keyIter.next();
						Element cell = doc.createElement(key.toString());
						cell.setTextContent(ObjectUtils.toString(((Map)record).get(key)));
						row.appendChild(cell);
					}
				} else {
					if (ArrayUtils.isEmpty(fields)) {
						List<String> allField = ListUtils.newList();
						PropertyDescriptor[] propDescs = PropertyUtils.getPropertyDescriptors(record);
						for (PropertyDescriptor pd : propDescs) {
							allField.add(pd.getName());
						}
						fields = ListUtils.toArray(allField);
					}
					for (String field : fields ) {
						Element cell = doc.createElement(field);
						cell.setTextContent(ObjectUtils.toString(BeanUtils.getAnyProperty(record, field)));
						row.appendChild(cell);
					}
				}
				rowset.appendChild(row);
			}
		}
		parent.appendChild(rowset);
		return rowset;
	}
	
	public Element createElement(String elementName) {
		return doc.createElement(elementName);
	}
	
	public Element getRoot() {
		return root;
	}
	
	public String toString() {
		StringWriter sw = new StringWriter();
		try {
			doc.print(sw);
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return sw.toString();
	}
	
	public StringReader toReader() {
		String xmlString = toString();
		Lang.println(xmlString);
		return new StringReader(xmlString);
	}
	
	public File toFile(String filePath) {
		File f = new File(filePath);
		FileWriter fOut = null;
		try {
		fOut = IOUtils.fileWriter(f);
		fOut.write(toString());
		fOut.flush();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(fOut);
		}
		return f;
	}
	
	public static void main(String[] args) {
		List<User> users = ListUtils.newList();
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setLoginName("user" +i);
			u.setPassword("pwd" + i);
			users.add(u);
		}
		XmlDataSet xds = XmlDataSet.create();
		xds.add( users,"loginName","password");
		Lang.print(xds.toString());
	}
	
}














