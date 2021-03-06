/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * Brian Wilmarth
 * bw24274
 * 15455
 * Slip days used: n/a
 * Git URL: https://github.com/bwilmarthedu/ee422c_assignment3.git
 * Spring 2018
 */


package assignment3;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner kb;	// input Scanner for commands
        PrintStream ps;	// output file, for student testing and grading only
        // If arguments are specified, read/write from/to files instead of Std IO.
        if (args.length != 0) {
            kb = new Scanner(new File(args[0]));
            ps = new PrintStream(new File(args[1]));
            System.setOut(ps);			// redirect output to ps
        } else {
            kb = new Scanner(System.in);// default input from Stdin
            ps = System.out;			// default output to Stdout
        }
        initialize();

        // TODO methods to read in words, output ladder

        ArrayList<String> input = new ArrayList<String>();
        ArrayList<String> ladderBFS = new ArrayList<String>();
        ArrayList<String> ladderDFS = new ArrayList<String>();

        input.add("a");
        while(!input.get(0).equals("\\quit")) {
            input = parse(kb);
            System.out.println(input);
            ladderBFS = getWordLadderBFS(input.get(0), input.get(1));
            printLadder(ladderBFS);
            ladderDFS = getWordLadderDFS(input.get(0), input.get(1));
            printLadder(ladderDFS);

            input.add("a");
        }
    }

    /**
     * Static variables and constants should be initialized here.
     */
    public static void initialize() {

    }

    /**
     * Parses the scanner input for the start and end word, or the /quit command
     * @param keyboard Scanner connected to System.in
     * @return ArrayList of Strings containing start word and end word.
     * If command is /quit, return empty ArrayList.
     */
    public static ArrayList<String> parse(Scanner keyboard) {
        String input = keyboard.nextLine();
        input = input.toUpperCase();
        String[] tokens = input.split("\\s+");
        return new ArrayList<String>(Arrays.asList(tokens));
    }

    /**
     * This function uses a depth first search algorithm to generate a word ladder from the start word to the end word
     * @param start the desired start of the word ladder
     * @param end the desired end of the word ladder
     * @return returns the an ArrayList containing the word ladder. If no word ladder is found, it just contains the start and end words.
     */
    public static ArrayList<String> getWordLadderDFS(String start, String end) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> dict = new ArrayList<String>();
        Graph g = new Graph();
        dict.addAll(makeDictionary());
        g = makeGraph(dict);
        return dfs(start.toUpperCase(), end.toUpperCase(), g);
    }

    /**
     * This function uses a breadth first search algorithm to generate a word ladder from the start word to the end word. BFS guarantees the shortest possible word ladder.
     * @param start the desired start of the word ladder
     * @param end the desired end of the word ladder
     * @return returns an ArrayList containing the word ladder. If no word ladder is found, it just contains the start and end words.
     */
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> dict = new ArrayList<String>();
        Graph g = new Graph();
        dict.addAll(makeDictionary());
        g = makeGraph(dict);
        return bfs(start.toUpperCase(), end.toUpperCase(), g); // replace this line later with real return
    }

    /**
     * Generates the output for a given word ladder
     * @param ladder the sequence of words to be printed
     */
    public static void printLadder(ArrayList<String> ladder) {
        for(int i = 0; i < ladder.size(); i ++){
            ladder.set(i, ladder.get(i).toLowerCase());
        }
        if(ladder.size() == 2){
            System.out.println("no word ladder can be found between " + ladder.get(0) + " and " + ladder.get(1) + ".");
        }
        else {
            System.out.println("a " + (ladder.size() - 2) + "-rung word ladder exists between " + ladder.get(0) + " and " + ladder.get(ladder.size() - 1) + ".");
            for (int i = 0; i < ladder.size(); i++) {
                System.out.println(ladder.get(i));
            }
        }
    }

    // Other private static methods here

    /**
     * Generates a similarity graph given a dictionary of words. Two words are similar if they differ by only one character.
     * @param dict an ArrayList of Strings
     * @return returns a Graph object
     */
    private static Graph makeGraph(ArrayList<String> dict){
        Graph g = new Graph();
        for(int i = 0; i < dict.size(); i++){
            g.addVertex(dict.get(i));
        }
        for(int i = 0; i < dict.size(); i++){
            for(int j = 0; j < dict.size(); j++){
                if(isDifferentByOne(dict.get(i), dict.get(j))){
                    g.addEdge(g.getVertex(i), g.getVertex(j));
                }
            }
        }
        return g;
    }

    /**
     * Checks if Strings s1 and s2 are different by only one character. Strings MUST be the same length.
     * @param s1 The first String to be compared
     * @param s2 The second String to be compared
     * @return true if different by only one character false otherwise
     */
    private static boolean isDifferentByOne(String s1, String s2){
        int differences = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                differences++;
            }
        }
        if(differences == 1){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * bfs algorithm
     * @param start String, desired start of the word ladder
     * @param end String, desired end point of the word ladder
     * @param g the Graph to be searched
     * @return returns an ArrayList containing the word ladder. If no word ladder is found, it just contains the start and end words.
     */
    private static ArrayList<String> bfs(String start, String end, Graph g){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Vertex> queue = new ArrayList<Vertex>();
        ArrayList<Vertex> adjacencyList = new ArrayList<Vertex>();
        boolean foundFlag = false;

        Vertex v = g.getVertex(start);
        Vertex head = new Vertex();
        queue.add(v);
        v.setVisited(true);
        v.setPrevious(head);

        while(!queue.isEmpty() && foundFlag == false){
            v = queue.remove(0);
            adjacencyList = g.getAdjacencyList(v);
            for(int i = 1; i < adjacencyList.size(); i++){
                Vertex neighbor = adjacencyList.get(i);
                if(!neighbor.isVisited()) {
                    if (neighbor.getLabel().compareTo(end) == 0) {
                        foundFlag = true;
                    }
                    neighbor.setPrevious(v);
                    neighbor.setVisited(true);
                    queue.add(neighbor);
                }
            }
        }

        if(foundFlag){
            Vertex previous = g.getVertex(end).getPrevious();
            result.add(0, end);
            while(!(previous.getPrevious() == head)){
                result.add(0, previous.getLabel());
                previous = previous.getPrevious();
            }
            result.add(0, start);
        }
        else{
            result.add(start);
            result.add(end);
        }
        return result;
    }

    /**
     * dfs algorithm
     * @param start String, desired start of the word ladder
     * @param end String, desired end point of the word ladder
     * @param g the Graph to be searched
     * @return returns an ArrayList containing the word ladder. If no word ladder is found, it just contains the start and end words.
     */
    private static ArrayList<String> dfs(String start, String end, Graph g){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Vertex> adjacencyList = new ArrayList<Vertex>();
        boolean ladderFound = false;

        Vertex v = g.getVertex(start);
        Vertex head = new Vertex();
        v.setVisited(true);
        v.setPrevious(head);
        ladderFound = dfsVertex(g, v, end);

        if(ladderFound){
            Vertex previous = g.getVertex(end).getPrevious();
            result.add(0, end);
            while(!(previous.getPrevious() == head)){
                result.add(0, previous.getLabel());
                previous = previous.getPrevious();
            }
            result.add(0, start);
        }
        else{
            result.add(start);
            result.add(end);
        }
        return result;

    }

    /**
     * The actual recursive portion of the dfs algorithm.
     * @param g the Graph to be searched
     * @param v the Vertex to run dfs from
     * @param end the desired end point of the word ladder. i.e. the stop condition for dfs
     * @return true if end has been reached, false otherwise
     */
    private static boolean dfsVertex(Graph g, Vertex v, String end){
        ArrayList<Vertex> adjacencyList = g.getAdjacencyList(v);
        for(int i = 1; i < adjacencyList.size(); i++){
            Vertex neighbor = adjacencyList.get(i);
            if(!neighbor.isVisited()) {
                neighbor.setPrevious(v);
                neighbor.setVisited(true);
                if (neighbor.getLabel().compareTo(end) == 0) {
                    return true;
                }
                if(dfsVertex(g, adjacencyList.get(i), end)){
                    return true;
                }
            }
        }
        return false;
    }

    /* Do not modify makeDictionary */

    /**
     * Constructs a dictionary from a text file
     * @return a set of Strings containing words from a text file
     */
    public static Set<String>  makeDictionary () {
        Set<String> words = new HashSet<String>();
        Scanner infile = null;
        try {
            infile = new Scanner (new File("five_letter_words.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary File not Found!");
            e.printStackTrace();
            System.exit(1);
        }
        while (infile.hasNext()) {
            words.add(infile.next().toUpperCase());
        }
        return words;
    }
}
