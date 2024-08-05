package com.lalalawrens.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        et=findViewById(R.id.et);
    }

    public void btnbarang(View view) {
        String get=et.getText().toString();
        Intent intent=new Intent(this, Barang.class);
        intent.putExtra("item",get);
        startActivity(intent);
    }
}