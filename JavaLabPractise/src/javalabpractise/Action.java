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
public class Action extends Movie{
    
    Action(){
        lateFee = 3.0;
    }
    
    public double calcLateFees(int noOfdays){
        return lateFee*noOfdays;
    }
    
}
