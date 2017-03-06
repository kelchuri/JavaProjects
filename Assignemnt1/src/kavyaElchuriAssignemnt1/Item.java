/*
 * 
 */
package kavyaElchuriAssignemnt1;

/**
 * Item class describes the attributes and behaviors of an item.
 * It has attributes name, quantity and price.
 * @author kavya
 */
public class Item {
    
    Item(String name, Integer quantity, Double price) {
        setName(name);
        setQuantity(quantity);
        setPrice(price);
    }
    
    private String name;
    
    private Integer quantity;
    
    private Double price;
    
    /**
     * This method sets the name of the item
     * @param name Name of the item
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This method returns the name of the item
     * @return name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * This method sets the quantity of the item
     * @param quantity quantity of the item
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    /**
     * This method returns th quantity of the item
     * @return quantity
     */
    public Integer getQuantity(){
        return this.quantity;
    }
    
    /**
     * This method sets the price of the item
     * @param price price of the item
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    /**
     * this method returns the price of the item
     * @return price
     */
    public Double getPrice(){
        return this.price;
    }
    
}
