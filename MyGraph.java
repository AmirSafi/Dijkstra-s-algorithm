import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {
	
	HashMap<Vertex, ArrayList<Edge>> graph;
	
    /**
     * Creates a MyGraph object with the given collection of vertices
     * and the given collection of edges.
     * @param v a collection of the vertices in this graph
     * @param e a collection of the edges in this graph
     */
    public MyGraph(Collection<Vertex> v, Collection<Edge> e) {
    	if(v == null || e == null) throw new IllegalArgumentException();
    	graph = new HashMap<Vertex, ArrayList<Edge>>();
    	//add all the vertices and edges
    	for(Vertex vertex:v){
    		graph.put(vertex, new ArrayList<Edge>());
    	}
    	for(Edge edge:e){
    		if(isValidEdge(edge)){
    			graph.get(edge.getSource()).add(edge);
    		}
    	}
    }//end Constructor

    /**
     * Private helper method checks if an Edge is valid. 
     * The edge should involve only vertices that are in the vertices of the graph. 
     * Edge weights should not be negative.
     * 
     * @param e Edge to be checked
     * @return true if e is a valid edge and false otherwise 
     */
    private boolean isValidEdge(Edge e){
    	//checks if the graph source and destination are valid and weight >= 0. 
    	return graph.containsKey(e.getSource()) && graph.containsKey(e.getDestination()) && e.getWeight() >= 0;
    }//end method isValidEdge
    
    /** 
     * Return the collection of vertices of this graph
     * @return the vertices as a collection (which is anything iterable)
     */
    public Collection<Vertex> vertices() {
    	return graph.keySet();
    }//end method vertices

    /** 
     * Return the collection of edges of this graph
     * @return the edges as a collection (which is anything iterable)
     */
    public Collection<Edge> edges() {
    	//Type mismatch: cannot convert from Collection<ArrayList<Edge>> to Collection<Edge>
    	graph.values().size();
    	Collection<Edge> allEdges = new ArrayList<Edge>();
    	for(ArrayList<Edge> edgeList: graph.values()){
    		for(Edge e: edgeList){
    			allEdges.add(e);		
    		}
    	}
    	return allEdges;
    }//end method edges

    /**
     * Return a collection of vertices adjacent to a given vertex v.
     *   i.e., the set of all vertices w where edges v -> w exist in the graph.
     * Return an empty collection if there are no adjacent vertices.
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices adjacent to v in the graph
     * @throws IllegalArgumentException if v does not exist.
     */
    public Collection<Vertex> adjacentVertices(Vertex v) {
    	Collection<Vertex> adjVertices = new ArrayList<Vertex>();
      	ArrayList<Edge> edges = graph.get(v);
    	for(Edge e : edges){
    		adjVertices.add(e.getDestination());
    	}
    	return adjVertices;
    }//end method adjacentVertices

    /**
     * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed graph.
     * Assumes that we do not have negative cost edges in the graph.
     * @param a one vertex
     * @param b another vertex
     * @return cost of edge if there is a directed edge from a to b in the graph, 
     * return -1 otherwise.
     * @throws IllegalArgumentException if a or b do not exist.
     */
    public int edgeCost(Vertex a, Vertex b) {
    	ArrayList<Edge> edges = graph.get(a);
    	for(Edge e : edges){
    		if(e.getDestination().equals(b)) return e.getWeight();
    	}
    	return -1;
    }//end method edgeCost

    /**
     * Returns the shortest path from a to b in the graph, or null if there is
     * no such path.  Assumes all edge weights are nonnegative.
     * Uses Dijkstra's algorithm.
     * @param a the starting vertex
     * @param b the destination vertex
     * @return a Path where the vertices indicate the path from a to b in order
     *   and contains a (first) and b (last) and the cost is the cost of 
     *   the path. Returns null if b is not reachable from a.
     * @throws IllegalArgumentException if a or b does not exist.
     */
    public Path shortestPath(Vertex a, Vertex b) {
    	if(a == null || b == null || !graph.containsKey(a) || !graph.containsKey(b)) 
    		throw new IllegalArgumentException();
    	//Find shortest path from a to b 
    	
    	return null;
    }//end method shortestPath

}//end class MyGraph
