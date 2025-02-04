/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.ConfigFileHelpers;
import helpers.ObjectHelpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojos.Bills;
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
    
    public static List<PaidBills> getSumOr(Connection con, String from, String to, String userid) {
        try {
            List<PaidBills> paidBillses = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + paidBillsTableName + " WHERE (ORNumber BETWEEN '" + from + "' AND '" + to + "') AND Status IS NULL AND AccountNumber IS NOT NULL AND Teller='" + userid + "' ORDER BY ORNumber");

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
            PreparedStatement ps = con.prepareStatement("SELECT pb.*, "
                    + "(SELECT SUM(TRY_CAST(Amount AS DECIMAL(25,4))) FROM Cashier_PaidBillsDetails WHERE ServicePeriod=pb.ServicePeriod AND AccountNumber=pb.AccountNumber AND PaymentUsed='Cash' AND UserId=?) AS CashPaid, "
                    + "sa.ServiceAccountName, "
                    + "sa.OldAccountNo "
                    + "FROM Cashier_PaidBills pb LEFT JOIN Billing_ServiceAccounts sa ON pb.AccountNumber=sa.id "
                    + "WHERE pb.PostingDate = ? AND pb.Teller = ? AND (pb.Status IS NULL OR pb.Status='Application') AND pb.PaymentUsed LIKE '%Cash%' ORDER BY pb.ORNumber");
            
            ps.setString(1, teller);
            ps.setString(2, orDate);
            ps.setString(3, teller);
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
                        (rs.getString("CashPaid") != null ? rs.getString("CashPaid") : "0"),
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
                        rs.getString("PaymentUsed")
                ));   
            }
            return paidBills;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean updateOR(Connection con, String id, String oldOr, String newOr, String tellerId, String period) {
        try {
            // update paidbills
            String updatePaidBills = "UPDATE Cashier_PaidBills SET ORNumber=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(updatePaidBills);
            ps.setString(1, newOr);
            ps.setString(2, id);
            ps.execute();
            ps.clearParameters();
            
            // update paidbillsdetails
            String updatePaidBillsDetails = "UPDATE Cashier_PaidBillsDetails SET ORNumber=? WHERE ORNumber=? AND ServicePeriod=?";
            ps = con.prepareStatement(updatePaidBillsDetails);
            ps.setString(1, newOr);
            ps.setString(2, oldOr);
            ps.setString(3, period);
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
    
    public static List<PaidBills> getPaidBillsByDcrNum(Connection con, String dcrNum) {
        try {
            List<PaidBills> paidBillses = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + paidBillsTableName + " WHERE DCRNumber=? AND Status IS NULL ORDER BY ORNumber");
            ps.setString(1, dcrNum);
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
    
    public static PaidBills getOneByOR(Connection con, String orNumber) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_PaidBills WHERE ORNumber=?");
            ps.setString(1, orNumber);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
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
                ps.close();
                rs.close();
                return paidBill;
            }
            
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static PaidBills getOneByORAndAccount(Connection con, String orNumber, String acctNo) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT p.* FROM Cashier_PaidBills p LEFT JOIN Billing_ServiceAccounts a ON p.AccountNumber=a.id "
                    + "WHERE ORNumber=? AND a.OldAccountNo=?");
            ps.setString(1, orNumber);
            ps.setString(2, acctNo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
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
                ps.close();
                rs.close();
                return paidBill;
            }
            
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void requesetCancelOR(Connection con, PaidBills pb, String reason, pojos.Login login) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Cashier_PaidBills SET Status='PENDING CANCEL', FiledBy=?, Notes=? WHERE ORNumber=? AND AccountNumber=?");
            ps.setString(1, login.getId());
            ps.setString(2, reason);
            ps.setString(3, pb.getORNumber());
            ps.setString(4, pb.getAccountNumber());
            ps.execute();            
            ps.clearParameters();
            
            // ADD TO CANCELLATIONS
            ps = con.prepareStatement("INSERT INTO Cashier_ORCancellations (id, ORNumber, ORDate, [From], ObjectId, DateTimeFiled) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, ObjectHelpers.generateIDandRandString());
            ps.setString(2, pb.getORNumber());
            ps.setString(3, pb.getORDate());
            ps.setString(4, "PaidBills");
            ps.setString(5, pb.getId());
            ps.setString(6, ObjectHelpers.getSqlDate());
            ps.execute();
            ps.clearParameters();
            
            // ADD TO NOTIFIERS
            ps = con.prepareStatement("INSERT INTO Notifiers (id, Notification, [From], [To], Status, Intent, ObjectId) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, ObjectHelpers.generateIDandRandString());
            ps.setString(2, "OR Cancellation requested by " + login.getUsername() + " with OR Number " + pb.getORNumber());
            ps.setString(3, login.getId());
            ps.setString(4, ConfigFileHelpers.getCashierHeadId());
            ps.setString(5, "SENT");
            ps.setString(6, "OR CANCELLATION");
            ps.setString(7, pb.getORNumber());
            ps.execute();
            ps.clearParameters();
            
            // REMOVE FROM DCR SUMMARY
            ps = con.prepareStatement("DELETE FROM Cashier_DCRSummaryTransactions WHERE ORNumber=? AND AccountNumber=?"); // ORNumber is once NEACode
            ps.setString(1, pb.getORNumber()); // previously account number
            ps.setString(2, pb.getAccountNumber());
            ps.execute();
            ps.clearParameters();
            
            // REMOVE FROM DETALIS
            ps = con.prepareStatement("DELETE FROM Cashier_PaidBillsDetails WHERE ServicePeriod=? AND AccountNumber=?");
            ps.setString(1, pb.getServicePeriod());
            ps.setString(2, pb.getAccountNumber());
            ps.execute();
            
            // REMOVE FROM CASHIER BILLS
            ps = con.prepareStatement("DELETE FROM Cashier_Bills WHERE ORNumber=? AND AccountNumber=?");
            ps.setString(1, pb.getORNumber());
            ps.setString(2, pb.getAccountNumber());
            ps.execute();
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static List<Bills> getBillsFromGroup(Connection con, String groupId, String period) {
        try {
            List<Bills> billsList = new ArrayList<>();
            String statement = "SELECT b.*, a.ServiceAccountName, a.OldAccountNo FROM Billing_Bills b "
                    + "LEFT JOIN Billing_ServiceAccounts a ON a.id=b.AccountNumber "
                    + "WHERE b.ServicePeriod=? AND a.MemberConsumerId=? "
                    + "AND b.AccountNumber NOT IN (SELECT AccountNumber FROM Cashier_PaidBills WHERE AccountNumber IS NOT NULL AND AccountNumber=b.AccountNumber AND ServicePeriod=b.ServicePeriod AND (Status IS NULL OR Status='Application')) "
                    + "ORDER BY a.OldAccountNo";
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setString(1, period);
            ps.setString(2, groupId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Bills bill = new Bills(
                            rs.getString("id"),
                            rs.getString("BillNumber"),
                            rs.getString("AccountNumber"),
                            rs.getString("ServicePeriod"),
                            rs.getString("Multiplier"),
                            rs.getString("Coreloss"),
                            rs.getString("KwhUsed"),
                            rs.getString("PreviousKwh"),
                            rs.getString("PresentKwh"),
                            rs.getString("OldAccountNo"), // DemandPrev = OldAccountNo
                            rs.getString("DemandPresentKwh"),
                            rs.getString("AdditionalKwh"),
                            rs.getString("AdditionalDemandKwh"),
                            rs.getString("KwhAmount"),
                            rs.getString("EffectiveRate"),
                            rs.getString("AdditionalCharges"),
                            rs.getString("Deductions"),
                            rs.getString("NetAmount"),
                            rs.getString("BillingDate"),
                            rs.getString("ServiceDateFrom"),
                            rs.getString("ServiceDateTo"),
                            rs.getString("DueDate"),
                            rs.getString("MeterNumber"),
                            rs.getString("ConsumerType"),
                            rs.getString("BillType"),
                            rs.getString("GenerationSystemCharge"),
                            rs.getString("TransmissionDeliveryChargeKW"),
                            rs.getString("TransmissionDeliveryChargeKWH"),
                            rs.getString("SystemLossCharge"),
                            rs.getString("DistributionDemandCharge"),
                            rs.getString("DistributionSystemCharge"),
                            rs.getString("SupplyRetailCustomerCharge"),
                            rs.getString("SupplySystemCharge"),
                            rs.getString("MeteringRetailCustomerCharge"),
                            rs.getString("MeteringSystemCharge"),
                            rs.getString("RFSC"),
                            rs.getString("LifelineRate"),
                            rs.getString("InterClassCrossSubsidyCharge"),
                            rs.getString("PPARefund"),
                            rs.getString("SeniorCitizenSubsidy"),
                            rs.getString("MissionaryElectrificationCharge"),
                            rs.getString("EnvironmentalCharge"),
                            rs.getString("StrandedContractCosts"),
                            rs.getString("NPCStrandedDebt"),
                            rs.getString("FeedInTariffAllowance"),
                            rs.getString("MissionaryElectrificationREDCI"),
                            rs.getString("GenerationVAT"),
                            rs.getString("TransmissionVAT"),
                            rs.getString("SystemLossVAT"),
                            rs.getString("DistributionVAT"),
                            rs.getString("RealPropertyTax"),
                            rs.getString("ServiceAccountName"), // Notes = Account Name
                            rs.getString("UserId"),
                            rs.getString("BilledFrom"),
                            rs.getString("AveragedCount"),
                            rs.getString("MergedToCollectible"),
                            rs.getString("OtherGenerationRateAdjustment"),
                            rs.getString("OtherTransmissionCostAdjustmentKW"),
                            rs.getString("OtherTransmissionCostAdjustmentKWH"),
                            rs.getString("OtherSystemLossCostAdjustment"),
                            rs.getString("OtherLifelineRateCostAdjustment"),
                            rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"),
                            rs.getString("FranchiseTax"),
                            rs.getString("BusinessTax"),
                            rs.getString("AdjustmentType"),
                            rs.getString("Form2307Amount"),
                            rs.getString("DeductedDeposit"),
                            rs.getString("ExcessDeposit"),
                            rs.getString("IsUnlockedForPayment"),
                            rs.getString("UnlockedBy"),
                            rs.getString("Evat2Percent"),
                            rs.getString("Evat5Percent"),
                            rs.getString("AdjustmentNumber"),
                            rs.getString("AdjustedBy"),
                            rs.getString("DateAdjusted"),
                            rs.getString("ForCancellation"),
                            rs.getString("CancelRequestedBy"),
                            rs.getString("CancelApprovedBy"),
                            rs.getString("KatasNgVat"),
                            rs.getString("SolarImportPresent"),
                            rs.getString("SolarImportPrevious"),
                            rs.getString("SolarExportPresent"),
                            rs.getString("SolarExportPrevious"),
                            rs.getString("SolarImportKwh"),
                            rs.getString("SolarExportKwh"),
                            rs.getString("GenerationChargeSolarExport"),
                            rs.getString("SolarResidualCredit"), // IF NEGATIVE ANG AMOUNT
                            rs.getString("SolarDemandChargeKW"),
                            rs.getString("SolarDemandChargeKWH"),
                            rs.getString("SolarRetailCustomerCharge"),
                            rs.getString("SolarSupplySystemCharge"),
                            rs.getString("SolarMeteringRetailCharge"),
                            rs.getString("SolarMeteringSystemCharge"),
                            rs.getString("Item1"), // CURRENT AMOUNT DU TO CUSTOMER / PARTIAL AMOUNT
                            rs.getString("Item2"),
                            rs.getString("Item3"),
                            rs.getString("Item4"), // CURRENT AMOUNT CUSTOMER TO DU (Solar Gen - Residual sa Previous)
                            rs.getString("Item5")
                );
                billsList.add(bill);
            }
            return billsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<PaidBills> getCheckSummary(Connection con, String orDate, String teller) {
        try {
            List<PaidBills> paidBills = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT pd.CheckNo, pd.Bank, SUM(TRY_CAST(Amount AS DECIMAL(12,2))) AS Total FROM Cashier_PaidBillsDetails pd "
                    + " WHERE pd.PaymentUsed='Check' AND TRY_CAST(pd.created_at AS DATE) = ? AND pd.UserId = ? GROUP BY pd.CheckNo, pd.Bank");
            
            ps.setString(1, orDate);
            ps.setString(2, teller);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                paidBills.add(new PaidBills(
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
                        null,
                        null,
                        null,
                        null,
                        (rs.getString("Total") != null ? rs.getString("Total") : "0"),
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
                        rs.getString("CheckNo"),
                        rs.getString("Bank"),
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
    
    public static double getSumORCheckTotal(Connection con, String from, String to, String teller) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT SUM(TRY_CAST(Amount AS DECIMAL(12,2))) AS Total FROM Cashier_PaidBillsDetails pd "
                    + " WHERE pd.PaymentUsed='Check' AND (pd.ORNumber BETWEEN '" + from + "' AND '" + to + "') AND pd.UserId = ? AND TRY_CAST(pd.created_at AS DATE) = ?");
            
            ps.setString(1, teller);
            ps.setString(2, ObjectHelpers.getSqlDate());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return (rs.getString("Total") != null ? Double.valueOf(rs.getString("Total")) : 0); 
            }
            
            ps.close();
            rs.close();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double getSumORCashTotal(Connection con, String from, String to, String teller) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT SUM(TRY_CAST(Amount AS DECIMAL(12,2))) AS Total FROM Cashier_PaidBillsDetails pd "
                    + " WHERE pd.PaymentUsed='Cash' AND (pd.ORNumber BETWEEN '" + from + "' AND '" + to + "') AND pd.UserId = ? AND TRY_CAST(pd.created_at AS DATE) = ?");
            
            ps.setString(1, teller);
            ps.setString(2, ObjectHelpers.getSqlDate());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return (rs.getString("Total") != null ? Double.valueOf(rs.getString("Total")) : 0); 
            }
            
            ps.close();
            rs.close();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
