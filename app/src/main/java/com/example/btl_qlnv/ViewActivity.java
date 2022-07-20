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

public class ViewActivity extends AppCompatActivity {
    private ListView lvPhongBan;
    private List<PhongBan> phongbanList;
    private PhongBanAdapter adapter;
    private PhongBanDAO pbDao;
    private DBHelper db;
    private Button btn_Searchpb;
    private EditText edtSearchpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        anhxa();
        phongbanList=new ArrayList<PhongBan>();
        pbDao=new PhongBanDAO(ViewActivity.this);
        phongbanList=pbDao.getAllPB();
        adapter=new PhongBanAdapter(getApplicationContext(),phongbanList);
        lvPhongBan.setAdapter(adapter);
        registerForContextMenu(lvPhongBan);
        btn_Searchpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phongbanList= (List<PhongBan>) pbDao.SearchPB(edtSearchpb.getText().toString());
                adapter=new PhongBanAdapter(getApplicationContext(),phongbanList);
                lvPhongBan.setAdapter(adapter);
            }
        });
        lvPhongBan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PhongBan pb = phongbanList.get(i);
                Intent intent= new Intent(ViewActivity.this,ViewNhanVienActivity.class);
                intent.putExtra("DULIEUNV",pb);
                startActivity(intent);
                Toast.makeText(ViewActivity.this,"Truy cập thành công",Toast.LENGTH_SHORT).show();
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
                Intent intent=new Intent(ViewActivity.this, AddActivity.class);
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
        inflater.inflate(R.menu.menu_tuychon,menu);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos=info.position;
        PhongBan pb =phongbanList.get(pos);
        switch (item.getItemId()){
            case R.id.menu_sua:{

                Intent intent=new Intent(ViewActivity.this, EditActivity.class);

                intent.putExtra("DuLieu",pb);
                startActivity(intent);
                break;
            }
            case R.id.menu_xoa:{
                pbDao.XoaPB(pb.getId_phong());
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
        phongbanList.clear();
        phongbanList.addAll(pbDao.getAllPB());
        adapter.notifyDataSetChanged();
    }

    private void anhxa() {
        lvPhongBan=findViewById(R.id.lv_pb);
        edtSearchpb=findViewById(R.id.edt_timkiempb);
        btn_Searchpb=findViewById(R.id.btn_TimKiempb);
    }
}