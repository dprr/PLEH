package com.example.d.pleh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishRequestActivity extends AppCompatActivity
{
    private TextView wishTitle;
    private TextView wishDescription;
    private TextView rewardTitle;
    private ImageButton btnWishWork;
    private ImageButton btnWishGeneralItems;
    private ImageButton btnWishMed;
    private ImageButton btnWishTrans;
    private ImageButton btnWishPpl;
    private ImageButton btnRewPiggy;
    private ImageButton btnRewCookies;
    private ImageButton btnRewDrink;
    private ImageButton btnRewFood;
    private ImageButton btnRewGeneralItems;
    private Button btnRequestWish;
    int categoryBtns[];
    int rewardBtns[];
    private WishCategoryType wishCategoryType;
    private RewardCategoryType rewardCategoryType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_request);
        wishTitle = findViewById(R.id.txtDescPageTitle);
        wishDescription = findViewById(R.id.txtDescPageDesc);
        rewardTitle = findViewById(R.id.txtRewardTitle);
        btnWishWork = findViewById(R.id.iconWork);
        btnWishGeneralItems = findViewById(R.id.iconCart);
        btnWishMed = findViewById(R.id.iconMedicine);
        btnWishTrans = findViewById(R.id.iconTranslate);
        btnWishPpl = findViewById(R.id.iconVolunteers);
        btnRewPiggy = findViewById(R.id.iconPiggyBank);
        btnRewCookies = findViewById(R.id.iconCookies);
        btnRewDrink = findViewById(R.id.iconDrink);
        btnRewFood = findViewById(R.id.iconFood);
        btnRewGeneralItems = findViewById(R.id.iconGeneral);
        btnRequestWish = findViewById(R.id.btnAskForWish);
        wishCategoryType = WishCategoryType.VOLUNTEERS;
        rewardCategoryType = RewardCategoryType.FOOD;
        categoryBtns = new int[5];
        rewardBtns = new int[5];

        btnRequestWish.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Wish wish = new Wish(wishTitle.getText().toString(), wishCategoryType,
                        wishDescription.getText().toString(), rewardTitle.getText().toString(),
                        rewardCategoryType, "A loaf of bread", User.getUser().getID());

                BulletinBoardActivity.wishListRecyclerView.getAdapter().notifyDataSetChanged();
                PlehAPI mAPIService = ApiUtils.getAPIService();

                mAPIService.addWish(wish).enqueue(new Callback<Long>()
                {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response)
                    {
                        Long id = response.body();
                        wish.setId(id);
                    }

                    @Override
                    public void onFailure(Call<Long> call, Throwable t)
                    {

                    }

                });

                Intent intent = new Intent(WishRequestActivity.this, BulletinBoardActivity.class);

                startActivity(intent);
            }
        });
    }
}
