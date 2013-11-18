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
		
		String nameFileXml = "test_remi.xml";
		String namePngImage = "test.png";
		
		// Add exception into Arg parsing
//		ArgsHandler arguments = new ArgsHandler(args);
//		namePngImage = arguments.getPngOutputName();
//		nameFileXml = arguments.getXmlFileName();
		
		// Parse the given file and map it into the GraphObject
		GraphInformations graphInfos = new GraphInformations();
		XMLParser parser = new XMLParser(nameFileXml, graphInfos);
		parser.parseDocument();		
		
		
		// Draw the PNG image from GraphObject and write it on disk.
		PicturePng p = new PicturePng(namePngImage, graphInfos);
		p.init();
		p.addPoints();

		Graph graph = new Graph(graphInfos);
		graph.createGraph();
		
		System.out.println("_______________________ > "+graph.getAllVertex()); 
		
		graph.printLog();
	
		
		List<Vertex> list_successeur = Graphs.djikstra(graph, graphInfos.getStart(),graphInfos.getEnd());
		p.addShortedPath(list_successeur);
		p.saveImage();
		
		
		
		
	
		
	}
}
