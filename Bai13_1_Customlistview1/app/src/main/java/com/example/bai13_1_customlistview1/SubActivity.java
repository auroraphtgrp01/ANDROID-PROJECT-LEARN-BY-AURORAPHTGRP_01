 package com.example.bai13_1_customlistview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

 public class SubActivity extends AppCompatActivity {
    TextView txt_subphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        txt_subphone = findViewById(R.id.txt_subphone);

        Intent myIntent = getIntent();
        //Lay data
    String namephone = myIntent.getStringExtra("name");
     txt_subphone.setText(namephone);

    }
}