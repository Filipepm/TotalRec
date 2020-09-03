package com.example.totalrec;

import com.example.totalrec.User;

import java.util.ArrayList;

public class Teams{
    private String teamName;
    private String creationDate;
    private String coachName;
    private int totalMembers;
    private String sport;



    public Teams(String teamName, String creationDate, String coachName, int totalMembers, String sport) {
        this.teamName = teamName;
        this.creationDate = creationDate;
        this.coachName = coachName;
        this.totalMembers = totalMembers;
        this.sport = sport;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }


}
