import java.sql.*;
import java.util.Scanner;

public class Addendum {

    public void adden (){

        Scanner str = new Scanner(System.in);
        System.out.println("Ведите имя");
        String name1 = str.nextLine();
        System.out.println("Введите возраст");
        int age1 = str.nextInt();



        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = Connector.getConnection()){

                System.out.println("Connection to test DB succesfull!");

                Statement statement = conn.createStatement();

                statement.executeUpdate("INSERT users (name, age) VALUES ('"+name1+"', "+age1+")");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }




}
