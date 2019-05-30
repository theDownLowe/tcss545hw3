package edu.tcss545.group10.store.dbmodels;

public class Department implements Comparable<Department>{

    private int departmentId;
    private String name;

    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Department other) {
        return this.departmentId > other.departmentId ? 1 : -1;
    }
}
