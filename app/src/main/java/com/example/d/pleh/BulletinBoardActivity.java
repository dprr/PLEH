package com.example.d.pleh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
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
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bulletin_board);

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

        wishList.add(new Wish("Sofa", "Beer", "help me", "Yoni", "medicine"));
        wishList.add(new Wish("Translation", "Cookies", "help me", "Felber", "medicine"));
        wishList.add(new Wish("Cart", "Drugs", "help me", "Shahar", "medicine"));
        wishList.add(new Wish("Work", "Cookies", "help me", "Ohad", "medicine"));
        wishListRecyclerView.setAdapter(new BulletinBoardAdapter(wishList, buttonsListener));
    }
}
