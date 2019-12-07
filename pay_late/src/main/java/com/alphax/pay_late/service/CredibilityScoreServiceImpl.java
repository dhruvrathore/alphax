package com.alphax.pay_late.service;

import com.alphax.pay_late.api.GetCredibilityScoreRequest;
import com.alphax.pay_late.constants.TransactionStatus;
import com.alphax.pay_late.entity.Transaction;
import com.alphax.pay_late.repository.TransactionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service public class CredibilityScoreServiceImpl {
    @Autowired TransactionRepository transactionRepository;

    public Double getCredibilityScore(GetCredibilityScoreRequest getCredibilityScoreRequest) {
        List<Transaction> transactionHistory = transactionRepository.getAllByFromUserId(getCredibilityScoreRequest.getUserId());
        List<Transaction> successfulTransactionHistory = transactionHistory.stream()
                .filter(x -> TransactionStatus.SUCCESS.equals(x.getStatus())).collect(Collectors.toList());
        List<Transaction> unsuccessfulTransactionHistory = transactionHistory.stream()
                .filter(x -> TransactionStatus.FAILURE.equals(x.getStatus())).collect(Collectors.toList());
        Double creditScore = 0.0;
        creditScore += getSuccessfulTransactionScore(successfulTransactionHistory);
        creditScore += getUnsuccessfulTransactionScore(unsuccessfulTransactionHistory);
        return Math.max(creditScore, 1.0);
    }

    public Double getSuccessfulTransactionScore(List<Transaction> transactionList) {

        if (transactionList.size() >= 5) {
            return 5.0;
        }
        else if (transactionList.size() == 4) {
            return 4.0;
        }
        else if (transactionList.size() == 3) {
            return 3.0;
        }
        else if (transactionList.size() == 2) {
            return 2.0;
        }
        else {
            return 1.0;
        }
    }

    public Double getUnsuccessfulTransactionScore(List<Transaction> transactionList) {

        if (transactionList.size() >= 5) {
            return -2.0;
        }
        else {
            return -1.0;
        }

    }
}
