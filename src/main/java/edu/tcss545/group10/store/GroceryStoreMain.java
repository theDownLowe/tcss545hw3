package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.Customer;

import java.sql.Date;

public class GroceryStoreMain {

    public static void main(String[] args) {
        MySQLConnector con = new MySQLConnector();
        con.addCustomer(new Customer(-1, "Name", "0123456789",
                "Address", new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), 500));
        con.closeConnection();
    }
}

