package projetAlgo;

public class Edge {
	private final int x;
	private final int y;
	
	public Edge(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	@Override
	public String toString(){
		return "Edge " + this.x + " : " + this.y; 
	}
}
