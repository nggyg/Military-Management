import Controller.ItemController;
import Controller.SoldierController;
import Repository.Repository;
import basic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {/*

//        itemRepository.display();
//        soldierRepository.display();
//
//        Armor armor = new Armor("Strong","Heavy",1);
//        controller.add(armor);
//        controller.removeItem(2,1);
        controller.resultSoldiers();
        ArrayList<Soldier> soldiers= new ArrayList<Soldier>();
        soldiers = controller.resultSoldiers();
        Soldier soldier1 = soldiers.get(1);
        System.out.println(soldier1.id());
        System.out.println(soldier1.getName());
        System.out.println(soldier1.getRang());*/
        globals globals=new globals();
        Repository<Soldier> soldierRepository = populateSoldierRepo(globals);//new Repository<Soldier>();
        Repository<Item> itemRepository = populateItemsRepo(globals);
        UI ui=new UI(soldierRepository,itemRepository,globals);
        ui.menu();

    }
//

    public static Repository<Soldier> populateSoldierRepo(globals globals) {
        Repository<Soldier> soldierRepository = new Repository<Soldier>();
        SoldierController soldierController = new SoldierController(soldierRepository);
        Soldier newSoldier = new Soldier("Alex", globals.getSolID(), Rang.Private);
        soldierController.addSoldier(newSoldier);
        newSoldier = new Soldier("Bob", globals.getSolID(), Rang.Officer);
        soldierController.addSoldier(newSoldier);
        newSoldier = new Soldier("Martin", globals.getSolID(), Rang.Private);
        soldierController.addSoldier(newSoldier);
        newSoldier = new Soldier("Greg", globals.getSolID(), Rang.General);
        soldierController.addSoldier(newSoldier);
        return soldierRepository;
    }

    public static Repository<Item> populateItemsRepo(globals globals) {
       Repository<Item> itemRepository = new Repository<Item>();
       ItemController itemController = new ItemController(itemRepository);

       Weapon weapon = new Weapon("AK-74", (float) 7.62, globals.getItemID());
       Armor armor = new Armor("Heavy", "Heavy", globals.getItemID());
        Vehicle vehicle = new Vehicle("Humvee",globals.getItemID(),new Soldier("John",2, Rang.Private));

       itemController.add(weapon);
       itemController.add(armor);
       itemController.add(vehicle);
       return itemController.getAll();
    }

    public static void load_basic_data(String filepath) throws FileNotFoundException {
        File memory = new File(filepath);
        if (memory.canRead()) {
            System.out.println(memory);
            Scanner memoscan = new Scanner(memory);
            System.out.println(memoscan.nextLine());
        }
    }
    //public static void main(String[] args) throws FileNotFoundException {/*
//        Registration r = new Registration();
//        r.displaySoldiers();
//
//        r.generalSoldierList.add(new Soldier("Alex",1,Rang.Private));
//        r.generalSoldierList.add(new Soldier("Bob",2,Rang.Officer));
//        r.generalSoldierList.add(new Soldier("Martin",3,Rang.Private));
//        r.generalSoldierList.add(new Soldier("Greg",4,Rang.General));
//
//        Scanner in = new Scanner(System.in);
//        System.out.println("Delete id:");
//        int id = in.nextInt();
//        r.deleteSoldier(id);
//        r.displaySoldiers();*/
//        ItemController itemController = new ItemController();
//        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
//        Armor armor = new Armor("Heavy","Heavy",2);
//        Vehicle vehicle = new Vehicle("Humvee",3,new ArrayList<Soldier>());
//
//        itemController.add(weapon);
//        itemController.add(armor);
//        itemController.add(vehicle);
//        System.out.println("1.Update Weapon\n2.Update Armor\n3.Update Vehicle");
//        Scanner in = new Scanner(System.in);
//        int choice = in.nextInt();
//        if(choice == 1){
//            System.out.println("Enter id: ");
//            int id = in.nextInt();
//            System.out.println("New name: ");
//            String name = in.next();
//            System.out.println("New calibre: ");
//            double calibre = in.nextDouble();
//            itemController.updateWeapon(name,calibre,id);
//            itemController.display();
//        }
//        load_basic_data("data.txt");
//    }
}