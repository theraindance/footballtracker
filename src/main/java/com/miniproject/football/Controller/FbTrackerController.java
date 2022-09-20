package com.miniproject.football.Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.miniproject.football.Model.User;
import com.miniproject.football.RedisConfig.RedisService;
//import com.miniproject.football.Service.AwayMatchResult;
import com.miniproject.football.Service.MatchResult;
import com.miniproject.football.Service.MatchTeam;
//import com.miniproject.football.Service.ScoreService;
import com.miniproject.football.Service.TeamService;

@Controller
public class FbTrackerController {
    @Autowired
    RedisService rs;

    @GetMapping("/home")
    public String goeshome(Model model, @ModelAttribute User user){

        //ScoreService scoService = new ScoreService();
        //List<User> homeTeamScoreList = scoService.getHomeScore();
        //System.out.println("this is from hometeam score service " + homeTeamScoreList);
        
        TeamService service = new TeamService();
        //System.out.println(service);
        List<String> footBallList = service.getFootballTeams();
        //System.out.println(footBallList);
        
        //the 3 lines of code below call the MatchResult service and returns the location/football result)
        // MatchResult matchResult = new MatchResult();
        // String location = matchResult.getFbMatchResult();
        // System.out.println(location);
 
        model.addAttribute("teamlisting", footBallList);
        return "fbfavteam";
        
    }

