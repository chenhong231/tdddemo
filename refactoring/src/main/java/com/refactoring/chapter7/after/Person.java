package com.refactoring.chapter7.after;

public class Person {

    private String name;
    private TelephoneNumber telephone = new TelephoneNumber();
    private Department department;

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephone.getTelephoneNumber();
    }

    TelephoneNumber getOfficeTelephone() {
        return telephone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person getManager() {
        return department.getManager();
    }
}
