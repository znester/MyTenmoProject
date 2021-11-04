package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

    List<Transfer> getTransferByUsername(String username);

    Transfer getTransferByTransferId(int transferId);

}
