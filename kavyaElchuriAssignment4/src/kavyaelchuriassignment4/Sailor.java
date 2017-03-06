/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

import java.util.Date;

/**
 * This class has Sailor info
 * @author kavya
 */
public class Sailor {

    /**
     *
     */
    public Sailor() {

    }

    /**
     *
     * @param id
     * @param name
     * @param dob
     * @param nationality
     */
    public Sailor(int id, String name, Date dob, String nationality) {
        setId(id);
        setName(name);
        setDob(dob);
        setNationality(nationality);
    }

    private int id;

    private String name;

    private Date dob;

    private double salary = 50000;

    private String nationality;

    private String dateOfJoining;

    private boolean isSupervisor;

    /**
     *
     * @return
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the dateOfJoining
     */
    public String getDateOfJoining() {
        return dateOfJoining;
    }

    /**
     * @param dateOfJoining the dateOfJoining to set
     */
    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    /**
     * @return the isSupervisor
     */
    public boolean isIsSupervisor() {
        return isSupervisor;
    }

    /**
     * @param isSupervisor the isSupervisor to set
     */
    public void setIsSupervisor(boolean isSupervisor) {
        this.isSupervisor = isSupervisor;
    }
}
