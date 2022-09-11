package com.miniproject.football.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.football.Model.User;
import com.miniproject.football.RedisConfig.RedisService;
import com.miniproject.football.Service.ParsingService;
import com.miniproject.football.Service.TeamService;

// @RestController
// @RequestMapping("/hello")
@Controller
public class FbTrackerController {
    @Autowired
    RedisService rs;

    @GetMapping("/home")
    public String whatever(Model model, @ModelAttribute User user){

        TeamService service = new TeamService();
        List<String> footBallList = service.getFootballTeams();
        //System.out.println(footBallList);
 
        model.addAttribute("teamlisting", footBallList);
        return "fbfavteam";
        
    }

    @PostMapping("/track")
    public String fbtrack(Model model, @ModelAttribute User userObject){

        model.addAttribute("user",new User());
        model.addAttribute("HomeTeam", userObject.getHomeTeam());
        model.addAttribute("name", userObject.getName());
        model.addAttribute("email", userObject.getEmail());
        // model.addAttribute("AwayTeamScore", userObject.getAwayTeamScore());
        System.out.println(userObject.getHomeTeam());
        // User theUser = new User(userObject.getName(), userObject.getEmail(), userObject.getHomeTeam());
        // RedisService RS = new RedisService(); 
        rs.save(userObject);
        return "trackmyteam";
    }

    @GetMapping("/signinform")
    public String however(Model model, @ModelAttribute User user){
        TeamService service = new TeamService();
        List<String> footBallList = service.getFootballTeams();
        model.addAttribute("teamlisting", footBallList);
        
        System.out.println("hello");
        return "signinform";
    }

    
}