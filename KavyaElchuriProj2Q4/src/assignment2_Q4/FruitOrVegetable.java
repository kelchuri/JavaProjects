/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_Q4;

/**
 * Represents a fruit or vegetable
 *
 * @author kavya
 */
public class FruitOrVegetable {

    private String name;

    private Double pricePerPiece;

    /**
     *
     * @param name
     */
    public FruitOrVegetable(String name) {
        setName(name);
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param price
     */
    public void setPrice(Double price) {
        this.pricePerPiece = price;
    }

    /**
     *
     * @return price
     */
    public Double getPrice() {
        return this.pricePerPiece;
    }
}
