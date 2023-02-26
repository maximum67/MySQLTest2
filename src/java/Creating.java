import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Creating {
    public void creating () {

        Scanner str = new Scanner(System.in);
        System.out.println("Ведите название таблицы");
        String nameTab = str.nextLine();
        System.out.println("Введите количество столбцов");
        int column = Integer.parseInt(str.nextLine());
        String sqlCommand = "CREATE TABLE "+ nameTab+" (Id INT PRIMARY KEY AUTO_INCREMENT, ";
        System.out.println("Первый столбец содержит номер строки по порядку");
        for (int i=2; i< column+2; i++) {
            System.out.println("Ведите название " + i + "-го столбца");
            String str1 = str.nextLine();
            sqlCommand += str1;
            System.out.println("Выберите тип данных " + i + "-го столбца");
            System.out.println("1.Строка");
            System.out.println("2.Число");
            int n = Integer.parseInt(str.nextLine());
            boolean flag = true;
            while (flag) {
                switch (n) {
                    case (1):
                        sqlCommand += " VARCHAR(30)";
                        flag = false;
                        break;
                    case (2):
                        sqlCommand += " INT";
                        flag = false;
                        break;
                    default:
                        System.out.println("Неверная команда");
                }
            }
            if (i<column+1){
                sqlCommand +=",";
            }
        }
        sqlCommand +=")";

        System.out.println(sqlCommand);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = Connector.getConnection()){

                System.out.println("Connection to test DB succesfull!");

                Statement statement = conn.createStatement();

                statement.executeUpdate(sqlCommand);
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
