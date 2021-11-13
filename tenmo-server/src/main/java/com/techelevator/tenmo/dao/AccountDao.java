package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.model.Account;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.List;

@Component
public interface AccountDao {

    Account getAccountByUsername(String username);

    Account getAccountByAccountId(int accountId) throws AccountNotFoundException;

    List<Account> getAllAccounts();

    void withdraw(BigDecimal amount, Account account) throws AccountNotFoundException;

    void deposit(BigDecimal amount, Account account) throws AccountNotFoundException;

}
