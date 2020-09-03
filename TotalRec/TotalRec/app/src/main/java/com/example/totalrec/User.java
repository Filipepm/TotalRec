package com.example.totalrec;

import java.util.ArrayList;

public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    private String birthDay;
    private String password;
    private boolean isCoach;
    private boolean isAthlete;
    private String sport;
    //private ArrayList<Teams> userSubscribedTeams= new ArrayList<Teams>();

    public User() {

    }

    public User(String email, String firstName, String lastName, String userName, String birthDay, String password, boolean coach, boolean athlete, String sport) {
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setBirthDay(birthDay);
        setPassword(password);
        setCoach(coach);
        setAthelete(athlete);
        setSport(sport);
        //setUserSubscribedTeams(teams);
    }

    public boolean isAthlete() {
        return isAthlete;
    }

    public void setAthlete(boolean athlete) {
        isAthlete = athlete;
    }

   // public ArrayList<Teams> getUserSubscribedTeams() {
     //   return userSubscribedTeams;
    //}

    //public void setUserSubscribedTeams(ArrayList<Teams> userSubscribedTeams) {
    //    this.userSubscribedTeams = userSubscribedTeams;
    //}

    public String getSport()
    {
        return sport;
    }
    public void setSport(String sport)
    {
        this.sport = sport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCoach() {
        return isCoach;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setCoach(boolean coach) {
        isCoach = coach;
    }

    public boolean isAthelete() {
        return isAthlete;
    }

    public void setAthelete(boolean athelete) {
        isAthlete = athelete;
    }

}

