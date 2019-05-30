package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class GroceryStoreGUI {

    private static JFrame frame;

    private static Object[][] customerData = {};
    private static Object[][] distributorData = {};
    private static Object[][] employeeData = {};
    private static Object[][] inventoryData = {};
    private static Object[][] purchaseData = {};
    private static Object[][] departmentData = {};

    private static JTable customerTable;
    private static JTable distributorTable;
    private static JTable employeeTable;
    private static JTable inventoryTable;
    private static JTable purchaseTable;
    private static JTable departmentTable;

    public static void generateGUI() {
        // Initialize JFrame
        frame = new JFrame("Grocery Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLocationRelativeTo(null);

        refreshData();
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
        Object[][] rowData = customerData;

        customerTable = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(customerTable);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        customerPanel.add(scrollPane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTables();
            }
        });
        customerPanel.add(refreshButton);

        // TODO - Add new customer forms
        // TODO - Update customer forms

        tabbedPane.add("Customers", customerPanel);
    }

    private static void addDistributorTab(JTabbedPane tabbedPane) {
        JComponent distributorPanel = new JPanel();

        String[] columnNames = {"DistributorId", "Name", "Phone", "Address", "Primary Contact Name"};
        Object[][] rowData = distributorData;

        distributorTable = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(distributorTable);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        distributorPanel.add(scrollPane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTables();
            }
        });
        distributorPanel.add(refreshButton);

        // TODO - Add distributor forms
        // TODO - Update distributor forms

        tabbedPane.add("Distributors", distributorPanel);
    }

    private static void addEmployeeTab(JTabbedPane tabbedPane) {
        JComponent employeePanel = new JPanel();

        String[] columnNames = {"EmployeeId", "Name", "Phone", "Address", "DoB", "Hire Date", "Position",
                "DepartmentId", "Salary", "IsActive"};
        Object[][] rowData = employeeData;

        employeeTable = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        employeePanel.add(scrollPane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTables();
            }
        });
        employeePanel.add(refreshButton);

        // TODO - Add employee forms
        // TODO - Update employee forms

        tabbedPane.add("Employees", employeePanel);
    }

    private static void addInventoryTab(JTabbedPane tabbedPane) {
        JComponent inventoryPanel = new JPanel();

        String[] columnNames = {"ItemId", "Name", "Description", "DepartmentId", "DistributorId",
                "Current Price", "Inventory Count"};
        Object[][] rowData = inventoryData;

        inventoryTable = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(inventoryTable);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        inventoryPanel.add(scrollPane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTables();
            }
        });
        inventoryPanel.add(refreshButton);

        // TODO - Add inventory forms
        // TODO - Update inventory forms

        tabbedPane.add("Inventory Items", inventoryPanel);
    }

    private static void addPurchaseTab(JTabbedPane tabbedPane) {
        JComponent purchasePanel = new JPanel();

        String[] columnNames = {"PurchaseId", "EmployeeId", "CustomerId", "ItemId", "Cost Per Unit", "Quantity", "Total Cost"};
        Object[][] rowData = purchaseData;

        purchaseTable = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(purchaseTable);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        purchasePanel.add(scrollPane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTables();
            }
        });
        purchasePanel.add(refreshButton);

        // TODO - Add purchase form

        tabbedPane.add("Purchases", purchasePanel);
    }

    private static void addDepartmentTab(JTabbedPane tabbedPane) {
        JComponent departmentPanel = new JPanel();

        String[] columnNames = {"DepartmentId", "Name"};
        Object[][] rowData = departmentData;

        departmentTable = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(departmentTable);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        departmentPanel.add(scrollPane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTables();
            }
        });
        departmentPanel.add(refreshButton);

        tabbedPane.add("Departments", departmentPanel);
    }

    private static void refreshData() {
        customerData = GroceryStoreUtil.getCustomers(GroceryStoreAPI.getCustomers());
        distributorData = GroceryStoreUtil.getDistributors(GroceryStoreAPI.getDistributors());
        employeeData = GroceryStoreUtil.getEmployees(GroceryStoreAPI.getEmployees());
        inventoryData = GroceryStoreUtil.getInventoryItems(GroceryStoreAPI.getInventoryItems());
        purchaseData = GroceryStoreUtil.getPurchases(GroceryStoreAPI.getPurchases());
        departmentData = GroceryStoreUtil.getDepartments(GroceryStoreAPI.getDepartments());
    }

    private static void refreshTables() {
        refreshData();
        customerTable.validate();
        distributorTable.validate();
        employeeTable.validate();
        inventoryTable.validate();
        purchaseTable.validate();
        departmentTable.validate();
    }
}
