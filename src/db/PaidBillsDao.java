/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojos.PaidBills;

/**
 *
 * @author Julio Lopez
 */
public class PaidBillsDao {    
    private static String paidBillsTableName = "Cashier_PaidBills";
    
    public static boolean insert(Connection con, PaidBills paidBills) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_PaidBills(id, BillNumber, AccountNumber, ServicePeriod, ORNumber, ORDate, DCRNumber, KwhUsed, Teller, OfficeTransacted, PostingDate, PostingTime, Surcharge, Form2307TwoPercent, Form2307FivePercent, AdditionalCharges, Deductions, NetAmount, Source, ObjectSourceId, UserId, created_at, updated_at, Status, FiledBy, ApprovedBy, AuditedBy, Notes, CheckNo, Bank, CheckExpiration, PaymentUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, paidBills.getId());
            ps.setString(2, paidBills.getBillNumber());
            ps.setString(3, paidBills.getAccountNumber());
            ps.setString(4, paidBills.getServicePeriod());
            ps.setString(5, paidBills.getORNumber());
            ps.setString(6, paidBills.getORDate());
            ps.setString(7, paidBills.getDCRNumber());
            ps.setString(8, paidBills.getKwhUsed());
            ps.setString(9, paidBills.getTeller());
            ps.setString(10, paidBills.getOfficeTransacted());
            ps.setString(11, paidBills.getPostingDate());
            ps.setString(12, paidBills.getPostingTime());
            ps.setString(13, paidBills.getSurcharge());
            ps.setString(14, paidBills.getForm2307TwoPercent());
            ps.setString(15, paidBills.getForm2307FivePercent());
            ps.setString(16, paidBills.getAdditionalCharges());
            ps.setString(17, paidBills.getDeductions());
            ps.setString(18, paidBills.getNetAmount());
            ps.setString(19, paidBills.getSource());
            ps.setString(20, paidBills.getObjectSourceId());
            ps.setString(21, paidBills.getUserId());
            ps.setString(22, paidBills.getCreated_at());
            ps.setString(23, paidBills.getUpdated_at());
            ps.setString(24, paidBills.getStatus());
            ps.setString(25, paidBills.getFiledBy());
            ps.setString(26, paidBills.getApprovedBy());
            ps.setString(27, paidBills.getAuditedBy());
            ps.setString(28, paidBills.getNotes());
            ps.setString(29, paidBills.getCheckNo());
            ps.setString(30, paidBills.getBank());
            ps.setString(31, paidBills.getCheckExpiration());
            ps.setString(32, paidBills.getPaymentUsed());
            ps.executeUpdate();                
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<PaidBills> getSumOr(Connection con, String from, String to) {
        try {
            List<PaidBills> paidBillses = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + paidBillsTableName + " WHERE (ORNumber BETWEEN ? AND ?) AND Status IS NULL");
            ps.setString(1, from);
            ps.setString(2, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PaidBills paidBill = new PaidBills(
                    rs.getString("id"),
                    rs.getString("BillNumber"),
                    rs.getString("AccountNumber"),
                    rs.getString("ServicePeriod"),
                    rs.getString("ORNumber"),
                    rs.getString("ORDate"),
                    rs.getString("DCRNumber"),
                    rs.getString("KwhUsed"),
                    rs.getString("Teller"),
                    rs.getString("OfficeTransacted"),
                    rs.getString("PostingDate"),
                    rs.getString("PostingTime"),
                    rs.getString("Surcharge"),
                    rs.getString("Form2307TwoPercent"),
                    rs.getString("Form2307FivePercent"),
                    rs.getString("AdditionalCharges"),
                    rs.getString("Deductions"),
                    rs.getString("NetAmount"),
                    rs.getString("Source"),
                    rs.getString("ObjectSourceId"),
                    rs.getString("UserId"),
                    rs.getString("created_at"),
                    rs.getString("updated_at"),
                    rs.getString("Status"),
                    rs.getString("FiledBy"),
                    rs.getString("ApprovedBy"),
                    rs.getString("AuditedBy"),
                    rs.getString("Notes"),
                    rs.getString("CheckNo"),
                    rs.getString("Bank"),
                    rs.getString("CheckExpiration"),
                    rs.getString("PaymentUsed")
                );
                paidBillses.add(paidBill);
            }
            return paidBillses;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<PaidBills> getCashPowerBills(Connection con, String orDate, String teller) {
        try {
            List<PaidBills> paidBills = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT pb.*, sa.ServiceAccountName, sa.OldAccountNo FROM Cashier_PaidBills pb LEFT JOIN Billing_ServiceAccounts sa ON pb.AccountNumber=sa.id "
                    + "WHERE pb.PostingDate = ? AND pb.Teller = ? AND pb.Status IS NULL AND pb.PaymentUsed LIKE '%Cash%' ORDER BY pb.ORNumber");
            ps.setString(1, orDate);
            ps.setString(2, teller);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                paidBills.add(new PaidBills(
                        rs.getString("ServiceAccountName"),
                        rs.getString("BillNumber"),
                        rs.getString("OldAccountNo"),
                        rs.getString("ServicePeriod"),
                        rs.getString("ORNumber"),
                        rs.getString("ORDate"),
                        null,
                        rs.getString("KwhUsed"),
                        teller,
                        rs.getString("OfficeTransacted"),
                        rs.getString("PostingDate"),
                        rs.getString("PostingTime"),
                        rs.getString("Surcharge"),
                        rs.getString("Form2307TwoPercent"),
                        rs.getString("Form2307FivePercent"),
                        rs.getString("AdditionalCharges"),
                        rs.getString("Deductions"),
                        rs.getString("NetAmount"),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                ));   
            }
            return paidBills;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean updateOR(Connection con, String id, String oldOr, String newOr) {
        try {
            // update paidbills
            String updatePaidBills = "UPDATE Cashier_PaidBills SET ORNumber=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(updatePaidBills);
            ps.setString(1, newOr);
            ps.setString(2, id);
            ps.execute();
            ps.clearParameters();
            
            // update paidbillsdetails
            String updatePaidBillsDetails = "UPDATE Cashier_PaidBillsDetails SET ORNumber=? WHERE ORNumber=?";
            ps = con.prepareStatement(updatePaidBillsDetails);
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
