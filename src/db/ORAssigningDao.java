/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojos.ORAssigning;

/**
 *
 * @author Julio Lopez
 */
public class ORAssigningDao {
    private static String orAssigningTableName = "Cashier_ORAssigning";
    
    public static ORAssigning getCurrentOR(Connection con, String userid) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT TOP 1 * FROM " + orAssigningTableName + " WHERE UserId=? ORDER BY created_at DESC, ORNumber DESC");
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ORAssigning oRAssigning = new ORAssigning(
                        rs.getString("id"),
                        rs.getString("ORNumber"),
                        rs.getString("UserId"),
                        rs.getString("DateAssigned"),
                        rs.getString("IsSetManually"),
                        rs.getString("TimeAssigned"),
                        rs.getString("Office"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
                
                ps.close();
                rs.close();
                return oRAssigning;
            }
            
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean insert(Connection con, ORAssigning oRAssigning) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cashier_ORAssigning(id, ORNumber, UserId, DateAssigned, IsSetManually, TimeAssigned, Office, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, oRAssigning.getId());
            ps.setString(2, oRAssigning.getORNumber());
            ps.setString(3, oRAssigning.getUserId());
            ps.setString(4, oRAssigning.getDateAsigned());
            ps.setString(5, oRAssigning.getIsSetManuall());
            ps.setString(6, oRAssigning.getTimeAssigned());
            ps.setString(7, oRAssigning.getOffice());
            ps.setString(8, oRAssigning.getCreated_at());
            ps.setString(9, oRAssigning.getUpdated_at());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
