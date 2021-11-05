package com.techelevator.tenmo.model;

import java.math.BigDecimal;
import java.util.List;

public class Transfer {
    private int transferID;
    private int transferTypeId;
    private int transferStatusId;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;

    public Transfer(int transferID, int transferTypeId, int transferStatusId, int accountFrom, int accountTo, BigDecimal amount) {
        this.transferID = transferID;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public Transfer() {
    }

    public int getTransferID() {
        return transferID;
    }

    public void setTransferID(int transferID) {
        this.transferID = transferID;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public int getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public int getAccount_from() {
        return accountFrom;
    }

    public void setAccount_from(int account_from) {
        this.accountFrom = account_from;
    }

    public int getAccount_to() {
        return accountTo;
    }

    public void setAccount_to(int account_to) {
        this.accountTo = account_to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferID=" + transferID +
                ", transferTypeId=" + transferTypeId +
                ", transferStatusId=" + transferStatusId +
                ", account_from=" + accountFrom +
                ", account_to=" + accountTo +
                ", amount=" + amount +
                '}';
    }
}

