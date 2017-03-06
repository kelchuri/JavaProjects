/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kavyaelchuriassignment4;

import java.util.Date;
import java.util.List;

/**
 * This class defines cruise
 * @author kavya
 */
public class Cruise {

    /**
     *
     * @param serialNo
     * @param sailingDate
     * @param returnDate
     */
    public Cruise(int serialNo, Date sailingDate, Date returnDate) {
        this.serialNo = serialNo;
        this.sailingDate = sailingDate;
        this.returnDate = returnDate;
    }

    private int serialNo;

    private Date sailingDate;

    private Date returnDate;

    private Port departingPort;

    private double cost = 900;

    private Ship ship;

    private List<Port> ports;

    private List<Passenger> passengers;

    /**
     *
     * @param ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     *
     * @return ship
     */
    public Ship getShip() {
        return this.ship;
    }

    /**
     *
     * @param ports
     */
    public void setPorts(List ports) {
        this.ports = ports;
    }

    /**
     *
     * @param passengers
     */
    public void setPassenegrs(List passengers) {
        this.passengers = passengers;
    }

    /**
     *
     * @return ports
     */
    public List<Port> getPorts() {
        for (Port s : ports) {
            //System.out.println(s.getName() + " " + s.isPassportRequired());
        }
        return this.ports;
    }

    /**
     *
     * @return list of passengers
     */
    public List<Passenger> getPassenegrs() {
        for (Passenger s : passengers) {
            // System.out.println(s.getName() + " " + s.getMoneySpentOnCruise() + " " + 
            //       (s.getDob()) + " " + s.getNationality());
        }
        return passengers;
    }

    //"passengers" list
    //ports list
    /**
     * @return the serialNo
     */
    public int getSerialNo() {
        return serialNo;
    }

    /**
     * @return the sailingDate
     */
    public Date getSailingDate() {
        return sailingDate;
    }

    /**
     * @param sailingDate the sailingDate to set
     */
    public void setSailingDate(Date sailingDate) {
        this.sailingDate = sailingDate;
    }

    /**
     * @return the returnDate
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the departingPort
     */
    public Port getDepartingPort() {
        return departingPort;
    }

    /**
     * @param departingPort the departingPort to set
     */
    public void setDepartingPort(Port departingPort) {
        this.departingPort = departingPort;
    }

}
