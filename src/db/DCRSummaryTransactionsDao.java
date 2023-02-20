/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.ObjectHelpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojos.Bills;
import pojos.DCRSummaryTransactions;
import pojos.TransactionDetails;

/**
 *
 * @author Julio Lopez
 */
public class DCRSummaryTransactionsDao {
    public static boolean insert(Connection con, DCRSummaryTransactions dCRSummaryTransactions) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_DCRSummaryTransactions(id, GLCode, NEACode, Description, Amount, Day, Time, Teller, DCRNumber, Status, created_at, updated_at, ORNumber, ReportDestination, Office, AccountNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, dCRSummaryTransactions.getId());
            ps.setString(2, dCRSummaryTransactions.getGLCode());
            ps.setString(3, dCRSummaryTransactions.getNEACode());
            ps.setString(4, dCRSummaryTransactions.getDescription());
            ps.setString(5, dCRSummaryTransactions.getAmount());
            ps.setString(6, dCRSummaryTransactions.getDay());
            ps.setString(7, dCRSummaryTransactions.getTime());
            ps.setString(8, dCRSummaryTransactions.getTeller());
            ps.setString(9, dCRSummaryTransactions.getDCRNumber());
            ps.setString(10, dCRSummaryTransactions.getStatus());
            ps.setString(11, dCRSummaryTransactions.getCreated_at());
            ps.setString(12, dCRSummaryTransactions.getUpdated_at());
            ps.setString(13, dCRSummaryTransactions.getORNumber());
            ps.setString(14, dCRSummaryTransactions.getReportDestination());
            ps.setString(15, dCRSummaryTransactions.getOffice());
            ps.setString(16, dCRSummaryTransactions.getAccountNumber());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static double getARConsumers(Bills bill) {
        try {
            double vat = Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getGenerationSystemCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getTransmissionDeliveryChargeKW())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getTransmissionDeliveryChargeKWH())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSystemLossCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getDistributionDemandCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getDistributionSystemCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSupplyRetailCustomerCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSupplySystemCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getMeteringRetailCustomerCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getMeteringSystemCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getOtherGenerationRateAdjustment())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getOtherTransmissionCostAdjustmentKW())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getOtherTransmissionCostAdjustmentKWH())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getOtherSystemLossCostAdjustment())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getOtherLifelineRateCostAdjustment())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getLifelineRate())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSeniorCitizenSubsidy())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSeniorCitizenDiscountAndSubsidyAdjustment()));
            
            return Double.valueOf(ObjectHelpers.roundTwoNoComma(vat + ""));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double getNetMeterCommercialSales(Bills bill) {
        try {
            double sales = Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSolarDemandChargeKW())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSolarDemandChargeKWH())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSolarRetailCustomerCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSolarSupplySystemCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSolarMeteringRetailCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSolarMeteringSystemCharge())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSupplyRetailCustomerCharge()));
            
            return Double.valueOf(ObjectHelpers.roundTwoNoComma(sales + ""));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static String getARConsumersCode(String town) {
        if (town.equals("01")) {
            return "140-142-50"; // Cadiz
        } else if(town.equals("02")) {
            return "140-142-20"; // EB Magalona
        } else if(town.equals("03")) {
            return "140-142-40"; // Manapla
        } else if(town.equals("04")) {
            return "140-142-30"; // Victorias
        } else if(town.equals("05")) {
            return "140-142-80"; // San Carlos
        } else if(town.equals("06")) {
            return "140-142-60"; // Sagay
        } else if(town.equals("07")) {
            return "140-142-70"; // Escalante
        } else if(town.equals("08")) {
            return "140-142-81"; // Calatrava
        } else if(town.equals("09")) {
            return "140-142-71"; // Toboso
        } else {
            return "0"; // Null
        }
    }
    
    public static String getARConsumersRPTCode(String town) {
        if (town.equals("01")) {
            return "140-143-05"; // Cadiz
        } else if (town.equals("02")) {
            return "140-143-02"; // EB Magalona
        } else if (town.equals("03")) {
            return "140-143-04"; // Manapla
        } else if (town.equals("04")) {
            return "140-143-03"; // Victorias
        } else if (town.equals("05")) {
            return "140-143-08"; // San Carlos
        } else if (town.equals("06")) {
            return "140-143-06"; // Sagay
        } else if (town.equals("07")) {
            return "140-143-07"; // Escalante
        } else if (town.equals("08")) {
            return "140-143-18"; // Calatrava
        } else if (town.equals("09")) {
            return "140-143-17"; // Toboso
        } else {
            return "0"; // Null
        }
    }
    
    public static String getGLCodePerAccountType(String type) {
        if (type.equals("COMMERCIAL") || type.equals("COMMERCIAL HIGH VOLTAGE")) {
            return "311-442-00";
        } else if (type.equals("PUBLIC BUILDING") || type.equals("PUBLIC BUILDING HIGH VOLTAGE")) {
            return "311-445-00";
        } else if (type.equals("INDUSTRIAL") || type.equals("INDUSTRIAL HIGH VOLTAGE")) {
            return "311-443-00";
        } else if (type.equals("STREET LIGHTS")) {
            return "311-444-00";
        } else if (type.equals("IRRIGATION/WATER SYSTEMS")) {
            return "311-446-00";
        } else if (type.equals("BAPA")) {
            return "311-448-00";
        } else {
            return "0";
        }
    }
    
    public static String getARConsumersTermedPayments(String town) {
        if (town.equals("01")) {
            return "140-142-67"; // Cadiz
        } else if(town.equals("02")) {
            return "140-142-64"; // EB Magalona
        } else if(town.equals("03")) {
            return "140-142-66"; // Manapla
        } else if(town.equals("04")) {
            return "140-142-65"; // Victorias
        } else if(town.equals("05")) {
            return "140-142-75"; // San Carlos
        } else if(town.equals("06")) {
            return "140-142-77"; // Sagay
        } else if(town.equals("07")) {
            return "140-142-68"; // Escalante
        } else if(town.equals("08")) {
            return "140-142-76"; // Calatrava
        } else if(town.equals("09")) {
            return "140-142-69"; // Toboso
        } else {
            return "0"; // Null
        }
    }
    
    public static double getGenTransSyslossVatSales(Bills bill) {
        try {
            double vat = Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getGenerationVAT())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getTransmissionVAT())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSystemLossVAT()));
            return Double.valueOf(ObjectHelpers.roundTwoNoComma(vat + ""));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static List<DCRSummaryTransactions> getDcrSummary(Connection con, String day, String teller) {
        try {
            List<DCRSummaryTransactions> dcr = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT GLCode, "
                    + "(SELECT Notes FROM Cashier_AccountGLCodes WHERE AccountCode=Cashier_DCRSummaryTransactions.GLCode) AS Description,"
                    + "SUM(TRY_CAST(Amount AS DECIMAL(25,2))) AS Amount "
                    + "FROM Cashier_DCRSummaryTransactions WHERE Day=? AND Teller=? AND (ReportDestination='COLLECTION' OR ReportDestination='BOTH') "
                    + "GROUP BY GLCode ORDER BY GLCode");
            ps.setString(1, day);
            ps.setString(2, teller);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dcr.add(new DCRSummaryTransactions(
                        null,
                        rs.getString("GLCode"),
                        null,
                        rs.getString("Description"),
                        rs.getString("Amount"),
                        day,
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
            return dcr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<TransactionDetails> getCheckPayments(Connection con, String day, String teller) {
        try {
            List<TransactionDetails> checkList = new ArrayList<>();
            
            String powerBillQry = "SELECT ORNumber, sa.OldAccountNo as AccountNumber, sa.ServiceAccountName, 'POWER BILL' AS Source, pb.Amount, pb.CheckNo, pb.Bank, pb.ServicePeriod FROM Cashier_PaidBillsDetails pb LEFT JOIN Billing_ServiceAccounts sa ON pb.AccountNumber=sa.id WHERE pb.UserId='" + teller + "' AND CAST(pb.created_at AS DATE)='" + day + "' AND PaymentUsed LIKE '%Check%'";
            String othersQry = "SELECT t.ORNumber, t.AccountNumber, t.PayeeName, 'OTHERS' AS Source, td.Amount, td.CheckNo, td.Bank, '1970-01-01' AS ServicePeriod FROM Cashier_TransactionPaymentDetails td LEFT JOIN Cashier_TransactionIndex t ON t.ORNumber=td.ORNumber WHERE t.UserId='" + teller + "' AND t.ORDate='" + day + "' AND td.PaymentUsed LIKE '%Check%'";
            PreparedStatement ps = con.prepareStatement(powerBillQry + " UNION " + othersQry);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                checkList.add(new TransactionDetails(
                        rs.getString("ORNumber"),
                        rs.getString("AccountNumber"),
                        rs.getString("ServiceAccountName"),
                        rs.getString("Source"),
                        rs.getString("CheckNo"),
                        rs.getString("Amount"),
                        rs.getString("Bank"),
                        rs.getString("ServicePeriod"),
                        null
                ));
            }
            
            return checkList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<TransactionDetails> getORsToday(Connection con, String day, String teller) {
        try {
            List<TransactionDetails> checkList = new ArrayList<>();
            
            String powerBillQry = "SELECT pb.id, pb.ORNumber, sa.OldAccountNo as AccountNumber, sa.ServiceAccountName, 'POWER BILL' AS Source, pb.NetAmount, pb.PaymentUsed, pb.ServicePeriod FROM Cashier_PaidBills pb LEFT JOIN Billing_ServiceAccounts sa ON pb.AccountNumber=sa.id WHERE pb.Teller='" + teller + "' AND ORDate='" + day + "'";
            String othersQry = "SELECT td.id, td.ORNumber, td.AccountNumber, td.PayeeName, 'OTHERS' AS Source, td.Total, td.PaymentUsed, '1990-01-01' AS ServicePeriod FROM Cashier_TransactionIndex td WHERE td.UserId='" + teller + "' AND td.ORDate='" + day + "'";
            PreparedStatement ps = con.prepareStatement(powerBillQry + " UNION " + othersQry + " ORDER BY ORNumber DESC");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                checkList.add(new TransactionDetails(
                        rs.getString("ORNumber"),
                        rs.getString("AccountNumber"),
                        rs.getString("ServiceAccountName"),
                        rs.getString("Source"),
                        rs.getString("id"),
                        rs.getString("NetAmount"),
                        rs.getString("PaymentUsed"),
                        rs.getString("ServicePeriod"),
                        null
                ));
            }
            
            return checkList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<TransactionDetails> getCancelledORs(Connection con, String day, String teller) {
        try {
            List<TransactionDetails> checkList = new ArrayList<>();
            
            String powerBillQry = "SELECT pb.id, pb.ORNumber, sa.OldAccountNo as AccountNumber, sa.ServiceAccountName, 'POWER BILL' AS Source, pb.NetAmount, pb.PaymentUsed, pb.Status FROM Cashier_PaidBills pb LEFT JOIN Billing_ServiceAccounts sa ON pb.AccountNumber=sa.id WHERE pb.Teller='" + teller + "' AND ORDate='" + day + "' AND pb.Status IN ('CANCELLED', 'PENDING CANCEL')";
            String othersQry = "SELECT td.id, td.ORNumber, td.AccountNumber, td.PayeeName, 'OTHERS' AS Source, td.Total, td.PaymentUsed, td.Status FROM Cashier_TransactionIndex td WHERE td.UserId='" + teller + "' AND td.ORDate='" + day + "' AND td.Status IN ('CANCELLED', 'PENDING CANCEL')";
            PreparedStatement ps = con.prepareStatement(powerBillQry + " UNION " + othersQry + " ORDER BY ORNumber DESC");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                checkList.add(new TransactionDetails(
                        rs.getString("ORNumber"),
                        rs.getString("AccountNumber"),
                        rs.getString("ServiceAccountName"),
                        rs.getString("Source"),
                        rs.getString("id"),
                        rs.getString("NetAmount"),
                        rs.getString("PaymentUsed"),
                        rs.getString("Status"),
                        null
                ));
            }
            
            return checkList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<TransactionDetails> searchOR(Connection con, String orNumber) {
        try {
            List<TransactionDetails> checkList = new ArrayList<>();
            
            String powerBillQry = "";
            String othersQry = "";
            if (orNumber.equals("All")) {
                powerBillQry = "SELECT TOP 20 pb.id, pb.ORNumber, sa.OldAccountNo as AccountNumber, sa.ServiceAccountName, 'POWER BILL' AS Source, pb.NetAmount, pb.PaymentUsed, pb.ORDate FROM Cashier_PaidBills pb LEFT JOIN Billing_ServiceAccounts sa ON pb.AccountNumber=sa.id WHERE pb.Status IS NULL";
                othersQry = "SELECT TOP 20 td.id, td.ORNumber, td.AccountNumber, td.PayeeName, 'OTHERS' AS Source, td.Total, td.PaymentUsed, td.ORDate FROM Cashier_TransactionIndex td WHERE td.Status IS NULL";
            } else {
                powerBillQry = "SELECT pb.id, pb.ORNumber, sa.OldAccountNo as AccountNumber, sa.ServiceAccountName, 'POWER BILL' AS Source, pb.NetAmount, pb.PaymentUsed, pb.ORDate FROM Cashier_PaidBills pb LEFT JOIN Billing_ServiceAccounts sa ON pb.AccountNumber=sa.id WHERE pb.Status IS NULL AND pb.ORNumber LIKE '%" + orNumber + "%'";
                othersQry = "SELECT td.id, td.ORNumber, td.AccountNumber, td.PayeeName, 'OTHERS' AS Source, td.Total, td.PaymentUsed, td.ORDate FROM Cashier_TransactionIndex td WHERE td.Status IS NULL AND td.ORNumber LIKE '%" + orNumber + "%'";      
            }
            
            PreparedStatement ps = con.prepareStatement(powerBillQry + " UNION " + othersQry + " ORDER BY ORNumber DESC");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                checkList.add(new TransactionDetails(
                        rs.getString("ORNumber"),
                        rs.getString("AccountNumber"),
                        rs.getString("ServiceAccountName"),
                        rs.getString("Source"),
                        rs.getString("id"),
                        rs.getString("NetAmount"),
                        rs.getString("PaymentUsed"),
                        rs.getString("ORDate"),
                        null
                ));
            }
            
            return checkList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static double getDcr(Connection con, String orNumber, String teller, String accountNumber, String day, String period) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT "
                    + "SUM(TRY_CAST(Amount AS DECIMAL(25,4))) AS Amount "
                    + "FROM Cashier_DCRSummaryTransactions WHERE Day=? AND Teller=? AND AccountNumber=? AND ORNumber=? AND NEACode=? AND (ReportDestination='COLLECTION' OR ReportDestination='BOTH')");
            ps.setString(1, day);
            ps.setString(2, teller);
            ps.setString(3, accountNumber);
            ps.setString(4, orNumber);
            ps.setString(5, period);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("Amount") != null ? Double.valueOf(rs.getString("Amount")) : 0;
            } else {
                return 0;
            }            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
