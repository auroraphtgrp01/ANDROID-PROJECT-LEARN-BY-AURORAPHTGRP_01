package com.example.bai13_1_customlistview1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class myArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int id_layout;
    ArrayList<Phone> myList;
    //Tạo contractor


    public myArrayAdapter(Activity context1, int id_layout, ArrayList<Phone> myList) {
        super(context1, id_layout,myList);
        this.context = context1;
        this.id_layout = id_layout;
        this.myList = myList;
    }
    //gọi hàm getview

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //tạo để chứ layout
        LayoutInflater myflater =context.getLayoutInflater();
        convertView = myflater.inflate(id_layout,null);
        //lấy phần tủ trong mảng
        Phone myPhone = myList.get(position);
        //Khai báo tham chiếu id img
        ImageView img_phone=convertView.findViewById(R.id.img_phone);
        img_phone.setImageResource(myPhone.getImage());
        //Khai báo, tham chiếu id, hiển thiện tên đt
        TextView txt_phone=convertView.findViewById(R.id.txt_phone);
        txt_phone.setText(myPhone.getNamePhone());
        //
        TextView txt_price=convertView.findViewById(R.id.txt_price1);
        txt_price.setText(myPhone.getPricePhone());
        return convertView;
    }
}
