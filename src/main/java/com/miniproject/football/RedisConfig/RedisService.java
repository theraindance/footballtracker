package com.miniproject.football.RedisConfig;

import java.util.ArrayList;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.miniproject.football.Model.User;

@Service
public class RedisService implements RedisRepo {
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Autowired
    RedisTemplate<String, User> redisTemplate;

    @Override
    public void save(User theUser) {
        redisTemplate.opsForValue().set(theUser.getName(), theUser);
    }

    @Override
    public User get(String userName) {
        User userobject = redisTemplate.opsForValue().get(userName);
        return userobject;

    }

    @Override
    public User delete(String userName) {
        User userobject = redisTemplate.opsForValue().getAndDelete(userName);
        return userobject;

    }

    @Override
    public ArrayList<String> getAllUsers() {
        Set<String> tempUsers = redisTemplate.keys("*");
        ArrayList<String> Users = new ArrayList<>();
        for (String user:tempUsers){
            Users.add(user);
            //For every user in tempUsers, save in Users

        }
        return Users;

    }

    @Override
    public ArrayList<String> getAllEmail() {
        Set<String> tempUsersEmail = redisTemplate.keys("*");
        ArrayList<String> Users = new ArrayList<>();
        for (String user:tempUsersEmail){
            User userobject = redisTemplate.opsForValue().get(user);
            Users.add(userobject.getEmail());
            //For every user in tempUsers, save in Users

        }
        return Users;

    }

    @Override
    public ArrayList<String> getAllTeam() {
        Set<String> tempUsersTeam = redisTemplate.keys("*");
        ArrayList<String> Users = new ArrayList<>();
        for (String user:tempUsersTeam){
            User userobject = redisTemplate.opsForValue().get(user);
            Users.add(userobject.getHomeTeam());
            //For every user in tempUsers, save in Users

        }
        return Users;

    }


    
    // @Override
    // public User delete(String deleteTeam){
    //     User userobject = redisTemplate.opsForValue().getAndDelete(deleteTeam);
    //     return userobject;
    // }
    
    // @Override
    // public Contact findById(final String contactId) {
    //     Contact result = (Contact) redisTemplate.opsForValue().get(contactId);
    //     logger.info(">>> " + result.getEmail());
    //     return result;
    // }
}