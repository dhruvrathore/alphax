package com.alphax.pay_late.service;

import com.alphax.pay_late.api.TransactionDTO;
import com.alphax.pay_late.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    private Boolean saveTransaction(TransactionDTO transactionDTO){
        return true;
    }
}
