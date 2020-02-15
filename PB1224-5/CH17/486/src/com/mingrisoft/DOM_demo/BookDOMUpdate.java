package com.mingrisoft.DOM_demo;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author bwm
 * 
 */
public class BookDOMUpdate {

	private Document document = null;

	private String path = null;

	public BookDOMUpdate(String path) {
		// TODO Auto-generated constructor stub
		this.path = path;
	}

	/**
	 * Ū��XML�ɮ�
	 * 
	 * @param path
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private void parseReadFile() {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dombuilder = null;
		try {
			dombuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file = new File(path);
		try {
			document = dombuilder.parse(file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �ھ�book�l�`�I���w�������s���������e
	 * 
	 * @param nodeName
	 *            ���w���󤸯��W��
	 * @param text
	 *            ���w���󤸯����e
	 * @param replNodeName
	 *            ���w��s���`�I
	 * @param repltext
	 *            �]�w��s�����e
	 */
	public void updateBook(String nodeName, String text, String replNodeName,
			String repltext) {
		parseReadFile();

		NodeList list = document.getElementsByTagName("book:book");
		for (int i = 0; i < list.getLength(); i++) {
			boolean flag = false;
			Node bookNode = list.item(i);
			NodeList list1 = bookNode.getChildNodes();
			// �d�ߥX�ݭn�ק諸book�`�I
			for (int j = 0; j < list1.getLength(); j++) {
				Node node1 = list1.item(j);
				if (node1.getNodeName().equals(nodeName)
						&& node1.getTextContent().equals(text)) {
					flag = true;
				}
			}
			// �d�ߨ�ݭn��book�`�I�A�]�w���w���������e
			if (flag) {
				for (int j = 0; j < list1.getLength(); j++) {
					Node node1 = list1.item(j);
					// �d�ߥX�ݭn�ק諸�`�I
					if (node1.getNodeName().equals(replNodeName)) {
						node1.setTextContent(repltext);
					}
				}
				flag = false;
			}

		}

	}

	/**
	 * �إ�XML�ɮ�
	 * 
	 * @param node
	 *            DOM�`�I
	 * @param url
	 *            XML�ɮ׸��|
	 */
	public void writeFile(String out) {
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(out));
		try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(domSource, streamResult);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] arg) {
		String in = "xmldemo/BookDOMBulid.xml";
		String out = "xmldemo/BookDOMUpdate.xml";
		BookDOMUpdate bulid = new BookDOMUpdate(in);
		bulid.updateBook("book:author", "���p��", "book:name", "�mC#�q�J�����q(��1��)�n");
		bulid.writeFile(out);
	}
}
