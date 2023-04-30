package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemons(View view) {
        Intent intent = new Intent(this, ListLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void switchToTrain(View view) {
        Intent intent = new Intent(this, TrainActivity.class);
        startActivity(intent);
    }

    public void switchToBattle(View view) {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }

}