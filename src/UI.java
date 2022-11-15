import Controller.ItemController;
import Controller.SoldierController;
import Repository.Repository;
import basic.Item;
import basic.Soldier;

import java.util.Scanner;

public class UI {
    private SoldierController soldierController;
    private ItemController itemController;
    private Repository<Soldier> soldierRepository;
    private Repository<Item> itemRepository;

    public UI(Repository<Soldier> soldierRepository, Repository<Item> itemRepository) {
        this.soldierRepository = soldierRepository;
        this.itemRepository = itemRepository;
        this.soldierController = new SoldierController(this.soldierRepository);
        this.itemController = new ItemController(this.itemRepository);
    }

    public UI() {
        this.soldierRepository = new Repository<Soldier>();
        this.itemRepository = new Repository<Item>();
        this.soldierController = new SoldierController(this.soldierRepository);
        this.itemController = new ItemController(this.itemRepository);
    }

    private void menu_text() {
        System.out.println();
        System.out.println("1. View Troops");
        System.out.println("2. View Inventory");
        System.out.println("3. Exit");
    }

    private void soldier_menu_text() {
        System.out.println();
        System.out.println("1. add new Soldier");
        System.out.println("2. edit Soldier");
        System.out.println("3. promote Soldier");
        System.out.println("4. view Soldier equipment");
        System.out.println("5. assign Soldier to battalion");
        System.out.println("6. remove Soldier");
        System.out.println("7. Return");
    }

    private void items_menu_text() {
        System.out.println();
        System.out.println("1. view weapons");
        System.out.println("2. view armor");
        System.out.println("3. view vehicle");
        System.out.println("4. add weapon");
        System.out.println("5. add armor");
        System.out.println("6. add vehicle");
        System.out.println("7. remove item");
        System.out.println("8. edit item");
        System.out.println("9. assign item to soldier");
        System.out.println("10. manage vehicle drivers");
        System.out.println("11. Return");
    }

    public void menu() {
        int option, option2;
        boolean t = true, t2 = true;
        Scanner scan = new Scanner(System.in);
        while (t) {
            t = true;
            menu_text();
            option = scan.nextInt();
            switch (option) {
                case 1 -> {
                    t2 = true;
                    soldierController.displaySoldiers();
                    soldier_menu_text();
                    option2 = scan.nextInt();
                    while (t2) {
                        switch (option2) {
                            case 1 -> {
                                //add new soldier
                            }
                            case 2 -> {
                                //edit soldier
                            }
                            case 3 -> {
                                //promote soldier
                            }
                            case 4 -> {
                                //view equipment
                            }
                            case 5 -> {
                                //assign soldier to battalion
                            }
                            case 6 -> {
                                //remove soldier
                            }
                            case 7 -> {
                                //return
                                t2 = false;
                            }
                            default -> {
                                System.out.println("Invalid option, try again");
                            }
                        }
                    }
                }
                case 2 -> {
                    t2=true;
                    itemController.display();
                    items_menu_text();
                    option2 = scan.nextInt();
                    while(t2) {
                        switch (option2) {
                            case 1 -> {
                                //view weapons
                            }
                            case 2 -> {
                                //view armor
                            }
                            case 3 -> {
                                //view vehicles
                            }
                            case 4 -> {
                                //add weapon
                            }
                            case 5 -> {
                                //add armor
                            }
                            case 6 -> {
                                //add vehicle
                            }
                            case 7 -> {
                                //remove item
                            }
                            case 8 -> {
                                //edit item
                            }
                            case 9 -> {
                                //assign item
                            }
                            case 10 -> {
                                //manage vehicle drivers
                            }
                            case 11 -> {
                                t2=false;
                            }
                            default -> {
                                System.out.println("Invalid option, try again");
                            }
                        }
                    }
                }
                case 3 -> {
                    t = false;
                }
                default -> {
                    System.out.println("Invalid option, try again");
                }
            }
        }
        scan.close();
    }
}


