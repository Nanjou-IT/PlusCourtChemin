package fr.upem.pluscourtchemin;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class GraphInformations {
	private Vertex start;
	private Vertex end;
	private final HashSet<Vertex> invalidVertex;
	private int height;
	private int width;

	public GraphInformations() {
		this.start = new Vertex();
		this.end = new Vertex();
		this.height = 0;
		this.width = 0;
		this.invalidVertex = new HashSet<Vertex>();
	}
	
	@SuppressWarnings("unchecked")
	public GraphInformations(GraphInformations graph){
		Objects.requireNonNull(graph);
		this.start = new Vertex(graph.getStart());
		this.end = new Vertex(graph.getEnd());
		this.height = graph.height;
		this.width = graph.width;	
		this.invalidVertex = (HashSet<Vertex>) graph.invalidVertex.clone();
	}

	public Vertex getStart() {
		return start;
	}

	public void setStart(Vertex start) {
		this.start = start;
	}

	public Vertex getEnd() {
		return end;
	}

	public void setEnd(Vertex end) {
		this.end = end;
	}

	public Set<Vertex> getInvalidVertex() {
		return invalidVertex;
	}
	
	public void addInvalidVertex(Vertex e) {
		this.invalidVertex.add(e);
	}

	/**
	 * Method that converts an image representation (x,y) to a graph 
	 * representation of the obstacles present in the image.
	 * 
	 * @return List of obstacles corresponding to a graph view
	 */
	public LinkedList<Integer> getGraphObstacles() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		int height = this.height;
		for (Vertex v : this.invalidVertex) {
			if (v == null) {
				continue;
			}
			
			list.add(v.getX() * height + v.getY());
		}
		
		return list;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int widht) {
		this.width = widht;
	}

	public String toString() {
		return "Height : " + this.height + "Width : " + this.width;
	}

}
