/*   Created by IntelliJ IDEA.
 *   Author: Dimpal Agrawal
 *   Date: 11/20/2020
 *   Time: 10:01 AM
 *   File: Connection.java
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL="jdbc:mysql://localhost:3306/google_play_game";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection=null;

    public static Connection getConnection() {
        return connection;
    }


    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD);
        } catch (SQLException exception) {
            System.err.println("could not able to connected....Plz enter right detail");
            exception.printStackTrace();
        } finally {
            printConnectionStatus();
        }
    }

    private void printConnectionStatus() {
        System.out.println(
                connection==null ?
                "Connection is inactive":
                "connection is active");
    }
}