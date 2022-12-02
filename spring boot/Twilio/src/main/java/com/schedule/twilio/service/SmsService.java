package com.schedule.twilio.service;

import com.schedule.twilio.dto.MessageAndTime;
import com.schedule.twilio.dto.NumberDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SmsService {
    ResponseEntity<Boolean> setMobileNumbersToArray(List<NumberDTO> numbers);

    void setTimeAndMessage(MessageAndTime messageAndTime);

    ResponseEntity<Boolean> cancelScheduleMessage();

}
