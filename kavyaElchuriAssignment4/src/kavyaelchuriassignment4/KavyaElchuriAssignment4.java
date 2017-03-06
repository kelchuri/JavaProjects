/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This is the starter class
 *
 * @author kavya
 */
public class KavyaElchuriAssignment4 {

    private Scanner input;

    private File file;

    private Ship ship;

    private Cruise cruise;

    private Map<String, ArrayList<Passenger>> passengerMap = new LinkedHashMap();

    private Map ageMap = new HashMap();

    private final String LESSTHAN20 = "<=20";

    private final String LESSTHAN50 = "20-50";

    private final String ABOVE50 = ">50";

    private long totalSalaries;

    private long dockingFee;

    private DateFormat df = new SimpleDateFormat("MM/dd/yy");

    private SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    private static final List randomReviews
            = Arrays.asList("The Cruise was Good", "The cruise was Bad", "the cruise was Okay");

    private long[][] report;
    
    private boolean manual = true; 

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.text.ParseException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
        // TODO code application logic here
        KavyaElchuriAssignment4 starter = new KavyaElchuriAssignment4();
        starter.createCruise();
        starter.createShip();
        starter.createSailors();
        starter.createPorts();
        starter.createPassengers();
        starter.displayReportOne();
        starter.sailorDetails();
        starter.portDetails();
        starter.passengerDetails();
        starter.passengerReviews();
        starter.ifShipMadeProfit();
        starter.dumpIntoFile();
    }

    /**
     * Creates and returns a random review
     *
     * @return random review
     */
    private String generateRandomReview() {
        Random random = new Random();
        int index = random.nextInt(randomReviews.size());
        return (String) randomReviews.get(index);
    }

    /**
     * generates a random rating
     *
     * @param review
     * @return
     */
    private int getRating(String review) {
        Random random = new Random();
        int rating;
        if (review.contains("good")) {
            rating = (random.nextInt() % 2 == 0) ? 4 : 5;
        } else if (review.contains("bad")) {
            rating = (random.nextInt() % 2 == 0) ? 2 : 1;
        } else {
            rating = 3;
        }
        return rating;
    }

    /**
     * creates a random cruise
     *
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void createCruise() throws FileNotFoundException, ParseException {
        URL name = KavyaElchuriAssignment4.class.getResource("Cruise.txt");
        file = new File(name.getPath());

        Random random = new Random();
        int number = random.nextInt(100);

        String line = getRandomLine(number);
        String[] elements = line.split("\\|");

        int id = Integer.parseInt(elements[0]);

        Date start = df.parse(elements[1]);
        Date end = df.parse(elements[2]);
        cruise = new Cruise(id, start, end);

    }

    /**
     * Creates a random ship
     *
     * @throws FileNotFoundException
     */
    public void createShip() throws FileNotFoundException {
        URL name = KavyaElchuriAssignment4.class.getResource("Ship.txt");
        file = new File(name.getPath());

        Random random = new Random();
        int number = random.nextInt(100);

        String line = getRandomLine(number);
        String[] elements = line.split("\\|");

        int id = Integer.parseInt(elements[0]);
        String shipName = elements[1];
        Double weight = Double.parseDouble(elements[2]);
        int year = Integer.parseInt(elements[3]);
        int capacity = Integer.parseInt(elements[4]);

        ship = new Ship(id, shipName, weight, year, capacity);
        cruise.setShip(ship);
    }

    /**
     * creates random sailors
     *
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void createSailors() throws FileNotFoundException, ParseException {

        URL name = KavyaElchuriAssignment4.class.getResource("Sailors.txt");
        file = new File(name.getPath());

        String line;
        String[] elements;
        String type, n, nationality;
        Date dob;
        int id;
        Sailor s = null;

        Random random = new Random();
        for (int i = 0; i < 25; i++) {

            line = getRandomLine(random.nextInt(100));
            elements = line.split("\\|");
            type = elements[0];
            id = Integer.parseInt(elements[1]);
            n = elements[2];
            dob = df.parse(elements[3]);
            nationality = elements[4];

            if (type.equals("sailor")) {
                s = new Sailor(id, n, dob, nationality);
            } else if (type.equals("doctor")) {
                s = new Doctor(id, n, dob, nationality);
            } else if (type.equals("cook")) {
                s = new Cook(id, n, dob, nationality);
            } else if (type.equals("engineer")) {
                s = new Engineer(id, n, dob, nationality);
            } else if (type.equals("captain")) {
                s = new Captain(id, n, dob, nationality);
            }
            ship.addSailor(s);
        }

    }

    /**
     * Creates random ports
     *
     * @throws FileNotFoundException
     */
    public void createPorts() throws FileNotFoundException {

        URL fileName = KavyaElchuriAssignment4.class.getResource("port.txt");
        file = new File(fileName.getPath());
        List<Port> ports = new ArrayList();
        String line;
        String[] elements;
        String name, country, population;
        boolean requiresPassport;
        long id;
        Port p = null;

        Random random = new Random();
        for (int i = 0; i < 25; i++) {

            line = getRandomLine(random.nextInt(100));
            elements = line.split("\\|");
            name = elements[0];
            country = elements[1];
            id = Long.parseLong(elements[2]);
            if (elements[3].equals("1")) {
                requiresPassport = true;

            } else {
                requiresPassport = false;
            }

            p = new Port(name, country, id, requiresPassport);
            ports.add(p);
        }

        cruise.setPorts(ports);
    }

    /**
     * Creates random Passengers
     *
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void createPassengers() throws FileNotFoundException, ParseException {

        URL fileName = KavyaElchuriAssignment4.class.getResource("Passengers.txt");
        file = new File(fileName.getPath());
        List<Passenger> passengers = new ArrayList();
        String line;
        String[] elements;
        String number, name, address, nationality;
        boolean requiresPassport;
        Date dob;
        long years;
        int id;
        double expenses;
        Passenger p = null;
        
        Scanner input = new Scanner(System.in);
        while(manual){
            System.out.println("Do you wish to add a Passenger? Enter -999 to proceed "
                    + "randomly, press 1 to continue!");
            int code = input.nextInt();
            input.nextLine();
            if(code==-999){
                manual = false;
                break;
            } else {
                System.out.println("Please Enter the name");
                String pname = input.nextLine();
                System.out.println("Enter the id");
                int pid = input.nextInt();
                input.nextLine();
                System.out.println("Enter address");
                String add = input.nextLine();
                System.out.println("Enter Nationality");
                String nation = input.nextLine();
                System.out.println("Enter Date Of Birth in mm/dd/yyyy format");
                Date date = df.parse(input.nextLine());
                System.out.println("Enter the money Spent on Cruise");
                Double money = input.nextDouble();
                input.nextLine();
                System.out.println("Enter The Review");
                String review1 = input.nextLine();
                System.out.println("Enter the rating");
                int rating1 = input.nextInt();
                p = new Passenger(pid, pname, add, nation, date, money);
                passengers.add(p);
                CruisePassengerInfo info = new CruisePassengerInfo(p, rating1, review1);
                p.addReview(info);
            }
        } 
        
        Random random = new Random();
        for (int i = 0; i < 25; i++) {

            line = getRandomLine(random.nextInt(100));
            elements = line.split("\\|");
            id = Integer.parseInt(elements[0]);
            name = elements[1];
            address = elements[2];
            nationality = elements[3];
            dob = df.parse(elements[4]);
            Double moneySpent = Double.parseDouble(elements[5]);

            p = new Passenger(id, name, address, nationality, dob, moneySpent);
            String review = generateRandomReview();
            int rating = getRating(review);
            CruisePassengerInfo info = new CruisePassengerInfo(p, rating, review);
            p.addReview(info);

            passengers.add(p);
        }

        cruise.setPassenegrs(passengers);
        cruise.getPassenegrs();
       
        
    }

    /**
     * Displays the reports on the revenue on nationality and age basis
     */
    public void displayReportOne() {
        passengerMap = (Map) cruise.getPassenegrs().stream().
                collect(Collectors.groupingBy(p -> ((Passenger) p).getNationality()));
        int i = 0, year1, year2, years;

        report = new long[4][passengerMap.size() + 1];

        int sum_20 = 0, sum_50 = 0, sum_above = 0;
        for (Map.Entry<String, ArrayList<Passenger>> entry : passengerMap.entrySet()) {
            int sum = 0;
            for (Passenger p : entry.getValue()) {
                sum += p.getMoneySpentOnCruise();
                year1 = Integer.parseInt(sdfYear.format(p.getDob()));
                year2 = Integer.parseInt(sdfYear.format(new Date()));

                years = year2 - year1;
                if (years <= 20) {
                    report[0][i]++;
                    sum_20 += p.getMoneySpentOnCruise();
                } else if (years > 20 && years <= 50) {
                    report[1][i]++;
                    sum_50 += p.getMoneySpentOnCruise();
                } else {
                    sum_above += p.getMoneySpentOnCruise();
                    report[2][i]++;
                }
            }
            report[3][i] = sum;
            System.out.println("The Revenue from " + entry.getKey() + "is " + sum + "$");
            i++;
        }
        report[0][passengerMap.size()] = sum_20;
        report[1][passengerMap.size()] = sum_50;
        report[2][passengerMap.size()] = sum_above;

        report[3][passengerMap.size()] = report[0][passengerMap.size()]
                + report[1][passengerMap.size()] + report[2][passengerMap.size()];
        System.out.println("The revenue from AgeGroup 0-20 Years is " + sum_20 + "$");
        System.out.println("The revenue from AgeGroup 20-50 Years is " + sum_50 + "$");
        System.out.println("The revenue from AgeGroup 50 and above Years is " + sum_above + "$");
        System.out.println("The total revenue Generated is " + report[3][passengerMap.size()] + "$");
        System.out.println("The Break down is as follows where"
                + " row denotes the 0-20, 20-50 and 50 above order and column denotes the country in the order printed above."
                + "The 4th row denotes the country wise revenue and the last column denotes the age wise revenue:");
        List<String> keys = new ArrayList(passengerMap.keySet());
        for (int k = 0; k < 4; k++) {

            for (int j = 0; j < passengerMap.size() + 1; j++) {
                System.out.printf("%10d", report[k][j]);
            }
            System.out.println();
        }

    }

    /**
     * Displays reports on sailor details
     */
    public void sailorDetails() {
        System.out.println();
        System.out.println("Report On Sailors:");
        System.out.printf("%20s%20s", "SailorName", "Salary");
        System.out.println();
        for (Sailor s : cruise.getShip().getSailors()) {
            System.out.printf("%20s%20s", s.getName(), String.valueOf(s.getSalary()));
            System.out.println();
            totalSalaries += s.getSalary();
        }
        System.out.println("Total salary amount " + totalSalaries + "$");
    }

    /**
     * Displays reports on Ports
     */
    public void portDetails() {
        System.out.println();
        System.out.println("Report On Ports:");
        System.out.println();
        for (Port p : cruise.getPorts()) {
            dockingFee += p.getDockingFee(ship.getWeight());
        }
        System.out.println("Total Port Docking amount " + dockingFee + "$");
    }

    /**
     * Displays reports on passengers on money in the sorted order
     */
    public void passengerDetails() {
        System.out.println();
        System.out.println("Report On Passengers:");
        System.out.printf("%20s%20s", "PassengerName", "MoneySpent");
        System.out.println();
        Collections.sort(cruise.getPassenegrs(), new Comparator() {
            public int compare(Object o1, Object o2) {
                Double nation1 = ((Passenger) o1).getMoneySpentOnCruise();
                Double nation2 = ((Passenger) o2).getMoneySpentOnCruise();
                int comp = nation1.compareTo(nation2);
                return comp;
            }
        });
        Collections.reverse(cruise.getPassenegrs());
        for (Passenger p : cruise.getPassenegrs()) {
            System.out.printf("%20s%20s", p.getName(), String.valueOf(p.getMoneySpentOnCruise()));
            System.out.println();
        }
    }

    /**
     * Displays cruise reviews by passengers
     */
    public void passengerReviews() {
        System.out.println();
        System.out.println("Report On reviews:");
        System.out.printf("%20s%20s%10s", "PassengerName", "Review", "rating");
        System.out.println();
        System.out.println();
        for (Passenger p : cruise.getPassenegrs()) {
            System.out.printf("%20s%20s%10s", p.getName(), p.getReview().getReview(), String.valueOf(p.getReview().getRating()));
            System.out.println();
        }
    }

    /**
     * Shoes if the ship has made any profits
     */
    public void ifShipMadeProfit() {
        System.out.println();
        if (totalSalaries + dockingFee > (report[3][passengerMap.size()] + (passengerMap.size() * 900))) {
            System.out.println("The cruise went into Losses!!");
        } else if (totalSalaries + dockingFee < (report[3][passengerMap.size()] + (passengerMap.size() * 900))) {
            System.out.println("The cruise made Profits!");
        } else {
            System.out.println("The cruise neither made profit nor is bankrupt!!");
        }
        System.out.println();
    }

    /**
     * Dumps all the details into a file
     *
     * @throws IOException
     */
    public void dumpIntoFile() throws IOException {
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/kavyaelchuriassignment4/" + "Result.txt"));
        writer.write(String.format("Sailor Details:"));
        writer.write(System.lineSeparator());
        writer.write(String.format("%-10s%15s%30s%20s", "Name", "Id", "Nation", "Salary"));
        writer.write(System.lineSeparator());
        for (Sailor s : ship.getSailors()) {
            writer.write(String.format("%-10s%15d%30s%20s", s.getName(), s.getId(), s.getNationality(), String.valueOf(s.getSalary())));
            writer.write(System.lineSeparator());

        }
        writer.write(System.lineSeparator());
        writer.write(System.lineSeparator());
        writer.write(String.format("Passenger Details:"));
        writer.write(System.lineSeparator());
        writer.write(String.format("%-10s%25s%20s", "Name", "Nation", "MoneySpent"));
        writer.write(System.lineSeparator());
        for (Passenger p : cruise.getPassenegrs()) {
            writer.write(String.format("%-10s%25s%20s", p.getName(), p.getNationality(), String.valueOf(p.getMoneySpentOnCruise())));
            writer.write(System.lineSeparator());

        }

        writer.write(System.lineSeparator());
        writer.write(System.lineSeparator());
        writer.write(String.format("Port Details:"));
        writer.write(System.lineSeparator());
        writer.write(String.format("%-10s%30s%20s", "Name", "Country", "Passport Required"));
        writer.write(System.lineSeparator());
        for (Port p : cruise.getPorts()) {
            writer.write(String.format("%-10s%30s%20s", p.getName(), p.getCountry(), String.valueOf(p.isPassportRequired())));
            writer.write(System.lineSeparator());

        }
        writer.close();

    }

    /**
     *
     * @param number
     * @return
     * @throws FileNotFoundException
     */
    private String getRandomLine(int number) throws FileNotFoundException {
        input = new Scanner(file);
        input.nextLine();
        String line = "";
        for (int i = 0; i < number + 1; i++) {
            line = input.nextLine();
        }
        input.close();
        return line;
    }

}
