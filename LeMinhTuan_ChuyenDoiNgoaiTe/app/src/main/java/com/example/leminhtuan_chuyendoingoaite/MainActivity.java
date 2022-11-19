package com.example.leminhtuan_chuyendoingoaite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity {
    EditText vndto1,tovnd;
    RadioGroup id1;
    RadioButton usd_button,eur_button,jpy_button;
    Button btn_vnd,btn_nt,btn_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vndto1 = findViewById(R.id.vndto1);
        int trans = Integer.parseInt(vndto1.getText().toString());

        tovnd = findViewById(R.id.vndto1);
        int trannt = Integer.parseInt(tovnd.getText().toString());
        btn_clear = findViewById(R.id.btn_clear);
        btn_vnd = findViewById(R.id.btn_vnd);
        btn_nt = findViewById(R.id.btn_nt);
        id1 = findViewById(R.id.id1);
        btn_vnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=id1.getCheckedRadioButtonId();
                int mg = 0;

                RadioButton radselect = findViewById(id);
                if(radselect == usd_button ) {
                    mg = trans / 22280;
                }
                if(radselect == eur_button ) {
                    mg = trans / 24280;
                }
                if(radselect == usd_button ) {
                    mg = trans / 204;
                }
                tovnd.setText(mg);
            }
        });



    }

}