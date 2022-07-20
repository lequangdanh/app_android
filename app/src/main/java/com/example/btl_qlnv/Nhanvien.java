package com.example.btl_qlnv;

import java.io.Serializable;

public class Nhanvien implements Serializable {
    private  int manhanvien;
    private String tennhanvien;
    private String ngaysinh;
    private String diachi;
    private String chucvu;
    private String sdt;
    private String email;
    private int gioitinh;
    private int maphong;
    private int luong;
    public Nhanvien(){

    }

    public Nhanvien(int manhanvien, String tennhanvien, String ngaysinh, String diachi, String chucvu, String sdt, String email, int gioitinh, int maphong, int luong) {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.chucvu = chucvu;
        this.sdt = sdt;
        this.email = email;
        this.gioitinh = gioitinh;
        this.maphong = maphong;
        this.luong = luong;
    }

    public Nhanvien(String tennhanvien, String ngaysinh, String diachi, String chucvu, String sdt, String email, int gioitinh, int maphong, int luong) {
        this.tennhanvien = tennhanvien;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.chucvu = chucvu;
        this.sdt = sdt;
        this.email = email;
        this.gioitinh = gioitinh;
        this.maphong = maphong;
        this.luong = luong;
    }

    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getMaphong() {
        return maphong;
    }

    public void setMaphong(int maphong) {
        this.maphong = maphong;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
}
