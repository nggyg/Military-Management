package Tests;

import basic.Rang;
import basic.Soldier;
import Controller.*;
import Repository.*;

import static org.junit.jupiter.api.Assertions.*;

class SoldierControllerTest {


    @org.junit.jupiter.api.Test
    void addSoldier() {
        Soldier soldier = new Soldier("Bob",5, Rang.Private);
        SoldierController controller = new SoldierController();
        controller.addSoldier(soldier);
    }

    @org.junit.jupiter.api.Test
    void deleteSoldier() {
        Soldier soldier = new Soldier("Bob",5, Rang.Private);
        SoldierController controller = new SoldierController();
        controller.addSoldier(soldier);
        assert(controller.deleteSoldier(5));
    }

    @org.junit.jupiter.api.Test
    void updateSoldier() {
        Soldier soldier = new Soldier("Bob",5, Rang.Private);
        SoldierController controller = new SoldierController();
        controller.addSoldier(soldier);
        assert(controller.updateSoldier(5,"Marian",Rang.Officer));
    }

    @org.junit.jupiter.api.Test
    void displaySoldiers() {
        Soldier soldier = new Soldier("Bob",5, Rang.Private);
        SoldierController controller = new SoldierController();
        controller.addSoldier(soldier);
//        assert(controller.displaySoldiers()=="Bob");
    }
}