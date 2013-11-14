package fr.upem.pluscourtchemin;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Graph implements GraphInterface{
	private final GraphInformations infos;
	private final LinkedList<Integer>[] list;

	@SuppressWarnings("unchecked")
	public Graph(GraphInformations graph) {
		this.infos = new GraphInformations(graph);
		LinkedList<Integer>[] tmp = new LinkedList[infos.getHeight()* infos.getWidth()];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = new LinkedList<Integer>();
		}
		this.list = tmp;
	}
	
	
	private void checkBound(int i, int j,LinkedList<Integer> tmp){
		for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				int t = k * infos.getHeight() + l;
				if ((k >= 0 && k < infos.getHeight()) && (l >= 0 && l < infos.getWidth()) && t != i * infos.getHeight() + j) { 																
					tmp.add(k * infos.getHeight() + l);
				}
			}
		}
	}
	
	private void removeIllegalEdge(int i, int j) { 
		
		int current_index = i * infos.getHeight() + j;
		if (infos.getInvalidVertex().contains(new Vertex(i, j))) {
			list[current_index] = null;
		}
		if (list[current_index] != null) {
			Iterator<Integer> it = list[current_index].iterator();
			while(it.hasNext()){
				Integer p = it.next();
				int c_i = p / infos.getHeight();
				int c_j = p - c_i * infos.getHeight();
			
				if (infos.getInvalidVertex().contains(new Vertex(c_i, c_j)))
					it.remove();
			}
		}

	}

	public void createGraph() {
		for (int i = 0; i < infos.getHeight(); i++) {
			for (int j = 0; j < infos.getWidth(); j++) {
				LinkedList<Integer> tmp = new LinkedList<Integer>();
				checkBound(i, j, tmp);
				list[i * infos.getHeight() + j] = tmp;
				removeIllegalEdge(i, j);
			}
		}
	}
	
	public  boolean isObstacle(Vertex v){
		int index_list = v.getX() + infos.getHeight() + v.getY();
		if(list[index_list] == null){
			return true;
		}
		return false;
	}

	public void printf() {
		for (int i = 0; i < list.length; i++) {
			System.out.println(i + " -> " + list[i]);
		}		
	}
	
	@Override
	public int VerticesCount() {
		return list.length;
	}

	@Override
	public boolean hasEdge(Vertex src, Vertex dst) {
		int i_a = src.getX() + infos.getHeight() + src.getY();
		int i_b = dst.getX() + infos.getHeight() + dst.getY();		
		return list[i_a].contains(i_b);
	}

	@Override
	public List<Vertex> getNeighbours(Vertex v) {
		List<Vertex> listVertex = new LinkedList<>();
		int current_indice = v.getX() * infos.getHeight() + v.getY();
		for(Integer i : list[current_indice]){
			int c_i = i / infos.getHeight();
			int c_j = i - c_i * infos.getHeight();
			listVertex.add(new Vertex(c_i,c_j));
		}
		return listVertex;
		
	}
	
	public List<Vertex> getAllVertex(){
		List<Vertex> tmp_list = new LinkedList<>();
		for(int i=0;i<list.length;i++){
			int c_i = i / infos.getHeight();
			int c_j = i - c_i * infos.getHeight();
			tmp_list.add(new Vertex(c_i,c_j));
		}
		return tmp_list;
	}
	
	

}
