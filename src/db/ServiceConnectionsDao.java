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
import pojos.ServiceConnections;

/**
 *
 * @author Julio Lopez
 */
public class ServiceConnectionsDao {
    public static List<ServiceConnections> getQueue(Connection con) {
        try {
            List<ServiceConnections> serviceConnections = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT sc.*, t.Town as TownName, b.Barangay as BarangayName FROM CRM_ServiceConnections sc "
                    + "LEFT JOIN CRM_Towns t ON sc.Town=t.id LEFT JOIN CRM_Barangays b ON sc.Barangay=b.id "
                    + "WHERE sc.Status IN ('Approved', 'For Inspection') AND ORNumber IS NULL AND ORDate IS NULL AND Trash IS NULL ORDER BY sc.created_at DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ServiceConnections connection = new ServiceConnections(
                        rs.getString("id"),
                        rs.getString("MemberConsumerId"),
                        rs.getString("DateOfApplication"),
                        rs.getString("ServiceAccountName"),
                        rs.getString("AccountCount"),
                        rs.getString("Sitio"),
                        rs.getString("BarangayName"),
                        rs.getString("TownName"),
                        rs.getString("ContactNumber"),
                        rs.getString("EmailAddress"),
                        rs.getString("AccountType"),
                        rs.getString("AccountOrganization"),
                        rs.getString("OrganizationAccountNumber"),
                        rs.getString("IsNIHE"),
                        rs.getString("AccountApplicationType"),
                        rs.getString("ConnectionApplicationType"),
                        rs.getString("BuildingType"),
                        rs.getString("Status"),
                        rs.getString("Notes"),
                        rs.getString("Trash"),
                        rs.getString("ORNumber"),
                        rs.getString("ORDate"),
                        rs.getString("DateTimeLinemenArrived"),
                        rs.getString("DateTimeOfEnergization"),
                        rs.getString("EnergizationOrderIssued"),
                        rs.getString("DateTimeOfEnergizationIssue"),
                        rs.getString("StationCrewAssigned"),
                        rs.getString("LoadCategory"),
                        rs.getString("TemporaryDurationInMonths"),
                        rs.getString("LongSpan"),
                        rs.getString("Office"),
                        rs.getString("TypeOfOccupancy"),
                        rs.getString("ResidenceNumber"),
                        rs.getString("AccountNumber"),
                        rs.getString("Barangay"),
                        rs.getString("Town"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
                serviceConnections.add(connection);
            }
            return serviceConnections;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<ServiceConnections> getQueueSearch(Connection con, String regex, String office) {
        try {
            List<ServiceConnections> serviceConnections = new ArrayList<>();
            String query = "";
            if (regex.equals("") || regex.isEmpty()) {
                query = "SELECT sc.*, t.Town as TownName, b.Barangay as BarangayName FROM CRM_ServiceConnections sc "
                    + "LEFT JOIN CRM_Towns t ON sc.Town=t.id LEFT JOIN CRM_Barangays b ON sc.Barangay=b.id "
                    + "WHERE sc.Status IN ('Approved', 'For Inspection') AND Trash IS NULL AND sc.Office='" + office + "' AND "
                    + "sc.id IN (SELECT ServiceConnectionId FROM CRM_ServiceConnectionParticularPaymentsTransactions WHERE (Vat IS NULL OR Vat='0.00') GROUP BY ServiceConnectionId) "
                    + "ORDER BY sc.created_at DESC";
            } else {
                query = "SELECT sc.*, t.Town as TownName, b.Barangay as BarangayName FROM CRM_ServiceConnections sc "
                    + "LEFT JOIN CRM_Towns t ON sc.Town=t.id LEFT JOIN CRM_Barangays b ON sc.Barangay=b.id "
                    + "WHERE sc.ServiceAccountName LIKE '%" + regex + "%'"
                    + "AND sc.Status IN ('Approved', 'For Inspection') AND Trash IS NULL AND "
                    + "sc.id IN (SELECT ServiceConnectionId FROM CRM_ServiceConnectionParticularPaymentsTransactions WHERE (Vat IS NULL OR Vat='0.00') GROUP BY ServiceConnectionId) "
                    + "ORDER BY sc.created_at DESC";
            }
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ServiceConnections connection = new ServiceConnections(
                        rs.getString("id"),
                        rs.getString("MemberConsumerId"),
                        rs.getString("DateOfApplication"),
                        rs.getString("ServiceAccountName"),
                        rs.getString("AccountCount"),
                        rs.getString("Sitio"),
                        rs.getString("BarangayName"),
                        rs.getString("TownName"),
                        rs.getString("ContactNumber"),
                        rs.getString("EmailAddress"),
                        rs.getString("AccountType"),
                        rs.getString("AccountOrganization"),
                        rs.getString("OrganizationAccountNumber"),
                        rs.getString("IsNIHE"),
                        rs.getString("AccountApplicationType"),
                        rs.getString("ConnectionApplicationType"),
                        rs.getString("BuildingType"),
                        rs.getString("Status"),
                        rs.getString("Notes"),
                        rs.getString("Trash"),
                        rs.getString("ORNumber"),
                        rs.getString("ORDate"),
                        rs.getString("DateTimeLinemenArrived"),
                        rs.getString("DateTimeOfEnergization"),
                        rs.getString("EnergizationOrderIssued"),
                        rs.getString("DateTimeOfEnergizationIssue"),
                        rs.getString("StationCrewAssigned"),
                        rs.getString("LoadCategory"),
                        rs.getString("TemporaryDurationInMonths"),
                        rs.getString("LongSpan"),
                        rs.getString("Office"),
                        rs.getString("TypeOfOccupancy"),
                        rs.getString("ResidenceNumber"),
                        rs.getString("AccountNumber"),
                        rs.getString("Barangay"),
                        rs.getString("Town"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
                serviceConnections.add(connection);
            }
            return serviceConnections;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean updateOr(Connection con, String svcId, String orNumber, String orDate) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnections SET ORNumber=?, ORDate=? WHERE id=?");
            ps.setString(1, orNumber);
            ps.setString(2, orDate);
            ps.setString(3, svcId);
            
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateOrOnServiceConPayments(Connection con, String svcId, String orNumber) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE CRM_ServiceConnectionTotalPayments SET Notes=? WHERE ServiceConnectionId=?");
            ps.setString(1, orNumber);
            ps.setString(2, svcId);
            
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
