package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class GroceryStoreAPITest {

    @BeforeEach
    void init() {
        System.out.println("Resetting DB");
        GroceryStoreAPI.resetDatabase();
    }

    @AfterAll
    static void tearDown() {
        GroceryStoreAPI.resetDatabase();
    }

    @Test
    void testAddCustomer() {
        Customer testCustomer = new Customer(11, "testName", "1234567890",
                "testAddress", new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), 100);
        GroceryStoreAPI.addCustomer(testCustomer);
        Set<Customer> customers = GroceryStoreAPI.getCustomers();
        boolean found = false;
        for (Customer c : customers) {
            if (c.getCustomerId() == 11) {
                assertEquals("testName", c.getName());
                assertEquals("1234567890", c.getPhone());
                assertEquals("testAddress", c.getAddress());
                assertEquals(100, c.getRewardsPoints());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void testUpdateCustomer() {
        Customer testCustomer = new Customer(11, "testName", "1234567890",
                "testAddress", new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), 100);
        GroceryStoreAPI.addCustomer(testCustomer);
        testCustomer = new Customer(11, "0987654321", "newAddress");
        GroceryStoreAPI.updateCustomer(testCustomer);
        Set<Customer> customers = GroceryStoreAPI.getCustomers();
        boolean found = false;
        for (Customer c : customers) {
            if (c.getCustomerId() == 11) {
                assertEquals("0987654321", c.getPhone());
                assertEquals("newAddress", c.getAddress());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void testAddDistributor() {
        Distributor distributor = new Distributor(11, "testName",
                "1234567890", "testAddress", "testPCN");
        GroceryStoreAPI.addDistributor(distributor);
        Set<Distributor> distributors = GroceryStoreAPI.getDistributors();
        boolean found = false;
        for (Distributor d : distributors) {
            if (d.getDistributorId() == 11) {
                assertEquals("testName", d.getName());
                assertEquals("1234567890", d.getPhone());
                assertEquals("testAddress", d.getAddress());
                assertEquals("testPCN", d.getPrimaryContactName());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void testUpdateDistributor() {
        Distributor distributor = new Distributor(11, "testName",
                "1234567890", "testAddress", "testPCN");
        GroceryStoreAPI.addDistributor(distributor);
        distributor = new Distributor(11, "0987654321", "newAddress", "newPCN");
        GroceryStoreAPI.updateDistributor(distributor);
        Set<Distributor> distributors = GroceryStoreAPI.getDistributors();
        boolean found = false;
        for (Distributor d : distributors) {
            if (d.getDistributorId() == 11) {
                assertEquals("0987654321", d.getPhone());
                assertEquals("newAddress", d.getAddress());
                assertEquals("newPCN", d.getPrimaryContactName());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void testAddInventoryItem() {
        Inventory inventory = new Inventory(11, "testName", "testDescription",
                1, 1, 1.00, 1);
        GroceryStoreAPI.addInventoryItem(inventory);
        Set<Inventory> inventories = GroceryStoreAPI.getInventoryItems();
        boolean found = false;
        for (Inventory i : inventories) {
            if (i.getItemId() == 11) {
                assertEquals("testName", i.getName());
                assertEquals("testDescription", i.getDescription());
                assertEquals(1, i.getDepartmentId());
                assertEquals(1, i.getDistributorId());
                assertEquals(1.00, i.getCurrentPrice());
                assertEquals(1, i.getInventoryCount());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void testUpdateInventoryItem() {
        Inventory inventory = new Inventory(11, "testName", "testDescription",
                1, 1, 1.00, 1);
        GroceryStoreAPI.addInventoryItem(inventory);
        inventory = new Inventory(11, 2.00, 2);
        GroceryStoreAPI.updateInventoryItem(inventory);
        Set<Inventory> inventories = GroceryStoreAPI.getInventoryItems();
        boolean found = false;
        for (Inventory i : inventories) {
            if (i.getItemId() == 11) {
                assertEquals("testName", i.getName());
                assertEquals(2.00, i.getCurrentPrice());
                assertEquals(2, i.getInventoryCount());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(11, "testName", "1234567890",
                "testAddress",  new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), "testPosition",
                1, 10000, true);
        GroceryStoreAPI.addEmployee(employee);
        Set<Employee> employees = GroceryStoreAPI.getEmployees();
        boolean found = false;
        for (Employee e : employees) {
            if (e.getEmployeeId() == 11) {
                assertEquals("testName", e.getName());
                assertEquals("1234567890", e.getPhone());
                assertEquals("testAddress", e.getAddress());
                assertEquals("testPosition", e.getPosition());
                assertEquals(1, e.getDepartmentId());
                assertEquals(10000, e.getSalary());
                assertTrue(e.isActiveEmployee());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee(11, "testName", "1234567890",
                "testAddress",  new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), "testPosition",
                1, 10000, true);
        GroceryStoreAPI.addEmployee(employee);
        employee = new Employee(11, "0987654321", "newAddress",
                "newPosition", 2, 50000, false);
        GroceryStoreAPI.updateEmployee(employee);
        Set<Employee> employees = GroceryStoreAPI.getEmployees();
        boolean found = false;
        for (Employee e : employees) {
            if (e.getEmployeeId() == 11) {
                assertEquals("0987654321", e.getPhone());
                assertEquals("newAddress", e.getAddress());
                assertEquals("newPosition", e.getPosition());
                assertEquals(2, e.getDepartmentId());
                assertEquals(50000, e.getSalary());
                assertFalse(e.isActiveEmployee());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void testAddPurchase() {
        Purchase purchase = new Purchase(11, 1, 1,
                1, 1.00, 1, 1.00);
        GroceryStoreAPI.addPurchase(purchase);
        Set<Purchase> purchases = GroceryStoreAPI.getPurchases();
        boolean found = false;
        for (Purchase p : purchases) {
            if (p.getPurchaseId() == 11) {
                assertEquals(1, p.getEmployeeId());
                assertEquals(1, p.getCustomerId());
                assertEquals(1, p.getItemId());
                assertEquals(1.00, p.getCostPerUnit());
                assertEquals(1, p.getQuantity());
                assertEquals(1.00, p.getTotalCost());
                found = true;
            }
        }
        assertTrue(found);
    }
}
