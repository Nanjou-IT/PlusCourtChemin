package fr.upem.pluscourtchemin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;


public class GraphImpl implements Graph {
	private final GraphInformations infos;
	private final LinkedList<Integer>[] array;	
	public final static int WEIGHT_EDGE = 1;

	@SuppressWarnings("unchecked")
	public GraphImpl(GraphInformations graph) {
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
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				//Debug
				Vertex v = new Vertex(x,y);
				LinkedList<Integer> tmp = new LinkedList<Integer>();
				int vertex = x + width * y;		

				if (!(this.infos.getInvalidVertex().contains(v))) {
					addDestinations(x, y, tmp);
					array[vertex] = tmp;
				}
			}
		}
	}
	
	private void addDestinations(int x1, int y1, LinkedList<Integer> tmp){
		int height = infos.getHeight();
		int width = infos.getWidth();		
		int current_vertex = x1 + y1 * width;		
		
		for (int y = y1 - 1; y <= y1 + 1; y++) {
			for (int x = x1 - 1; x <= x1 + 1; x++) {
				// Point is in bounds?
				if ((x >= 0 && x < width) && (y >= 0 && y < height)) {
					Vertex v = new Vertex(x,y);
					int vertex = x + y * width;					
					// Check if it isn't an Obstacle
					if((!infos.getInvalidVertex().contains(v)) && vertex != current_vertex){
						tmp.add(vertex);
					}
				}
			}
		}
	}
	
	public  boolean isObstacle(Vertex v){
		int index_list = v.getX() + v.getY() * infos.getWidth();
		if(array[index_list] == null){
			return true;
		}
		return false;
	}

	public void printLog() throws IOException {
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("log.txt")));
		for (int i = 0; i < array.length; i++) {
			writer.println(i + " -> " + array[i]);
		}		
		writer.close();	
	}
	
	@Override
	public int VerticesCount() {
		return array.length;
	}

	@Override
	public boolean hasEdge(Vertex src, Vertex dst) {
		int i_a = src.getX() + infos.getWidth() + src.getY();
		int i_b = dst.getX() + infos.getWidth() + dst.getY();		
		return array[i_a].contains(i_b);
	}

	@Override
	public List<Vertex> getNeighbours(Vertex v) {
		List<Vertex> listVertex = new LinkedList<>();
		int current_indice = v.getX() + infos.getWidth() * v.getY();
		for(Integer i : array[current_indice]){
			int c_j = i / infos.getWidth();
			int c_i = i - c_j * infos.getWidth();
			listVertex.add(new Vertex(c_i,c_j));
		}
		return listVertex;
		
	}
	
	public List<Vertex> getAllVertex(){

		List<Vertex> tmp_list = new LinkedList<>();
		for(int i=0;i<array.length;i++){
			int c_j = i / infos.getWidth();
			int c_i = i - c_j * infos.getWidth();
			tmp_list.add(new Vertex(c_i,c_j));
		}
		return tmp_list;
	}
	
	public List<Vertex> getAllVertexWithoutObstacles(){
		List<Vertex> tmp_list = new LinkedList<>();
		for(int i =0;i<array.length;i++){
			if(!(array[i].isEmpty())){
				int c_j = i / infos.getWidth();
				int c_i = i - c_j * infos.getWidth();
				tmp_list.add(new Vertex(c_i,c_j));
			}		
		}
		return tmp_list;
	}







}
