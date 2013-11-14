package fr.upem.pluscourtchemin;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


public class Graphs {
	public static void djikstra(Graph graph,Vertex v){
		//TODO
		
		int nb_vertex = graph.VerticesCount();
		LinkedBlockingQueue<Vertex> fifo = new LinkedBlockingQueue<Vertex>(graph.getAllVertex());
		HashMap<Object, Object> pi = new HashMap<>();
		HashMap<Vertex,Integer> d = new HashMap<>();
		
		
		
		
		//Initialisation
		for(Vertex vt : fifo){
			pi.put(vt,null);
			if(vt.equals(v)){
				d.put(vt,Integer.MAX_VALUE);
			} else{
				d.put(vt, 0);
			}
		}
		
		// Executer l'algo de dijsktra
		while(!fifo.isEmpty()){
			Vertex x = fifo.poll();
			for(Vertex y : graph.getNeighbours(x)){
				
			}
		}
		
		
	}
}
