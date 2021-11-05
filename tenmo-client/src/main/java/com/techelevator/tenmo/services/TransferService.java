package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class TransferService {

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser currentUser;

    public TransferService(String baseUrl, AuthenticatedUser currentUser) {
        this.baseUrl = baseUrl;
        this.currentUser = currentUser;
    }
    public TransferService(){}

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(headers);
    }
    public Transfer[] getTransfersByUsername(){
        Transfer[] transfers = null;
        try {
            ResponseEntity<Transfer[]> response = restTemplate.exchange(baseUrl + "accounts/user/transfers", HttpMethod.GET,
                    makeAuthEntity(), Transfer[].class);
            transfers = response.getBody();
        } catch(RestClientResponseException | ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return transfers;

        //pass in transfer into http entity
        //param = transfer
        //use exchange for transfer method
        //one method for request one for make transfer
    }

    public void makeTransfer(Transfer transfer){
        HttpEntity<Transfer> postEntity = new HttpEntity<>(transfer, makeAuthEntity().getHeaders());
        restTemplate.exchange(baseUrl + "/transfers/makeTransfer", HttpMethod.POST, postEntity, Transfer.class);
    }
}
