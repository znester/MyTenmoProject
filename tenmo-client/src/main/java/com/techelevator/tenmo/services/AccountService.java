package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import io.cucumber.java.en_old.Ac;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountService {

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser currentUser;


    public AccountService(String url, AuthenticatedUser currentUser) {
        this.baseUrl = url;
        this.currentUser = currentUser;
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(headers);
    }

    public Account getBalance() {
        Account account = null;
        account = restTemplate.exchange(baseUrl + "/accounts/balance", HttpMethod.GET,
                makeAuthEntity(), Account.class).getBody();
        System.out.println("Your account balance is : $" + account.getBalance());

        return account;
    }

    public List<Account> allAccounts(){
        Account[] allAccounts = restTemplate.exchange(baseUrl + "/accounts", HttpMethod.GET, makeAuthEntity(),
                Account[].class).getBody();
        return Arrays.asList(allAccounts);
    }
}
