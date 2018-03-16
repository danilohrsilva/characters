package com.example.drodrigues.heroespoc.gateway.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.drodrigues.heroespoc.gateway.database.tables.CharacterTable;


public class CharactersDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public CharactersDatabase(final Context context) {
        super(context.getApplicationContext(), "characters", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CharacterTable.SQL_CREATE);
        final String sql = CharacterTable.SQL_INSERT;
        final SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        sqLiteDatabase.beginTransaction();
        CharacterTable.insertInitialCharacters(statement);
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
