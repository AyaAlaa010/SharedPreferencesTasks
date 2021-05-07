package com.example.sharedpreferencestasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences=getSharedPreferences("user",MODE_PRIVATE);
        preferences.edit().putString("username","aya").apply();//for add value
        String userName=preferences.getString("username","not found"); //for get value
        Log.i(TAG, "onCreate: xxxxxxxx "+userName);


        preferences.edit().putString("accesToken","Bearer "+"token").apply();
        String accessToken=preferences.getString("accesToken","");
        //for get value
        if(accessToken.isEmpty()){
            Toast.makeText(MainActivity.this,"access token not found ",Toast.LENGTH_LONG).show();
        }
        else{
            Log.i(TAG, "onCreate: "+"access token ="+accessToken);
        }
// level2 store object
        User user=new User("aya alaa","aya@yahoo.com","01092098006");
String userGson=new Gson().toJson(user);
preferences.edit().putString("userData",userGson).apply();
String newUserGson=preferences.getString("userData","");
User newUser=new Gson().fromJson(newUserGson,User.class);
        Log.i(TAG, "onCreate: "+newUser.getEmail());
        Log.i(TAG, "onCreate: "+newUser);

    }
}