package com.rest.service;

import com.rest.model.Transaction;

public interface TransactionService {
	public Transaction getTransactionById(long transactionId);
	public Transaction createTransaction(Transaction transaction);
}