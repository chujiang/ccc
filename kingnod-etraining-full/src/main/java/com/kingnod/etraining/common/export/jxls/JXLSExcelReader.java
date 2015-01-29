
package com.kingnod.etraining.common.export.jxls;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.ReaderConfig;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

import org.xml.sax.SAXException;

import com.kingnod.core.util.Lang;
import com.kingnod.core.util.io.IOUtils;
import com.kingnod.etraining.common.export.AbstractExcelReader;
import com.kingnod.etraining.common.export.ReadResult;

/**
 * 基于JXLS的Excel读取器实现。
 * 
 * @author Sam
 * 
 */
public class JXLSExcelReader extends AbstractExcelReader {
    
    private File configFile;
    
    public JXLSExcelReader(File configFile) {

        this.configFile = configFile;
    }
    
    public JXLSExcelReader(String configPath) {

        this(new File(configPath));
    }
    
    @Override
    public ReadResult read(InputStream in) throws IOException {

        XLSReader innerReader = buildInnerReader();
        ReaderConfig readerConfig = ReaderConfig.getInstance();
        readerConfig.setSkipErrors(this.skipError);
        readerConfig.setUseDefaultValuesForPrimitiveTypes(true);
        XLSReadStatus readStatus = innerReader.read(in, resultMapping);
        
        return new ReadResult(readStatus.isStatusOK(), readStatus.getReadMessages(), resultMapping);
    }
    
    private XLSReader buildInnerReader() throws IOException {

        InputStream config = IOUtils.fileBufferIn(configFile);
        try {
            return ReaderBuilder.buildFromXML(config);
        } catch (SAXException ex) {
            throw Lang.wrapThrow(ex, "build xlsReader from xml file[%s] is error!", configFile
                    .getAbsoluteFile());
        } finally {
            IOUtils.close(config);
        }
        
    }
    
}
