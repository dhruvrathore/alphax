package com.alphax.pay_late.repository;

import com.alphax.pay_late.entity.Transaction;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    public List<Transaction> getAllByFromUserId(Long userId);
}
