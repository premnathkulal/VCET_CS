package com.example.vcet_cs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("regi.php")
    Call<user> performRegistration(@Query("name") String name, @Query("email") String email, @Query("usn") String usn, @Query("password") String password);

    @GET("login.php")
    Call<user> performUserLogin(@Query("email") String email,@Query("password") String password);


}
