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
import pojos.PrepaymentBalance;

/**
 *
 * @author Julio Lopez
 */
public class PrepaymentBalanceDao {
    public static void insertOrUpdate(Connection con, String accountNo, String amount, String orNumber, pojos.Login login) {
        try {
            PreparedStatement ps;
            PrepaymentBalance pb = getOne(con, accountNo);
            if (pb != null) {
                // update
                double oldBalance = pb.getBalance() != null ? Double.valueOf(pb.getBalance()) : 0;
                double newBalance = oldBalance + (Double.valueOf(amount));
                ps = con.prepareStatement("UPDATE Billing_PrePaymentBalance SET Balance=?, updated_at=? WHERE AccountNumber=?");
                ps.setString(1, ObjectHelpers.roundTwoNoComma(newBalance + ""));
                ps.setString(2, ObjectHelpers.getCurrentTimestamp());
                ps.setString(3, accountNo);
                ps.execute();
                ps.clearParameters();
            } else {
                // create new
                ps = con.prepareStatement("INSERT INTO Billing_PrePaymentBalance (id, AccountNumber, Balance, created_at, updated_at) VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, ObjectHelpers.generateIDandRandString());
                ps.setString(2, accountNo);
                ps.setString(3, amount);
                ps.setString(4, ObjectHelpers.getCurrentTimestamp());
                ps.setString(5, ObjectHelpers.getCurrentTimestamp());
                ps.execute();
                ps.clearParameters();
            }
            
            // INSERT PREPAYMENT TRANSACTION HISTORY
            ps = con.prepareStatement("INSERT INTO Billing_PrePaymentTransactionHistory (id, AccountNumber, Method, Amount, UserId, ORNumber, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, ObjectHelpers.generateIDandRandString());
            ps.setString(2, accountNo);
            ps.setString(3, "DEPOSIT");
            ps.setString(4, amount);
            ps.setString(5, login.getId());
            ps.setString(6, orNumber);
            ps.setString(7, ObjectHelpers.getCurrentTimestamp());
            ps.setString(8, ObjectHelpers.getCurrentTimestamp());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static PrepaymentBalance getOne(Connection con, String accountNo) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_PrePaymentBalance WHERE AccountNumber=?");
            ps.setString(1, accountNo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                PrepaymentBalance pb = new PrepaymentBalance(
                        rs.getString("id"),
                        rs.getString("AccountNumber"),
                        rs.getString("Balance"),
                        rs.getString("Status"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
                rs.close();
                ps.close();
                return pb;
            }
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
