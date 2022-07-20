package com.example.btl_qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    private EditText edttenphong;

    private Button btnLuu, btnThoatedit;
    private PhongBanDAO pbDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        pbDAO =new PhongBanDAO(EditActivity.this);

        Intent intent=getIntent();
        final PhongBan phongBan=(PhongBan) intent.getSerializableExtra("DuLieu");

        ANhXa();


        edttenphong.setText(phongBan.getTenphong());



        btnThoatedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                phongBan.setTenphong(edttenphong.getText().toString());
                pbDAO.UpDatePB(phongBan);
                Toast.makeText(EditActivity.this,"Lưu dữ liệu thành công",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void ANhXa() {

        edttenphong=findViewById(R.id.edt_tenphongedit);

        btnLuu=findViewById(R.id.btn_luu);
        btnThoatedit=findViewById(R.id.btn_thoatedit);

    }
}