package com.vuduyphuc.baithi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.vuduyphuc.baithi.Adapter.AdaperLoaiSanPham;
import com.vuduyphuc.baithi.Model.LoaiSanPham;
import com.vuduyphuc.baithi.Model.SanPham;
import com.vuduyphuc.baithi.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnthem,btnxoa,btnsua;
    ListView lvLoaiSP;
    AdaperLoaiSanPham adaper;
    ArrayList<LoaiSanPham> LoaiSPArrayList;
    ArrayList<SanPham> SanPhamArrayList;
    int INDEX_XOA = 0 ;
    int INDEX_SUA = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode ==123 && data!=null)
        {
            LoaiSanPham a = (LoaiSanPham) data.getSerializableExtra("lsp");
            LoaiSPArrayList.add(a);
            adaper.notifyDataSetChanged();
        }
        if(requestCode == 234 && data != null)
        {
            Bundle bundle = data.getBundleExtra("bundleSP");
            LoaiSanPham a = (LoaiSanPham) bundle.getSerializable("lspSP");
            int i = bundle.getInt("indexSP");
            LoaiSPArrayList.remove(i);
            LoaiSPArrayList.add(i,a);
            adaper.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void addEvent() {

        LoaiSPArrayList = new ArrayList<LoaiSanPham>();
        LoaiSanPham a = new LoaiSanPham("1", "Giày bata", null);
        LoaiSanPham b = new LoaiSanPham("2", "Giày sandal", null);
        LoaiSPArrayList.add(a);
        LoaiSPArrayList.add(b);

        SanPham z = new SanPham("001","Nike",10000,R.drawable.item_giay1);
        SanPham q = new SanPham("002","Adidas",10000,R.drawable.item_giay2);
        SanPhamArrayList = new ArrayList<>();
        SanPhamArrayList.add(z);
        SanPhamArrayList.add(q);
        a.setSanPhamArrayList(SanPhamArrayList);

        adaper = new AdaperLoaiSanPham(MainActivity.this, LoaiSPArrayList);
        lvLoaiSP.setAdapter(adaper);


        /////////////////////////////////
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoaiSPArrayList.remove(INDEX_XOA);
                adaper.notifyDataSetChanged();
            }
        });
        /////////////////////////////////
        lvLoaiSP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(MainActivity.this,SanPhamActivity.class);
                Bundle bundle =new Bundle();
                bundle.putSerializable("listsp",LoaiSPArrayList);
                bundle.putInt("indexsp",i);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
                return false;
            }
        });
        //////////////////////////////////
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent =new Intent(MainActivity.this,ThemLoaiSPActivity.class);
               startActivityForResult(intent,123);
            }
        });
        lvLoaiSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                INDEX_SUA = i ;
                INDEX_XOA = i ;
            }
        });
        //////////////////////////
        btnsua.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoaiSanPham a = LoaiSPArrayList.get(INDEX_SUA);
                Intent intent = new Intent(MainActivity.this,SuaLoaiSPActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("a",a);
                bundle.putInt("so",INDEX_SUA);
                intent.putExtra("bundle",bundle);
                startActivityForResult(intent,234);
            }
        });

    }

    private void addControl() {
        btnthem =findViewById(R.id.btnThem);
        btnxoa=findViewById(R.id.btnXoa);
        btnsua=findViewById(R.id.btnSua);
        lvLoaiSP=findViewById(R.id.listviewLoaiSP);
    }
}
