package com.miniproject.football.Service;

import java.io.StringReader;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

public class Service {
    RestTemplate template = new RestTemplate();
    String URL = "https://fixturedownload.com/feed/json/epl-2022";

    public Set<String> getFootballTeams(){
        ResponseEntity<String> responseEntity = template.getForEntity(URL, String.class);
        String payload = responseEntity.getBody();
        StringReader stringReader = new StringReader(payload);
        JsonReader jsonReader = Json.createReader(stringReader);
        JsonArray jsonArray = jsonReader.readArray();
        //line 23 to 25, build to Json object or array, in order to get whatever you want
        Set<String> footBallSet = new HashSet<>();
        //empty set for the footballteam to populate in using the for loop
        //in jsonArray, for every v, loop through v.
        for (JsonValue v : jsonArray){
            String homeTeam = v.asJsonObject().getString("HomeTeam");
            footBallSet.add(homeTeam);
        }
        // System.out.println(footBallSet.size());
        for (String s : footBallSet){
             System.out.println(s);
        }

        return footBallSet;


    }
    
}
