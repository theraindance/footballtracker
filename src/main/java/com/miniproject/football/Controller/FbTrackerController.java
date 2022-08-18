package com.miniproject.football.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miniproject.football.Model.User;

@Controller
public class FbTrackerController {

    // @RequestMapping("/")
    // public String showForm(){
        
    //     return "fbfavteam";
    // }

    @RequestMapping("/favouriteteam")
    
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
         
        List<String> listTeams = Arrays.asList("Manchester City", "Chelsea", "Newcastle");
        model.addAttribute("listTeams", listTeams);
         String hello="hello";
        return "fbfavteam";
    }

    // @RequestMapping("/")
    // public String showPage(){
    //     return "footballtracker";
    // }
}
