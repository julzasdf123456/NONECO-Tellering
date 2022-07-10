/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojos.Login;

/**
 *
 * @author Julio Lopez
 */
public class UsersDao {
    public static Login getLogin(Connection con, String id) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Login login = new Login();
                login.setId(rs.getString("id"));
                login.setName(rs.getString("name"));
                login.setUsername(rs.getString("username"));
                ps.close();
                rs.close();
                return login;
            }
            
           ps.close();
           rs.close();
           return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
