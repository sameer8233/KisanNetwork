package com.kisannetwork.database.config;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kisannetwork.modal.pojo.DbContactPojo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "contactdb";

    private static final String TABLE_CONTACTS = "contacts";

    private static final String KEY_CONTACT_NAME = "contactname";
    private static final String KEY_CONTACT_NUMBER = "contactnumber";
    private static final String KEY_CONTACT_OTP = "otp";
    private static final String KEY_OTP_TIME = "otptime";
    private static final String KEY_MESSAGE_STATUS = "messagestatus";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_CONTACT_NAME + " TEXT," + KEY_CONTACT_NUMBER + " TEXT,"+ KEY_CONTACT_OTP +" TEXT,"+ KEY_OTP_TIME +" DATETIME DEFAULT CURRENT_TIMESTAMP,"+ KEY_MESSAGE_STATUS +" TEXT"+ ")";
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }


    public void addContact(DbContactPojo dbpojo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT_NAME, dbpojo.getContact_name());
        values.put(KEY_CONTACT_NUMBER, dbpojo.getContact_number());
        values.put(KEY_CONTACT_OTP, dbpojo.getOtp());
        values.put(KEY_MESSAGE_STATUS, dbpojo.getMessage_status());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }


    public List<DbContactPojo> getAllContacts() {
        List<DbContactPojo> contactlist = new ArrayList();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DbContactPojo i = new DbContactPojo();
                i.setContact_name(cursor.getString(0));
                i.setContact_number(cursor.getString(1));
                i.setOtp(cursor.getString(2));
                i.setOtp_time(cursor.getString(3));
                i.setMessage_status(cursor.getString(4));
                contactlist.add(i);
            } while (cursor.moveToNext());
        }

        return contactlist;
    }


}