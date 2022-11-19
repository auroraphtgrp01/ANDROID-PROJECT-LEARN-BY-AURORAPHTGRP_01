package com.example.minhtuan_bai4_amlich;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ipsec.ike.ChildSaProposal;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnchuyen;
    EditText EdtDL;
    TextView txt_amlich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdtDL = findViewById(R.id.EdtDL);
        txt_amlich = findViewById(R.id.txt_amlich);
        btnchuyen = findViewById(R.id.btnchuyen);
        btnchuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Can="", chi="";
                int namduong = Integer.parseInt(EdtDL.getText().toString());
                switch (namduong % 10)
                {
                    case 0: Can = "Canh"; break;
                    case 1: Can = "Tân"; break;
                    case 2: Can = "Nhâm"; break;
                    case 3: Can = "Quý"; break;
                    case 4: Can = "Giáp"; break;
                    case 5: Can = "Ất"; break;
                    case 6: Can = "Bính"; break;
                    case 7: Can = "Đinh"; break;
                    case 8: Can = "Mậu"; break;
                    case 9: Can = "Kỷ"; break;

                }
                switch (namduong%12)
                {
                    case 0: chi = "Thân"; break;
                    case 1: chi = "Dậu"; break;
                    case 2: chi = "Tuất"; break;
                    case 3: chi = "Hợi"; break;
                    case 4: chi = "Tí"; break;
                    case 5: chi = "Sửu"; break;
                    case 6: chi = "Dần"; break;
                    case 7: chi = "Mẹo"; break;
                    case 8: chi = "Thìn"; break;
                    case 9: chi = "Tỵ"; break;
                    case 10: chi = "Ngọ"; break;
                    case 11: chi = "Mùi"; break;
                }
                txt_amlich.setText(Can + " " +  chi);
            }
        });

    }
}