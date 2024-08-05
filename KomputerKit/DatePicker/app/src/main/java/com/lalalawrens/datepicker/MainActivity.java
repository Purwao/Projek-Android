package com.lalalawrens.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        etDate= findViewById(R.id.editTextText);

    }

    public void datePick(View view) {
        Calendar cal= Calendar.getInstance();

        int tgl=cal.get(cal.DAY_OF_MONTH);
        int bln=cal.get(cal.MONTH);
        int thn=cal.get(cal.YEAR);

        DatePickerDialog datepicker= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int thn, int bln, int tgl) {
                etDate.setText(tgl+"-"+(bln+1)+"-"+thn);
            }
        },thn,bln,tgl);

        datepicker.show();
    }
}