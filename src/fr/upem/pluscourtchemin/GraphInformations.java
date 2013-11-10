package fr.upem.pluscourtchemin;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphInformations {
	private Edge start;
	private Edge end;
	private final HashSet<Edge> invalidEdge;
	private int height;
	private int width;

	public GraphInformations() {
		this.start = new Edge();
		this.end = new Edge();
		this.height = 0;
		this.width = 0;
		this.invalidEdge = new HashSet<Edge>();
	}

	// Je sais ce que je fais ;)
	@SuppressWarnings("unchecked")
	public GraphInformations(Edge start, Edge end, HashSet<Edge> invalidEdge, int height, int width) {
		Objects.requireNonNull(invalidEdge);
		this.start = Objects.requireNonNull(start);
		this.end = Objects.requireNonNull(end);
		this.height = height;
		this.width = width;
		this.invalidEdge = (HashSet<Edge>) invalidEdge.clone();
	}

	public Edge getStart() {
		return start;
	}

	public void setStart(Edge start) {
		this.start = start;
	}

	public Edge getEnd() {
		return end;
	}

	public void setEnd(Edge end) {
		this.end = end;
	}

	public Set<Edge> getInvalidEdge() {
		return invalidEdge;
	}
	
	public void addInvalidEdge(Edge e) {
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