    @PostMapping("/track")
    public String fbtrack(Model model, @ModelAttribute User userObject){

        // TeamService service = new TeamService();
        // String matchList = service.getFootballMatchR();
        // System.out.println(matchList);

        if(userObject.getHomeTeam()!=null){
            model.addAttribute("user",new User());
            model.addAttribute("HomeTeam", userObject.getHomeTeam());
            model.addAttribute("name", userObject.getName());
            model.addAttribute("email", userObject.getEmail());

            //model.addAttribute("matchlisting", matchList.getFootballMatchR);
        // model.addAttribute("AwayTeamScore", userObject.getAwayTeamScore());
        System.out.println("userObject get HomeTeam " + userObject.getHomeTeam());
        // User theUser = new User(userObject.getName(), userObject.getEmail(), userObject.getHomeTeam());
        // RedisService RS = new RedisService(); 
        MatchResult selectMR = new MatchResult();
        String selectResult = selectMR.getMatchResult(model, userObject);

        // AwayMatchResult awayMR = new AwayMatchResult();
        // String awResult = awayMR.getAwayMatchResult(model, userObject);
        
        System.out.println(selectResult);
        //System.out.println(awResult);

        for(int i=0; i<selectResult.length();i++){  
            char d = selectResult.charAt(i);  
            System.out.println(d);  
        } 
        
        // for(int i=0; i<awResult.length();i++){  
        //     char d = awResult.charAt(i);  
        //     System.out.println(d);  
        // } 
        model.addAttribute("HomeTeamScore0", selectResult.charAt(0));
        model.addAttribute("HomeTeamScore1", selectResult.charAt(2));
        model.addAttribute("HomeTeamScore2", selectResult.charAt(4));
        model.addAttribute("HomeTeamScore3", selectResult.charAt(6));
        model.addAttribute("HomeTeamScore4", selectResult.charAt(8));
        model.addAttribute("HomeTeamScore5", selectResult.charAt(10));
        // model.addAttribute("HomeTeamScore6", selectResult.charAt(12));
        // model.addAttribute("HomeTeamScore7", selectResult.charAt(14));
        // model.addAttribute("HomeTeamScore8", selectResult.charAt(16));
        // model.addAttribute("HomeTeamScore9", selectResult.charAt(18));

        // model.addAttribute("HomeTeamScore10", selectResult.charAt(20));
        // model.addAttribute("HomeTeamScore11", selectResult.charAt(22));
        // model.addAttribute("HomeTeamScore12", selectResult.charAt(24));
        // model.addAttribute("HomeTeamScore13", selectResult.charAt(26));
        // model.addAttribute("HomeTeamScore14", selectResult.charAt(28));
        // model.addAttribute("HomeTeamScore15", selectResult.charAt(30));
        // model.addAttribute("HomeTeamScore16", selectResult.charAt(32));
        // model.addAttribute("HomeTeamScore17", selectResult.charAt(34));
        // model.addAttribute("HomeTeamScore18", selectResult.charAt(36));
        // model.addAttribute("HomeTeamScore19", selectResult.charAt(38));

        model.addAttribute("AwayTeamScore0", selectResult.charAt(1));
        model.addAttribute("AwayTeamScore1", selectResult.charAt(3));
        model.addAttribute("AwayTeamScore2", selectResult.charAt(5));
        model.addAttribute("AwayTeamScore3", selectResult.charAt(7));
        model.addAttribute("AwayTeamScore4", selectResult.charAt(9));
        model.addAttribute("AwayTeamScore5", selectResult.charAt(11));


        MatchTeam selectMT = new MatchTeam();
        String selectTeam = selectMT.getTeamName(model, userObject);
        System.out.println("String of Teams from results" + selectTeam);
        List<String> teamname = Arrays.asList(selectTeam.split(", "));
        System.out.println("here is teamname List " + teamname);


        model.addAttribute("HomeTeamName0", teamname.get(0));
        model.addAttribute("HomeTeamName1", teamname.get(2));
        model.addAttribute("HomeTeamName2", teamname.get(4));
        model.addAttribute("HomeTeamName3", teamname.get(6));
        model.addAttribute("HomeTeamName4", teamname.get(8));
        model.addAttribute("HomeTeamName5", teamname.get(10));

        model.addAttribute("AwayTeamName0", teamname.get(1));
        model.addAttribute("AwayTeamName1", teamname.get(3));
        model.addAttribute("AwayTeamName2", teamname.get(5));
        model.addAttribute("AwayTeamName3", teamname.get(7));
        model.addAttribute("AwayTeamName4", teamname.get(9));
        model.addAttribute("AwayTeamName5", teamname.get(11));

        rs.save(userObject);
        } else {
            User userobj = rs.get(userObject.getName());
        if(userobj.getName().equals(userObject.getName()) && userobj.getEmail().equals(userObject.getEmail())){

            model.addAttribute("user",new User());
            model.addAttribute("HomeTeam", userobj.getHomeTeam());
            model.addAttribute("name", userobj.getName());
            model.addAttribute("email", userobj.getEmail());

            //model.addAttribute("matchlisting", matchList.getFootballMatchR);
        // model.addAttribute("AwayTeamScore", userObject.getAwayTeamScore());
        System.out.println("userObject get HomeTeam " + userobj.getHomeTeam());
        // User theUser = new User(userObject.getName(), userObject.getEmail(), userObject.getHomeTeam());
        // RedisService RS = new RedisService(); 
        MatchResult selectMR = new MatchResult();
        String selectResult = selectMR.getMatchResult(model, userobj);

        // AwayMatchResult awayMR = new AwayMatchResult();
        // String awResult = awayMR.getAwayMatchResult(model, userObject);
        
        System.out.println(selectResult);
        //System.out.println(awResult);

        for(int i=0; i<selectResult.length();i++){  
            char d = selectResult.charAt(i);  
            System.out.println(d);  
        } 
        
        // for(int i=0; i<awResult.length();i++){  
        //     char d = awResult.charAt(i);  
        //     System.out.println(d);  
        // } 
        model.addAttribute("HomeTeamScore0", selectResult.charAt(0));
        model.addAttribute("HomeTeamScore1", selectResult.charAt(2));
        model.addAttribute("HomeTeamScore2", selectResult.charAt(4));
        model.addAttribute("HomeTeamScore3", selectResult.charAt(6));
        model.addAttribute("HomeTeamScore4", selectResult.charAt(8));
        model.addAttribute("HomeTeamScore5", selectResult.charAt(10));
        // model.addAttribute("HomeTeamScore6", selectResult.charAt(12));
        // model.addAttribute("HomeTeamScore7", selectResult.charAt(14));
        // model.addAttribute("HomeTeamScore8", selectResult.charAt(16));
        // model.addAttribute("HomeTeamScore9", selectResult.charAt(18));

        // model.addAttribute("HomeTeamScore10", selectResult.charAt(20));
        // model.addAttribute("HomeTeamScore11", selectResult.charAt(22));
        // model.addAttribute("HomeTeamScore12", selectResult.charAt(24));
        // model.addAttribute("HomeTeamScore13", selectResult.charAt(26));
        // model.addAttribute("HomeTeamScore14", selectResult.charAt(28));
        // model.addAttribute("HomeTeamScore15", selectResult.charAt(30));
        // model.addAttribute("HomeTeamScore16", selectResult.charAt(32));
        // model.addAttribute("HomeTeamScore17", selectResult.charAt(34));
        // model.addAttribute("HomeTeamScore18", selectResult.charAt(36));
        // model.addAttribute("HomeTeamScore19", selectResult.charAt(38));

        model.addAttribute("AwayTeamScore0", selectResult.charAt(1));
        model.addAttribute("AwayTeamScore1", selectResult.charAt(3));
        model.addAttribute("AwayTeamScore2", selectResult.charAt(5));
        model.addAttribute("AwayTeamScore3", selectResult.charAt(7));
        model.addAttribute("AwayTeamScore4", selectResult.charAt(9));
        model.addAttribute("AwayTeamScore5", selectResult.charAt(11));


        MatchTeam selectMT = new MatchTeam();
        String selectTeam = selectMT.getTeamName(model, userobj);
        System.out.println("String of Teams from results" + selectTeam);
        List<String> teamname = Arrays.asList(selectTeam.split(", "));
        System.out.println("here is teamname List " + teamname);


        model.addAttribute("HomeTeamName0", teamname.get(0));
        model.addAttribute("HomeTeamName1", teamname.get(2));
        model.addAttribute("HomeTeamName2", teamname.get(4));
        model.addAttribute("HomeTeamName3", teamname.get(6));
        model.addAttribute("HomeTeamName4", teamname.get(8));
        model.addAttribute("HomeTeamName5", teamname.get(10));

        model.addAttribute("AwayTeamName0", teamname.get(1));
        model.addAttribute("AwayTeamName1", teamname.get(3));
        model.addAttribute("AwayTeamName2", teamname.get(5));
        model.addAttribute("AwayTeamName3", teamname.get(7));
        model.addAttribute("AwayTeamName4", teamname.get(9));
        model.addAttribute("AwayTeamName5", teamname.get(11));

            System.out.println("access granted");
        }

        }
        
        return "trackmyteam";
    }

