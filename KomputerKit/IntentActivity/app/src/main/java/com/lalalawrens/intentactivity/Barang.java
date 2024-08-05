package com.lalalawrens.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Barang extends AppCompatActivity {

    TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);
        load();
    }

    public void load(){
        tvRes=findViewById(R.id.textView);
        String barang=getIntent().getStringExtra("item");
        tvRes.setText(barang);
    }


}