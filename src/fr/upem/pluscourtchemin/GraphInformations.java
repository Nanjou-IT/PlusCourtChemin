package fr.upem.pluscourtchemin;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphInformations {
	private Vertex start;
	private Vertex end;
	private final HashSet<Vertex> invalidEdge;
	private int height;
	private int width;

	public GraphInformations() {
		this.start = new Vertex();
		this.end = new Vertex();
		this.height = 0;
		this.width = 0;
		this.invalidEdge = new HashSet<Vertex>();
	}
	
	@SuppressWarnings("unchecked")
	public GraphInformations(GraphInformations graph){
		this.start = new Vertex(graph.getStart());
		this.end = new Vertex(graph.getEnd());
		this.height = graph.height;
		this.width = graph.width;	
		this.invalidEdge = (HashSet<Vertex>) graph.invalidEdge.clone();
	}

	// Je sais ce que je fais ;) ... -> A delete
	@SuppressWarnings("unchecked")
	public GraphInformations(Vertex start, Vertex end, HashSet<Vertex> invalidEdge, int height, int width) {
		Objects.requireNonNull(invalidEdge);
		this.start = Objects.requireNonNull(start);
		this.end = Objects.requireNonNull(end);
		this.height = height;
		this.width = width;
		this.invalidEdge = (HashSet<Vertex>) invalidEdge.clone();
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

	public Set<Vertex> getInvalidEdge() {
		return invalidEdge;
	}
	
	public void addInvalidEdge(Vertex e) {
		this.invalidEdge.add(e);
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
