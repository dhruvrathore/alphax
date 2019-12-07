package com.alphax.pay_late.entity;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Column(name = "from_user_id")
    private Long fromUserId;
    @Column(name = "to_user_id")
    private Long toUserId;
    @Column(name = "money")
    private Double money;
    @Column(name = "metadata")
    private String metadata;
}
