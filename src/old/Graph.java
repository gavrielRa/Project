package old;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
	/**
	 * the string is the key
	 * the LinkedHashSet is the value 
	 */
    private Map<String, LinkedHashSet<String>> map = new HashMap<String, LinkedHashSet<String>>();

    

    
    /**
     * adjacent is the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     * 
     * @param node1 - number
     * @param node2 - number
     */
    public void addEdge(String node1, String node2) {

    	LinkedHashSet<String> adjacent = map.get(node1);
        
    	//if node1 is not in the map, create new LinkedHashSet and node1 will be the head.
        if(adjacent==null) {
            adjacent = new LinkedHashSet<String>();
            map.put(node1, adjacent);
        }
     
        adjacent.add(node2);
    }
    
    /**
     * method that build a new graph
     * 
     * @param matNeighbor - matrix
     * @return - graph
     */
    public Graph buildGraph (int [][] matNeighbor){
    	
    	Graph graph = new Graph();
    	for (int i = 0; i < matNeighbor.length; i++) {
			for (int j = 0; j < matNeighbor[0].length; j++) {
				if(matNeighbor[i][j]==1) graph.addEdge((i+""), (j+""));
			}
		}
    	return graph;
    }
    /**
     * method that check if last is in the map
     * if yes - return a new LinkedList with last is the head
     * if no - return a new LinkedList. 
     * @param last - number
     * @return a new LinkedList
     */
    public LinkedList<String> adjacentNodes(String last) {
        LinkedHashSet<String> adjacent = map.get(last);
        if(adjacent==null) {
            return new LinkedList<String>();
        }
        return new LinkedList<String>(adjacent);
    }
    
    /**
     * print the graph
     */
    public void printGraph () {
		for (int i = 0; i < map.size(); i++) {
			System.out.println(map.toString());
		}
	}
    
//    public void addTwoWayVertex(String node1, String node2) {
//        addEdge(node1, node2);
//        addEdge(node2, node1);
//    }

//    public boolean isConnected(String node1, String node2) {
//        Set adjacent = map.get(node1);
//        if(adjacent==null) {
//            return false;
//        }
//        return adjacent.contains(node2);
//    }




    
    
}