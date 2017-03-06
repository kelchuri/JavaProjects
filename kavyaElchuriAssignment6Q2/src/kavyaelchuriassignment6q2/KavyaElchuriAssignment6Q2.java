/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment6q2;

/**
 * This class calls the necessary methods to generate points and then sort them.
 *
 * @author kavya
 */
public class KavyaElchuriAssignment6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PointGenerator pointGenerator = new PointGenerator();
        pointGenerator.generatePoints();
        pointGenerator.compare();
    }

}
