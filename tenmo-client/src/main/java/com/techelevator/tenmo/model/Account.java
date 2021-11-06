package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {
    private int accountId;
    private int userId;
    private String username;
    private BigDecimal balance;
    private int accountFrom;
    private int accountTo;

    public Account(int accountId, int userId, BigDecimal balance, String username, int accountFrom, int accountTo) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
        this.username = username;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", accountFrom=" + accountFrom +
                ", accountTo=" + accountTo +
                '}';
    }
}
