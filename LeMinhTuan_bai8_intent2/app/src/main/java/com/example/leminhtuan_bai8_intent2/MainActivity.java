package com.example.leminhtuan_bai8_intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnresult;
    EditText edtsoA,edtsoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtsoA = findViewById(R.id.edtsoA);
        edtsoB = findViewById(R.id.edtsoB);
        btnresult = findViewById(R.id.btnresult);
        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this,resultactivity.class);
                Bundle mybundle = new Bundle();
                int soA = Integer.parseInt(edtsoA.getText().toString());
                int soB = Integer.parseInt(edtsoB.getText().toString());
                mybundle.putInt("soA",soA);
                mybundle.putInt("soB",soB);
                myIntent.putExtra("MyPackage",mybundle);
                startActivity(myIntent);

            }
        });
    }
}