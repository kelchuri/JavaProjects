/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_Q4;

/**
 * Tray contains vegetable or fruit of one kind, has some quantity and price
 * associated
 *
 * @author kavya
 */
public class Tray {

    private FruitOrVegetable content;

    private Double quantity;

    /**
     *
     * @param name
     */
    public Tray(String name) {
        setContent(name);
    }

    /**
     * @return the content
     */
    public FruitOrVegetable getContent() {
        return content;
    }

    /**
     * @param name
     */
    public void setContent(String name) {
        this.content = new FruitOrVegetable(name);
    }

    /**
     * @return the quantity
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
