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

public class activity_sendsms extends AppCompatActivity {
    EditText edtSMS;
    ImageButton btnsms;
    Button btn_backsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendsms);
        edtSMS = findViewById(R.id.edtSMS);
        btn_backsms = findViewById(R.id.btn_backsms);
        btnsms = findViewById(R.id.btnsms);
        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsintent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + edtSMS.getText().toString()));
                // Yêu cầu người dùng đồng ý quyền truy cập vào tính năng gọi điện
                if (ActivityCompat.checkSelfPermission(activity_sendsms.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity_sendsms.this, new String[]{Manifest.permission.SEND_SMS},1);
                    return;
                }

                startActivity(smsintent);
            }
        });
        btn_backsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}