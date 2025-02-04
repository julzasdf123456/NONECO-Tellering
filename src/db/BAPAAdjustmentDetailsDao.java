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
import pojos.BAPAAdjustmentDetails;

/**
 *
 * @author Julio Lopez
 */
public class BAPAAdjustmentDetailsDao {
    public static List<BAPAAdjustmentDetails> getAdjustedBapaConsumers(Connection con, String bapaName, String period) {
        try {
            List<BAPAAdjustmentDetails> consumers = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT sa.id AS AccountNumber, sa.ServiceAccountName, sa.AccountStatus, "
                    + "sa.OldAccountNo, b.KwhUsed, b.ServicePeriod, b.id as BillId, b.BillNumber, b.NetAmount, cb.*"
                    + " FROM Cashier_BAPAAdjustmentDetails cb LEFT JOIN Billing_Bills b ON cb.BillId=b.id " +
                        "LEFT JOIN Billing_ServiceAccounts sa ON sa.id=cb.AccountNumber " +
                        "WHERE cb.ServicePeriod = '" + period + "' AND sa.OrganizationParentAccount='" + bapaName + "' " +
                        "AND b.AccountNumber NOT IN (SELECT AccountNumber FROM Cashier_PaidBills WHERE AccountNumber=b.AccountNumber AND ServicePeriod=b.ServicePeriod AND AccountNumber IS NOT NULL AND (Status IS NULL OR Status='Application')) ORDER BY sa.OldAccountNo"
                    );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                consumers.add(new BAPAAdjustmentDetails(
                        rs.getString("id"),
                        rs.getString("AccountNumber"),
                        rs.getString("OldAccountNo"),
                        rs.getString("ServiceAccountName"),
                        rs.getString("AccountStatus"),
                        rs.getString("BillNumber"),
                        rs.getString("NetAmount"),
                        rs.getString("KwhUsed"),
                        rs.getString("BillId"),
                        rs.getString("DiscountPercentage"),
                        rs.getString("DiscountAmount"),
                        bapaName,
                        rs.getString("ServicePeriod"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")                        
                ));
            }
            return consumers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
