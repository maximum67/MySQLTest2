import java.nio.file.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Main{

    public static void main(String[] args) {

        System.out.println("Выберите действие с базой");
        System.out.println("1. Создать таблицу");
        System.out.println("2. Добавить запись в таблицу");
        System.out.println("3. Удалить запись из таблицы");
        System.out.println("4. Просмотреть таблицу");
        System.out.println("5. Удалить таблицу");

        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            int n = scanner.nextInt();

            switch (n) {
                case (1):
                    Creating cr = new Creating();
                    cr.creating();
                    break;
                case (2):
                    Addendum ad = new Addendum();
                    ad.adden();
                    break;
                case (3):
                    Removal removal = new Removal();
                    removal.removal();
                    break;
                case (4):
                    Viewing viewing = new Viewing();
                    viewing.view();
                    break;
                case (5):
                    System.out.println("Выберите 2");
                    break;
                default:
                    System.out.println("Неверная команда");
                    b = false;
            }
        }

    }


}