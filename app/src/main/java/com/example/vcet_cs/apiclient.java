package com.example.vcet_cs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiclient {
    public static  final  String BASE_URL="https://mokedatuluver.000webhostapp.com/";
    public static Retrofit retrofit = null;

    public  static  Retrofit getApiclient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }
}
//192.168.43.159