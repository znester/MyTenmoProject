package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferType;

public interface TransferTypeDao {
    TransferType getTransferTypeById(int transferTypeId);
    TransferType getTransfer_type_desc(String transfer_type_desc);
}
