package com.vuduyphuc.baithi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vuduyphuc.baithi.Model.LoaiSanPham;
import com.vuduyphuc.baithi.R;

import java.util.ArrayList;

/**
 * Created by user on 11/24/2017.
 */

public class AdaperLoaiSanPham extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<LoaiSanPham> LoaiSanPhamArrayList;

    public AdaperLoaiSanPham(Context context, ArrayList<LoaiSanPham> loaiSanPhamArrayList) {
        this.context = context;
        LoaiSanPhamArrayList = loaiSanPhamArrayList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return LoaiSanPhamArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return LoaiSanPhamArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =inflater.inflate(R.layout.item_loaisp,null);
        TextView tvMaSP =view.findViewById(R.id.textviewMaSP);
        TextView tvTenSP =view.findViewById(R.id.textviewTenSP);
        tvMaSP.setText(LoaiSanPhamArrayList.get(i).getMaSP());
        tvTenSP.setText(LoaiSanPhamArrayList.get(i).getTenSP());
        return view;

    }
}
