package com.mingrisoft.SAX_demo;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class ErrorSAXParsing extends DefaultHandler {

	public void warning(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("warning");
		System.out.println("錯誤位置：" + exception.getLineNumber() + "行"
				+ exception.getColumnNumber() + "列");
		System.out.println("錯誤資訊：" + exception.getMessage());
	}

	public void error(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("error");
		System.out.println("錯誤位置：" + exception.getLineNumber() + "行"
				+ exception.getColumnNumber() + "列");
		System.out.println("錯誤資訊：" + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("fdatalError");
		System.out.println("錯誤位置：" + exception.getLineNumber() + "行"
				+ exception.getColumnNumber() + "列");
		System.out.println("錯誤資訊：" + exception.getMessage());

	}

	/**
	 * 透過檔案讀取XML
	 * 
	 * @param pathname
	 *            檔案路徑
	 */
	public void parseReadFile(String pathname) {
		SAXParser parser;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			parser = factory.newSAXParser();
			File file = new File(pathname);
			parser.parse(file, this);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] arg) {

		String pathname = "xmldemo/books.xml";
		ErrorSAXParsing elementSAXParsing = new ErrorSAXParsing();
		elementSAXParsing.parseReadFile(pathname);
	}
}
