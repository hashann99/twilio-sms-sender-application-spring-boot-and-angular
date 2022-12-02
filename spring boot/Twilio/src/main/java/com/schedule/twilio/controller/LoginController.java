package com.schedule.twilio.controller;

import com.schedule.twilio.dto.LoginDTO;
import com.schedule.twilio.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Component
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Boolean>login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }
}
