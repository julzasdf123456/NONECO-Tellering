/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import static helpers.ConfigFileHelpers.ACTIVE_LOGIN;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import pojos.Login;

/**
 *
 * @author Julio Lopez
 */
public class Auth {
    public static Login getActiveUser() {
        try {
            Login login = new Login();
            File file=new File(ACTIVE_LOGIN);    //creates a new file instance  
            if (file.exists()) {
                FileReader fr = new FileReader(file);   //reads the file  
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  
                String line;  
                int i=0;
                while((line=br.readLine())!=null) {   
                    if (i==0) {
                        login.setUsername(line);
                    } else if (i==1) {
                        login.setId(line);
                    } else  if (i==2) {
                        login.setPassword(line);
                    }
                    
                    i++;
                } 

                fr.close();    //closes the stream and release the resources   

                return login;
            } else {
                return null;
            }                
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Active Login", e.getMessage());
            return null;
        }
    }
    
    public static boolean authenticate(String username, String password, Login login) {
        try {
            if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
