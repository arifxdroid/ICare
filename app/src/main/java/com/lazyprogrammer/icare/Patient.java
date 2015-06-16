package com.lazyprogrammer.icare;

import android.net.Uri;

/**
 * Created by arif on 6/9/15.
 */
public class Patient {

    private String name;
    private String patientType;
    private String gender;
    private String bloodGroup;
    private String currentDate;
    private int age;
    private int id;
    private double height;
    private double weight;
    private String phoneNumber;
    private String email;
    private String patientCondition;
    private Uri patientImage;

    public Patient(String name, String patientType, String gender, String bloodGroup, String currentDate, int age, int id, double height, double weight, String phoneNumber, String email, String patientCondition, Uri patientImage) {
        this.name = name;
        this.patientType = patientType;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.currentDate = currentDate;
        this.age = age;
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.patientCondition = patientCondition;
        this.patientImage = patientImage;
    }

    public Patient(String name, String patientType, String gender, String bloodGroup, String currentDate, int age, double height, double weight, String phoneNumber, String email, String patientCondition, Uri patientImage) {
        this.name = name;
        this.patientType = patientType;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.currentDate = currentDate;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.patientCondition = patientCondition;
        this.patientImage = patientImage;
    }

    public Patient(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientCondition() {
        return patientCondition;
    }

    public void setPatientCondition(String patientCondition) {
        this.patientCondition = patientCondition;
    }

    public Uri getPatientImage() {
        return patientImage;
    }

    public void setPatientImage(Uri patientImage) {
        this.patientImage = patientImage;
    }


}
