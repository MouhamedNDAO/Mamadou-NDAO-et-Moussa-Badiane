package com.example.bankApiSoap.Response;
import java.math.BigDecimal;

public class BalanceResponse {

    private BigDecimal balance;

    // Constructeurs, getters et setters

    public BalanceResponse() {
    }

    public BalanceResponse(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
                "balance=" + balance +
                '}';
    }
}

