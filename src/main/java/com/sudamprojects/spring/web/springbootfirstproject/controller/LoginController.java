package com.sudamprojects.spring.web.springbootfirstproject.controller;

import com.sudamprojects.spring.web.springbootfirstproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    //Inject automatically
    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String showLoginMessage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String showWelcomeMessage(ModelMap model, @RequestParam String name,@RequestParam String password ){
        boolean isValidUser = service.validateUser(name,password);

        if(!isValidUser){
            model.put("errorMessage","Invalid Credentials");
            return "login";
        }
        model.put("name",name);
        model.put("password",password);

        return "welcome";
    }
}
