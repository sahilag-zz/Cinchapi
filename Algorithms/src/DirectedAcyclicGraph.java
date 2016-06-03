import java.util.ArrayList;
import java.util.HashMap;

public class DirectedAcyclicGraph {
	
	
	private HashMap<String, ArrayList<String>> edges = new HashMap<String, ArrayList<String>>();
	
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
		
		return false;
	}
	
	
	/**
	 * Create a new node with an empty nodes list
	 * 
	 * @param vertex
	 */
	
	private void createNode(String nodeName){
		
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
		
    	 return false;
	}

}