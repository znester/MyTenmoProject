package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.*;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
//@RequestMapping("")
//@PreAuthorize("isAuthenticated()")

public class TEnmoController {
    private AccountDao accountDao;
    private UserDao userDao;
    private TransferDao transferDao;

    public TEnmoController(AccountDao Accountdao, UserDao userDao, TransferDao transferDao) {
        this.accountDao = Accountdao;
        this.userDao = userDao;
        this.transferDao = transferDao;
    }

//    @RequestMapping(path = "/accounts" , method = RequestMethod.GET)
//    public List<Account> getAccounts() {
//        return accountDao.getAllAccounts();
//    }

    
    @RequestMapping(path = "/accounts/balance", method = RequestMethod.GET)
    @ResponseBody
    public Account accountBalance(Principal principal) {
        return accountDao.getAccountByUsername(principal.getName());
    }

    @RequestMapping(path = "/accounts/users/transfers", method = RequestMethod.GET)
    @ResponseBody
    public List<Transfer> getTransfersByUsername(Principal principal){
        return transferDao.getTransferByUsername(principal.getName());
    }

}
