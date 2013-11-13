package fr.upem.pluscourtchemin;

public class Graph {
	// Il faut qu'on voit les autres structures possibles
	private final GraphImpl[] list ;
	
	public Graph(){
		//list = new GraphImpl[graph.getHeight() * graph.getWidth() - graph.getInvalidEdge().size() + 1];
		list = new GraphImpl[100];
	}
	
	/*
	 *  Bordure ? Obstacle ? Edge d'arrivé ?
	 *  
	 * 			*  *  *
	 * 	 		*  E  *
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
					list[compteur] = new GraphImpl(e);
					
					for (int k = i - 1; k <= i + 1; k++) {
						for (int l = j - 1; l <= j + 1; l++) {
							if ((k >= 0 && k < graph.getHeight()) && (l >= 0	&& l < graph.getWidth())  ) { // Check Range
								// On enleve le cas ou est identique a nous meme
								list[compteur].addDestinationVertex(new Vertex(k, l));
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
	
	
	public boolean exist(Vertex a, Vertex b) {
		return false;
	}
	
	public void addEdge(Vertex a, Vertex b) { 
		
	}
	
	// Debug
	public void print(){
		for(GraphImpl gp : list){
			System.out.println(gp.getStart() + " -> " + gp.getDestinations());
		}
	}

	
}
