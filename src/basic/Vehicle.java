package basic;

import java.util.*;

public class Vehicle extends Item {
    private String name;
    private int vehicleID;
    private Soldier driver;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Soldier getDriver() {
        return driver;
    }

    public void setDriver(Soldier driver) {
        this.driver = driver;
    }

    public Vehicle(String name, int id, Soldier driver) {
        this.name = name;
        this.vehicleID = id;
        this.driver = driver;
    }

    @Override
    public void assignedTo(Soldier soldier) {

    }

    public Vehicle() {
        this.name="TBD";
    }

    @Override
    public String toString(){
        return this.getName();
    }
    @Override
    public boolean usable() {
        return false;
    }
}
