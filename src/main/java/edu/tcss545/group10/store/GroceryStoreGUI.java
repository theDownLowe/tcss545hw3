package edu.tcss545.group10.store;

import javax.swing.*;

public class GroceryStoreGUI {

    private static JFrame frame;

    public static void generateGUI() {
        // Initialize JFrame
        frame = new JFrame("Grocery Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630, 800);
        frame.setLocationRelativeTo(null);

        addTabs();

        frame.setVisible(true);
    }

    private static void addTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();

        // Home tab
        JComponent homePanel = new JPanel();
        tabbedPane.add("Home", homePanel);

        // Customer tab
        JComponent customerPanel = new JPanel();
        tabbedPane.add("Customers", customerPanel);

        // Distributor tab
        JComponent distributorPanel = new JPanel();
        tabbedPane.add("Distributors", distributorPanel);

        // Employee tab
        JComponent employeePanel = new JPanel();
        tabbedPane.add("Employees", employeePanel);

        // Inventory tab
        JComponent inventoryPanel = new JPanel();
        tabbedPane.add("Inventory Items", inventoryPanel);

        // Purchase tab
        JComponent purchasePanel = new JPanel();
        tabbedPane.add("Purchases", purchasePanel);

        // Department tab
        JComponent departmentPanel = new JPanel();
        tabbedPane.add("Departments", departmentPanel);

        frame.add(tabbedPane);
    }
}
