package com.vuduyphuc.baithi.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vuduyphuc.baithi.R;

public class LoginActivity extends AppCompatActivity {
    TextView txtuser,txtpass;
    Button btndangnhap,btnthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AddControls();
        AddEvent();
    }

    private void AddEvent() {
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtuser.getText().length()!=0 && txtpass.getText().length()!=0){
                    if(txtuser.getText().toString().equals("phuc") && txtpass.getText().toString().equals("1234")){
                        Toast.makeText(LoginActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }else
                        Toast.makeText(LoginActivity.this,"Bạn đăng nhập ko thnahf công",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(LoginActivity.this,"Mời bạn nhập đày đủ thông tin",Toast.LENGTH_SHORT).show();
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this,
                        android.R.style.Theme_DeviceDefault_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát khỏi ứng dụng");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }

    private void AddControls() {
        txtuser=findViewById(R.id.txtUser);
        txtpass=findViewById(R.id.txtPass);
        btndangnhap=findViewById(R.id.btnDangNhap);
        btnthoat=findViewById(R.id.btnThoat);
    }
}
