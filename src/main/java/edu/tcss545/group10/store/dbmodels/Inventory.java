package edu.tcss545.group10.store.dbmodels;

public class Inventory {

    private int itemId;
    private String name;
    private String description;
    private int departmentId;
    private int distributorId;
    private double currentPrice;
    private int inventoryCount;

    public Inventory(int itemId, String name, String description, int departmentId,
                     int distributorId, double currentPrice, int inventoryCount) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.departmentId = departmentId;
        this.distributorId = distributorId;
        this.currentPrice = currentPrice;
        this.inventoryCount = inventoryCount;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
