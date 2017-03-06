/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

import java.util.Date;

/**
 * This class has engineer info
 * @author kavya
 */
public class Engineer extends Sailor {

    /**
     *
     * @param id
     * @param name
     * @param dob
     * @param nationality
     */
    public Engineer(int id, String name, Date dob, String nationality) {
        super(id, name, dob, nationality);
    }

    private double salary = 80000;

    /**
     *
     * @return salary
     */
    public double getSalary() {
        return salary;
    }
}
