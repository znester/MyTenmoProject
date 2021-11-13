package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.exception.TransferNotFoundException;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface TransferDao {

    List<Transfer> getTransfersByUsername(Principal principal);

    Transfer getTransferByTransferId(int transferId) throws TransferNotFoundException;

    void transferToUser(Account fromAccount, Account toAccount, BigDecimal amount) throws AccountNotFoundException;

    Transfer requestTransfer(int userFromId, int userToId, BigDecimal amount);

    List<Transfer> getPendingTransfersByUserId(int userId);

    List<Transfer> getTransfersByUserId(int userId);


}
