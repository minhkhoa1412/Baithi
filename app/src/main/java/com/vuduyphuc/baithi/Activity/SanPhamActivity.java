package com.vuduyphuc.baithi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.vuduyphuc.baithi.Adapter.AdapterSanPham;
import com.vuduyphuc.baithi.Model.LoaiSanPham;
import com.vuduyphuc.baithi.R;

import java.util.ArrayList;

public class SanPhamActivity extends AppCompatActivity
{
    Button btnThemgiay, btnXoagiay, btnSuagiay;
    ListView lvsanpham;
    AdapterSanPham adapter;
    ArrayList<LoaiSanPham> loaiSanPhamArrayList;
    int INDEX = 0 ;
    int INDEX_XOA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        addControl();
        addEvent();
    }

    private void addEvent()
    {
        loaiSanPhamArrayList = new ArrayList<>();
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("bundle");
        loaiSanPhamArrayList = (ArrayList<LoaiSanPham>) bundle.getSerializable("listsp");
        INDEX = bundle.getInt("indexsp");

        adapter = new AdapterSanPham(SanPhamActivity.this, loaiSanPhamArrayList.get(INDEX).getSanPhamArrayList());
        Log.d("AAA",String.valueOf(String.valueOf(loaiSanPhamArrayList.get(INDEX).getSanPhamArrayList().get(0).getTenSP())));
        lvsanpham.setAdapter(adapter);

        //////////////////////
        lvsanpham.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                INDEX_XOA = i ;
            }
        });
        btnXoagiay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                loaiSanPhamArrayList.get(INDEX).getSanPhamArrayList().remove(INDEX_XOA);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void addControl()
    {
        btnThemgiay = findViewById(R.id.btnThemGiay);
        btnSuagiay = findViewById(R.id.btnSuaGiay);
        btnXoagiay = findViewById(R.id.btnXoaGiay);
        lvsanpham = findViewById(R.id.lvSanPham);
    }
}
