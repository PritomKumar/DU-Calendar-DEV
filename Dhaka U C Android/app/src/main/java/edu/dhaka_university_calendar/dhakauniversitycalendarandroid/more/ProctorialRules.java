package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.more;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProctorialRules implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("rule")
    private String rule;

    public ProctorialRules(String id, String rule) {
        this.id = id;
        this.rule = rule;
    }

    public String getId() {
        return id;
    }


    public String getRule() {
        return rule;
    }

}
