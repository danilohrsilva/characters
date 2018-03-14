package com.example.drodrigues.heroespoc.gateway.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.drodrigues.heroespoc.gateway.database.tables.HeroesTable;


public class HeroesDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public HeroesDatabase(final Context context) {
        super(context.getApplicationContext(), "Heroes", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(HeroesTable.SQL_CREATE);
        final String sql = HeroesTable.SQL_INSERT;
        final SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        sqLiteDatabase.beginTransaction();
        HeroesTable.insertInitialHeroes(statement);
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
