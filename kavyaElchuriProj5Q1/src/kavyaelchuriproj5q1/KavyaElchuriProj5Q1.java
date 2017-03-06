/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriproj5q1;

import java.sql.SQLException;

/**
 * This class initiates the db operation of creating the tables and inserting
 * the data
 *
 * @author kavya
 */
public class KavyaElchuriProj5Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        DBoperations initializer = new DBoperations();
        initializer.connectToDatabase();
        //initializer.droptable();
        initializer.createAndInsertData();
        initializer.getAllQuestions();
    }

}
