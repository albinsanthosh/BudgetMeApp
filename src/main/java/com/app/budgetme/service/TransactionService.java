package com.app.budgetme.service;

import com.app.budgetme.entity.transaction;

import java.util.List;

public interface TransactionService{

    List<transaction> findAll();

    transaction findById(int theId);

    void save(transaction theTransaction);

    void deleteById(int theId);
}
