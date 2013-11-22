package fr.upem.pluscourtchemin;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// Have to handle args properly
		System.out.println("Projet d'algo !");
		
		String nameFileXml = "labygrand2.xml";
		String namePngImage = "test.png";
		// Chek GetNeighbours avec les obstacles
		
		// Parse the given file and map it into the GraphObject
		GraphInformations graphInfos = new GraphInformations();
		XMLParser parser = new XMLParser(nameFileXml, graphInfos);
		parser.parseDocument();		
		
				
		// Draw the PNG image from GraphObject and write it on disk.
		PicturePng p = new PicturePng(namePngImage, graphInfos);
		p.init();
		p.addPoints();
		
		Graph graph = GraphFactory.getGraph(graphInfos);		
		
		Vertex start = graphInfos.getStart();
		Vertex end = graphInfos.getEnd();	
		
		List<Vertex> list = Graphs.djikstra(graph,start,end);
		p.addShortedPath(list);
		p.saveImage();
		
		System.out.println("Done.");
		
	
		
	}
}
