/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pojos.CheckPayments;

/**
 *
 * @author Julio Lopez
 */
public class PaidBillDetailsDao {
    public static boolean insert(Connection con, CheckPayments details) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_PaidBillsDetails(id, AccountNumber, ServicePeriod, BillId, ORNumber, Amount, PaymentUsed, CheckNo, Bank, CheckExpiration, UserId, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, details.getId());
            ps.setString(2, details.getAccountNumber());
            ps.setString(3, details.getServicePeriod());
            ps.setString(4, details.getBillId());
            ps.setString(5, details.getORNumber());
            ps.setString(6, details.getAmount());
            ps.setString(7, details.getPaymentUsed());
            ps.setString(8, details.getCheckNo());
            ps.setString(9, details.getBank());
            ps.setString(10, details.getCheckExpiration());
            ps.setString(11, details.getUserId());
            ps.setString(12, details.getCreated_at());
            ps.setString(13, details.getUpdated_at());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception  e) {
            e.printStackTrace();
            return false;
        }
    }
}
