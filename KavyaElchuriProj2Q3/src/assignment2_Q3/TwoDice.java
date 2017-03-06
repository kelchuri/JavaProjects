/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_Q3;

import java.util.Random;

/**
 * TwoDice simulates the roll of two dice and computes total
 *
 * @author kavya
 */
public class TwoDice {

    private int firstDie;

    private int secondDie;

    private int getDieRoll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    /**
     * getTotal displays the total of a roll
     *
     * @return total
     */
    public int getTotal() {
        int total;
        firstDie = getDieRoll();
        secondDie = getDieRoll();
        total = firstDie + secondDie;
        return total;
    }
}
