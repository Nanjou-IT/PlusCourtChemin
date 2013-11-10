package projetAlgo;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {

	private final String nameXmlFile;
	private GraphInformations graph;

	public XMLParser(String nameXmlFile) {
		super();

		this.graph = new GraphInformations();
		this.nameXmlFile = nameXmlFile;
	}

	public void parseDocument() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(nameXmlFile, this);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de configuration du parseur");
			System.out.println("Lors de l'appel à newSAXParser()");
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de parsing");
			System.out.println("Lors de l'appel à parse()");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur d'entrée/sortie");
			System.out.println("Lors de l'appel à parse()");
			e.printStackTrace();
		}
	}

	public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException{

		
		if (qName.equalsIgnoreCase("rectangle")) {

		} else if (qName.equalsIgnoreCase("dimension")) {
			this.graph.setHeight(Integer.parseInt(attributes.getValue("height")));
			this.graph.setWidth(Integer.parseInt(attributes.getValue("width")));
		} else if (qName.equalsIgnoreCase("start")) {
			Edge s = new Edge(Integer.parseInt(attributes.getValue("x")),Integer.parseInt(attributes.getValue("y")));
			this.graph.setStart(s);
		} else if (qName.equalsIgnoreCase("end")) {
			Edge e = new Edge(Integer.parseInt(attributes.getValue("x")),Integer.parseInt(attributes.getValue("y")));
			this.graph.setEnd(e);
		} else if (qName.equalsIgnoreCase("obstacle")) {
			int topLeftX = Integer.parseInt(attributes.getValue("topleftx"));
			int topLeftY = Integer.parseInt(attributes.getValue("toplefty"));
			int bottomRightX = Integer.parseInt(attributes.getValue("bottomrightx"));
			int bottomRightY = Integer.parseInt(attributes.getValue("bottomrighty"));
			for(int i = topLeftX ; i <= bottomRightX ; i++){
				for( int j = topLeftY ; j <= bottomRightY ; j++){
					Edge e = new Edge(i,j);
					this.graph.getInvalidEdge().add(e);
				}
			}

		}
		
	}

	public void endElement(String uri, String localName, String qName) {
		return;
	}

	public void startParsing() {
		System.out.println("Début du parsing");
	}

	public void endParsing() {
		System.out.println(graph.getHeight());
		System.out.println(graph.getHeight());
		System.out.println(graph.getStart());
		System.out.println(graph.getEnd());
		System.out.println("Fin du parsing");
	}

	public GraphInformations getGraphInformations() {
		return graph;
	}

}
