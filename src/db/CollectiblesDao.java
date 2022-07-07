/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojos.Collectibles;

/**
 *
 * @author Julio Lopez
 */
public class CollectiblesDao {
    public static Collectibles getOne(Connection con, String AccountNumber) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Collectibles WHERE AccountNumber=?");
            ps.setString(1, AccountNumber);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Collectibles collectible = new Collectibles(
                        rs.getString("id"),
                        rs.getString("AccountNumber"),
                        rs.getString("Balance"),
                        rs.getString("Notes"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
                
                ps.close();
                rs.close();
                return collectible;
            }
            
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean updateCollectible(Connection con, String accountNo, String balance) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Billing_Collectibles SET Balance=? WHERE AccountNumber=?");
            ps.setString(1, balance);
            ps.setString(2, accountNo);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
