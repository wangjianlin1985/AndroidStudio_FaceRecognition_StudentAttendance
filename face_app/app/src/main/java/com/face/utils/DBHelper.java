package com.face.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "door.db";
    public static final String TABLE_USER = "user";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create table Orders(Id integer primary key, CustomName text, OrderPrice integer, Country text);
        String sql = "create table if not exists " + TABLE_USER
                + " (id integer primary key, name text, address text, img text, sex text, phone text, faceid text)";


        sqLiteDatabase.execSQL(sql);

    }
 
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_USER;

        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);
    }
}