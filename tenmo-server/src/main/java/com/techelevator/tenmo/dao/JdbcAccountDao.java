package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao{


    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public Account getBalance(String user) {
//        Account balance = null;
//        String sql = "SELECT a.balance" +
//                "FROM accounts " +
//                "JOIN users u ON a.user_id = u.user_id " +
//                "WHERE u.username = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user);
//        if (results.next()) {
//            String accountBalance = results.getString("balance");
//            balance.setBalance(new BigDecimal(accountBalance));
//        }
//        return balance;
//    }

    @Override
    public Account getAccountByUserId(int userId) {
        Account account = null;
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        if(results.next()){
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public Account getAccountByAccountId(int accountId) {
        Account account = null;
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if (results.next()){
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, user_id, balance FROM accounts;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Account accountResults = mapRowToAccount(results);
            accounts.add(accountResults);
        }
        return accounts;
    }



    private Account mapRowToAccount(SqlRowSet rowSet) {
        Account account = new Account();
        account.setAccountId(rowSet.getInt("accountId"));
        account.setUserId(rowSet.getInt("user_id"));
        account.setBalance(rowSet.getBigDecimal("balance"));

        return account;
    }

}
