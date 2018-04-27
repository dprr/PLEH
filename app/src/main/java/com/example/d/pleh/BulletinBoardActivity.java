package com.example.d.pleh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BulletinBoardActivity extends AppCompatActivity {
    public static final String WISH_IMAGE = "com.example.hasorkim.wish_image";
    public static final String REWARD_IMAGE = "com.example.hasorkim.reward_image";
    public static final String WISH_TITLE = "com.example.hasorkim.wish_title";
    public static final String REWARD_TITLE = "com.example.hasorkim.reward_title";
    public static final String WISH_DESCRIPTION = "com.example.hasorkim.wish_description";

    private ProgressBar progressBar;
    private LinearLayout wishListLayout;
    private RecyclerView wishListRecyclerView;
    private Button createWishButton;
    private List<Wish> wishList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin_board);

        progressBar = findViewById(R.id.wish_list_progress_bar);
        createWishButton = findViewById(R.id.create_wish_btn);
        wishListLayout = findViewById(R.id.wish_list_layout);
        wishListRecyclerView = findViewById(R.id.wish_list_recycler_view);

        wishListRecyclerView.setHasFixedSize(true);
        createWishButton = findViewById(R.id.create_wish_btn);

        RecyclerView.LayoutManager vetListLayoutManager = new LinearLayoutManager(this);
        wishListRecyclerView.setLayoutManager(vetListLayoutManager);

        getWishes();
    }

    public void OnOfferClick(View v) {
        Intent intent = new Intent(BulletinBoardActivity.this, WishRequestActivity.class);
        startActivity(intent);
    }

    private void getWishes() {
        PlehAPI mAPIService = ApiUtils.getAPIService();
        mAPIService.getWish().enqueue(new Callback<List<Wish>>() {
            @Override
            public void onResponse(Call<List<Wish>> call, Response<List<Wish>> response) {
                wishList = response.body();
                if (wishList == null)
                    wishList = new ArrayList<>();
                updateUI();
            }

            @Override
            public void onFailure(Call<List<Wish>> call, Throwable t) {

            }
        });
    }

    private void updateUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final BulletinBoardAdapter.OnItemClickListener bulletsListener = new BulletinBoardAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Wish item) {
                        Intent intent = new Intent(BulletinBoardActivity.this, PageWishDescription.class);
                        intent.putExtra(WISH_IMAGE, Wish.getWishImage(item.getWishCategoryType()));
                        intent.putExtra(REWARD_IMAGE, Wish.getRewardImage(item.getRewardCategoryType()));
                        intent.putExtra(WISH_TITLE, item.getWishTitle());
                        intent.putExtra(REWARD_TITLE, item.getRewardTitle());
                        intent.putExtra(WISH_DESCRIPTION, item.getWishDescription());
                        startActivity(intent);
                    }
                };

                wishListRecyclerView.setAdapter(new BulletinBoardAdapter(wishList, bulletsListener));
                progressBar.setVisibility(View.GONE);
                wishListLayout.setVisibility(View.VISIBLE);

                if (wishList.size() == 0)
                    createWishButton.setVisibility(View.GONE);
            }
        });
    }
}
