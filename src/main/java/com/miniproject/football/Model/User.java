package com.miniproject.football.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class User {
    
    
    
    private String name;
    private String email;
    private String HomeTeam;
    private int AwayTeamScore;
    private int RoundNumber;
     
    public User(String name, String email, String HomeTeam) {
        this.name=name;
        this.email=email;
        this.HomeTeam=HomeTeam;
    }

    public User(){
        
    }
    
    public int getRoundNumber() {
        return RoundNumber;
    }
    public void setRoundNumber(int roundNumber) {
        RoundNumber = roundNumber;
    }
    public int getAwayTeamScore() {
        return AwayTeamScore;
    }
    public void setAwayTeamScore(int awayTeamScore) {
        AwayTeamScore = awayTeamScore;
    }
    public String getHomeTeam() {
        return HomeTeam;
    }
    public void setHomeTeam(String homeTeam) {
        HomeTeam = homeTeam;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    // @Override
    // public String toString() {
    //     return this.name;
    // }
    
}