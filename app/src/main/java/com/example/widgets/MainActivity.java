package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prf;

    Switch aSwitch;

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





    }
}
