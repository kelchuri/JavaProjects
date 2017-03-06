/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment6q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BracesCheck reads the file and checks for the balance of braces.
 *
 * @author kavya
 */
public class BracesCheck {

    private File file;

    private final Map<String, String> symbols = new HashMap<>();
    //("(", ")", "<", ">", "{", "}", "[", "]");

    private final Stack<String> stack = new Stack<>();

    private char[] letters;

    private boolean incorrectMatch = true;

    private boolean printed = false;

    /**
     * setMap sets the key, values as open and close braces
     */
    public void setMap() {
        symbols.put("(", ")");
        symbols.put("{", "}");
        symbols.put("<", ">");
        symbols.put("[", "]");
    }

    /**
     * read gets the file name from command line argument and parses the code
     * file to check the balance
     *
     * @param fileName name of the java file
     */
    public void read(String fileName) {
        URL name = getClass().getResource(fileName);
        file = new File(name.getPath());
        String line, letter;
        try {
            Scanner input = new Scanner(file);
            outerloop:
            while (input.hasNextLine()) {
                line = input.nextLine();
                letters = line.toCharArray();
                for (char letterChar : letters) {
                    letter = String.valueOf(letterChar);
                    if (symbols.keySet().contains(letter)) {
                        stack.add(letter);
                        //System.out.println("Pushed " + letter);
                    } else if (symbols.values().contains(letter)) {
                        String key = getKeyFromMap(letter);
                        if (stack.isEmpty() || !stack.contains(key)) {
                            System.out.println("Program is Incorrect."
                                    + " Match not found for " + letter);
                            incorrectMatch = false;
                            printed = true;
                            break outerloop;
                        } else {
                            stack.remove(key);
                            //System.out.println("Popped " + key);
                        }
                    }

                }
            }
            if (stack.isEmpty() && incorrectMatch != false) {
                System.out.println("Program is correct");
            } else if (printed == false) {
                System.out.println("Program is Incorrect. Match not found for " + getAllRemainingElements());

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KavyaElchuriAssignment6Q3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //gets all the remaining elements in the stack which do not match
    private String getAllRemainingElements() {
        String result = "";
        for (String s : stack) {
            result += " " + s;
        }
        //result = stack.stream().map((s) -> s + " ").reduce(result, String::concat);
        return result;
    }

    //gets the key to be popped based on the value
    private String getKeyFromMap(String value) {
        for (String key : symbols.keySet()) {
            if (symbols.get(key).equalsIgnoreCase(value)) {
                return key;
            }
        }
        return "";
    }

}
