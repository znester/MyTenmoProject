package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface TransferDao {

    List<Transfer> getTransfersByUsername(Principal principal);

    Transfer getTransferByTransferId(int transferId);

    //void createTransfer(Transfer transfer, Principal principal);
    void transferToUser(Account fromAccount, Account toAccount, BigDecimal amount);

    //public List<Transfer> getAllTransfers();

    //Extras
    Transfer requestTransfer(int userFromId, int userToId, BigDecimal amount);

    List<Transfer> getPendingTransfersByUserId(int userId);

    List<Transfer> getTransfersByUserId(int userId);


}
