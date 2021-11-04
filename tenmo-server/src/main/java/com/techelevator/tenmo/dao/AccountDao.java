package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface AccountDao {

    //Account getBalance(String user);

    Account getAccountByUsername(String username);
    Account getAccountByAccountId(int accountId);

    List<Account> getAllAccounts();

}
