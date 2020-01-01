package com.example.dhakauniversitycalendarandroid.award;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DeansAwardWinners implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("department")
    private String department;
    @SerializedName("result")
    private String result;
    @SerializedName("year")
    private String year;

    public DeansAwardWinners(String id, String name, String department, String result, String year) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.result = result;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
