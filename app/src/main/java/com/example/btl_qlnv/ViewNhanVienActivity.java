package com.example.btl_qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewNhanVienActivity extends AppCompatActivity {
    private ListView lv_nv;
    private List<Nhanvien> nhanvienList;
    private NhanVienAdapter adapter;
    private NhanVienDAO nvDao;
    private DBHelper db;
    private Button btn_Searchnv;
    private EditText edtSearchnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_nhan_vien);
        Intent intent = getIntent();
        PhongBan pb = (PhongBan) intent.getSerializableExtra("DULIEUNV");
        anhxa();

        nhanvienList=new ArrayList<Nhanvien>();
        nvDao=new NhanVienDAO(ViewNhanVienActivity.this);
        nhanvienList=nvDao.getAllNV( pb.getId_phong());

        adapter=new NhanVienAdapter(getApplicationContext(),nhanvienList);
        lv_nv.setAdapter(adapter);
        registerForContextMenu(lv_nv);
        btn_Searchnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhanvienList= (List<Nhanvien>) nvDao.SearchNV(edtSearchnv.getText().toString());
                adapter=new NhanVienAdapter(getApplicationContext(),nhanvienList);
                lv_nv.setAdapter(adapter);
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch (id){
            case R.id.menu_them:{
                Intent intent=new Intent(ViewNhanVienActivity.this, AddNhanVienActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_thoat:
                finish();
        }
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_tuychon2,menu);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos=info.position;
        Nhanvien nv =nhanvienList.get(pos);
        switch (item.getItemId()){
            case R.id.menu_suanv:{

                Intent intent=new Intent(ViewNhanVienActivity.this, EditNhanVienActivity.class);

                intent.putExtra("DuLieunv",nv);
                startActivity(intent);
                break;
            }
            case R.id.menu_sendemail:{

                Intent intent=new Intent(ViewNhanVienActivity.this, SendEmailActivity.class);

                intent.putExtra("DuLieunvemail",nv);
                startActivity(intent);
                break;
            }
            case R.id.menu_sendsms:{

                Intent intent=new Intent(ViewNhanVienActivity.this, SendSMSActivity.class);

                intent.putExtra("DuLieunvemail",nv);
                startActivity(intent);
                break;
            }
            case R.id.menu_xoanv:{
                nvDao.XoaNV(nv.getManhanvien());
                adapter.notifyDataSetChanged();
                onResume();
                break;
            }
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        PhongBan pb = (PhongBan) intent.getSerializableExtra("DULIEUNV");
        nhanvienList.clear();
        nhanvienList.addAll(nvDao.getAllNV(pb.getId_phong()));
        adapter.notifyDataSetChanged();
    }


    private void anhxa() {
        lv_nv=findViewById(R.id.lv_nv);
        edtSearchnv=findViewById(R.id.edt_timkiemnv);
        btn_Searchnv=findViewById(R.id.btn_TimKiemnv);
    }
}