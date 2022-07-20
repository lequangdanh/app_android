package com.example.btl_qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmailActivity extends AppCompatActivity {
private EditText edt_to, edt_mess,edt_sub;
private Button bt_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        anhxa();
        Intent intent=getIntent();
        final Nhanvien nhanvien=(Nhanvien) intent.getSerializableExtra("DuLieunvemail");
        edt_to.setText(nhanvien.getEmail());
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }

    private void anhxa() {
        edt_to = findViewById(R.id.edt_to);
        edt_sub = findViewById(R.id.edt_subject);
        edt_mess=findViewById(R.id.edt_message);
        bt_send=findViewById(R.id.bt_send);
    }
    private void sendMail() {

        String recipient = edt_to.getText().toString();


        String subject = edt_sub.getText().toString();
        String message = edt_mess.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
       intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

       intent.setType("message/rfc822");
       startActivity(Intent.createChooser(intent, "Choose an email client"));

    }
}