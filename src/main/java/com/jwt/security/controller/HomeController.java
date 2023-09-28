package com.jwt.security.controller;

import com.jwt.security.entities.User;
import com.jwt.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    private Logger logger= LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> getUser()
    {
    logger.info("This is the test user");
        List<User> users = userService.getUsers();
        return users;
    }

    @GetMapping("/current-user")
    public  String getLoginUser(Principal principal)
    {
    logger.info("This is featcing login  test user");
        return principal.getName();

    }
}
