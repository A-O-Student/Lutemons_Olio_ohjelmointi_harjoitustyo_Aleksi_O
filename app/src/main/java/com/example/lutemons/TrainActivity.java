package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        makeRadioButtons();
    }

    public void makeRadioButtons() {

        ArrayList<Lutemon> lutemons = TrainingArea.getInstance().getLutemons();

        RadioGroup rgTrain = findViewById(R.id.rgTrainActivity);
        rgTrain.removeAllViews();

        RadioButton rb;
        int i = 0;
        for (Lutemon l : lutemons) {

            rb = new RadioButton(this);
            rb.setText(l.getName());
            rb.setId(i++);
            rgTrain.addView(rb);
        }
        rgTrain.check(0);
    }

    public void moveSelectedToHome(View view) {
        try {
            RadioGroup rgTrain = findViewById(R.id.rgTrainActivity);
            Lutemon selectedLutemon = TrainingArea.getInstance().getLutemonById(rgTrain.getCheckedRadioButtonId());
            TrainingArea.getInstance().moveLutemonFromTraining(selectedLutemon);
            Home.getInstance().takeLutemonHome(selectedLutemon);
            makeRadioButtons();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Luultavasti ei listattuja lutemoneja");
        }
    }

    public void trainSelectedLutemon(View view) {
        try {
            RadioGroup rgTrain = findViewById(R.id.rgTrainActivity);
            Lutemon selectedLutemon = TrainingArea.getInstance().getLutemonById(rgTrain.getCheckedRadioButtonId());
            TrainingArea.getInstance().trainLutemon(selectedLutemon);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Luultavasti ei listattuja lutemoneja");
        }
    }

    public void moveSelectedToBattlefield(View view) {
        try {
            RadioGroup rgTrain = findViewById(R.id.rgTrainActivity);
            Lutemon selectedLutemon = TrainingArea.getInstance().getLutemonById(rgTrain.getCheckedRadioButtonId());
            TrainingArea.getInstance().moveLutemonFromTraining(selectedLutemon);
            Battlefield.getInstance().takeLutemonToBattlefield(selectedLutemon);
            makeRadioButtons();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Luultavasti ei listattuja lutemoneja");
        }
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}