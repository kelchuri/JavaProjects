/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_Q4;

/**
 * FreshBoxTest invokes a FreshBox object
 *
 * @author kavya
 */
public class FreshBoxTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        FreshBox freshBox = new FreshBox();
        freshBox.randomTrayGenerator();
        freshBox.getAvailableContents();
        freshBox.displayResults();
    }
}
