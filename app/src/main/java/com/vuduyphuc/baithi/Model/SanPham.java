package com.vuduyphuc.baithi.Model;

import java.io.Serializable;

/**
 * Created by user on 11/24/2017.
 */

public class SanPham implements Serializable {
    private String MaSP;
    private String TenSP;
    private int gia;
    private int hinhanh;


    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public SanPham(String maSP, String tenSP, int gia, int hinhanh) {
        MaSP = maSP;
        TenSP = tenSP;
        this.gia = gia;
        this.hinhanh = hinhanh;
    }

    public SanPham() {
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
