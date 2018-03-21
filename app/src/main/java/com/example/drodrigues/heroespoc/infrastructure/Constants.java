package com.example.drodrigues.heroespoc.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Constants {

    private Constants() {
    }

    public static final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    public static final class Errors {
        public static final int NEW_CHARACTER_EMPTY_NAME = 10001;
        public static final int NEW_CHARACTER_TYPE = 10002;
        public static final int NEW_CHARACTER_EMPTY_DESCRIPTION = 10003;
        public static final int NEW_CHARACTER_EMPTY_PICTURE = 10004;
    }

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

    public static final class StringUtils {

        private static final String MD5 = "MD5";

        public static String md5(final String str) {
            try {
                final MessageDigest m = MessageDigest.getInstance(MD5);
                m.update(str.getBytes(), 0, str.length());

                return new BigInteger(1, m.digest()).toString(16);

            } catch (NoSuchAlgorithmException e) {
                return "";
            }
        }
    }
}
