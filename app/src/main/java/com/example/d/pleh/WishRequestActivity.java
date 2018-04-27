package com.example.d.pleh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishRequestActivity extends AppCompatActivity {
    private TextView wishTitle = findViewById(R.id.txtDescPageTitle);
    private TextView wishDescription = findViewById(R.id.wish_description);
    private TextView txtDescription = findViewById(R.id.wish_description);
    private ImageButton btnWishWork = findViewById(R.id.iconWork);
    private ImageButton btnWishGeneralItems = findViewById(R.id.iconCart);
    private ImageButton btnWishMed = findViewById(R.id.iconMedicine);
    private ImageButton btnWishTrans = findViewById(R.id.iconTranslate);
    private ImageButton btnWishPpl = findViewById(R.id.iconVolunteers);
    private ImageButton btnRewPiggy = findViewById(R.id.iconPiggyBank);
    private ImageButton btnRewCookies = findViewById(R.id.iconCookies);
    private ImageButton btnRewDrink = findViewById(R.id.iconDrink);
    private ImageButton btnRewFood = findViewById(R.id.iconFood);
    private ImageButton btnRewGeneralItems = findViewById(R.id.iconGeneral);

    private int btns[] = new int[5];
    private Button btnRequestWish = findViewById(R.id.btnAskForWish);

    private WishCategoryType wishCategoryType = WishCategoryType.VOLUNTEERS;
    private RewardCategoryType rewardCategoryType = RewardCategoryType.FOOD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_request);

        btnRequestWish.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Wish wish = new Wish("Feeding Poor", wishCategoryType,
                        "Help distibuting food", "Spaghetti",
                        rewardCategoryType, "A loaf of bread", User.getUser().getID());

                PlehAPI mAPIService = ApiUtils.getAPIService();

                mAPIService.addWish(wish).enqueue(new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {
                        Long id = response.body();
                        wish.setId(id);
                    }

                    @Override
                    public void onFailure(Call<Long> call, Throwable t) {

                    }
                });
            }
        });


    }
}
