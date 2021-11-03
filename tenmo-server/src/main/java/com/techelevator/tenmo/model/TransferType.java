package com.techelevator.tenmo.model;

public class TransferType {
    private int transferTypeID;
    private String transfer_type_desc;

    public TransferType(int transferTypeID, String transfer_type_desc) {
        this.transferTypeID = transferTypeID;
        this.transfer_type_desc = transfer_type_desc;
    }

    public int getTransferTypeID() {
        return transferTypeID;
    }

    public void setTransferTypeID(int transferTypeID) {
        this.transferTypeID = transferTypeID;
    }

    public String getTransfer_type_desc() {
        return transfer_type_desc;
    }

    public void setTransfer_type_desc(String transfer_type_desc) {
        this.transfer_type_desc = transfer_type_desc;
    }
}
