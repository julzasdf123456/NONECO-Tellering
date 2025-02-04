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
import pojos.AccountPayables;

/**
 *
 * @author Julio Lopez
 */
public class AccountPayablesDao {
    public static List<AccountPayables> getPayables(Connection con) {
        try {
            List<AccountPayables> payablesList = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_AccountPayables ORDER BY AccountTitle");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                payablesList.add(new AccountPayables(
                        rs.getString("id"),
                        rs.getString("AccountCode"),
                        rs.getString("AccountTitle"),
                        rs.getString("AccountDescription"),
                        rs.getString("DefaultAmount"),
                        rs.getString("VATPercentage"),
                        rs.getString("Notes"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                ));
            }
            
            return payablesList;
        } catch  (Exception e) {
            e.printStackTrace();
            return null;
        }                
    }
    
    public static List<AccountPayables> searchPayable(Connection con, String regex) {
        try {
            List<AccountPayables> payablesList = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_AccountPayables WHERE AccountCode LIKE '%" + regex + "%' OR AccountTitle LIKE '%" + regex + "%' ORDER BY AccountTitle");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                payablesList.add(new AccountPayables(
                        rs.getString("id"),
                        rs.getString("AccountCode"),
                        rs.getString("AccountTitle"),
                        rs.getString("AccountDescription"),
                        rs.getString("DefaultAmount"),
                        rs.getString("VATPercentage"),
                        rs.getString("Notes"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                ));
            }
            
            return payablesList;
        } catch  (Exception e) {
            e.printStackTrace();
            return null;
        }                
    }
    
    /**
    public static List<AccountPayables> getPayables(Connection con) {
        try {
            List<AccountPayables> payablesList = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT g.id, g.AccountCode, g.Notes, p.AccountDescription, p.DefaultAmount, p.VATPercentage, p.Notes, p.created_at, p.updated_at"
                    + " FROM Cashier_AccountGLCodes g "
                    + "LEFT JOIN Cashier_AccountPayables p ON g.AccountCode=p.AccountCode ORDER BY g.Notes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                payablesList.add(new AccountPayables(
                        rs.getString("id"),
                        rs.getString("AccountCode"),
                        rs.getString("Notes"),
                        rs.getString("AccountDescription"),
                        rs.getString("DefaultAmount"),
                        rs.getString("VATPercentage"),
                        rs.getString("Notes"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                ));
            }
            
            return payablesList;
        } catch  (Exception e) {
            e.printStackTrace();
            return null;
        }                
    }
    
    public static List<AccountPayables> searchPayable(Connection con, String regex) {
        try {
            List<AccountPayables> payablesList = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT g.id, g.AccountCode, g.Notes, p.AccountDescription, p.DefaultAmount, p.VATPercentage, p.Notes, p.created_at, p.updated_at"
                    + " FROM Cashier_AccountGLCodes g "
                    + "LEFT JOIN Cashier_AccountPayables p ON g.AccountCode=p.AccountCode WHERE g.AccountCode LIKE '%" + regex + "%' OR g.Notes LIKE '%" + regex + "%' ORDER BY g.Notes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                payablesList.add(new AccountPayables(
                        rs.getString("id"),
                        rs.getString("AccountCode"),
                        rs.getString("Notes"),
                        rs.getString("AccountDescription"),
                        rs.getString("DefaultAmount"),
                        rs.getString("VATPercentage"),
                        rs.getString("Notes"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                ));
            }
            
            return payablesList;
        } catch  (Exception e) {
            e.printStackTrace();
            return null;
        }                
    }
    **/
}
