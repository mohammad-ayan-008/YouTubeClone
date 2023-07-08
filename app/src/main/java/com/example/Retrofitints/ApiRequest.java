package com.example.Retrofitints;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {
    
    @GET("/youtube/v3/search")
    Call<Model> getResponse(@Query("part") String part,@Query("maxResults") int maxResults,@Query("q") String q,@Query("type") String type,@Query("key") String key);
}
