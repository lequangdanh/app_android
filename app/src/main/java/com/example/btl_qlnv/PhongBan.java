package com.example.btl_qlnv;

import java.io.Serializable;

public class PhongBan implements Serializable {
    private int id_phong;
    private String tenphong;
    public PhongBan(){

    }

    public PhongBan(int id_phong, String tenphong) {
        this.id_phong = id_phong;
        this.tenphong = tenphong;
    }

    public PhongBan(String tenphong) {
        this.tenphong = tenphong;
    }

    public int getId_phong() {
        return id_phong;
    }

    public void setId_phong(int id_phong) {
        this.id_phong = id_phong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }
}