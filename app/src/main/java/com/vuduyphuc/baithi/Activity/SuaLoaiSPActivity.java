package com.vuduyphuc.baithi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vuduyphuc.baithi.Model.LoaiSanPham;
import com.vuduyphuc.baithi.R;

public class SuaLoaiSPActivity extends AppCompatActivity
{
    EditText edtMaloaiSP, edtTenloaiSP;
    Button btnSuaSP;
    int INDEX = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_loai_sp);
        addControls();
        addEvent();
        getData();

    }

    private void getData()
    {
        Intent intent = getIntent();
        if (intent != null)
        {
            Bundle bundle = intent.getBundleExtra("bundle");
            LoaiSanPham a = (LoaiSanPham) bundle.getSerializable("a");
            INDEX = bundle.getInt("so");
            edtMaloaiSP.setText(a.getMaSP());
            edtTenloaiSP.setText(a.getTenSP());
        }
    }


    private void addEvent()
    {
        btnSuaSP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoaiSanPham a = new LoaiSanPham();
                a.setMaSP(edtMaloaiSP.getText().toString());
                a.setTenSP(edtTenloaiSP.getText().toString());
                a.setSanPhamArrayList(null);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("lspSP", a);
                bundle.putInt("indexSP", INDEX);
                intent.putExtra("bundleSP", bundle);
                setResult(234, intent);
                finish();
            }
        });
    }

    private void addControls()
    {
        edtMaloaiSP = findViewById(R.id.edtMaLoaiSP);
        edtTenloaiSP = findViewById(R.id.edtTenLoaiSP);
        btnSuaSP = findViewById(R.id.btnSuaSP);
    }
}
