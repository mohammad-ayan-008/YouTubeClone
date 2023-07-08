package com.example.Retrofitints;
import android.content.Context;
import com.example.Retrofitints.ApiRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCall {
    private static Retrofit retrofit;
    public static  String url="https://www.googleapis.com";
   
    public static  ApiRequest getInstance(){
     
        if(retrofit==null){
            retrofit =new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        }
        return retrofit.create(ApiRequest.class);
    }
}
