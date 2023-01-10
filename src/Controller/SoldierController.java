package Controller;

import Repository.Repository;
import basic.Rang;
import basic.Soldier;

import java.util.ArrayList;

public class SoldierController {
    private Repository<Soldier> generalSoldierList;

    public SoldierController() {
        this.generalSoldierList=new Repository<Soldier>(new ArrayList<Soldier>());
    }

    public SoldierController(Repository<Soldier> generalSoldierList){
        this.generalSoldierList = generalSoldierList;
    }

    public Soldier findById(int id) {
        for (Soldier soldier : generalSoldierList.getContent()) {
            if (soldier.id() == id) {
                return soldier;
            }
        }
        return null;
    }

    public void addSoldier(Soldier newSoldier) {
        newSoldier.setRang(Rang.Private);
        generalSoldierList.add(newSoldier);
        //save to database
    }

    public boolean deleteSoldier(int id) {
//        generalSoldierList.removeIf(soldier -> Objects.equals(soldier.id(),id));
        for (Soldier soldier : generalSoldierList.getContent()) {
            if (id == soldier.id()) {
                generalSoldierList.remove(soldier);
                return true;
            }
        }
        return false;   //also update database
    }

    public boolean updateSoldier(int id, String newName, Rang newRang) {
        for (Soldier soldier : generalSoldierList.getContent()) {
            if (id == soldier.id()) {
                soldier.setName(newName);
                soldier.setRang(newRang);
                return true;
            }
        }       //also update database
        return false;
    }

    public void displaySoldiers() {
        this.generalSoldierList.display();
    }
    //select from database

}
