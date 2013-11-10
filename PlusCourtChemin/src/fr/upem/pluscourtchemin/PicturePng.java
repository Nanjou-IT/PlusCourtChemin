package projetAlgo;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.ImageIO;




public class PicturePng {
	
	private final String name;
	private final GraphInformations graph;
	private final BufferedImage image;
	
	public PicturePng(String name, GraphInformations graph){
		this.name = name;
		this.graph = new GraphInformations(graph.getStart(),graph.getEnd(),(HashSet<Edge>) graph.getInvalidEdge(),graph.getHeight(),graph.getWidth());
		this.image = new BufferedImage(graph.getHeight(),graph.getWidth(),BufferedImage.TYPE_INT_RGB);
	}
	
	public void init(){
		for(int i = 0 ; i < graph.getHeight() ; i++){
			for(int j = 0 ; j < graph.getWidth() ; i++){
				image.setRGB(i, j, Color.WHITE.getRGB());
			}
		}
	}
	
	public void addStart(){
		Edge e = graph.getStart();
		image.setRGB(e.getX(), e.getY(), Color.RED.getRGB());
	}
	
	public void addEnd(){
		Edge e = graph.getEnd();
		image.setRGB(e.getX(), e.getY(), Color.RED.getRGB());
	}
	
	public void addInvalidPoints(){
		Iterator<Edge> it = graph.getInvalidEdge().iterator();
		while(it.hasNext()){
			Edge e = (Edge) it.next();
			image.setRGB(e.getX(), e.getY(), Color.BLACK.getRGB());
		}
		
	}
	
	public void saveImage(){ /* Ajouter la gestion des Exceptions */
		File outputfile = new File(name);
	    try {
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	    
   

}
