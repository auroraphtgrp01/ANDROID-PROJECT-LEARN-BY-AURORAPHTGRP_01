
package com.example.bai8_intent_call_sms_leminhtuan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class activity_call_phone extends AppCompatActivity {
    EditText edtPhone;
    Button btnback;
    ImageButton btn_call01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
        btnback = findViewById(R.id.btn_back);
        btn_call01 = findViewById(R.id.btn_call01);
        edtPhone = findViewById(R.id.edtPhone);
        btn_call01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent ẩn
                Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edtPhone.getText().toString()));
                // Yêu cầu người dùng đồng ý quyền truy cập vào tính năng gọi điện
                if (ActivityCompat.checkSelfPermission(activity_call_phone.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity_call_phone.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    return;
                }

                startActivity(callintent);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}