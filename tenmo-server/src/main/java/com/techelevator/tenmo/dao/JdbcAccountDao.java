package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountByUsername(String username) {
        Account account = null;
        String sql = "SELECT accounts.account_id, accounts.user_id, accounts.balance FROM accounts " +
                "JOIN users ON users.user_id = accounts.user_id " +
                "WHERE users.username = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        if (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public Account getAccountByAccountId(int accountId) {
        Account account = null;
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, accounts.user_id, balance, username FROM accounts " +
                "JOIN users ON accounts.user_id = users.user_id ; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Account account = mapRowToAccount(results);
            account.setUsername(results.getString("username"));
            accounts.add(account);

        }
        return accounts;
    }

    @Override
    public void deposit(BigDecimal amount, int account) {
        String sql = "UPDATE accounts " +
                "SET balance = balance + ? " +
                "WHERE account_id = ?; ";
        jdbcTemplate.update(sql, amount, account);
    }

    @Override
    public void withdraw(BigDecimal amount, int account) {
        String sql = "UPDATE accounts " +
                "SET balance = balance - ? " +
                "WHERE account_id = ?; ";
        jdbcTemplate.update(sql, amount, account);
    }


    private Account mapRowToAccount(SqlRowSet rowSet) {
        Account account = new Account();
        account.setAccountId(rowSet.getInt("account_id"));
        account.setUserId(rowSet.getInt("user_id"));
        account.setBalance(rowSet.getBigDecimal("balance"));

        return account;
    }

}
