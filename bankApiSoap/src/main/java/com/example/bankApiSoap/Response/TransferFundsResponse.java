package com.example.bankApiSoap.Response;

public class TransferFundsResponse {

    private String status; // Status de la transaction (e.g., "Success" ou "Failure")
    private String transactionId; // ID de la transaction

    // Constructeurs, getters et setters

    public TransferFundsResponse() {
    }

    public TransferFundsResponse(String status, String transactionId) {
        this.status = status;
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "TransferFundsResponse{" +
                "status='" + status + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}

