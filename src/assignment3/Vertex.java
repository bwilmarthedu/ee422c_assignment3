package assignment3;
import java.util.*;

public class Vertex {

    private String label;
    private boolean visited;
    private int index;
    private Vertex previous;

    /**
     * Creates an empty vertex
     */
    public Vertex(){

    }

    /**
     * Creates a Vertex to represent the String label at a given index
     * @param label the String to be represented by this Vertex
     * @param index int, the index of this Vertex
     */
    public Vertex(String label, int index){
        this.label = label;
        this.index = index;
        this.previous = null;
        visited = false;
    }

    /**
     * Gets the label of a Vertex
     * @return int, the label of the Vertex
     */
    public String getLabel(){
        return label;
    }

    /**
     * Gets the index of a Vertex
     * @return int, the index of the Vertex
     */
    public int getIndex(){
        return index;
    }

    /**
     * Gets the parent Vertex of a Vertex
     * @return the parent Vertex of the Vertex
     */
    public Vertex getPrevious(){
        return previous;
    }

    /**
     * Sets the parent Vertex of a Vertex
     * @param v the parent Vertex
     */
    public void setPrevious(Vertex v){
        previous = v;
    }

    /**
     * Sets the visited variable of a Vertex to boolean value b
     * @param b boolean, value to set the visited variable to
     */
    public void setVisited(Boolean b){
        visited = b;
    }

    /**
     * Gets the visited variable of a Vertex
     * @return boolean, the value of the visited variable
     */
    public boolean isVisited(){
        return visited;
    }
}
