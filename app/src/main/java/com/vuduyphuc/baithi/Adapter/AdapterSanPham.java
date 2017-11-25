package com.vuduyphuc.baithi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vuduyphuc.baithi.Model.SanPham;
import com.vuduyphuc.baithi.R;

import java.util.ArrayList;

/**
 * Created by user on 11/24/2017.
 */

public class AdapterSanPham extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<SanPham> SanPhamArrayList;

    public AdapterSanPham(Context context, ArrayList<SanPham> sanPhamArrayList) {
        this.context = context;
        this.SanPhamArrayList = sanPhamArrayList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return SanPhamArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return SanPhamArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= inflater.inflate(R.layout.item_sanpham,null);
        TextView tvmaSP=view.findViewById(R.id.tvMaSP);
        TextView tvtenSP=view.findViewById(R.id.tvTenSP);
        TextView tvgia=view.findViewById(R.id.tvGia);
        ImageView imganh =view.findViewById(R.id.imgAnh);

        tvmaSP.setText(SanPhamArrayList.get(i).getMaSP());
        tvtenSP.setText(SanPhamArrayList.get(i).getTenSP());
        tvgia.setText(String.valueOf(SanPhamArrayList.get(i).getGia()));
        imganh.setImageResource(SanPhamArrayList.get(i).getHinhanh());

        return view;
    }
}
