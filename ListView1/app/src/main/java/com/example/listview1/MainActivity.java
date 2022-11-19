package com.example.listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_phone;
    //Khai bao Listview
    String myphone[] = {"Điện Thoại Iphone","Điện Thoại SamSung ","Điện Thoại Oppo","Điện Thoại Vivo","Điện Thoại Nokia","Điện Thoại Bphone"};
    ArrayAdapter<String> myadapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_phone = findViewById(R.id.txt_phone);
        lv = findViewById(R.id.lv);
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myphone);
        lv.setAdapter(myadapter);
        //lang nghe su kien
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt_phone.setText("Vi tri "+i+": "+myphone[i]);
            }
        });
    }
}