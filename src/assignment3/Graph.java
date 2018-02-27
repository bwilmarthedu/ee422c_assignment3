package assignment3;
import java.util.*;

public class Graph {

    private ArrayList<ArrayList<Vertex>> map = new ArrayList<ArrayList<Vertex>>();

    /**
     * Creates an empty graph
     */
    public Graph(){
    }

    public void addVertex(String label){
        int index = map.size();
        map.add(new ArrayList<Vertex>());
        map.get(map.size()-1).add(new Vertex(label, index));
    }

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

    public Vertex getVertex(int i){
        return map.get(i).get(0);
    }

    public Vertex getVertex(String s){
        for(int i = 0; i < map.size(); i++){
            if(map.get(i).get(0).getLabel().equals(s)){
                return map.get(i).get(0);
            }
        }
        return null;
    }

}
