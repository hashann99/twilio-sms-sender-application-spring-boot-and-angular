package com.schedule.twilio.service.impl;

import com.schedule.twilio.dto.LoginDTO;
import com.schedule.twilio.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public ResponseEntity<Boolean> login(LoginDTO loginDTO) {
        if(loginDTO.getUserName().trim().equals("Alex")){
            if(loginDTO.getPassword().trim().equals("1234")){
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
