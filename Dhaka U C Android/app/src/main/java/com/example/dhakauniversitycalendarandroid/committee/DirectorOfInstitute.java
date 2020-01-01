package com.example.dhakauniversitycalendarandroid.committee;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DirectorOfInstitute implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("institute_name")
    private String instituteName;
    @SerializedName("director_name")
    private String directorName;

    public DirectorOfInstitute(String id, String instituteName, String directorName) {
        this.id = id;
        this.instituteName = instituteName;
        this.directorName = directorName;
    }

    public String getId() {
        return id;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public String getDirectorName() {
        return directorName;
    }
}
