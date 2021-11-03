package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferType;

public interface TransferStatusDao {
    TransferType getTransferStatusById(int transferStatusId);
    TransferType getTransferStatusDesc(String transferStatusDesc);
}
