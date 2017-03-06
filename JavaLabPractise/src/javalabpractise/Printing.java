/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabpractise;

/**
 *
 * @author kavya
 */
public class Printing {
    static int number=1;
    
    public static void main(String[] args){
        printGrid(1, 3);
        System.out.println();
        
    }
    
    public static void printGrid(int rows, int cols){
        int printValue;
        for(int i=0; i< rows; i++){
            printValue = number;
            for(int j=0; j<cols; j++){
                System.out.print(printValue+" ");
                printValue += rows;
            }
            System.out.println();
            number++;
        }
    }
    
}
