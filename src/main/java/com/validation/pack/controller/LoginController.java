package com.validation.pack.controller;


import com.validation.pack.entity.User;
import com.validation.pack.service.UserService;
import com.validation.pack.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.ui.Model;
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String showLoginPage() {
        return "login"; 
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }
    @GetMapping("/welcome")
    public String showWelcomeForm() {
        return "welcome";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if (userService.validateUser(username, password)) {
            // Redirect to a welcome page or dashboard
            return "redirect:/welcome";
        } else {
            // Add an error message and return to the login page
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    
    @PostMapping("/register")
    public ModelAndView registerUser(
            @RequestParam("name") String name,
            @RequestParam("contactNumber") String contactNumber,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword) {

        // Input validation
        if (!ValidationUtil.validateName(name)) {
            ModelAndView mav = new ModelAndView("register");
            mav.addObject("error", "Invalid name, Full Name is required");
            return mav;
        }
        if (!ValidationUtil.validateContactNumber(contactNumber)) {
            ModelAndView mav = new ModelAndView("register");
            mav.addObject("error", "Invalid contact number. It should be a 10-digit number, and should start with 7,8 or 9");
            return mav;
        }
        if (!ValidationUtil.validateUsername(username)) {
            ModelAndView mav = new ModelAndView("register");
            mav.addObject("error", "Invalid username. Username should have at least one uppercase letter and be 8 characters long.");
            return mav;
        }
        if (!ValidationUtil.validatePassword(password)) {
            ModelAndView mav = new ModelAndView("register");
            mav.addObject("error", "Invalid password. Password should be at least 8 characters long, with at least one uppercase letter, one lowercase letter, one digit, and one special character.");
            return mav;
        }
        if (!password.equals(confirmPassword)) {
            ModelAndView mav = new ModelAndView("register");
            mav.addObject("error", "Passwords do not match.");
            return mav;
        }

        // Check if user already exists
        if (userService.isUserExists(username)) {
            ModelAndView mav = new ModelAndView("register");
            mav.addObject("error", "Username already exists.");
            return mav;
        }

        // Create user object
        User user = new User(name, contactNumber, username, password);

        // Register user
        userService.registerUser(user);

        // Redirect to login page with success message
        return new ModelAndView("redirect:/login?success");
    }
}
