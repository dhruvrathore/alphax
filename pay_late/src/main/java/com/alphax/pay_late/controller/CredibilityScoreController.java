package com.alphax.pay_late.controller;

import com.alphax.pay_late.api.GetCredibilityScoreRequest;
import com.alphax.pay_late.service.CredibilityScoreServiceImpl;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @Validated @RequestMapping("/api/v1/credibility") public class CredibilityScoreController {

    @Autowired private CredibilityScoreServiceImpl credibilityScoreService;

    @PostMapping("/score") public Double saveTransaction(
            @RequestBody @Validated @NotNull GetCredibilityScoreRequest getCredibilityScoreRequest)
    {
        return credibilityScoreService.getCredibilityScore(getCredibilityScoreRequest);
    }
}
