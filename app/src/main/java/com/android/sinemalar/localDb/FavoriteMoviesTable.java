package com.android.sinemalar.localDb;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.android.sinemalar.models.Ontheater;

import java.util.ArrayList;

public class FavoriteMoviesTable {
    public static String TABLE_NAME="favorite";
    public static String FIELD_ID = "_id";
    public static String FIELD_NAME = "name";
    public static String FIELD_ORG_NAME = "org_name";
    public static String FIELD_DURATION = "duration";
    public static String FIELD_IMG = "img";
    public static String FIELD_GENRES = "genres";
    public static String FIELD_PRODUCT_YEAR = "product_year";

    public static String CREATE_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ( "+FIELD_ID+" number, "+FIELD_NAME+" text, "+FIELD_ORG_NAME+" text, "+FIELD_DURATION+" number, "+FIELD_IMG+" text, "+FIELD_GENRES+" text, "+FIELD_PRODUCT_YEAR +" number, "+FIELD_ORG_NAME +" text) ;";
    public static String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;
    public static ArrayList<Ontheater> getAllMovie(DatabaseHelper dbHelper){
        Ontheater anItem;
        ArrayList<Ontheater> data = new ArrayList<>();
        Cursor cursor = dbHelper.getAllRecords(TABLE_NAME, null);
        Log.d("DATABASE OPERATIONS", cursor.getCount()+",  "+cursor.getColumnCount());
        while(cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name = cursor.getString(1);
            String org_name= cursor.getString(2);
            String img = cursor.getString(3);
            String product_year = cursor.getString(4);
            String genres = cursor.getString(5);
            int duration = cursor.getInt(6);
            anItem = new Ontheater(id, name, img, org_name,  genres, product_year,duration);
            data.add(anItem);

        }
        Log.d("DATABASE OPERATIONS",data.toString());
        return data;
    }
    public static boolean insertMovie(DatabaseHelper db,int id, String name,String img,String org_name,String  genres, String product_year,int duration) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(FIELD_ID, id);
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_ORG_NAME, org_name);
        contentValues.put(FIELD_IMG, img);
        contentValues.put(FIELD_PRODUCT_YEAR, product_year);
        contentValues.put(FIELD_GENRES, genres);
        contentValues.put(FIELD_DURATION, duration);
        boolean res = db.insert(TABLE_NAME, contentValues);
        return  res;
    }


}
