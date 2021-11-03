package com.techelevator.tenmo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
//import org.springframework.security.access.prepost.PreAuthorize;



public class AccountService {

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;
    //private Account dao

    //public jdbc

    public void authToken(String authToken) {this.authToken = authToken;}

    public AccountService(String url) {
        this.baseUrl = url;
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

//    public Account getBalance() {
//    }


}
