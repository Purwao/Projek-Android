package com.lalalawrens.projekconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv2;
    EditText suhu;
    Spinner choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        tv2= findViewById(R.id.textView2);
        suhu= findViewById(R.id.editTextText);
        choices= findViewById(R.id.spinner);
    }

    public void Convert(View view){
        String choice= choices.getSelectedItem().toString();
        System.out.println(choice);
        if(choice.equals("Celcius to Fahrenheit")){
            CtF();
        } else if(choice.equals("Celcius to Reamur")){
            CtR();
        } else if (choice.equals("Celcius to Kelvin")) {
            CtK();
        }
    }
    public void CtF(){
        double ctf=Double.parseDouble(suhu.getText().toString());
        double hasilctf=(ctf * 9/5)+32;
        tv2.setText(hasilctf+"");
    }

    public void CtR(){
        double ctr=Double.parseDouble(suhu.getText().toString());
        double hasilctr=(ctr * 4)/5;
        tv2.setText(hasilctr+"");
    }

    public void CtK(){
        double ctk=Double.parseDouble(suhu.getText().toString());
        double hasilctk=ctk+273.15;
        tv2.setText(hasilctk+"");
    }
}