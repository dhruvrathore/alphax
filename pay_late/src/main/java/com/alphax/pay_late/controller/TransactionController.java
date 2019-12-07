package com.alphax.pay_late.controller;

import com.alphax.pay_late.api.TransactionDTO;
import com.alphax.pay_late.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public Boolean saveTransaction(@RequestBody @Validated @NotNull TransactionDTO transactionDTO) throws Exception{
        return transactionService.saveTransaction(transactionDTO);
    }

}
