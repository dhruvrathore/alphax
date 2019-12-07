package com.alphax.pay_late.common;

import lombok.Data;

@Data
public class TransactionMetadata {
    private String imei;
    private String imsi;
    private String line1;
}
