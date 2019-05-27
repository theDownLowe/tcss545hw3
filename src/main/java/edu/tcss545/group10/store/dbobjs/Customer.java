package edu.tcss545.group10.store.dbobjs;

import java.util.Date;

public class Customer {

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
    }
}
