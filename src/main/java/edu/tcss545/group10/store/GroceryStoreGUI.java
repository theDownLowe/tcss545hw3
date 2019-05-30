package edu.tcss545.group10.store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroceryStoreGUI {

    private static final String GC_ICON_LOCATION = "src/main/resources/grocery-icon.png";

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
        frame.setSize(700, 650);
        frame.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon(GC_ICON_LOCATION);
        frame.setIconImage(img.getImage());

        //refreshData();

        // Refresh Table Button
        JButton refreshButton = new JButton("Refresh Data");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTables();
            }
        });
        frame.add(refreshButton, BorderLayout.NORTH);

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

        frame.add(tabbedPane, BorderLayout.CENTER);
    }

    private static void addHomeTab(JTabbedPane tabbedPane) {
        JComponent homePanel = new JPanel();
        JLabel homeLabel = new JLabel("Welcome to the Grocery Store Data Administrator Application!");
        homePanel.add(homeLabel);

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

        // Add Customer Button
        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddCustomerForm();
            }
        });
        customerPanel.add(addCustomerButton);

        // Update Customer Button
        JButton updateCustomerButton = new JButton("Update Customer");
        updateCustomerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUpdateCustomerForm();
            }
        });
        customerPanel.add(updateCustomerButton);

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

        // Add Distributor Button
        JButton addDistributorButton = new JButton("Add Distributor");
        addDistributorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddDistributorForm();
            }
        });
        distributorPanel.add(addDistributorButton);

        // Update Distributor Button
        JButton updateDistributorButton = new JButton("Update Distributor");
        updateDistributorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUpdateDistributorForm();
            }
        });
        distributorPanel.add(updateDistributorButton);

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

        // Add Employee Button
        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddEmployeeForm();
            }
        });
        employeePanel.add(addEmployeeButton);

        // Update Employee Button
        JButton updateEmployeeButton = new JButton("Update Employee");
        updateEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUpdateEmployeeForm();
            }
        });
        employeePanel.add(updateEmployeeButton);

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

        // Add Inventory Button
        JButton addInventoryButton = new JButton("Add Inventory");
        addInventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddInventoryForm();
            }
        });
        inventoryPanel.add(addInventoryButton);

        // Update Inventory Button
        JButton updateInventoryButton = new JButton("Update Inventory");
        updateInventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUpdateInventoryForm();
            }
        });
        inventoryPanel.add(updateInventoryButton);

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

        // Add Purchase Button
        JButton addPurchaseButton = new JButton("Add Purchase");
        addPurchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddPurchaseForm();
            }
        });
        purchasePanel.add(addPurchaseButton);

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

    private static void openAddCustomerForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Customer Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.addCustomer();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static void openUpdateCustomerForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Update Customer Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.updateCustomer();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static void openAddDistributorForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Distributor Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.addDistributor();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static void openUpdateDistributorForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Update Distributor Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.updateDistributor();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static void openAddEmployeeForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Employee Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.addEmployee();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static void openUpdateEmployeeForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Update Employee Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.updateEmployee();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static void openAddInventoryForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Inventory Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.addInventory();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static void openUpdateInventoryForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Update Inventory Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.updateInventory();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static void openAddPurchaseForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Purchase Form");
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                //GroceryStoreAPI.addPurchase();
                //refreshTables();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
}
