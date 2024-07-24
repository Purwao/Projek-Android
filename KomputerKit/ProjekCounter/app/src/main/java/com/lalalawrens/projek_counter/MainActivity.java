package com.lalalawrens.projek_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count=0;
    TextView TvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        TvHasil= findViewById(R.id.TvHasil);
        TvHasil.setText(count+"");
    }
    public void countup(View view){
        count++;
        System.out.println(count);
        load();

    }

    public void countdown(View view){
        if (count==0){
            count=0;
            load();
        }else {
            count--;
            System.out.println(count);
            load();
        }
    }
}
