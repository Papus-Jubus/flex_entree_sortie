package com.example.demo.services;



import java.util.Date;
import java.util.List;



import com.example.demo.entities.Transaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public List<Transaction> searchTransactions(String category, Date date) {
        if (category != null && date != null) {
            return transactionRepository.findByCategoryAndDate(category, date);
        } else if (category != null) {
            return transactionRepository.findByCategory(category);
        } else if (date != null) {
            return transactionRepository.findByDate(date);
        } else {
            return getAllTransactions();
        }
    }



}

