package com.alphax.pay_late.encryption;

import com.alphax.pay_late.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j @Service public class DecryptServiceImpl {

    @Autowired private ObjectMapper objectMapper;

    public Transaction decryptTransaction(String transactionInfo)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException, JsonProcessingException
    {

        String key = "PAY_LATE_LATE_PAY"; // 128 bit key
        // Create key and cipher
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        // now convert the string to byte array
        // for decryption
        byte[] bb = new byte[transactionInfo.length()];
        for (int i = 0; i < transactionInfo.length(); i++) {
            bb[i] = (byte) transactionInfo.charAt(i);
        }

        // decrypt the text
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(bb));
        try{
            return objectMapper.readValue(decrypted, new TypeReference<Transaction>() {
            });
        }catch (Exception e){
            return null;
        }

    }
}
