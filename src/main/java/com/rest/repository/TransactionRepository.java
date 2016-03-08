package com.rest.repository;

import com.rest.exception.EntityNotFoundException;
import com.rest.model.Transaction;

public interface TransactionRepository {
	Transaction getTransactionById(long transactionId) throws EntityNotFoundException;
	Transaction createTransaction(Transaction transaction);
}