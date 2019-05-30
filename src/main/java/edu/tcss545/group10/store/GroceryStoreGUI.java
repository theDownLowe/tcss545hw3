package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.Department;

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
        Object[][] rowData = {};

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        customerPanel.add(scrollPane);

        tabbedPane.add("Customers", customerPanel);
    }

    private static void addDistributorTab(JTabbedPane tabbedPane) {
        JComponent distributorPanel = new JPanel();

        String[] columnNames = {"DistributorId", "Name", "Phone", "Address", "Primary Contact Name"};
        Object[][] rowData = {};

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
        Object[][] rowData = {};

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
        Object[][] rowData = {};

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        inventoryPanel.add(scrollPane);

        tabbedPane.add("Inventory Items", inventoryPanel);
    }

    private static void addPurchaseTab(JTabbedPane tabbedPane) {
        JComponent purchasePanel = new JPanel();

        String[] columnNames = {"PurchaseId", "EmployeeId", "CustomerId", "ItemId", "Cost Per Unit", "Quantity", "Total Cost"};
        Object[][] rowData = {};

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
