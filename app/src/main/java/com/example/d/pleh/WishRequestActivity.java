package com.example.d.pleh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishRequestActivity extends AppCompatActivity
{
    public static final int WORK_IDX = 0;
    public static final int WISH_ITEM_IDX = 1;
    public static final int MEDS_IDX = 2;
    public static final int TRANS_IDX = 3;
    public static final int VLNT_IDX = 4;
    public static final int MONEY_IDX = 5;
    public static final int SWEETS_IDX = 6;
    public static final int DRINK_IDX = 7;
    public static final int FOOD_IDX = 8;
    public static final int ITEMS_IDX = 9;
    public static final int OFFSET_FOR_REWARD = 5;
    public static final float ALPHA_NOT_SELECTED = 0.18f;
    public static final float ALPHA_ON = 1f;

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
    private WishCategoryType wishCategoryType = null;
    private RewardCategoryType rewardCategoryType = null;
    private boolean rewardTitleValid;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_request);

        // Edit texts
        wishTitle = findViewById(R.id.txtDescPageTitle);
        wishDescription = findViewById(R.id.txtDescPageDesc);
        rewardTitle = findViewById(R.id.txtRewardTitle);

        // Wish ImageButtons
        btnWishWork = findViewById(R.id.iconWork);
        btnWishGeneralItems = findViewById(R.id.iconCart);
        btnWishMed = findViewById(R.id.iconMedicine);
        btnWishTrans = findViewById(R.id.iconTranslate);
        btnWishPpl = findViewById(R.id.iconVolunteers);
        // Reward ImageButtons
        btnRewPiggy = findViewById(R.id.iconPiggyBank);
        btnRewCookies = findViewById(R.id.iconCookies);
        btnRewDrink = findViewById(R.id.iconDrink);
        btnRewFood = findViewById(R.id.iconFood);
        btnRewGeneralItems = findViewById(R.id.iconGeneral);

        //Make wish
        btnRequestWish = findViewById(R.id.btnAskForWish);

        // Used for UI

        ImageButton wishBtnArr[] = {btnWishWork, btnWishGeneralItems, btnWishMed, btnWishTrans, btnWishPpl};
        ImageButton rewBtnArr[] = {btnRewPiggy, btnRewCookies, btnRewDrink, btnRewFood, btnRewGeneralItems};


        //Setting up the Category
        btnWishWork.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                highlightBtn(WORK_IDX);
                wishCategoryType = WishCategoryType.WORK;
            }
        });
        btnWishGeneralItems.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                highlightBtn(WISH_ITEM_IDX);
                wishCategoryType = WishCategoryType.ITEMS;
            }
        });
        btnWishMed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                highlightBtn(MEDS_IDX);
                wishCategoryType = WishCategoryType.MEDICINE;
            }
        });
        btnWishTrans.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                highlightBtn(TRANS_IDX);
                wishCategoryType = WishCategoryType.TRANSLATING;
            }
        });
        btnWishPpl.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                highlightBtn(VLNT_IDX);
                wishCategoryType = WishCategoryType.VOLUNTEERS;
            }
        });

        // Setting up the Reward
        btnRewPiggy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                highlightBtn(MONEY_IDX);
                rewardCategoryType = RewardCategoryType.MONEY;
            }
        });
        btnRewCookies.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                highlightBtn(SWEETS_IDX);

                rewardCategoryType = RewardCategoryType.SWEETS;
            }
        });
        btnRewDrink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                highlightBtn(DRINK_IDX);

                rewardCategoryType = RewardCategoryType.DRINK;
            }
        });
        btnRewFood.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                highlightBtn(FOOD_IDX);

                rewardCategoryType = RewardCategoryType.FOOD;
            }
        });
        btnRewGeneralItems.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                highlightBtn(ITEMS_IDX);
                rewardCategoryType = RewardCategoryType.GENERAL;
            }
        });

        // Posting the wish
        btnRequestWish.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if (wishIsValid())
                {

                    Wish wish = new Wish(wishTitle.getText().toString(), wishCategoryType,
                            wishDescription.getText().toString(), rewardTitle.getText().toString(),
                            rewardCategoryType, "A loaf of bread", User.getUser().getID());

                    BulletinBoardActivity.wishListRecyclerView.getAdapter().notifyItemInserted(BulletinBoardActivity.wishList.size() - 0);


//                Service related
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
                    finish();
                }

            }
        });
    }

    private void highlightBtn(int workIdx)
    {
        ImageButton wishBtnArr[] = {btnWishWork, btnWishGeneralItems, btnWishMed, btnWishTrans, btnWishPpl};
        ImageButton rewBtnArr[] = {btnRewPiggy, btnRewCookies, btnRewDrink, btnRewFood, btnRewGeneralItems};

        // wish Category btns
        if (0 <= workIdx && workIdx <= 4)
        {
            for (int c = 0; c < 5; ++c)
            {
                if (c != workIdx)
                {
                    wishBtnArr[c].setAlpha(ALPHA_NOT_SELECTED);
                }
                else
                {
                    wishBtnArr[workIdx].setAlpha(ALPHA_ON);
                }
            }

        }
        // rewards category btns
        if (5 <= workIdx && workIdx <= 9)
        {
            for (int i = 0; i < 5; ++i)
            {
                if (i != workIdx - OFFSET_FOR_REWARD)
                {
                    rewBtnArr[i].setAlpha(ALPHA_NOT_SELECTED);
                }
                else
                {
                    rewBtnArr[workIdx - OFFSET_FOR_REWARD].setAlpha(1f);
                }
            }
        }
    }

    private boolean wishIsValid()
    {
        if (wishTitleIsInvalid())
        {
            Toast.makeText(this, "Please enter a  Wish Title", Toast.LENGTH_SHORT).show();  // Todo replace with Pop up rather than Toast
            return false;
        }
        else if (!wishCatgoryWasChosen())
        {
            Toast.makeText(this, "But what's your wish TYPE???\nHow will we know?!", Toast.LENGTH_SHORT).show();  // Todo replace with Pop up rather than Toast
            return false;
        }
        else if (!rewardCatgoryWasChosen())
        {
            Toast.makeText(this, "But what's your reward TYPE???\nYour helper's gotta make a living!", Toast.LENGTH_SHORT).show();  // Todo replace with Pop up rather than Toast
            return false;
        }
        else if (rewardTitleIsInvalid())
        {

            Toast.makeText(this, "Please enter some Reward for your wish", Toast.LENGTH_LONG).show();  // Todo replace with Pop up rather than Toast
            return false;
        }
        else if (wishDeschIsInvalid())
        {
            Toast.makeText(this, "Please enter a description Title", Toast.LENGTH_SHORT).show();  // Todo replace with Pop up rather than Toast
            return false;
        }

        return true;
    }

    private boolean rewardCatgoryWasChosen()
    {
        return rewardCategoryType != null;
    }
    private boolean wishCatgoryWasChosen()
    {
        return wishCategoryType != null;
    }

    private boolean wishTitleIsInvalid()
    {
        return wishTitle.getText().toString().length() == 0;
    }

    public boolean wishDeschIsInvalid()
    {
        return wishDescription.getText().toString().length() == 0;
    }

    public boolean rewardTitleIsInvalid()
    {
        return rewardTitle.getText().toString().length() == 0;
    }
}
