package com.lalalawrens.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        tvResult =findViewById(R.id.tvResult);
        et1= findViewById(R.id.et1);
        et2= findViewById(R.id.et2);
    }

    public void penjumlahan(View view){
        double bil1=Double.parseDouble(et1.getText().toString());
        double bil2=Double.parseDouble(et2.getText().toString());
        double res=bil1 + bil2 ;
        tvResult.setText(res + "");
        load();
    }

    public void pengurangan(View view){
        double bil1=Double.parseDouble(et1.getText().toString());
        double bil2=Double.parseDouble(et2.getText().toString());
        double res=bil1 - bil2 ;
        tvResult.setText(res + "");
        load();
    }

    public void perkalian(View view){
        double bil1=Double.parseDouble(et1.getText().toString());
        double bil2=Double.parseDouble(et2.getText().toString());
        double res=bil1 * bil2 ;
        tvResult.setText(res + "");
        load();
    }

    public void pembagian(View view){
        double bil1=Double.parseDouble(et1.getText().toString());
        double bil2=Double.parseDouble(et2.getText().toString());
        double res=bil1 / bil2 ;
        tvResult.setText(res + "");
        load();
    }

}