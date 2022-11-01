package Controller;

import Repository.Repository;
import basic.Rang;
import basic.Soldier;

import java.util.Objects;

public class Controller {
    private Repository<Soldier> generalSoldierList;

    public Controller() {

    }

    void addSoldier(Soldier newSoldier){
        newSoldier.setRang(Rang.Private);
        generalSoldierList.add(newSoldier);
    }
    boolean deleteSoldier(int id){
//        generalSoldierList.removeIf(soldier -> Objects.equals(soldier.id(),id));
        for(Soldier soldier:generalSoldierList.content()){
            if(id == soldier.id()){
                generalSoldierList.remove(soldier);
                return true;
            }
        }
        return false;
    }
    boolean updateSoldier(int id, String newName, Rang newRang){
        for (Soldier soldier:generalSoldierList.content()){
            if(id== soldier.id()){
                soldier.setName(newName);
                soldier.setRang(newRang);
                return true;
            }
        }
        return false;
    }

    void displaySoldiers(){
        for (Soldier soldier:generalSoldierList.content()){
            System.out.println(soldier);
        }
    }

}
