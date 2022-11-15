import Controller.*;
import basic.Armor;
import basic.Soldier;
import basic.Vehicle;
import basic.Weapon;

import java.util.ArrayList;

public class UI{
    public UI(){
    ItemController itemController=new ItemController();
    SoldierController soldierController = new SoldierController();

    Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
    Armor armor = new Armor("Heavy","Heavy",2);
    Vehicle vehicle = new Vehicle("Humvee",3,new ArrayList<Soldier>());

    }
}