/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palindrome;

import java.util.Scanner;
/**
 *
 * @author kavya
 */
public class Palindrome {
    
    private String input;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Palindrome palindrome = new Palindrome();
        palindrome.getString();
       
    }
    
    public void getString(){
        Scanner out = new Scanner(System.in);
        System.out.println("PLease enter the string:");
        input = out.nextLine();
        if(input.length() == 5) {
            System.out.println(checkPalindrome());
        } else {
            System.out.println("You have not met length requirements:");
            getString();
        }
    }
    
    public String checkPalindrome(){
        int end = input.length()-1;
        for(int start=0;start<=input.length()/2;start++) {
                if(input.charAt(start) != input.charAt(end)) {
                    return "Not a Palindrome!";
                    
                } else {
                    end--;
            }
        }
        return "It is a palindrome";
    }
}
