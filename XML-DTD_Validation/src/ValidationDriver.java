import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidationDriver {

	public static void main(String[] args) {
		String flag = "Yes";
		try {
			validate("Data.xml");
		} catch (ParserConfigurationException e) {
			flag = "No";
		} catch (FileNotFoundException e) {
			flag = "No";
		} catch (SAXException e) {
			flag = "No";
		} catch (IOException e) {
			flag = "No";
		}

		System.out.println("Is XML file valid: " + flag);
	}

	public static void validate(String xmlFile)
			throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(true);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler() {

			@Override
			public void warning(SAXParseException exception) throws SAXException {
				throw exception;
			}

			@Override
			public void error(SAXParseException exception) throws SAXException {
				throw exception;
			}

			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				throw exception;
			}
		});
		documentBuilder.parse(new FileInputStream(xmlFile));
	}

}
