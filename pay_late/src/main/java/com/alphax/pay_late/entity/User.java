package com.alphax.pay_late.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
@Slf4j
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "cred_score")
    private Double credScore;

    @Column(name = "walled_balance")
    private Double walletBalance;

    @Column(name = "successful_transaction")
    private Long successfulTransaction;

}
