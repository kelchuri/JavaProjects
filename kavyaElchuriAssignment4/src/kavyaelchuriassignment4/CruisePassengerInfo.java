/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

/**
 * This class defines the passenger cruise info
 * @author kavya
 */
public class CruisePassengerInfo {

    /**
     *
     * @param passenger
     * @param rating
     * @param review
     */
    public CruisePassengerInfo(Passenger passenger, int rating, String review) {
        this.passenger = passenger;
        this.rating = rating;
        this.review = review;
    }

    private Cruise cruise;

    private Passenger passenger;

    private int travelCount;

    private String dateOfTravel;

    private int rating;

    /**
     *
     * @return rating
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *
     * @return review
     */
    public String getReview() {
        return review;
    }

    /**
     *
     * @param review
     */
    public void setReview(String review) {
        this.review = review;
    }

    private String review;
}
