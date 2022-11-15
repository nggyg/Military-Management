import Controller.ItemController;
import Controller.SoldierController;
import Repository.Repository;
import basic.Item;
import basic.Soldier;

import java.util.Scanner;

public class UI{
    private SoldierController soldierController;
    private ItemController itemController;
    private Repository<Soldier> soldierRepository;
    private Repository<Item> itemRepository;

    public UI(SoldierController soldierController, ItemController itemController, Repository<Soldier> soldierRepository, Repository<Item> itemRepository) {
        this.soldierController = soldierController;
        this.itemController = itemController;
        this.soldierRepository = soldierRepository;
        this.itemRepository = itemRepository;
    }

    public UI() {
        this.soldierController= new SoldierController();
        this.itemController=new ItemController();
        this.soldierRepository=new Repository<Soldier>();
        this.itemRepository=new Repository<Item>();
    }
    private void menu_text(){
        System.out.println("1. View Troops");
        System.out.println("2. View Inventory");
        System.out.println("3. Exit");
    }
    private void soldier_menu_text(){
        System.out.println("1. add new Soldier");
        System.out.println("2. edit Soldier");
        System.out.println("3. promote Soldier");
        System.out.println("4. remove Soldier");
    }
    private void items_menu_text(){
        System.out.println("1. view weapons");
        System.out.println("2. view armor");
        System.out.println("3. view vehicle");
        System.out.println("4. add weapon");
        System.out.println("5. add armor");
        System.out.println("6. add vehicle");
        System.out.println("7. remove item");
        System.out.println("8. edit item");
    }
    public void menu(){
        boolean t=true;
        while(t) {
            menu_text();
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            switch (option) {
                case 1 -> {
                    soldierController.displaySoldiers();
                    soldier_menu_text();
                }
                case 2 -> {
                    items_menu_text();
                }
                default -> System.out.println("Invalid option");
                case 3 -> {
                    t=false;
                }
            }

        }
    }
}


