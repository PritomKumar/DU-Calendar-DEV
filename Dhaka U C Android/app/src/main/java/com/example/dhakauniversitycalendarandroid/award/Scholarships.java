package com.example.dhakauniversitycalendarandroid.award;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Scholarships implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("grade")
    private String grade;
    @SerializedName("description")
    private String description;

    public Scholarships(String id, String grade, String description) {
        this.id = id;
        this.grade = grade;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
