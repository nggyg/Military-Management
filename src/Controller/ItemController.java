package Controller;

import Repository.*;
import basic.*;

import java.util.ArrayList;

public class ItemController {
    private Repository<Weapon> weapons;
    private Repository<Armor> armors;
    private Repository<Vehicle> vehicles;

    public ItemController(Repository<Item> content) {
        this.weapons = new Repository<Weapon>(new ArrayList<Weapon>());
        this.armors = new Repository<Armor>(new ArrayList<Armor>());
        this.vehicles = new Repository<Vehicle>(new ArrayList<Vehicle>());
    }

    private Repository<Item> content;

    public Item findById(int id) {
        for (Item item : weapons.getContent()) {
            if (item.getID() == id) {
                return item;
            }
        }
        for (Item item : armors.getContent()) {
            if (item.getID() == id) {
                return item;
            }
        }
        for (Item item : vehicles.getContent()) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    public void add(Item newItem) {
        if (newItem.getClass() == Weapon.class)
            this.weapons.add((Weapon) newItem);
        else if (newItem.getClass() == Armor.class)
            this.armors.add((Armor) newItem);
        else if (newItem.getClass() == Vehicle.class)
            this.vehicles.add((Vehicle) newItem);
    }

    public boolean removeItem(int id) {
        Object foundItem = this.findById(id);
        if (foundItem == null)
            return false;
        if (foundItem.getClass() == Armor.class) {
            this.armors.remove((Armor) foundItem);
            return true;
        } else if (foundItem.getClass() == Weapon.class) {
            this.weapons.remove((Weapon) foundItem);
            return true;
        } else if (foundItem.getClass() == Vehicle.class) {
            this.vehicles.remove((Vehicle) foundItem);
            return true;
        }
        return false;
    }

    public boolean updateWeapon(String newName, double newCalibre, int id) {
        for (Weapon weapon : weapons.getContent()) {
            if (id == weapon.getID()) {
                weapon.setCalibre(newCalibre);
                weapon.setName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean updateArmor(String newArmorType, String newArmorLightness, int id) {
        for (Armor armor : armors.getContent()) {
            if (id == armor.getID()) {
                armor.setArmorLightness(newArmorLightness);
                armor.setArmorType(newArmorType);
                return true;
            }
        }
        return false;
    }

    public boolean updateVehicle(String newName, int id) {
        for (Vehicle vehicle : vehicles.getContent()) {
            if (id == vehicle.getID()) {
                vehicle.setName(newName);
                return true;
            }
        }
        return false;
    }
}
//    public boolean update(int id){
//        for(Item item:this.content.getContent()) {
//            if (item.getID() == id) {
//                if(item.getClass()==Armor.class){
//                    //what?
//                }
//                else if(item.getClass()== Weapon.class){
//                    //the
//                }
//                else if(item.getClass()== Vehicle.class){
//                    //f*ck?
//                }
//                return true;
//            }
//        }
//        return false;
//    }
//    public void display(){
//        this.weapons.display();
//        this.armors.display();
//        this.vehicles.display();
//    }
//}
