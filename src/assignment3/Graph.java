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
        map.add(new ArrayList<Vertex>());
        map.get(map.size()-1).add(new Vertex(label));
    }

    public void addEdge(Vertex v1, Vertex v2){
        getAdjacencyList(v1).add(v2);
    }

    public ArrayList<Vertex> getAdjacencyList(Vertex v) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).get(0).equals(v)) {
                return map.get(i);
            }
        }
        return null;
    }

    public ArrayList. getGraph(){
        return map;
    }
}
