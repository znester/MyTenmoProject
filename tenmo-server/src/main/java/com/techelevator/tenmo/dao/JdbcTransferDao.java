package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcTransferDao implements TransferDao {

    private final JdbcTemplate jdbcTemplate;
    private final AccountDao accountDao;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate, AccountDao accountDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.accountDao = accountDao;
    }
    @Override
    public List<Transfer> getTransfersByUsername(Principal principal) {
        List <Transfer> transfers = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfers " +
                "WHERE account_from = " +
                "(SELECT account_id FROM accounts a " +
                "INNER JOIN users u " +
                "ON u.user_id = a.user_id " +
                "WHERE username = ?);";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal.getName());
        while(results.next()){
            Transfer transferResults = mapRowToTransfer(results);
            transfers.add(transferResults);
        }

        String sql2 = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfers " +
                "WHERE account_to = " +
                "(SELECT account_id FROM accounts a " +
                "INNER JOIN users u " +
                "ON u.user_id = a.user_id " +
                "WHERE username = ?);";
        SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, principal.getName());
        while(results2.next()){
            Transfer transferResults = mapRowToTransfer(results2);
            transfers.add(transferResults);
        }
        return transfers;
    }

    @Override
    public Transfer getTransferByTransferId(int transferId) {
        Transfer transfer = null;
        String sql = "SELECT t.transfer_id, t.transfer_type_id, t.transfer_status_id, t.account_from, t.account_to, t.amount \n" +
                "FROM transfers t " +
                "JOIN accounts a ON t.account_to = a. account_id " +
                "JOIN users u ON a.user_id = u.user_id " +
                "WHERE transfer_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
        if(results.next()){
            transfer = mapRowToTransfer(results);
        }
        return transfer;
    }



    @Override
    public void transferToUser(Account fromAccount, Account toAccount, BigDecimal amount) throws AccountNotFoundException {
        String sql = "INSERT INTO transfers (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "Values (2, 2, ?, ?, ?);";
        jdbcTemplate.update(sql, fromAccount.getAccountId(), toAccount.getAccountId(), amount);
        accountDao.withdraw(amount, toAccount);
        accountDao.deposit(amount, fromAccount);
    }

    //Extras
    @Override
    public Transfer requestTransfer(int userFromId, int userToId, BigDecimal amount) {
        return null;
    }

    @Override
    public List<Transfer> getPendingTransfersByUserId(int userId) {
        return null;
    }

    @Override
    public List<Transfer> getTransfersByUserId(int userId) {
        List <Transfer> transfers = new ArrayList<>();
        String sql = "SELECT t.transfer_id, t.transfer_type_id, t.transfer_status_id, t.account_from, t.account_to, t.amount " +
                "FROM transfers t " +
                "JOIN accounts a ON t.account_to = a. account_id " +
                "JOIN users u ON a.user_id = u.user_id " +
                "WHERE u.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if(results.next()){
            Transfer transferResults = mapRowToTransfer(results);
            transfers.add(transferResults);
        }
        return transfers;
    }

    private Transfer mapRowToTransfer(SqlRowSet rowSet) {
        Transfer transfer = new Transfer();
        transfer.setTransferID(rowSet.getInt("transfer_id"));
        transfer.setTransferTypeId(rowSet.getInt("transfer_type_id"));
        transfer.setTransferStatusId(rowSet.getInt("transfer_status_id"));
        transfer.setAccountFromId(rowSet.getInt("account_from"));
        transfer.setAccountToId(rowSet.getInt("account_to"));
        transfer.setAmount(rowSet.getBigDecimal("amount"));
        return transfer;
    }
    private Transfer mapRowCreateTransfer(SqlRowSet rowSet) {
        Transfer transfer = new Transfer();
        transfer.setTransferID(rowSet.getInt("transfer_id"));
        transfer.setTransferTypeId(rowSet.getInt("transfer_type_id"));
        transfer.setTransferStatusId(rowSet.getInt("transfer_status_id"));
        transfer.setAccountFromId(rowSet.getInt("account_from"));
        transfer.setAccountToId(rowSet.getInt("account_to"));
        transfer.setAmount(rowSet.getBigDecimal("amount"));
        transfer.setAccountToUsername(rowSet.getString("username"));
        transfer.setAccountFromUsername(rowSet.getString("username"));
        transfer.setAccountTo(rowSet.getObject("account_to", Account.class));
        transfer.setAccountFrom(rowSet.getObject("account_from", Account.class));
        return transfer;
    }

}
