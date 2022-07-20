package com.example.btl_qlnv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    private DBHelper csdl;
    public NhanVienDAO(Context context){
        csdl=new DBHelper(context);

    }
    public List<Nhanvien> getAllNV(int t){
        String sql="SELECT * FROM TABLE_NHANVIEN WHERE maphong="+"'"+t+"'";

        List<Nhanvien> nhanvienList=new ArrayList<Nhanvien>();

        SQLiteDatabase db=csdl.getReadableDatabase();

        Cursor cursor=db.rawQuery(sql,null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int manhanvien=cursor.getInt(0);
            String tenhanvien=cursor.getString(1);
            String ngaysinh=cursor.getString(2);
            String diachi=cursor.getString(3);
            String chucvu=cursor.getString(4);
            String sdt=cursor.getString(5);
            String email=cursor.getString(6);
            int gioitinh=cursor.getInt(7);
            int maphong = cursor.getInt(8);
            int luong = cursor.getInt(9);

            Nhanvien nv=new Nhanvien(manhanvien,tenhanvien,ngaysinh,diachi,chucvu,sdt,email,gioitinh,maphong,luong);
            nhanvienList.add(nv);
            cursor.moveToNext();
        }
        return nhanvienList;
    }
    public List<Nhanvien> SearchNV(String str){

        List<Nhanvien> nhanvienList=new ArrayList<Nhanvien>();

        String sql="SELECT * FROM TABLE_NHANVIEN WHERE tennhanvien LIKE '%"+str+"%'OR chucvu LIKE '%"+str+"%'";


        SQLiteDatabase db=csdl.getReadableDatabase();

        Cursor cursor=db.rawQuery(sql,null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int manhanvien=cursor.getInt(0);
            String tenhanvien=cursor.getString(1);
            String ngaysinh=cursor.getString(2);
            String diachi=cursor.getString(3);
            String chucvu=cursor.getString(4);
            String sdt=cursor.getString(5);
            String email=cursor.getString(6);
            int gioitinh=cursor.getInt(7);
            int maphong = cursor.getInt(8);
            int luong = cursor.getInt(9);

            Nhanvien nv=new Nhanvien(manhanvien,tenhanvien,ngaysinh,diachi,chucvu,sdt,email,gioitinh,maphong,luong);
           nhanvienList.add(nv);
            cursor.moveToNext();
        }
        return nhanvienList;
    }


    public void ThemNV(Nhanvien nv){
        SQLiteDatabase db=csdl.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("tennhanvien",nv.getTennhanvien());
        values.put("ngaysinh",nv.getNgaysinh());
        values.put("diachi",nv.getDiachi());
        values.put("chucvu",nv.getChucvu());
        values.put("sodienthoai",nv.getSdt());
        values.put("email",nv.getEmail());
        values.put("gioitinh",nv.getGioitinh());
        values.put("maphong",nv.getMaphong());
        values.put("luong",nv.getLuong());

        db.insert("TABLE_NHANVIEN",null,values);
    }


    public void UpDateNV(Nhanvien nv){

        SQLiteDatabase database=csdl.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("tennhanvien",nv.getTennhanvien());
        values.put("ngaysinh",nv.getNgaysinh());
        values.put("diachi",nv.getDiachi());
        values.put("chucvu",nv.getChucvu());
        values.put("sodienthoai",nv.getSdt());
        values.put("email",nv.getEmail());
        values.put("gioitinh",nv.getGioitinh());
        values.put("maphong",nv.getMaphong());
        values.put("luong",nv.getLuong());

        String manv=String.valueOf(nv.getManhanvien());

        database.update("TABLE_NHANVIEN", values,"manhanvien=?",new String[]{manv} );
    }


    public int XoaNV(int id){
        SQLiteDatabase db = csdl.getWritableDatabase();
        int kq= db.delete("TABLE_NHANVIEN",  " manhanvien= ?",
                new String[] { String.valueOf(id) });
        db.close();
        return kq;
    }


}
