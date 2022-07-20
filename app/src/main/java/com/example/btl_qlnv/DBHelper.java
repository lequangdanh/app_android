package com.example.btl_qlnv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="1DBNHANVIEN.db";
    public static final String TABLE_NAME="TABLE_NHANVIEN";
    public static final String TABLE_NAME2="TABLE_PHONGBAN";
    private static int VERSION = 1;
    private Context context;

    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Quanlyphongban="CREATE TABLE "+TABLE_NAME2
                +"(maphongban integer primary key ,"
                +"tenphongban VARCHAR(100))";

        db.execSQL(Quanlyphongban);
        String Quanlynhanvien="CREATE TABLE "+TABLE_NAME
                +"(manhanvien integer primary key autoincrement,"
                +"tennhanvien VARCHAR(100),"
                +"ngaysinh VARCHAR(100),"
                +"diachi VARCHAR(100),"
                +"chucvu VARCHAR(100),"
                +"sodienthoai VARCHAR(100),"
                +"email VARCHAR(100),"
                +"gioitinh integer,"
                +"maphong integer,"
                +"luong integer,"
                +"FOREIGN KEY(maphong) REFERENCES TABLE_PHONGBAN(maphongban))";

        db.execSQL(Quanlynhanvien);
        String sqlInsert1 = "INSERT INTO TABLE_PHONGBAN(maphongban,tenphongban) VALUES('101','ROM 101')";
        String sqlInsert2 = "INSERT INTO TABLE_PHONGBAN(maphongban,tenphongban) VALUES('102','ROM 102')";
        db.execSQL(sqlInsert1);
        db.execSQL(sqlInsert2);
        String sqlInsert3 = "INSERT INTO TABLE_NHANVIEN(tennhanvien, ngaysinh, diachi, chucvu,sodienthoai,email,gioitinh,maphong,luong) VALUES('An', '11-07-1999','Hà Nội','kế toán','0335045893','lyhai@gmail.com','0','101','20000000')";
        String sqlInsert4 = "INSERT INTO TABLE_NHANVIEN(tennhanvien, ngaysinh, diachi, chucvu,sodienthoai,email,gioitinh,maphong,luong) VALUES('thiện', '11-07-1999','Hà Nội','kế toán','0335045893','lyhai@gmail.com','1','101','20000000')";
        db.execSQL(sqlInsert3);
        db.execSQL(sqlInsert4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }
}

