package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Transaction;
import com.rest.service.TransactionService;

@RestController
@RequestMapping("transactionservice")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@RequestMapping(value="/transaction/{transactionId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Transaction getTransaction(@PathVariable("transactionId") long transactionId) {
		return transactionService.getTransactionById(transactionId);
	}
	
	@RequestMapping(value="/createtransaction", method = RequestMethod.POST)
	@ResponseBody
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return transactionService.createTransaction(transaction);
	}
}
