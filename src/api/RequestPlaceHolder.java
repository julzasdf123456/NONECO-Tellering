/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import pojos.Login;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 * @author Julio Lopez
 */
public interface RequestPlaceHolder {
    @POST("login")
    Call<Login> login(@Body Login login);
}
