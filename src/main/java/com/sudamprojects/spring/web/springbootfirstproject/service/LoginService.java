package com.sudamprojects.spring.web.springbootfirstproject.service;

import org.springframework.stereotype.Component;

//Spring Bean
@Component
public class LoginService {
    public boolean validateUser(String userid, String password){
        return userid.equalsIgnoreCase("sudam") && password.equalsIgnoreCase("admin");
    }
}
