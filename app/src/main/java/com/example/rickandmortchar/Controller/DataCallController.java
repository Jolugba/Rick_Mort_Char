package com.example.rickandmortchar.Controller;

import android.util.Log;
import androidx.annotation.NonNull;
import com.example.rickandmortchar.Api.ApiManager;
import com.example.rickandmortchar.Model.CharacterNames;
import com.example.rickandmortchar.View.UsersViewInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataCallController {

    private ApiManager manager;
    private String TAG = DataCallController.class.getSimpleName();
    //todo 6: most times, you are not building your retrofit service correctly too, but before we address this, let's add an interceptor to retrofit
    //todo : You use interceptors to log other background things that happens when your url calls are being made


    //todo 11:  so let's build your retrofit class properly
    public DataCallController(){
        //build your manager class here instead
        manager = new ApiManager();
    }

    //todo 10: this is just a comment; i love that you are using an interface to listen to your succesful api response,
    //todo: you have actually tried a lot on this project to get to this phase
    public void getUsers(final UsersViewInterface viewInterface) {
        Call<List<CharacterNames>> call = manager.getService().listUsers();
        call.enqueue(new Callback<List<CharacterNames>>() {
            @Override
            public void onResponse(@NonNull Call<List<CharacterNames>> call, @NonNull Response<List<CharacterNames>> response) {

               /* if (!response.isSuccessful()) {
                    Log.i(TAG, "Unsuccessful, code: " + response.code());
                    return;
                } else {

                    List<CharacterNames> users = response.body();
                    viewInterface.setUpAdapterAndView(users);
                }*/

               //todo: I would advise you do the if statement this way
                if(response.isSuccessful()){
                    //todo 1: it comes to this block of code if you got a success response message from the api call
                    //todo 2: You can get you response body like this
                    if(response.body() != null){
                        //todo 3: You can only get the list of your users from response.body
                        List<CharacterNames> users = response.body();
                        //todo 4: Lets get the size of the user list here
                        Log.d(TAG, "Users fetched from api is of size " + users.size());
                        viewInterface.setUpAdapterAndView(users);
                    }

                } else{
                    //todo 5:  In this section, your call to the server was actually successful, but for some reasons, you couldn't get the suppossed payload
                    Log.d(TAG, "The api returned an error " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<CharacterNames>> call, @NonNull Throwable t) {
                //todo 5: when your call fails, you can get the failure message from response.message
                Log.i(TAG, "Error : " + t.getMessage());
                Log.d(TAG, "Error : " + t.getLocalizedMessage());
            }
        });

    }
}


//todo 12: Viola, if you check your logcat at this stage, you will see that your api call is made, and you can see the response format
//the issue now is the CharacterName class is not appropriately mapped to the data payload from the api
/*
* I didn't check all of the codebase but from the little I saw, I noticed the following
* 1. You do not format your codes well, in terms of spacing and formatting, it is really important to have a CLEAN code.
* 2. You do not clear your imports, try and do that.
* */