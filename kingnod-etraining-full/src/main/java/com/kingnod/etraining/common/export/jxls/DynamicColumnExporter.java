package com.kingnod.etraining.common.export.jxls;
 
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.dict.DictFactory;
import com.kingnod.core.dict.DictService;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.CollectionUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.reflect.BeanUtils;
import com.kingnod.core.util.web.ServletUtils;
import com.kingnod.etraining.common.export.ExcelExporter;
import com.kingnod.etraining.common.export.util.Exporters;

/**
 * 简单动态列EXCEL导出器，只针对简单的EXCEL数据导出，即导出的Excel只需要标题，列表这些，如果比较复杂的话应该
 * 使用自定义模板的方式来实现
 * @author sam
 *
 */
public class DynamicColumnExporter {
	/**
	 * 默认的动态列导出模板
	 */
	private static final String DEFAULT_TEMPLATE = "dynamicTemplate.xls";	
	
	/**
	 * 动态列导出模板所在位置，一般情况下不须要修改此
	 */
	private String  template = getFileOfClassPath(DEFAULT_TEMPLATE);
	
	/**
	 * 导出Excel的标题
	 */
	private String title;
	
	/**
	 * 列头定义，即表格的头部文本信息
	 */
	private List<String> columns = ListUtils.newList();
	
	/**
	 * 导出的记录中的记录相应的属性集，导出器会根据这个顺序和名称取记录的属性作输出
	 */
	private List<String> properties = ListUtils.newList();
	
	/**
	 * 导出的记录集
	 */
	@SuppressWarnings("unchecked")
	private List records = new ArrayList();
	
	/**
	 * 设置与Dict的映射关系
	 */
	private Map<String,String> dictMapping = MapUtils.newMap();
	
	/**
	 * 依赖的导出器
	 */
	private ExcelExporter exporter = new JXLSExcelExporter(); 	
	
	DynamicColumnExporter() { }
	

	
	/**
	 * 设置导出标题
	 * @param title
	 * @return
	 */
	public DynamicColumnExporter title(String title) {
		this.title = title;
		return this;
	}
	
	public DynamicColumnExporter cellMerge(Integer uniteStartRow,Integer rowSize,List<Integer> uniteCols) {
		this.exporter.cellMerge(uniteStartRow, rowSize, uniteCols);
		return this;
	}

	
	/**
	 * 设置列标题
	 * @param columns
	 * @return
	 */
	public DynamicColumnExporter columns(String...columns) {
		this.columns.addAll(ListUtils.of(columns));
		return this;
	}

	public DynamicColumnExporter applyDict(String property,String dictName) {
		dictMapping.put(property,dictName);
		return this;
	}

	
	/**
	 * 设置列标题
	 * @param columns
	 * @return
	 */
	public DynamicColumnExporter columns(List<String> columns) {
		this.columns.addAll(columns);
		return this;
	}
	
	/**
	 * 设置记录的属性
	 * @param props
	 * @return
	 */
	public DynamicColumnExporter properties(String...props) {
		this.properties.addAll(ListUtils.of(props));
		return this;
	}
	
	/**
	 * 设置记录的属性
	 * @param props
	 * @return
	 */
	public DynamicColumnExporter properties(List<String> props) {
		this.properties.addAll(props);
		return this;
	}
	
	/**
	 * 设置要导出的数据集
	 * @param records
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public DynamicColumnExporter record(List records) {
		this.records = records;
		return this;
	}
	
	/**
	 * 导出处理
	 * @param f 导出的目标文件
	 * @return
	 * @throws IOException 
	 */
	public void export(File f) throws IOException {
		if (!dictMapping.isEmpty()) {
			handleRecords();
		}
		if (f != null && !f.exists())
			f.createNewFile();
		exporter.setExportPath(f.getAbsolutePath());
		exporter.setReportPath(template);
		exporter.addParam("title", this.title);
		exporter.addDataSource("columns", this.columns);		
		exporter.addDataSource("properties", this.properties);
		exporter.addDataSource("records", this.records);

		exporter.export();
	}
	
	private void handleRecords() {
		DictFactory dictFactory = SpringUtils.getBean(DictFactory.class);
		DictService dictService = dictFactory.createDictService();
		if (CollectionUtils.isNotEmpty(records)) {
			for (int i = 0; i < records.size(); i++ ) {
				Object o = records.get(i);
				if (o != null) {
					for (Entry<String,String> entry : dictMapping.entrySet()) {
						if (StringUtils.contains(entry.getValue(), ".")) {
							String dictConfigName = entry.getValue().split("[.]")[0];
							String name = entry.getValue().split("[.]")[1];
							Object v = BeanUtils.getAnyProperty(o, entry.getKey());
							if (v != null) {
								Object vv = 
									dictService.getDictItemNameByValue(dictConfigName, name, null, v.toString());
								BeanUtils.setProperty(o, entry.getKey(), vv);
							}
						}
					}
				}
			}
		}
	}



	/**
	 * 导出处理
	 * @param exportPath 导出的目标路径，如果只写文件名的话则会在应用程序指定的临时目录写文件
	 * @return
	 * @throws IOException 
	 */
	public File export(String exportPath) throws IOException {		
		File exportFile = Exporters.findFile(exportPath);
		export(exportFile);
		return exportFile;
	}	

	/**
	 * 导出到客户端
	 * @param response HTTP响应
	 * @param fileName 要导出的文件名
	 * @throws IOException 
	 */
	public void export(HttpServletResponse response,String fileName) throws IOException {
		File f = export(fileName);
		ServletUtils.download(response, f,fileName, false);		
	}		
	
	/**
	 * 创建一个导出处理器
	 * @return
	 */
	public static DynamicColumnExporter create(){
		return new DynamicColumnExporter();
	}
	
	String getFileOfClassPath(String path) {
		URL url = getClass().getResource(path);
		return url.getFile();
	}

	/**
	 * 获取导出报表标题
	 * @return
	 */
	public String getTitle() {
		return title;
	}	
	
	/**
	 * 获取模板名称 
	 * @return
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * 获取记录集
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getRecords() {
		return records;
	}
	
	/**
	 * 返回内部的Excel导出处理器
	 * @return
	 */
	public ExcelExporter getInnerExporter() {
		return exporter;
	}
	
//	public static void main(String[] a) throws IOException {
//		List<Employee> emps = ListUtils.newList();
//		for (int i = 0; i<100; i++ ) {
//			emps.add(new Employee("Elsa"+i, 28+i, 1500+i, 0.15+i));
//		}
//		
//		DynamicColumnExporter de = DynamicColumnExporter.create();
//		de.title("员工列表")
//		  .properties("name", "age", "payment", "bonus")
//		  .columns("名称","年龄","工资","交税")
//		  .record(emps)
//		  .export("dynamicemp");
//	
//	}
	
}

