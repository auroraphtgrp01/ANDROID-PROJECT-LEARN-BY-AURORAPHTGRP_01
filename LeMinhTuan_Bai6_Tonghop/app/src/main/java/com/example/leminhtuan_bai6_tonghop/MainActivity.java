package com.example.leminhtuan_bai6_tonghop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity<ten> extends AppCompatActivity {
EditText edthoten, edtcmnd, edtbosung;
CheckBox chkdocbao, chkdocsach, chkcoding;
Button btnsend;
RadioGroup idgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edthoten = findViewById(R.id.edthoten);
        edtcmnd = findViewById(R.id.edtcmnd);
        edtbosung = findViewById(R.id.edtbosung);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkcoding = findViewById(R.id.chkcoding);
        chkdocsach = findViewById(R.id.chkdocsach);
        btnsend = findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ten=edthoten.getText().toString();
                if(ten.length()<3)
                {
                    edthoten.requestFocus();
                    edthoten.selectAll();
                    Toast.makeText(MainActivity.this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
                    return;
                }
                //kiểm tra CMND hợp lệ
                String cmnd= edtcmnd.getText().toString();
                cmnd=cmnd.trim();
                if(cmnd.length()!=9)
                {
                    edtcmnd.requestFocus();
                    edtcmnd.selectAll();
                    Toast.makeText(MainActivity.this, "CMND phải đúng 9 ký tự",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                //Kiểm tra bằng cấp
                String bang="";
                idgroup = findViewById(R.id.idgroup);
                int id=idgroup.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(id);
                bang=radselect.getText().toString();
                //Lấy tt sỏ thích
                String sothich="";
                if(chkdocbao.isChecked()) {
                    sothich += chkdocbao.getText().toString()+"\n";
                }
                if(chkcoding.isChecked()){
                    sothich += chkcoding.getText().toString()+"\n";
                }
                if(chkdocsach.isChecked()){
                    sothich += chkdocsach.getText().toString();
                }
                //lấy thông tin bổ sung
                String bosung = edtbosung.getText().toString();
                //Tổng hợp thông tin
                String tonghop=ten+"\n"+cmnd+"\n"+bang+"\n"+sothich+"\n"+"\n";
                tonghop+="------------THÔNG TIN BỔ SUNG----------\n";
                tonghop+=bosung+"\n";
                tonghop+="--------------------------------------------------------";
                //tạo dialog
                AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Thông Tin Cá Nhân");
                dialog.setMessage(tonghop);
                dialog.setNegativeButton("ĐÓNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dialog.create().show();
            }
        }

        );

    }







    @Override
    public void onBackPressed() {
        AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
        mydialog.setTitle("Cảnh Báo !");
        mydialog.setMessage("Bạn có muốn thoát ứng dụng không ? ");
        mydialog.setIcon(R.drawable.iconwarning);
        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
    mydialog.create().show();
    }





}