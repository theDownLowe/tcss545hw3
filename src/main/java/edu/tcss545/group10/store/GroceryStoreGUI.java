package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Displays the GUI for the Grocery Store Application.
 * Visualizes the database tables and allows users to add and modify the tables.
 */
class GroceryStoreGUI {

    // Icon
    private static final String GC_ICON_LOCATION = "src/main/resources/grocery-icon.png";

    // Table Columns
    private static final String[] CUSTOMER_COLS = {"CustomerId", "Name", "Phone", "Address", "DoB", "Customer Since", "Rewards Points"};
    private static final String[]  DISTRIBUTOR_COLS = {"DistributorId", "Name", "Phone", "Address", "Primary Contact Name"};
    private static final String[] EMPLOYEE_COLS = {"EmployeeId", "Name", "Phone", "Address", "DoB", "Hire Date", "Position",
            "DepartmentId", "Salary", "IsActive"};
    private static final String[] INVENTORY_COLS = {"ItemId", "Name", "Description", "DepartmentId", "DistributorId",
            "Current Price", "Inventory Count"};
    private static final String[] PURCHASE_COLS = {"PurchaseId", "EmployeeId", "CustomerId", "ItemId", "Cost Per Unit", "Quantity", "Total Cost"};
    private static final String[] DEPARTMENT_COLS = {"DepartmentId", "Name"};

    // GUI Frame
    private static JFrame frame;

    // Table data sets
    private static Object[][] customerData = {};
    private static Object[][] distributorData = {};
    private static Object[][] employeeData = {};
    private static Object[][] inventoryData = {};
    private static Object[][] purchaseData = {};
    private static Object[][] departmentData = {};

    // Data tables
    private static JTable customerTable;
    private static JTable distributorTable;
    private static JTable employeeTable;
    private static JTable inventoryTable;
    private static JTable purchaseTable;
    private static JTable departmentTable;

    /**
     * Generates the user interface for the Grocery Store Application.
     */
    static void generateGUI() {
        // Initialize JFrame
        frame = new JFrame("Grocery Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 650);
        frame.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon(GC_ICON_LOCATION);
        frame.setIconImage(img.getImage());

        refreshData();

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

    /**
     * Adds the database table tabs to the GUI.
     */
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

    /**
     * The home tab, used to welcome user and display basic information.
     *
     * @param tabbedPane - Pane the tab is to be added to
     */
    private static void addHomeTab(JTabbedPane tabbedPane) {
        JComponent homePanel = new JPanel();
        FlowLayout layout = new FlowLayout();
        layout.setHgap(300);
        homePanel.setLayout(layout);
        JLabel homeLabel = new JLabel("Welcome to the Grocery Store Data Administrator Application!");
        homePanel.add(homeLabel);
        homePanel.add(new JLabel(" "));
        homePanel.add(new JLabel("To view a table, select one of the tabs above."));
        homePanel.add(new JLabel("To add/update a record, select the button below some of the tables and fill out the form."));
        homePanel.add(new JLabel("To refresh the data set, press the 'Refresh Data' button at the top and wait a few seconds."));

        tabbedPane.add("Home", homePanel);
    }

    /**
     * Tab to display the Customer information.
     * Also allows for Addition and Modification of Customer data.
     *
     * @param tabbedPane - Pane the tab is to be added to
     */
    private static void addCustomerTab(JTabbedPane tabbedPane) {
        JComponent customerPanel = new JPanel();

        Object[][] rowData = customerData;

        customerTable = new JTable(new DefaultTableModel(rowData, CUSTOMER_COLS));
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

    /**
     * Tab to display the Distributor information.
     * Also allows for Addition and Modification of Distributor data.
     *
     * @param tabbedPane - Pane the tab is to be added to
     */
    private static void addDistributorTab(JTabbedPane tabbedPane) {
        JComponent distributorPanel = new JPanel();

        Object[][] rowData = distributorData;
        distributorTable = new JTable(new DefaultTableModel(rowData, DISTRIBUTOR_COLS));
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

    /**
     * Tab to display the Employee information.
     * Also allows for Addition and Modification of Employee data.
     *
     * @param tabbedPane - Pane the tab is to be added to
     */
    private static void addEmployeeTab(JTabbedPane tabbedPane) {
        JComponent employeePanel = new JPanel();

        Object[][] rowData = employeeData;
        employeeTable = new JTable(new DefaultTableModel(rowData, EMPLOYEE_COLS));
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

    /**
     * Tab to display the Inventory information.
     * Also allows for Addition and Modification of Inventory data.
     *
     * @param tabbedPane - Pane the tab is to be added to
     */
    private static void addInventoryTab(JTabbedPane tabbedPane) {
        JComponent inventoryPanel = new JPanel();

        Object[][] rowData = inventoryData;
        inventoryTable = new JTable(new DefaultTableModel(rowData, INVENTORY_COLS));
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

    /**
     * Tab to display the Purchase information.
     * Also allows for Addition of Purchase data.
     *
     * @param tabbedPane - Pane the tab is to be added to
     */
    private static void addPurchaseTab(JTabbedPane tabbedPane) {
        JComponent purchasePanel = new JPanel();

        Object[][] rowData = purchaseData;
        purchaseTable = new JTable(new DefaultTableModel(rowData, PURCHASE_COLS));
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

    /**
     * Tab to display the Department information.
     *
     * @param tabbedPane - Pane the tab is to be added to
     */
    private static void addDepartmentTab(JTabbedPane tabbedPane) {
        JComponent departmentPanel = new JPanel();

        Object[][] rowData = departmentData;
        departmentTable = new JTable(new DefaultTableModel(rowData, DEPARTMENT_COLS));
        JScrollPane scrollPane = new JScrollPane(departmentTable);
        scrollPane.setPreferredSize(new Dimension(650, 500));
        departmentPanel.add(scrollPane);

        tabbedPane.add("Departments", departmentPanel);
    }

    /**
     * Opens the form to Add a new Customer record.
     */
    private static void openAddCustomerForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Customer Form");
        dialog.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label);

        // Customer Name Field
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Customer Full Name: "));
        final JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 24));
        namePanel.add(nameField);
        dialog.add(namePanel);

        // Customer Phone Field
        JPanel phonePanel = new JPanel();
        phonePanel.add(new JLabel("Customer Phone Number: "));
        final JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 24));
        phonePanel.add(phoneField);
        dialog.add(phonePanel);

        // Customer Address Field
        JPanel addressPanel = new JPanel();
        addressPanel.add(new JLabel("Customer Address: "));
        final JTextField addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 24));
        addressPanel.add(addressField);
        dialog.add(addressPanel);

