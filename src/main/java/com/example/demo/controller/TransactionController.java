package com.example.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TransferResult;
import com.example.demo.exception.AccountNotExistException;
import com.example.demo.exception.OverDraftException;
import com.example.demo.model.Transaction;
import com.example.demo.service.TransferService;


@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {
	
	private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private TransferService accountService;

	@PostMapping(consumes = { "application/json" })
	public ResponseEntity transferMoney(@RequestBody @Valid Transaction request) throws Exception {

		try {
			accountService.transferBalances(request);
			TransferResult result = new TransferResult();
			result.setAccountFromId(request.getAccountFromId());
			result.setBalanceAfterTransfer(accountService.retrieveBalances(request.getAccountFromId()).getBalance());
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		} catch (AccountNotExistException | OverDraftException e) {
			log.error("Fail to transfer balances, please check with system administrator.");
			throw e;
		}
	}
}
