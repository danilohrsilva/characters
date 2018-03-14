package com.example.drodrigues.heroespoc.infrastructure.factory;

import android.content.Context;

import com.example.drodrigues.heroespoc.gateway.database.dao.CharacterDao;

public class DaoFactory {

    private static final DaoFactory ourInstance = new DaoFactory();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    public CharacterDao createHeroDao(final Context context) {
        return new CharacterDao(context);
    }

}
