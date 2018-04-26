package com.example.d.pleh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("log", "here");

        // Creating abbu branch
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        UserController userController = new UserController();
//        userController.start();

        Log.e("log", "hello");
        User user = new User();
        PlehAPI mAPIService = ApiUtils.getAPIService();
        mAPIService.addUser(user).enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Long id = response.body();
                Log.e("log", String.valueOf(id));

            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {

            }
        });
    }

}
