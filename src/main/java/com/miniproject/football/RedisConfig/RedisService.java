package com.miniproject.football.RedisConfig;

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
    // @Override
    // public Contact findById(final String contactId) {
    //     Contact result = (Contact) redisTemplate.opsForValue().get(contactId);
    //     logger.info(">>> " + result.getEmail());
    //     return result;
    // }
}