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
import pojos.OCLMonthly;

/**
 *
 * @author Julio Lopez
 */
public class OCLMonthlyDao {
    public static OCLMonthly getOne(Connection con, String period, String accountNumber) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  Billing_ArrearsLedgerDistribution WHERE AccountNumber = ? AND ServicePeriod = ?");
            ps.setString(1, accountNumber);
            ps.setString(2, period);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                OCLMonthly ocl = new OCLMonthly(
                        rs.getString("id"),
                        rs.getString("AccountNumber"),
                        rs.getString("ServicePeriod"),
                        rs.getString("Amount"),
                        rs.getString("IsBilled"),
                        rs.getString("IsPaid"),
                        rs.getString("LinkedBillNumber"),
                        rs.getString("Notes"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
                
                ps.close();
                rs.close();
                return ocl;
            }
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean setOclPaid(Connection con, String oclId) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Billing_ArrearsLedgerDistribution SET IsPaid='Yes' WHERE id=?");
            ps.setString(1, oclId);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<OCLMonthly> getOclList(Connection con, String accountNo) {
        try {
            List<OCLMonthly> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  Billing_ArrearsLedgerDistribution WHERE AccountNumber = ? AND IsPaid IS NULL ORDER BY ServicePeriod");
            ps.setString(1, accountNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OCLMonthly(
                    rs.getString("id"),
                    rs.getString("AccountNumber"),
                    rs.getString("ServicePeriod"),
                    rs.getString("Amount"),
                    rs.getString("IsBilled"),
                    rs.getString("IsPaid"),
                    rs.getString("LinkedBillNumber"),
                    rs.getString("Notes"),
                    rs.getString("created_at"),
                    rs.getString("updated_at")
                ));
            }            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
