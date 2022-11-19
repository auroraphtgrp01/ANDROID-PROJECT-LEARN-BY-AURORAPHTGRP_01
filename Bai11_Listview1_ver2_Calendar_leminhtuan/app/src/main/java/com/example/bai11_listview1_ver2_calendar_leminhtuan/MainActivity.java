package com.example.bai11_listview1_ver2_calendar_leminhtuan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> Arraywork;
    ArrayAdapter<String> arrAdapter;
    EditText edth, edtm, edtwork;
    TextView edt_today;
    Button btn_add, btn_dele;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edth = findViewById(R.id.edth);
        edtm = findViewById(R.id.edtm);
        edtwork = findViewById(R.id.edtwork);
        edt_today = findViewById(R.id.edt_today);
        btn_add = findViewById(R.id.btn_add);
        btn_dele = findViewById(R.id.btn_dele);
        lv = findViewById(R.id.lv);
        Arraywork = new ArrayList<String>();
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arraywork);
        lv.setAdapter(arrAdapter);
        Date currentDate = Calendar.getInstance().getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        edt_today.setText("Hôm Nay: " + simpleDateFormat.format(currentDate));
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtwork.getText().toString().equals("") == false || edth.getText().toString().equals("") == false
                        || edtm.getText().toString().equals("") == false) {
                    if (edth.getText().toString().length() >= 0 && edth.getText().toString().length() <= 2) {
                        if (edtm.getText().toString().length() >= 0 && edtm.getText().toString().length() <= 2) {
                            if (Integer.parseInt(edth.getText().toString()) >= 0
                                    && Integer.parseInt(edth.getText().toString()) < 24) {
                                if (Integer.parseInt(edtm.getText().toString()) >= 0
                                        && Integer.parseInt(edtm.getText().toString()) < 60) {
                                    if (edtwork.getText().toString().equals("") || edth.getText().toString().equals("")
                                            || edtm.getText().toString().equals("")) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                        builder.setTitle("Info missing");
                                        builder.setMessage("Please enter all information of the work");
                                        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                            }
                                        });
                                        builder.show();
                                    } else {
                                        String str = edtwork.getText().toString() + " - " + edth.getText().toString()
                                                + ":" + edtm.getText().toString();
                                        Arraywork.add(str);
                                        arrAdapter.notifyDataSetChanged();
                                        edth.setText("");
                                        edtm.setText("");
                                        edtwork.setText("");
                                    }
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "Wrong Format !", Toast.LENGTH_LONG).show();
                            }
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong Format !", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                btn_dele.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (Arraywork.size() != 0) {
                            Arraywork.remove(i);
                            arrAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        });
    }
}