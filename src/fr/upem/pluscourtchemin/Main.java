package fr.upem.pluscourtchemin;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		System.out.println("Projet d'algo");
		String nameFileXml = "test.xml";
		
		
		XMLParser w = new XMLParser(nameFileXml);
		w.parseDocument();		
		
		
		GraphInformations g = w.getGraphInformations();
		PicturePng p = new PicturePng("test",g);
		p.init();
		p.addEnd();
		p.addStart();
		p.addInvalidPoints();
		p.saveImage();
		
		Graph graph = new Graph(g);
		graph.affiche();
		
		
		

	
	}
}
