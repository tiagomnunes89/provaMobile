package br.edu.iftm.prova.services;

import java.util.List;

import br.edu.iftm.prova.entities.Candy;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("/droidcafe")
    Call<List<Candy>> getCandy();
}
