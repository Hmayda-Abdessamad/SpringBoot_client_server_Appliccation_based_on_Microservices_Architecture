package com.example.finalproject.Beans;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role")
public class User {
    @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "f_name")
    protected String fName;
    @Column(name = "l_name")
    protected String lName;
    @Column(name = "user_name")
    protected String userName;
    @Column(name = "email")
    protected String email;
    @Column(name = "gender")
    protected String gender;
    @Column(name = "password")
    protected String password;

    public User() {
    }


    public User(String fName, String lName, String userName, String email, String gender, String password) {
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

