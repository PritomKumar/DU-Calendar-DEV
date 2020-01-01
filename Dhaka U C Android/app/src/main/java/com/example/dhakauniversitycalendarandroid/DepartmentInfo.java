package com.example.dhakauniversitycalendarandroid;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DepartmentInfo {
    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    private String departmentId;
    private String departmentName;
    private String description;
    private String  mImageUrl;
    private int establishmentYear;

    public DepartmentInfo(){
        //this constructor is required
    }

    public DepartmentInfo(String departmentId, String departmentName, String mImageUrl, String description, int establishmentYear) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.mImageUrl = mImageUrl;
        this.description = description;
        this.establishmentYear = establishmentYear;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }
}
