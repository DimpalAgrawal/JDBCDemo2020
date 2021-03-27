/*   Created by IntelliJ IDEA.
 *   Author: Dimpal Agrawal
 *   Date: 11/20/2020
 *   Time: 10:01 AM
 *   File: Main.java
 */

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final int Update_column = 3;
    private static final int Delete_column = 4;
    private static final int Insert_column=1;
    private static final int Read_column = 2;

    public static void main(String[] args) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectToDatabase();
            System.out.println("--------menu--------------");
            System.out.println("1.insert a column");
            System.out.println("2.read a column");
            System.out.println("3.update a column");
            System.out.println("4.Delete a column");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();
            Helper helper=new Helper();
            s.nextLine();
            switch(choice) {
                case Insert_column:
                    System.out.println("Enter a column");
                    String name=s.nextLine();
                    System.out.println("Have u gone to that city");
                    boolean isTraversed = s.nextBoolean();
                    int kmsrequired= (int)((Math.random()*2000.0) + 100.0);
                    try {
                        helper.createNewCity(DatabaseConnection.getConnection(),
                                new City(name,isTraversed,kmsrequired
                                ));

                    } catch (SQLException exception) {
                        System.out.println("error");
                        exception.printStackTrace();
                    }
                    break;
                case Read_column:
                    try {
                        helper.readAllCities(DatabaseConnection.getConnection());
                    } catch (SQLException exception) {
                        JOptionPane.showMessageDialog(null,
                                "The value could not be there",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case Update_column:
                    String names = s.nextLine();
                    int kilometers =s.nextInt();
                    try {
                        helper.updateAllCities(DatabaseConnection.getConnection(),names,kilometers);
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                    break;
                case Delete_column:
                 String Cityname =s.nextLine();
                 helper.deleteCity(DatabaseConnection.getConnection(),Cityname);
            }
    }
}
