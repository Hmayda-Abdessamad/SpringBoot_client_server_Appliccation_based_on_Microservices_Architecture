package com.example.finalproject.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Consommateur extends Client {

    @Column(name = "cin")
    private String cin;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "address")
    private String address;

    public Consommateur() {
    }

    public Consommateur(String fName, String lName, String userName, String email, String gender, String password, String ville, String cin, String telephone, String address) {
        super(fName, lName, userName, email, gender, password, ville);
        this.cin = cin;
        this.telephone = telephone;
        this.address = address;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Consommateur{" +
                "cin='" + cin + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
