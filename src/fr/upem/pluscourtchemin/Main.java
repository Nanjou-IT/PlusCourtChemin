package fr.upem.pluscourtchemin;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// Have to handle args properly
		System.out.println("Projet d'algo !");
		String nameFileXml = "test.xml";
		
		// Parse the given file and map it into the GraphObject
		GraphInformations graphInfos = new GraphInformations();
		XMLParser parser = new XMLParser(nameFileXml, graphInfos);
		parser.parseDocument();		
		
		// TODO : ..
		// Have to check the GraphObject: borns etc..
		
		// Draw the PNG image from GraphObject and write it on disk.
		PicturePng p = new PicturePng("test.png", graphInfos);
		p.init();
		p.addPoints();
		p.saveImage();
		
		Graph graph = new Graph(graphInfos);
		graph.createGraph();
		graph.printf();
	
				

		
	
		
	}
}
