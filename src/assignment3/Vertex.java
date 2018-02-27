package assignment3;
import java.util.*;

public class Vertex {

    private String label;
    private int visited;

    public Vertex(String label){
        this.label = label;
        visited = 0;
    }

    public String getLabel(){
        return label;
    }
}
