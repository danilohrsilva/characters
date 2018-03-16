package com.example.drodrigues.heroespoc.gateway.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.drodrigues.heroespoc.gateway.database.CharactersDatabase;

import java.util.List;

abstract class BaseDao<T> {

    private final Context mContext;
    private final CharactersDatabase dataBase;

    public BaseDao(final Context context) {
        this.mContext = context;
        this.dataBase = new CharactersDatabase(this.mContext);
    }

    public SQLiteDatabase getDBForRead() {
        return this.dataBase.getReadableDatabase();
    }

    public SQLiteDatabase getDBForWrite() {
        return this.dataBase.getWritableDatabase();
    }

    public void closeDB() {
        this.dataBase.close();
    }

    public abstract T get(String id);
    public abstract List<T> getAll();
    public abstract boolean add(T data);
    public abstract boolean addAll(List<T> data);
    public abstract boolean delete(T data);
    public abstract boolean deleteAll();
    public abstract boolean update(T data);

    public abstract ContentValues parseToValues(final T data);

    public Context getContext() {
        return mContext;
    }

}
