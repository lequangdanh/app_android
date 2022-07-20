package com.example.btl_qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private EditText edtmaphong, edttenphong;


    private Button btnThem, btnThoat;
    private PhongBanDAO pbDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        AnhXa();
        pbDao=new PhongBanDAO(AddActivity.this);
        // bắt sự kiện

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maphong = Integer.parseInt(edtmaphong.getText().toString());
                String tenphong=edttenphong.getText().toString();
                PhongBan pb=new PhongBan(maphong,tenphong);
                pbDao.ThemPB(pb);
                Toast.makeText(AddActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void AnhXa() {
        edtmaphong = findViewById(R.id.edt_maphong);
        edttenphong=findViewById(R.id.edt_tenphong);

        btnThem=findViewById(R.id.btn_Them);
        btnThoat=findViewById(R.id.btn_Thoat);
    }
}