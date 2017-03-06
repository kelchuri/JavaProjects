/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment6q3;

/**
 * This class takes the file input from command line and passes it on for the
 * check
 *
 * @author kavya
 */
@SuppressWarnings("unchecked")
public class KavyaElchuriAssignment6Q3 {

    /**
     *
     * @param args the command line arguments args[0] will give the file name
     */
    public static void main(String[] args) {
        BracesCheck bracesCheck = new BracesCheck();
        bracesCheck.setMap();
        try {
            bracesCheck.read(args[0]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("No file name has been given.");
        } catch (Exception ex) {
            System.out.println("Either the file doesnot exist or it is not in the correct path");
        }
    }

}
