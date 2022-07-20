package com.example.btl_qlnv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PhongBanDAO {
    private DBHelper csdl;
    public PhongBanDAO(Context context){
        csdl=new DBHelper(context);

    }

    public List<PhongBan> getAllPB(){
        String sql="SELECT * FROM TABLE_PHONGBAN";

        List<PhongBan> phongbanList=new ArrayList<PhongBan>();

        SQLiteDatabase db=csdl.getReadableDatabase();

        Cursor cursor=db.rawQuery(sql,null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int maphong=cursor.getInt(0);
            String tenphong=cursor.getString(1);

            PhongBan pb=new PhongBan(maphong,tenphong);
            phongbanList.add(pb);
            cursor.moveToNext();
        }
        return phongbanList;
    }


    public List<PhongBan> SearchPB(String str){

        List<PhongBan> phongbanList=new ArrayList<PhongBan>();

        String sql="SELECT * FROM TABLE_PHONGBAN WHERE maphongban LIKE '%"+str+"%'OR tenphongban LIKE '%"+str+"%'";


        SQLiteDatabase db=csdl.getReadableDatabase();

        Cursor cursor=db.rawQuery(sql,null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int maphongban=cursor.getInt(0);
            String tenphongban=cursor.getString(1);

            PhongBan pb=new PhongBan(maphongban,tenphongban);
            phongbanList.add(pb);
            cursor.moveToNext();
        }
        return phongbanList;
    }


    public void ThemPB(PhongBan pb){
        SQLiteDatabase db=csdl.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("tenphongban",pb.getTenphong());

        db.insert("TABLE_PHONGBAN",null,values);
    }


    public void UpDatePB(PhongBan pb){

        SQLiteDatabase database=csdl.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("tenphongban",pb.getTenphong());


        String maphong=String.valueOf(pb.getId_phong());

        database.update("TABLE_PHONGBAN", values,"maphongban=?",new String[]{maphong} );
    }


    public int XoaPB(int id){
        SQLiteDatabase db = csdl.getWritableDatabase();
        int kq= db.delete("Table_PHONGBAN",  " maphongban= ?",
                new String[] { String.valueOf(id) });
        db.close();
        return kq;
    }
}
