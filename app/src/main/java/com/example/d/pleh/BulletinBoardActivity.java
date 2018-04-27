package com.example.d.pleh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BulletinBoardActivity extends AppCompatActivity {
    public static final String REWARD_IMAGE = "com.example.hasorkim.reward_image";

    private ProgressBar progressBar;
    private LinearLayout wishListLayout;
    private RecyclerView wishListRecyclerView;
    private List<Wish> wishList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin_board);

        progressBar = findViewById(R.id.wish_list_progress_bar);
        progressBar.setVisibility(View.GONE); // TODO change this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        wishListLayout = findViewById(R.id.wish_list_layout);
        wishListRecyclerView = findViewById(R.id.wish_list_recycler_view);
        wishListRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager vetListLayoutManager = new LinearLayoutManager(this);
        wishListRecyclerView.setLayoutManager(vetListLayoutManager);

        getWishes();

//        wishList.add(new Wish("Sofa", RewardCategory.DRUGS, "help me", "Yoni", WishCategoryType.ITEMS, 0));
//        wishList.add(new Wish("Translation", RewardCategory.DRUGS, "help me", "Felber", WishCategoryType.ITEMS, 1));
//        wishList.add(new Wish("Cart", RewardCategory.DRUGS, "help me", "Shahar", WishCategoryType.ITEMS, 2));
//        wishList.add(new Wish("Work", RewardCategory.DRUGS, "help me", "Ohad", WishCategoryType.ITEMS, 3));
//        wishList.add(new Wish("Sofa", RewardCategory.DRUGS, "help me", "Yoni", WishCategoryType.ITEMS, 4));
//        wishList.add(new Wish("Translation", RewardCategory.DRUGS, "help me", "Felber", WishCategoryType.ITEMS, 5));
//        wishList.add(new Wish("Cart", RewardCategory.DRUGS, "help me", "Shahar", WishCategoryType.ITEMS, 6));
//        wishList.add(new Wish("Work", RewardCategory.DRUGS, "help me", "Ohad", WishCategoryType.ITEMS, 7));
//        wishList.add(new Wish("Sofa", RewardCategory.DRUGS, "help me", "Yoni", WishCategoryType.ITEMS, 8));
//        wishList.add(new Wish("Translation", RewardCategory.DRUGS, "help me", "Felber", WishCategoryType.ITEMS, 9));
//        wishList.add(new Wish("Cart", RewardCategory.DRUGS, "help me", "Shahar", WishCategoryType.ITEMS, 11));
//        wishList.add(new Wish("Work", RewardCategory.DRUGS, "help me", "Ohad", WishCategoryType.ITEMS, 12));
//        wishListRecyclerView.setAdapter(new BulletinBoardAdapter(wishList, buttonsListener));
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
                final BulletinBoardAdapter.OnItemClickListener buttonsListener = new BulletinBoardAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Wish item) {
//                        Intent intent = new Intent(BulletinBoardActivity.this, PageWishDescription.class);
//                        intent.putExtra(REWARD_IMAGE, Wish.getRewardOffer(item.getRewardCategory()));
//
//                        startActivity(intent);
                        Intent intent = new Intent(BulletinBoardActivity.this, PageWishDescription.class);
                        startActivity(intent);
                    }
                };

                progressBar.setVisibility(View.GONE);
                wishListLayout.setVisibility(View.VISIBLE);
            }
        });
    }
}
