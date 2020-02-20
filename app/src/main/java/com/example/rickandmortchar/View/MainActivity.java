/***
 * Copyright (c) 2020 Esther Jolugba
 * All rights reserved
 * Created on Feb 16-02-2020
 */
package com.example.rickandmortchar.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.rickandmortchar.Controller.DataCallController;
import com.example.rickandmortchar.Controller.MainController;
import com.example.rickandmortchar.Model.User;
import com.example.rickandmortchar.R;
import com.example.rickandmortchar.Utils.UsersAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  UsersViewInterface {

    UsersAdapter adapter;
    String TAG = MainActivity.class.getSimpleName();
    private List<User> listOfUsers;
    private RecyclerView recyclerView;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        controller = new MainController(this, new DataCallController());
        getControllerUsers();
    }

    private void getControllerUsers() {
        controller.getUsersFromDataSource();
    }
    public void setUpAdapterAndView(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
        if(this.listOfUsers != null){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new UsersAdapter(this, listOfUsers);
            recyclerView.setAdapter(adapter);
        }
        else{
            Log.i(TAG, "user list is empty");
        }

    }


    }

