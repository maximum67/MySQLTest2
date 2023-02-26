import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Viewing {

    public void view (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = Connector.getConnection()){

                System.out.println("Connection to Store DB succesfull!");

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int age = resultSet.getInt(3);
                    System.out.printf("%d. %s - %d \n", id, name, age);
                }

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

    }

}
