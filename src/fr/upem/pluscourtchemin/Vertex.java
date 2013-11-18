package fr.upem.pluscourtchemin;

import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
	private final int x;
	private final int y;
	private boolean parcouru;
	private int distance;
	
	public Vertex(int x, int y){
		if(x < 0 || y < 0){
			throw new IllegalArgumentException("The points in vertex must be positive");
		}
		this.x = x;
		this.y = y;
		this.distance = -1;
		this.parcouru = false;
	}
	
	public Vertex(Vertex v){	
		Objects.requireNonNull(v);
		this.x = v.x;
		this.y = v.y;
		this.distance = 0;
		this.parcouru = false;
	}
	
	public Vertex() {
		this(0,0);
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setViewedStateTo(boolean state) {
		this.parcouru = state;
	}
	
	public boolean getViewedState() {
		return this.parcouru;
	}
	
	public int getDistance(){
		return this.distance;
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Vertex)){
			return false;
		}
		Vertex e = (Vertex)o;
		return this.x == e.x && this.y == e.y && this.distance == e.distance && this.parcouru == e.parcouru;		
	}
	
	@Override
	public String toString(){
		return "[Vertex " + this.x + " : " + this.y + " p:"+this.parcouru+" dist:"+this.distance+"] "; 
	}
	
	@Override 
	public int hashCode(){
		return 10 * x + y;		
	}

	@Override
	public int compareTo(Vertex o) {
		return 0;
	}
}
