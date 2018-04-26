package com.example.d.pleh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class BulletinBoardActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private LinearLayout wishListLayout;
    private RecyclerView wishListRecyclerView;
    private Button createWishButton;
    private List<Wish> wishList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin_board);

        // OHAD code TODO delete
        /*
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
        */

        progressBar = findViewById(R.id.wish_list_progress_bar);
        progressBar.setVisibility(View.GONE); // TODO change this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        wishListLayout = findViewById(R.id.wish_list_layout);
        wishListRecyclerView = findViewById(R.id.wish_list_recycler_view);
        createWishButton = findViewById(R.id.create_wish_btn);

        wishListRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager vetListLayoutManager = new LinearLayoutManager(this);
        wishListRecyclerView.setLayoutManager(vetListLayoutManager);
//
//        ListItemDecoration decoration = new ListItemDecoration(this, Color.LTGRAY, 1f);
//        wishListRecyclerView.addItemDecoration(decoration);

        BulletinBoardAdapter.OnItemClickListener buttonsListener = new BulletinBoardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Wish vetClinic) {
//                Intent intent = new Intent(BulletinBoardActivity.this, WishDescriptionActivity.class);
//                intent.putExtra(PLACE_ID, vetClinic.getPlaceId());
//                intent.putExtra(NAME, vetClinic.getName());
//                intent.putExtra(ADDRESS, vetClinic.getAddress());
//                intent.putExtra(ORIGIN_LATITUDE, Double.toString(currLatitude));
//                intent.putExtra(ORIGIN_LONGITUDE, Double.toString(currLongitude));
//                startActivity(intent);
            }
        };

        wishList.add(new Wish("Sofa", "Beer", "help me", "Yoni", WishCategory.ITEMS, 0, 1));
        wishList.add(new Wish("Translation", "Cookies", "help me", "Felber", WishCategory.ITEMS, 1, 2));
        wishList.add(new Wish("Cart", "Drugs", "help me", "Shahar", WishCategory.ITEMS, 2, 3));
        wishList.add(new Wish("Work", "Cookies", "help me", "Ohad", WishCategory.ITEMS, 3, 4));
        wishList.add(new Wish("Sofa", "Beer", "help me", "Yoni", WishCategory.ITEMS, 4, 5));
        wishList.add(new Wish("Translation", "Cookies", "help me", "Felber", WishCategory.ITEMS, 5, 6));
        wishList.add(new Wish("Cart", "Drugs", "help me", "Shahar", WishCategory.ITEMS, 6, 7));
        wishList.add(new Wish("Work", "Cookies", "help me", "Ohad", WishCategory.ITEMS, 7, 8));
        wishList.add(new Wish("Sofa", "Beer", "help me", "Yoni", WishCategory.ITEMS, 8, 9));
        wishList.add(new Wish("Translation", "Cookies", "help me", "Felber", WishCategory.ITEMS, 9, 10));
        wishList.add(new Wish("Cart", "Drugs", "help me", "Shahar", WishCategory.ITEMS, 11, 12));
        wishList.add(new Wish("Work", "Cookies", "help me", "Ohad", WishCategory.ITEMS, 12, 13));
        wishListRecyclerView.setAdapter(new BulletinBoardAdapter(wishList, buttonsListener));
    }
}
