package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {

    List<Transfer> getTransfersByUsername(String username);

    Transfer getTransferByTransferId(int transferId);

    Transfer transferToUser(int userFromId, int userToId, BigDecimal amount);

    //Extras
    Transfer requestTransfer(int userFromId, int userToId, BigDecimal amount);

    List<Transfer> getPendingTransfersByUserId(int userId);


}
