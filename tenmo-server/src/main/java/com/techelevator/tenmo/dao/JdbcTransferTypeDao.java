package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcTransferTypeDao implements TransferTypeDao{


    @Override
    public TransferType getTransferTypeById(int transferTypeId) {
        TransferType transferType = null;
        String sql = "SELECT transfer_type_id, transfer_type_desc FROM transfer_types WHERE transfer_type_id = ?";
        SqlRowSet result = JdbcTemplate.queryForRowSet(sql, transferTypeId);
        if (result.next()){
           int transferTypeId = result.getInt("transferTypeId");
        }

    }

    @Override
    public TransferType getTransfer_type_desc(String transfer_type_desc) {
        return null;
    }
}
