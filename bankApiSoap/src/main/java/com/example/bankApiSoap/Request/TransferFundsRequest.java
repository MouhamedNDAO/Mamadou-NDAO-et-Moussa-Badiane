package com.example.bankApiSoap.Request;

import java.math.BigDecimal;

public class TransferFundsRequest {

    private String creditor; // ID ou nom du bénéficiaire
    private String debtor; // ID ou nom du débiteur
    private BigDecimal amount; // Montant du virement
    private String currency; // Devise du virement

    // Constructeurs, getters et setters

    public TransferFundsRequest() {
    }

    public TransferFundsRequest(String creditor, String debtor, BigDecimal amount, String currency) {
        this.creditor = creditor;
        this.debtor = debtor;
        this.amount = amount;
        this.currency = currency;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
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

    @Override
    public String toString() {
        return "TransferFundsRequest{" +
                "creditor='" + creditor + '\'' +
                ", debtor='" + debtor + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}

