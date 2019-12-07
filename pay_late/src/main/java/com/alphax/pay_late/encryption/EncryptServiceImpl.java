package com.alphax.pay_late.encryption;

import com.alphax.pay_late.entity.Transaction;
import com.alphax.pay_late.model.ObjectToEncrypt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j @Service public class EncryptServiceImpl {

    @Autowired private ObjectMapper objectMapper;
    @Autowired private ObjectToEncryptService objectToEncryptService;

    public String encryptObject(Transaction transactionInfo) throws JsonProcessingException {
        ObjectToEncrypt objectToEncrypt = objectToEncryptService.getObjectToEncryptService(transactionInfo);
        String stringToEncrypt = objectMapper.writeValueAsString(objectToEncrypt);
        StringBuilder sb = new StringBuilder();
        try {
            String key = "PAY_LATE_LATE_PAY"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(stringToEncrypt.getBytes());

            for (byte b : encrypted) {
                sb.append((char) b);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

}
