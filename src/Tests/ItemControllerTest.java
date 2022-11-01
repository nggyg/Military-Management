package Tests;

import Controller.ItemController;
import Repository.Repository;
import basic.Item;
import basic.Weapon;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    @Test
    void add() {
        ItemController itemController = new ItemController(new Repository<Item>(new ArrayList<Item>()));
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        itemController.add(weapon);
        assert(itemController.findById(1)==weapon);

    }

    @Test
    void removeItem() {
        ItemController itemController = new ItemController(new Repository<Item>(new ArrayList<Item>()));
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        itemController.add(weapon);
        assert(itemController.removeItem(1));
        assert(!itemController.removeItem(1));
        assert(itemController.findById(1)==null);

    }

    @Test
    void update() {
    }

    @Test
    void display() {
    }
}