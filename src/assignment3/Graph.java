package assignment3;
import java.util.*;

public class Graph {

    private ArrayList<ArrayList<Vertex>> map = new ArrayList<ArrayList<Vertex>>();

    /**
     * Creates an empty graph
     */
    public Graph(){
    }

    /**
     * Adds a vertex to the Graph
     * @param label the word that this vertex represents
     */
    public void addVertex(String label){
        int index = map.size();
        map.add(new ArrayList<Vertex>());
        map.get(map.size()-1).add(new Vertex(label, index));
    }

    /**
     * Adds an edge between vertices v1 and v2
     * @param v1 Vertex v1
     * @param v2 Vertex v2
     */
    public void addEdge(Vertex v1, Vertex v2){
        getAdjacencyList(v1).add(v2);
    }

    /**
     * Gets the adjacency list for a given Vertex v
     * @param v
     * @return returns the adjacency list of v
     */
    public ArrayList<Vertex> getAdjacencyList(Vertex v) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).get(0).equals(v)) { // If
                return map.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the ith vertex in the graph
     * @param i index
     * @return ith vertex of the graph, returns null if a vertex does not exist at index i
     */
    public Vertex getVertex(int i){
        return map.get(i).get(0);
    }

    /**
     * Gets the vertex that represents String s
     * @param s String
     * @return the Vertex that represents String s, returns null if a Vertex for String s does not exist.
     */
    public Vertex getVertex(String s){
        for(int i = 0; i < map.size(); i++){
            if(map.get(i).get(0).getLabel().equals(s)){
                return map.get(i).get(0);
            }
        }
        return null;
    }

}
