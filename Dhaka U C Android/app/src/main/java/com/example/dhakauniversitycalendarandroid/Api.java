package com.example.dhakauniversitycalendarandroid;

import com.example.dhakauniversitycalendarandroid.award.Acheivements;
import com.example.dhakauniversitycalendarandroid.award.DeansAward;
import com.example.dhakauniversitycalendarandroid.award.DeansAwardWinners;
import com.example.dhakauniversitycalendarandroid.award.Scholarships;
import com.example.dhakauniversitycalendarandroid.calendar.EventDay;
import com.example.dhakauniversitycalendarandroid.calendar.SpecificCalendarDay;
import com.example.dhakauniversitycalendarandroid.committee.BoardOfProctor;
import com.example.dhakauniversitycalendarandroid.committee.ChairmanOfDepartments;
import com.example.dhakauniversitycalendarandroid.committee.CommitteMember;
import com.example.dhakauniversitycalendarandroid.committee.DeanMember;
import com.example.dhakauniversitycalendarandroid.committee.DirectorOfBureaus;
import com.example.dhakauniversitycalendarandroid.committee.DirectorOfInstitute;
import com.example.dhakauniversitycalendarandroid.committee.HeadOfOffice;
import com.example.dhakauniversitycalendarandroid.committee.ProvostOfHall;
import com.example.dhakauniversitycalendarandroid.faculty.Faculty;
import com.example.dhakauniversitycalendarandroid.information.Club;
import com.example.dhakauniversitycalendarandroid.information.Department;
import com.example.dhakauniversitycalendarandroid.information.GradeSystem;
import com.example.dhakauniversitycalendarandroid.information.Hall;
import com.example.dhakauniversitycalendarandroid.information.HeadOfDU;
import com.example.dhakauniversitycalendarandroid.information.Office;
import com.example.dhakauniversitycalendarandroid.more.AffiliatedInstitutes;
import com.example.dhakauniversitycalendarandroid.more.Ducsu;
import com.example.dhakauniversitycalendarandroid.more.ProctorialRules;
import com.example.dhakauniversitycalendarandroid.transport.Transport;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String baseURL = "http://103.28.121.45/DUC/Web Portal/android/";

    @GET("headOfDU.php")
    Call<List<HeadOfDU>> getHeadOfDU();

    @GET("faculty.php")
    Call<List<Faculty>> getFacultyList();

    @GET("duHistory.php")
    Call<List<Faculty>> getDuHistory();

    @GET("Faculty/facultyOfBiologicalSciences.php")
    Call<List<Department>> getBiologicalScienceDepartments();

    @GET("Faculty/facultyOfEngineering.php")
    Call<List<Department>> getEngineeringDepartments();

    @GET("Faculty/facultyOfEarthAndEnvironment.php")
    Call<List<Department>> getEarthAndEnvironmentDepartments();

    @GET("Faculty/facultyOfFineArts.php")
    Call<List<Department>> getFineArtsDepartments();

    @GET("Faculty/facultyOfPharmacy.php")
    Call<List<Department>> getPharmacyDepartments();

    @GET("Faculty/facultyOfLaw.php")
    Call<List<Department>> getLawDepartments();

    @GET("Faculty/facultyOfSocialSciences.php")
    Call<List<Department>> getSocialScienceDepartments();

    @GET("Faculty/facultyOfBusinessStudies.php")
    Call<List<Department>> getCommerceDepartments();

    @GET("Faculty/facultyOfArts.php")
    Call<List<Department>> getArtsDepartments();

    @GET("Faculty/facultyOfSciences.php")
    Call<List<Department>> getScienceDepartments();

    @GET("institutes.php")
    Call<List<Department>> getInstitues();

    @GET("excitingPlaces.php")
    Call<List<Department>> getExcitingPlaces();

    @GET("Calendar/calendar.php")
    Call<List<EventDay>> getEventDays();

    @GET("Calendar/sportsCalendar.php")
    Call<List<EventDay>> getSportsEventDays();

    @GET("Calendar/specificCalendar.php")
    Call<List<SpecificCalendarDay>> getSpecificEventDays(
            @Query("dept_name") String dept_name, @Query("academic_year") String academic_year);

    @GET("Calendar/counselingCalendar.php")
    Call<List<EventDay>> getCounselingCalendar();


    @GET("calendarIIT.php")
    Call<List<EventDay>> getIITevents();

    @GET("calendarCSE.php")
    Call<List<EventDay>> getCSEevents();

    @GET("SpecificCalendar/IIT/calendarIITFirst.php")
    Call<List<SpecificCalendarDay>> getIITFirstYearEvents();

    @GET("SpecificCalendar/IIT/calendarIITSecond.php")
    Call<List<SpecificCalendarDay>> getIITSecondYearEvents();

    @GET("SpecificCalendar/IIT/calendarIITThird.php")
    Call<List<SpecificCalendarDay>> getIITThirdYearEvents();

    @GET("SpecificCalendar/IIT/calendarIITFourth.php")
    Call<List<SpecificCalendarDay>> getIITFourthYearEvents();

    @GET("hall.php")
    Call<List<Hall>> getHall();

    @GET("duLibrary.php")
    Call<List<Faculty>> getLibrary();

    @GET("club.php")
    Call<List<Club>> getClub();

    @GET("office.php")
    Call<List<Office>> getOffice();

    @GET("Committee/deanList.php")
    Call<List<DeanMember>> getDeanList();

    @GET("Committee/editorialCommittee.php")
    Call<List<CommitteMember>> getEditorialCommittee();

    @GET("Committee/implementationCommittee.php")
    Call<List<CommitteMember>> getImplementationCommittee();

    @GET("Committee/boardOfProctor.php")
    Call<List<BoardOfProctor>> getBoardOfProctor();

    @GET("Committee/directorOfBureaus.php")
    Call<List<DirectorOfBureaus>> getDirectorOfBureaus();

    @GET("Committee/headOfOffices.php")
    Call<List<HeadOfOffice>> getHeadOfOffices();

    @GET("Committee/chairmanOfDepartment.php")
    Call<List<ChairmanOfDepartments>> getChairmanOfDepartments();

    @GET("Committee/directorOfInstitutes.php")
    Call<List<DirectorOfInstitute>> getDirectorOfInstitutes();

    @GET("Committee/provostOfHalls.php")
    Call<List<ProvostOfHall>> getProvostOfHalls();

    @GET("Transport/transport.php")
    Call<List<Transport>> getTransportRetrofit(@Query("busName") String busName);

    @GET("Transport/transportChytali.php")
    Call<List<Transport>> getTransportChytali();

    @GET("Transport/transportBaishakhi.php")
    Call<List<Transport>> getTransportBaishakhi();

    @GET("Transport/transportHemonto.php")
    Call<List<Transport>> getTransportHemonto();

    @GET("Transport/transportKhonika.php")
    Call<List<Transport>> getTransportKhonika();

    @GET("Transport/transportTorongo.php")
    Call<List<Transport>> getTransportTorongo();

    @GET("Transport/transportSrabon.php")
    Call<List<Transport>> getTransportSrabon();

    @GET("Transport/transportBoshoto.php")
    Call<List<Transport>> getTransportBoshoto();

    @GET("Transport/transportUllash.php")
    Call<List<Transport>> getTransportUllash();

    @GET("Transport/transportAnanda.php")
    Call<List<Transport>> getTransportAnanda();

    @GET("gradeSystem.php")
    Call<List<GradeSystem>> getGradingSystem();

    @GET("Award/deansAward.php")
    Call<List<DeansAward>> getDeansAward();

    @GET("Award/deansAwardWinners.php")
    Call<List<DeansAwardWinners>> getDeansAwardWinners();

    @GET("Award/scholarships.php")
    Call<List<Scholarships>> getScholarships();

    @GET("Award/acheivements.php")
    Call<List<Acheivements>> getAcheivements();

    @GET("More/medicalCenter.php")
    Call<List<Faculty>> getMedicalCenter();

    @GET("More/proctorialRules.php")
    Call<List<ProctorialRules>> getProctorialRules();

    @GET("More/affiliatedInstitutes.php")
    Call<List<AffiliatedInstitutes>> getAffiliatedInstitutes();

    @GET("More/ducsu.php")
    Call<List<Ducsu>> getDucsu();



}
