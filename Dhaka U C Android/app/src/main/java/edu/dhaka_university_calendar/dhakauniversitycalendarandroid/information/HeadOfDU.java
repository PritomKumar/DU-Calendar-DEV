package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.information;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HeadOfDU implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private  String name;
    @SerializedName("rank")
    private  String rank;
    @SerializedName("educational_qualification")
    private  String qualification;
    @SerializedName("image")
    private String image;
    @SerializedName("profile_link")
    private String profileLink;


    public HeadOfDU(String id, String name, String rank, String qualification, String image, String profileLink) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.qualification = qualification;
        this.image = image;
        this.profileLink = profileLink;
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

    public String getQualification() {
        return qualification;
    }

    public String getImage() {
        return image;
    }

    public String getProfileLink() {
        return profileLink;
    }
}
