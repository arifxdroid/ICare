package com.lazyprogrammer.icare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by arif on 6/9/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "iCareDB";
    public static final int VERSION = 1;

    public static final String TABLE_NAME = "patientProfile";
    public static final String PATIENT_ID = "_ID_patient";
    public static final String PATIENT_NAME_FIELD = "patient_name";
    public static final String PATIENT_PROFILE_TYPE = "patient_profile_type";
    public static final String PATIENT_GENDER = "patient_gender";
    public static final String PATIENT_BLOOD_GROUP = "patient_blood_group";
    public static final String CURRENT_DATE = "current_date";
    public static final String PATIENT_AGE = "patient_age";
    public static final String PATIENT_HEIGHT = "patient_height";
    public static final String PATIENT_WEIGHT = "patient_weight";
    public static final String PATIENT_PHONE_NUMBER = "patent_phone_number";
    public static final String PATIENT_EMAIL = "patient_email";
    public static final String PATIENT_CONDITION = "patient_condition";
    public static final String PATIENT_IMAGE = "patient_image";

    public static final String PATIENT_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ("+PATIENT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+PATIENT_NAME_FIELD+" TEXT, "+PATIENT_PROFILE_TYPE+" TEXT, "+PATIENT_GENDER+" TEXT, "+PATIENT_BLOOD_GROUP+" TEXT, "+CURRENT_DATE+" TEXT, "+PATIENT_AGE+" INTEGER, "+ PATIENT_HEIGHT +" DOUBLE, "+PATIENT_WEIGHT+" DOUBLE, "+PATIENT_PHONE_NUMBER+" TEXT, "+PATIENT_EMAIL+" TEXT, "+PATIENT_CONDITION+" TEXT, "+PATIENT_IMAGE+" TEXT)";

    public DbHelper(Context context){

        super(context,DB_NAME,null,VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(PATIENT_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addPatient(Patient patient){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PATIENT_ID, patient.getId());
        values.put(PATIENT_NAME_FIELD, patient.getName());
        values.put(PATIENT_PROFILE_TYPE, patient.getPatientType());
        values.put(PATIENT_GENDER, patient.getGender());
        values.put(PATIENT_BLOOD_GROUP, patient.getBloodGroup());
        values.put(CURRENT_DATE, patient.getCurrentDate());
        values.put(PATIENT_AGE, patient.getAge());
        values.put(PATIENT_HEIGHT, patient.getHeight());
        values.put(PATIENT_WEIGHT, patient.getWeight());
        values.put(PATIENT_PHONE_NUMBER, patient.getPhoneNumber());
        values.put(PATIENT_EMAIL, patient.getEmail());
        values.put(PATIENT_CONDITION, patient.getPatientCondition());
        values.put(PATIENT_IMAGE, patient.getPatientImage().toString());

        long inserted = db.insert(TABLE_NAME, "", values);

        db.close();

        return inserted;
    }

    public ArrayList<Patient> getAllPatient(){

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        ArrayList<Patient> all = new ArrayList<>();

        if (cursor != null){

            if (cursor.getCount()>0){

                cursor.moveToFirst();
                do {
                    int id = cursor.getInt(cursor.getColumnIndex(PATIENT_ID));
                    String name = cursor.getString(cursor.getColumnIndex(PATIENT_NAME_FIELD));
                    String profileType = cursor.getString(cursor.getColumnIndex(PATIENT_PROFILE_TYPE));
                    String gender = cursor.getString(cursor.getColumnIndex(PATIENT_GENDER));
                    String bloodGroup = cursor.getString(cursor.getColumnIndex(PATIENT_BLOOD_GROUP));
                    String currentDate = cursor.getString(cursor.getColumnIndex(CURRENT_DATE));
                    int age = cursor.getInt(cursor.getColumnIndex(PATIENT_AGE));
                    double height = cursor.getDouble(cursor.getColumnIndex(PATIENT_HEIGHT));
                    double weight = cursor.getDouble(cursor.getColumnIndex(PATIENT_WEIGHT));
                    String phoneNumber = cursor.getString(cursor.getColumnIndex(PATIENT_PHONE_NUMBER));
                    String email = cursor.getString(cursor.getColumnIndex(PATIENT_EMAIL));
                    String patientCondition = cursor.getString(cursor.getColumnIndex(PATIENT_CONDITION));
                    String patientImage = cursor.getString(cursor.getColumnIndex(PATIENT_IMAGE));
                    Uri image = Uri.parse(patientImage);

                    all.add(new Patient(name,profileType,gender,bloodGroup,currentDate,age,id,height,weight,phoneNumber,email,patientCondition,image));

                }while (cursor.moveToNext());
            }
        }

        db.close();
        cursor.close();
        return all;
    }
}
