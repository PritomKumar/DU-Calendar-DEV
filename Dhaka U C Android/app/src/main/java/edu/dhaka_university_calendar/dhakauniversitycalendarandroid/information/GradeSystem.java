package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.information;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GradeSystem implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("marks")
    private String marks;
    @SerializedName("grade")
    private String grade;
    @SerializedName("point")
    private String point;

    public GradeSystem(String id, String marks, String grade, String point) {
        this.id = id;
        this.marks = marks;
        this.grade = grade;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public String getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    public String getPoint() {
        return point;
    }
}
