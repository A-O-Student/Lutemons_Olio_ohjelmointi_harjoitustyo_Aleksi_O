package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private LinearLayout checkBoxContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        makeRadioButtons();
        makeCheckBoxButtons();
    }

    public void makeRadioButtons() {

        ArrayList<Lutemon> lutemons = Battlefield.getInstance().getLutemons();

        RadioGroup rgBattle = findViewById(R.id.rgBattleActivity);
        rgBattle.removeAllViews();

        RadioButton rb;
        int i = 0;
        for (Lutemon l : lutemons) {

            rb = new RadioButton(this);
            rb.setText(l.getName());
            rb.setId(i++);
            rgBattle.addView(rb);
        }
        rgBattle.check(0);

    }

    public void makeCheckBoxButtons() {
        checkBoxContainer = findViewById(R.id.checkboxContainer);
        checkBoxContainer.removeAllViews();

        ArrayList<Lutemon> lutemons = Battlefield.getInstance().getLutemons();

        CheckBox cb;
        int j = 0;
        for (Lutemon l : lutemons) {

            cb = new CheckBox(this);
            cb.setText(l.getName());
            cb.setId(j++);
            checkBoxContainer.addView(cb);
        }
    }

    public void moveSelectedToHome(View view) {
        try {
            RadioGroup rgBattle = findViewById(R.id.rgBattleActivity);
            Lutemon selectedLutemon = Battlefield.getInstance().getLutemonById(rgBattle.getCheckedRadioButtonId());
            Battlefield.getInstance().moveLutemonFromBattlefield(selectedLutemon);
            Home.getInstance().takeLutemonHome(selectedLutemon);
            makeRadioButtons();
            makeCheckBoxButtons();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Luultavasti ei listattuja lutemoneja");
        }
    }

    public void moveSelectedToTrain(View view) {
        try {
            RadioGroup rgBattle = findViewById(R.id.rgBattleActivity);
            Lutemon selectedLutemon = Battlefield.getInstance().getLutemonById(rgBattle.getCheckedRadioButtonId());
            Battlefield.getInstance().moveLutemonFromBattlefield(selectedLutemon);
            TrainingArea.getInstance().takeLutemonTraining(selectedLutemon);
            makeRadioButtons();
            makeCheckBoxButtons();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Luultavasti ei listattuja lutemoneja");
        }
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void makeLutemonsFight(View view) {
        int count = checkBoxContainer.getChildCount();
        ArrayList<Lutemon> lutemons = Battlefield.getInstance().getLutemons();
        ArrayList<Integer> idList = new ArrayList<>();
        TextView txtFight = findViewById(R.id.txtFight);

        for (int i = 0; i < count; i++) {
            view = checkBoxContainer.getChildAt(i);
            if (view instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) view;
                if (checkBox.isChecked()) {
                    System.out.println("Lutemon " + lutemons.get(i).getName() + " on valittu.");
                    idList.add(i);
                }
            }
        }

        if (idList.size() != 2) {
            txtFight.setText("Väärä määrä lutemoneja valittu!");
        } else {
            Battlefield.getInstance().makeLutemonsFight(lutemons.get(idList.get(0)), lutemons.get(idList.get(1)), txtFight);
        }
        makeRadioButtons();
        makeCheckBoxButtons();
    }

}