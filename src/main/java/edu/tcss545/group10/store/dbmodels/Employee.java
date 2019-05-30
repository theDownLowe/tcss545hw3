package edu.tcss545.group10.store.dbmodels;

import java.util.Date;

public class Employee implements Comparable<Employee> {

    private int employeeId;
    private String name;
    private String phone;
    private String address;
    private Date dob;
    private Date hireDate;
    private String position;
    private int departmentId;
    private double salary;
    private boolean isActiveEmployee;

    public Employee(int employeeId, String name, String phone, String address, Date dob, Date hireDate,
                    String position, int departmentId, double salary, boolean isActiveEmployee) {
        this.employeeId = employeeId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.hireDate = hireDate;
        this.position = position;
        this.departmentId = departmentId;
        this.salary = salary;
        this.isActiveEmployee = isActiveEmployee;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isActiveEmployee() {
        return isActiveEmployee;
    }

    public void setActiveEmployee(boolean activeEmployee) {
        isActiveEmployee = activeEmployee;
    }

    public int compareTo(Employee other) {
        return this.employeeId > other.employeeId ? 1 : -1;
    }
}
