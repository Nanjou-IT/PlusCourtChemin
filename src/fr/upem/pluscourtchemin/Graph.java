package fr.upem.pluscourtchemin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	// Il faut qu'on voit les autres structures possibles
	//private final GraphImpl[] list ;
	// Why Not : SortedMap
	HashMap<Vertex,List<Vertex>> map ;
	
	public Graph(){
		//list = new GraphImpl[graph.getHeight() * graph.getWidth() - graph.getInvalidEdge().size() + 1];*
		map = new HashMap<Vertex,List<Vertex>>();
	}
	
	/*
	 *  Bordure ? Obstacle ? Vertex d'arrivé ?
	 *  
	 * 			*  *  *
	 * 	 		*  V  *
	 *  		*  *  *
	 */
	public void createGraph(GraphInformations graph){
		int compteur = 0;

		for (int i = 0; i < graph.getHeight(); i++) {
			for (int j = 0; j < graph.getWidth(); j++) {
				
				Vertex e = new Vertex(i, j);
				// Edge is not an obstacle, so it is possible to reach it 
				if (!(graph.getInvalidEdge().contains(e))) {
					// Edge 'e' is a starting edge
					//list[compteur] = new GraphImpl(e);
					
					
					List<Vertex> tmp =  new LinkedList<Vertex>();
					
					for (int k = i - 1; k <= i + 1; k++) {
						for (int l = j - 1; l <= j + 1; l++) {
							if ((k >= 0 && k < graph.getHeight()) && (l >= 0	&& l < graph.getWidth())  ) { // Check Range
								tmp.add(new Vertex(i,j));								
							}
						}
					}
					map.put(e, tmp);
					compteur++;
				}
			}
		}
	}
	
	public int numberEdge() {
		return map.size();
	}
	
	
	public boolean exist(Vertex a, Vertex b) {
		return false;
	}
	
	public void addEdge(Vertex a, Vertex b) { 
		
	}
	
	// Debug
	public void print(){
		 Iterator it = map.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry m = (Map.Entry)it.next();
		        System.out.println(m.getKey() + " => " + m.getValue());
		        }
	}

	
}
