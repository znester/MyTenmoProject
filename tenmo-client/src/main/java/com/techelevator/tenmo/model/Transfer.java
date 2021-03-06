package com.techelevator.tenmo.model;



import java.math.BigDecimal;
import java.util.List;

public class Transfer {
    private int transferID;
    private int transferTypeId;
    private int transferStatusId;
    private Account accountFrom;
    private Account accountTo;
    private BigDecimal amount;
    private int accountFromId;
    private int accountToId;
    private User username;
    private String accountFromName;
    private String accountToName;


    public Transfer(int transferID, int transferTypeId, int transferStatusId, Account accountFrom, Account accountTo,
                    BigDecimal amount, int accountFromId, int accountToId, User username, String accountFromName, String accountToName) {
        this.transferID = transferID;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.accountFromId = accountFromId;
        this.accountToId = accountToId;
        this.username = username;
        this.accountFromName = accountFromName;
        this.accountToName = accountToName;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public int getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(int accountFromId) {
        this.accountFromId = accountFromId;
    }

    public int getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(int accountToId) {
        this.accountToId = accountToId;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public String getAccountFromName() {
        return accountFromName;
    }

    public void setAccountFromName(String accountFromName) {
        this.accountFromName = accountFromName;
    }

    public String getAccountToName() {
        return accountToName;
    }

    public void setAccountToName(String accountToName) {
        this.accountToName = accountToName;
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

