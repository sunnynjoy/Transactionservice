package com.rest.repositoryImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.rest.exception.EntityNotFoundException;
import com.rest.model.Transaction;
import com.rest.repository.TransactionRepository;

@Service
public class TransactionRepositoryImpl implements TransactionRepository {

	private Map<String, Transaction> inMemoryTransactionRepository = new ConcurrentHashMap<>();

	 @Override
	    public Transaction getTransactionById(long transactionId) throws EntityNotFoundException {
	        final Transaction transaction = inMemoryTransactionRepository.get(inMemoryTransactionRepository);
	        if (null == transaction) {
	            throw new EntityNotFoundException("Cant find Transaction " + inMemoryTransactionRepository);
	        }
	        return transaction;
	    }

	@Override
	public Transaction createTransaction(Transaction transaction) {
		inMemoryTransactionRepository.put("1", transaction);
		return transaction;
	}
}
