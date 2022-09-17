package com.miniproject.football.Service;
import java.io.StringReader;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import com.miniproject.football.Model.User;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;


public class MatchTeam {
    RestTemplate template = new RestTemplate();
    String URL = "https://fixturedownload.com/feed/json/epl-2022";
    
    public String getTeamName(Model model, @ModelAttribute User userObject){
        ResponseEntity<String> responseEntity = template.getForEntity(URL, String.class);
        String payload = responseEntity.getBody();
        //get Body of Json
        StringReader stringReader = new StringReader(payload);
        JsonReader jsonReader = Json.createReader(stringReader);
        //read an JSON array from a string
        JsonArray jsonArray = jsonReader.readArray();       
        //line 25 to 28, build to Json object or array, in order to get whatever you want
        //System.out.println(jsonArray.get(3));
        System.out.println(jsonArray.size());
        String all = "";
        
        try {
        for(int i = 0; i < jsonArray.size(); i++) {  
              
            // store each object in JSONObject  
            JsonObject obj = jsonArray.getJsonObject(i);
            //System.out.println(jsonArray.getJsonObject(0));
            if(userObject.getHomeTeam().equals(obj.getString("HomeTeam"))||userObject.getHomeTeam().equals(obj.getString("AwayTeam"))) {
            
                String htName = obj.getString("HomeTeam");
                if (htName != null){
                String hm=String.valueOf(htName)+", ";
                all += hm;}

                String atName = obj.getString("AwayTeam");
                if (atName != null){
                String aw=String.valueOf(atName)+", ";
                all += aw;}
            }  
        }  
                } catch (Exception e) {
                    
                }
        return all;
                    
    }

}
