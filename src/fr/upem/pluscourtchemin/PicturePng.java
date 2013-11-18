package fr.upem.pluscourtchemin;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.imageio.ImageIO;

public class PicturePng {
	private final String name;
	private final GraphInformations graph;
	private final BufferedImage image;
	
	public PicturePng(String name, GraphInformations graph){
		this.name = Objects.requireNonNull(name);
		this.graph = Objects.requireNonNull(graph);
		this.image = new BufferedImage(graph.getWidth(),graph.getHeight(),BufferedImage.TYPE_INT_RGB);
		System.out.println("h: "+graph.getHeight() + " w:" + graph.getWidth()); 
	}
	
	public void init(){
		for(int i = 0 ; i < graph.getWidth() ; i++){
			for(int j = 0 ; j < graph.getHeight() ; j++){
				image.setRGB(i, j, Color.WHITE.getRGB());
			}
		}
	}
	
	private void addInvalidPoints(){
		Iterator<Vertex> it = graph.getInvalidVertex().iterator();
		while(it.hasNext()){
			Vertex e = (Vertex) it.next();
			image.setRGB(e.getX(), e.getY(), Color.BLACK.getRGB());
		}
	}

	public void addPoints() {
		Vertex eStart = graph.getStart();
		image.setRGB(eStart.getX(), eStart.getY(), Color.RED.getRGB());
		
		Vertex eEnd = graph.getEnd();
		System.out.println(eEnd); 
		image.setRGB(eEnd.getX(), eEnd.getY(), Color.RED.getRGB());
		
		addInvalidPoints();
	}
	
	public void addShortedPath(List<Vertex> list){
		for(Vertex v : list){
			image.setRGB(v.getX(), v.getY(), Color.MAGENTA.getRGB());
		}
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
