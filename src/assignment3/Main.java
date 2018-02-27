/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * Brian Wilmarth
 * bw24274
 * 15455
 * Slip days used: <0>
 * Git URL:
 * Spring 2018
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {

    // static variables and constants only here.

    public static void main(String[] args) throws Exception {

        Scanner kb;	// input Scanner for commands
        PrintStream ps;	// output file, for student testing and grading only
        // If arguments are specified, read/write from/to files instead of Std IO.
        if (args.length != 0) {
            kb = new Scanner(new File(args[0]));
            ps = new PrintStream(new File(args[1]));
            //System.setOut(ps);			// redirect output to ps
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
            //System.out.println(input);
            ladderBFS = getWordLadderBFS(input.get(1), input.get(2));
            printLadder(ladderBFS);
            ladderDFS = getWordLadderDFS(input.get(1), input.get(2));
            printLadder(ladderDFS);

            input.add("a");
        }
    }

    public static void initialize() {
        // initialize your static variables or constants here.
        // We will call this method before running our JUNIT tests.  So call it
        // only once at the start of main.
    }

    /**
     * @param keyboard Scanner connected to System.in
     * @return ArrayList of Strings containing start word and end word.
     * If command is /quit, return empty ArrayList.
     */
    public static ArrayList<String> parse(Scanner keyboard) {
        // TO DO

        String input = keyboard.nextLine();
        String[] tokens = input.split("\\s+");

        return new ArrayList<String>(Arrays.asList(tokens));
    }

    public static ArrayList<String> getWordLadderDFS(String start, String end) {

        // Returned list should be ordered start to end.  Include start and end.
        // If ladder is empty, return list with just start and end.
        // TODO some code
        Set<String> dict = makeDictionary();
        // TODO more code

        return null; // replace this line later with real return
    }

    public static ArrayList<String> getWordLadderBFS(String start, String end) {

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> dict = new ArrayList<String>();

        result.add(start);
        dict.addAll(makeDictionary());



        return null; // replace this line later with real return
    }


    public static void printLadder(ArrayList<String> ladder) {
        System.out.println("A " + (ladder.size()-2) + "-rung word ladder exists between " + ladder.get(0) + " and " + ladder.get(ladder.size()-1) + ".");
        for(int i = 0; i < ladder.size(); i++){
            System.out.println(ladder.get(i));
        }
    }
    // TODO
    // Other private static methods here

    public void makeGraph(ArrayList<String> dict, Graph g){
        Graph g = new Graph();
        boolean diffByOne = 0;
        for(int i = 0; i < dict.size(); i++){
            g.addVertex(dict.get(i));
        }
        for(int i = 0; i < dict.size(); i++){
            for(int j = 0; j < dict.size(); j++){
                dict.get(i)
            }
        }
    }

    public boolean isDifferentByOne(String s1, String s2){
        int differences = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
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


    /* Do not modify makeDictionary */
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
