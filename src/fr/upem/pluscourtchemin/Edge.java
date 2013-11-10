package fr.upem.pluscourtchemin;

public class Edge {
	private final int x;
	private final int y;
	
	public Edge(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Edge() {
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
		if(!(o instanceof Edge)){
			return false;
		}
		Edge e = (Edge)o;
		return this.x == e.x && this.y == e.y;		
	}
	
	@Override
	public String toString(){
		return "Edge > " + this.x + " : " + this.y; 
	}
}
