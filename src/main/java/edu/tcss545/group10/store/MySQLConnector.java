package edu.tcss545.group10.store;

import java.sql.*;

/**
 * Establishes and maintains connections to a MySQL database.
 * Passes queries to the database and retrieves the results.
 * Passes update SQL statements to the database.
 */
public class MySQLConnector {

    private static final String SQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_DB_NAME ="jdbc:mysql://grocerystore.c7wiwrmvv2sb.us-west-2.rds.amazonaws.com";
    private static final String MYSQL_DB_USERNAME = "group10";
    private static final String MYSQL_DB_PASSWORD = "tcss545a";

    private Connection mySQLConnection;
    private PreparedStatement statement;

    /**
     * Constructor for Connector, initializes the MYSQL Connection
     */
    public MySQLConnector () {
        initializeConnection();
    }

    /**
     * Makes a call to update the MySQL database using the given SQL Statement.
     *
     * @param updateStatement - Statement to be sent to the MySQL Database
     */
    public void makeUpdate(String updateStatement) {
        try {
            initializeConnection();
            statement = mySQLConnection.prepareStatement(updateStatement);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Makes a call to update the MySQL database using the given SQL Statement.
     *
     * @param query - - Statement to be sent to the MySQL Database
     * @return The returned results from the SQL query
     */
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

    /**
     * Initializes the connection to MySQL, declaring the correct Schema to use.
     */
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

    /**
     * Closes the database connection
     */
    public void closeConnection() {
        try {
            mySQLConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
