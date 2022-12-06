package com.example.finalproject.controllers;

import com.example.finalproject.Beans.Admin;
import com.example.finalproject.Beans.Client;
import com.example.finalproject.Beans.User;
import com.example.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();

    }
    @GetMapping("/getUsers/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value="id") int id){
        try {
            User country = userService.getUserById(id);
            return new ResponseEntity<User>(country, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getUsers/{email}")
    public ResponseEntity<User>  getUserByEmail(@PathVariable(value = "email") String email){
        try {
            User user = userService.getUserByEmail(email);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client){
        return userService.addClient(client);
    }

    @PostMapping("/addAdmin")
    public Admin addAdimn(@RequestBody Admin admin){
        return userService.addAdmin(admin);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id,@RequestBody User user){
        try {
            User existUser =  userService.getUserById(id);
            existUser.setlName(user.getlName());
            existUser.setfName(user.getfName());
            existUser.setEmail(user.getEmail());
            existUser.setUserName(user.getUserName());
            existUser.setPassword(user.getPassword());
            existUser.setGender(user.getGender());

            User updated_user = userService.updateUser(existUser);
            return new ResponseEntity<User>(updated_user, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }


    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteCountry(@PathVariable int id){
        User user=null;
        try {
            user=userService.getUserById(id);
            userService.deleteUser(user);

        }catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

}
