package fr.upem.pluscourtchemin;

public class GraphFactory {
	public static Graph getGraph(GraphInformations graph){
		GraphImpl g = new GraphImpl(graph);
		g.createGraph();
		return g;
	}
}
