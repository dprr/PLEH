package com.example.d.pleh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WishController implements Callback<List<Wish>> {
    static final String BASE_URL = "http://";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PlehAPI plehAPI = retrofit.create(PlehAPI.class);

//        Call<List<Wish>> call = plehAPI.getUser();
//        call.enqueue(this);

    }
    
    @Override
    public void onResponse(Call<List<Wish>> call, Response<List<Wish>> response) {
        
    }

    @Override
    public void onFailure(Call<List<Wish>> call, Throwable t) {
        t.printStackTrace();
    }
}
