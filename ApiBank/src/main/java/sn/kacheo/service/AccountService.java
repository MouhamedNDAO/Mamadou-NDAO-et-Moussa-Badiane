package sn.kacheo.service;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sn.kacheo.model.Transaction;

public interface AccountService {

	BigDecimal getBalance(Long accountId);
    Page<Transaction> getTransactions(Long accountId, Pageable pageable);
    void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
