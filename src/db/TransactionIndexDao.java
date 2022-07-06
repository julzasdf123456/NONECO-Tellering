/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.Notifiers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import pojos.TransactionIndex;

/**
 *
 * @author Julio Lopez
 */
public class TransactionIndexDao {
    public static boolean insert(Connection con, TransactionIndex transaction) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_TransactionIndex (id, TransactionNumber, PaymentTitle, PaymentDetails, ORNumber, ORDate, SubTotal, VAT, Total, Notes, UserId, ServiceConnectionId, TicketId, ObjectId, Source, PaymentUsed, Status, FiledBy, ApprovedBy, AuditedBy, CancellationNotes, PayeeName, CheckNo, Bank, CheckExpiration, AccountNumber, created_at, updated_at) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, transaction.getId());
            ps.setString(2, transaction.getTransactionNumber());
            ps.setString(3, transaction.getPaymentTitle());
            ps.setString(4, transaction.getPaymentDetails());
            ps.setString(5, transaction.getORNumber());
            ps.setString(6, transaction.getORDate());
            ps.setString(7, transaction.getSubTotal());
            ps.setString(8, transaction.getVAT());
            ps.setString(9, transaction.getTotal());
            ps.setString(10, transaction.getNotes());
            ps.setString(11, transaction.getUserId());
            ps.setString(12, transaction.getServiceConnectionId());
            ps.setString(13, transaction.getTicketId());
            ps.setString(14, transaction.getObjectId());
            ps.setString(15, transaction.getSource());
            ps.setString(16, transaction.getPaymentUsed());
            ps.setString(17, transaction.getStatus());
            ps.setString(18, transaction.getFiledBy());
            ps.setString(19, transaction.getApprovedBy());
            ps.setString(20, transaction.getAuditedBy());
            ps.setString(21, transaction.getCancellationNotes());
            ps.setString(22, transaction.getPayeeName());
            ps.setString(23, transaction.getCheckNo());
            ps.setString(24, transaction.getBank());
            ps.setString(25, transaction.getCheckExpiration());
            ps.setString(26, transaction.getAccountNumber());
            ps.setString(27, transaction.getCreated_at());
            ps.setString(28, transaction.getUpdated_at());
            
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error saving transaction", e.getMessage());
            return false;
        }
    }
}
