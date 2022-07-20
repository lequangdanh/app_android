package com.example.btl_qlnv;

import android.support.v4.app.INotificationSideChannel;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_login, btn_thoat;
    private EditText username,password;
    private int counter = 5;
    private TextView Info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        Info.setText("Số lượt đăng nhập là: 5");
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().length()!=0 && password.getText().length()!=0)
                {
                    if(username.getText().toString().equals("admin")&& password.getText().toString().equals("admin"))
                    {
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,ViewActivity.class);
                        startActivity(intent);
                    }
                    else
                    {

                        Toast.makeText(MainActivity.this,"Đăng nhập thất bại, mời thử lại!",Toast.LENGTH_SHORT).show();
                        counter--;
                        Info.setText("Bạn còn số lượt đăng nhập là: " + String.valueOf(counter));

                        if(counter == 0){
                            btn_login.setEnabled(false);
                        }
                    }
                }
                else
                {

                    Toast.makeText(MainActivity.this,"ban chua nhap tai khoan hoawc mat khau",Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void anhxa() {
        btn_thoat= findViewById(R.id.btn_thoat);
        btn_login= findViewById(R.id.btn_login);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        Info = findViewById(R.id.Info);
    }
    private void validate(String username, String password){
        if((username.equals("Admin")) && (password.equals("1234"))){
            Intent intent = new Intent(this, ViewActivity.class);
            startActivity(intent);
        }else{

            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                btn_login.setEnabled(false);
            }
        }
    }
}