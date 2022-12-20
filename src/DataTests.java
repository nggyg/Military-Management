import basic.Soldier;

import java.sql.*;
import basic.Soldier;

import static basic.Rang.General;

public class DataTests {
    public static void main(String[] args) throws SQLException {
        Soldier soldier = new Soldier("Soldatu1",2,General);
        String url ="jdbc:sqlserver://DESKTOP-GLDFCK4;databaseName=MillitaryManagement;user=test;password=123;encrypt=true;trustServerCertificate=true";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into Soldier (name, rang) values (' "+soldier.getName()+
                    " ', ' "+soldier.getRang()+" ')");
        }catch(Exception e){
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
    }
}
