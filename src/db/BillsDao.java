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

/**
 *
 * @author Julio Lopez
 */
public class BillsDao {
    private static String billsTableName = "Billing_Bills";
    private static String paidBillsTableName = "Cashier_PaidBills";
    
    public static List<Bills> getUnpaidBillsFromAccountId(Connection con, String accountId) {
        try {
            List<Bills> billsList = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + billsTableName + 
                    " WHERE AccountNumber=? AND id NOT IN (SELECT ObjectSourceId FROM " + paidBillsTableName + " WHERE AccountNumber=? AND Status IS NULL) ORDER BY ServicePeriod DESC");
            ps.setString(1, accountId);
            ps.setString(2, accountId);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                billsList.add(
                        new Bills(
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
                            rs.getString("CancelApprovedBy")
                        )
                );
            }
            
            return billsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Bills getOneById(Connection con, String id) {
        try {
            Bills bill;
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Bills WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bill = new Bills(
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
                        rs.getString("CancelApprovedBy")
                );
                ps.close();
                rs.close();
                return bill;
            }
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAccountType(String acctType) {
        try {
            if (acctType.equals("RURAL RESIDENTIAL") || acctType.equals("RESIDENTIAL RURAL")) {
                return "RESIDENTIAL";
            } else {
                return acctType;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "RESIDENTIAL";
        }
    }
    
    public static double getSurcharge(Bills bill) {
        try {
            if (getAccountType(bill.getConsumerType()).equals("RESIDENTIAL")) {
                return 0;
            } else {
                if (ObjectHelpers.isAfterDue(bill)) {
                    return Double.valueOf(bill.getNetAmount()) * .05;
                } else {
                    return 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
