package com.ayokhedma.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    EditText username,password;
    ApiInterface apiInterface;
    Retrofit retrofit;
    UserModel user;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        name  = (TextView) findViewById(R.id.name);


    }
    public void login(View view){
        retrofit = new Retrofit.Builder().baseUrl("http://ayokhedma.com/app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        Call<UserModel> log = apiInterface.login(
                username.getText().toString(),
                password.getText().toString()
        );

        log.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                user = response.body();
                name.setText(user.getName());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(Main2Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
