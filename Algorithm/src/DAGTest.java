import static org.junit.Assert.*;

import org.junit.Test;


public class DAGTest {

	@Test
	public void testAddEdge() {
		DirectedAcyclicGraph G = new DirectedAcyclicGraph();
		
		boolean result = G.addEdge("a", "b");
		assertEquals(true, result);
		result = G.addEdge("a", "b"); // should not add edge if it exists
		assertEquals(false, result);
		result = G.addEdge("b", "c"); 
		assertEquals(true, result);
		result = G.addEdge("c", "d");
		assertEquals(true, result);
		result = G.addEdge("d", "a"); // creating a directed cycle on adding the edge
		assertEquals(false, result);
	}

}
