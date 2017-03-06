/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabpractise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author kavya
 */
public class JavaLabPractise {

    private String input;
    
    private String[] words;
    
    private Map<String, Number> wordCount = new LinkedHashMap<String, Number>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaLabPractise javaLabPractise = new JavaLabPractise();
        javaLabPractise.takeInput();
        javaLabPractise.calWordCount();
        javaLabPractise.displayCount();
        // TODO code application logic here
    }

    public void takeInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLease Enter the String");
        input = scanner.nextLine();

    }
    
    public void calWordCount(){
        words = input.split(" ");
        for(String word: words){
            if(wordCount.containsKey(word)){
                wordCount.put(word, ((int)wordCount.get(word)) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
    }
    
    public void displayCount(){
        for(String key: wordCount.keySet()){
            System.out.printf("%-25s  %-25s\n", key, wordCount.get(key));
        }
    }

}