    @GetMapping("/signinform")
    public String signin(Model model, @ModelAttribute User User){
        //below is from database
        // User userobj = rs.get(userObject.getName());
        // if(userobj.getName().equals(userObject.getName())){
        //     System.out.println("access granted");
        // }
        // User userobj = rs.get(userObject.getName());
        // User userobj, this is from redis db
        // userObject.getName(), this is from user submittion from signin form
        

        // TeamService service = new TeamService();
        // List<String> footBallList = service.getFootballTeams();
        // model.addAttribute("teamlisting", footBallList);
        return "signinform";
    }

    @GetMapping("/userlist")
    public String listofuser(Model model, @ModelAttribute User userObject){
        //TeamService service = new TeamService();
        //List<Integer> matchList = service.getFootballMatchR();

        ArrayList<String> Users = rs.getAllUsers();
        ArrayList<String> UsersEmail = rs.getAllEmail();
        ArrayList<String> UsersTeam = rs.getAllTeam();

        model.addAttribute("userList",Users);
        model.addAttribute("emailList",UsersEmail);
        model.addAttribute("teamList",UsersTeam);
        model.addAttribute("user",new User());
        model.addAttribute("HomeTeam", userObject.getHomeTeam());
        model.addAttribute("name", userObject.getName());
        
        return "userlist";
    }

    
    // @RequestMapping("/trackmyteam")
    // private String listMatches(Model model, @ModelAttribute User user){
    //   model.addAttribute("trackmyteam", user.getHomeTeamScore());
    //   return "trackmyteam";
  	// }

    
}