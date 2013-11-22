package fr.upem.pluscourtchemin;

import java.io.IOException;
import java.util.Objects;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {
	private final String nameXmlFile;
	private final GraphInformations graph;

	public XMLParser(String nameXmlFile, GraphInformations graph) {
		this.graph = Objects.requireNonNull(graph);
		this.nameXmlFile = Objects.requireNonNull(nameXmlFile);
	}

	public void parseDocument() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(nameXmlFile, this);
		} catch (ParserConfigurationException e) {
			System.out.println("Erreur de configuration du parseur");
			System.out.println("Lors de l'appel � newSAXParser()");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("Erreur de parsing");
			System.out.println("Lors de l'appel � parse()");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur d'entree/sortie");
			System.out.println("Lors de l'appel � parse()");
			e.printStackTrace();
		}
	}

	public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException{
		if (qName.equalsIgnoreCase("dimension")) {
			this.graph.setHeight(Integer.parseInt(attributes.getValue("height")));
			this.graph.setWidth(Integer.parseInt(attributes.getValue("width")));
		} else if (qName.equalsIgnoreCase("start")) {
			Vertex s = new Vertex(Integer.parseInt(attributes.getValue("x")),Integer.parseInt(attributes.getValue("y")));
			this.graph.setStart(s);
		} else if (qName.equalsIgnoreCase("end")) {
			Vertex e = new Vertex(Integer.parseInt(attributes.getValue("x")),Integer.parseInt(attributes.getValue("y")));
			this.graph.setEnd(e);
		} else if (qName.equalsIgnoreCase("obstacle")) {
			int topLeftX = Integer.parseInt(attributes.getValue("topleftx"));
			int topLeftY = Integer.parseInt(attributes.getValue("toplefty"));
			int bottomRightX = Integer.parseInt(attributes.getValue("bottomrightx"));
			int bottomRightY = Integer.parseInt(attributes.getValue("bottomrighty"));
			for(int i = topLeftX ; i <= bottomRightX ; i++){
				for( int j = topLeftY ; j <= bottomRightY ; j++){
					Vertex e = new Vertex(i,j);
					this.graph.addInvalidVertex(e);
				}
			}
		}
	}
}
