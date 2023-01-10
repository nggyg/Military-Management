import Controller.ItemController;
import Controller.SoldierController;
import Repository.Repository;
import basic.Item;
import basic.Rang;
import basic.globals;
import basic.Soldier;

import java.util.Scanner;

public class UI {
    private SoldierController soldierController;
    private ItemController itemController;
    private Repository<Soldier> soldierRepository;
    private Repository<Item> itemRepository;
    private globals globals;

    public UI(Repository<Soldier> soldierRepository, Repository<Item> itemRepository,globals globals) {
        this.globals=globals;
        this.soldierRepository = soldierRepository;
        this.itemRepository = itemRepository;
        this.soldierController = new SoldierController(this.soldierRepository);
        this.itemController = new ItemController(this.itemRepository);
    }

    public UI(globals globals) {
        this.globals=globals;
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
        int option, option2, option3;
        boolean t = true, t2 = true, t3=true;
        Scanner scan = new Scanner(System.in);
        while (t) {
            t = true;
            menu_text();
            option = scan.nextInt();
            switch (option) {
                case 1 -> {
                    t2 = true;
                    while (t2) {
                        soldierController.displaySoldiers();
                        soldier_menu_text();
                        option2 = scan.nextInt();
                        switch (option2) {
                            case 1 -> {
                                //add new soldier
                                System.out.print("Name: ");
                                String name=scan.nextLine();
                                Soldier s=new Soldier(name,globals.getSolID(), Rang.Private);
                                s.setEquipment(this.itemController.getAvailableEq());
                                this.itemController.findById(s.getEquipment().getKey().getID()/*weapon*/).assignedTo(s);
                                this.itemController.findById(s.getEquipment().getValue().getID()/*armor*/).assignedTo(s);
                                System.out.println(s);
                                this.soldierController.addSoldier(s);
                                break;
                            }
                            case 2 -> {
                                //edit soldier
                                t3=true;
                                while(t3) {
                                    System.out.print("Choose soldier to edit: ");
                                    int id=scan.nextInt();
                                    System.out.println("1. Change Name\n2. Switch Weapon\n3. Switch Armor\n4. Cancel");
                                    option3 = scan.nextInt();
                                    switch(option3){
                                        case 1:{
                                            System.out.print("New Name: ");
                                            String newName=scan.nextLine();
                                            this.soldierController.findById(id).setName(newName);
                                            System.out.print("Change anything else? y/n");
                                            String answer=scan.nextLine();
                                            if(answer=="n")
                                                t3=false;
                                            break;
                                        }
                                        case 2:{
                                            System.out.print("Change anything else? y/n");
                                            String answer=scan.nextLine();
                                            if(answer=="n")
                                                t3=false;
                                            break;
                                        }
                                        case 3:{
                                            System.out.print("Change anything else? y/n");
                                            String answer=scan.nextLine();
                                            if(answer=="n")
                                                t3=false;
                                            break;
                                        }
                                        case 4:{
                                            t3=false;
                                            break;
                                        }
                                        default:{
                                            System.out.println("Invalid option, try again");
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case 3 -> {
                                //promote soldier
                                System.out.print("Choose soldier id: ");
                                int id=scan.nextInt();
                                this.soldierController.findById(id).promote();
                                break;
                            }
                            case 4 -> {
                                //view equipment
                                break;
                            }
                            case 5 -> {
                                //assign soldier to battalion
                                break;
                            }
                            case 6 -> {
                                //remove soldier
                                System.out.print("Choose soldier to remove: ");
                                int id= scan.nextInt();
                                if(this.soldierController.deleteSoldier(id))
                                    System.out.println("Soldier removed");
                                System.out.println("Soldier not found");
                                break;
                            }
                            case 7 -> {
                                //return
                                t2 = false;
                                break;
                            }
                            default -> {
                                System.out.println("Invalid option, try again");
                                break;
                            }
                        }
                    }
                    break;
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
                                break;
                            }
                            case 2 -> {
                                //view armor
                                break;
                            }
                            case 3 -> {
                                //view vehicles
                                break;
                            }
                            case 4 -> {
                                //add weapon
                                break;
                            }
                            case 5 -> {
                                //add armor
                                break;
                            }
                            case 6 -> {
                                //add vehicle
                                break;
                            }
                            case 7 -> {
                                //remove item
                                break;
                            }
                            case 8 -> {
                                //edit item
                                break;
                            }
                            case 9 -> {
                                //assign item
                                break;
                            }
                            case 10 -> {
                                //manage vehicle drivers
                                break;
                            }
                            case 11 -> {
                                t2=false;
                                break;
                            }
                            default -> {
                                System.out.println("Invalid option, try again");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3 -> {
                    t = false;
                    break;
                }
                default -> {
                    System.out.println("Invalid option, try again");
                    break;
                }
            }
        }
        scan.close();
    }
}


