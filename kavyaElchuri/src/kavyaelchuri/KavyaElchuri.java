/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuri;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kavya
 */
public class KavyaElchuri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        List<Monster> monsters = new ArrayList();
        monsters.add(new Monster("Godzilla", 11, 10, 2000, "VenomThrower"));
        monsters.add(new UglyMonster("Shark", 12, 02, 1900, "Jaw"));
        monsters.add(new SweetMonster("JigglyPuff", 11, 11, 1992, "DreamCatcher"));
        monsters.add(new CookieMonster("CookieMan",28 , 03, 1800, "ChocochipCookies", random.nextInt(100)));
        monsters.add(new JellyBeanMonster("JillyJelly", 16, 10, 1993, "IcedJellies", random.nextInt(100)));  
        for(Monster monster: monsters) {
            System.out.println(monster.toString());
            if(monster instanceof UglyMonster) {
                System.out.println("Call the status method: " + ((UglyMonster) monster).status());
            } else if(monster instanceof SweetMonster) {
                System.out.println("Call the isDiabetic method: " + ((SweetMonster) monster).isDiabetic());
            }
          
        }
    }

}

class Monster {

    String name;

    MyDate dateofbirth;

    Weapon weapon;

    Monster(String name, int day, int month, int year, String weaponName) {
        this.name = name;
        this.dateofbirth = new MyDate(year, month, day);
        this.weapon = new Weapon(weaponName);
    }
    
    public String toString(){
        return "Name : "+name + ", DOB : " + dateofbirth.toString() + ", Weapon : " + weapon.toString();
    }

}

class UglyMonster extends Monster {

    private Integer id;

    public UglyMonster(String name, int day, int month, int year, String weaponName) {
        super(name, day, month, year, weaponName);
        Random random = new Random();
        setId(random.nextInt(100));
    }

    public String status() {
        return new String("I am in the Ugly Monster Class");
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String toString(){
        return "Name : "+name + ", DOB : " + dateofbirth.toString() + ", Weapon : " + weapon.toString() + ", Id : " + getId();
    }

}

class SweetMonster extends Monster {

    private double bloodSugarLevel;

    public SweetMonster(String name, int day, int month, int year, String weaponName) {
        super(name, day, month, year, weaponName);
        Random random = new Random();
        setBloodSugarLevel(random.nextInt(500));
    }

    public boolean isDiabetic() {
        return getBloodSugarLevel() > 200;
    }

    /**
     * @return the bloodSugarLevel
     */
    public double getBloodSugarLevel() {
        return bloodSugarLevel;
    }

    /**
     * @param bloodSugarLevel the bloodSugarLevel to set
     */
    public void setBloodSugarLevel(double bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }
    
    public String toString(){
        return "Name : "+name + ", DOB : " + dateofbirth.toString() + ", Weapon : " + weapon.toString() + ", Blood Sugar Level : " + bloodSugarLevel;
    }

}

class CookieMonster extends SweetMonster{
    
    private int numberofCookiesLeft;
    
    public CookieMonster(String name, int day, int month, int year, String weaponName, int cookies) {
        super(name, day, month, year, weaponName);
        this.numberofCookiesLeft = cookies;
    }
    
    public String toString(){
        return "Name : "+name + ", DOB : " + dateofbirth.toString() + ", Weapon : " + weapon.toString() + ", Number of Cookies Left : " + numberofCookiesLeft;
    }
    
    
}

class JellyBeanMonster extends SweetMonster{
    
    private int numberofBeansLeft;
    
    public JellyBeanMonster(String name, int day, int month, int year, String weaponName, int beans) {
        super(name, day, month, year, weaponName);
        this.numberofBeansLeft = beans;
    }
    
    public String toString(){
        return "Name : "+name + ", DOB : " + dateofbirth.toString() + ", Weapon : " + weapon.toString() + ", Number of Beans Left : " + numberofBeansLeft;
    }
    
    
}

class Weapon {

    private String name;

    Weapon(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }
    
    public String toString(){
        return getName();
    }

}

class MyDate {

    private int year;

    private int month;

    private int day;

    MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }
    
    public String toString(){
        return this.day + "-" + this.month + "-" + this.year;
    }
}
