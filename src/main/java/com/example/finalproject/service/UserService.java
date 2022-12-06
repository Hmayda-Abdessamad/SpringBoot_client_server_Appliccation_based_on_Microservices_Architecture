package com.example.finalproject.service;

import com.example.finalproject.Beans.Admin;
import com.example.finalproject.Beans.Client;
import com.example.finalproject.Beans.Consommateur;
import com.example.finalproject.Beans.User;
import com.example.finalproject.controllers.AddResponse;
import com.example.finalproject.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return  userRepo.findAll();

    }

    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }

    public User getUserByEmail(String email) {
        List<User> users = userRepo.findAll();
        User user = null;
        for (User utilisateur :users){
            if (utilisateur.getEmail().equalsIgnoreCase(email)){
                user=utilisateur;
            }
        }
        return user;
    }
    public Client addClient(Client client){
        client.setId(getMaxId());
        userRepo.save(client);
        return client;
    }

    public Consommateur addConsommateur(Consommateur consommateur){
        consommateur.setId(getMaxId());
        userRepo.save(consommateur);
        return consommateur;
    }

    public Admin addAdmin(Admin admin){
        admin.setId(getMaxId());
        userRepo.save(admin);
        return admin;
    }


    public int getMaxId(){
        System.out.println(userRepo.findAll().size()+1);
        return userRepo.findAll().size()+1;

    }
    public User updateUser(User user){
        userRepo.save(user);
        return user;
    }
    public AddResponse deleteUserByID(int id){
        userRepo.deleteById(id);
        AddResponse res = new AddResponse();
        res.setId(id);
        res.setMsg("deleted succesfully");
        return res;
    }

    public void deleteUser(User user){
        userRepo.delete(user);
    }

}
