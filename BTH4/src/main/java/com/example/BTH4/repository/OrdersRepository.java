package com.example.BTH4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BTH4.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
