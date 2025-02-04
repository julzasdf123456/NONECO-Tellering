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
import pojos.CashierBills;
import pojos.DCRSummaryTransactions;

/**
 *
 * @author julza
 */
public class CashierBillsDao {
    public static CashierBills getOne(Connection con, String accountNumber, String period) {
        try {
            String sql = "SELECT * FROM Cashier_Bills WHERE AccountNumber=? AND ServicePeriod=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ps.setString(2, period);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                CashierBills cb = new CashierBills(
                    rs.getString("id"),
                    rs.getString("BillNumber"),
                    rs.getString("AccountNumber"),
                    rs.getString("ServicePeriod"),
                    rs.getString("Multiplier"),
                    rs.getString("Coreloss"),
                    rs.getString("KwhUsed"),
                    rs.getString("PreviousKwh"),
                    rs.getString("PresentKwh"),
                    rs.getString("DemandPreviousKwh"),
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
                    rs.getString("Notes"),
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
                    rs.getString("SolarResidualCredit"),
                    rs.getString("SolarDemandChargeKW"),
                    rs.getString("SolarDemandChargeKWH"),
                    rs.getString("SolarRetailCustomerCharge"),
                    rs.getString("SolarSupplySystemCharge"),
                    rs.getString("SolarMeteringRetailCharge"),
                    rs.getString("SolarMeteringSystemCharge"),
                    rs.getString("Item1"),
                    rs.getString("Item2"),
                    rs.getString("Item3"),
                    rs.getString("Item4"),
                    rs.getString("Item5"),
                    rs.getString("ORNumber"),
                    rs.getString("ORDate"),
                    rs.getString("Surcharges"),
                    rs.getString("BAPADiscount"),
                    rs.getString("Prepayment")
                );
                
                ps.close();
                rs.close();
                return cb;  
            } else {
                ps.close();
                rs.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;   
        }
    }
    
    public static void delete(Connection con, CashierBills cb) {
        try {
            String sql = "DELETE FROM Cashier_Bills WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cb.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void insert(Connection con, CashierBills cb) {
        try {
            CashierBills checkCb = getOne(con, cb.getAccountNumber(), cb.getServicePeriod());
            
            if (checkCb != null) {
                // delete original
                delete(con, cb);
            }
            
            // insert cashier bills
            String sql = "INSERT INTO Cashier_Bills (id," +
                "BillNumber," +
                "AccountNumber," +
                "ServicePeriod," +
                "Multiplier," +
                "Coreloss," +
                "KwhUsed," +
                "PreviousKwh," +
                "PresentKwh," +
                "DemandPreviousKwh," +
                "DemandPresentKwh," +
                "AdditionalKwh," +
                "AdditionalDemandKwh," +
                "KwhAmount," +
                "EffectiveRate," +
                "AdditionalCharges," +
                "Deductions," +
                "NetAmount," +
                "BillingDate," +
                "ServiceDateFrom," +
                "ServiceDateTo," +
                "DueDate," +
                "MeterNumber," +
                "ConsumerType," +
                "BillType," +
                "GenerationSystemCharge," +
                "TransmissionDeliveryChargeKW," +
                "TransmissionDeliveryChargeKWH," +
                "SystemLossCharge," +
                "DistributionDemandCharge," +
                "DistributionSystemCharge," +
                "SupplyRetailCustomerCharge," +
                "SupplySystemCharge," +
                "MeteringRetailCustomerCharge," +
                "MeteringSystemCharge," +
                "RFSC," +
                "LifelineRate," +
                "InterClassCrossSubsidyCharge," +
                "PPARefund," +
                "SeniorCitizenSubsidy," +
                "MissionaryElectrificationCharge," +
                "EnvironmentalCharge," +
                "StrandedContractCosts," +
                "NPCStrandedDebt," +
                "FeedInTariffAllowance," +
                "MissionaryElectrificationREDCI," +
                "GenerationVAT," +
                "TransmissionVAT," +
                "SystemLossVAT," +
                "DistributionVAT," +
                "RealPropertyTax," +
                "Notes," +
                "UserId," +
                "BilledFrom," +
                "AveragedCount," +
                "MergedToCollectible," +
                "OtherGenerationRateAdjustment," +
                "OtherTransmissionCostAdjustmentKW," +
                "OtherTransmissionCostAdjustmentKWH," +
                "OtherSystemLossCostAdjustment," +
                "OtherLifelineRateCostAdjustment," +
                "SeniorCitizenDiscountAndSubsidyAdjustment," +
                "FranchiseTax," +
                "BusinessTax," +
                "AdjustmentType," +
                "Form2307Amount," +
                "DeductedDeposit," +
                "ExcessDeposit," +
                "IsUnlockedForPayment," +
                "UnlockedBy," +
                "Evat2Percent," +
                "Evat5Percent," +
                "AdjustmentNumber," +
                "AdjustedBy," +
                "DateAdjusted," +
                "ForCancellation," +
                "CancelRequestedBy," +
                "CancelApprovedBy," +
                "KatasNgVat," +
                "SolarImportPresent," +
                "SolarImportPrevious," +
                "SolarExportPresent," +
                "SolarExportPrevious," +
                "SolarImportKwh," +
                "SolarExportKwh," +
                "GenerationChargeSolarExport," +
                "SolarResidualCredit," +
                "SolarDemandChargeKW," +
                "SolarDemandChargeKWH," +
                "SolarRetailCustomerCharge," +
                "SolarSupplySystemCharge," +
                "SolarMeteringRetailCharge," +
                "SolarMeteringSystemCharge," +
                "Item1," +
                "Item2," +
                "Item3," +
                "Item4," +
                "Item5," +
                "ORNumber," +
                "ORDate," +
                "Surcharges," +
                "BAPADiscount,"
                    + "created_at,"
                    + "updated_at," +
                "Prepayment) VALUES (" + 
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cb.getId());
            ps.setString(2, cb.getBillNumber());
            ps.setString(3, cb.getAccountNumber());
            ps.setString(4, cb.getServicePeriod());
            ps.setString(5, cb.getMultiplier());
            ps.setString(6, cb.getCoreloss());
            ps.setString(7, cb.getKwhUsed());
            ps.setString(8, cb.getPreviousKwh());
            ps.setString(9, cb.getPresentKwh());
            ps.setString(10, cb.getDemandPreviousKwh());
            ps.setString(11, cb.getDemandPresentKwh());
            ps.setString(12, cb.getAdditionalKwh());
            ps.setString(13, cb.getAdditionalDemandKwh());
            ps.setString(14, cb.getKwhAmount());
            ps.setString(15, cb.getEffectiveRate());
            ps.setString(16, cb.getAdditionalCharges());
            ps.setString(17, cb.getDeductions());
            ps.setString(18, cb.getNetAmount());
            ps.setString(19, cb.getBillingDate());
            ps.setString(20, cb.getServiceDateFrom());
            ps.setString(21, cb.getServiceDateTo());
            ps.setString(22, cb.getDueDate());
            ps.setString(23, cb.getMeterNumber());
            ps.setString(24, cb.getConsumerType());
            ps.setString(25, cb.getBillType());
            ps.setString(26, cb.getGenerationSystemCharge());
            ps.setString(27, cb.getTransmissionDeliveryChargeKW());
            ps.setString(28, cb.getTransmissionDeliveryChargeKWH());
            ps.setString(29, cb.getSystemLossCharge());
            ps.setString(30, cb.getDistributionDemandCharge());
            ps.setString(31, cb.getDistributionSystemCharge());
            ps.setString(32, cb.getSupplyRetailCustomerCharge());
            ps.setString(33, cb.getSupplySystemCharge());
            ps.setString(34, cb.getMeteringRetailCustomerCharge());
            ps.setString(35, cb.getMeteringSystemCharge());
            ps.setString(36, cb.getRFSC());
            ps.setString(37, cb.getLifelineRate());
            ps.setString(38, cb.getInterClassCrossSubsidyCharge());
            ps.setString(39, cb.getPPARefund());
            ps.setString(40, cb.getSeniorCitizenSubsidy());
            ps.setString(41, cb.getMissionaryElectrificationCharge());
            ps.setString(42, cb.getEnvironmentalCharge());
            ps.setString(43, cb.getStrandedContractCosts());
            ps.setString(44, cb.getNPCStrandedDebt());
            ps.setString(45, cb.getFeedInTariffAllowance());
            ps.setString(46, cb.getMissionaryElectrificationREDCI());
            ps.setString(47, cb.getGenerationVAT());
            ps.setString(48, cb.getTransmissionVAT());
            ps.setString(49, cb.getSystemLossVAT());
            ps.setString(50, cb.getDistributionVAT());
            ps.setString(51, cb.getRealPropertyTax());
            ps.setString(52, cb.getNotes());
            ps.setString(53, cb.getUserId());
            ps.setString(54, cb.getBilledFrom());
            ps.setString(55, cb.getAveragedCount());
            ps.setString(56, cb.getMergedToCollectible());
            ps.setString(57, cb.getOtherGenerationRateAdjustment());
            ps.setString(58, cb.getOtherTransmissionCostAdjustmentKW());
            ps.setString(59, cb.getOtherTransmissionCostAdjustmentKWH());
            ps.setString(60, cb.getOtherSystemLossCostAdjustment());
            ps.setString(61, cb.getOtherLifelineRateCostAdjustment());
            ps.setString(62, cb.getSeniorCitizenDiscountAndSubsidyAdjustment());
            ps.setString(63, cb.getFranchiseTax());
            ps.setString(64, cb.getBusinessTax());
            ps.setString(65, cb.getAdjustmentType());
            ps.setString(66, cb.getForm2307Amount());
            ps.setString(67, cb.getDeductedDeposit());
            ps.setString(68, cb.getExcessDeposit());
            ps.setString(69, cb.getIsUnlockedForPayment());
            ps.setString(70, cb.getUnlockedBy());
            ps.setString(71, cb.getEvat2Percent());
            ps.setString(72, cb.getEvat5Percent());
            ps.setString(73, cb.getAdjustmentNumber());
            ps.setString(74, cb.getAdjustedBy());
            ps.setString(75, cb.getDateAdjusted());
            ps.setString(76, cb.getForCancellation());
            ps.setString(77, cb.getCancelRequestedBy());
            ps.setString(78, cb.getCancelApprovedBy());
            ps.setString(79, cb.getKatasNgVat());
            ps.setString(80, cb.getSolarImportPresent());
            ps.setString(81, cb.getSolarImportPrevious());
            ps.setString(82, cb.getSolarExportPresent());
            ps.setString(83, cb.getSolarExportPrevious());
            ps.setString(84, cb.getSolarImportKwh());
            ps.setString(85, cb.getSolarExportKwh());
            ps.setString(86, cb.getGenerationChargeSolarExport());
            ps.setString(87, cb.getSolarResidualCredit());
            ps.setString(88, cb.getSolarDemandChargeKW());
            ps.setString(89, cb.getSolarDemandChargeKWH());
            ps.setString(90, cb.getSolarRetailCustomerCharge());
            ps.setString(91, cb.getSolarSupplySystemCharge());
            ps.setString(92, cb.getSolarMeteringRetailCharge());
            ps.setString(93, cb.getSolarMeteringSystemCharge());
            ps.setString(94, cb.getItem1());
            ps.setString(95, cb.getItem2());
            ps.setString(96, cb.getItem3());
            ps.setString(97, cb.getItem4());
            ps.setString(98, cb.getItem5());
            ps.setString(99, cb.getORNumber());
            ps.setString(100, cb.getORDate());
            ps.setString(101, cb.getSurcharges());
            ps.setString(102, cb.getBAPADiscount());
            ps.setString(103, ObjectHelpers.getCurrentTimestamp());
            ps.setString(104, ObjectHelpers.getCurrentTimestamp());
            ps.setString(105, cb.getPrepayment());
            
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static CashierBills bridgeFromBills(Bills b) {
        try {
            CashierBills cb = new CashierBills(
                b.getId(),
                b.getBillNumber(),
                b.getAccountNumber(),
                b.getServicePeriod(),
                b.getMultiplier(),
                b.getCoreloss(),
                b.getKwhUsed(),
                b.getPreviousKwh(),
                b.getPresentKwh(),
                b.getDemandPreviousKwh(),
                b.getDemandPresentKwh(),
                b.getAdditionalKwh(),
                b.getAdditionalDemandKwh(),
                b.getKwhAmount(),
                b.getEffectiveRate(),
                b.getAdditionalCharges(),
                b.getDeductions(),
                b.getNetAmount(),
                b.getBillingDate(),
                b.getServiceDateFrom(),
                b.getServiceDateTo(),
                b.getDueDate(),
                b.getMeterNumber(),
                b.getConsumerType(),
                b.getBillType(),
                b.getGenerationSystemCharge(),
                b.getTransmissionDeliveryChargeKW(),
                b.getTransmissionDeliveryChargeKWH(),
                b.getSystemLossCharge(),
                b.getDistributionDemandCharge(),
                b.getDistributionSystemCharge(),
                b.getSupplyRetailCustomerCharge(),
                b.getSupplySystemCharge(),
                b.getMeteringRetailCustomerCharge(),
                b.getMeteringSystemCharge(),
                b.getRFSC(),
                b.getLifelineRate(),
                b.getInterClassCrossSubsidyCharge(),
                b.getPPARefund(),
                b.getSeniorCitizenSubsidy(),
                b.getMissionaryElectrificationCharge(),
                b.getEnvironmentalCharge(),
                b.getStrandedContractCosts(),
                b.getNPCStrandedDebt(),
                b.getFeedInTariffAllowance(),
                b.getMissionaryElectrificationREDCI(),
                b.getGenerationVAT(),
                b.getTransmissionVAT(),
                b.getSystemLossVAT(),
                b.getDistributionVAT(),
                b.getRealPropertyTax(),
                b.getNotes(),
                b.getUserId(),
                b.getBilledFrom(),
                b.getAveragedCount(),
                b.getMergedToCollectible(),
                b.getOtherGenerationRateAdjustment(),
                b.getOtherTransmissionCostAdjustmentKW(),
                b.getOtherTransmissionCostAdjustmentKWH(),
                b.getOtherSystemLossCostAdjustment(),
                b.getOtherLifelineRateCostAdjustment(),
                b.getSeniorCitizenDiscountAndSubsidyAdjustment(),
                b.getFranchiseTax(),
                b.getBusinessTax(),
                b.getAdjustmentType(),
                b.getForm2307Amount(),
                b.getDeductedDeposit(),
                b.getExcessDeposit(),
                b.getIsUnlockedForPayment(),
                b.getUnlockedBy(),
                b.getEvat2Percent(),
                b.getEvat5Percent(),
                b.getAdjustmentNumber(),
                b.getAdjustedBy(),
                b.getDateAdjusted(),
                b.getForCancellation(),
                b.getCancelRequestedBy(),
                b.getCancelApprovedBy(),
                b.getKatasNgVat(),
                b.getSolarImportPresent(),
                b.getSolarImportPrevious(),
                b.getSolarExportPresent(),
                b.getSolarExportPrevious(),
                b.getSolarImportKwh(),
                b.getSolarExportKwh(),
                b.getGenerationChargeSolarExport(),
                b.getSolarResidualCredit(),
                b.getSolarDemandChargeKW(),
                b.getSolarDemandChargeKWH(),
                b.getSolarRetailCustomerCharge(),
                b.getSolarSupplySystemCharge(),
                b.getSolarMeteringRetailCharge(),
                b.getSolarMeteringSystemCharge(),
                b.getItem1(),
                b.getItem2(),
                b.getItem3(),
                b.getItem4(),
                b.getItem5(),
                null, // or number
                null, // or date
                null, // surcharges
                null, // bapa discount
                null //prepayments
            );
            
            return cb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<DCRSummaryTransactions> getARDCR(Connection con, String teller, String day) {
        try {
            List<DCRSummaryTransactions> dcrList = new ArrayList<>();
            
            /**
             * AR CONSUMERS - 01
             */
            String sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '01%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("01" + teller + day, 
                        "140-142-50", 
                        null, "A/R-Consumers-Cadiz", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * AR CONSUMERS - 02
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '02%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("02" + teller + day, 
                        "140-142-20", 
                        null, "A/R-Consumers-E.B. Magalona", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * AR CONSUMERS - 03
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '03%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("03" + teller + day, 
                        "140-142-40", 
                        null, "A/R-Consumers-Manapla", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * AR CONSUMERS - 04
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '04%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("04" + teller + day, 
                        "140-142-30", 
                        null, "A/R-Consumers-Victorias", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * AR CONSUMERS - 05
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '05%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("05" + teller + day, 
                        "140-142-80", 
                        null, "A/R-Consumers-San Carlos", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * AR CONSUMERS - 06
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '06%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("06" + teller + day, 
                        "140-142-60", 
                        null, "A/R-Consumers-Sagay", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * AR CONSUMERS - 07
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '07%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("07" + teller + day, 
                        "140-142-70", 
                        null, "A/R-Consumers-Escalante", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * AR CONSUMERS - 08
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '08%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("08" + teller + day, 
                        "140-142-81", 
                        null, "A/R-Consumers-Calatrava", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * AR CONSUMERS - 09
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '09%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("09" + teller + day, 
                        "140-142-71", 
                        null, "A/R-Consumers-Toboso", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            return dcrList;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<DCRSummaryTransactions> getRPTandBusinessTaxDCR(Connection con, String teller, String day) {
        try {
            List<DCRSummaryTransactions> dcrList = new ArrayList<>();
            
            /**
             * RPT - 01
             */
            String sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '01%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("01" + teller + day, 
                        "140-143-05", 
                        null, "A/R-Consumers-Others-RPT CAO", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 02
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '02%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("02" + teller + day, 
                        "140-143-02", 
                        null, "A/R-Consumers-Others-RPT EBMAO", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 03
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '03%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("03" + teller + day, 
                        "140-143-04", 
                        null, "A/R-Consumers-Others-RPT MANAPLA", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 04
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '04%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("04" + teller + day, 
                        "140-143-03", 
                        null, "A/R-Consumers-Others-RPT VAO", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 05
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '05%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("05" + teller + day, 
                        "140-143-08", 
                        null, "A/R-Consumers-Others-RPT SCAO", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 06
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '06%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("06" + teller + day, 
                        "140-143-06", 
                        null, "A/R-Consumers-Others-RPT SAO", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 07
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '07%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("07" + teller + day, 
                        "140-143-07", 
                        null, "A/R-Cosumers-Others-RPT EAO", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 08
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '08%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("08" + teller + day, 
                        "140-143-18", 
                        null, "A/R-Consumers-Others-RPT CALATRAVA", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 09
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RealPropertyTax AS DECIMAL(13,2))) + SUM(TRY_CAST(BusinessTax AS DECIMAL(13,2))) + SUM(TRY_CAST(FranchiseTax AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '09%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("09" + teller + day, 
                        "140-143-17", 
                        null, "A/R-Consumers-Others-RPT TOBOSO", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            return dcrList;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<DCRSummaryTransactions> getTermedPaymentsDCR(Connection con, String teller, String day) {
        try {
            List<DCRSummaryTransactions> dcrList = new ArrayList<>();
            
            /**
             * RPT - 01
             */
            String sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '01%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("01" + teller + day, 
                        "140-142-67", 
                        null, "A/R Plan of Payment - Cadiz", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 02
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '02%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("02" + teller + day, 
                        "140-142-64", 
                        null, "A/R Plan of Payment - EB Magalona", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 03
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '03%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("03" + teller + day, 
                        "140-142-66", 
                        null, "A/R Plan of Payment - Manapla", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 04
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '04%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("04" + teller + day, 
                        "140-142-65", 
                        null, "A/R Plan of Payment - Victorias", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 05
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '05%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("05" + teller + day, 
                        "140-142-75", 
                        null, "A/R Plan of Payment - San Carlos", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 06
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '06%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("06" + teller + day, 
                        "140-142-77", 
                        null, "A/R Plan of Payment - Sagay", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 07
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '07%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("07" + teller + day, 
                        "140-142-68", 
                        null, "A/R Plan of Payment - Escalante", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 08
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '08%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("08" + teller + day, 
                        "140-142-76", 
                        null, "A/R Plan of Payment - Calatrava", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
             * RPT - 09
             */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(AdditionalCharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "' \n" +
                "AND AccountNumber LIKE '09%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("09" + teller + day, 
                        "140-142-69", 
                        null, "A/R Plan of Payment - Toboso", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            return dcrList;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<DCRSummaryTransactions> getOtherPowerBillDcr(Connection con, String teller, String day) {
        try {
            List<DCRSummaryTransactions> dcrList = new ArrayList<>();
            
            /**
            * NPC STRANDED DEBT
            */
            String sql = "SELECT \n" +
                "(SUM(TRY_CAST(NPCStrandedDebt AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("102" + teller + day, 
                        "140-142-87", 
                        null, "A/R-Consumers - UC-NPC Stranded Debt", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * STRANDED CONTRACT COSTS
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(StrandedContractCosts AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("102" + teller + day, 
                        "140-142-92", 
                        null, "A/R-Consumers - UC-SCC", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * FIT ALL
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(FeedInTariffAllowance AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("103" + teller + day, 
                        "140-142-88", 
                        null, "A/R-Consumers - UC-ME - FIT-ALL", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * REDCI
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(MissionaryElectrificationREDCI AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-142-89", 
                        null, "A/R-Consumers - UC-ME - REDCI", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * GENVAT
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationVAT AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-142-94", 
                        null, "A/R - VAT Genco", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * TRANS VAT
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(TransmissionVAT AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-142-95", 
                        null, "A/R - VAT Transco", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * SYSTEM LOSS VAT
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(SystemLossVAT AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-142-96", 
                        null, "A/R - VAT Systems Loss", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * DIST VAT
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(DistributionVAT AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-142-97", 
                        null, "A/R - VAT Distn/Others", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * UCME VAT
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(MissionaryElectrificationCharge AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-142-98", 
                        null, "A/R - Consumers - UC-ME", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * ENVIRONMENTAL
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(EnvironmentalCharge AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-142-99", 
                        null, "A/R - Consumers - UC-EC", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * RFSC
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(RFSC AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-142-93", 
                        null, "A/R-Consumers- RFSC", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * EVAT 2%
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(Evat2Percent AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-160-00", 
                        null, "EWT 2%", 
                        "-" + ObjectHelpers.doubleFromString(rs.getString("Amount")), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * EVAT 5%
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(Evat5Percent AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "140-180-00", 
                        null, "CWVAT 5%", 
                        "-" + ObjectHelpers.doubleFromString(rs.getString("Amount")), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * NET METERING COMMERCIAL SALES
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(SolarDemandChargeKW AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SolarDemandChargeKWH AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SolarRetailCustomerCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SolarSupplySystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SolarMeteringRetailCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SolarMeteringSystemCharge AS DECIMAL(13,2))) + \n" +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "311-442-00", 
                        null, "Commercial Sales", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * NET METERING SOLAR GENERATION EXPORTED
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(GenerationChargeSolarExport AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "412-555-00", 
                        null, "Purchased Power", 
                        "-" + ObjectHelpers.doubleFromString(rs.getString("Amount")), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * SURCHARGES
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(Surcharges AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "312-450-00", 
                        null, "Surcharge/Interest", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * TERMED PAYMENT / DEPOSIT
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(Prepayment AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("104" + teller + day, 
                        "223-235-20", 
                        null, "Consumers Deposit-Bills - Solar", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            /**
            * BAPA DISCOUNTS
            */
            sql = "SELECT \n" +
                "(SUM(TRY_CAST(BAPADiscount AS DECIMAL(13,2)))) AS Amount \n" +
                "FROM Cashier_Bills \n" +
                "WHERE UserId='" + teller + "' \n" +
                "AND ORDate='" + day + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                dcrList.add(new DCRSummaryTransactions("108" + teller + day, 
                        "312-452-00", 
                        null, "Prompt Payment Discount", 
                        rs.getString("Amount"), 
                        day, 
                        null, null, null, null, null, null, null, null, null, null));
            }
            
            return dcrList;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<DCRSummaryTransactions> getOtherDCR(Connection con, String teller, String day) {
        try {
            List<DCRSummaryTransactions> dcr = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT GLCode, "
                    + "(SELECT Notes FROM Cashier_AccountGLCodes WHERE AccountCode=Cashier_DCRSummaryTransactions.GLCode) AS Description,"
                    + "SUM(TRY_CAST(Amount AS DECIMAL(25,2))) AS Amount "
                    + "FROM Cashier_DCRSummaryTransactions WHERE Day=? AND Teller=? AND Source='MISCELLANEOUS' "
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
}
