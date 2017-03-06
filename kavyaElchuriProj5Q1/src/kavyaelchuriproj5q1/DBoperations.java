/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriproj5q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class has all the db interactions
 *
 * @author kavya
 */
public class DBoperations {

    private File file;

    private Scanner input;

    private final List<String> options = Arrays.asList("a", "b", "c", "d", "A", "B", "C", "D");

    private int score;
    private int wrong;
    private Connection con;
    private final String url = "jdbc:derby:ExamDB;create=true";
    private final String username = "adminuser";
    private final String password = "adminuser";

    /**
     * This method connects to the database and creates the table
     */
    public void connectToDatabase() {

        try (Connection connect = DriverManager.getConnection(url, username, password);) {

            String query = "CREATE TABLE QUIZ (\n"
                    + " QUESTION_NO REAL NOT NULL, \n"
                    + " LEVEL VARCHAR(100) NOT NULL, \n"
                    + " QUESTION VARCHAR(100) NOT NULL, \n"
                    + "	CHOICE1 VARCHAR(60) NOT NULL,\n"
                    + " CHOICE2 VARCHAR(60) NOT NULL,\n"
                    + "	CHOICE3 VARCHAR(60) NOT NULL,\n"
                    + " CHOICE4 VARCHAR(60) NOT NULL,\n"
                    + "	ANSWER VARCHAR(2) NOT NULL)";

            Statement stmt = connect.createStatement();
            stmt.execute(query);
        } catch (java.sql.SQLTransactionRollbackException ex) {

        } catch (SQLException ex) {
            //System.out.println(ex);
        }
    }

    /**
     * This method inserts the data into the quiz table
     *
     * @throws SQLException
     */
    public void createAndInsertData() throws SQLException {
        URL name = DBoperations.class.getResource("Questions.txt");
        file = new File(name.getPath());
        String insertQuery = "INSERT INTO QUIZ VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
        PreparedStatement pstmt;

        try (Connection connect = DriverManager.getConnection(url, username, password);) {
            input = new Scanner(file);
            String line = "";
            String question, o1, o2, o3, o4, ans, level;
            int no;

            while (input.hasNextLine()) {
                pstmt = connect.prepareStatement(insertQuery);
                line = input.nextLine();
                String[] elements = line.split("\\,");
                no = Integer.parseInt(elements[0]);
                level = elements[1];
                question = elements[2];
                o1 = elements[3];
                o2 = elements[4];
                o3 = elements[5];
                o4 = elements[6];
                ans = elements[7];
                pstmt.setInt(1, no);
                pstmt.setString(2, level);
                pstmt.setString(3, question);
                pstmt.setString(4, o1);
                pstmt.setString(5, o2);
                pstmt.setString(6, o3);
                pstmt.setString(7, o4);
                pstmt.setString(8, ans);
                int rs = pstmt.executeUpdate();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(KavyaElchuriProj5Q1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Specified File either does not exist or is not found");
        }

    }

    /**
     * This method fetches three questions at Random
     */
    public void getAllQuestions() {
        String query = "select * from QUIZ order by random() fetch next 3 row only";
        Statement stmt;
        try (Connection con = DriverManager.getConnection(url, username, password);) {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Your Exam starts now:");
            parseAndDisplay(rs);
        } catch (SQLException ex) {
            Logger.getLogger(KavyaElchuriProj5Q1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method drops the quiz table
     */
    public void droptable() {
        String query = "drop table quiz";
        Statement stmt;
        try (Connection con = DriverManager.getConnection(url, username, password);) {
            stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KavyaElchuriProj5Q1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //This method parses and prints the questions for the MCQ test
    private void parseAndDisplay(ResultSet rs) throws SQLException {
        input = new Scanner(System.in);
        while (rs.next()) {
            String Question = rs.getString("QUESTION");
            String c1 = rs.getString("CHOICE1");
            String c2 = rs.getString("CHOICE2");
            String c3 = rs.getString("CHOICE3");
            String c4 = rs.getString("CHOICE4");
            String answer = rs.getString("ANSWER");

            System.out.println(Question);
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
            System.out.println("Please print your option:");
            fetchAnswer(answer);

        }
        System.out.println("Your score is : " + score);
        System.out.println("Number of wrong answers is : " + wrong);
        System.out.println("\n\n");
    }

    // This method reads the answer and asseses it to be right or wrong
    private void fetchAnswer(String answer) {
        String ans = input.nextLine();
        if (validateAns(ans)) {
            if (answer.equalsIgnoreCase(ans)) {
                score++;
            } else {
                wrong++;
            }
        } else {
            System.out.println("Please choose one of the options - a,b,c,d!!");
            fetchAnswer(answer);
        }
    }

    // This method validates if the answer inserted matches the expected one.
    private boolean validateAns(String ans) {
        if (options.contains(ans)) {
            return true;
        }
        return false;
    }
}
