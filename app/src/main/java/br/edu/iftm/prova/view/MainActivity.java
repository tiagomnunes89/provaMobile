package br.edu.iftm.prova.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.prova.R;
import br.edu.iftm.prova.config.RetrofitService;
import br.edu.iftm.prova.entities.Candy;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textViewTitleDonnut;
    TextView textViewDescrptionDonnut;
    TextView textViewPriceDonnut;
    TextView textViewTitleIce;
    TextView textViewDescrptionIce;
    TextView textViewPriceIce;
    TextView textViewTitleFroyo;
    TextView textViewDescriptionFroyo;
    TextView textViewPriceFroyo;
    ImageView imageViewDonnut;
    ImageView imageViewFroyo;
    ImageView imageViewIce;
    List<Candy> candyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        candyList = new ArrayList<>();

        imageViewDonnut = findViewById(R.id.donnut_item_img);
        textViewTitleDonnut = findViewById(R.id.donnut_product_tv);
        textViewPriceDonnut = findViewById(R.id.donnut_price);
        textViewDescrptionDonnut = findViewById(R.id.donnut_description_tv);

        imageViewFroyo = findViewById(R.id.froyo_item_img);
        textViewTitleFroyo = findViewById(R.id.froyo_product_tv);
        textViewPriceFroyo = findViewById(R.id.froyo_price);
        textViewDescriptionFroyo = findViewById(R.id.froyo_description_tv);

        imageViewIce = findViewById(R.id.ice_cream_item_img);
        textViewTitleIce = findViewById(R.id.ice_cream_product_tv);
        textViewPriceIce = findViewById(R.id.ice_cream_price);
        textViewDescrptionIce = findViewById(R.id.ice_cream_description_tv);
        searchData();
    }

    private void searchData() {
        RetrofitService.getServico().getCandy().enqueue(new Callback<List<Candy>>() {
            @Override
            public void onResponse(Call<List<Candy>> call, Response<List<Candy>> response) {
                candyList = response.body();
                for (Candy candy : candyList) {
                    if (candy.getProduto().equals("Donuts")) {
                        textViewTitleDonnut.setText(candy.getProduto());
                        textViewPriceDonnut.setText("R$ "+candy.getValor()+ ",00");
                        textViewDescrptionDonnut.setText(candy.getDescricao());
                    }
                    if (candy.getProduto().equals("Sanduiche de sorvete")) {
                        textViewTitleIce.setText(candy.getProduto());
                        textViewPriceIce.setText("R$ "+candy.getValor()+ ",00");
                        textViewDescrptionIce.setText(candy.getDescricao());
                    }
                    if (candy.getProduto().equals("FroYo")) {
                        textViewTitleFroyo.setText(candy.getProduto());
                        textViewPriceFroyo.setText("R$ "+candy.getValor()+ ",00");
                        textViewDescriptionFroyo.setText(candy.getDescricao());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Candy>> call, Throwable t) {

            }
        });
    }
}
