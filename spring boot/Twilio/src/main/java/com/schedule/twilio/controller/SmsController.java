package com.schedule.twilio.controller;

import com.schedule.twilio.dto.MessageAndTime;
import com.schedule.twilio.dto.NumberDTO;
import com.schedule.twilio.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Component
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/saveNumberList")
    public ResponseEntity<Boolean> setMobileNumbersToArray(@RequestBody List<NumberDTO>numbers){
        return this.smsService.setMobileNumbersToArray(numbers);
    }

    @PostMapping("/saveTimeAndMessage")
    public void setTimeAndMessage(@RequestBody MessageAndTime messageAndTime){
        this.smsService.setTimeAndMessage(messageAndTime);
    }

    //set all variable of clear
    @GetMapping("/clearAll")
    public ResponseEntity<Boolean> cancelScheduleMessage(){
        return this.smsService.cancelScheduleMessage();
    }

}
