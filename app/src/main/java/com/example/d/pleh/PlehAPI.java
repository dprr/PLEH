package com.example.d.pleh;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PlehAPI {
    @GET("user/all")
    Call<List<User>> getUser();

    @POST("user/create")
    Call<Long> addUser(@Body User user);

//    @GET("wish/")
//    Call<List<Wish>> getUser();
//    //todo same for wish and etc.
}
