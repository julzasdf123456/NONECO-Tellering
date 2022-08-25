/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import helpers.ConfigFileHelpers;

/**
 *
 * @author Julio Lopez
 */
public class BaseURL {
    public static String baseUrl() {
        return "http://" + ConfigFileHelpers.getServerIp()+ "/crm-noneco/public/api/";
    }
}
