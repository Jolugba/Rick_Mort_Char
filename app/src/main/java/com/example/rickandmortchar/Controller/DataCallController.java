package com.example.rickandmortchar.Controller;
import android.util.Log;
import com.example.rickandmortchar.Api.ApiManager;
import com.example.rickandmortchar.Model.CharacterNames;
import com.example.rickandmortchar.Model.Result;
import com.example.rickandmortchar.View.UsersViewInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataCallController {
    private ApiManager manager = new ApiManager();

    String TAG = DataCallController.class.getSimpleName();
    public void getUsers(final UsersViewInterface viewInterface){
        Call<CharacterNames> call = manager. getService().listUsers();
        call.enqueue(new Callback<CharacterNames>() {
            @Override
            public void onResponse(Call<CharacterNames> call, Response<CharacterNames> response) {
                Log.i(TAG,"Unsuccessful, code: "+response.code());
                if (!response.isSuccessful()){
                    Log.i(TAG,"Unsuccessful, code: "+response.code());
                    return;
                }
                else{
                    Log.i(TAG,"successful, code: "+response.code());

                    List<Result> users = response.body().getResults();
                    viewInterface.setUpAdapterAndView(users);
                }
            }
            @Override
            public void onFailure(Call<CharacterNames> call, Throwable t) {
                Log.i(TAG, "Error : " + t.getLocalizedMessage());
            }
        });

}}
