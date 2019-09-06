package br.edu.iftm.prova.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import br.edu.iftm.prova.services.ApiEndPoint;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private String baseUrl ="http://angoti.atwebpages.com";
    private ApiEndPoint api;
    private static RetrofitService instancia;

    private RetrofitService() {
        api = criaRetrofit().create(ApiEndPoint.class);
    }

    public static ApiEndPoint getServico() {
        if (instancia == null)
            instancia = new RetrofitService();
        return instancia.api;
    }


    private Retrofit criaRetrofit() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES);
        httpClient.addInterceptor(logging);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
    }
}
