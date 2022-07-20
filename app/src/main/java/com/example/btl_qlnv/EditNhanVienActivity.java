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

public class EditNhanVienActivity extends AppCompatActivity {
    private EditText edtHoTennv, edtngaysinhnv, edtdiachinv,edtchucvunv,maphongnv,luongnv,edtsdtnv,edtemailnv;
    private RadioGroup rggioiTinh;
    private RadioButton rbNam, rbNu;
    private int gioitinh=1;
    private Button btnLuu, btnThoat;
    private NhanVienDAO nvsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nhan_vien);
        Intent intent=getIntent();
        final Nhanvien nhanvien=(Nhanvien) intent.getSerializableExtra("DuLieunv");
        nvsDao =new NhanVienDAO(EditNhanVienActivity.this);
        anhxa();


       // anhxa();


        edtHoTennv.setText(nhanvien.getTennhanvien());
        edtngaysinhnv.setText(nhanvien.getNgaysinh());
        edtdiachinv.setText(nhanvien.getDiachi());
        edtchucvunv.setText(nhanvien.getChucvu());
         edtsdtnv.setText(nhanvien.getSdt());
         edtemailnv.setText(nhanvien.getEmail());
        maphongnv.setText(String.valueOf(nhanvien.getMaphong()));
        luongnv.setText(String.valueOf(nhanvien.getLuong()));
        if(nhanvien.getGioitinh()==1){
            rbNam.setChecked(true);
            gioitinh=1;
        }else {
            rbNu.setChecked(true);
            gioitinh=0;
        }



        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        rggioiTinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_nam){
                    gioitinh=1;
                }else {
                    gioitinh=0;
                }
            }
        });

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nhanvien.setTennhanvien(edtHoTennv.getText().toString());
                nhanvien.setNgaysinh(edtngaysinhnv.getText().toString());
                nhanvien.setDiachi(edtdiachinv.getText().toString());
                nhanvien.setChucvu(edtchucvunv.getText().toString());
                nhanvien.setSdt(edtsdtnv.getText().toString());
                nhanvien.setEmail(edtemailnv.getText().toString());
                nhanvien.setGioitinh(gioitinh);
                nhanvien.setMaphong(Integer.parseInt(maphongnv.getText().toString()));
                nhanvien.setLuong(Integer.parseInt(luongnv.getText().toString()));


                nvsDao.UpDateNV(nhanvien);
                Toast.makeText(EditNhanVienActivity.this,"Lưu dữ liệu thành công",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void anhxa() {
        edtHoTennv=findViewById(R.id.edt_hotenedit);
        edtngaysinhnv=findViewById(R.id.edt_ngaysinhedit);
        edtdiachinv=findViewById(R.id.edt_diachiedit);
        edtchucvunv=findViewById(R.id.edt_chucvuedit);
        edtsdtnv = findViewById(R.id.edt_sdtedit);
        edtemailnv=findViewById(R.id.edt_emailedit);
        maphongnv = findViewById(R.id.edit_maphongnvedit);
        luongnv = findViewById(R.id.edit_luongnvedit);
        rggioiTinh=findViewById(R.id.rg_gioitinhnv);
        btnLuu=findViewById(R.id.btn_Luu);
        btnThoat=findViewById(R.id.btn_Thoat);
        rbNam=findViewById(R.id.rb_nam);
        rbNu=findViewById(R.id.rb_nu);
    }
}