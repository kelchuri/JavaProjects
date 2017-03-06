/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment6q2;

/**
 * Point class has fields x and y and implements Comparable interface to
 * override the compareTo method.
 *
 * @author kavya
 */
public class Point implements Comparable<Point> {

    private int x;

    private int y;

    /**
     * Takes two arguments x and y
     *
     * @param x
     * @param y
     */
    Point(int x, int y) {
        setX(x);
        setY(y);
    }

    //overrides compareTo to compare on the basis of x-coordinates of the points.
    @Override
    public int compareTo(Point o) {
        if (this.getX() == o.getX()) {

            return this.getY() - o.getY();

        }
        return this.getX() - o.getX();
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
