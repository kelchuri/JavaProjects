/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardGame;

/**
 * Card class has attributes of card
 *
 * @author kavya
 */
public class Card {

    private String value;

    private boolean faceUp;

    /**
     * sets the value of card
     *
     * @param name value
     */
    public Card(String name) {
        setValue(name);
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the faceUp
     */
    public boolean isFaceUp() {
        return faceUp;
    }

    /**
     * @param faceUp the faceUp to set
     */
    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }
}