        // Customer Date of Birth
        JPanel dobPanel = new JPanel();
        dobPanel.add(new JLabel("Customer Date of Birth (yyyy-MM-dd): "));
        final JTextField dobField = new JTextField();
        dobField.setPreferredSize(new Dimension(200, 24));
        dobPanel.add(dobField);
        dialog.add(dobPanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = sdf.parse(dobField.getText());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    Customer customer = new Customer(-1, nameField.getText(), phoneField.getText(),
                            addressField.getText(), new java.sql.Date(date.getTime()),
                            new java.sql.Date(System.currentTimeMillis()), 0);
                    GroceryStoreAPI.addCustomer(customer);
                    updateCustomerTable();
                } catch (Exception ex) {
                    showErrorDialog();
                }
                dialog.dispose();

            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Opens the form to Update an existing Customer record.
     */
    private static void openUpdateCustomerForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Update Customer Form");
        dialog.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Customer ID Field
        final JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("Customer ID to Update: "));
        final JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 24));
        idPanel.add(idField);
        dialog.add(idPanel);

        // Customer Phone Field
        JPanel phonePanel = new JPanel();
        phonePanel.add(new JLabel("Customer Phone Number: "));
        final JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 24));
        phonePanel.add(phoneField);
        dialog.add(phonePanel);

        // Customer Address Field
        JPanel addressPanel = new JPanel();
        addressPanel.add(new JLabel("Customer Address: "));
        final JTextField addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 24));
        addressPanel.add(addressField);
        dialog.add(addressPanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GroceryStoreAPI.updateCustomer(new Customer(Integer.parseInt(idField.getText()), phoneField.getText(), addressField.getText()));
                    updateCustomerTable();
                } catch (Exception ex) {
                    showErrorDialog();
                }
                dialog.dispose();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Opens the form to Add a new Distributor record.
     */
    private static void openAddDistributorForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Distributor Form");
        dialog.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Distributor Name Field
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Distributor Name: "));
        final JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 24));
        namePanel.add(nameField);
        dialog.add(namePanel);

        // Distributor Phone Field
        JPanel phonePanel = new JPanel();
        phonePanel.add(new JLabel("Distributor Phone Number: "));
        final JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 24));
        phonePanel.add(phoneField);
        dialog.add(phonePanel);

        // Distributor Address Field
        JPanel addressPanel = new JPanel();
        addressPanel.add(new JLabel("Distributor Address: "));
        final JTextField addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 24));
        addressPanel.add(addressField);
        dialog.add(addressPanel);

        // Distributor Primary Contact Name Field
        JPanel pcnPanel = new JPanel();
        pcnPanel.add(new JLabel("Distributor Primary Contact Name: "));
        final JTextField pcnField = new JTextField();
        pcnField.setPreferredSize(new Dimension(200, 24));
        pcnPanel.add(pcnField);
        dialog.add(pcnPanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GroceryStoreAPI.addDistributor(new Distributor(1, nameField.getText(),
                            phoneField.getText(), addressField.getText(), pcnField.getText()));
                    updateDistributorTable();
                } catch (Exception ex) {
                    showErrorDialog();
                }
                dialog.dispose();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Opens the form to Update an existing Distributor record.
     */
    private static void openUpdateDistributorForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Update Distributor Form");
        dialog.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Distributor Id Field
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("Distributor ID to Update: "));
        final JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 24));
        idPanel.add(idField);
        dialog.add(idPanel);

        // Distributor Phone Field
        JPanel phonePanel = new JPanel();
        phonePanel.add(new JLabel("Distributor Phone Number: "));
        final JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 24));
        phonePanel.add(phoneField);
        dialog.add(phonePanel);

        // Distributor Address Field
        JPanel addressPanel = new JPanel();
        addressPanel.add(new JLabel("Distributor Address: "));
        final JTextField addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 24));
        addressPanel.add(addressField);
        dialog.add(addressPanel);

        // Distributor Primary Contact Name Field
        JPanel pcnPanel = new JPanel();
        pcnPanel.add(new JLabel("Distributor Primary Contact Name: "));
        final JTextField pcnField = new JTextField();
        pcnField.setPreferredSize(new Dimension(200, 24));
        pcnPanel.add(pcnField);
        dialog.add(pcnPanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GroceryStoreAPI.updateDistributor(new Distributor(Integer.parseInt(idField.getText()),
                            phoneField.getText(), addressField.getText(), pcnField.getText()));
                    updateDistributorTable();

                } catch (Exception ex) {
                    showErrorDialog();
                }

                dialog.dispose();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Opens the form to Add a new Employee record.
     */
    private static void openAddEmployeeForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Employee Form");
        dialog.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Employee Name Field
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Employee Full Name: "));
        final JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 24));
        namePanel.add(nameField);
        dialog.add(namePanel);

        // Employee Phone Field
        JPanel phonePanel = new JPanel();
        phonePanel.add(new JLabel("Employee Phone Number: "));
        final JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 24));
        phonePanel.add(phoneField);
        dialog.add(phonePanel);

        // Employee Address Field
        JPanel addressPanel = new JPanel();
        addressPanel.add(new JLabel("Employee Address: "));
        final JTextField addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 24));
        addressPanel.add(addressField);
        dialog.add(addressPanel);

        // Employee DoB Field
        JPanel dobPanel = new JPanel();
        dobPanel.add(new JLabel("Employee Date of Birth (yyyy-MM-dd): "));
        final JTextField dobField = new JTextField();
        dobField.setPreferredSize(new Dimension(200, 24));
        dobPanel.add(dobField);
        dialog.add(dobPanel);

        // Employee Position Field
        JPanel positionPanel = new JPanel();
        positionPanel.add(new JLabel("Employee Position: "));
        final JTextField positionField = new JTextField();
        positionField.setPreferredSize(new Dimension(200, 24));
        positionPanel.add(positionField);
        dialog.add(positionPanel);

        // Employee Department ID Field
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("Department ID: "));
        final JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 24));
        idPanel.add(idField);
        dialog.add(idPanel);

        // Employee Salary Field
        JPanel salaryPanel = new JPanel();
        salaryPanel.add(new JLabel("Employee Salary: "));
        final JTextField salaryField = new JTextField();
        salaryField.setPreferredSize(new Dimension(200, 24));
        salaryPanel.add(salaryField);
        dialog.add(salaryPanel);

        // Employee Is Active Checkbox
        JPanel isActivePanel = new JPanel();
        isActivePanel.add(new JLabel("Employee Is Active: "));
        final JCheckBox isActiveBox = new JCheckBox();
        isActiveBox.setSelected(true);
        isActivePanel.add(isActiveBox);
        dialog.add(isActivePanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = sdf.parse(dobField.getText());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    GroceryStoreAPI.addEmployee(new Employee(-1, nameField.getText(),
                            phoneField.getText(), addressField.getText(), new java.sql.Date(date.getTime()),
                            new java.sql.Date(System.currentTimeMillis()), positionField.getText(),
                            Integer.parseInt(idField.getText()), Double.parseDouble(salaryField.getText()),
                            isActiveBox.isSelected()));
                    updateEmployeeTable();
                } catch (Exception ex) {
                    showErrorDialog();
                }
                dialog.dispose();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Opens the form to Update an existing Employee record.
     */
    private static void openUpdateEmployeeForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Update Employee Form");
        dialog.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Employee ID
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("Employee ID to Update: "));
        final JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 24));
        idPanel.add(idField);
        dialog.add(idPanel);

        // Phone
        JPanel phonePanel = new JPanel();
        phonePanel.add(new JLabel("Employee Phone Number: "));
        final JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 24));
        phonePanel.add(phoneField);
        dialog.add(phonePanel);

        // Address
        JPanel addressPanel = new JPanel();
        addressPanel.add(new JLabel("Employee Address: "));
        final JTextField addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 24));
        addressPanel.add(addressField);
        dialog.add(addressPanel);

        // Position
        JPanel positionPanel = new JPanel();
        positionPanel.add(new JLabel("Employee Position: "));
        final JTextField positionField = new JTextField();
        positionField.setPreferredSize(new Dimension(200, 24));
        positionPanel.add(positionField);
        dialog.add(positionPanel);

        // Department Id
        JPanel didPanel = new JPanel();
        didPanel.add(new JLabel("Department ID: "));
        final JTextField didField = new JTextField();
        didField.setPreferredSize(new Dimension(200, 24));
        didPanel.add(didField);
        dialog.add(didPanel);

        // Salary
        JPanel salaryPanel = new JPanel();
        salaryPanel.add(new JLabel("Employee Salary: "));
        final JTextField salaryField = new JTextField();
        salaryField.setPreferredSize(new Dimension(200, 24));
        salaryPanel.add(salaryField);
        dialog.add(salaryPanel);

        // Active Employee Status
        JPanel isActivePanel = new JPanel();
        isActivePanel.add(new JLabel("Employee Is Active: "));
        final JCheckBox isActiveBox = new JCheckBox();
        isActiveBox.setSelected(true);
        isActivePanel.add(isActiveBox);
        dialog.add(isActivePanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GroceryStoreAPI.updateEmployee(new Employee(Integer.parseInt(idField.getText()),
                            phoneField.getText(), addressField.getText(), positionField.getText(),
                            Integer.parseInt(didField.getText()), Double.parseDouble(salaryField.getText()),
                            isActiveBox.isSelected()));
                    updateEmployeeTable();
                } catch (Exception ex) {
                    showErrorDialog();
                }
                dialog.dispose();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Opens the form to Add a new Inventory record.
     */
    private static void openAddInventoryForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Inventory Form");
        dialog.setLocationRelativeTo(null);        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Name
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Item Name: "));
        final JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 24));
        namePanel.add(nameField);
        dialog.add(namePanel);

        // Description
        JPanel descPanel = new JPanel();
        descPanel.add(new JLabel("Item Description: "));
        final JTextField descField = new JTextField();
        descField.setPreferredSize(new Dimension(200, 24));
        descPanel.add(descField);
        dialog.add(descPanel);

        // Department Id
        JPanel didPanel = new JPanel();
        didPanel.add(new JLabel("Department ID: "));
        final JTextField didField = new JTextField();
        didField.setPreferredSize(new Dimension(200, 24));
        didPanel.add(didField);
        dialog.add(didPanel);

        // Distributor Id
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("Distributor ID: "));
        final JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 24));
        idPanel.add(idField);
        dialog.add(idPanel);

        // Current Price
        JPanel pricePanel = new JPanel();
        pricePanel.add(new JLabel("Item Current Price: "));
        final JTextField priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(200, 24));
        pricePanel.add(priceField);
        dialog.add(pricePanel);

        // Inventory Count
        JPanel countPanel = new JPanel();
        countPanel.add(new JLabel("Item Inventory Count: "));
        final JTextField countField = new JTextField();
        countField.setPreferredSize(new Dimension(200, 24));
        countPanel.add(countField);
        dialog.add(countPanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GroceryStoreAPI.addInventoryItem(new Inventory(-1, nameField.getText(), descField.getText(),
                            Integer.parseInt(didField.getText()), Integer.parseInt(idField.getText()),
                            Double.parseDouble(priceField.getText()), Integer.parseInt(countField.getText())));
                    updateInventoryTable();
                } catch (Exception ex) {
                    showErrorDialog();
                }
                dialog.dispose();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Opens the form to Update an existing Inventory record.
     */
    private static void openUpdateInventoryForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Update Inventory Form");
        dialog.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Inventory ID
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("Inventory Item ID to Update: "));
        final JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 24));
        idPanel.add(idField);
        dialog.add(idPanel);

        // Current Price
        JPanel pricePanel = new JPanel();
        pricePanel.add(new JLabel("Item Current Price: "));
        final JTextField priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(200, 24));
        pricePanel.add(priceField);
        dialog.add(pricePanel);

        // Inventory Count
        JPanel countPanel = new JPanel();
        countPanel.add(new JLabel("Item Inventory Count: "));
        final JTextField countField = new JTextField();
        countField.setPreferredSize(new Dimension(200, 24));
        countPanel.add(countField);
        dialog.add(countPanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GroceryStoreAPI.updateInventoryItem(new Inventory(Integer.parseInt(idField.getText()),
                            Double.parseDouble(priceField.getText()), Integer.parseInt(countField.getText())));
                    updateInventoryTable();
                } catch (Exception ex) {
                    showErrorDialog();
                }
                dialog.dispose();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Opens the form to Add a new Purchase record.
     */
    private static void openAddPurchaseForm() {
        final JDialog dialog = new JDialog(frame, true);
        dialog.setSize(500, 500);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Add Purchase Form");
        dialog.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        dialog.setLayout(layout);

        JLabel label = new JLabel("Fill out the form...");
        dialog.add(label, BorderLayout.NORTH);

        // Employee Id
        JPanel eidPanel = new JPanel();
        eidPanel.add(new JLabel("Cashier's Employee Id: "));
        final JTextField eidField = new JTextField();
        eidField.setPreferredSize(new Dimension(200, 24));
        eidPanel.add(eidField);
        dialog.add(eidPanel);

        // Customer Id
        JPanel cidPanel = new JPanel();
        cidPanel.add(new JLabel("Purchasing Customer's Id: "));
        final JTextField cidField = new JTextField();
        cidField.setPreferredSize(new Dimension(200, 24));
        cidPanel.add(cidField);
        dialog.add(cidPanel);

        // Item Id
        JPanel iidPanel = new JPanel();
        iidPanel.add(new JLabel("Purchased Item Id: "));
        final JTextField iidField = new JTextField();
        iidField.setPreferredSize(new Dimension(200, 24));
        iidPanel.add(iidField);
        dialog.add(iidPanel);

        // Cost Per Unit
        JPanel cpuPanel = new JPanel();
        cpuPanel.add(new JLabel("Cost Per Unit: "));
        final JTextField cpuField = new JTextField();
        cpuField.setPreferredSize(new Dimension(200, 24));
        cpuPanel.add(cpuField);
        dialog.add(cpuPanel);

        // Quantity
        JPanel countPanel = new JPanel();
        countPanel.add(new JLabel("Item Purchase Quantity: "));
        final JTextField countField = new JTextField();
        countField.setPreferredSize(new Dimension(200, 24));
        countPanel.add(countField);
        dialog.add(countPanel);

        // Total Cost
        JPanel tcPanel = new JPanel();
        tcPanel.add(new JLabel("Total Purchase Cost: "));
        final JTextField tcField = new JTextField();
        tcField.setPreferredSize(new Dimension(200, 24));
        tcPanel.add(tcField);
        dialog.add(tcPanel);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GroceryStoreAPI.addPurchase(new Purchase(-1, Integer.parseInt(eidField.getText()),
                            Integer.parseInt(cidField.getText()), Integer.parseInt(iidField.getText()),
                            Double.parseDouble(cpuField.getText()), Integer.parseInt(countField.getText()),
                            Double.parseDouble(tcField.getText())));

                    updatePurchaseTable();
                    updateCustomerTable();
                    updateInventoryTable();
                } catch (Exception ex) {
                    showErrorDialog();
                }
                dialog.dispose();
            }
        });
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /**
     * Refreshes the data sets.
     */
    private static void refreshData() {
        customerData = GroceryStoreUtil.getCustomers(GroceryStoreAPI.getCustomers());
        distributorData = GroceryStoreUtil.getDistributors(GroceryStoreAPI.getDistributors());
        employeeData = GroceryStoreUtil.getEmployees(GroceryStoreAPI.getEmployees());
        inventoryData = GroceryStoreUtil.getInventoryItems(GroceryStoreAPI.getInventoryItems());
        purchaseData = GroceryStoreUtil.getPurchases(GroceryStoreAPI.getPurchases());
        departmentData = GroceryStoreUtil.getDepartments(GroceryStoreAPI.getDepartments());
    }

    /**
     * Refreshes the data tables.
     */
    private static void refreshTables() {
        updateCustomerTable();
        updateDistributorTable();
        updateEmployeeTable();
        updateInventoryTable();
        updatePurchaseTable();
        updateDepartmentTable();
    }

    /**
     * Updates the Customer table.
     */
    private static void updateCustomerTable() {
        customerData = GroceryStoreUtil.getCustomers(GroceryStoreAPI.getCustomers());
        DefaultTableModel dm = (DefaultTableModel) customerTable.getModel();
        dm.setNumRows(0);
        dm.setDataVector(customerData, CUSTOMER_COLS);
        dm.fireTableDataChanged();
    }

    /**
     * Updates the Distributor table.
     */
    private static void updateDistributorTable() {
        distributorData = GroceryStoreUtil.getDistributors(GroceryStoreAPI.getDistributors());
        DefaultTableModel dm = (DefaultTableModel) distributorTable.getModel();
        dm.setNumRows(0);
        dm.setDataVector(distributorData, DISTRIBUTOR_COLS);
        dm.fireTableDataChanged();
    }

    /**
     * Updates the Employee table.
     */
    private static void updateEmployeeTable() {
        employeeData = GroceryStoreUtil.getEmployees(GroceryStoreAPI.getEmployees());
        DefaultTableModel dm = (DefaultTableModel) employeeTable.getModel();
        dm.setNumRows(0);
        dm.setDataVector(employeeData, EMPLOYEE_COLS);
        dm.fireTableDataChanged();
    }

    /**
     * Updates the Inventory table.
     */
    private static void updateInventoryTable() {
        inventoryData = GroceryStoreUtil.getInventoryItems(GroceryStoreAPI.getInventoryItems());
        DefaultTableModel dm = (DefaultTableModel) inventoryTable.getModel();
        dm.setNumRows(0);
        dm.setDataVector(inventoryData, INVENTORY_COLS);
        dm.fireTableDataChanged();

    }

    /**
     * Updates the Purchase table.
     */
    private static void updatePurchaseTable() {
        purchaseData = GroceryStoreUtil.getPurchases(GroceryStoreAPI.getPurchases());
        DefaultTableModel dm = (DefaultTableModel) purchaseTable.getModel();
        dm.setNumRows(0);
        dm.setDataVector(purchaseData, PURCHASE_COLS);
        dm.fireTableDataChanged();
    }

    /**
     * Updates the Department table.
     */
    private static void updateDepartmentTable() {
        departmentData = GroceryStoreUtil.getDepartments(GroceryStoreAPI.getDepartments());
        DefaultTableModel dm = (DefaultTableModel) departmentTable.getModel();
        dm.setNumRows(0);
        dm.setDataVector(departmentData, DEPARTMENT_COLS);
        dm.fireTableDataChanged();

    }

    /**
     * Displays a popup error message when an exception is thrown.
     */
    private static void showErrorDialog() {
        JOptionPane.showMessageDialog(frame, "Some or all of the data entered was invalid. Try again.",
                "Invalid Input Error!", JOptionPane.ERROR_MESSAGE);
    }
}
