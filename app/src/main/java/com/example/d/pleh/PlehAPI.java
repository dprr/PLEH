package com.example.d.pleh;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PlehAPI {
    @GET("user/all")
    Call<List<User>> getUser();

    @GET("user/email")
    Call<User> getUserbyEmail(String email);

    @POST("user/create")
    Call<Long> addUser(@Body User user);

    @GET("wish/all")
    Call<List<Wish>> getWish();

    @POST("wish/create")
    Call<Long> addWish(@Body User user);
}
