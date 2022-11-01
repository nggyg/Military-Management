package Tests;

import Controller.ItemController;
import basic.Soldier;
import Repository.Repository;
import basic.Armor;
import basic.Item;
import basic.Vehicle;
import basic.Weapon;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    @Test
    void add() {
        ItemController itemController = new ItemController(new Repository<Item>(new ArrayList<Item>()));
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        Armor armor = new Armor("Heavy","Heavy",2);
        Vehicle vehicle = new Vehicle("Humvee",3,new ArrayList<Soldier>());

        itemController.add(weapon);
        itemController.add(armor);
        itemController.add(vehicle);
        assert(itemController.findById(1)==weapon);
        assert(itemController.findById(2)==armor);
        assert (itemController.findById(3)==vehicle);
    }

    @Test
    void removeItem() {
        ItemController itemController = new ItemController(new Repository<Item>(new ArrayList<Item>()));
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        Armor armor = new Armor("Heavy","Heavy",2);
        Vehicle vehicle = new Vehicle("Humvee",3,new ArrayList<Soldier>());

        itemController.add(weapon);
        itemController.add(armor);
        itemController.add(vehicle);
        assert(itemController.removeItem(1));
        assert(!itemController.removeItem(1));
        assert(itemController.findById(1)==null);

        assert(itemController.removeItem(2));
        assert(!itemController.removeItem(2));
        assert(itemController.findById(2)==null);

        assert(itemController.removeItem(3));
        assert(!itemController.removeItem(3));
        assert(itemController.findById(3)==null);

    }

    @Test
    void update() {
        ItemController itemController = new ItemController(new Repository<Item>(new ArrayList<Item>()));
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        Armor armor = new Armor("Heavy","Heavy",2);
        Vehicle vehicle = new Vehicle("Humvee",3,new ArrayList<Soldier>());

        itemController.add(weapon);
        itemController.add(armor);
        itemController.add(vehicle);

    }

    @Test
    void display() {
    }
}