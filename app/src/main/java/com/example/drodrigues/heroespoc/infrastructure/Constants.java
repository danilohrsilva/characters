package com.example.drodrigues.heroespoc.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Constants {

    private Constants() {
    }

    public static final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    public static final class Database {
        public static final String CREATE_TABLE = "CREATE TABLE ";
        public static final String TABLE_SEPARATOR_OPEN = " ( ";
        public static final String TABLE_SEPARATOR_CLOSE = " ) ";
        public static final String COLUMN_SEPARATOR = ", ";
        public static final String LINE_SEPARATOR = ";";
        public static final String STRING_SEPARATOR = "'";
        public static final String COLUMN_TYPE_PK = " INTEGER PRIMARY KEY AUTOINCREMENT";
        public static final String COLUMN_TYPE_STRING = " TEXT ";
        public static final String INSERT_INTO = "INSERT INTO ";
        public static final String VALUES = " VALUES ";
        public static final String BIND_CHAR = "?";
    }

}
