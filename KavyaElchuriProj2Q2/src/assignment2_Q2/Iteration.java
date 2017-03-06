/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_Q2;

/**
 * Iteration class computes the function using iteration
 *
 * @author kavya
 */
public class Iteration {

    /**
     * thisIsIterative performs the required calculations using iteration
     * instead of recursion
     *
     * @param n user entered value
     * @return the computed result
     */
    public int thisIsIterativeMain(int n) {
        int firstValue = -10, secondValue = 2, finalValue = 5;
        if (n < 0) {
            return -10;
        } else if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 5;
        } else {
            for (int i = 2; i <= n; i++) {
                firstValue = secondValue;
                secondValue = finalValue;
                finalValue = secondValue + 3 * firstValue + 2 * i;
            }
        }
        return finalValue;
    }
}
