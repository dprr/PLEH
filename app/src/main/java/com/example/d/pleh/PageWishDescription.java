package com.example.d.pleh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PageWishDescription extends AppCompatActivity
{
    ImageView rewardImg;
    ImageView catagoryImg;
    TextView txtTitle;
    TextView txtDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_wish_description);
        rewardImg = findViewById(R.id.imgRewardCat);
        catagoryImg = findViewById(R.id.imgWishCat);
        txtTitle = findViewById(R.id.txtDescPageTitle);
        txtDesc = findViewById(R.id.txtDescPageDesc);

        rewardImg.setImageResource(R.drawable.drink);
        catagoryImg.setImageResource(R.drawable.medicine);
    }
}
