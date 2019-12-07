package com.alphax.pay_late.entity;

import com.alphax.pay_late.common.TransactionMetadata;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@Slf4j
public class Transaction {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "from_user_id")
    private Long fromUserId;

    @Column(name = "to_user_id")
    private Long toUserId;

    @Column(name = "money")
    private Double money;

    @Column(name = "metadata",columnDefinition = "json")
    private String metadata;

    private TransactionMetadata transactionMetadata;
    private ObjectMapper objectMapper;

    @JsonIgnore
    public void setMetadataObject(TransactionMetadata transactionMetadata){
        if(transactionMetadata!=null) {
            try{
                this.metadata  = objectMapper.writeValueAsString(transactionMetadata);
            }catch (JsonProcessingException ex){
                log.error("Error in Serializing to json {}", transactionMetadata);
                throw new RuntimeException(ex);
            }
        }

    }

    @JsonIgnore
    public TransactionMetadata getMetadataObject(){
        if(transactionMetadata!=null) {
            return transactionMetadata;
        } else {
            try{
                this.transactionMetadata = objectMapper.readValue(metadata, TransactionMetadata.class);
                return transactionMetadata;
            }catch (JsonProcessingException ex) {
                log.error("Error in deSerializing to json {}", transactionMetadata);
                throw new RuntimeException(ex);
            }
        }
    }
}
