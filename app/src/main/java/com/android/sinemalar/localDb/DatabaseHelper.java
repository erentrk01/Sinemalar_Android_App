package com.android.sinemalar.localDb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME=" Sinemalarrdb";
    public static int DATABASE_VERSION = 1;

    SQLiteDatabase sqLiteDB;
    public static String TABLE_NAME="favorite";
    public static String FIELD_ID = "id";
    public static String FIELD_NAME = "name";
    public static String FIELD_ORG_NAME = "orgname";
    public static String FIELD_DURATION = "duration";
    public static String FIELD_IMG = "img";
    public static String FIELD_GENRES = "genres";
    public static String FIELD_PRODUCT_YEAR = "productyear";

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        sqLiteDB = getWritableDatabase();

    }
    public void close() {
        if (sqLiteDB != null && sqLiteDB.isOpen()) {
            sqLiteDB.close();//Wirtable and Readable mode
            Log.d("DATABASE OPERATIONS", "CLOSE");
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //onCreate called if database doesn't exist
        try {
            db.execSQL( "CREATE TABLE "+TABLE_NAME+" ( "+FIELD_ID+" INTEGER PRIMARY KEY, "+FIELD_NAME+" text, "+FIELD_ORG_NAME+" text, "+FIELD_DURATION+" number, "+FIELD_IMG+" text, "+FIELD_GENRES+" text, "+FIELD_PRODUCT_YEAR +" INTEGER, "+FIELD_ORG_NAME +" text);");

        }catch (SQLException e){
            e.printStackTrace();
        }
        Log.d("DATABASE OPERATIONS", "OnCreate, table is created, records inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade called when DATABASE_VERSION is changed
        //SQLiteDatabase object used to execute SQL statements
        try {
            db.execSQL(FavoriteMoviesTable.DROP_TABLE_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        onCreate(db);
        Log.d("DATABASE OPERATIONS", "onUpgrade, table dropped and recreated. OldVersion:"+oldVersion+" NewVersion:"+newVersion);
    }

    public Cursor getAllRecords(String tableName, String[] colums) {
        Cursor cursor = sqLiteDB.query(tableName, colums, null, null, null, null,null);
        return cursor;
    }
    public boolean insert(String tableName, ContentValues contentValues) {
        Log.d("DATABASE OPERATIONS", "INSERT DONE");
        return sqLiteDB.insert(tableName, null, contentValues)>0;
    }
    public boolean delete(String tableName, String whereCondition) {
        Log.d("DATABASE OPERATIONS", "DELETE DONE");
        return sqLiteDB.delete(tableName, whereCondition, null)>0;
    }

}
