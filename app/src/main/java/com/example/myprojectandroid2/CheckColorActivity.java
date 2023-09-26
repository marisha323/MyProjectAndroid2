package com.example.myprojectandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class CheckColorActivity extends AppCompatActivity {
    private LinearLayout container;
    private CheckBox redCheckBox,greenCheckBox,blueCheckBox,yellowCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_color);
        container=findViewById(R.id.container);
        redCheckBox=findViewById(R.id.redCheckBox);
        greenCheckBox=findViewById(R.id.greenCheckBox);
        blueCheckBox=findViewById(R.id.blueCheckBox);
        yellowCheckBox=findViewById(R.id.yellowCheckBox);


        redCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateBackgroundColor();
            }
        });

        greenCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateBackgroundColor();
            }
        });

        blueCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateBackgroundColor();
            }
        });
        yellowCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateBackgroundColor();
            }
        });
    }

    private void updateBackgroundColor() {
        int red=redCheckBox.isChecked()? Color.RED:0;
        int green=greenCheckBox.isChecked()?Color.GREEN:0;
        int blue = blueCheckBox.isChecked()?Color.BLUE:0;
        int yellow=yellowCheckBox.isChecked()?Color.YELLOW:0;

        int backgroundColor=red|green|blue|yellow;
        container.setBackgroundColor(backgroundColor);
    }
}