package com.alphax.pay_late.service;

import com.alphax.pay_late.api.UserDTO;
import com.alphax.pay_late.entity.User;
import com.alphax.pay_late.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Double getUserCredScore(Long userId){
        User user = userRepository.getOne(userId);
        return user.getCredScore();
    }

    public Boolean updateWalletBalance(Long userId, Double amount) {
        User user = userRepository.getOne(userId);
        if(amount<0.0 && amount+user.getWalletBalance() < 0.0) {
            return false;
        }
        user.setWalletBalance(user.getWalletBalance() + amount);
        return true;
    }

    public Double getWalletBalance(Long userId){
        User user = userRepository.getOne(userId);
        return user.getWalletBalance();
    }

    public UserDTO getUserinfo(Long userId){
        User user = userRepository.getOne(userId);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setCredScore(user.getCredScore());
        userDTO.setName(user.getName());
        userDTO.setType(user.getType());
        userDTO.setWalletBalance(user.getWalletBalance());
        userDTO.setSuccessfulTransactions(user.getSuccessfulTransaction());
        return userDTO;
    }
}
