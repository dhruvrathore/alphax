package com.alphax.pay_late.service;

import com.alphax.pay_late.api.TransactionDTO;
import com.alphax.pay_late.entity.Transaction;
import com.alphax.pay_late.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Boolean saveTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setCreatedOn(new Date());
        transaction.setFromUserId(transactionDTO.getFromUserId());
        transaction.setToUserId(transactionDTO.getToUserId());
        transaction.setMoney(transactionDTO.getMoney());
        transaction.setTransactionTimestamp(transactionDTO.getTransactionTimestamp());
        transaction.setTransactionUUid(transactionDTO.getTransactionUUid());
        transaction.setMetadataObject(transactionDTO.getTransactionMetadata());
        transaction.setStatus(transactionDTO.getStatus());
        transactionRepository.save(transaction);
        return true;
    }
}
