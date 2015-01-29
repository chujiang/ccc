package com.kingnod.etraining.common.export;

import oracle.xdo.template.FOProcessor;
/**
 * 文件输出类型
 * @author Sam
 *
 */
public enum ExportType {
	PDF,
	EXCEL,
	HTML,
	IMAGE_JPG,
	PPT,
	RTF;
	
	public byte getXmlPublishFormatValue() {
		if (this == PDF)
			return FOProcessor.FORMAT_PDF;
		if (this == HTML)
			return FOProcessor.FORMAT_HTML;
		if (this == RTF)
			return FOProcessor.FORMAT_RTF;
		if (this == IMAGE_JPG)
			return FOProcessor.FORMAT_IMAGE_JPG;
		if (this == PPT)
			return FOProcessor.FORMAT_PPTX;
		return FOProcessor.FORMAT_EXCEL;
	}
}
