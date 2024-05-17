package com.example.demo.repository;

import com.example.demo.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;





@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCategory(String category);
    List<Transaction> findByDate(Date date);
    List<Transaction> findByCategoryAndDate(String category, Date date);
}