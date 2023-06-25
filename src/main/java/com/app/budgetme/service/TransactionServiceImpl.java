package com.app.budgetme.service;

import com.app.budgetme.dao.TransactionRepository;
import com.app.budgetme.entity.transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository theTransactionRepository){
        transactionRepository=theTransactionRepository;
    }

    @Override
    public List<transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public transaction findById(int theId) {
        Optional<transaction> result = transactionRepository.findById(theId);

        transaction theTransaction = null;

        if(result.isPresent()){
            theTransaction = result.get();
        }
        else {
            // we didn't find the transaction
            throw new RuntimeException("Did not find transaction id - " + theId);
        }

        return theTransaction;
    }

    @Override
    public void save(transaction theTransaction) {
        transactionRepository.save(theTransaction);
    }

    @Override
    public void deleteById(int theId) {
        transactionRepository.deleteById(theId);
    }
}
