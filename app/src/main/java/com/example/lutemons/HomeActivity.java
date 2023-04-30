package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        makeRadioButtons();
    }

    public void makeRadioButtons() {

        ArrayList<Lutemon> lutemons = Home.getInstance().getLutemons();

        RadioGroup rgHome = findViewById(R.id.rgHomeActivity);
        rgHome.removeAllViews();

        RadioButton rb;
        int i = 0;
        for (Lutemon l : lutemons) {

            rb = new RadioButton(this);
            rb.setText(l.getName());
            rb.setId(i++);
            rgHome.addView(rb);
        }
        rgHome.check(0);

    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void moveSelectedToTrain(View view) {
        try {
            RadioGroup rgHome = findViewById(R.id.rgHomeActivity);
            Lutemon selectedLutemon = Home.getInstance().getLutemonById(rgHome.getCheckedRadioButtonId());
            Home.getInstance().moveLutemonFromHome(selectedLutemon);
            TrainingArea.getInstance().takeLutemonTraining(selectedLutemon);
            makeRadioButtons();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Luultavasti ei listattuja lutemoneja");
        }
    }

    public void moveSelectedToBattle(View view) {
        try {
            RadioGroup rgHome = findViewById(R.id.rgHomeActivity);
            Lutemon selectedLutemon = Home.getInstance().getLutemonById(rgHome.getCheckedRadioButtonId());
            Home.getInstance().moveLutemonFromHome(selectedLutemon);
            Battlefield.getInstance().takeLutemonToBattlefield(selectedLutemon);
            makeRadioButtons();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Luultavasti ei listattuja lutemoneja");
        }
    }

}