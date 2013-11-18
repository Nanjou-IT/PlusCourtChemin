package fr.upem.pluscourtchemin;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.LinkedBlockingQueue;

public class Graphs {
	public static List<Vertex> djikstra(Graph graph, Vertex src, Vertex dst) {
		// Predecesseurs
		HashMap<Vertex, Vertex> pi = new HashMap<>();
		// Distances
		HashMap<Vertex, Integer> d = new HashMap<>();

		// Initialisation des distances + predecesseurs
		for (Vertex vt : graph.getAllVertex()) {
			pi.put(vt, null);
			System.out.println("ADD: " + vt); 
			if (vt.equals(src)) {
				d.put(vt, 0);
			} else {
				d.put(vt, -1);
			}
		}
		
		Comparator<Vertex> shortestDistance = new Comparator<Vertex>() {
            public int compare(Vertex L, Vertex R) {
                if (d.get(L) > d.get(R)) return 1;
                if (d.get(L) < d.get(R)) return -1;
                return 0;
            }
        };

        PriorityQueue<Vertex> fifo = new PriorityQueue<Vertex>(graph.VerticesCount(), shortestDistance);
		
		// Ajout Queue
		List<Vertex> vertexList = graph.getAllVertex();
		for (Vertex v : vertexList) {
			fifo.add(v);
		}
		
		System.out.println("fifo 1: " + fifo);
//		System.out.println("fifo 2: " + fifo);
		System.out.println();
		System.out.println("dist tab: " + d);
		System.out.println();
		
		// Executer l'algo de dijsktra
		while (!fifo.isEmpty()) {
			Vertex extracted = fifo.poll();
			
			List<Vertex> listNeighbours = graph.getNeighbours(extracted);
			Collections.shuffle(listNeighbours); 
			System.out.println("Fils de "+ extracted +">    "+listNeighbours);
			for (Vertex y : listNeighbours) {
				// si deja parcouru .getViewedState() 
//				if (d.keySet().contains(y)) {
//					Iterator<Vertex> it = d.keySet().iterator();
//					continue;
//				}
//				y.setViewedStateTo(true);
				
				if (d.get(y) == null) {
					System.out.println("___ d.get("+ y +") is NULL. ");
					continue;
				}
				
				if (d.get(extracted) + Graph.WEIGHT_EDGE < d.get(y) || (d.get(y) == -1)) {
					d.put(y, d.get(extracted) + Graph.WEIGHT_EDGE);
					pi.put(y, extracted);
				}
			}
		}
		
		System.out.println("Dist : " + d); 
		System.out.println("Predecesseur : " + pi);
		
		// Mettre les Vertex dans une liste
		ArrayList<Vertex> list_successeur = new ArrayList<Vertex>();
		
		Vertex currentVertex = dst;
		
		while (!(currentVertex.equals(src))) {
			Vertex tmp = pi.get(currentVertex);
			
//			if (tmp == null) {
//				System.out.println(currentVertex + "__to__" + src);
//				System.out.println(pi.containsKey(currentVertex));
//				continue;
//			}
			System.out.println("TMP :" + tmp);
			System.out.println("Current : " + currentVertex);
			if (!(tmp.equals(src))) {
				if (list_successeur.contains(tmp)) {
					System.out.println("Erreur: boucle dans la liste des predecesseurs.");
					System.out.println(list_successeur);
					return list_successeur;
				}
				list_successeur.add(tmp);
			}
			
			currentVertex = tmp;
		}
		
		
		return list_successeur;
	}
}
