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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author bwm
 * 
 */
public class BookDOMDelete {

	private Document document = null;

	private String path = null;

	public BookDOMDelete(String path) {
		// TODO Auto-generated constructor stub
		this.path = path;
	}

	/**
	 * 讀取XML檔案
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
	 * 根據book子節點的條件刪除book節點
	 */
	public void deleteBook(String nodeName, String text) {
		parseReadFile();

		Element books = document.getDocumentElement();
		NodeList list = document.getElementsByTagName("book:book");
		Node node = null;
		for (int i = 0; i < list.getLength(); i++) {
			NodeList list1 = list.item(i).getChildNodes();
			for (int j = 0; j < list1.getLength(); j++) {
				Node node1 = list1.item(j);
				// 根據條件查詢要刪除的節點
				if (node1.getNodeName().equals(nodeName)
						&& node1.getTextContent().equals(text)) {
					node = list.item(i);
				}
			}
		}
		books.removeChild(node);

	}

	/**
	 * 建立XML檔案
	 * 
	 * @param node
	 *            DOM節點
	 * @param url
	 *            XML檔案路徑
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
		String out = "xmldemo/BookDOMDelete.xml";
		BookDOMDelete bulid = new BookDOMDelete(in);
		bulid.deleteBook("book:name", "《C#從入門到精通(第2版)》");
		bulid.writeFile(out);
	}
}
