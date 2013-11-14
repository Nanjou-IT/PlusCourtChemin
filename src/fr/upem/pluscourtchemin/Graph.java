package fr.upem.pluscourtchemin;

import java.util.LinkedList;
import java.util.List;


public class Graph implements GraphInterface {
	private final GraphInformations infos;
	private final LinkedList<Integer>[] array;	
	private final static int WEIGHT_EDGE = 1;

	@SuppressWarnings("unchecked")
	public Graph(GraphInformations graph) {
		this.infos = new GraphInformations(graph);
		
		LinkedList<Integer>[] tmp = new LinkedList[infos.getHeight()* infos.getWidth()];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = new LinkedList<Integer>();
		}
		this.array = tmp;
	}
	
	
	public void createGraph() {
		int height = infos.getHeight();
		int width = infos.getWidth();
		
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				LinkedList<Integer> tmp = new LinkedList<Integer>();
				
				Integer vertex = new Integer(x * height + y);
				
				// check if vertex starting point isn't an Obstacle
				if (!this.infos.getGraphObstacles().contains(vertex)) {
					addDestinations(x, y, tmp);
					array[vertex] = tmp;
				}
			}
		}
	}
	
	private void addDestinations(int x1, int y1, LinkedList<Integer> tmp){
		int height = infos.getHeight();
		int width = infos.getWidth();
		
		for (int x = x1 - 1; x <= x1 + 1; x++) {
			for (int y = y1 - 1; y <= y1 + 1; y++) {
				
				// Point is in bounds?
				if ((x >= 0 && x < height) && (y >= 0 && y < width)) {
					Integer vertex = new Integer(x * height + y);
					
					// Check if it isn't an Obstacle
					if (!infos.getGraphObstacles().contains(vertex)) { 																
						tmp.add(vertex);
					}
				}
			}
		}
	}
	
	public  boolean isObstacle(Vertex v){
		int index_list = v.getX() + infos.getHeight() + v.getY();
		if(array[index_list] == null){
			return true;
		}
		return false;
	}

	public void printf() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " -> " + array[i]);
		}		
	}
	
	@Override
	public int VerticesCount() {
		return array.length;
	}

	@Override
	public boolean hasEdge(Vertex src, Vertex dst) {
		int i_a = src.getX() + infos.getHeight() + src.getY();
		int i_b = dst.getX() + infos.getHeight() + dst.getY();		
		return array[i_a].contains(i_b);
	}

	@Override
	public List<Vertex> getNeighbours(Vertex v) {
		List<Vertex> listVertex = new LinkedList<>();
		int current_indice = v.getX() * infos.getHeight() + v.getY();
		for(Integer i : array[current_indice]){
			int c_i = i / infos.getHeight();
			int c_j = i - c_i * infos.getHeight();
			listVertex.add(new Vertex(c_i,c_j));
		}
		return listVertex;
		
	}
	
	public List<Vertex> getAllVertex(){
		List<Vertex> tmp_list = new LinkedList<>();
		for(int i=0;i<array.length;i++){
			int c_i = i / infos.getHeight();
			int c_j = i - c_i * infos.getHeight();
			tmp_list.add(new Vertex(c_i,c_j));
		}
		return tmp_list;
	}
}
