package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.*;
import com.techelevator.tenmo.model.Account;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("http://localhost:8080/")
@PreAuthorize("isAuthenticated")

public class TEnmoController {
    private AccountDao accountDao;
    private TransferDao transferDao;
    private TransferStatusDao transferStatusDao;
    private TransferTypeDao transferTypeDao;
    private UserDao userDao;

    public TEnmoController(AccountDao dao) {
        this.accountDao = dao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "accounts" , method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountDao.getAllAccounts();
    }
}
