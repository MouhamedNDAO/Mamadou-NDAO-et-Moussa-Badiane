package com.example.bankApiSoap.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.bankApiSoap.Request.GetBalanceRequest;
import com.example.bankApiSoap.Request.GetTransactionsRequest;
import com.example.bankApiSoap.Request.TransferFundsRequest;
import com.example.bankApiSoap.Response.BalanceResponse;
import com.example.bankApiSoap.Response.TransactionsResponse;
import com.example.bankApiSoap.Response.TransferFundsResponse;

@WebService(targetNamespace = "http://example.com/banking")
public interface BankingService {

    @WebMethod
    BalanceResponse getBalance(GetBalanceRequest request);

    @WebMethod
    TransactionsResponse getTransactions(GetTransactionsRequest request);

    @WebMethod
    TransferFundsResponse transferFunds(TransferFundsRequest request);
}
