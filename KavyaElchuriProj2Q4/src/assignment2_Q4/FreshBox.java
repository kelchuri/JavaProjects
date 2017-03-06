/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_Q4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * FreshBox contains no of trays with a recipe
 *
 * @author kavya
 */
public class FreshBox {

    private final String[] fruitsAndVeggiesList = {"Banana", "Apple", "Cauliflower",
        "Potato", "Capsicum"};

    private final List<Tray> availableTrays = new ArrayList();

    private static final int NO_OF_TRAYS = 4;

    private String recipe;

    private static final String TEMPLATE = " How to Make ";

    private int currentTray;

    private static final int INITIAL_COUNT = 1;

    private List<Tray> traysInBox = new ArrayList<>();

    private Map<String, Integer> duplicateCheck = new HashMap<>();

    /**
     * Generates four random trays
     */
    public void randomTrayGenerator() {
        for (int i = 0; i < NO_OF_TRAYS; i++) {
            Tray tray = getRandomTray();
            addTrayToBox(tray);
        }
    }

    /**
     * All the available trays are stored
     */
    public void getAvailableContents() {
        for (int i = 0; i < fruitsAndVeggiesList.length; i++) {
            Tray tray = getTray(i);
            availableTrays.add(tray);
        }
    }

    /**
     * displays the frequency bar graph
     */
    public void displayResults() {
        System.out.println("The current contents of the box are : " + toString());
        if (takeUserInputs()) {
            System.out.println("The current contents of the box are : " + toString());
        }
    }

    /**
     * takes user input by displaying available and current contents
     */
    public void displayRandomAndAvailable() {
        System.out.println("The contents of the box are:");
        for (int i = 1; i <= getTrayContents().size(); i++) {
            System.out.println(i + " " + traysInBox.get(i - 1).getContent().getName());
        }
        System.out.println("The available options for the box are:");
        for (int i = 1; i <= availableTrays.size(); i++) {
            System.out.println(i + " " + availableTrays.get(i - 1).getContent().getName());
        }
    }

    private Boolean validate(int index, int start, int end) {
        return (index != -999 && index <= end && index > start);
    }

    /**
     * takes user input for substitution
     *
     * @return true or false
     */
    public Boolean takeUserInputs() {
        int box, list;
        displayRandomAndAvailable();
        Scanner out = new Scanner(System.in);
        System.out.println("If you want to replace an item from the box, "
                + "choose its number or if you want to exit, enter -999");
        box = out.nextInt();
        if (validate(box, 0, traysInBox.size())) {
            System.out.println("Choose an item from the available options"
                    + " displayed or if you want to exit, enter -999");
            list = out.nextInt();
            if (validate(list, 0, fruitsAndVeggiesList.length)) {
                removeFromBox(box);
                FreshBox.this.addTrayToBox(box - 1, availableTrays.get(list - 1));
            } else {
                System.out.println("You either exited or entered an "
                        + "invalid option");
                return false;
            }
        } else {
            System.out.println("You either exited or entered an "
                    + "invalid option");
            return false;
        }
        return true;
    }

    /**
     * removes a tray form the box
     *
     * @param box
     */
    public void removeFromBox(int box) {
        duplicateCheck.put(traysInBox.get(box - 1).getContent().getName(),
                duplicateCheck.get(traysInBox.get(box - 1).getContent().getName()) - 1);
    }

    /**
     * generates a random index for tray
     *
     * @return tray
     */
    public Tray getRandomTray() {
        Random random = new Random();
        int index = random.nextInt(5);
        return getTray(index);
    }

    /**
     * generates random tray
     *
     * @param index
     * @return tray
     */
    public Tray getTray(int index) {
        Tray tray;
        tray = new Tray(fruitsAndVeggiesList[index]);
        return tray;
    }

    /**
     * adds a tray to the box
     *
     * @param box
     * @param tray
     */
    public void addTrayToBox(int box, Tray tray) {
        if (currentTray > 4) {
            System.out.println("You cannot add any more items");
        } else {
            traysInBox.set(box, tray);
            currentTray++;
            trackCountForRecipe(tray.getContent());
        }
    }

    /**
     * checks the number of occurrences of each vegetable
     *
     * @param veg
     */
    public void trackCountForRecipe(FruitOrVegetable veg) {
        if (duplicateCheck.containsKey(veg.getName())) {
            duplicateCheck.put(veg.getName(),
                    duplicateCheck.get(veg.getName()) + 1);
        } else {
            duplicateCheck.put(veg.getName(), INITIAL_COUNT);
        }
    }

    /**
     * adds a tray to the box
     *
     * @param tray
     */
    public void addTrayToBox(Tray tray) {
        if (currentTray > 4) {
            System.out.println("You cannot add any more items");
        } else {
            traysInBox.add(tray);
            currentTray++;
            trackCountForRecipe(tray.getContent());
        }

    }

    /**
     * converts the contents of the box to String
     *
     *
     * @return
     */
    public String toString() {
        String content = "";
        for (Tray tray : traysInBox) {
            content += tray.getContent().getName() + " ";
        }
        return content + findTheRecipesToBeAdded();
    }

    /**
     * gets the recipe of the box
     *
     * @return the recipe
     */
    public String findTheRecipesToBeAdded() {
        String recipe = "";
        for (String name : duplicateCheck.keySet()) {
            if (duplicateCheck.get(name) > 1) {
                recipe += TEMPLATE + name;
            }
        }
        return recipe;
    }

    /**
     * @return the noOfTrays
     */
    public int getNoOfTrays() {
        return currentTray;
    }

    /**
     * @return the trayContents
     */
    public List<Tray> getTrayContents() {
        return traysInBox;
    }

    /**
     * @return the duplicateCheck
     */
    public Map<String, Integer> getDuplicateCheck() {
        return duplicateCheck;
    }

    /**
     * @param noOfTrays the noOfTrays to set
     */
    public void setNoOfTrays(int noOfTrays) {
        this.currentTray = noOfTrays;
    }

    /**
     * @param trayContents the trayContents to set
     */
    public void setTrayContents(List<Tray> trayContents) {
        this.traysInBox = trayContents;
    }

    /**
     * @param duplicateCheck the duplicateCheck to set
     */
    public void setDuplicateCheck(Map<String, Integer> duplicateCheck) {
        this.duplicateCheck = duplicateCheck;
    }

}
