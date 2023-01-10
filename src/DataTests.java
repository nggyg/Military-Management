import basic.Rang;
import basic.Soldier;

import java.sql.*;

import static basic.Rang.General;

public class DataTests {
    public static void main(String[] args) throws SQLException {
        Soldier soldier = new Soldier("Soldatu1",2,General);
        String url ="jdbc:sqlserver://localhost//SQLEXPRESS:1433;database=JDB1";//"jdbc:sqlserver://DESKTOP-GLDFCK4;databaseName=MillitaryManagement;user=test;password=123;encrypt=true;trustServerCertificate=true";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into Soldier (name, rang) values (' "+soldier.getName()+
                    " ', ' "+soldier.getRang()+" ')");

            ResultSet resultSet =statement.executeQuery("select * from Soldier where id=1");
            Soldier soldier1 = null;
            while(resultSet.next()){
                soldier1 = new Soldier(resultSet.getString("name"),resultSet.getInt("id"),Rang.valueOf( resultSet.getString("rang")));

            }
            System.out.println(soldier1.getId());
            System.out.println(soldier1.getName());
            System.out.println(soldier1.getRang());
        }catch(Exception e){
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
    }
}
