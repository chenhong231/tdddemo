package com.refactoring.chapter7.before;

public class Person {

    private String name;
    private String officeAreaCode;
    private String officeNumber;

    private Department department;

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return "(" + officeAreaCode + ")" + officeNumber;
    }

    String getOfficeAreaCode() {
        return officeAreaCode;
    }

    void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }

    private String getOfficeNumber() {
        return officeNumber;
    }

    private void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
