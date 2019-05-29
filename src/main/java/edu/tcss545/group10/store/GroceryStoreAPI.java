package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.*;

import java.sql.ResultSet;
import java.util.Set;
import java.util.TreeSet;

public class GroceryStoreAPI {

    private static MySQLConnector con = new MySQLConnector();

    public static void addCustomer(Customer customer) {
        String sqlStatement = "INSERT INTO Customer VALUES(NULL, " + customer.getName() + ", "
                + customer.getPhone() + ", " + customer.getAddress() + ", " + customer.getDob()
                + ", " + customer.getCustomerSince() + ", " + customer.getRewardsPoints() + ");";
        makeUpdate(sqlStatement);
    }

    public static void updateCustomer(Customer customer) {
        String sqlStatement = "UPDATE Customer SET Phone = " + customer.getPhone()
                + ", Address = " + customer.getAddress() + " WHERE CustomerId = "
                + customer.getCustomerId() + ";";
        makeUpdate(sqlStatement);
    }

    public static Set<Customer> getCustomers() {
        Set<Customer> customers = new TreeSet<Customer>();

        try {
            ResultSet rs = makeQuery("SELECT * FROM Customer");

            while (rs.next()) {
                Customer customer = new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5), rs.getDate(6), rs.getInt(7));

                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    public static Set<Department> getDepartments() {
        Set<Department> departments = new TreeSet<Department>();

        try {
            ResultSet rs = makeQuery("SELECT * FROM Department");

            while (rs.next()) {
                Department department = new Department(rs.getInt(1), rs.getString(2));

                departments.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return departments;
    }

    public static void addDistributor(Distributor distributor) {
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

    public static Set<Distributor> getDistributors() {
        Set<Distributor> distributors = new TreeSet<Distributor>();

        try {
            ResultSet rs = makeQuery("SELECT * FROM Distributor");

            while (rs.next()) {
                Distributor distributor = new Distributor(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));

                distributors.add(distributor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return distributors;
    }

    public static void addInventoryItem(Inventory inventory) {
        String sqlStatement = "INSERT INTO Inventory VALUES (NULL, " + inventory.getName() + ", "
                + inventory.getDescription() + ", " + inventory.getDepartmentId() + ", "
                + inventory.getDistributorId() + ", " + inventory.getCurrentPrice() + ", "
                + inventory.getInventoryCount() + ");";
        makeUpdate(sqlStatement);
    }

    public static void updateInventoryItem(Inventory inventory) {
        String sqlStatement = "UPDATE Inventory SET CurrentPrice = " + inventory.getCurrentPrice()
                + ", InventoryCount = " + inventory.getInventoryCount() + ";";
        makeUpdate(sqlStatement);
    }

    public static Set<Inventory> getInventoryItems() {
        Set<Inventory> inventoryItems = new TreeSet<Inventory>();

        try {
            ResultSet rs = makeQuery("SELECT * FROM Inventory");

            while (rs.next()) {
                Inventory inventory = new Inventory(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getDouble(6), rs.getInt(7));

                inventoryItems.add(inventory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inventoryItems;
    }

    public static void addEmployee(Employee employee) {
        String sqlStatement = "INSERT INTO Employee VALUES (NULL, " + employee.getName() + ", "
                + employee.getPhone() + ", " + employee.getAddress() + ", " + employee.getDob()
                + ", " + employee.getHireDate() + ", " + employee.getPosition() + ", "
                + employee.getDepartmentId() + ", " + employee.getSalary() + ", " + employee.isActiveEmployee() + ");";
        makeUpdate(sqlStatement);
    }

    public static void updateEmployee(Employee employee) {
        String sqlStatement = "UPDATE Employee SET Phone = " + employee.getPhone()
                + ", Address = " + employee.getAddress() + ", Position = " + employee.getPosition()
                + ", Department = " + employee.getDepartmentId() + ", Salary = " + employee.getSalary()
                + ", IsActiveEmployee = " + employee.isActiveEmployee() + ";";
        makeUpdate(sqlStatement);
    }

    public static Set<Employee> getEmployees() {
        Set<Employee> employees = new TreeSet<Employee>();

        try {
            ResultSet rs = makeQuery("SELECT * FROM Employee");

            while (rs.next()) {
                Employee employee = new Employee(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getDate(6), rs.getString(7),  rs.getInt(8),
                        rs.getDouble(9),  rs.getBoolean(10));

                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }

    public static void addPurchase(Purchase purchase) {
        String sqlStatement = "INSERT INTO Purchase VALUES (NULL, " + purchase.getEmployeeId()
                + ", " + purchase.getCustomerId() + ", " + purchase.getItemId() + ", "
                + purchase.getCostPerUnit() + ", " + purchase.getQuantity() + ", " + purchase.getTotalCost() + ");";
        makeUpdate(sqlStatement);
    }

    public static Set<Purchase> getPurchases() {
        Set<Purchase> purchases = new TreeSet<Purchase>();

        try {
            ResultSet rs = makeQuery("SELECT * FROM Purchase");

            while (rs.next()) {
                Purchase purchase = new Purchase(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4), rs.getDouble(5),
                        rs.getInt(6), rs.getDouble(7));

                purchases.add(purchase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return purchases;
    }

    public static void printAllCustomers() {
        try {
            ResultSet rs = makeQuery("SELECT * FROM Customer");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getString(3) + " | " +
                                rs.getString(4) + " | " +
                                rs.getDate(5) + " | " +
                                rs.getDate(6) + " | " +
                                rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printAllDepartments() {
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

    public static void printAllDistributors() {
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

    public static void printAllEmployees() {
        try {
            ResultSet rs = makeQuery("SELECT * FROM Employee");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getString(3) + " | " +
                                rs.getString(4) + " | " +
                                rs.getDate(5) + " | " +
                                rs.getDate(6) + " | " +
                                rs.getString(7) + " | " +
                                rs.getInt(8) + " | " +
                                rs.getDouble(9) + " | " +
                                rs.getBoolean(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printAllInventory() {
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

    public static void printAllPurchases() {
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

    public static void resetDatabase() {
        try {
            makeQuery("CALL resetGroceryStoreDB()");
            System.out.println("Database has been reset");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void makeUpdate(String sqlStatement) {
        System.out.println("Executing MySQL statement: " + sqlStatement);
        con.makeUpdate(sqlStatement);
    }

    private static ResultSet makeQuery(String sqlStatement) {
        System.out.println("Executing MySQL statement: " + sqlStatement);
        return con.makeQuery(sqlStatement);
    }
}
