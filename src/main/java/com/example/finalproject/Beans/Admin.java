package com.example.finalproject.Beans;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "admin")
public class Admin extends User {
    @Column(name = "department")
    private String department;

    public Admin() {

    }

    public Admin(String fName, String lName, String userName, String email, String gender, String password, String department) {
        super(fName, lName, userName, email, gender, password);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "department='" + department + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

