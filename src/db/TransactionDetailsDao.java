/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pojos.TransactionDetails;

/**
 *
 * @author Julio Lopez
 */
public class TransactionDetailsDao {
    public static boolean insert(Connection con, TransactionDetails transactions) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_TransactionDetails (id, TransactionIndexId, Particular, Amount, VAT, Total, AccountCode, created_at, updated_at) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, transactions.getId());
            ps.setString(2, transactions.getTransactionIndexId());
            ps.setString(3, transactions.getParticular());
            ps.setString(4, transactions.getAmount());
            ps.setString(5, transactions.getVAT());
            ps.setString(6, transactions.getTotal());
            ps.setString(7, transactions.getAccountCode());
            ps.setString(8, transactions.getCreated_at());
            ps.setString(9, transactions.getUpdated_at());
            
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
