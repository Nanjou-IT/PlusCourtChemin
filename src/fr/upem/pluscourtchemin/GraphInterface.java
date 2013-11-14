package fr.upem.pluscourtchemin;

import java.util.List;

public interface GraphInterface {

	public int VerticesCount();
	public boolean hasEdge(Vertex src,Vertex dst);
	//public int getWeight(Vertex src, Vertex dst);
	//public void addEdge(Vertex src, Vertex dst);
	//public void removeEdge(Vertex src, Vertex dst);
	public List<Vertex> getNeighbours(Vertex v);
	
}
