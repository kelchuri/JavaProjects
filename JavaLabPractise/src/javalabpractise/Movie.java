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
public class Movie {
    
    private String rating;
    
    private long id;
    
    private String movieTitle;
    
    double lateFee= 2.0;

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }
    
    public double calcLateFees(int noOfdays){
        return lateFee*noOfdays;
    }
    
    public boolean equals(Object movie){
        Movie film = (Movie) movie;
        return film.getId() == this.id;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the movieTitle
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * @param movieTitle the movieTitle to set
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    
    
}
