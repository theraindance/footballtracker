package com.miniproject.football.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class JsonParsingService implements ParsingService {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Object parse(String ccurl){
        return restTemplate.getForObject(ccurl, Object.class);
    }
}


