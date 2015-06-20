package com.lazyprogrammer.icare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by arif on 6/20/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "iCareDatabase";
    public static final int VERSION = 1;

    public static final String TABLE_NAME = "patient_profile";
    public static final String ID_FIELD = "_ID";
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

    public static final String PATIENT_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ("+ID_FIELD+" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, "+PATIENT_NAME_FIELD+" TEXT, "+PATIENT_PROFILE_TYPE +" TEXT, "+PATIENT_GENDER+" TEXT, "+PATIENT_BLOOD_GROUP+" TEXT, "+CURRENT_DATE+" TEXT, "+PATIENT_AGE+" INTEGER, "+PATIENT_HEIGHT+" DOUBLE, "+PATIENT_WEIGHT+" DOUBLE, "+PATIENT_PHONE_NUMBER+" TEXT, "+PATIENT_EMAIL+" TEXT, "+PATIENT_CONDITION+" TEXT, "+PATIENT_IMAGE+" BLOB)";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(PATIENT_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public long addPatient(PatientTemplate p){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(ID_FIELD, p.getId());
        values.put(PATIENT_NAME_FIELD, p.getName());
        values.put(PATIENT_PROFILE_TYPE, p.getPatientType());
        values.put(PATIENT_GENDER, p.getGender());
        values.put(PATIENT_BLOOD_GROUP, p.getBloodGroup());
        values.put(CURRENT_DATE, p.getCurrentDate());
        values.put(PATIENT_AGE, p.getAge());
        values.put(PATIENT_HEIGHT, p.getHeight());
        values.put(PATIENT_WEIGHT, p.getWeight());
        values.put(PATIENT_PHONE_NUMBER, p.getPhoneNumber());
        values.put(PATIENT_EMAIL, p.getEmail());
        values.put(PATIENT_CONDITION, p.getPatientCondition());
        values.put(PATIENT_IMAGE, p.getPatient_image());

        long inserted = db.insert(TABLE_NAME, null, values);

        db.close();

        return inserted;
    }


//    public ArrayList<PatientTamplate> getAllPatient(){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null,null);
//        ArrayList<PatientTamplate> all = new ArrayList<PatientTamplate>();
//
//        if (cursor != null){
//
//            if (cursor.getCount()>0){
//
//                cursor.moveToFirst();
//                do {
//                    int id = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
//                    String name = cursor.getString(cursor.getColumnIndex(PATIENT_NAME_FIELD));
//                    String profileType = cursor.getString(cursor.getColumnIndex(PATIENT_PROFILE_TYPE));
//                    String gender = cursor.getString(cursor.getColumnIndex(PATIENT_GENDER));
//                    String bloodGroup = cursor.getString(cursor.getColumnIndex(PATIENT_BLOOD_GROUP));
//                    String currentDate = cursor.getString(cursor.getColumnIndex(CURRENT_DATE));
//                    int age = cursor.getInt(cursor.getColumnIndex(PATIENT_AGE));
//                    double height = cursor.getDouble(cursor.getColumnIndex(PATIENT_HEIGHT));
//                    double weight = cursor.getDouble(cursor.getColumnIndex(PATIENT_WEIGHT));
//                    String phoneNumber = cursor.getString(cursor.getColumnIndex(PATIENT_PHONE_NUMBER));
//                    String email = cursor.getString(cursor.getColumnIndex(PATIENT_EMAIL));
//                    String patientCondition = cursor.getString(cursor.getColumnIndex(PATIENT_CONDITION));
//                    byte[] patientImage = cursor.getBlob(cursor.getColumnIndex(PATIENT_IMAGE));
//
//                    PatientTamplate patient = new PatientTamplate(id,name,profileType,gender,bloodGroup,currentDate,age,height,weight,phoneNumber,email,patientCondition,patientImage);
//                    all.add(patient);
//
//                }while (cursor.moveToNext());
//            }
//        }
//
//        db.close();
//        cursor.close();
//        return all;
//    }

    public ArrayList<PatientTemplate> getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null,null);
        ArrayList<PatientTemplate> all = new ArrayList<>();
        if (cursor != null){
            if (cursor.getCount()>0){
                cursor.moveToFirst();
                do {
                    int id = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                    String name = cursor.getString(cursor.getColumnIndex(PATIENT_NAME_FIELD));
                    String profileType = cursor.getString(cursor.getColumnIndex(PATIENT_PROFILE_TYPE));
                    String gender = cursor.getString(cursor.getColumnIndex(PATIENT_GENDER));
                    String blood = cursor.getString(cursor.getColumnIndex(PATIENT_BLOOD_GROUP));
                    String currentDate = cursor.getString(cursor.getColumnIndex(CURRENT_DATE));
                    int age = cursor.getInt(cursor.getColumnIndex(PATIENT_AGE));
                    double height = cursor.getDouble(cursor.getColumnIndex(PATIENT_HEIGHT));
                    double weight = cursor.getDouble(cursor.getColumnIndex(PATIENT_WEIGHT));
                    String phone = cursor.getString(cursor.getColumnIndex(PATIENT_PHONE_NUMBER));
                    String email = cursor.getString(cursor.getColumnIndex(PATIENT_EMAIL));
                    String patientCondition = cursor.getString(cursor.getColumnIndex(PATIENT_CONDITION));
                    byte[] image = cursor.getBlob(cursor.getColumnIndex(PATIENT_IMAGE));

                    PatientTemplate patient = new PatientTemplate(id,name,profileType,gender,blood,currentDate,age,height,weight,phone,email,patientCondition,image);
                    all.add(patient);
                }while (cursor.moveToNext());
            }
        }
        db.close();
        cursor.close();
        return all;
    }

    public int deletePatient(int id){
        SQLiteDatabase db = getWritableDatabase();
        int deleted = db.delete(TABLE_NAME, ID_FIELD+"=?", new String[]{""+id});

        db.close();
        return deleted;
    }

}
