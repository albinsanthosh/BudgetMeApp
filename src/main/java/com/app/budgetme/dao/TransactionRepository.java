package com.app.budgetme.dao;

import com.app.budgetme.entity.transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<transaction, Integer> {
}
