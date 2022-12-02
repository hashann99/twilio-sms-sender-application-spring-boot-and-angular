package com.schedule.twilio.service;

import com.schedule.twilio.dto.LoginDTO;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<Boolean> login(LoginDTO loginDTO);
}
