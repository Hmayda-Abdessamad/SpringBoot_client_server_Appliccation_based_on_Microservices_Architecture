package com.example.finalproject.repositories;

import com.example.finalproject.Beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
