package edu.tcss545.group10.store.dbmodels;

public class Distributor implements Comparable<Distributor> {

    private int distributorId;
    private String name;
    private String phone;
    private String address;
    private String primaryContactName;

    public Distributor(int distributorId, String name, String phone, String address, String primaryContactName) {
        this.distributorId = distributorId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.primaryContactName = primaryContactName;
    }

    public Distributor(int distributorId, String phone, String address, String primaryContactName) {
        this.distributorId = distributorId;
        this.phone = phone;
        this.address = address;
        this.primaryContactName = primaryContactName;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrimaryContactName() {
        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {
        this.primaryContactName = primaryContactName;
    }

    public int compareTo(Distributor other) {
        return this.distributorId > other.distributorId ? 1 : -1;
    }
}
