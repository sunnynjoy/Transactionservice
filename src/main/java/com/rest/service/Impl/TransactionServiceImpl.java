package com.rest.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.EntityNotFoundException;
import com.rest.model.Transaction;
import com.rest.repository.TransactionRepository;
import com.rest.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction getTransactionById(long transactionId) {
		try {
			return transactionRepository.getTransactionById(transactionId);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.createTransaction(transaction);
	}
}
