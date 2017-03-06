/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.week1;

import java.util.Scanner;

/**
 *
 * @author kavya
 */
public class LabWeek1b {
    
    public Long number;
    public char[] numberArray;
    public static void main(String[] args) {
        // TODO code application logic here
        LabWeek1b cal = new LabWeek1b();
        cal.takeInput();
        cal.displayResult();
    }
    
    public void takeInput(){
        Scanner out = new Scanner(System.in);
        System.out.print("Enter the number: ");
        number = out.nextLong();
    }
    
    public void displayResult(){
        String numberStr = number.toString();
        numberArray = numberStr.toCharArray();
        for(int i=0; i<numberStr.length(); i++) {
            System.out.print(numberArray[i] + "   ");
        }
    }
}
