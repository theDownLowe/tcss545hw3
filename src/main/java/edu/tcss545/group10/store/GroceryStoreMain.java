package edu.tcss545.group10.store;

public class GroceryStoreMain {

    public static void main(String[] args) {
        MySQLConnector con = new MySQLConnector();

        con.closeConnection();
    }
}

