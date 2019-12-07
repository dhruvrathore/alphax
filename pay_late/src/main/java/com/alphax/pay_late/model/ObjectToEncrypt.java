package com.alphax.pay_late.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor public class ObjectToEncrypt {

    private String userId;
    private String userIdentificationKey;
    private Double amount;
    private Date time;
    private String vendorId;
}
