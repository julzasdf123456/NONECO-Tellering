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
import pojos.Login;
import pojos.ServiceAccounts;

/**
 *
 * @author Julio Lopez
 */
public class TicketsDao {
    public static void createReconnection(Connection con, ServiceAccounts accounts, Login login, String office) {
        try {
            String mtr = "SELECT * FROM Billing_Meters WHERE ServiceAccountId=? ORDER BY created_at DESC";
            PreparedStatement psMtr = con.prepareStatement(mtr);
            psMtr.setString(1, accounts.getId());
            ResultSet rsMtr = psMtr.executeQuery();
            String meterNo = "", meterBrand = "";
            if (rsMtr.next()) {
                meterNo = rsMtr.getString("SerialNumber");
                meterBrand = rsMtr.getString("Brand");
            } else {
                meterNo = "-";
                meterBrand = "-";
            }
            
            String sql = "INSERT INTO CRM_Tickets(id, AccountNumber, ConsumerName, Town, Barangay, Sitio, Ticket, Reason, GeoLocation, Status, UserId, Office, created_at, updated_at, CurrentMeterNo, CurrentMeterBrand) VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            String id = ObjectHelpers.generateIDandRandString();
            
            ps.setString(1, id);
            ps.setString(2, accounts.getId());
            ps.setString(3, accounts.getServiceAccountName());
            ps.setString(4, accounts.getTownCode());
            ps.setString(5, accounts.getMigrated());
            ps.setString(6, accounts.getPurok());
            ps.setString(7, "1668541254428");
            ps.setString(8, "Delinquency");
            ps.setString(9, accounts.getLatitude() + "," + accounts.getLongitude());
            ps.setString(10, "Received");
            ps.setString(11, login.getId());
            ps.setString(12, office);
            ps.setString(13, ObjectHelpers.getCurrentTimestamp());
            ps.setString(14, ObjectHelpers.getCurrentTimestamp());
            ps.setString(15, meterNo);
            ps.setString(16, meterBrand);
            
            ps.execute();
            
            ps.clearParameters();            
            
            String logs = "INSERT INTO CRM_TicketLogs (id, TicketId, Log, LogDetails, UserId) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(logs);
            ps.setString(1, ObjectHelpers.generateIDandRandString());
            ps.setString(2, id);
            ps.setString(3, "Ticket Filed");
            ps.setString(4, "Ticket automatically created via Reconnection Payment Module");
            ps.setString(5, login.getId());
            ps.execute();
            
            ps.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
