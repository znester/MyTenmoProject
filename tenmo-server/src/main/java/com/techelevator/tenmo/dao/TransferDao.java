package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

    List<Transfer> getTransfer(int userId);
    List<Transfer> getAllTransfer();
    List<Transfer> getPendingTransfer(int userId);
    Transfer getTransferByTransferId(int transferId);

}
