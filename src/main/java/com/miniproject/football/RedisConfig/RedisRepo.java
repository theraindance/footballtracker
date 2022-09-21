package com.miniproject.football.RedisConfig;

import java.util.ArrayList;

import com.miniproject.football.Model.User;


public interface RedisRepo {
    public void save(User theUser);
    public User get(String userName);
    public ArrayList<User> getAllUsers();
    public ArrayList<String> getAllEmail();
    public ArrayList<String> getAllTeam();
    public User delete(String userName);
    //public User delete(String HomeTeam);

    // public Contact findById(final String contactId);
}
