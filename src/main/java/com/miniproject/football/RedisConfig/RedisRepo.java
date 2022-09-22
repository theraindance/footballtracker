package com.miniproject.football.RedisConfig;

import java.util.ArrayList;

import com.miniproject.football.Model.User;


public interface RedisRepo {
    public void save(User theUser);
    public User get(String userName);
    public User checkuserexist(String userName, String email);
    // public User check(String email);
    public ArrayList<User> getAllUsers();
    public ArrayList<String> getAllEmail();
    public ArrayList<String> getAllTeam();
    public User delete(String userName);
    //public User checkname(String userName, String email);
    //public User delete(String HomeTeam);

    // public Contact findById(final String contactId);
}
