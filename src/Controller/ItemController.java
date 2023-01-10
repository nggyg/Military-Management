package Controller;

import Repository.*;
import basic.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        String url ="jdbc:sqlserver://DESKTOP-GLDFCK4;databaseName=MillitaryManagement;user=test;password=123;encrypt=true;trustServerCertificate=true";
        //
        if (newItem.getClass() == Weapon.class) {
            this.weapons.add((Weapon) newItem);
            try {
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                statement.executeUpdate("insert into Weapon (Name, calibre) values (' "+((Weapon) newItem).getName()+
                        " ', ' "+((Weapon) newItem).getCalibre()+" ')");
            }catch(Exception e){
                System.out.println("Failed");
                System.out.println(e.getMessage());
            }
        }
        else if (newItem.getClass() == Armor.class) {
            this.armors.add((Armor) newItem);
            try {
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                statement.executeUpdate("insert into Armor (armorType, armorLightness) values (' "+((Armor) newItem).getArmorType()+
                        " ', ' "+((Armor) newItem).getArmorLightness()+" ')");
            }catch(Exception e){
                System.out.println("Failed");
                System.out.println(e.getMessage());
            }
        }
        else if (newItem.getClass() == Vehicle.class) {
            this.vehicles.add((Vehicle) newItem);
            try {
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                statement.executeUpdate("insert into Vehicle (Name, driver1,driver2,driver3,driver4) values (' "+((Vehicle) newItem).getName()+
                        " ', ' "+((Vehicle) newItem).getDriver()+" ')");
            }catch(Exception e){
                System.out.println("Failed");
                System.out.println(e.getMessage());
            }
        }


    }

    public boolean removeItem(int id) {
        Object foundItem = this.findById(id);
        String url ="jdbc:sqlserver://DESKTOP-GLDFCK4;databaseName=MillitaryManagement;user=test;password=123;encrypt=true;trustServerCertificate=true";
        if (foundItem == null)
            return false;
        if (foundItem.getClass() == Armor.class) {
            this.armors.remove((Armor) foundItem);
            try {
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                statement.executeUpdate("delete from Armor where id = ' "+id+" '");
            }catch(Exception e){
                System.out.println("Failed");
                System.out.println(e.getMessage());
            }
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
    public Repository<Item> getAll(){
        Repository<Item> everything=new Repository<Item>();
        for(Weapon weapon:this.weapons.getContent())
            everything.add(weapon);
        for(Armor armor:this.armors.getContent())
            everything.add(armor);
        for(Vehicle vehicle:this.vehicles.getContent())
            everything.add(vehicle);
        return everything;
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
        ArrayList<String> WeaponParams=new ArrayList<>();
        System.out.print("New weapon name: ");
        WeaponParams.set(1, scan.next());
        System.out.print("New calibre name: ");
        WeaponParams.set(2, scan.next());
        scan.close();
        return WeaponParams;
    }
    private ArrayList<String> armor_data_text(){
        Scanner scan=new Scanner(System.in);
        ArrayList<String> ArmorParams=new ArrayList<>();
        System.out.print("New Armor type: ");
        ArmorParams.set(1,scan.next());
        System.out.print("New Armor lightness: ");
        ArmorParams.set(2,scan.next());
        scan.close();
        return ArmorParams;
    }
    private String vehicle_data_text(){
        Scanner scan=new Scanner(System.in);
        System.out.print("New vehicle name: ");
        String param=scan.next();
        scan.close();
        return param;
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
                return updateVehicle(vehicle_data_text(), found.getID());
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
