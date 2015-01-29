/**
 *  RELOAD TOOLS
 *
 *  Copyright (c) 2004 Oleg Liber, Bill Olivier, Phillip Beauvoir, Paul Sharples
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *  Project Management Contact:
 *
 *  Oleg Liber
 *  Bolton University
 *  Deane Road
 *  Bolton BL3 5AB
 *  UK
 *
 *  e-mail:   o.liber@bolton.ac.uk
 *
 *
 *  Technical Contact:
 *
 *  Phillip Beauvoir
 *  e-mail:   p.beauvoir@dadabeatnik.com
 *
 *  Paul Sharples
 *  e-mail:   p.sharples@bolton.ac.uk
 *
 *  Web:      http://www.reload.ac.uk
 *
 */

package com.kingnod.etraining.course.parsescorm;


import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * A class used to test an xml instance against the schemas it refers to.
 * @author Paul Sharples
 * @version $Id: SchemaValidator.java,v 1.3 2007/07/15 20:28:49 phillipus Exp $ 
 */
public class SchemaValidator {	
	
	public static String SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	
	public static String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	                       
	public File _xmlInstance;
	
	public ErrorPrinter _errors;
	
	public SchemaValidator(){
		_errors = new ErrorPrinter();
	}	
	
	/**
	 * Constructor which allows user to set the xml instance to validate.
	 * @param xmlInstance
	 */
	public SchemaValidator(File xmlInstance){
		_errors = new ErrorPrinter();		
		_xmlInstance = xmlInstance;
	}
		
	public void setXmlInstance(File xmlInstance){
		_xmlInstance = xmlInstance;
	}
	
	public void validate(File xsd) throws IOException, SAXException, ParserConfigurationException {		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		SAXParser parser = factory.newSAXParser();		
		SchemaFactory schemaFactory =
		     SchemaFactory.newInstance(XML_SCHEMA);
		Source schemaSource = 
		     new StreamSource(_xmlInstance);
		Source xsdSource = new StreamSource(xsd);
		Schema schema = schemaFactory.newSchema(xsdSource);
		Validator validator = schema.newValidator();
		parser.setProperty(SCHEMA_LANGUAGE,XML_SCHEMA);					
		if (_xmlInstance.exists()){			
			validator.validate(schemaSource);
		}
	}
	
	public boolean hasErrors(){
		return _errors.hasErrors();
	}
	
	public String[] getErrorMessages(){
		return _errors.getErrorStrings();
	}
	
	
	class ErrorPrinter extends DefaultHandler
	{	 			
		private boolean errorsFound = false;	
								
		private Vector _errorStrings;
		
		private MessageFormat message = new MessageFormat("({0}: {1}, {2}): {3}");
		
		
		public ErrorPrinter(){
			_errorStrings = new Vector();	
		}
	  
		public boolean hasErrors(){
			return errorsFound;
		}
		
		public String[] getErrorStrings(){
			String[] exs = new String[_errorStrings.size()];
			_errorStrings.copyInto(exs);
			return exs;
		}

	    private void print(SAXParseException x){
	    	errorsFound = true;

	   		String msg = message.format(new Object[]{
	                                     x.getSystemId(),
	                                     new Integer(x.getLineNumber()),
	                                     new Integer(x.getColumnNumber()),
	                                     x.getMessage()
	        });
			_errorStrings.add(msg);
	    }

	    public void warning(SAXParseException x){
	    	print(x);
	    }

	    public void error(SAXParseException x){
	   		print(x);
	    }

	    public void fatalError(SAXParseException x){
	   		print(x);
	    }
	 }

}
