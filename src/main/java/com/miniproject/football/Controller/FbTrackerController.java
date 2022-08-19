package com.miniproject.football.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.miniproject.football.Model.User;
import com.miniproject.football.Service.ParsingService;

@Controller
public class FbTrackerController {
    

    //RestTemplate template = new RestTemplate();
    private static final String JSON_CC_URL = "https://fixturedownload.com/feed/json/epl-2022";
    

    @Autowired
    private ParsingService parsingService;

    @GetMapping("/home")
    public String whatever(Model model, @ModelAttribute User user){
       List<User> teams = (List<User>) parsingService.parse(JSON_CC_URL);
       model.addAttribute("teamList", teams);
       System.out.println(teams);
       //note1: must be same name as in main.html iStat: ${}
        return "fbfavteam";
        
    }
    //@ModelAttribute User user, here the @modelattribute gets data from the form, put into the listCount, Country is the object
    @PostMapping("/track")
    public String fbtrack(Model model, @ModelAttribute User userObject){
        //var selectedSR = model.addAttribute(subregion, subregion);
        model.addAttribute("user",new User());
        model.addAttribute("HomeTeam", userObject.getHomeTeam());
        model.addAttribute("name", userObject.getName());
        model.addAttribute("email", userObject.getEmail());
        model.addAttribute("AwayTeamScore", userObject.getAwayTeamScore());
        System.out.println(userObject.getHomeTeam());
        return "trackmyteam";
    }
}
