/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintStars;

/**
 *
 * @author kavya
 */
public class PrintStars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrintStars printStars = new PrintStars();
        printStars.dislpayNormal();
        System.out.println("");
        printStars.displaySecond();
        System.out.println("");
        printStars.displayThird();
        System.out.println("");
        printStars.displayFourth();
    }
    
    public void dislpayNormal(){
        for(int i=1;i<=10;i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    public void displaySecond(){
        for(int i=10;i>0;i--) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    public void displayThird(){
        for(int i=1;i<=10;i++) {
            for(int k=1; k<=10-i;k++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    public void displayFourth(){
        for(int i=10;i>0;i--) {
            for(int k=10; k>i;k--){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}
