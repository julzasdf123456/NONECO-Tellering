/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import pojos.Server;

/**
 *
 * @author Julio Lopez
 */
public class ConfigFileHelpers {
    private static String SEPARATOR = File.separator;        
    public static String SERVER = System.getProperty("user.dir") + SEPARATOR + "config" + SEPARATOR + "server.txt";
    public static String ACTIVE_LOGIN = System.getProperty("user.dir") + SEPARATOR + "config" + SEPARATOR + "activelogin.txt";
    public static String OTHER_CONFIG = System.getProperty("user.dir") + SEPARATOR + "config" + SEPARATOR + "otherconfig.txt";
    public static String REPORTS_FOLDER = System.getProperty("user.dir") + SEPARATOR + "reports" + SEPARATOR;
    
    public static String OR_VIEW_URL = "http://" + getServerIp() + ":8000/transaction_indices/browse-ors-view/";
    public static String VIEW_ACCOUNT_URL = "http://" + getServerIp() + ":8000/serviceAccounts/";
    
    public static String getOffice () {
        try {
            String office = "";
            File file=new File(OTHER_CONFIG);    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line;  
            if((line=br.readLine())!=null) {   
                office = line;
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return office;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Office", e.getMessage());
            return null;
        }
    }
    
    public static String getOfficeCode () {
        try {
            String office = "";
            File file=new File(OTHER_CONFIG);    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line;  
            int i=0;
            while((line=br.readLine())!=null) {  
                if (i==1) {
                    office = line;
                }                
                i++;
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return office;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Office", e.getMessage());
            return null;
        }
    }
    
    public static String getServerName() {
        try {
            String server = "";
            File file=new File(SERVER);    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
            String line;  
            while((line=br.readLine())!=null) {   
                String[] lineTab = line.split(" ");
                server = lineTab[0];
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return server;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Server", e.getMessage());
            return null;
        }
    }
    
    public static void saveLoginInfo(String username, String id, String password) {
        try {
            File text = new File(ACTIVE_LOGIN);
            if (text.createNewFile()) {
                StringBuilder data = new StringBuilder();
                data.append(username + "\n" + id + "\n" + password);
                Files.write(text.toPath(), data.toString().getBytes());
            } else {
                text.delete();
                
                text = new File(ACTIVE_LOGIN);
                StringBuilder data = new StringBuilder();
                data.append(username + "\n" + id + "\n" + password);
                Files.write(text.toPath(), data.toString().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Saving Login", e.getMessage());
        }
    }
    
    public static Server getServer() {
        try {
            Server server = new Server();
            File file=new File(SERVER);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line;  
            while((line=br.readLine())!=null) {   
                String[] lineTab = line.split(" ");
                server.setServerName(lineTab[0]);
                server.setDatabase(lineTab[1]);
                server.setUsername(lineTab[2]);
                server.setPassword(lineTab[3]);
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return server;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Server", e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(getOfficeCode() + "" + getOffice());
    }
    
    public static String getCashierHeadId () {
        try {
            String office = "";
            File file=new File(OTHER_CONFIG);    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line;  
            int i=0;
            while((line=br.readLine())!=null) {  
                if (i==2) {
                    office = line;
                }                
                i++;
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return office;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Cashier Head Id", e.getMessage());
            return null;
        }
    }
    
    public static String getServerIp () {
        try {
            String office = "";
            File file=new File(OTHER_CONFIG);    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line;  
            int i=0;
            while((line=br.readLine())!=null) {  
                if (i==3) {
                    office = line;
                }                
                i++;
            } 
            
            fr.close();    //closes the stream and release the resources   
            
            return office;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Server IP Address", e.getMessage());
            return null;
        }
    }
}
