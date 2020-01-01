package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.committee;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DirectorOfBureaus implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("center_name")
    private String centerName;
    @SerializedName("constitution_date")
    private String constitutionDate;
    @SerializedName("committee_date")
    private String committeeDate;
    @SerializedName("chairman_name")
    private String chairmanName;
    @SerializedName("director_name")
    private String directorName;

    public DirectorOfBureaus(String id, String centerName, String constitutionDate, String committeeDate, String chairmanName, String directorName) {
        this.id = id;
        this.centerName = centerName;
        this.constitutionDate = constitutionDate;
        this.committeeDate = committeeDate;
        this.chairmanName = chairmanName;
        this.directorName = directorName;
    }

    public String getId() {
        return id;
    }

    public String getCenterName() {
        return centerName;
    }

    public String getConstitutionDate() {
        return constitutionDate;
    }

    public String getCommitteeDate() {
        return committeeDate;
    }

    public String getChairmanName() {
        return chairmanName;
    }

    public String getDirectorName() {
        return directorName;
    }
}
