package com.example.BTH1_2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.BTH1_2.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	  Optional<User> findByUsername(String username);
}
