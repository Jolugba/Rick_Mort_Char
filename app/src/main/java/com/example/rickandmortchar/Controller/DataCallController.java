package com.example.rickandmortchar.Controller;

import android.util.Log;

import com.example.rickandmortchar.Api.ApiManager;
import com.example.rickandmortchar.Model.CharacterNames;
import com.example.rickandmortchar.Model.User;
import com.example.rickandmortchar.View.UsersViewInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataCallController {
    private ApiManager manager = new ApiManager();

    String TAG = DataCallController.class.getSimpleName();
    public void getUsers(final UsersViewInterface viewInterface){
        Call<List<CharacterNames>> call = manager. getService().listUsers();
        call.enqueue(new Callback<List<CharacterNames>>() {
            @Override
            public void onResponse(Call<List<CharacterNames>> call, Response<List<CharacterNames>> response) {

                if (!response.isSuccessful()){
                    Log.i(TAG,"Unsuccessful, code: "+response.code());
                    return;
                }
                else{
                    List<CharacterNames> users = response.body();
                    viewInterface.setUpAdapterAndView(users);
                }
            }
            @Override
            public void onFailure(Call<List<CharacterNames>> call, Throwable t) {
                Log.i(TAG, "Error : " + t.getLocalizedMessage());
            }
        });

}}
