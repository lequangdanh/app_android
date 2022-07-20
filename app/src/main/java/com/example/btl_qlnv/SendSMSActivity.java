package com.example.btl_qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSActivity extends AppCompatActivity {
    private EditText edt_to, edt_mess;
    private Button bt_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smsactivity);
        anhxa();
        Intent intent=getIntent();
        final Nhanvien nhanvien=(Nhanvien) intent.getSerializableExtra("DuLieunvemail");
        edt_to.setText(nhanvien.getSdt());
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED)
                    {
                        sendSMS();
                    }
                    else
                    {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                    }
                }

            }
        });

    }

    private void anhxa() {
        edt_to = findViewById(R.id.edt_tosms);

        edt_mess=findViewById(R.id.edt_messagesms);
        bt_send=findViewById(R.id.bt_sendsms);

    }
    private void sendSMS() {

        Log.i("Send SMS", "");
        String phoneNo = edt_to.getText().toString();
        String message = edt_mess.getText().toString();
        try
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();

        }
        catch (Exception e)
        { Toast.makeText(getApplicationContext(), "SMS faild, please try again.",
                Toast.LENGTH_LONG).show();

            e.printStackTrace();

        }
    }
}