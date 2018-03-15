package com.example.drodrigues.heroespoc.gateway.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.entity.CharacterType;
import com.example.drodrigues.heroespoc.gateway.database.tables.HeroesTable;
import com.example.drodrigues.heroespoc.infrastructure.Constants;

import java.util.ArrayList;
import java.util.List;

public class CharacterDao extends BaseDao<Character> {

    public CharacterDao(final Context context) {
        super(context);
    }

    @Override
    public Character get(String id) {
        return null;
    }

    @Override
    public List<Character> getAll() {
        final List <Character> result = new ArrayList<>();

        final SQLiteDatabase db = getDBForRead();

        try {
            final Cursor cursor = db.query(HeroesTable.TABLE_NAME,
                    HeroesTable.getAllColumns(),
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);

            if (cursor != null) {
                try {
                    while (cursor.moveToNext()) {
                        final Character character = parseToObj(cursor);
                        result.add(character);
                    }
                } finally {
                    cursor.close();
                }
            }

        } finally {
            closeDB();
        }

        return result;
    }

    @Override
    public boolean add(Character data) {
        return false;
    }

    @Override
    public boolean addAll(List<Character> data) {
        return false;
    }

    @Override
    public boolean delete(Character data) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean update(Character data) {
        return false;
    }

    @Override
    public ContentValues parseToValues(Character data) {
        return null;
    }

    private static Character parseToObj(final Cursor cursor) {

        final String data = cursor.getString(cursor.getColumnIndex(HeroesTable.DATA));

        return Constants.gson.fromJson(data, Character.class);
    }
}
