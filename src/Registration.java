import basic.*;

import java.util.ArrayList;
import java.util.Objects;

public class Registration {
    ArrayList<Soldier> generalSoldierList = new ArrayList<Soldier>();
    public Registration() {
        populateSoldiers();
    }

    void addSoldier(Soldier newSoldier){
        newSoldier.setRang(Rang.Private);
        generalSoldierList.add(newSoldier);
    }
    void populateSoldiers(){
        generalSoldierList.add(new Soldier("Alex",1,Rang.Private));
        generalSoldierList.add(new Soldier("Bob",2,Rang.Officer));
        generalSoldierList.add(new Soldier("Martin",3,Rang.Private));
        generalSoldierList.add(new Soldier("Greg",4,Rang.General));
    }

    void deleteSoldier(int id){
        generalSoldierList.removeIf(soldier -> Objects.equals(soldier.id(),id));
    }
    void displaySoldiers(){
        for (Soldier soldier:generalSoldierList){
            System.out.println("Name: "+soldier.getName()+
            "\tId: "+soldier.id()+"\tRang: "+soldier.getRang());
        }
    }

    void updateSoldier(int id, String newName, Rang newRang){
        for (Soldier soldier:generalSoldierList){
            if(id== soldier.id()){
                soldier.setName(newName);
                soldier.setRang(newRang);
            }
        }

    }
    /*1 weapon assigned to soldier
    * 1 armor assigned to soldier
    * */
    void assignToSoldier(){

    }
}

/*
    Jeder Soldat - hat eine Rustung, Waffe und Rang
                 - ist eine Person
                 - wenn Rang 'Private' ist dann kann auch jeder soldat ein Fahrer fur
                   ein Vehicle sein
    Jede Waffe, Rustung und Auto ist ein Item
    Item ist eine abstrakte Klasse welche zu einem Soldat 'assigned' ist
        - wenn ein Item usable als false hat kann man es nicht zu einen
          Soldat zuordnen
    Ein Battalion enthalt mehrere Soldaten und ein leader
    Einen Vehicle kann mehrere Fahrer haben, ein Soldat kann mehrere Vehicles fahren
    In der Registration wird sich eine Person als Soldat registrieren,
    wird random zu einer Battalion zugeordnet und bekommt Waffe und Rustung.
    Inventory hat eine liste fur Waffe, Rustung und Vehicles, aus dieser wird der Soldat der sich
    registriert eine Waffe und Rustung welche nicht zugeordnet sind.
    Jeder Soldat hat eine Stat-Klasse welche ihre Fahigkeiten verspiegelt.


* */