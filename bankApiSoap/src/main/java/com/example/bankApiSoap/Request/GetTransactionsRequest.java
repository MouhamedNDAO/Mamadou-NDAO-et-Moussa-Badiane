package com.example.bankApiSoap.Request;

import java.math.BigDecimal;

public class GetTransactionsRequest {
    
    private String transactionId;
    private String description;
    private BigDecimal amount;
    private String currency;
    private String date;

    // Constructeurs, getters et setters

    public GetTransactionsRequest() {
    }

    public GetTransactionsRequest(String transactionId, String description, BigDecimal amount, String currency, String date) {
        this.transactionId = transactionId;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

