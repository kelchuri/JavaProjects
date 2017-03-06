/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

import java.util.List;

/**
 * This class has Supervisor info
 * @author kavya
 */
public class Supervisor extends Sailor {

    private double salary;

    /**
     *
     * @param sailor
     */
    public Supervisor(Sailor sailor) {
        salary = sailor.getSalary();
    }

    private List<Sailor> sailors;

    public double getSalary() {
        return (salary + (20 * salary) / 100);
    }
}
