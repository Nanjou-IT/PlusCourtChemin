package fr.upem.pluscourtchemin;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GraphImpl {
	private final Vertex start;
	private final LinkedList<Vertex> destinations;
	
	public GraphImpl(Vertex e){
		this.start = Objects.requireNonNull(e);
		this.destinations = new LinkedList<Vertex>();		
	}
	
	public void addDestination(Vertex e){
		Objects.requireNonNull(e);
		this.destinations.add(e);
	}
	
	public Vertex getStart(){
		return this.start;
	}
	
	public List<Vertex> getDestinations(){
		return this.destinations;
	}
	
	public void addDestinationVertex(Vertex e){
		this.destinations.add(e);
	}
}
