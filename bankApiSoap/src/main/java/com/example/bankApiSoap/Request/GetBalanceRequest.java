package com.example.bankApiSoap.Request;

import java.math.BigDecimal;

public class GetBalanceRequest {
private BigDecimal balance;

    // Constructeurs, getters et setters

    public GetBalanceRequest() {
    }

    public GetBalanceRequest(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
                "balance=" + balance +
                '}';
    }
}
