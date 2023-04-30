package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText name;
    private String sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
    }

    public void addLutemon(View view) {

        RadioGroup rgLutemonType = findViewById(R.id.rgLutemons);
        name = findViewById(R.id.editTextLutemonName);
        sName = String.valueOf(name.getText());

        if(sName != null && !sName.trim().isEmpty()) {
            switch (rgLutemonType.getCheckedRadioButtonId()) {
                case R.id.rbBlack:
                    Storage.getInstance().addLutemon(new Black(sName));
                    break;
                case R.id.rbGreen:
                    Storage.getInstance().addLutemon(new Green(sName));
                    break;
                case R.id.rbOrange:
                    Storage.getInstance().addLutemon(new Orange(sName));
                    break;
                case R.id.rbPink:
                    Storage.getInstance().addLutemon(new Pink(sName));
                    break;
                case R.id.rbWhite:
                    Storage.getInstance().addLutemon(new White(sName));
                    break;
            }
        } else {
            switch (rgLutemonType.getCheckedRadioButtonId()) {
                case R.id.rbBlack:
                    Storage.getInstance().addLutemon(new Black());
                    break;
                case R.id.rbGreen:
                    Storage.getInstance().addLutemon(new Green());
                    break;
                case R.id.rbOrange:
                    Storage.getInstance().addLutemon(new Orange());
                    break;
                case R.id.rbPink:
                    Storage.getInstance().addLutemon(new Pink());
                    break;
                case R.id.rbWhite:
                    Storage.getInstance().addLutemon(new White());
                    break;
            }
        }
    }

    public void switchToMainMenuFromAddLutemon(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}