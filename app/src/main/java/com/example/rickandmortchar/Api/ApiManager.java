package com.example.rickandmortchar.Api;

import com.example.rickandmortchar.Utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.rickandmortchar.Utils.Constants.BASE_URL;

public class ApiManager {

    private ApiService service;

    public ApiService getService(){

        if(service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(ApiService.class);
        }
        return service;
    }
}
