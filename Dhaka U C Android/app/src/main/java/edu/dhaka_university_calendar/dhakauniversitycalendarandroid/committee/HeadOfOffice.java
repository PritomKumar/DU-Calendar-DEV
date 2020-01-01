package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.committee;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HeadOfOffice implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("office_name")
    private String officName;
    @SerializedName("head_name")
    private String headName;

    public HeadOfOffice(String id, String officName, String headName) {
        this.id = id;
        this.officName = officName;
        this.headName = headName;
    }

    public String getId() {
        return id;
    }

    public String getOfficName() {
        return officName;
    }

    public String getHeadName() {
        return headName;
    }
}
