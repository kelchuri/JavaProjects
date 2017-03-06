/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment5q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class has all the db interactions
 *
 * @author kavya
 */
public class DbOperations {

    private File file;

    private Scanner input;

    private Connection con;
    private final String FNAME = "FIRSTNAME";
    private final String LNAME = "LASTNAME";
    private final String POSITION = "POSITION";
    private final String SALARY = "SALARY";

    private final String url = "jdbc:derby://localhost:1527/EmployeeDB;create=true";
    private final String username = "adminuser";
    private final String password = "adminuser";

    /**
     * This method prints the sailors whose last name starts with R and whose
     * salary is greater 58543$
     */
    public void getSpecificSailors() {
        String query = "select * from sailor where lastname like 'R%' and salary > 58543";
        Statement stmt;
        try (Connection con = DriverManager.getConnection(url, username, password);) {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("List of Sailors whose Lastname starts with ‘R’ and earn more than $58543 are as follows: ");
            parseAndDisplay(rs, false);
        } catch (SQLException ex) {
            Logger.getLogger(KavyaElchuriAssignment5Q2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method prints the sailors whose salaries are above average
     */
    public void getAvgSalSailors() {
        String query = "select * from sailor s\n"
                + "inner join \n"
                + "(select avg(salary) as sal from sailor) as s1\n"
                + "on s.salary>=s1.sal";
        Statement stmt;
        try (Connection con = DriverManager.getConnection(url, username, password);) {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("The Sailors earning above avergae salaries are:");
            parseAndDisplay(rs, true);
        } catch (SQLException ex) {
            Logger.getLogger(KavyaElchuriAssignment5Q2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method prints the sailor whose salary is the minimum or the maximum
     *
     * @param str - describes if the sailor has min or max
     */
    public void getMinSailor(String str) {

        String query = "select * from sailor s\n"
                + "inner join \n"
                + "(select " + str + "(salary) as sal from sailor) as s1\n"
                + "on s.salary=s1.sal";
        Statement stmt;
        try (Connection con = DriverManager.getConnection(url, username, password);) {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("The Sailor earning " + str + " Salary is :");
            parseAndDisplay(rs, false);
        } catch (SQLException ex) {
            Logger.getLogger(KavyaElchuriAssignment5Q2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method prints the sailors with the maximum salary in each position
     */
    public void getListOfSailorsPosition() {
        String query = "select * from sailor s\n"
                + "inner join \n"
                + "(select max(salary) as sal , position as po from sailor group by position) as s1\n"
                + "on s.salary=s1.sal and s.position = s1.po";
        Statement stmt;
        try (Connection con = DriverManager.getConnection(url, username, password);) {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("list of top-earning sailors in each Position are as follows");
            parseAndDisplay(rs, false);
        } catch (SQLException ex) {
            Logger.getLogger(KavyaElchuriAssignment5Q2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * this method creates and inserts the data
     *
     * @throws SQLException
     */
    public void createAndInsertData() throws SQLException {
        URL name = KavyaElchuriAssignment5Q2.class.getResource("Sailor.txt");
        file = new File(name.getPath());
        String insertQuery = "INSERT INTO SAILOR VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt;

        try (Connection connect = DriverManager.getConnection(url, username, password);) {
            input = new Scanner(file);
            String line = "";
            String fname, lname, position;
            long salary;
            input.nextLine();
            while (input.hasNextLine()) {
                pstmt = connect.prepareStatement(insertQuery);
                //System.out.println(input.nextLine());
                line = input.nextLine();
                String[] elements = line.split("\\,");
                lname = elements[0];
                fname = elements[1];
                position = elements[2];
                salary = Long.parseLong(elements[3]);
                pstmt.setString(1, fname);
                pstmt.setString(2, lname);
                pstmt.setString(3, position);
                pstmt.setLong(4, salary);
                int rs = pstmt.executeUpdate();
                //System.out.println(lname + "   " + fname + "   " + position + "   " +  salary);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(KavyaElchuriAssignment5Q2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Specified File either does not exist or is not found");
        }

    }

    /**
     * This method connects to the database taking url, username and password
     */
    public void connectToDatabase() {

        try (Connection connect = DriverManager.getConnection(url, username, password);) {
            con = connect;
            String query = "CREATE TABLE SAILOR (\n"
                    + " FIRSTNAME VARCHAR(40) NOT NULL, \n"
                    + "	LASTNAME VARCHAR(40) NOT NULL,\n"
                    + "	POSITION VARCHAR(40),\n"
                    + "	SALARY REAL)";

            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (java.sql.SQLTransactionRollbackException ex) {

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //This method parses the result Set and prints the Data correctly
    private void parseAndDisplay(ResultSet rs, boolean flag) throws SQLException {
        if (!flag) {
            System.out.printf("%-30s%-30s%-15s%-10s\n", FNAME, LNAME, POSITION, SALARY);

        }
        boolean toBePrinted = true;
        while (rs.next()) {
            String fname = rs.getString(FNAME);
            String lname = rs.getString(LNAME);
            String position = rs.getString(POSITION);
            Long salary = rs.getLong(SALARY);
            if (flag && toBePrinted) {
                toBePrinted = false;
                System.out.println("The average salary is $" + rs.getLong("SAL"));
                System.out.printf("%-30s%-30s%-15s%-10s\n", FNAME, LNAME, POSITION, SALARY);

            }
            //System.out.println(fname + "  " + lname + "  " + position + "  " + salary);
            System.out.printf("%-30s%-30s%-15s%-10s\n", fname, lname, position, salary);
        }
        System.out.println("\n\n");
    }

}
