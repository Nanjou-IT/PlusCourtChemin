package fr.upem.pluscourtchemin;


public class Graph {
	
	GraphImpl[] list ;
	
	@SuppressWarnings("unchecked")
	public Graph(GraphInformations graph){
		//list = new GraphImpl[graph.getHeight() * graph.getWidth() - graph.getInvalidEdge().size() + 1];
		list = new GraphImpl[100];
		createGraph(graph);
	}
	
	private void createGraph(GraphInformations graph){
		
	
		int compteur = 0;
		
	
		for (int i = 0; i < graph.getHeight(); i++) {
			for (int j = 0; j < graph.getWidth(); j++) {
				Edge e = new Edge(i, j);
				if (!(graph.getInvalidEdge().contains(e))) {
					list[compteur] = new GraphImpl(e);
					
					
					for (int k = i - 1; k <= i + 1; k++) {
						for (int l = j - 1; l <= j + 1; l++) {
							if ((k >= 0 && k < graph.getHeight()) && (l >= 0	&& l < graph.getWidth())) { // Check Range
								// On enleve le cas ou est identique a nous meme
								list[compteur].getDestinations().add(new Edge(k, l));
							}
						}
					}
					compteur++;
				}
			}
		}
	}
	
	public int numberEdge() {
		return list.length;
	}
	
	
	public boolean exister(Edge a,Edge b) {
		return false;
	}
	
	public void ajouterArc(Edge a,Edge b) { 
		
	}
	// Debug
	public void affiche(){
		for(GraphImpl gp : list){
			System.out.println(gp.getStart() + " -> " + gp.getDestinations());
		}
	}

	
}
