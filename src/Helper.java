/*   Created by IntelliJ IDEA.
 *   Author: Dimpal Agrawal
 *   Date: 11/20/2020
 *   Time: 10:01 AM
 *   File: Helper.java
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Helper {

    private static final String INSERT_QUERY ="INSERT INTO CITIES(name,traversed,kilometers_required)" +
            "VALUES(?,?,?)";

    private static final String READ_QUERY="SELECT * FROM CITIES";

    private static final String UPDATE_QUERY="UPDATE CITIES SET name=? WHERE kilometers_required =?";

    private static final String DELETE_QUERY="Delete from city where name=?";

    public boolean createNewCity(Connection connection,City city) throws SQLException {
        String name=city.getName();
        boolean isTraversed =city.isTraversed();
        int kilometers=city.getKilometers();
        PreparedStatement preparedStatement=connection.prepareStatement(INSERT_QUERY);
        preparedStatement.setString(1,name);
        preparedStatement.setBoolean(2,isTraversed);
        preparedStatement.setInt(3, kilometers);
        preparedStatement.executeUpdate();
        return false;
    }

    public void readAllCities(Connection connection) throws SQLException {
        PreparedStatement readStatement=connection.prepareStatement(READ_QUERY);
        ResultSet results=readStatement.executeQuery();
        while (results.next()) {
            String name=results.getString(1);
            boolean isTraversed=results.getBoolean(2);
            int kilometersRequired=results.getInt(3);
            City city =new City(
                    name,
                    isTraversed,kilometersRequired);

            System.out.println(city);
            System.out.println("------------------------------");
        }
    }

    public  void updateAllCities(Connection connection,String name,int kilo) throws SQLException {
        PreparedStatement updateStatement = connection.prepareStatement(UPDATE_QUERY);
        updateStatement.setString(1,name);
        updateStatement.setInt(2,kilo);
        updateStatement.executeUpdate();

    }

    public  void deleteCity(Connection connection,String names) throws SQLException {
        PreparedStatement deleteStatement =connection.prepareStatement(DELETE_QUERY);
        deleteStatement.setString(1,names);
        deleteStatement.executeUpdate();
    }
}