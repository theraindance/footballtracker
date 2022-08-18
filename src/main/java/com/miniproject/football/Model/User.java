package com.miniproject.football.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class User {
    public User() {
    }
    public User(int AwayTeamScore) {
    }
    private String name;
    private String email;
    private String HomeTeam;
    private int AwayTeamScore;
    
    
    
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