package fr.upem.pluscourtchemin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	private final GraphInformations infos;
	private final LinkedList<Integer>[] list ;
	
	@SuppressWarnings("unchecked")
	public Graph(GraphInformations graph){
		this.infos = new GraphInformations(graph);				
		LinkedList<Integer>[] tmp = new LinkedList[infos.getHeight() * infos.getWidth()];
		for(int i =0 ; i < tmp.length ; i++){
			tmp[i] = new LinkedList<Integer>();
		}		
		this.list = tmp;
	}
	
	/*
	 *  Bordure ? Obstacle ? Vertex d'arriv� ?
	 *  
	 * 			*  *  *
	 * 	 		*  V  *
	 *  		*  *  *
	 */
	public void createGraph(){

		for (int i = 0; i < infos.getHeight(); i++) {
			for (int j = 0; j < infos.getWidth(); j++) {
				
				Vertex e = new Vertex(i, j);
				// Edge is not an obstacle, so it is possible to reach it 
				if (!(infos.getInvalidEdge().contains(e))) {
					// Edge 'e' is a starting edge
					//list[compteur] = new GraphImpl(e);
					
					
					LinkedList<Integer> tmp =  new LinkedList<Integer>();
					
					for (int k = i - 1; k <= i + 1; k++) {
						for (int l = j - 1; l <= j + 1; l++) {
							if ((k >= 0 && k < infos.getHeight()) && (l >= 0	&& l < infos.getWidth())  ) { // Check Range
								tmp.add(k*infos.getHeight()+l);
								
							}
						}
					}
					list[i*infos.getHeight()+j] = tmp;
				}
			}
		}
	}
	
	public int numberVertex() {
		return list.length;
	}
	
	
	public boolean exist(Vertex a, Vertex b) {
		return false;
	}
	
	public void printf(){
		for(int i = 0; i<list.length;i++){
			System.out.println(i + " -> " +list[i]);
		}
	}
	

	

	
}
