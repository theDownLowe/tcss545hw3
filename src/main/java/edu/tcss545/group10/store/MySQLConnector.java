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


    public  void initializeConnection() {
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


    public void printAllCustomers() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getString(4) + " | " +
                        rs.getString(5) + " | " +
                        rs.getString(6) + " | " +
                        rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void printAllDepartments() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Department");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void printAllDistributors() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Distributor");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getString(4) + " | " +
                        rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void printAllEmployees() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Employee");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getString(4) + " | " +
                        rs.getString(5) + " | " +
                        rs.getString(6) + " | " +
                        rs.getString(7) + " | " +
                        rs.getInt(8) + " | " +
                        rs.getDouble(9) + " | " +
                        rs.getBoolean(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void printAllInventory() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Inventory");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getInt(4) + " | " +
                        rs.getInt(5) + " | " +
                        rs.getDouble(6) + " | " +
                        rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void printAllPurchases() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Purchase");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getInt(2) + " | " +
                        rs.getInt(3) + " | " +
                        rs.getInt(4) + " | " +
                        rs.getDouble(5) + " | " +
                        rs.getInt(6) + " | " +
                        rs.getDouble(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void resetDatabase() {
        try {
            statement.executeQuery("CALL resetGroceryStoreDB()");
            System.out.println("Database has been reset");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void closeConnection() {
        try {
            mySQLConnection.close();
        } catch (Exception e) {}
    }
}
