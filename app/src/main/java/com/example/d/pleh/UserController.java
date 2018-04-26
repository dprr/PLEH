//todo depricated

package com.example.d.pleh;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserController implements Callback<List<User>> {

    static final String BASE_URL = "http://192.114.88.126:8080/";
    private PlehAPI plehAPI;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        plehAPI = retrofit.create(PlehAPI.class);
        getAllUsers();
    }

    public void getAllUsers() {
        Call<List<User>> call = plehAPI.getUser();
        call.enqueue(this);
    }



    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        List<User> users = response.body();
        for (User user:users)
        {
            Log.e("request", String.valueOf(user.getID()));
        }

    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        t.printStackTrace();
    }
}
