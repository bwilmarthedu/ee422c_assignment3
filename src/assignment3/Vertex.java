package assignment3;
import java.util.*;

public class Vertex {

    private String label;
    private boolean visited;
    private int index;
    private Vertex previous;

    public Vertex(){

    }

    public Vertex(String label, int index){
        this.label = label;
        this.index = index;
        this.previous = null;
        visited = false;
    }

    public String getLabel(){
        return label;
    }

    public int getIndex(){
        return index;
    }

    public Vertex getPrevious(){
        return previous;
    }

    public void setPrevious(Vertex v){
        previous = v;
    }

    public void setVisited(Boolean b){
        visited = b;
    }

    public boolean isVisited(){
        return visited;
    }
}
