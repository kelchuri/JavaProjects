/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_Q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * BarGraph displays a frequency graph for the number of times dice are rolled
 *
 * @author kavya
 */
public class BarGraph {

    private final Map<Integer, Integer> map = new HashMap<>();

    private int totalRolls;
    private static final int INITIAL_COUNT = 1;
    private static final int STAR_COUNT = 100;

    /**
     * getInput takes the input from user to know how many times the dice is to
     * be rolled
     */
    public void getInput() {
        Scanner out = new Scanner(System.in);
        System.out.println("Enter no of times you want to roll the dice:");
        totalRolls = out.nextInt();
        if (validateTotalRolls(totalRolls)) {
            int total, count;
            TwoDice dice;
            for (int i = 0; i < totalRolls; i++) {
                dice = new TwoDice();
                total = dice.getTotal();
                count = map.containsKey(total) ? (map.get(total)) + 1 : INITIAL_COUNT;
                map.put(total, count);
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

    }

    private Boolean validateTotalRolls(int number) {
        return number > 0;
    }

    /**
     * displayBarGraph displays the graph
     */
    public void displayBarGraph() {
        for (Integer no : map.keySet()) {
            System.out.print(no + "\t");
            for (int j = 0; j < getNumberOfStars(map.get(no)); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private int getNumberOfStars(int number) {
        return (number * STAR_COUNT) / totalRolls;
    }
}
