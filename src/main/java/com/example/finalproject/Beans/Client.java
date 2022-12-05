package com.example.finalproject.Beans;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value="Client")
public class Client extends User {

    @Column(name = "ville")
    private String ville;

    public Client() {
    }

    public Client(String fName, String lName, String userName, String email, String gender, String password, String ville) {
        super(fName, lName, userName, email, gender, password);
        this.ville = ville;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ville='" + ville + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
