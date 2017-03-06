/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment5q2;

import java.sql.SQLException;

/**
 * This is the initiator class which is invoking the db operations
 *
 * @author kavya
 */
public class KavyaElchuriAssignment5Q2 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        DbOperations initialize = new DbOperations();
        initialize.connectToDatabase();

        initialize.createAndInsertData();
        initialize.getListOfSailorsPosition();
        initialize.getMinSailor("min");
        initialize.getMinSailor("max");
        initialize.getAvgSalSailors();
        initialize.getSpecificSailors();

    }

}
