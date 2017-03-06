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
public class MoviesTest {

    public static void main(String[] args) {
        Movie defaultMovie = new Movie();
        Movie action = new Action();
        Movie comedy = new Comedy();
        Movie drama = new Drama();
        int noOfdays = 20;
        System.out.println("Late fee for default" + defaultMovie.calcLateFees(noOfdays));
        System.out.println("Late fee for Action" + action.calcLateFees(noOfdays));
        System.out.println("Late fee for comedy" + comedy.calcLateFees(noOfdays));
        System.out.println("Late fee for drama" + drama.calcLateFees(noOfdays));
    }

}
