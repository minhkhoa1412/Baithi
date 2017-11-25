package com.vuduyphuc.baithi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vuduyphuc.baithi.Model.LoaiSanPham;
import com.vuduyphuc.baithi.R;

public class ThemLoaiSPActivity extends AppCompatActivity {
    EditText txtMasp,txtTensp;
    Button btnThemsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_loai_sp);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnThemsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoaiSanPham a =new LoaiSanPham();
                a.setMaSP(txtMasp.getText().toString());
                a.setTenSP(txtTensp.getText().toString());
                a.setSanPhamArrayList(null);

                Intent intent =new Intent();
                intent.putExtra("lsp",a);
                setResult(123,intent);
                finish();
            }
        });
    }

    private void addControls() {
        txtMasp =findViewById(R.id.txtMaLoaiSP);
        txtTensp=findViewById(R.id.txtTenLoaiSP);
        btnThemsp =findViewById(R.id.btnThemSP);

    }
}
