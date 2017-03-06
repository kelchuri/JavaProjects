/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

import java.util.Date;
import java.util.List;

/**
 * This class has passenger info
 * @author kavya
 */
public class Passenger {

    /**
     *
     * @param passenger_no
     * @param name
     * @param address
     * @param nationality
     * @param dob
     * @param moneySpentOnCruise
     */
    public Passenger(int passenger_no, String name, String address, String nationality, Date dob, double moneySpentOnCruise) {
        this.passenger_no = passenger_no;
        this.name = name;
        this.address = address;
        this.nationality = nationality;
        this.dob = dob;
        this.moneySpentOnCruise = moneySpentOnCruise;
    }

    private int passenger_no;

    private String name;

    private String address;

    private String nationality;

    private Date dob;

    private double ticketCost = 900;

    private double moneySpentOnCruise;

    private String travelDate;

    private List<CruisePassengerInfo> reviews;

    private CruisePassengerInfo review;

    /**
     *
     * @return
     */
    public String getTravelDate() {
        return travelDate;
    }

    /**
     *
     * @param travelDate
     */
    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    /**
     *
     * @return reviews
     */
    public List<CruisePassengerInfo> getReviews() {
        return reviews;
    }

    /**
     *
     * @param reviews
     */
    public void setReviews(List<CruisePassengerInfo> reviews) {
        this.reviews = reviews;
    }

    /**
     *
     * @param info
     */
    public void addReview(CruisePassengerInfo info) {
        this.review = info;
    }

    /**
     *
     * @return review
     */
    public CruisePassengerInfo getReview() {
        return this.review;
    }

    /**
     * @return the passenger_no
     */
    public int getPassenger_no() {
        return passenger_no;
    }

    /**
     * @param passenger_no the passenger_no to set
     */
    public void setPassenger_no(int passenger_no) {
        this.passenger_no = passenger_no;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return the ticketCost
     */
    public double getTicketCost() {
        return ticketCost;
    }

    /**
     * @param ticketCost the ticketCost to set
     */
    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

    /**
     * @return the moneySpentOnCruise
     */
    public double getMoneySpentOnCruise() {
        return moneySpentOnCruise;
    }

    /**
     * @param moneySpentOnCruise the moneySpentOnCruise to set
     */
    public void setMoneySpentOnCruise(double moneySpentOnCruise) {
        this.moneySpentOnCruise = moneySpentOnCruise;
    }

}
