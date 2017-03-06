/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment6q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * PointGenerator creates 100 random points and sorts them on X and Y coordinate
 * basis.
 *
 * @author kavya
 */
public class PointGenerator {

    private final List<Point> points = new ArrayList<>();

    /**
     * generatePoints generates 100 random points
     */
    public void generatePoints() {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            //Range is taken as 200 to have chances of duplicate x or y intercepts
            int x = random.nextInt(200);
            int y = random.nextInt(200);
            points.add(new Point(x, y));
        }

    }

    /**
     * compare first compares the points on x coordinates and then on Y coordinates
     */
    public void compare() {
        Collections.sort(points);
        System.out.println("Sort based on X-coordinates:\n");
        display();
        Collections.sort(points, new CompareY());
        System.out.println("Sort based on Y-coordinates:\n");
        display();

    }

    /**
     * display displays the points
     */
    public void display() {
        System.out.printf("%4s %4s\n", "X", "Y");
        for (Point point : points) {
            System.out.printf("%4d %4d\n", point.getX(), point.getY());
        }
        System.out.println("\n");
    }

}
