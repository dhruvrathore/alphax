package com.alphax.pay_late.constants;

import lombok.Getter;

public enum TransactionStatus {
    SUCCESS("ACTUAL"), FAILURE("POTENTIAL");

    @Getter private final String name;

    TransactionStatus(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public static TransactionStatus fromName(String name) {
        for (TransactionStatus transactionStatus : TransactionStatus.values()) {
            if (transactionStatus.getName().equals(name)) {
                return transactionStatus;
            }
        }
        return null;
    }
}
