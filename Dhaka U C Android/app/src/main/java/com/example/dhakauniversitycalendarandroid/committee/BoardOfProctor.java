package com.example.dhakauniversitycalendarandroid.committee;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BoardOfProctor implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("institute")
    private String institute;
    @SerializedName("membership")
    private String membership;

    public BoardOfProctor(String id, String name, String institute, String membership) {
        this.id = id;
        this.name = name;
        this.institute = institute;
        this.membership = membership;
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

    public String getMembership() {
        return membership;
    }
}
