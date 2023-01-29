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
import pojos.ParticularPaymentTransactions;

/**
 *
 * @author Julio Lopez
 */
public class ParticularPaymentTransactionsDao {
    public static List<ParticularPaymentTransactions> getPaymentParticulars(Connection con, String svcId) {
        try {
            List<ParticularPaymentTransactions> payments = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT t.*, p.Particular AS ParticularName, p.AccountNumber FROM CRM_ServiceConnectionParticularPaymentsTransactions t "
                    + "LEFT JOIN CRM_ServiceConnectionPaymentParticulars p ON t.Particular=p.id "
                    + "WHERE t.ServiceConnectionId=? AND (Vat IS NULL OR Vat='0.00')");
            ps.setString(1, svcId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ParticularPaymentTransactions payment = new ParticularPaymentTransactions(
                        rs.getString("id"),
                        rs.getString("ServiceConnectionId"),
                        rs.getString("Particular"),
                        rs.getString("Amount"),
                        rs.getString("Vat"),
                        rs.getString("Total"),
                        rs.getString("created_at"),
                        rs.getString("updated_at"),
                        rs.getString("ParticularName"),
                        rs.getString("AccountNumber")
                );
                payments.add(payment);
            }
            return payments;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void updateParticulars(Connection con, String svcId, String orno) {
        try {
            String query = "UPDATE CRM_ServiceConnectionParticularPaymentsTransactions SET Vat=?, updated_at=? WHERE Vat IS NULL AND ServiceConnectionId=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, orno);
            ps.setString(2, ObjectHelpers.getCurrentTimestamp());
            ps.setString(3, svcId);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
