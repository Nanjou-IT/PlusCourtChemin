package fr.upem.pluscourtchemin;

import java.util.List;

public interface Graph {

	public int VerticesCount();
	public boolean hasEdge(Vertex src,Vertex dst);
	public List<Vertex> getNeighbours(Vertex v);
	public List<Vertex> getAllVertexWithoutObstacles();
	public List<Vertex> getAllVertex();
	
	/*
	 * addEdge and removeEdge are not used in this project
	 */
}
