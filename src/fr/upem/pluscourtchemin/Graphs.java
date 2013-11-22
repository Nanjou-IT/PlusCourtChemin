package fr.upem.pluscourtchemin;

import java.util.*;

public class Graphs {
	public static List<Vertex> djikstra(Graph graph,Vertex src,Vertex dst) {	
	
		HashMap<Vertex, Vertex> pi = new HashMap<>();
		HashMap<Vertex,Integer> d = new HashMap<>();		
		HashMap<Vertex,Boolean> visited = new HashMap<>();
		
		for(Vertex vt : graph.getAllVertexWithoutObstacles()){
			pi.put(vt,null);
			visited.put(vt, false);
			if(vt.equals(src)){
				d.put(vt,0);
			} else{
				d.put(vt, Integer.MAX_VALUE);
			}
		}

		Comparator<Vertex> c = new Comparator<Vertex>(){
			@Override
			public int compare(Vertex v1, Vertex v2){
				int weigth_v1 = d.get(v1);
				int weithg_v2 = d.get(v2);
				if(weigth_v1 < weithg_v2){
					return -1;
				}
				return 1;
			}
		};
		
		PriorityQueue<Vertex> fifo = new PriorityQueue<Vertex>(c);	
		fifo.add(src);
		
				
		while(!fifo.isEmpty()){
			Vertex x = fifo.remove();
			visited.put(x, true);
			
			List<Vertex> listNeighbours = graph.getNeighbours(x);			
			
			for(Vertex y : listNeighbours){
				if(d.get(x) == Integer.MAX_VALUE || (visited.get(y)))
					continue;				
				if((d.get(x) + GraphImpl.WEIGHT_EDGE ) < d.get(y)){
					d.put(y,(d.get(x) + GraphImpl.WEIGHT_EDGE));
					pi.put(y, x);
					fifo.add(y);
				}
			
			}
		}	
	
		
		

	
		ArrayList<Vertex> list_successeur = new ArrayList<Vertex>();
		Vertex currentVertex = dst;
		
	
		while(!(currentVertex.equals(src))){
			System.out.println(currentVertex);
			Vertex tmp = (Vertex) pi.get(currentVertex);
			
			if (tmp == null) {
				System.out.println(pi);
			}
			
			if(!(tmp.equals(src))){
				list_successeur.add(tmp);
			}
			currentVertex = tmp;			
		}
		return list_successeur; 
		
		
		
		
		
		
		
	}
}
