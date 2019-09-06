package br.edu.iftm.prova.view;

import android.os.Bundle;
import android.view.ViewGroup;
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
    ViewGroup viewGroupDonnut;
    ViewGroup viewGroupIce;
    ViewGroup viewGroupFroyo;
    List<Candy> candyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        candyList = new ArrayList<>();
        viewGroupDonnut = findViewById(R.id.donnut);
        viewGroupFroyo = findViewById(R.id.froyo);
        viewGroupIce = findViewById(R.id.ice_cream);

        imageViewDonnut = viewGroupDonnut.findViewById(R.id.donnut_item_img);
        textViewTitleDonnut = viewGroupDonnut.findViewById(R.id.donnut_product_tv);
        textViewPriceDonnut = viewGroupDonnut.findViewById(R.id.donnut_price);
        textViewDescrptionDonnut = viewGroupDonnut.findViewById(R.id.donnut_description_tv);

        imageViewFroyo = viewGroupFroyo.findViewById(R.id.item_img);
        textViewTitleFroyo = viewGroupFroyo.findViewById(R.id.product_tv);
        textViewPriceFroyo = viewGroupFroyo.findViewById(R.id.price);
        textViewDescriptionFroyo = viewGroupFroyo.findViewById(R.id.description_tv);

        imageViewIce = viewGroupIce.findViewById(R.id.ice_cream_item_img);
        textViewTitleIce= viewGroupIce.findViewById(R.id.ice_cream_product_tv);
        textViewPriceIce = viewGroupIce.findViewById(R.id.ice_cream_price);
        textViewDescrptionIce = viewGroupIce.findViewById(R.id.ice_cream_description_tv);
        searchData();
    }

    private void searchData() {
        RetrofitService.getServico().getCandy().enqueue(new Callback<List<Candy>>() {
            @Override
            public void onResponse(Call<List<Candy>> call, Response<List<Candy>> response) {
                candyList = response.body();
                for (Candy candy : candyList) {
                    candyList.add(candy);
                    if(candy.getProduto().equals("Donuts")){
                        textViewTitleDonnut.setText(candy.getProduto());
                        textViewPriceDonnut.setText(candy.getValor());
                        textViewDescrptionDonnut.setText(candy.getDescricao());

                    }
                    if(candy.getProduto().equals("Sanduiche de sorvete")){
                        textViewTitleIce.setText(candy.getProduto());
                        textViewPriceIce.setText(candy.getValor());
                        textViewDescrptionIce.setText(candy.getDescricao());

                    }
                    if(candy.getProduto().equals("FroYo")){
                        textViewTitleFroyo.setText(candy.getProduto());
                        textViewTitleFroyo.setText(candy.getValor());
                        textViewTitleFroyo.setText(candy.getDescricao());

                    }

                }
            }

            @Override
            public void onFailure(Call<List<Candy>> call, Throwable t) {

            }
        });
    }
}
