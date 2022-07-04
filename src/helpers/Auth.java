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
                while((line=br.readLine())!=null) {   
                    String[] lineTab = line.split(" ");
                    login.setUsername(lineTab[0]);
                    login.setId(lineTab[1]);
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
}
