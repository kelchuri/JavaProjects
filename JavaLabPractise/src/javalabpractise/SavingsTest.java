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
public class SavingsTest {
    
    
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        saver1.setBalance(2000.0);
        saver2.setBalance(3000.0);
        callSavers(saver1, saver2, 4);
        callSavers(saver1, saver2, 5);
    }

    public static void callSavers(SavingsAccount saver1, SavingsAccount saver2, double interestrate) {
        SavingsAccount.modifyInterestRate(interestrate);
        
        System.out.println(saver1.getnewBalance());
        System.out.println(saver2.getnewBalance());
    }
}
