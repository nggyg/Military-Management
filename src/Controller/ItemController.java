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
    public void add(Item newItem){
        if(newItem.getClass()== Weapon.class)
            this.weapons.add((Weapon) newItem);
        else if(newItem.getClass()== Armor.class)
            this.armors.add((Armor) newItem);
        else if(newItem.getClass()== Vehicle.class)
            this.vehicles.add((Vehicle) newItem);
    }
    public boolean removeItem(int id){
        Item foundItem=this.findById(id);
        if(foundItem==null)
            return false;
        if(foundItem.getClass()==Armor.class){
            this.armors.remove((Armor) foundItem);
            return true;
        }
        else if(foundItem.getClass()== Weapon.class){
            this.weapons.remove((Weapon) foundItem);
            return true;
        }
        else if(foundItem.getClass()== Vehicle.class){
            this.vehicles.remove((Vehicle) foundItem);
            return true;
        }
        return false;
    }
    public boolean update(int id){
        Item foundItem=this.findById(id);
        if(foundItem==null)
            return false;
        if (foundItem.getID() == id) {
            if(foundItem.getClass()==Armor.class){
                //what?
            }
            else if(foundItem.getClass()== Weapon.class){
                //the
            }
            else if(foundItem.getClass()== Vehicle.class){
                //f*ck?
            }
            return true;
        }
        return false;
    }
    public void display(){
        this.weapons.display();
        this.armors.display();
        this.vehicles.display();
    }
}
