/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaElchuriAssignemnt1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class has the methods required to capture the user information
 * and print the invoice
 * @author kavya
 */
public class GenerateInvoice {
    
    private static final Integer ITEMCOUNT = 3;
    private static final String ITEM= "Item";
    private static final String QUANTITY= "Quantity";
    private static final String PRICE= "Price";
    private static final String TOTAL= "Total";
    private static final String DATE= "Date";
    private static final char PERCENT = '%';
    
    //The percentage of sales tax
    private static final double SALES_TAX = 7.25; 
    private ArrayList<Item> items = new ArrayList<Item>();
    
    private Item item;
    private String customerName;
   
    /**
     * Gather Information is for taking the user inputs like
     * name and also to collect the item information consisting of name, price
     * and quantity where name is a string, price is a double and quantity is
     * an integer
     */
    public void gatherInformation() {
        Scanner out = new Scanner(System.in);
        System.out.printf("Please Enter your name:");
        customerName = out.nextLine();
        for(int number=1; number<= ITEMCOUNT; number++) {
        System.out.println("Input name of item " + number + ":");
        String name = out.nextLine();
        System.out.println("Input quantity of item " + number + ":");
        Integer quantity= out.nextInt();
        System.out.println("Input price of item " + number + ":");
        Double price= out.nextDouble();
        item = new Item(name, quantity, price);
        items.add(item);
        out.nextLine();
        } 
    }

    /**
     * Display invoice structures the information in a tabular format. It
     * also does the sales tax calculations and displays the output in 
     * a formatted manner.
     */
    public void displayInvoice(){
      Double total = 0.0;  
      System.out.println("Invoice for "+ customerName);
      System.out.printf("No: %d%35s:%s\n", getInvoiceNumber(),DATE, getCurrentDate());
      System.out.printf("%-30s%-10s%-10s%-10s\n",ITEM, QUANTITY, PRICE, TOTAL);
      for(Item item: items) {
            total = total + (item.getQuantity()* item.getPrice());
            System.out.printf("%-30s%-10d%-10.2f%-10.2f\n",item.getName(), item.getQuantity(),
                    item.getPrice(), (item.getQuantity()* item.getPrice()));
        }  
      System.out.printf("SubTotal%47.2f\n", total);
      Double salesTax =  getTax(total);
      System.out.printf("%.2f%c sales tax%40.2f\n",SALES_TAX,PERCENT,salesTax);
      System.out.printf("%s%50.2f\n", TOTAL,(total + salesTax));
    }
    
    /**
     * This method calculates the sales tax.
     * @param total This is the total amount of the items
     * @return sales tax value
     */
    public static double getTax(Double total) {
        return (SALES_TAX * total)/100;
    }
    
    
    /**
     * The getInvoiceNumber method returns and invoice number
     * which is random 5 digit number
     * @return 5-digit invoice Number
     */
    public Integer getInvoiceNumber(){
        Random random = new Random();
        return random.nextInt(99999);
    }
    
    /**
     * The getCurrentDate method returns the formatted date to be added
     * in the invoice
     * @return date formatted in "dd-MM-yyyy" pattern
     */
    public String getCurrentDate(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.format(dateFormat);
    }
}
