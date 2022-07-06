/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojos.BillOfMaterialsSummary;

/**
 *
 * @author Julio Lopez
 */
public class BillOfMaterialsSummaryDao {
    public static BillOfMaterialsSummary getOne(Connection con, String svcId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM CRM_BillsOfMaterialsSummary WHERE ServiceConnectionId = ?");
            ps.setString(1, svcId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BillOfMaterialsSummary bs = new BillOfMaterialsSummary(
                        rs.getString("id"),
                        rs.getString("ServiceConnectionId"),
                        rs.getString("ExcludeTransformerLaborCost"),
                        rs.getString("TransformerChangedPrice"),
                        rs.getString("MonthDuration"),
                        rs.getString("TransformerLaborCostPercentage"),
                        rs.getString("MaterialLaborCostPercentage"),
                        rs.getString("HandlingCostPercentage"),
                        rs.getString("SubTotal"),
                        rs.getString("LaborCost"),
                        rs.getString("HandlingCost"),
                        rs.getString("Total"),
                        rs.getString("TotalVAT"),
                        rs.getString("TransformerLaborCost"),
                        rs.getString("MaterialLaborCost"),
                        rs.getString("TransformerTotal"),
                        rs.getString("IsPaid"),
                        rs.getString("ORNumber"),
                        rs.getString("ORDate"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
                
                ps.close();
                rs.close();
                return bs;
            }
            
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean updateOr(Connection con, BillOfMaterialsSummary summary) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE CRM_BillsOfMaterialsSummary SET ORNumber=?, ORDate=?, IsPaid='Yes' WHERE ServiceConnectionId=?");
            ps.setString(1, summary.getORNumber());
            ps.setString(2, summary.getORDate());
            ps.setString(3, summary.getServiceConnectionId());
            
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
