package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Balance;

import javax.security.auth.login.AccountException;
import java.math.BigDecimal;

public interface AccountDao {

    Balance getBalance(String user);
    Account getAccountByUserId(int userId);
    Account getAccountByAccountId(int accountId);

}
