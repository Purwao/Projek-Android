package com.lalalawrens.databasesqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText etBarang,etStok,etHarga;
    TextView tvPilihan;
    Database db;
    List<Barang> dataBarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    RecyclerView rcvBarang;
    String idbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
        selectData();
    }

    public void load(){
        db=new Database(this);
        db.buatTabel();

        etBarang= findViewById(R.id.etBarang);
        etStok= findViewById(R.id.etStok);
        etHarga= findViewById(R.id.etHarga);
        tvPilihan= findViewById(R.id.tvPilihan);
        rcvBarang= findViewById(R.id.rcvBarang);

        rcvBarang.setLayoutManager(new LinearLayoutManager(this));
        rcvBarang.setHasFixedSize(true);
    }


    public void Button(View view) {
            String barang= etBarang.getText().toString();
            String stok= etStok.getText().toString();
            String harga= etHarga.getText().toString();
            String pilihan= tvPilihan.getText().toString();

            if (barang.isEmpty()||harga.isEmpty()||stok.isEmpty()){
                toast("Data ada yang kosong!");
            }else {
                if(pilihan.equals("Insert")){
                    String sql="INSERT INTO tblBarang (barang, stok, harga) VALUES ('" + barang + "', " + stok + ", " + harga + ")";
                    if (db.runSQL(sql)){
                        toast("Insert Sukses");
                        selectData();
                    }
                }else{
                    String sql = "UPDATE tblBarang\nSET barang = '" + barang +
                            "', stok = " + stok + ", harga = " + harga + "\nWHERE idbarang = " + idbarang + ";";

                    if (db.runSQL(sql)) {
                        toast("Berhasil Update!");
                        selectData();
                    } else {
                        toast("Gagal Update!");
                    }
                }
            }
        etBarang.setText("");
        etStok.setText("");
        etHarga.setText("");
        tvPilihan.setText("Insert");
    }


    public void selectData(){
        String sql="SELECT * FROM tblBarang ORDER BY barang ASC";
        Cursor cursor= db.select(sql);
        dataBarang.clear();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String idbarang = cursor.getString(cursor.getColumnIndex("idbarang"));
                @SuppressLint("Range") String barang = cursor.getString(cursor.getColumnIndex("barang"));
                @SuppressLint("Range") String stok = cursor.getString(cursor.getColumnIndex("stok"));
                @SuppressLint("Range") String harga = cursor.getString(cursor.getColumnIndex("harga"));

                dataBarang.add(new Barang(idbarang, barang, stok, harga));
            }
            adapter = new BarangAdapter(this, dataBarang);
            rcvBarang.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else {
            toast("Data where? Kosong!");
        }
    }

    public void toast(String pesan){
        Toast.makeText(this,pesan,Toast.LENGTH_SHORT).show();
    }

    public void deleteData(String id){
        String idbarang= id;
        String sql = "DELETE FROM tblBarang WHERE idbarang = " + idbarang + ";";

        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        alertDialog.setTitle("WARNING!");
        alertDialog.setMessage("Yakinkah Anda untuk menghapus data terkait?");
        alertDialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Execute the SQL command to delete the data
                if (db.runSQL(sql)) {
                   toast("Data Berhasil Dihapus");
                    selectData();
                } else {
                    toast("Data Trouble!");
                }
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }

    @SuppressLint("Range")
    public void selectUpdate(String id) {
        idbarang = id;
        String sql = "SELECT * FROM tblBarang WHERE idbarang = " + id + ";";

        Cursor cursor = db.select(sql);
        cursor.moveToNext();
        etBarang.setText(cursor.getString(cursor.getColumnIndex("barang")));
        etStok.setText(cursor.getString(cursor.getColumnIndex("stok")));
        etHarga.setText(cursor.getString(cursor.getColumnIndex("harga")));
        tvPilihan.setText("Update");
    }
};

