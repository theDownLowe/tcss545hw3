package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.Customer;
import edu.tcss545.group10.store.dbmodels.Department;
import edu.tcss545.group10.store.dbmodels.Distributor;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class GroceryStoreGUI {

    private static JFrame frame;

    public static void generateGUI() {
        // Initialize JFrame
        frame = new JFrame("Grocery Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLocationRelativeTo(null);

        addTabs();

        frame.setVisible(true);
    }

    private static void addTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();

        addHomeTab(tabbedPane);
        addCustomerTab(tabbedPane);
        addDistributorTab(tabbedPane);
        addEmployeeTab(tabbedPane);
        addInventoryTab(tabbedPane);
        addPurchaseTab(tabbedPane);
        addDepartmentTab(tabbedPane);

        frame.add(tabbedPane);
    }

    private static void addHomeTab(JTabbedPane tabbedPane) {
        JComponent homePanel = new JPanel();
        tabbedPane.add("Home", homePanel);
    }

    private static void addCustomerTab(JTabbedPane tabbedPane) {
        JComponent customerPanel = new JPanel();

        String[] columnNames = {"CustomerId", "Name", "Phone", "Address", "DoB", "Customer Since", "Rewards Points"};
        Object[][] rowData = getCustomers();

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        customerPanel.add(scrollPane);

        tabbedPane.add("Customers", customerPanel);
    }

    private static void addDistributorTab(JTabbedPane tabbedPane) {
        JComponent distributorPanel = new JPanel();

        String[] columnNames = {"DistributorId", "Name", "Phone", "Address", "Primary Contact Name"};
        Object[][] rowData = getDistributors();

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        distributorPanel.add(scrollPane);

        tabbedPane.add("Distributors", distributorPanel);
    }

    private static void addEmployeeTab(JTabbedPane tabbedPane) {
        JComponent employeePanel = new JPanel();

        String[] columnNames = {"EmployeeId", "Name", "Phone", "Address", "DoB", "Hire Date", "Position",
                "DepartmentId", "Salary", "IsActive"};
        Object[][] rowData = getEmployees();

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        employeePanel.add(scrollPane);

        tabbedPane.add("Employees", employeePanel);
    }

    private static void addInventoryTab(JTabbedPane tabbedPane) {
        JComponent inventoryPanel = new JPanel();

        String[] columnNames = {"ItemId", "Name", "Description", "DepartmentId", "DistributorId",
                "Current Price", "Inventory Count"};
        Object[][] rowData = getInventory();

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        inventoryPanel.add(scrollPane);

        tabbedPane.add("Inventory Items", inventoryPanel);
    }

    private static void addPurchaseTab(JTabbedPane tabbedPane) {
        JComponent purchasePanel = new JPanel();

        String[] columnNames = {"PurchaseId", "EmployeeId", "CustomerId", "ItemId", "Cost Per Unit", "Quantity", "Total Cost"};
        Object[][] rowData = getPurchases();

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        purchasePanel.add(scrollPane);

        tabbedPane.add("Purchases", purchasePanel);
    }

    private static void addDepartmentTab(JTabbedPane tabbedPane) {
        JComponent departmentPanel = new JPanel();

        String[] columnNames = {"DepartmentId", "Name"};
        Object[][] rowData = getDepartments();

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        departmentPanel.add(scrollPane);

        tabbedPane.add("Departments", departmentPanel);
    }

    private static Object[][] getCustomers() {
        Set<Customer> customers = GroceryStoreAPI.getCustomers();
        if (customers == null) {
            return null;
        }

        Object[][] custs = new Object[customers.size()][7];
        int i = 0;
        for (Customer c : customers) {
            custs[i][0] = c.getCustomerId();
            custs[i][1] = c.getName();
            custs[i][2] = c.getPhone();
            custs[i][3] = c.getAddress();
            custs[i][4] = c.getDob();
            custs[i][5] = c.getCustomerSince();
            custs[i][6] = c.getRewardsPoints();
            i++;
        }

        return custs;
    }

    private static Object[][] getDistributors() {
        Set<Distributor> distributors = GroceryStoreAPI.getDistributors();
        if (distributors == null) {
            return null;
        }

        Object[][] dists = new Object[distributors.size()][5];
        int i = 0;
        for (Distributor d : distributors) {
            dists[i][0] = d.getDistributorId();
            dists[i][1] = d.getName();
            dists[i][2] = d.getPhone();
            dists[i][3] = d.getAddress();
            dists[i][4] = d.getPrimaryContactName();
            i++;
        }

        return dists;
    }

    private static Object[][] getEmployees() {
        // TODO
        Object[][] obj = {};
        return obj;
    }

    private static Object[][] getInventory() {
        // TODO

        Object[][] obj = {};
        return obj;
    }

    private static Object[][] getPurchases() {
        // TODO

        Object[][] obj = {};
        return obj;
    }

    private static Object[][] getDepartments() {
        Set<Department> departments = GroceryStoreAPI.getDepartments();
        if (departments == null) {
            return null;
        }
        Object[][] depts = new Object[departments.size()][2];
        int i = 0;
        for (Department d : departments) {
            depts[i][0] = d.getDepartmentId();
            depts[i][1] = d.getName();
            i++;
        }

        return depts;
    }
}
