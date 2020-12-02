package com.alaminkarno.signupcheckboxvisibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    Button button;
    AutoCompleteTextView bloodGroupTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkboxID);
        button = findViewById(R.id.signupBTN);
        bloodGroupTV = findViewById(R.id.bloodGroupTV);

        String [] bloodGroup = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,bloodGroup);
        bloodGroupTV.setAdapter(arrayAdapter);
        bloodGroupTV.setThreshold(1);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    button.setVisibility(View.VISIBLE);
                }
                else {
                    button.setVisibility(View.INVISIBLE);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Sign up Done", Toast.LENGTH_SHORT).show();
            }
        });

    }
}