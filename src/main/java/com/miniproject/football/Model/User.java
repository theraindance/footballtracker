package com.miniproject.football.Model;

public class User {
    
    private String name;
    private String email;
    private String teams;

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
    public String getTeams() {
        return teams;
    }
    public void setTeams(String teams) {
        this.teams = teams;
    }

    // @Override
    // public String toString() {
    //     return this.name;
    // }
    
}
