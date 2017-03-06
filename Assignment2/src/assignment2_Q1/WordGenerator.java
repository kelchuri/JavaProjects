/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_Q1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * WordGenerator takes a string of 5 letters and generates list of all the
 * possible three-lettered words
 *
 * @author kavya
 */
public class WordGenerator {

    /**
     * @param args the command line arguments
     */
    private String input;

    private final List<String> result = new ArrayList<>();

    private static final int REQUIRED_LENGTH = 3;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WordGenerator wordGenerator = new WordGenerator();
        if (!wordGenerator.takeInputString()) {
            wordGenerator.getCombinations("", wordGenerator.input);
            wordGenerator.displayResult();
        } else {
            System.out.println("Please enter a five-lettered String.");
        }

    }

    /**
     * calls the user input method
     */
    public void fetchInputAndCompute() {
        if (!takeInputString()) {
            getCombinations("", input);
            displayResult();
        } else {
            System.out.println("Please enter a five-lettered String.");
        }
    }

    /**
     * TakeInputString takes an input from the user
     *
     * @return true or false
     */
    public Boolean takeInputString() {
        Scanner out = new Scanner(System.in);
        System.out.println("Please Enter the String");
        input = out.nextLine();
        return validateInput(input);
    }

    /**
     * validateInput takes in the user input and validates if it matches the
     * length and value specifications
     *
     * @param input user entered value
     * @return true or false
     */
    public Boolean validateInput(String input) {
        return input.matches(".*[0-9].*") || (input.length() > 5);
    }

    /**
     * getCombinations generates all the possible three letter combinations from
     * the five lettered input using recursion
     *
     * @param prefix is the constant character set for that recursion depth
     * @param input user entered value
     */
    public void getCombinations(String prefix, String input) {
        int strLength = input.length();
        if (prefix.length() == REQUIRED_LENGTH) {
            getPermutations(prefix);
        }

        for (int i = 0; i < strLength; i++) {
            getCombinations(prefix + input.charAt(i), input.substring(i + 1));
        }
    }

    /**
     * displayResult displays all the unique strings that are generated
     */
    public void displayResult() {
        System.out.println("Total no of strings:" + result.size());
        for (String word : result) {
            System.out.println(word);
        }
    }

    /**
     * getPermutations gives all the permutations of a three lettered string
     *
     * @param str three lettered String
     */
    public void getPermutations(String str) {
        char current;
        for (int i = 0; i < str.length(); i++) {
            current = str.charAt(i);
            String rest = str.substring(0, i) + str.substring(i + 1, str.length());
            addStringToResult(current + rest);
            addStringToResult(current + new StringBuffer(rest).reverse().toString());

        }
    }

    /**
     * addStringToResult adds the string to the list only if it does not already
     * exist
     *
     * @param str String to be added
     */
    public void addStringToResult(String str) {
        if (!result.contains(str)) {
            result.add(str);
        }
    }
}
