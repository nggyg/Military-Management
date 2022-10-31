package basic;

import java.util.*;

public class Vehicle extends Item {
    private String name;
    private int vehicleID;
    private ArrayList<Soldier> driverList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public ArrayList<Soldier> getDriverList() {
        return driverList;
    }

    public void setDriverList(ArrayList<Soldier> driverList) {
        this.driverList = driverList;
    }

    public Vehicle(String name, int id, ArrayList<Soldier> driverList) {
        this.name = name;
        this.vehicleID = id;
        this.driverList = driverList;
    }

    @Override
    public void assignedTo(Soldier soldier) {

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
