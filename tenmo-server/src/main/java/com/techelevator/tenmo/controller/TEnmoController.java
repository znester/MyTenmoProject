package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.*;
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")

public class TEnmoController {
    private final AccountDao accountDao;
    private final UserDao userDao;
    private final TransferDao transferDao;

    public TEnmoController(AccountDao Accountdao, UserDao userDao, TransferDao transferDao) {
        this.accountDao = Accountdao;
        this.userDao = userDao;
        this.transferDao = transferDao;
    }

    //GET CURRENT BALANCE BY PRINCIPAL
    @RequestMapping(path = "/accounts/balance", method = RequestMethod.GET)
    @ResponseBody
    public Account accountBalance(Principal principal) {
        return accountDao.getAccountByUsername(principal.getName());
    }


    //GET TRANSFER HISTORY BY PRINCIPAL USERNAME
    @RequestMapping(path = "/accounts/users/transfers", method = RequestMethod.GET)
    public List<Transfer> getTransfersByUsername(Principal principal) {
        return transferDao.getTransfersByUsername(principal);
    }

    //POST TRANSFER BY PRINCIPAL
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/transfers/makeTransfer", method = RequestMethod.POST)
    public void makeTransfer(@RequestBody Transfer transfer ) throws AccountNotFoundException {
        transferDao.transferToUser(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
    }

    //GET USER BY USERNAME
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/accounts/users/{username}", method = RequestMethod.GET)
    public User user(@PathVariable String username) {
        return userDao.findByUsername(username);
    }

    //GET ALL ACCOUNTS
    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    public List<Account> accounts() {
        return accountDao.getAllAccounts();
    }
}
