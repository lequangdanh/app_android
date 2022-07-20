package com.example.btl_qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddNhanVienActivity extends AppCompatActivity {

    private EditText edtHoTennv, edtngaysinhnv, edtdiachinv,edtchucvunv,maphongnv,luongnv,edtsdt,edtemail;
    private RadioGroup rggioiTinh;
    private int gioitinh=1;
    private Button btnThem, btnThoat;
    private NhanVienDAO nvDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nhan_vien);
        anhxa();
        nvDao=new NhanVienDAO(AddNhanVienActivity.this);

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


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten=edtHoTennv.getText().toString();
                String ngaysinh=edtngaysinhnv.getText().toString();
                String diachi=edtdiachinv.getText().toString();
                String chucvu=edtchucvunv.getText().toString();
                String sdt=edtsdt.getText().toString();
                String email = edtemail.getText().toString();
                int maphong = Integer.parseInt(maphongnv.getText().toString());
                int luong = Integer.parseInt(luongnv.getText().toString());

                Nhanvien nv=new Nhanvien(hoten,ngaysinh,diachi,chucvu,sdt,email,gioitinh,maphong,luong);
                nvDao.ThemNV(nv);
                Toast.makeText(AddNhanVienActivity.this,"Thêm Thành Công",Toast.LENGTH_SHORT).show();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void anhxa() {
        edtHoTennv=findViewById(R.id.edt_hotenadd);
        edtngaysinhnv=findViewById(R.id.edt_ngaysinhadd);
        edtdiachinv=findViewById(R.id.edt_diachiadd);
        edtchucvunv=findViewById(R.id.edt_chucvuadd);
        edtsdt=findViewById(R.id.edt_sdtadd);
        edtemail=findViewById(R.id.edt_emailadd);
        maphongnv = findViewById(R.id.edit_maphongnvadd);
        luongnv = findViewById(R.id.edit_luongnvadd);
        rggioiTinh=findViewById(R.id.rg_gioitinhnv);
        btnThem=findViewById(R.id.btn_Them);
        btnThoat=findViewById(R.id.btn_Thoat);
    }

}