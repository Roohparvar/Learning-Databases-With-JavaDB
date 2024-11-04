package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaDB {

    public static void main(String[] args) {

        try {
            String Url = "jdbc:derby://localhost:1527/MyDatabase";
            String user = "MyUser";
            String Pass = "JavaDb840";

            Connection MyConnect = DriverManager.getConnection(Url, user, Pass);
            java.sql.Statement MyState = MyConnect.createStatement();
            ResultSet MyResult = MyState.executeQuery("select * from MyTable");

            int i = 1;
            while (MyResult.next()) {
                System.out.println("Record Number:" + i + "\nName: " + MyResult.getString(1) + "\tFamily: " + MyResult.getString(2) + "\tPhone: " + MyResult.getString(3));
                i++;
                System.out.println("----------------------------");
            }

            MyState.execute("insert into MyTable(Name,Family,Phone)values('Elham','Shirazi','09121119021')");
            System.out.println("Added record with Name: 'Elham' and Family: 'Shirazi' ");

            MyState.execute("DELETE FROM MyTable WHERE Name = 'Elham' AND Family = 'Shirazi' ");
            System.out.println("Deleted record with Name: 'Elham' and Family: 'Shirazi' ");

            MyState.execute("UPDATE MyTable SET Phone = '09122222222' WHERE Name = 'Reza' AND Family = 'Tabrizi'");
            System.out.println("Updated Phone number for Name: 'Reza' and Family: 'Tabriza'");

        } catch (SQLException ex) {
            Logger.getLogger(JavaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
