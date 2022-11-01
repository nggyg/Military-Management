package Controller;

import Repository.*;
import basic.*;

import java.util.ArrayList;

public class ItemController {
    private Repository<Weapon> weapons;
    private Repository<Armor> armors;
    private Repository<Vehicle> vehicles;

    public ItemController(Repository<Item> content) {
        this.content = content;
//        this.weapons = new Repository<Weapon>(new ArrayList<Weapon>());
//        this.armors = new Repository<Armor>(new ArrayList<Armor>());
//        this.vehicles = new Repository<Vehicle>(new ArrayList<Vehicle>());
    }

    private Repository<Item> content;

    public Item findById(int id) {
        for (Item item : content.getContent()) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    public void add(Item newItem) {
        this.content.add(newItem);
    }

    public boolean removeItem(int id) {
        for (Item item : this.content.getContent()) {
            if (item.getID() == id) {
                this.content.remove(item);
                return true;
            }
        }
        return false;
    }

//    public void updateWeapon(String newName, double newCalibre, int id){
//        for(Weapon weapon:)
//    }

    public boolean update(int id) {
        for (Item item : this.content.getContent()) {
            if (item.getID() == id) {
                Weapon weapon=new Weapon();
                Armor armor=new Armor();
                Vehicle vehicle=new Vehicle();
                if (Weapon.class.equals(item.getClass())) {
                    //ask for updated values

                }
                else if (Armor.class.equals(item.getClass())) {
                    //ask for updated values
                }
                else if (Vehicle.class.equals(item.getClass())) {
                    //ask for updated values
                }
                return true;
            }
        }
        return false;
    }

    public void display() {
        this.content.display();
    }
}
