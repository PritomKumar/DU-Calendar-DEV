package com.example.dhakauniversitycalendarandroid.committee;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChairmanOfDepartments implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("dept_name")
    private String departmentName;
    @SerializedName("chairman_name")
    private String chairmanName;

    public ChairmanOfDepartments(String id, String departmentName, String chairmanName) {
        this.id = id;
        this.departmentName = departmentName;
        this.chairmanName = chairmanName;
    }

    public String getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getChairmanName() {
        return chairmanName;
    }
}
