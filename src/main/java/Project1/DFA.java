package Project1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This class simulates a DFA.
 * 
 * @author Chase Clark
 */
public class DFA {

    private String currentState;
    private String initialState;
    private List<String> inputStrings;
    private List<String> alphabetList;
    private List<String> statesList;
    private List<String> finalStatesList;
    private HashMap<String, String> transitionsMap;

    // this method is the first thing called when the program is ran.
    public void start() {
        System.out.println("Chase Clark DFA program");
        System.out.println("Starting program...");
        System.out.println();

        loadInputFiles();
        runDFA();
    }

    private void loadInputFiles() {
        String dfaFilePath = "COSC485_P1_DFA.txt";
        String stringsFilePath = "COSC485_P1_StringsDFA.txt";

        try {
            // load the input strings into list
            inputStrings = Files.readAllLines(Path.of(stringsFilePath));

            // begin loading DFA information
            List<String> dfaLines = Files.readAllLines(Path.of(dfaFilePath));
            // loop through each line of file

            // States line
            String s = dfaLines.get(5);
            // get substring of s and convert data to list
            statesList = Arrays.asList(s.substring(s.indexOf("{") + 1, s.indexOf("}")).replace(" ", "").split(","));

            // get alphabet
            s = dfaLines.get(7);
            alphabetList = Arrays.asList(s.substring(s.indexOf("{") + 1, s.indexOf("}")).replace(" ", "").split(","));

            // parse out the intitial state value
            s = dfaLines.get(9);
            initialState = s.substring(s.indexOf("=") + 1, s.indexOf(",")).replace(" ", "");

            // parse out the final states and add to a List
            s = dfaLines.get(11);
            finalStatesList = Arrays
                    .asList(s.substring(s.indexOf("{") + 1, s.indexOf("}")).replace(" ", "").split(","));

            // convert the transitions data into a HashMap<String,String>
            transitionsMap = new HashMap<String, String>();
            // number of transitions should be the number of states multiplied by the
            // alphabet size
            int numTransitions = statesList.size() * alphabetList.size();
            // start of transition data in file is index 14 in array
            int offset = 14;
            for (int i = offset; i < numTransitions + offset; i++) {
                String line = dfaLines.get(i);
                // now we can parse the information between the parens
                String[] arr = line.substring(line.indexOf("(") + 1, line.indexOf(")")).replace(" ", "").split(",");
                // arr length should be 3
                // hash key will be arr[0] + arr[1]
                // hash value will be arr[2]
                transitionsMap.put(arr[0] + arr[1], arr[2]);
            }

            System.out.println("Loading done!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method takes our list of input strings and runs them through the
     * simulated DFA. The output for each string will be either "accepted" or "not
     * accepted"
     */
    private void runDFA() {
        // make sure to set current state = initial state at the beginning of the loop
    }

}
