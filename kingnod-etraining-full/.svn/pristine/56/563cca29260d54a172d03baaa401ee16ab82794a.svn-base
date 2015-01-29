
package com.kingnod.etraining.common.export.jxls;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

import com.kingnod.core.util.ArrayUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.export.AbstractExcelExporter;
import com.kingnod.etraining.common.export.ExcelExporter;
  

/**
 * 基于JXLS的excel导出处理器。
 * 
 * @author Sam
 * 
 */
public class JXLSExcelExporter extends AbstractExcelExporter implements ExcelExporter {
    
    private XLSTransformer excelExportHandler = new XLSTransformer();
    
    public JXLSExcelExporter() {

    }
    
    public JXLSExcelExporter(String reportPath, String exportPath) {

        super(reportPath, exportPath);
    }
    
    @SuppressWarnings("unchecked")
    public JXLSExcelExporter(String reportPath, String exportPath, Map params, Map ds) {

        super(reportPath, exportPath);
        addParams(params);
        addDataSources(ds);
    }
    
    @SuppressWarnings("unchecked")
    public void doExport() throws IOException {

        Map jxlsParams = new HashMap();
        jxlsParams.put("params", reportParams);
        jxlsParams.putAll(dataSources);
        checkAndCreateDir(exportPath);
        excelExportHandler.transformXLS(reportPath, jxlsParams, exportPath);
        if (cellSetting != null) {
            new POICellMerger().merge(new File(exportPath), cellSetting.getMergeStartRow(),
                    cellSetting.getRowSize(), cellSetting.getMergeCols());
        }
    }
    
    private String checkAndCreateDir(String exportPath) {

        if (StringUtils.isNotBlank(exportPath)) {
            exportPath = exportPath.replaceAll("\\\\", "/");
            String dir = StringUtils.substringBeforeLast(exportPath, "/");
            File file = new File(dir);
            if (!file.exists())
                file.mkdir();
        }
        return exportPath;
    }
    
    public ExcelExporter hideColumns(int... columns) {

        excelExportHandler.setColumnsToHide(ArrayUtils.toShorts(columns));
        return this;
    }
    
    @SuppressWarnings("unchecked")
    public XLSTransformer getExcelHandler() {

        return excelExportHandler;
    }
    
}
