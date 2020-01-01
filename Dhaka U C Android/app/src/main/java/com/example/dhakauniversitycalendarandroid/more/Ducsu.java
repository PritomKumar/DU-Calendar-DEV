package com.example.dhakauniversitycalendarandroid.more;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ducsu implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("rank")
    private String rank;
    @SerializedName("institute")
    private String institute;

    public Ducsu(String id, String name, String rank, String institute) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.institute = institute;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getInstitute() {
        return institute;
    }
}