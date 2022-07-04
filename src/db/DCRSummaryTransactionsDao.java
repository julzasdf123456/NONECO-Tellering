/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.ObjectHelpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import pojos.Bills;
import pojos.DCRSummaryTransactions;

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
            return Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getGenerationSystemCharge())) +
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
            return Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getGenerationVAT())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getTransmissionVAT())) +
                    Double.valueOf(ObjectHelpers.validateNullNumbers(bill.getSystemLossVAT()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
