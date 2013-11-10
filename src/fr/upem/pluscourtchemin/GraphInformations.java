package fr.upem.pluscourtchemin;

import java.util.HashSet;
import java.util.Set;

public class GraphInformations {
	private Edge start;
	private Edge end;
	// private LinkedList<Edge> invalidEdge;
	private HashSet<Edge> invalidEdge;
	private int height;
	private int width;

	public GraphInformations() {
		// invalidEdge = new LinkedList<Edge>();
		invalidEdge = new HashSet<Edge>();
	}

	@SuppressWarnings("unchecked")
	// Je sais ce que je fais ;)
	public GraphInformations(Edge start, Edge end, HashSet<Edge> invalidEdge,
			int height, int width) {
		this.start = new Edge(start.getX(), start.getY());
		this.end = new Edge(end.getX(), end.getY());
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

	/*
	 * public LinkedList<Edge> getInvalidEdge() { return invalidEdge; }
	 * 
	 * public void setInvalidEdge(LinkedList<Edge> invalidEdge) {
	 * this.invalidEdge = invalidEdge; }
	 */

	public Set<Edge> getInvalidEdge() {
		return invalidEdge;
	}

	/*
	 * public void setInvalidEdge(HashSet<Edge> invalidEdge){ this.invalidEdge =
	 * invalidEdge;
	 * 
	 * }
	 */

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
