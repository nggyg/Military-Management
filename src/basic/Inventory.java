package basic;

import java.util.ArrayList;

public class Inventory {
    public Inventory(ArrayList<Weapon> weaponsInventory, ArrayList<Armor> armorInventory, ArrayList<Vehicle> vehicleInventory) {
        this.weaponsInventory = weaponsInventory;
        this.armorInventory = armorInventory;
        this.vehicleInventory = vehicleInventory;
    }

    public ArrayList<Weapon> getWeaponsInventory() {
        return weaponsInventory;
    }

    public void setWeaponsInventory(ArrayList<Weapon> weaponsInventory) {
        this.weaponsInventory = weaponsInventory;
    }

    public ArrayList<Armor> getArmorInventory() {
        return armorInventory;
    }

    public void setArmorInventory(ArrayList<Armor> armorInventory) {
        this.armorInventory = armorInventory;
    }

    public ArrayList<Vehicle> getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(ArrayList<Vehicle> vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    private ArrayList<Weapon> weaponsInventory;
    private ArrayList<Armor> armorInventory;
    private ArrayList<Vehicle> vehicleInventory;
}
