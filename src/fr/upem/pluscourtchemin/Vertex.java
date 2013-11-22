package fr.upem.pluscourtchemin;

import java.util.Objects;

public class Vertex {
	private final int x;
	private final int y;
	
	public Vertex(int x, int y){
		if(x < 0 || y < 0){
			throw new IllegalArgumentException("The points in vertex must be positive");
		}
		this.x = x;
		this.y = y;
	}
	
	public Vertex(Vertex v){	
		Objects.requireNonNull(v);
		this.x = v.x;
		this.y = v.y;
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
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Vertex)){
			return false;
		}
		Vertex e = (Vertex)o;
		return this.x == e.x && this.y == e.y;		
	}
	
	@Override
	public String toString(){
		return "Vertex " + this.x + " : " + this.y; 
	}
	
	@Override 
	public int hashCode(){
		  int hash = 7;
		  hash = 71 * hash + this.x;
		  hash = 71 * hash + this.y;
		  return hash;
	}
}
