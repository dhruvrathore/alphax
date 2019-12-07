package com.alphax.pay_late.api;

import com.alphax.pay_late.common.TransactionMetadata;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {
    @NotNull
    private Long fromUserId;
    @NotNull
    private Long toUserId;
    @NotNull
    private Double money;
    @NotNull
    private Date transactionTimestamp;
    @NotNull
    private String transactionUuid;
    @NotNull
    private String status;
    private TransactionMetadata transactionMetadata;

}
