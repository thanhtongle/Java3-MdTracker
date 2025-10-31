package com.example.mdtracker.database;

public class DBConst {
    // ITEM TABLE
    public static final String TABLE_ITEM = "item";
    public static final String ITEM_COLUMN_ID = "id";
    public static final String ITEM_COLUMN_NAME = "name";
    public static final String ITEM_COLUMN_YEAR = "year";
    public static final String ITEM_COLUMN_CONDITION = "coin_condition";
    public static final String ITEM_COLUMN_LOCATION = "location";

    // COIN TABLE
    public static final String TABLE_COIN = "coin";
    public static final String COIN_COLUMN_ID = "id";
    public static final String COIN_COLUMN_NAME = "name";

    // CONDITION TABLE
    public static final String TABLE_CONDITION = "coin_condition";
    public static final String CONDITION_COLUMN_ID = "id";
    public static final String CONDITION_COLUMN_NAME = "name";

    // LOCATION TABLE
    public static final String TABLE_LOCATION = "location";
    public static final String LOCATION_COLUMN_ID = "id";
    public static final String LOCATION_COLUMN_NAME = "name";
    public static final String LOCATION_COLUMN_LATITUDE = "latitude";
    public static final String LOCATION_COLUMN_LONGITUDE = "longitude";

    // CREATE TABLES
    public static final String CREATE_TABLE_COIN =
            "CREATE TABLE IF NOT EXISTS " + TABLE_COIN +
            "(" +
            COIN_COLUMN_ID + " int NOT NULL AUTO_INCREMENT," +
            COIN_COLUMN_NAME + " VARCHAR(50)," +
            "PRIMARY KEY (" + COIN_COLUMN_ID + ")" +
            ");";
    public static final String CREATE_TABLE_COIN_CONDITION =
            "CREATE TABLE IF NOT EXISTS " + TABLE_CONDITION +
            "(" +
            CONDITION_COLUMN_ID + " int NOT NULL AUTO_INCREMENT," +
            CONDITION_COLUMN_NAME + " VARCHAR(50)," +
            "PRIMARY KEY (" + CONDITION_COLUMN_ID + ")" +
            ");";
    public static final String CREATE_TABLE_LOCATION =
            "CREATE TABLE IF NOT EXISTS " + TABLE_LOCATION +
            "(" +
            LOCATION_COLUMN_ID + " int NOT NULL AUTO_INCREMENT," +
            LOCATION_COLUMN_NAME + " VARCHAR(50)," +
            LOCATION_COLUMN_LONGITUDE + " VARCHAR(15)," +
            LOCATION_COLUMN_LATITUDE + " VARCHAR(15)," +
            "PRIMARY KEY (" + LOCATION_COLUMN_ID + ")" +
            ");";
    public static final String CREATE_TABLE_ITEMS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_ITEM +
            "(" +
            ITEM_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            ITEM_COLUMN_NAME + " int NOT NULL," +
            ITEM_COLUMN_YEAR + " int(4) NOT NULL," +
            ITEM_COLUMN_CONDITION + " int NOT NULL," +
            ITEM_COLUMN_LOCATION + " int NOT NULL," +
            "FOREIGN KEY (" + ITEM_COLUMN_LOCATION + ")" +
                "REFERENCES " + TABLE_LOCATION + " (" + LOCATION_COLUMN_ID + ")," +
            "FOREIGN KEY (" + ITEM_COLUMN_CONDITION + ")" +
                "REFERENCES " + TABLE_CONDITION + " (" + CONDITION_COLUMN_ID + ")," +
            "FOREIGN KEY (" + ITEM_COLUMN_NAME + ")" +
                "REFERENCES " + TABLE_COIN + " (" + COIN_COLUMN_ID + ")" +
            ");";
}
