package com.example.dhakauniversitycalendarandroid.more;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AffiliatedInstitutes implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("institute_name")
    private String institute;
    @SerializedName("governance")
    private String governance;


    public AffiliatedInstitutes(String id, String name, String institute, String governance) {
        this.id = id;
        this.name = name;
        this.institute = institute;
        this.governance = governance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInstitute() {
        return institute;
    }

    public String getGovernance() {
        return governance;
    }
}
