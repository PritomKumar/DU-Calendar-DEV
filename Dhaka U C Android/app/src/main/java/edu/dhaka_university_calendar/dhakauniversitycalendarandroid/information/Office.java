package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.information;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Office implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private  String name;
    @SerializedName("description")
    private  String description;
    @SerializedName("image")
    private String image;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("latitude")
    private String latitude;

    public Office(String id, String name, String description, String image, String longitude, String latitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Office(String id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }
}
