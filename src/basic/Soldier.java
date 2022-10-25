package basic;

import java.util.Map;
import java.util.ArrayList;

public class Soldier extends Person{
    private Rang rang;
    private Map.Entry<Weapon,Armor> equipment;
    private ArrayList<Vehicle> vehicleList;

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Soldier(String name, int id, Rang rang) {
        super(name, id);
        this.rang=rang;
    }

    public Rang rang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }
}
