package fr.upem.pluscourtchemin;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


public class Graphs {
	public static void djikstra(Graph graph,Vertex v){
		//TODO
		int nb_vertex = graph.VerticesCount();
		LinkedBlockingQueue<Vertex> fifo = new LinkedBlockingQueue<Vertex>(graph.getAllVertex());
		Vertex[] pi = new Vertex[nb_vertex];
		Integer[] d = new Integer[nb_vertex];
		for(Vertex vt : fifo){
			if(vt.equals(v)){
				
			} else{
				
			}
		}
		
		
	}
}
