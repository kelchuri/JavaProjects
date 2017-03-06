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
public class SavingsAccount {
    
    private static double annualInterestRate;
    
    private double savingsBalance;
    
    
    public double calculateMonthlyInterest() {
        return (savingsBalance*annualInterestRate)/12;
    }
    
    public static void modifyInterestRate(double annualRate){
        annualInterestRate = annualRate;
    }
    
    public void setBalance(double balance){
        savingsBalance = balance;
    }
    
    public double getBalance(){
        return savingsBalance;
    }
    
    public double getnewBalance(){
        return calculateMonthlyInterest() + getBalance();
    }
    
}
