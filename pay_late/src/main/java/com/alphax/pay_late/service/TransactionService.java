package com.alphax.pay_late.service;

import com.alphax.pay_late.api.TransactionDTO;
import com.alphax.pay_late.constants.TransactionStatus;
import com.alphax.pay_late.entity.Transaction;
import com.alphax.pay_late.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public Boolean saveTransaction(TransactionDTO transactionDTO) throws Exception{

        Transaction transaction = transactionRepository.getByTransactionUUid(transactionDTO.getTransactionUuid());
        if(transaction!=null) {
            return true;
        }
        transaction = new Transaction();
        transaction.setCreatedOn(new Date());
        transaction.setFromUserId(transactionDTO.getFromUserId());
        transaction.setToUserId(transactionDTO.getToUserId());
        transaction.setMoney(transactionDTO.getMoney());
        transaction.setTransactionTimestamp(transactionDTO.getTransactionTimestamp());
        transaction.setTransactionUUid(transactionDTO.getTransactionUuid());
        transaction.setMetadataObject(transactionDTO.getTransactionMetadata());
        transaction.setStatus(TransactionStatus.SUCCESS);
        transactionRepository.save(transaction);
        Boolean isDeductionSuccessful = userService.updateWalletBalance(transactionDTO.getFromUserId(), -transaction.getMoney());
        Boolean isAdditionSuccessful = userService.updateWalletBalance(transactionDTO.getToUserId(), transaction.getMoney());
        if(!isDeductionSuccessful || !isAdditionSuccessful) {
            throw new Exception("Insufficient Balance");
        }
        return true;
    }
}
