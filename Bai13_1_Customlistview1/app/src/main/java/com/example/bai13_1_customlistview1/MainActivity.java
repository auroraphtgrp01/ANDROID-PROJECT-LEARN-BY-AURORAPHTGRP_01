package com.example.bai13_1_customlistview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.samsung,R.drawable.htc,R.drawable.ip,R.drawable.lg,R.drawable.sky,R.drawable.wp};
    String name[] = {"Điện thoại SamSung","Điện Thoại Iphone","Điện Thoại HTC","Điện Thoại LG","Điện Thoại Sky","Điện Thoại Windows Phone"};
    String pricePhone[]={"100000","200000","500000","7000000","900000","7800000"};
    //Khai Báo Listview
    ArrayList<Phone> myList;
    myArrayAdapter myAdapter;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        myList= new ArrayList<>();
        for(int i=0; i<name.length; i++){
            myList.add(new Phone(image[i],name[i],pricePhone[i]));
        }
        myAdapter= new myArrayAdapter(MainActivity.this,R.layout.layout_item,myList);
        lv.setAdapter(myAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(MainActivity.this, SubActivity.class);
                myIntent.putExtra("name",name[i]);
                myIntent.putExtra("gia",pricePhone[i]);
                startActivity(myIntent);
            }
        });
    }


}