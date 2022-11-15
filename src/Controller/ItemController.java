package Controller;

import Repository.*;
import basic.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemController {
    private Repository<Weapon> weapons;
    private Repository<Armor> armors;
    private Repository<Vehicle> vehicles;

    public ItemController() {
        this.weapons = new Repository<Weapon>(new ArrayList<Weapon>());
        this.armors = new Repository<Armor>(new ArrayList<Armor>());
        this.vehicles = new Repository<Vehicle>(new ArrayList<Vehicle>());
    }

    public ItemController(Repository<Item> itemRepository){
        this.weapons = new Repository<Weapon>(new ArrayList<Weapon>());
        this.armors = new Repository<Armor>(new ArrayList<Armor>());
        this.vehicles = new Repository<Vehicle>(new ArrayList<Vehicle>());
        for(Item item: itemRepository.getContent()){
            if(item.getClass()==Weapon.class)
                this.weapons.add((Weapon) item);
            if(item.getClass()== Armor.class)
                this.armors.add((Armor) item);
            if(item.getClass()== Vehicle.class)
                this.vehicles.add((Vehicle) item);
        }
    }
    public ItemController(Repository<Weapon> weapons, Repository<Armor> armors, Repository<Vehicle> vehicles) {
        this.weapons = weapons;
        this.armors = armors;
        this.vehicles = vehicles;
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

    public void display() {
        this.weapons.display();
        this.armors.display();
        this.vehicles.display();
    }

    private ArrayList<String> weapon_data_text(){
        Scanner scan=new Scanner(System.in);
        ArrayList<String> Paramlist=new ArrayList<>();
        System.out.print("New weapon name: ");
        Paramlist.set(1, scan.next());
        System.out.print("New calibre name: ");
        Paramlist.set(2, scan.next());
        scan.close();
        return Paramlist;
    }
    private ArrayList<String> armor_data_text(){
        Scanner scan=new Scanner(System.in);
        ArrayList<String> Paramlist=new ArrayList<String>();
        System.out.print("New Armor type: ");
        Paramlist.set(1,scan.next());
        System.out.print("New Armor lightness: ");
        Paramlist.set(2,scan.next());
        scan.close();
        return Paramlist;
    }
    public boolean update(int id) {
        Item found = findById(id);
        if (found != null) {
            ArrayList<String> params=new ArrayList<>();
            if(found.getClass()== Weapon.class) {
                params=weapon_data_text();
                return updateWeapon(params.get(1), Double.parseDouble(params.get(2)), found.getID());
            }
            if(found.getClass()== Armor.class) {
                params=armor_data_text();
                return updateArmor(params.get(1), params.get(2), found.getID());
            }
            if(found.getClass()==Vehicle.class) {
                return updateVehicle(((Vehicle) found).getName(), found.getID());
            }
            return false;
        }
        return false;
    }
}
//    public void display(){
//        this.weapons.display();
//        this.armors.display();
//        this.vehicles.display();
//    }
//}
