/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.ConfigFileHelpers;
import helpers.Notifiers;
import helpers.ObjectHelpers;
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
                    + "d.Amount,"
                    + "t.AccountNumber,"
                    + "t.PayeeName,"
                    + "t.PaymentDetails, "
                    + "t.PaymentUsed "
                    + "FROM Cashier_TransactionPaymentDetails d LEFT JOIN Cashier_TransactionIndex t ON t.ORNumber=d.ORNumber "
                    + "WHERE t.ORDate=? AND t.UserId=? AND t.Status IS NULL AND d.PaymentUsed='Cash' ORDER BY t.ORNumber");
            ps.setString(1, orDate);
            ps.setString(2, teller);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                dcr.add(new TransactionDetails(
                        rs.getString("ORNumber"),
                        rs.getString("PaymentUsed"),
                        rs.getString("PaymentDetails"),
                        null,
                        rs.getString("PayeeName"),
                        rs.getString("Amount"),
                        null,
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
    
    public static boolean updateOR(Connection con, String id, String oldOr, String newOr, String tellerId) {
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
            String updateOrAssigning = "UPDATE Cashier_ORAssigning SET ORNumber=? WHERE ORNumber=? AND UserId=?";
            ps = con.prepareStatement(updateOrAssigning);
            ps.setString(1, newOr);
            ps.setString(2, oldOr);
            ps.setString(3, tellerId);
            ps.execute();
            ps.clearParameters();
            
            // update dcrtransactionsummary
            String updateDcr = "UPDATE Cashier_DCRSummaryTransactions SET ORNumber=? WHERE ORNumber=? AND Teller=?";
            ps = con.prepareStatement(updateDcr);
            ps.setString(1, newOr);
            ps.setString(2, oldOr);
            ps.setString(3, tellerId);
            ps.execute();
            ps.clearParameters();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static TransactionIndex getOneByOR(Connection con, String orNumber) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_TransactionIndex WHERE ORNumber=?");
            ps.setString(1, orNumber);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                TransactionIndex index = new TransactionIndex(
                        rs.getString("id"),
                        rs.getString("TransactionNumber"),
                        rs.getString("PaymentTitle"),
                        rs.getString("PaymentDetails"),
                        rs.getString("ORNumber"),
                        rs.getString("ORDate"),
                        rs.getString("SubTotal"),
                        rs.getString("VAT"),
                        rs.getString("Total"),
                        rs.getString("Notes"),
                        rs.getString("UserId"),
                        rs.getString("ServiceConnectionId"),
                        rs.getString("TicketId"),
                        rs.getString("ObjectId"),
                        rs.getString("Source"),
                        rs.getString("PaymentUsed"),
                        rs.getString("Status"),
                        rs.getString("FiledBy"),
                        rs.getString("ApprovedBy"),
                        rs.getString("AuditedBy"),
                        rs.getString("CancellationNotes"),
                        rs.getString("PayeeName"),
                        rs.getString("CheckNo"),
                        rs.getString("Bank"),
                        rs.getString("CheckExpiration"),
                        rs.getString("AccountNumber"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
                ps.close();
                rs.close();
                return index;
            }
            
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void requestCancelOR(Connection con, TransactionIndex index, String reason, pojos.Login login) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Cashier_TransactionIndex SET Status='PENDING CANCEL', FiledBy=?, Notes=? WHERE ORNumber=?");
            ps.setString(1, login.getId());
            ps.setString(2, reason);
            ps.setString(3, index.getORNumber());
            ps.execute();            
            ps.clearParameters();
            
            // ADD TO CANCELLATIONS
            ps = con.prepareStatement("INSERT INTO Cashier_ORCancellations (id, ORNumber, ORDate, [From], ObjectId, DateTimeFiled) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, ObjectHelpers.generateIDandRandString());
            ps.setString(2, index.getORNumber());
            ps.setString(3, index.getORDate());
            ps.setString(4, "Transactions");
            ps.setString(5, index.getId());
            ps.setString(6, ObjectHelpers.getSqlDate());
            ps.execute();
            ps.clearParameters();
            
            // ADD TO NOTIFIERS
            ps = con.prepareStatement("INSERT INTO Notifiers (id, Notification, [From], [To], Status, Intent, ObjectId) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, ObjectHelpers.generateIDandRandString());
            ps.setString(2, "OR Cancellation requested by " + login.getUsername() + " with OR Number " + index.getORNumber());
            ps.setString(3, login.getId());
            ps.setString(4, ConfigFileHelpers.getCashierHeadId());
            ps.setString(5, "SENT");
            ps.setString(6, "OR CANCELLATION");
            ps.setString(7, index.getORNumber());
            ps.execute();            
            ps.clearParameters();
            
            // REMOVE FROM DCR SUMMARY
            ps = con.prepareStatement("DELETE FROM Cashier_DCRSummaryTransactions WHERE ORNumber=?");
            ps.setString(1, index.getORNumber());
            ps.execute();
            ps.clearParameters();
            
            // REMOVE FROM DCR SUMMARY
            ps = con.prepareStatement("DELETE FROM Cashier_TransactionPaymentDetails WHERE ORNumber=?");
            ps.setString(1, index.getORNumber());
            ps.execute();
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static double getSumOr(Connection con, String from, String to, String userid) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT SUM(TRY_CAST(Total AS DECIMAL(12,2))) AS Total FROM Cashier_TransactionIndex WHERE (ORNumber BETWEEN TRY_CAST('" + from + "' AS DECIMAL(20,2)) AND TRY_CAST('" + to + "' AS DECIMAL(20,2))) AND Status IS NULL AND UserId='" + userid + "'");
   
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return Double.valueOf(rs.getString("Total"));
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static int getSumOrCount(Connection con, String from, String to) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(id) AS CountTotal FROM Cashier_TransactionIndex WHERE (ORNumber BETWEEN ? AND ?) AND Status IS NULL");
   
            ps.setString(1, from);
            ps.setString(2, to);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return Integer.valueOf(rs.getString("CountTotal"));
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double getSumOrCheckTotal(Connection con, String from, String to, String userid) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT SUM(TRY_CAST(pd.Amount AS DECIMAL(12,2))) AS Total FROM Cashier_TransactionIndex p LEFT JOIN Cashier_TransactionPaymentDetails pd ON p.id=pd.TransactionIndexId WHERE (p.ORNumber BETWEEN TRY_CAST('" + from + "' AS DECIMAL(20,2)) AND TRY_CAST('" + to + "' AS DECIMAL(20,2))) AND p.Status IS NULL AND p.UserId='" + userid + "' AND pd.PaymentUsed='Check'");
   
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return Double.valueOf(rs.getString("Total"));
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double getSumOrCashTotal(Connection con, String from, String to, String userid) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT SUM(TRY_CAST(pd.Amount AS DECIMAL(12,2))) AS Total FROM Cashier_TransactionIndex p LEFT JOIN Cashier_TransactionPaymentDetails pd ON p.id=pd.TransactionIndexId WHERE (p.ORNumber BETWEEN TRY_CAST('" + from + "' AS DECIMAL(20,2)) AND TRY_CAST('" + to + "' AS DECIMAL(20,2))) AND p.Status IS NULL AND p.UserId='" + userid + "' AND pd.PaymentUsed='Cash'");
   
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return Double.valueOf(rs.getString("Total"));
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
