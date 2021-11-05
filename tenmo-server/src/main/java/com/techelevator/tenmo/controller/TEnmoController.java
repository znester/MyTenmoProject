package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.*;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
//@RequestMapping("")
//@PreAuthorize("isAuthenticated()")

public class TEnmoController {
    private final AccountDao accountDao;
    private final UserDao userDao;
    private final TransferDao transferDao;

    public TEnmoController(AccountDao Accountdao, UserDao userDao, TransferDao transferDao) {
        this.accountDao = Accountdao;
        this.userDao = userDao;
        this.transferDao = transferDao;
    }

    //USE CASE #3 - AUTHENTICATED USER ABLE TO SEE ACCOUNT BALANCE
    @RequestMapping(path = "/accounts/balance", method = RequestMethod.GET)
    @ResponseBody
    public Account accountBalance(Principal principal) {
        return accountDao.getAccountByUsername(principal.getName());
    }

    //USE CASE #4 - AUTHENTICATED USER ABLE TO SEND TRANSFER TO ANOTHER REGISTERED USER
    @RequestMapping(path = "/accounts/transfers/{account_from}/{account_to}/{amount}", method = RequestMethod.PUT)
    public void transferToUser(@RequestBody Transfer transfer, @PathVariable int account_from,
                               @PathVariable int account_to, @PathVariable BigDecimal amount) {
        transferDao.requestTransfer(account_from, account_to, amount);
    }

    //USE CASE #5 - AUTHENTICATED USER ABLE TO SEE TRANSFER HISTORY
    @RequestMapping(path = "/accounts/users/transfers", method = RequestMethod.GET)
    @ResponseBody
    public List<Transfer> getTransfersByUsername(Principal principal){
        return transferDao.getTransfersByUsername(principal.getName());
    }



    //THIS IS JUST FOR TESTING PURPOSES
    @RequestMapping(path = "/accounts/users/{username}", method = RequestMethod.GET)
    public User user(@PathVariable String username) {
        return userDao.findByUsername(username);
    }

    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    public List<Account> accounts() {
        return accountDao.getAllAccounts();
    }
}
