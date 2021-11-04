package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcTransferTypeDao implements TransferTypeDao{


    @Override
    public TransferType getTransferTypeById(int transferTypeId) throws DataAccessException {
        TransferType transferType = null;
//        String sql = "SELECT transfer_type_id, transfer_type_desc FROM transfer_types WHERE transfer_type_id = ?";
//        SqlRowSet result = JdbcTemplate.queryForRowSet(sql, transferTypeId);
//        if (result.next()){
//           transferTypeId = result.getInt("transferTypeId");
//        }
        return transferType;
    }

    @Override
    public TransferType getTransfer_type_desc(String transfer_type_desc) {
        return null;
    }
}
