/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has ship info
 * @author kavya
 */
public class Ship {

    /**
     *
     * @param shipno
     * @param name
     * @param weight
     * @param yearBuilt
     * @param passenger
     */
    public Ship(int shipno, String name, double weight, int yearBuilt, int passenger) {
        setShipNo(shipno);
        setName(name);
        setWeight(weight);
        setYearBuilt(yearBuilt);
        setPassengerCapacity(passenger);
    }

    private int shipNo;

    private String name;

    private double weight;

    private int yearBuilt;

    private int passengerCapacity;

    private List<Sailor> sailors = new ArrayList<Sailor>();

    //private List<Cruise> cruises;
    /**
     * @param sailor
     */
    public void addSailor(Sailor sailor) {
        sailors.add(sailor);
    }

    /**
     *
     * @return sailors
     */
    public List<Sailor> getSailors() {
        for (Sailor s : sailors) {
            //System.out.println(s.getId() + " " + s.getSalary() );
        }
        return this.sailors;
    }

    /**
     *
     * @return shipNo
     */
    public int getShipNo() {
        return shipNo;
    }

    /**
     * @param shipNo the shipNo to set
     */
    public void setShipNo(int shipNo) {
        this.shipNo = shipNo;
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
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the yearBuilt
     */
    public int getYearBuilt() {
        return yearBuilt;
    }

    /**
     * @param yearBuilt the yearBuilt to set
     */
    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    /**
     * @return the passengerCapacity
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * @param passengerCapacity the passengerCapacity to set
     */
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

}
