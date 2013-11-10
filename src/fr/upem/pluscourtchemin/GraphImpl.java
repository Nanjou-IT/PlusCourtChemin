package fr.upem.pluscourtchemin;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GraphImpl {
	private final Edge start;
	private final LinkedList<Edge> destinations;
	
	public GraphImpl(Edge e){
		this.start = Objects.requireNonNull(e);
		this.destinations = new LinkedList<Edge>();		
	}
	
	public void addDestination(Edge e){
		Objects.requireNonNull(e);
		this.destinations.add(e);
	}
	
	public Edge getStart(){
		return this.start;
	}
	
	public List<Edge> getDestinations(){
		return this.destinations;
	}
	
	public void addDestinationEdge(Edge e){
		this.destinations.add(e);
	}
}
