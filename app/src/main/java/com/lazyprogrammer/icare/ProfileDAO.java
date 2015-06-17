package com.lazyprogrammer.icare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by arif on 6/17/15.
 */
public class ProfileDAO {

    private SQLiteDatabase myDatabase;
    private DbHelper dbHelper;
    private Context context;
    private String[] allColumns = {dbHelper.ID_FIELD, dbHelper.PATIENT_NAME_FIELD, dbHelper.PATIENT_PROFILE_TYPE, dbHelper.PATIENT_GENDER, dbHelper.PATIENT_BLOOD_GROUP, dbHelper.CURRENT_DATE, dbHelper.PATIENT_AGE, dbHelper.PATIENT_HEIGHT, dbHelper.PATIENT_WEIGHT, dbHelper.PATIENT_PHONE_NUMBER, dbHelper.PATIENT_EMAIL, dbHelper.PATIENT_CONDITION, dbHelper.PATIENT_IMAGE};

    public ProfileDAO(Context context){

        this.context = context;

        dbHelper = new DbHelper(context);
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void open() throws SQLException{

        myDatabase = dbHelper.getWritableDatabase();

    }

    public void close(){

        myDatabase.close();

    }

    public long addPatient(Patient patient){

        //SQLiteDatabase db = dbHelper.getWritableDatabase();
        myDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbHelper.ID_FIELD, patient.getId());
        values.put(dbHelper.PATIENT_NAME_FIELD, patient.getName());
        values.put(dbHelper.PATIENT_PROFILE_TYPE, patient.getPatientType());
        values.put(dbHelper.PATIENT_GENDER, patient.getGender());
        values.put(dbHelper.PATIENT_BLOOD_GROUP, patient.getBloodGroup());
        values.put(dbHelper.CURRENT_DATE, patient.getCurrentDate());
        values.put(dbHelper.PATIENT_AGE, patient.getAge());
        values.put(dbHelper.PATIENT_HEIGHT, patient.getHeight());
        values.put(dbHelper.PATIENT_WEIGHT, patient.getWeight());
        values.put(dbHelper.PATIENT_PHONE_NUMBER, patient.getPhoneNumber());
        values.put(dbHelper.PATIENT_EMAIL, patient.getEmail());
        values.put(dbHelper.PATIENT_CONDITION, patient.getPatientCondition());
        values.put(dbHelper.PATIENT_IMAGE, patient.getPatientImage().toString());

        long inserted = myDatabase.insert(dbHelper.TABLE_NAME, "", values);

        close();

        return inserted;
    }


    public ArrayList<Patient> getAllPatient(){

        myDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = myDatabase.query(dbHelper.TABLE_NAME, null,null,null,null,null,null);
        ArrayList<Patient> all = new ArrayList<>();

        if (cursor != null){

            if (cursor.getCount()>0){

                cursor.moveToFirst();
                do {
                    int id = cursor.getInt(cursor.getColumnIndex(dbHelper.ID_FIELD));
                    String name = cursor.getString(cursor.getColumnIndex(dbHelper.PATIENT_NAME_FIELD));
                    String profileType = cursor.getString(cursor.getColumnIndex(dbHelper.PATIENT_PROFILE_TYPE));
                    String gender = cursor.getString(cursor.getColumnIndex(dbHelper.PATIENT_GENDER));
                    String bloodGroup = cursor.getString(cursor.getColumnIndex(dbHelper.PATIENT_BLOOD_GROUP));
                    String currentDate = cursor.getString(cursor.getColumnIndex(dbHelper.CURRENT_DATE));
                    int age = cursor.getInt(cursor.getColumnIndex(dbHelper.PATIENT_AGE));
                    double height = cursor.getDouble(cursor.getColumnIndex(dbHelper.PATIENT_HEIGHT));
                    double weight = cursor.getDouble(cursor.getColumnIndex(dbHelper.PATIENT_WEIGHT));
                    String phoneNumber = cursor.getString(cursor.getColumnIndex(dbHelper.PATIENT_PHONE_NUMBER));
                    String email = cursor.getString(cursor.getColumnIndex(dbHelper.PATIENT_EMAIL));
                    String patientCondition = cursor.getString(cursor.getColumnIndex(dbHelper.PATIENT_CONDITION));
                    String patientImage = cursor.getString(cursor.getColumnIndex(dbHelper.PATIENT_IMAGE));
                    Uri image = Uri.parse(patientImage);

                    all.add(new Patient(name,profileType,gender,bloodGroup,currentDate,age,id,height,weight,phoneNumber,email,patientCondition,image));

                }while (cursor.moveToNext());
            }
        }

        myDatabase.close();
        cursor.close();
        return all;
    }


    public int deletePatient(int id){
        myDatabase = dbHelper.getWritableDatabase();
        int deleted = myDatabase.delete(dbHelper.TABLE_NAME, dbHelper.ID_FIELD+"=?", new String[]{""+id});

        myDatabase.close();
        return deleted;
    }

}
