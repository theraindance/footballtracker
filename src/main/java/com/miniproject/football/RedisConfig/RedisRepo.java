package com.miniproject.football.RedisConfig;

import com.miniproject.football.Model.User;


public interface RedisRepo {
    public void save(User theUser);
    public User get(String userName);
    //public User delete(String HomeTeam);

    // public Contact findById(final String contactId);
}
