package Controller;

import Repository.Repository;
import basic.Rang;
import basic.Soldier;

public class SoldierController {
    private Repository<Soldier> generalSoldierList;

    public SoldierController() {

    }

    void addSoldier(Soldier newSoldier){
        newSoldier.setRang(Rang.Private);
        generalSoldierList.add(newSoldier);
    }
    boolean deleteSoldier(int id){
//        generalSoldierList.removeIf(soldier -> Objects.equals(soldier.id(),id));
        for(Soldier soldier:generalSoldierList.getContent()){
            if(id == soldier.id()){
                generalSoldierList.remove(soldier);
                return true;
            }
        }
        return false;
    }
    boolean updateSoldier(int id, String newName, Rang newRang){
        for (Soldier soldier:generalSoldierList.getContent()){
            if(id== soldier.id()){
                soldier.setName(newName);
                soldier.setRang(newRang);
                return true;
            }
        }
        return false;
    }

    void displaySoldiers(){
        this.generalSoldierList.display();
    }

}
