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
        Controller c =  new Controller();


    }

    @org.junit.jupiter.api.Test
    void deleteSoldier() {
    }

    @org.junit.jupiter.api.Test
    void updateSoldier() {
    }

    @org.junit.jupiter.api.Test
    void displaySoldiers() {
    }
}