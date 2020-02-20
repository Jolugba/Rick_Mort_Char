package com.example.rickandmortchar.Api;
import com.example.rickandmortchar.Model.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("characters")
    Call<List<User>> listUsers();

    @GET("characters/{id}")
    Call<List<User>> listUsersId(@Path("id") int id);

    @GET("characters/{id}")
    Call<List<User>> getTodosUsingQuery(@Query("id") int id);

    @GET("characters/{name}")
    Call<List<User>> getName(@Path("name") String name);

    @GET("characters/{id}")
    Call<List<User>> getNameUsingQuery(@Query("name") String name);

    @GET("characters/{id}")
    Call<List<User>> getImage(@Path("image") String image);

    @GET("characters/{id}")
    Call<List<User>> getImageUsingQuery(@Query("image") String image);



}
