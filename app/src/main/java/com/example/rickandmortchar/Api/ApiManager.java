package com.example.rickandmortchar.Api;

import com.example.rickandmortchar.BuildConfig;
import com.example.rickandmortchar.Utils.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private ApiService service;

    public ApiService getService(){

        if(service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    //todo 9: add the interceptor to retrofit here
                    .client(okHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(ApiService.class);
        }
        return service;
    }

    //todo 7: Always add an interceptor to your api calls in
    // order to see some logs on your logcat that actually informs you about the request you are making
    private OkHttpClient okHttpClient(){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        //add a logging interceptor to be able to log network request response
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        if(BuildConfig.DEBUG){
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        okHttpClient.addInterceptor(httpLoggingInterceptor);
        return okHttpClient.build();
    }
}
