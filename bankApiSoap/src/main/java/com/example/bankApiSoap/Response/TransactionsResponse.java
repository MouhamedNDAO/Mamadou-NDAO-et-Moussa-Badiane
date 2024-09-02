package com.example.bankApiSoap.Response;

import java.util.List;

import com.example.bankApiSoap.Request.GetTransactionsRequest;


public class TransactionsResponse {

    private List<GetTransactionsRequest> transactions; // Liste des transactions pour la page actuelle
    private int totalPages; // Total des pages disponibles
    private int currentPage; // Page actuelle demandée

    // Constructeurs, getters et setters

    public TransactionsResponse() {
    }

    public TransactionsResponse(List<GetTransactionsRequest> transactions, int totalPages, int currentPage) {
        this.transactions = transactions;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    public List<GetTransactionsRequest> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<GetTransactionsRequest> transactions) {
        this.transactions = transactions;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "TransactionsResponse{" +
                "transactions=" + transactions +
                ", totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                '}';
    }
}
