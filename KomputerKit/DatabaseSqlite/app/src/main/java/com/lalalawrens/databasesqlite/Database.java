package com.lalalawrens.databasesqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static final String DATABASE_NAME="dbtoko";
    private static final int VERSION=1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        db= this.getWritableDatabase();
    }

    boolean runSQL(String sql){
        try{
            db.execSQL(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void buatTabel(){
        String tblbarang="CREATE TABLE \"tblBarang\" (\n" +
                "\t\"idbarang\"\tINTEGER,\n" +
                "\t\"barang\"\tTEXT,\n" +
                "\t\"harga\"\tREAL,\n" +
                "\t\"stok\"\tREAL,\n" +
                "\tPRIMARY KEY(\"idbarang\" AUTOINCREMENT)\n" +
                ");";

        runSQL(tblbarang);
    }

    Cursor select (String sql){
        try {
            return db.rawQuery(sql, null);
        } catch (Exception e){
            return null;
        }
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
