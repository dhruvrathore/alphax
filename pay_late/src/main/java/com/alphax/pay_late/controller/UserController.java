package com.alphax.pay_late.controller;

import com.alphax.pay_late.api.UserDTO;
import com.alphax.pay_late.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/cred_score")
    public Double getUsersCredScore(@NotNull @RequestParam(value = "user_id") Long userId){
        return userService.getUserCredScore(userId);
    }

    @GetMapping("/wallet_balance")
    public Double getWalledBalance(@NotNull @RequestParam(value = "user_id") Long userId){
        return userService.getWalletBalance(userId);
    }


    @GetMapping("/user_info")
    public UserDTO getUserInfo(@NotNull @RequestParam(value = "user_id") Long userId){
        return userService.getUserinfo(userId);
    }
}
