/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pojos.TransactionPaymentDetails;

/**
 *
 * @author Julio Lopez
 */
public class TransactionPaymentDetailsDao {
    public static boolean insert(Connection con, TransactionPaymentDetails logs) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_TransactionPaymentDetails (id,TransactionIndexId,Amount,PaymentUsed,Bank,CheckNo,CheckExpiration,ORNumber,created_at,updated_at) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, logs.getId());
            ps.setString(2, logs.getTransactionIndexId());
            ps.setString(3, logs.getAmount());
            ps.setString(4, logs.getPaymentUsed());
            ps.setString(5, logs.getBank());
            ps.setString(6, logs.getCheckNo());
            ps.setString(7, logs.getCheckExpiration());
            ps.setString(8, logs.getORNumber());
            ps.setString(9, logs.getCreated_at());
            ps.setString(10, logs.getUpdated_at());
            
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
