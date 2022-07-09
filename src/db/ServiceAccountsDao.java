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
import pojos.ServiceAccounts;

/**
 *
 * @author Julio Lopez
 */
public class ServiceAccountsDao {
    
    private static String accountsTableName = "Billing_ServiceAccounts";
    private static String townsTableName = "CRM_Towns";
    private static String barangaysTableName = "CRM_Barangays";
    
    public static ServiceAccounts getOneByOldAccountNumber(Connection con, String oldAccountNo) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT " + accountsTableName + ".*, " + townsTableName + ".Town as TownName, " + barangaysTableName + ".Barangay as BarangayName, "
                    + "(SELECT TOP 1 SerialNumber FROM Billing_Meters WHERE ServiceAccountId=" + accountsTableName + ".id ORDER BY created_at DESC) AS MeterNumber "
                    + "FROM " 
                    + accountsTableName + " LEFT JOIN " + 
                    townsTableName + " ON " + accountsTableName + ".Town = " + townsTableName + ".id LEFT JOIN " +
                    barangaysTableName + " ON " + accountsTableName + ".Barangay = " + barangaysTableName + ".id " +
                    "WHERE OldAccountNo=?");
            ps.setString(1, oldAccountNo);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                ServiceAccounts account = new ServiceAccounts(
                    rs.getString("id"),
                    rs.getString("ServiceAccountName"),
                    rs.getString("TownName"),
                    rs.getString("BarangayName"),
                    rs.getString("Purok"),
                    rs.getString("AccountType"),
                    rs.getString("AccountStatus"),
                    rs.getString("ContactNumber"),
                    rs.getString("EmailAddress"),
                    rs.getString("ServiceConnectionId"),
                    rs.getString("MeterNumber"),
                    rs.getString("TransformerDetailsId"),
                    rs.getString("PoleNumber"),
                    rs.getString("AreaCode"),
                    rs.getString("BlockCode"),
                    rs.getString("SequenceCode"),
                    rs.getString("Feeder"),
                    rs.getString("ComputeType"),
                    rs.getString("Organization"),
                    rs.getString("OrganizationParentAccount"),
                    rs.getString("GPSMeter"),
                    rs.getString("OldAccountNo"),
                    rs.getString("UserId"),
                    rs.getString("MeterReader"),
                    rs.getString("GroupCode"),
                    rs.getString("ForDistribution"),
                    rs.getString("Multiplier"),
                    rs.getString("Coreloss"),
                    rs.getString("Main"),
                    rs.getString("Evat5Percent"),
                    rs.getString("Ewt2Percent"),
                    rs.getString("AccountCount"),
                    rs.getString("ConnectionDate"),
                    rs.getString("LatestReadingDate"),
                    rs.getString("DateDisconnected"),
                    rs.getString("DateTransfered"),
                    rs.getString("SeniorCitizen"),
                    rs.getString("AccountPaymentType"),
                    rs.getString("Latitude"),
                    rs.getString("Longitude"),
                    rs.getString("AccountRetention"),
                    rs.getString("AccountExpiration"),
                    rs.getString("DurationInMonths"),
                    rs.getString("Contestable"),
                    rs.getString("NetMetered"),
                    rs.getString("Notes"),
                    rs.getString("Migrated"),
                    rs.getString("MemberConsumerId"),
                    rs.getString("DistributionAccountCode"),
                    rs.getString("Town")
                );

                ps.close();
                rs.close();
                return account;
            }

            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ServiceAccounts getOneById(Connection con, String id) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT " + accountsTableName + ".*, " + townsTableName + ".Town as TownName, " + barangaysTableName + ".Barangay as BarangayName, "
                    + "(SELECT TOP 1 SerialNumber FROM Billing_Meters WHERE ServiceAccountId=" + accountsTableName + ".id ORDER BY created_at DESC) AS MeterNumber "
                    + " FROM " 
                    + accountsTableName + " LEFT JOIN " + 
                    townsTableName + " ON " + accountsTableName + ".Town = " + townsTableName + ".id LEFT JOIN " +
                    barangaysTableName + " ON " + accountsTableName + ".Barangay = " + barangaysTableName + ".id " +
                    "WHERE " + accountsTableName + ".id=?");
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                ServiceAccounts account = new ServiceAccounts(
                    rs.getString("id"),
                    rs.getString("ServiceAccountName"),
                    rs.getString("TownName"),
                    rs.getString("BarangayName"),
                    rs.getString("Purok"),
                    rs.getString("AccountType"),
                    rs.getString("AccountStatus"),
                    rs.getString("ContactNumber"),
                    rs.getString("EmailAddress"),
                    rs.getString("ServiceConnectionId"),
                    rs.getString("MeterNumber"),
                    rs.getString("TransformerDetailsId"),
                    rs.getString("PoleNumber"),
                    rs.getString("AreaCode"),
                    rs.getString("BlockCode"),
                    rs.getString("SequenceCode"),
                    rs.getString("Feeder"),
                    rs.getString("ComputeType"),
                    rs.getString("Organization"),
                    rs.getString("OrganizationParentAccount"),
                    rs.getString("GPSMeter"),
                    rs.getString("OldAccountNo"),
                    rs.getString("UserId"),
                    rs.getString("MeterReader"),
                    rs.getString("GroupCode"),
                    rs.getString("ForDistribution"),
                    rs.getString("Multiplier"),
                    rs.getString("Coreloss"),
                    rs.getString("Main"),
                    rs.getString("Evat5Percent"),
                    rs.getString("Ewt2Percent"),
                    rs.getString("AccountCount"),
                    rs.getString("ConnectionDate"),
                    rs.getString("LatestReadingDate"),
                    rs.getString("DateDisconnected"),
                    rs.getString("DateTransfered"),
                    rs.getString("SeniorCitizen"),
                    rs.getString("AccountPaymentType"),
                    rs.getString("Latitude"),
                    rs.getString("Longitude"),
                    rs.getString("AccountRetention"),
                    rs.getString("AccountExpiration"),
                    rs.getString("DurationInMonths"),
                    rs.getString("Contestable"),
                    rs.getString("NetMetered"),
                    rs.getString("Notes"),
                    rs.getString("Migrated"),
                    rs.getString("MemberConsumerId"),
                    rs.getString("DistributionAccountCode"),
                    rs.getString("Town")
                );

                ps.close();
                rs.close();
                return account;
            }

            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<ServiceAccounts> search(Connection con, String regex) {
        try {
            List<ServiceAccounts> serviceAccountses = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT " + accountsTableName + ".*, " + townsTableName + ".Town as TownName, " + barangaysTableName + ".Barangay as BarangayName FROM " 
                    + accountsTableName + " LEFT JOIN " + 
                    townsTableName + " ON " + accountsTableName + ".Town = " + townsTableName + ".id LEFT JOIN " +
                    barangaysTableName + " ON " + accountsTableName + ".Barangay = " + barangaysTableName + ".id " +
                    "WHERE OldAccountNo LIKE '%" + regex + "%' OR " + accountsTableName + ".id LIKE '%" + regex + "%' OR ServiceAccountName LIKE '%" + regex + "%'");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ServiceAccounts account = new ServiceAccounts(
                    rs.getString("id"),
                    rs.getString("ServiceAccountName"),
                    rs.getString("TownName"),
                    rs.getString("BarangayName"),
                    rs.getString("Purok"),
                    rs.getString("AccountType"),
                    rs.getString("AccountStatus"),
                    rs.getString("ContactNumber"),
                    rs.getString("EmailAddress"),
                    rs.getString("ServiceConnectionId"),
                    rs.getString("MeterDetailsId"),
                    rs.getString("TransformerDetailsId"),
                    rs.getString("PoleNumber"),
                    rs.getString("AreaCode"),
                    rs.getString("BlockCode"),
                    rs.getString("SequenceCode"),
                    rs.getString("Feeder"),
                    rs.getString("ComputeType"),
                    rs.getString("Organization"),
                    rs.getString("OrganizationParentAccount"),
                    rs.getString("GPSMeter"),
                    rs.getString("OldAccountNo"),
                    rs.getString("UserId"),
                    rs.getString("MeterReader"),
                    rs.getString("GroupCode"),
                    rs.getString("ForDistribution"),
                    rs.getString("Multiplier"),
                    rs.getString("Coreloss"),
                    rs.getString("Main"),
                    rs.getString("Evat5Percent"),
                    rs.getString("Ewt2Percent"),
                    rs.getString("AccountCount"),
                    rs.getString("ConnectionDate"),
                    rs.getString("LatestReadingDate"),
                    rs.getString("DateDisconnected"),
                    rs.getString("DateTransfered"),
                    rs.getString("SeniorCitizen"),
                    rs.getString("AccountPaymentType"),
                    rs.getString("Latitude"),
                    rs.getString("Longitude"),
                    rs.getString("AccountRetention"),
                    rs.getString("AccountExpiration"),
                    rs.getString("DurationInMonths"),
                    rs.getString("Contestable"),
                    rs.getString("NetMetered"),
                    rs.getString("Notes"),
                    rs.getString("Migrated"),
                    rs.getString("MemberConsumerId"),
                    rs.getString("DistributionAccountCode"),
                    rs.getString("Town")
                );
                serviceAccountses.add(account);
            }

            rs.close();
            ps.close();
            return serviceAccountses;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<String> bapaSearch(Connection con, String regex) {
        try {
            List<String> bapaList = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT OrganizationParentAccount FROM " + accountsTableName + 
                    " WHERE OrganizationParentAccount LIKE '%" + regex + "%' GROUP BY OrganizationParentAccount");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                bapaList.add(rs.getString("OrganizationParentAccount"));
            }
            return bapaList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getAddress (ServiceAccounts account) {
        try {
            String address = "";
            
            if (account.getBarangay() != null) {
                address = account.getPurok() + ", " + account.getBarangay() + ", " + account.getTown();
            } else {
                address = account.getPurok() + ", " + account.getTown();
            }
            
            return address;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<ServiceAccounts> searchWithOcl(Connection con, String regex) {
        try {
            List<ServiceAccounts> serviceAccountses = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT " + accountsTableName + ".*, " + townsTableName + ".Town as TownName, " + barangaysTableName + ".Barangay as BarangayName FROM " 
                    + accountsTableName + " LEFT JOIN " + 
                    townsTableName + " ON " + accountsTableName + ".Town = " + townsTableName + ".id LEFT JOIN " +
                    barangaysTableName + " ON " + accountsTableName + ".Barangay = " + barangaysTableName + ".id " +
                    "WHERE OldAccountNo LIKE '%" + regex + "%' OR " + accountsTableName + ".id LIKE '%" + regex + "%' OR ServiceAccountName LIKE '%" + regex + "%' "
                            + "AND " + accountsTableName + ".id IN (SELECT AccountNumber FROM Billing_Collectibles)");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ServiceAccounts account = new ServiceAccounts(
                    rs.getString("id"),
                    rs.getString("ServiceAccountName"),
                    rs.getString("TownName"),
                    rs.getString("BarangayName"),
                    rs.getString("Purok"),
                    rs.getString("AccountType"),
                    rs.getString("AccountStatus"),
                    rs.getString("ContactNumber"),
                    rs.getString("EmailAddress"),
                    rs.getString("ServiceConnectionId"),
                    rs.getString("MeterDetailsId"),
                    rs.getString("TransformerDetailsId"),
                    rs.getString("PoleNumber"),
                    rs.getString("AreaCode"),
                    rs.getString("BlockCode"),
                    rs.getString("SequenceCode"),
                    rs.getString("Feeder"),
                    rs.getString("ComputeType"),
                    rs.getString("Organization"),
                    rs.getString("OrganizationParentAccount"),
                    rs.getString("GPSMeter"),
                    rs.getString("OldAccountNo"),
                    rs.getString("UserId"),
                    rs.getString("MeterReader"),
                    rs.getString("GroupCode"),
                    rs.getString("ForDistribution"),
                    rs.getString("Multiplier"),
                    rs.getString("Coreloss"),
                    rs.getString("Main"),
                    rs.getString("Evat5Percent"),
                    rs.getString("Ewt2Percent"),
                    rs.getString("AccountCount"),
                    rs.getString("ConnectionDate"),
                    rs.getString("LatestReadingDate"),
                    rs.getString("DateDisconnected"),
                    rs.getString("DateTransfered"),
                    rs.getString("SeniorCitizen"),
                    rs.getString("AccountPaymentType"),
                    rs.getString("Latitude"),
                    rs.getString("Longitude"),
                    rs.getString("AccountRetention"),
                    rs.getString("AccountExpiration"),
                    rs.getString("DurationInMonths"),
                    rs.getString("Contestable"),
                    rs.getString("NetMetered"),
                    rs.getString("Notes"),
                    rs.getString("Migrated"),
                    rs.getString("MemberConsumerId"),
                    rs.getString("DistributionAccountCode"),
                    rs.getString("Town")
                );
                serviceAccountses.add(account);
            }

            rs.close();
            ps.close();
            return serviceAccountses;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
