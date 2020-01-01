package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.committee;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProvostOfHall implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("hall_name")
    private String hallName;
    @SerializedName("provost_name")
    private String provostName;

    public ProvostOfHall(String id, String hallName, String provostName) {
        this.id = id;
        this.hallName = hallName;
        this.provostName = provostName;
    }

    public String getId() {
        return id;
    }

    public String getHallName() {
        return hallName;
    }

    public String getProvostName() {
        return provostName;
    }
}
