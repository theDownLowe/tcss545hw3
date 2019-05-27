package edu.tcss545.group10.store.dbmodels;

public class Purchase {

    private int purchaseId;
    private int employeeId;
    private int CustomerId;
    private int ItemId;
    private double costPerUnit;
    private int quantity;
    private double totalCost;

    public Purchase(int purchaseId, int employeeId, int customerId, int itemId,
                    double costPerUnit, int quantity, double totalCost) {
        this.purchaseId = purchaseId;
        this.employeeId = employeeId;
        CustomerId = customerId;
        ItemId = itemId;
        this.costPerUnit = costPerUnit;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
