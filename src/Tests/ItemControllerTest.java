package Tests;

import Controller.ItemController;
import basic.*;
import Repository.Repository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    @Test
    void add() {
        ItemController itemController = new ItemController();
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        Armor armor = new Armor("Heavy","Heavy",2);
        Vehicle vehicle = new Vehicle("Humvee",3,new Soldier("John",2, Rang.Private));

        itemController.add(weapon);
        itemController.add(armor);
        itemController.add(vehicle);
        assert(itemController.findById(1)==weapon);
        assert(itemController.findById(2)==armor);
        assert (itemController.findById(3)==vehicle);

    }

    @Test
    void removeItem() {
        ItemController itemController = new ItemController();
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        Armor armor = new Armor("Heavy","Heavy",1);
//        Vehicle vehicle = new Vehicle("Humvee",1,new Soldier("John",1, Rang.Private));

        itemController.add(weapon);
        itemController.add(armor);
//        itemController.add(vehicle);
        assert(itemController.removeItem(1,2));
        assert(!itemController.removeItem(1,2));
        assert(itemController.findById(1)==null);

        assert(itemController.removeItem(1,1));
        assert(!itemController.removeItem(1,1));
        assert(itemController.findById(2)==null);

//        assert(itemController.removeItem(1,3));
//        assert(!itemController.removeItem(1,3));
//        assert(itemController.findById(3)==null);

    }

    @Test
    void update() {
        ItemController itemController = new ItemController();
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        Armor armor = new Armor("Heavy","Heavy",2);
        Vehicle vehicle = new Vehicle("Humvee",3,new Soldier("John",2, Rang.Private));

        itemController.add(weapon);
        itemController.add(armor);
        itemController.add(vehicle);
        assert(itemController.updateWeapon("M4A4",5.56,1));
        assert(itemController.updateArmor("Heavy","Medium",2));
        assert(itemController.updateVehicle("APC",3));
    }
    @Test
    void display() {
    }
}