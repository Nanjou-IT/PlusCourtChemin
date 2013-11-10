package fr.upem.pluscourtchemin;

import java.util.LinkedList;
import java.util.List;

public class GraphImpl {
	private final Edge start;
	private final LinkedList<Edge> destinations;
	
	public GraphImpl(Edge e){
		this.start = new Edge(e.getX(),e.getY());
		this.destinations = new LinkedList<Edge>();		
	}
	
	public void addDestination(Edge e){
		this.destinations.add(new Edge(e.getX(),e.getY()));
	}
	
	public Edge getStart(){
		return this.start;
	}
	
	public List<Edge> getDestinations(){
		return this.destinations;
	}
}
