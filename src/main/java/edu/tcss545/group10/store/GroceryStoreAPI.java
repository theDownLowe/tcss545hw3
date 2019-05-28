package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.*;

import java.sql.ResultSet;
import java.util.Set;

public class GroceryStoreAPI {

    private MySQLConnector con;

    public GroceryStoreAPI() {
        this.con = new MySQLConnector();
    }

    public void addCustomer(Customer customer) {
        String sqlStatement = "INSERT INTO Customer VALUES(NULL, " + customer.getName() + ", "
                + customer.getPhone() + ", " + customer.getAddress() + ", " + customer.getDob()
                + ", " + customer.getCustomerSince() + ", " + customer.getRewardsPoints() + ");";
        makeUpdate(sqlStatement);
    }

    public void updateCustomer(Customer customer) {
        String sqlStatement = "UPDATE Customer SET Phone = " + customer.getPhone()
                + ", Address = " + customer.getAddress() + " WHERE CustomerId = "
                + customer.getCustomerId() + ";";
        makeUpdate(sqlStatement);
    }

    public Set<Customer> getCustomers() {
        // TODO
        return null;
    }

    public Set<Department> getDepartments() {
        // TODO
        return null;
    }

    public void addDistributor(Distributor distributor) {
        String sqlStatement = "INSERT INTO Distributor VALUES (NULL, " + distributor.getName() + ", "
                + distributor.getPhone() + ", " + distributor.getAddress() + ", "
                + distributor.getPrimaryContactName() + ");";
        makeUpdate(sqlStatement);
    }

    public void updateDistributor(Distributor distributor) {
        String sqlStatement = "UPDATE Distributor SET Phone = " + distributor.getPhone()
                + ", Address = " + distributor.getAddress() + ", PrimaryContactName = "
                + distributor.getPrimaryContactName() + ";";
        makeUpdate(sqlStatement);
    }

    public Set<Distributor> getDistributors() {
        // TODO
        return null;
    }

    public void addInventoryItem(Inventory inventory) {
        String sqlStatement = "INSERT INTO Inventory VALUES (NULL, " + inventory.getName() + ", "
                + inventory.getDescription() + ", " + inventory.getDepartmentId() + ", "
                + inventory.getDistributorId() + ", " + inventory.getCurrentPrice() + ", "
                + inventory.getInventoryCount() + ");";
        makeUpdate(sqlStatement);
    }

    public void updateInventoryItem(Inventory inventory) {
        String sqlStatement = "UPDATE Inventory SET CurrentPrice = " + inventory.getCurrentPrice()
                + ", InventoryCount = " + inventory.getInventoryCount() + ";";
        makeUpdate(sqlStatement);
    }

    public Set<Inventory> getInventory() {
        // TODO
        return null;
    }

    public void addEmployee(Employee employee) {
        String sqlStatement = "INSERT INTO Employee VALUES (NULL, " + employee.getName() + ", "
                + employee.getPhone() + ", " + employee.getAddress() + ", " + employee.getDob()
                + ", " + employee.getHireDate() + ", " + employee.getPosition() + ", "
                + employee.getDepartmentId() + ", " + employee.getSalary() + ", " + employee.isActiveEmployee() + ");";
        makeUpdate(sqlStatement);
    }

    public void updateEmployee(Employee employee) {
        String sqlStatement = "UPDATE Employee SET Phone = " + employee.getPhone()
                + ", Address = " + employee.getAddress() + ", Position = " + employee.getPosition()
                + ", Department = " + employee.getDepartmentId() + ", Salary = " + employee.getSalary()
                + ", IsActiveEmployee = " + employee.isActiveEmployee() + ";";
        makeUpdate(sqlStatement);
    }

    public Set<Employee> getEmployees() {
        // TODO
        return null;
    }

    public void addPurchase(Purchase purchase) {
        String sqlStatement = "INSERT INTO Purchase VALUES (NULL, " + purchase.getEmployeeId()
                + ", " + purchase.getCustomerId() + ", " + purchase.getItemId() + ", "
                + purchase.getCostPerUnit() + ", " + purchase.getQuantity() + ", " + purchase.getTotalCost() + ");";
        makeUpdate(sqlStatement);
    }

    public Set<Purchase> getPurchases() {
        // TODO
        return null;
    }

    public void printAllCustomers() {
        try {
            ResultSet rs = makeQuery("SELECT * FROM Customer");

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
            ResultSet rs = makeQuery("SELECT * FROM Department");

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
            ResultSet rs = makeQuery("SELECT * FROM Distributor");

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
            ResultSet rs = makeQuery("SELECT * FROM Employee");

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
            ResultSet rs = makeQuery("SELECT * FROM Inventory");

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
            ResultSet rs = makeQuery("SELECT * FROM Purchase");

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
            makeQuery("CALL resetGroceryStoreDB()");
            System.out.println("Database has been reset");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeUpdate(String sqlStatement) {
        System.out.println("Executing MySQL statement: " + sqlStatement);
        con.makeUpdate(sqlStatement);
    }

    private ResultSet makeQuery(String sqlStatement) {
        System.out.println("Executing MySQL statement: " + sqlStatement);
        return con.makeQuery(sqlStatement);
    }
}
