package com.lalalawrens.life_cycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate");
    }

    public void showToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String pesan){
        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setMessage(pesan);
        alert.setTitle("Attention!");
        alert.show();
    }

    public void showAlertButton(String pesan){
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Caution!");
        alert.setMessage(pesan);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("Aight Buddy");
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("frfr");
            }
        });
        alert.show();
    }


    public void Toast(View view) {
        showToast("Eula Lawrens");
    }
    public void Alert(View view) {
        showAlert("Eula Lawrens");
    }
    public void AlertButton(View view) {
        showAlertButton("Fume UltraGreatsword?");
    }


//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        System.out.println("onStart");
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//
//        System.out.println("onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        System.out.println("onPause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        System.out.println("onStop");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        System.out.println("onDestroy");
//    }
}