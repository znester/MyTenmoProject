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
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("")
//@PreAuthorize("isAuthenticated")

public class TEnmoController {
    private AccountDao accountDao;
    private UserDao userDao;

    public TEnmoController(AccountDao dao) {
        this.accountDao = dao;
    }

 //   @PreAuthorize("permitAll")
    @RequestMapping(path = "/accounts/" , method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountDao.getAllAccounts();
    }

    @RequestMapping(path = "accounts/balance", method = RequestMethod.GET)
    public BigDecimal accountBalance(Principal principal) {
        String principalName = principal.getName();

        int userId = userDao.findByUsername(principalName).getId();

        return accountDao.getAccountByUserId(userId).getBalance();

    }

}
