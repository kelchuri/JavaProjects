/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaElchuriAssignemnt1;

/**
 * The GenerateInvoiceTest is the class invoking the GenerateInvoice. 
 * @author kavya
 */
public class GenerateInvoiceTest {
    
 public static void main(String[] args) {
        
        GenerateInvoice generateInvoice = new GenerateInvoice();
        generateInvoice.gatherInformation();
        generateInvoice.displayInvoice(); 
    }   
}
