/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

/**
 * This class has port info
 * @author kavya
 */
public class Port {

    /**
     *
     * @param name
     * @param country
     * @param population
     * @param passportRequired
     */
    public Port(String name, String country, long population, boolean passportRequired) {
        this.name = name;
        this.country = country;
        this.population = population;
        this.passportRequired = passportRequired;
    }

    private String name;

    private String country;

    private long population;

    private boolean passportRequired;

    private int dockingFee;

    /**
     *
     * @param weight
     * @return
     */
    public int getDockingFee(double weight) {
        if (weight < 30000) {
            dockingFee = 20000;
        } else if (30000 < weight && weight < 50000) {
            dockingFee = 50000;
        } else {
            dockingFee = 100000;
        }
        return dockingFee;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * @return the passportRequired
     */
    public boolean isPassportRequired() {
        return passportRequired;
    }

    /**
     * @param passportRequired the passportRequired to set
     */
    public void setPassportRequired(boolean passportRequired) {
        this.passportRequired = passportRequired;
    }

}
