import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Removal {

    public void removal(){

        Scanner str = new Scanner(System.in);
        System.out.println("Какую строку удалить");
        int age2 = str.nextInt();



        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = Connector.getConnection()){

                System.out.println("Connection to test DB succesfull!");

                Statement statement = conn.createStatement();

                statement.executeUpdate("DELETE FROM users WHERE Id = "+age2+"");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
