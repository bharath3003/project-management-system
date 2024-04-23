package com.JavaProject.controller;

import java.security.Principal;
import java.util.List;
import com.JavaProject.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JavaProject.repository.ProjectRepository;
import com.JavaProject.repository.UserRepo;
import com.JavaProject.entity.Project;
import com.JavaProject.entity.Project.DomainName;
import com.JavaProject.entity.User;
import com.JavaProject.service.ProjectService;
import com.JavaProject.service.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.JavaProject.repository.AcceptedRepo;
import com.JavaProject.repository.RequestsRepo;
import com.JavaProject.entity.Requests;
import jakarta.servlet.http.HttpSession;
import com.JavaProject.service.RequestService;
import com.JavaProject.entity.Accepted;
import com.JavaProject.entity.RegularUser;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController extends BaseRequestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RequestsRepo requestsRepo;

    @Autowired
    private AcceptedRepo acceptedRepo;

    @Autowired
    private RequestService requestService;

    @Override
    protected String handleAuthenticatedRequest(Principal p, Model model) {
        String email = p.getName();
        User user = userRepo.findByEmail(email);
        model.addAttribute("user", user);
        return "profile"; // Assuming "profile" is the view name for authenticated users
    }
    

    @Override
    protected String handleUnauthenticatedRequest(Model model) {
        return "index"; // Redirecting unauthenticated users to the index page// Handle unauthenticated request logic
    }

    @ModelAttribute
    public void commonUser(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            User user = userRepo.findByEmail(email);
            m.addAttribute("user", user);
        }
    }

    @GetMapping("/")
    public String index(Principal principal) {
        if (principal != null) {
            return "redirect:/user/profile";
        }
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/user/profile")
    public String profile(Principal p, Model m) {
        String email = p.getName();
        User user = userRepo.findByEmail(email);
        RegularUser regularUser = new RegularUser("regular");
        m.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/user/projectdetails")
    public String projectdetails() {
        return "projectdetails";
    }
    @GetMapping("/user/projects")
    public String projects(Model model) {
        List<ProjectDto> allProjects = projectService.getAllProjects();
        model.addAttribute("allProjects", allProjects);
        return "projects";
    }

    @PostMapping("/user/projects")
    public String projectsByDomain(@RequestParam("domain") DomainName domain, Model model) {
        List<ProjectDto> projectsByDomain = projectService.getProjectsByDomain(domain);
        model.addAttribute("allProjects", projectsByDomain);
        return "projects";
    }
    @GetMapping("/user/inbox")
    public String inbox(Principal p, Model m) {
        String email = p.getName();
        User user = userRepo.findByEmail(email);
        m.addAttribute("user", user);
        // Fetch the accepted friends of the user from the database
        List<Accepted> acceptedFriends = acceptedRepo.findAll();
        m.addAttribute("acceptedFriends", acceptedFriends);

        
        List<Requests> requests = requestsRepo.findAll();  
        
        // Add requests to the model
        m.addAttribute("requests", requests);
        return "inbox";
        
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {
        User u = userService.saveUser(user);
        if (u != null) {
            session.setAttribute("msg", "Registered successfully");
        } else {
            session.setAttribute("msg", "Server error");
        }
        return "redirect:/register";
    }
    @PostMapping("/inbox/acceptRequest")
    public String acceptRequest(@RequestParam("reqSender") String reqSender, @ModelAttribute("user") User user) {
        requestService.acceptRequest(reqSender, user.getEmail());
        return "redirect:/user/inbox";
    }

    @PostMapping("/inbox/rejectRequest")
    public String rejectRequest(@RequestParam("reqSender") String reqSender, @ModelAttribute("user") User user) {
        requestService.rejectRequestBySender(reqSender, user.getEmail());
        return "redirect:/user/inbox";
    }
    @GetMapping("/viewprofile")
    public String viewFriendProfile(@RequestParam("friendEmail") String friendEmail, Model model) {
        // Retrieve the friend's profile from the database using their email
        User friend = userService.getUserByEmail(friendEmail);
        
        // Add the friend's profile to the model
        model.addAttribute("friend", friend);
        
        return "friend_profile"; // Assuming friend_profile.html is the template for friend profiles
    }
}