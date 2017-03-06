/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardGame;

/**
 * Card Game Test starts the card game
 *
 * @author kavya
 */
public class CardGameTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.generateMatrix();
        //cardGame.generateDollarMatrix();
        cardGame.playMatch();
    }
}
