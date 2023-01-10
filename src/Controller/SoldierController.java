package Controller;
import java.sql.*;

import Repository.Repository;
import basic.Rang;
import basic.Soldier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public ArrayList<Soldier> resultSoldiers(){
        ArrayList<Soldier> soldiers = new ArrayList<Soldier>();
        String url ="jdbc:sqlserver://DESKTOP-GLDFCK4;databaseName=MillitaryManagement;user=test;password=123;encrypt=true;trustServerCertificate=true";

        try{
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            int id=1;
            String idnull = " ";
            while(id==1) {
                ResultSet resultSet = statement.executeQuery("select * from Soldier where id=' "+id+" '");
                Soldier soldier1 = null;
                while (resultSet.next()) {
                    soldier1 = new Soldier(resultSet.getString("name"), resultSet.getInt("id"), Rang.valueOf(resultSet.getString("rang")));

                }
                soldiers.add(soldier1);
                id++;
            }
        }catch(Exception e){
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
        return soldiers;
    }

    public void addSoldier(Soldier newSoldier) {
        newSoldier.setRang(Rang.Private);
        generalSoldierList.add(newSoldier);
        String url ="jdbc:sqlserver://DESKTOP-GLDFCK4;databaseName=MillitaryManagement;user=test;password=123;encrypt=true;trustServerCertificate=true";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into Soldier (name, rang) values (' "+newSoldier.getName()+
                    " ', ' "+newSoldier.getRang()+" ')");
        } catch (Exception e) {
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
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
