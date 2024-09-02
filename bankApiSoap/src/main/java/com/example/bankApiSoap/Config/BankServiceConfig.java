package com.example.bankApiSoap.Config;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.bankApiSoap.Service.BankingService;
import com.example.bankApiSoap.Service.ServiceImpl.BankingServiceImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class BankServiceConfig {

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bankService());
        endpoint.publish("/BankingService");
        return endpoint;
    }

    @Bean
    public BankingService bankService() {
        return new BankingServiceImpl();
    }
}

