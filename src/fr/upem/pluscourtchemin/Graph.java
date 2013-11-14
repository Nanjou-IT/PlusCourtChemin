package fr.upem.pluscourtchemin;

import java.util.Iterator;
import java.util.LinkedList;


public class Graph {
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
	
	private void removeIllegalEdge(int i, int j) { // C'est a finir
		
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

	public int numberVertex() {
		return list.length;
	}

	public boolean existEdge(Vertex a, Vertex b) {
		int i_a = a.getX() + infos.getHeight() + a.getY();
		int i_b = b.getX() + infos.getHeight() + a.getY();
		
		return list[i_a].contains(i_b);
	}

	public void printf() {
		for (int i = 0; i < list.length; i++) {
			System.out.println(i + " -> " + list[i]);
		}
	}

}
