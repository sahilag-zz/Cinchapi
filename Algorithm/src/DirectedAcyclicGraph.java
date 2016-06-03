import java.util.ArrayList;
import java.util.HashMap;

public class DirectedAcyclicGraph {
	
	
	private HashMap<String, ArrayList<String>> graph;
	
	/**
	 * Initializes an empty graph
	 */
	public DirectedAcyclicGraph(){
		graph = new HashMap<String, ArrayList<String>>();
	}
	
	/* ------------- Helper methods for addEdge() ------------------*/
	
	/**
	 * Check if there is a directed path from {@code destination} to 
	 * {@code source} and return {@code true} if there is. 
	 * If there is, this implies that adding edge
	 * {@code (source, destination)} will create a directed cycle which
	 * we do not want.
	 * 
	 * @param source
	 * @param destination
	 * @return {@code true} if there is a path from destination to source.
	 */ 
	private boolean checkCycle(String source, String destination){
		// visitedNodes stores true if reachable via depthFirstSearch()
		
		HashMap<String, Boolean> visitedNodes = new HashMap<String, Boolean>();
		for (String key : graph.keySet()) {
		    visitedNodes.put(key,false);
		}
		
		depthFirstSearch(destination, visitedNodes);
		
		if (visitedNodes.get(source) == false){
			return false;
		}
		else return true;
	}
	
	/**
	 * performs a depth first search on the graph and marks nodes as visited
	 * 
	 * @param v starting node
	 * @param visited is the Hashmap of visited nodes marked true or false
	 */
	
	private void depthFirstSearch(String v, HashMap<String, Boolean> visited){
		visited.put(v,true);
		// iterating through all nodes adjacent to v
		for (String node: graph.get(v)){
			if (visited.get(v) == false){
				depthFirstSearch(node, visited);
			}
		}
		
	}
	/**
	 * Create a new node with an empty nodes list
	 * 
	 * @param nodeName is the name of the new node to be created
	 */
	
	private void createNode(String nodeName){
		ArrayList<String> emptyList = new ArrayList<String>();
		graph.put(nodeName, emptyList);
	}
	
	
	/**
	 * Add an edge from {@code source} to {@code destination} and return
	 * {@code true} if the edge is added as a result of this function. If
	 * either {@code source} or {@code destination} does not exist, create
	 * them before adding the edge.
	
	 * @param source the name of the source node
	 * @param destination the name of the destination node
	 * @return {@code true} if the edge is added as a result of this 
	 * method call
	 */
	public boolean addEdge(String source, String destination){
		
		boolean existSource = graph.containsKey(source);
		boolean existDest = graph.containsKey(destination);
		// if one or more of the nodes don't exist
		if (!existSource || !existDest ){
			if (!existSource){
				createNode(source);
			}
			if (!existDest){
				createNode(destination);
			}
			graph.get(source).add(destination);
			return true;
		}
		// if the edge already exists return false
		else if(graph.get(source).contains(destination)){
			return false;
		}
		// check that adding the edge doesn't form a directed cycle
		else{
			if (checkCycle(source, destination) == false){
				graph.get(source).add(destination);
				return true;
			}
			else return false;
		}
	}
	
	
	/**
	 * prints the graph as an adjacency list
	 */
	public void printGraph(){
		for (String key : graph.keySet()) {
		    System.out.println(key + " " + graph.get(key));
		}
	}
	
	
	public static void main(String[] args){
		DirectedAcyclicGraph G = new DirectedAcyclicGraph();
		String source = "A"; String destination = "B";
		
		G.addEdge(source, destination);
	}

}