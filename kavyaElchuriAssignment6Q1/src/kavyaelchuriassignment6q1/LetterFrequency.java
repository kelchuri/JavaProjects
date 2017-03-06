/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment6q1;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * LetterFrequency class has methods to precess the file and get the frequency
 * of each letter
 *
 * @author kavya
 */
public class LetterFrequency {

    private File file;

    private Scanner input;

    private String fileName;

    private final Map<String, Integer> letterMap = new HashMap<>();

    //totalCount is to get the totalCount of letters in that file
    private int totalCount;

    /**
     * getFileName takes an input from the user for the file name.
     */
    public void getFileName() {
        System.out.println("Please enter the filename along with the extension,"
                + " For eg: story.txt ");
        input = new Scanner(System.in);
        fileName = input.nextLine();
        getFileAndAccess();
    }

    /**
     * getFileAndAccess method tries to access the file, reads its content and
     * stores the letter and its count in a map.
     */
    public void getFileAndAccess() {
        try {
            URL name = KavyaElchuriAssignment6Q1.class.getResource(fileName);
            file = new File(name.getPath());
            String line, letter;
            char[] letters;
            int count;
            input = new Scanner(file);
            while (input.hasNextLine()) {
                line = input.nextLine();
                letters = line.toCharArray();
                for (char letterChar : letters) {

                    letter = String.valueOf(letterChar);
                    //character should be a letter
                    if (letter.matches("[a-zA-Z]+")) {
                        totalCount++;
                        letter = letter.toLowerCase();
                        if (letterMap.keySet().contains(letter)) {
                            count = letterMap.get(letter);
                        } else {
                            count = 0;
                        }
                        count++;
                        letterMap.put(letter, count);
                    }

                }
            }
        } catch (Exception ex) {
            System.out.println("Either the file name is wrong or it doesnot exist. PLease try again!");
            getFileName();
        }
    }

    /**
     * display prints the letters along with their frequencies
     */
    public void display() {
        for (String key : letterMap.keySet()) {
            System.out.printf("%s %.5f\n", key, ((float) letterMap.get(key) / totalCount));
        }
        System.out.println("Total Count is " + totalCount);
    }
}
