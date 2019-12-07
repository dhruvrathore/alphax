package com.alphax.pay_late.encryption;

import com.alphax.pay_late.entity.Transaction;
import com.alphax.pay_late.model.ObjectToEncrypt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j @Data @AllArgsConstructor
@Service
public class ObjectToEncryptService {

    public ObjectToEncrypt getObjectToEncryptService(Transaction transaction)
    {

        return new ObjectToEncrypt(transaction.getFromUserId().toString(),
                transaction.getTransactionMetadata().getImei(), transaction.getMoney(),
                transaction.getTransactionTimestamp(), transaction.getToUserId().toString());
    }
}

