package edu.tcss545.group10.store.dbmodels;

import java.sql.Date;

public class Customer implements Comparable<Customer> {

    private int customerId;
    private String name;
    private String phone;
    private String address;
    private Date dob;
    private Date customerSince;
    private int rewardsPoints;

    public Customer(int customerId, String name, String phone, String address, Date dob, Date customerSince, int rewardsPoints) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.customerSince = customerSince;
        this.rewardsPoints = rewardsPoints;
    }

    public Customer(int customerId, String phone, String address) {
        this.customerId = customerId;
        this.phone = phone;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(Date customerSince) {
        this.customerSince = customerSince;
    }

    public int getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(int rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }

    public int compareTo(Customer other) {
        return this.customerId > other.customerId ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", customerSince=" + customerSince +
                ", rewardsPoints=" + rewardsPoints +
                '}';
    }
}
