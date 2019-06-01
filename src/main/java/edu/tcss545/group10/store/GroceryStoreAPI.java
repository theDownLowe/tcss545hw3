package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.*;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * The primary class for connecting the GUI to the MySQL connector.
 * Used to send specific queries and update statements to the database.
 */
public class GroceryStoreAPI {

    private static MySQLConnector con = new MySQLConnector();

    /**
     * Adds a new customer record to the database.
     *
     * @param customer - New customer to be added to database
     */
    public static void addCustomer(Customer customer) {
        String sqlStatement = "INSERT INTO Customer VALUES(NULL, \"" + customer.getName() + "\", \""
                + customer.getPhone() + "\", \"" + customer.getAddress() + "\", \"" + customer.getDob()
                + "\", \"" + customer.getCustomerSince() + "\", " + customer.getRewardsPoints() + ");";
        makeUpdate(sqlStatement);
    }

    /**
     * Updates an existing customer in the database.
     *
     * @param customer - The existing customer in the database to be updated
     */
    public static void updateCustomer(Customer customer) {
        String sqlStatement = "UPDATE Customer SET Phone = \"" + customer.getPhone()
                + "\", Address = \"" + customer.getAddress() + "\" WHERE CustomerId = "
                + customer.getCustomerId() + ";";
        makeUpdate(sqlStatement);
    }

    /**
     * Returns all customer records from the database.
     *
     * @return Customer records from database
     */
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

    /**
     * Returns all department records from the database.
     *
     * @return Department records from database
     */
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

    /**
     * Adds a new distributor record to the database.
     *
     * @param distributor - New distributor to be added to database
     */
    public static void addDistributor(Distributor distributor) {
        String sqlStatement = "INSERT INTO Distributor VALUES (NULL, \"" + distributor.getName() + "\", \""
                + distributor.getPhone() + "\", \"" + distributor.getAddress() + "\", \""
                + distributor.getPrimaryContactName() + "\");";
        makeUpdate(sqlStatement);
    }

    /**
     * Updates an existing distributor in the database.
     *
     * @param distributor - The existing distributor in the database to be updated
     */
    public static void updateDistributor(Distributor distributor) {
        String sqlStatement = "UPDATE Distributor SET Phone = \"" + distributor.getPhone()
                + "\", Address = \"" + distributor.getAddress() + "\", PrimaryContactName = \""
                + distributor.getPrimaryContactName() + "\" WHERE DistributorId = "
                + distributor.getDistributorId() + ";";
        makeUpdate(sqlStatement);
    }

    /**
     * Returns all distributors records from the database.
     *
     * @return Distributor records from database
     */
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

    /**
     * Adds a new inventory item record to the database.
     *
     * @param inventory - New inventory item to be added to database
     */
    public static void addInventoryItem(Inventory inventory) {
        String sqlStatement = "INSERT INTO Inventory VALUES (NULL, \"" + inventory.getName() + "\", \""
                + inventory.getDescription() + "\", " + inventory.getDepartmentId() + ", "
                + inventory.getDistributorId() + ", " + inventory.getCurrentPrice() + ", "
                + inventory.getInventoryCount() + ");";
        makeUpdate(sqlStatement);
    }

    /**
     * Updates an existing inventory item record in the database.
     *
     * @param inventory - The existing inventory item in the database to be updated
     */
    public static void updateInventoryItem(Inventory inventory) {
        String sqlStatement = "UPDATE Inventory SET CurrentPrice = " + inventory.getCurrentPrice()
                + ", InventoryCount = " + inventory.getInventoryCount() + " WHERE ItemId = " + inventory.getItemId() + ";";
        makeUpdate(sqlStatement);
    }

    /**
     * Returns all distributors records from the database.
     *
     * @return Distributor records from database
     */
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

    /**
     * Adds a new employee record to the database.
     *
     * @param employee - New employee record to be added to database
     */
    public static void addEmployee(Employee employee) {
        String sqlStatement = "INSERT INTO Employee VALUES (NULL, \"" + employee.getName() + "\", \""
                + employee.getPhone() + "\", \"" + employee.getAddress() + "\", \"" + employee.getDob()
                + "\", \"" + employee.getHireDate() + "\", \"" + employee.getPosition() + "\", "
                + employee.getDepartmentId() + ", " + employee.getSalary() + ", " + employee.isActiveEmployee() + ");";
        makeUpdate(sqlStatement);
    }

    /**
     * Updates an existing employee record in the database.
     *
     * @param employee - The existing employee item in the database to be updated
     */
    public static void updateEmployee(Employee employee) {
        String sqlStatement = "UPDATE Employee SET Phone = \"" + employee.getPhone()
                + "\", Address = \"" + employee.getAddress() + "\", Position = \"" + employee.getPosition()
                + "\", DepartmentId = " + employee.getDepartmentId() + ", Salary = " + employee.getSalary()
                + ", IsActiveEmployee = " + employee.isActiveEmployee() + " WHERE EmployeeId = "
                + employee.getEmployeeId() + ";";
        makeUpdate(sqlStatement);
    }

    /**
     * Returns all employees records from the database.
     *
     * @return employees records from database
     */
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

    /**
     * Adds a new purchase record to the database.
     *
     * @param purchase - New purchase record to be added to database
     */
    public static void addPurchase(Purchase purchase) {
        // Inserts the new record
        String sqlStatement = "INSERT INTO Purchase VALUES (NULL, " + purchase.getEmployeeId()
                + ", " + purchase.getCustomerId() + ", " + purchase.getItemId()
                + ", " + purchase.getCostPerUnit() + ", " + purchase.getQuantity()
                + ", " + purchase.getTotalCost() + ");";
        makeUpdate(sqlStatement);

        // Update Customers Reward Points
        sqlStatement = "UPDATE Customer SET RewardPoints = RewardPoints + "
                + Math.round(purchase.getTotalCost()) + " WHERE CustomerId = " + purchase.getCustomerId() + ";";
        makeUpdate(sqlStatement);

        // Update Inventory Quantity
        sqlStatement = "UPDATE Inventory SET InventoryCount = InventoryCount - " + purchase.getQuantity()
                + " WHERE ItemId = " + purchase.getItemId() + ";";
        makeUpdate(sqlStatement);
    }

    /**
     * Returns all purchase records from the database.
     *
     * @return purchase records from database
     */
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

    /**
     * Resets the database to initial data set.
     */
    public static void resetDatabase() {
        try {
            makeQuery("CALL resetGroceryStoreDB()");
            System.out.println("Database has been reset");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Makes a call to add/update records in the database.
     *
     * @param sqlStatement - Statement to be sent to the database
     */
    private static void makeUpdate(String sqlStatement) {
        System.out.println("Executing MySQL statement: " + sqlStatement);
        con.makeUpdate(sqlStatement);
    }

    /**
     * Makes a query in the database.
     *
     * @param sqlStatement - Query to be sent to the database
     * @return Results from the database query
     */
    private static ResultSet makeQuery(String sqlStatement) {
        System.out.println("Executing MySQL statement: " + sqlStatement);
        return con.makeQuery(sqlStatement);
    }
}
