package com.vuduyphuc.baithi.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 11/20/2017.
 */

public class LoaiSanPham implements Serializable {
    private String MaSP;
    private String TenSP;
    private ArrayList<SanPham> sanPhamArrayList;

    public LoaiSanPham(String maSP, String tenSP, ArrayList<SanPham> sanPhamArrayList)
    {
        MaSP = maSP;
        TenSP = tenSP;
        this.sanPhamArrayList = sanPhamArrayList;
    }

    public LoaiSanPham() {
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

    public ArrayList<SanPham> getSanPhamArrayList()
    {
        return sanPhamArrayList;
    }

    public void setSanPhamArrayList(ArrayList<SanPham> sanPhamArrayList)
    {
        this.sanPhamArrayList = sanPhamArrayList;
    }
}
