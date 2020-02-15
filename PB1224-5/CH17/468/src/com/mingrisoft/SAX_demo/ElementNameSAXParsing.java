/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-3-20
 */
package com.mingrisoft.SAX_demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author bwm
 * 
 */
public class ElementNameSAXParsing extends DefaultHandler {

	private List<String> list = new ArrayList<String>();

	/**
	 * ���s�w�q�����O��k�A�x�sXML����
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		list.add(localName);
	}

	/**
	 * ��o
	 * 
	 * @return
	 */
	public List<String> getList() {
		return this.list;
	}

	/**
	 * �z�L�ɮ�Ū��XML
	 * 
	 * @param pathname
	 *            �ɮ׸��|
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
		ElementNameSAXParsing elementSAXParsing = new ElementNameSAXParsing();
		elementSAXParsing.parseReadFile(pathname);
		System.out.println("�����W��");
		System.out.println(elementSAXParsing.getList());
	}
}
