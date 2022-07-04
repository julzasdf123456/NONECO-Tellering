/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.ConfigFileHelpers;
import helpers.Notifiers;
import java.sql.Connection;
import java.sql.DriverManager;
import pojos.Server;

/**
 *
 * @author Julio Lopez
 */
public class DatabaseConnection {
    private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    Connection databaseConnection= null;
    
    public DatabaseConnection() {
        
    }
    
    public Connection getDbConnectionFromDatabase(Server server) {
        try {
           String url = "jdbc:sqlserver://" + server.getServerName()+ ":1433;DatabaseName=" + server.getDatabase()+ ";user=" + server.getUsername() + ";password=" + server.getPassword() + ";encrypt=true;trustServerCertificate=true;useBulkCopyForBatchInsert=true;";
           
           Class.forName(jdbcDriver).newInstance();
           
           databaseConnection = (Connection) DriverManager.getConnection(url);
           
           System.out.println("Connected to " + server.getServerName());
           
           return databaseConnection;
        } catch (Exception err) {
           System.out.println("Not Connected");
           err.printStackTrace();
           Notifiers.showErrorMessage("Database Connection Error", err.getMessage());
           return null;
        }
    }  

    public Connection getDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseConnection(Connection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    
    
}
