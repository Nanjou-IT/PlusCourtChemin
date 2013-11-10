package fr.upem.pluscourtchemin;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import javax.imageio.ImageIO;

public class PicturePng {
	private final String name;
	private final GraphInformations graph;
	private final BufferedImage image;
	
	public PicturePng(String name, GraphInformations graph){
		this.name = Objects.requireNonNull(name);
		this.graph = Objects.requireNonNull(graph);
		this.image = new BufferedImage(graph.getHeight(),graph.getWidth(),BufferedImage.TYPE_INT_RGB);
	}
	
	public void init(){
		for(int i = 0 ; i < graph.getHeight() ; i++){
			for(int j = 0 ; j < graph.getWidth() ; j++){
				image.setRGB(i, j, Color.WHITE.getRGB());
			}
		}
	}
	
	private void addInvalidPoints(){
		Iterator<Edge> it = graph.getInvalidEdge().iterator();
		while(it.hasNext()){
			Edge e = (Edge) it.next();
			image.setRGB(e.getX(), e.getY(), Color.BLACK.getRGB());
		}
	}

	public void addPoints() {
		Edge eStart = graph.getStart();
		image.setRGB(eStart.getX(), eStart.getY(), Color.RED.getRGB());
		
		Edge eEnd = graph.getEnd();
		image.setRGB(eEnd.getX(), eEnd.getY(), Color.RED.getRGB());
		
		addInvalidPoints();
	}
	
	/* TODO: Ajouter la gestion des Exceptions */
	public void saveImage(){ 
		File outputfile = new File(name);
	    try {
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
