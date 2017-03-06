/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.week1;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author kavya
 */
public class LabWeek1a {

    /**
     * @param args the command line arguments
     */
    
    public Integer num1, num2, num3;
    public ArrayList<Integer> numbers = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        LabWeek1a cal = new LabWeek1a();
        cal.takeInput();
        cal.displayResult();
        
    }
    
    public void takeInput() {
        Scanner out = new Scanner(System.in);
        System.out.println("Please enter first number");
        num1 = out.nextInt();
        System.out.println("Please enter second number");
        num2 = out.nextInt();
        System.out.println("Please enter third number");
        num3 = out.nextInt();
        numbers.add(num1);
        numbers.add(num2);
        numbers.add(num3);
    }
    
    public void displayResult(){
        System.out.println("Sum: " + getSum());
        System.out.println("Average" + getAverage());
        System.out.println("Product" + getProduct());
        System.out.println("Max:" + getMax());
        System.out.println("Min:" + getMin());
    }
    
    public Integer getSum() {
        return num1+num2+num3;
    }
    
    public Integer getProduct() {
        return num1*num2*num3;
    }
    
    public Integer getAverage() {
        return (getSum()/3);
    }
    
    public Integer getMax() {
        int max = 0;
        for(Integer number: numbers) {
            if(number > max) {
                max = number;
            }
        }
        return max;
    }
    
    public Integer getMin() {
        int min = numbers.get(0);
        for(Integer number: numbers) {
            if(number < min) {
                min = number;
            }
        }
        return min;
    }
    
}
