package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prf;

    Switch aSwitch;
    ToggleButton toggleButton;
    CheckBox checkBox;
    CheckedTextView checkedTextView;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prf = getPreferences(MODE_PRIVATE);

        // ------- SWITCH

        aSwitch = findViewById(R.id.switch2);
        aSwitch.setChecked(prf.getBoolean("SW", false));
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prf.edit().putBoolean("SW", isChecked).apply();
            }
        });

        // ------- TOGGLE BUTTON

        toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setChecked(prf.getBoolean("TB",false));
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prf.edit().putBoolean("TB", isChecked).apply();
            }
        });

        // ------- CHECKBOX

        checkBox = findViewById(R.id.checkBox);
        checkBox.setChecked(prf.getBoolean("CB",false));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prf.edit().putBoolean("CB", isChecked).apply();
            }
        });

        // ------- CHECKEDTEXTVIEW

        checkedTextView = findViewById(R.id.checkedTextView);
        checkedTextView.setChecked(prf.getBoolean("CTV",false));
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedTextView.toggle();
                prf.edit().putBoolean("CTV", checkedTextView.isChecked()).apply();
            }
        });

        // ------- RADIOGROUP
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.check(prf.getInt("RG", radioGroup.getCheckedRadioButtonId()));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                prf.edit().putInt("RG", checkedId).apply();
            }
        });

    }
}
