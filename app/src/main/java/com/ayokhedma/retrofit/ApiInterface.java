package com.ayokhedma.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by MK on 07/08/2017.
 */

public interface ApiInterface {

    @GET("category.php")
    Call<List<CategoryModel>> getCategories();

    @FormUrlEncoded
    @POST("category.php")
    Call<List<CategoryModel>> getMainCategories(@Field("limit") String go);

    @FormUrlEncoded
    @POST("login.php")
    Call<UserModel> login(@Field("username") String username,
                          @Field("password") String password);
}
