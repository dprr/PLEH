package com.example.d.pleh;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PlehAPI {
    @GET("user/all")
    Call<List<User>> getUser();

    @POST("user/create")
    Call<Long> addUser(@Body User user);

    @GET("wish/all")
    Call<List<Wish>> getWish();

    @POST("wish/create")
    Call<Long> addWish(@Body User user);
//    //todo same for wish and etc.
}
