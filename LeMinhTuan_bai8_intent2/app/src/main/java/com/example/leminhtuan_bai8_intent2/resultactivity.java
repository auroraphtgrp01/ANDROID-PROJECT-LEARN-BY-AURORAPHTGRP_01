package com.example.leminhtuan_bai8_intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class resultactivity extends AppCompatActivity {
    TextView edtKQ;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultactivity);
        edtKQ = findViewById(R.id.edtKQ);
        btnback = findViewById(R.id.btnback);
        Intent myIntent=getIntent();
        Bundle mybundle = myIntent.getBundleExtra("MyPackage");
        int a = mybundle.getInt("soA");
        int b = mybundle.getInt("soB");
       int x=0;
        if(a==0){
            if(b==0) {
                edtKQ.setText("PT VO SO NGHIEM");
        }
            else edtKQ.setText("PT VO NGHIEM");
    }
        else {
            x=-b/a;
            edtKQ.toString().;
        }

                }
    }