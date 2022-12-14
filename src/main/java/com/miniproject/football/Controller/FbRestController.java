package com.miniproject.football.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.football.Model.User;
import com.miniproject.football.RedisConfig.RedisService;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@RestController
public class FbRestController {
        @Autowired
        RedisService rs;

        @GetMapping("/track/{username}/{email}")
        public ResponseEntity userId(@PathVariable String username, String email, String Hometeam){
            try {
                
                User userx = rs.get(username);
                JsonObjectBuilder builder = Json.createObjectBuilder();
                builder.add("Name:",userx.getName());
                builder.add("Email:",userx.getEmail());
                builder.add("HomeTeam:",userx.getHomeTeam());
                
                JsonObject body = builder.build();

                   return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(body.toString());
                
            } 
            
            catch (Exception e) {
                JsonObjectBuilder builder = Json.createObjectBuilder();
                builder.add("error","data not found");
                JsonObject body = builder.build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body.toString());

            }
            
            
        }
    
}
