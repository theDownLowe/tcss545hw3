package edu.tcss545.group10.store;

import java.sql.*;

public class MySQLConnector {

    private static final String SQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_DB_NAME ="jdbc:mysql://mydbinstance.c7wiwrmvv2sb.us-west-2.rds.amazonaws.com";
    private static final String MYSQL_DB_USERNAME = "group10";
    private static final String MYSQL_DB_PASSWORD = "tcss545a";

    private Connection mySQLConnection;
    private PreparedStatement statement;


    public MySQLConnector () {
        initializeConnection();
    }


    public void makeUpdate(String updateStatement) {
        try {
            initializeConnection();
            statement = mySQLConnection.prepareStatement(updateStatement);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResultSet makeQuery(String query) {
        ResultSet rs = null;
        try {
            initializeConnection();
            statement = mySQLConnection.prepareStatement(query);
            rs = statement.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }


    private void initializeConnection() {
        try {
            Class.forName(SQL_DRIVER_NAME);
            mySQLConnection = DriverManager.getConnection(MYSQL_DB_NAME, MYSQL_DB_USERNAME, MYSQL_DB_PASSWORD);
            statement = mySQLConnection.prepareStatement("USE GroceryStore");
            statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Unable to connect to Database");
            e.printStackTrace();
        }
    }


    public void closeConnection() {
        try {
            mySQLConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
