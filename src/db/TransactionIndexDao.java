/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.Notifiers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojos.TransactionDetails;
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
    
    public static List<TransactionDetails> getDcr(Connection con, String orDate, String teller) {
        try {
            List<TransactionDetails> dcr = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT t.ORNumber,"
                    + "d.Total,"
                    + "t.AccountNumber,"
                    + "t.PayeeName,"
                    + "d.AccountCode, "
                    + "d.Particular, "
                    + "t.PaymentUsed "
                    + "FROM Cashier_TransactionDetails d LEFT JOIN Cashier_TransactionIndex t ON t.id=d.TransactionIndexId "
                    + "WHERE t.ORDate=? AND t.UserId=? AND t.Status IS NULL AND t.PaymentUsed='Cash' ORDER BY t.ORNumber");
            ps.setString(1, orDate);
            ps.setString(2, teller);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                dcr.add(new TransactionDetails(
                        rs.getString("ORNumber"),
                        rs.getString("PaymentUsed"),
                        rs.getString("Particular"),
                        null,
                        rs.getString("PayeeName"),
                        rs.getString("Total"),
                        rs.getString("AccountCode"),
                        null,
                        null
                ));
            }
            return dcr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean updateOR(Connection con, String id, String oldOr, String newOr) {
        try {
            // update transaction index
            String updateTransactionindex = "UPDATE Cashier_TransactionIndex SET ORNumber=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(updateTransactionindex);
            ps.setString(1, newOr);
            ps.setString(2, id);
            ps.execute();
            ps.clearParameters();
            
            // update transaction paymentdetails
            String updateTransactionPaymentDetails = "UPDATE Cashier_TransactionPaymentDetails SET ORNumber=? WHERE ORNumber=?";
            ps = con.prepareStatement(updateTransactionPaymentDetails);
            ps.setString(1, newOr);
            ps.setString(2, oldOr);
            ps.execute();
            ps.clearParameters();
            
            // update orassigning
            String updateOrAssigning = "UPDATE Cashier_ORAssigning SET ORNumber=? WHERE ORNumber=?";
            ps = con.prepareStatement(updateOrAssigning);
            ps.setString(1, newOr);
            ps.setString(2, oldOr);
            ps.execute();
            ps.clearParameters();
            
            // update dcrtransactionsummary
            String updateDcr = "UPDATE Cashier_DCRSummaryTransactions SET ORNumber=? WHERE ORNumber=?";
            ps = con.prepareStatement(updateDcr);
            ps.setString(1, newOr);
            ps.setString(2, oldOr);
            ps.execute();
            ps.clearParameters();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
