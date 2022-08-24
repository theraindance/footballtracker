package com.miniproject.football.Controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.json.simple.parser.ParseException;

import com.miniproject.football.Model.User;
import com.miniproject.football.Service.ParsingService;
import com.miniproject.football.Service.Service;

@Controller
public class FbTrackerController {
    

    //RestTemplate template = new RestTemplate();
    private static final String JSON_CC_URL = "https://fixturedownload.com/feed/json/epl-2022";
    

    @Autowired
    private ParsingService parsingService;

    @GetMapping("/home")
    public String whatever(Model model, @ModelAttribute User user) throws FileNotFoundException, IOException, ParseException{

        Service service = new Service();
        service.getFootballTeams();
        ArrayList<String> teamListing
            = new ArrayList<>(service.getFootballTeams());
        //System.out.println(teamListing);
        String teams = String.join(" ", teamListing);
        System.out.println(teams);

        //List<User> teams = (List<User>) parsingService.parse(JSON_CC_URL);
        model.addAttribute("teamListing", teams);
       //note1: must be same name as in main.html iStat: ${}
        return "fbfavteam";
        
    }
    @PostMapping("/track")
    public String fbtrack(Model model, @ModelAttribute User userObject){
        model.addAttribute("user",new User());
        model.addAttribute("HomeTeam", userObject.getHomeTeam());
        model.addAttribute("name", userObject.getName());
        model.addAttribute("email", userObject.getEmail());
        model.addAttribute("AwayTeamScore", userObject.getAwayTeamScore());
        System.out.println(userObject.getHomeTeam());
        return "trackmyteam";
    }
}