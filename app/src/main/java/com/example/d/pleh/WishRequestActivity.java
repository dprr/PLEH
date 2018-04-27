package com.example.d.pleh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishRequestActivity extends AppCompatActivity {
    private EditText wishTitle = findViewById(R.id.txtDescPageTitle);
    private EditText wishDescription = findViewById(R.id.wish_description);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_request);

//        final Wish wish = new Wish("Beer", RewardCategory.MONEY, "I want a beer", "Eli",
//                WishCategoryType.VOLUNTEERS, 123);
//
//        PlehAPI mAPIService = ApiUtils.getAPIService();
//        mAPIService.addWish(wish).enqueue(new Callback<Long>() {
//            @Override
//            public void onResponse(Call<Long> call, Response<Long> response) {
//                Long id = response.body();
//                wish.setId(id);
//            }
//
//            @Override
//            public void onFailure(Call<Long> call, Throwable t) {
//
//            }
//        });
    }
}
