package edu.tcss545.group10.store;

import edu.tcss545.group10.store.dbmodels.*;

import java.util.Set;

/**
 * Utility class used primarily for data conversions.
 */
class GroceryStoreUtil {

    /**
     * Transforms a Set of Customers into a 2D Object arr of Customers.
     *
     * @param customers - Set to be converted
     * @return 2D Object arr representation
     */
    static Object[][] getCustomers(Set<Customer> customers) {
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

    /**
     * Transforms a Set of Distributors into a 2D Object arr of Distributors.
     *
     * @param distributors - Set to be converted
     * @return 2D Object arr representation
     */
    static Object[][] getDistributors(Set<Distributor> distributors) {
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

    /**
     * Transforms a Set of Employees into a 2D Object arr of Employees.
     *
     * @param employees - Set to be converted
     * @return 2D Object arr representation
     */
    static Object[][] getEmployees(Set<Employee> employees) {
        if (employees == null) {
            return null;
        }

        Object[][] empls = new Object[employees.size()][10];
        int i = 0;
        for (Employee e : employees) {
            empls[i][0] = e.getEmployeeId();
            empls[i][1] = e.getName();
            empls[i][2] = e.getPhone();
            empls[i][3] = e.getAddress();
            empls[i][4] = e.getDob();
            empls[i][5] = e.getHireDate();
            empls[i][6] = e.getPosition();
            empls[i][7] = e.getDepartmentId();
            empls[i][8] = e.getSalary();
            empls[i][9] = e.isActiveEmployee();
            i++;
        }

        return empls;
    }

    /**
     * Transforms a Set of Inventory Items into a 2D Object arr of Inventory Items.
     *
     * @param inventoryItems - Set to be converted
     * @return 2D Object arr representation
     */
    static Object[][] getInventoryItems(Set<Inventory> inventoryItems) {
        if (inventoryItems == null) {
            return null;
        }

        Object[][] invt = new Object[inventoryItems.size()][7];
        int i = 0;
        for (Inventory in : inventoryItems) {
            invt[i][0] = in.getItemId();
            invt[i][1] = in.getName();
            invt[i][2] = in.getDescription();
            invt[i][3] = in.getDepartmentId();
            invt[i][4] = in.getDistributorId();
            invt[i][5] = in.getCurrentPrice();
            invt[i][6] = in.getInventoryCount();
            i++;
        }

        return invt;
    }

    /**
     * Transforms a Set of Purchases into a 2D Object arr of Purchases.
     *
     * @param purchases - Set to be converted
     * @return 2D Object arr representation
     */
    static Object[][] getPurchases(Set<Purchase> purchases) {
        if (purchases == null) {
            return null;
        }

        Object[][] purs = new Object[purchases.size()][7];
        int i = 0;
        for (Purchase p : purchases) {
            purs[i][0] = p.getPurchaseId();
            purs[i][1] = p.getEmployeeId();
            purs[i][2] = p.getCustomerId();
            purs[i][3] = p.getItemId();
            purs[i][4] = p.getCostPerUnit();
            purs[i][5] = p.getQuantity();
            purs[i][6] = p.getTotalCost();
            i++;
        }

        return purs;
    }

    /**
     * Transforms a Set of Departments into a 2D Object arr of Departments.
     *
     * @param departments - Set to be converted
     * @return 2D Object arr representation
     */
    static Object[][] getDepartments(Set<Department> departments) {
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
