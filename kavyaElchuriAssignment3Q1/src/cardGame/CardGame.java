/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Card Game shuffles the cards and starts the game
 *
 * @author kavya
 */
public class CardGame {

    private static final List CARDS = Arrays.asList("A", "K", "Q", "J", "2", "5", "6", "9");

    private static final Map COUNT_MAP = createMap();

    private String startCoordinates, endCoordinates;

    private Card firstCard, secondCard;

    private final Card[][] matrix = new Card[4][4];

    private final List enteredCoordinates = new ArrayList<>();

    private int startX, startY, endX, endY;

    private int cardDraw = 2;

    private int noOfMatches;

    /**
     * generates the card matrix required for the game
     */
    public void generateMatrix() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = getRandomCard();
            }
        }
    }

    /**
     * This method starts the game
     */
    public void playMatch() {
        try {
            if (noOfMatches >= 8) {
                System.out.println("You have finished the game successfully");
                return;
            }
            String coordinates;
            System.out.println("Enter the coordinates in (x,y) manner: ");
            Scanner out = new Scanner(System.in);
            coordinates = out.nextLine();
            coordinates = coordinates.replaceAll(" ", "");
            int x = Character.getNumericValue(coordinates.charAt(1)) - 1;
            int y = Character.getNumericValue(coordinates.charAt(3)) - 1;
            if (validate(x, y, coordinates)) {
                enteredCoordinates.add(coordinates);
                printMatrix(x, y, coordinates);
            } else {
                restartGame();
            }
        } catch (Exception e) {
            restartGame();
        }
    }

    private void restartGame() {
        System.out.println("Either your input is wrong or the card you chose is already up");
        playMatch();
    }

    private boolean validate(int x, int y, String input) {
        if (x < 0 || x > 3 || y < 0 || y > 3) {
            return false;
        } else if (enteredCoordinates.contains(input)) {
            return false;
        } else if (!input.matches("(^\\(\\d,\\d\\)$)")) {
            return false;
        }
        return true;
    }

    /**
     * Prints the matrix after every card is picked up
     *
     * @param x x coordinate in the matrix
     * @param y y coordinate in the matrix
     * @param input coordinate string
     */
    public void printMatrix(int x, int y, String input) {
        startCoordinates = endCoordinates;
        endCoordinates = input;
        startX = endX;
        startY = endY;
        endX = x;
        endY = y;
        System.out.println("   1  2  3  4");
        secondCard = firstCard;
        firstCard = matrix[x][y];
        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1 + "  ");
            for (int j = 0; j < 4; j++) {
                if ((x == i && y == j)) {
                    cardDraw--;
                    firstCard = matrix[i][j];
                    firstCard.setFaceUp(true);
                }
                if (matrix[i][j].isFaceUp()) {
                    System.out.print(matrix[i][j].getValue() + "  ");
                } else {
                    System.out.print("$" + "  ");
                }

            }
            System.out.println();
        }
        if (cardDraw == 0) {
            cardDraw = 2;
            if (!firstCard.getValue().equalsIgnoreCase(secondCard.getValue())) {
                matrix[startX][startY].setFaceUp(false);
                matrix[endX][endY].setFaceUp(false);
                enteredCoordinates.remove(enteredCoordinates.indexOf(startCoordinates));
                enteredCoordinates.remove(enteredCoordinates.indexOf(endCoordinates));
                skipConsole();
            } else {
                noOfMatches++;
                System.out.println("You have a match!!");
            }
        }
        playMatch();
    }

    private static Map createMap() {
        Map count = new HashMap<>();
        for (Object card : CARDS) {
            count.put(card, 2);
        }
        return count;
    }

    /**
     * This method picks a random card
     *
     * @return a card
     */
    public Card getRandomCard() {
        Random random = new Random();
        int index = random.nextInt(CARDS.size());
        if ((int) COUNT_MAP.get(CARDS.get(index)) > 0) {
            COUNT_MAP.put(CARDS.get(index), ((int) COUNT_MAP.get(CARDS.get(index))) - 1);
            return new Card(CARDS.get(index).toString());
        }
        return getRandomCard();
    }

    private void skipConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

}
