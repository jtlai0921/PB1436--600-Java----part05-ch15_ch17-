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
public class ElementValueSAXParsing extends DefaultHandler {

	private List<String> list = new ArrayList<String>();

	private String value;

	/**
	 * Ū���ثe���������e,�L�o�^�s��šB�Ů�šB�T�{�šB�����
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//Ū���ثe���������e,�L�o�^�s��šB�Ů�šB�T�{�šB�����
		value = String.valueOf(ch, start, length);
		value = value.replace("\t", "");
		value = value.replace(" ", "");
		value = value.replace("\n", "");
		value = value.replace("\r", "");
	}

	/**
	 * Ū�����������A�⤸���W�٩M�������e�x�s�blist��
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//Ū�����������A�⤸���W�٩M�������e�x�s�blist��
		list.add(localName + ":" + value);
	}

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
		ElementValueSAXParsing elementSAXParsing = new ElementValueSAXParsing();
		elementSAXParsing.parseReadFile(pathname);
		System.out.println("�����W�٩M�������e");
		System.out.println(elementSAXParsing.getList());
	}
}
