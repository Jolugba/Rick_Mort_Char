package com.example.rickandmortchar.Api;
import com.example.rickandmortchar.Model.CharacterNames;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/character/")
    Call<CharacterNames> listUsers();




}
