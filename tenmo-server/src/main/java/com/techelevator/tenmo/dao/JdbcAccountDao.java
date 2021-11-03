package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;

public class JdbcAccountDao implements AccountDao{


    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal getBalance(String user) {
        Account balance = null;
        String sql = "SELECT a.balance" +
                "FROM accounts " +
                "JOIN users u ON a.user_id = u.user_id " +
                "WHERE u.username = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user);
        Account balance = new BigDecimal()
        if (results.next()) {
            balance = mapRowToAccount(results);
        }
        return balance;
    }

    @Override
    public Account getAccountByUserId(int userId) {
        return null;
    }

    @Override
    public Account getAccountByAccountId(int accountId) {
        return null;
    }

//    private Account mapRowToAccount(SqlRowSet results) {
//        Account account = new Account();
//        account.setAccountId(results.getInt("account_id"));
//        account.setUserId(results.getInt("user_id"));
//        account.setBalance(results.getBigDecimal("balance"));
//        return account;
//    }

}
