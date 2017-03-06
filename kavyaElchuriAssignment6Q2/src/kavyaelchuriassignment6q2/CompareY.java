/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment6q2;

import java.util.Comparator;

/**
 * CompareY implements Comparator and overrides compare method to compare two
 * points on the basis of this y-coordinates.
 *
 * @author kavya
 */
public class CompareY implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        if (o1.getY() == o2.getY()) {
            return o1.getX() - o2.getX();
        }
        return o1.getY() - o2.getY();
    }

}
