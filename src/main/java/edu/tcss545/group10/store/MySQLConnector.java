package edu.tcss545.group10.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnector {

    private static final String SQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_DB_NAME ="jdbc:mysql://mydbinstance.c7wiwrmvv2sb.us-west-2.rds.amazonaws.com";
    private static final String MYSQL_DB_USERNAME = "group10";
    private static final String MYSQL_DB_PASSWORD = "tcss545a";

    private Connection mySQLConnection;
    private Statement statement;


    public MySQLConnector () {
        initializeConnection();
    }


    public void makeUpdate(String updateStatement) {
        // TODO - may need to replace Statement with PreparedStatement here
        try {
            initializeConnection();
            statement.executeUpdate(updateStatement);
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResultSet makeQuery(String query) {
        ResultSet rs = null;
        try {
            initializeConnection();
            rs = statement.executeQuery(query);
            closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }


    private void initializeConnection() {
        try {
            Class.forName(SQL_DRIVER_NAME);
            mySQLConnection = DriverManager.getConnection(MYSQL_DB_NAME, MYSQL_DB_USERNAME, MYSQL_DB_PASSWORD);
            statement = mySQLConnection.createStatement();

            statement.executeQuery("USE GroceryStore");
        } catch (Exception e) {
            System.out.println("Unable to connect to Database");
            e.printStackTrace();
        }
    }


    private void closeConnection() {
        try {
            mySQLConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
