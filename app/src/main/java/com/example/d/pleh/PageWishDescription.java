package com.example.d.pleh;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PageWishDescription extends AppCompatActivity
{
    ImageView rewardImg;
    ImageView categoryImg;
    TextView wishTxtTitle;
    TextView txtRewardTitle;
    TextView description;
    Button btnAskForWish;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_wish_description);
        Intent intent = getIntent();

        rewardImg = findViewById(R.id.imgRewardCat);
        categoryImg = findViewById(R.id.imgWishCat);
        wishTxtTitle = findViewById(R.id.txtDescPageTitle);
        txtRewardTitle = findViewById(R.id.txtRewardTitle);
        description = findViewById(R.id.txtDescPageDesc);

        rewardImg.setImageResource(R.drawable.drink);
        categoryImg.setImageResource(R.drawable.medicine);
        wishTxtTitle.setText(intent.getStringExtra(BulletinBoardActivity.WISH_TITLE));
        txtRewardTitle.setText(intent.getStringExtra(BulletinBoardActivity.REWARD_TITLE));
        description.setText(intent.getStringExtra(BulletinBoardActivity.WISH_DESCRIPTION));
    }

    public void OnButtonClick(View v) {
        TextView title = new TextView(this);
        title.setText("PLEH!");
        title.setPadding(30, 50, 64, 9);
        title.setTextColor(Color.BLUE);
        title.setTextSize(20);

        new AlertDialog.Builder(this).setMessage("We successfully submitted your submission!")
                .setCustomTitle(title)
                .setPositiveButton("BACK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // implement
            }
        }).create().show();
    }
}
