package com.schedule.twilio.service.impl;

import com.schedule.twilio.dto.MessageAndTime;
import com.schedule.twilio.dto.NumberDTO;
import com.schedule.twilio.service.SmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SmsServiceImpl implements SmsService {

    List<NumberDTO> numberDTOS;
    // This variable check sendSMS method are already execute or no
    // it's check by timeSchedule method
    boolean isSend=false;

    int setMonth,setDay,setHour,setMinute;
    String message;

    // this method call by timeSchedule method
    public ResponseEntity<String> sendSMS() {
        for (NumberDTO number:numberDTOS){
            try {
                Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
                Message.creator(new PhoneNumber("\""+number.getNumber()+"\""), new PhoneNumber(System.getenv("TWILIO_PHONE_NUMBER")), message).create();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }


    @Scheduled(fixedRate = 60000)
    public void timeSchedule() throws FileNotFoundException {
        LocalDate date = LocalDate.now();
        int month = date.getMonth().getValue();
        int day=date.getDayOfMonth();

        LocalTime time = LocalTime.now();
        int hour=time.getHour();
        int minute=time.getMinute();

        System.out.println("======================= number list =======================");
        try {
            for (NumberDTO obj:numberDTOS){ System.out.println(obj.getNumber());}
        }catch (Exception e){ System.out.println(e);}

        System.out.println("================= front end details ============================");
        System.out.println("month : "+setMonth);
        System.out.println("day : "+setDay);
        System.out.println("hour : "+setHour);
        System.out.println("minute : "+setMinute);

        System.out.println("================= back end details ============================");
        System.out.println("month : "+month);
        System.out.println("day : "+day);
        System.out.println("hour : "+hour);
        System.out.println("minute : "+minute);
        System.out.println("message  :"+ message);

        if(setMonth==month && setDay == day){
            if(setHour==hour && setMinute==minute){
                if(isSend==false){
                    System.out.println("message send now");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date dates = new Date();
                    System.out.println(formatter.format(dates));
                    // call method here
                    sendSMS();
                    isSend=true; // set message send already
                }
            }
        }
    }

    @Override
    public ResponseEntity<Boolean> setMobileNumbersToArray(List<NumberDTO> numbers) {
        numberDTOS=numbers;
        if(numberDTOS.size()>0){
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
    }

    @Override
    public void setTimeAndMessage(MessageAndTime messageAndTime) {
        this.setMonth=messageAndTime.getMonth()+1;
        this.setDay=messageAndTime.getDay();
        this.setHour=messageAndTime.getHour();
        this.setMinute=messageAndTime.getMinute();
        this.message=messageAndTime.getMessage();
        this.isSend=false;
    }

    @Override
    public ResponseEntity<Boolean> cancelScheduleMessage() {
        numberDTOS=new ArrayList<>();
        this.setHour=0;
        this.setMinute=0;
        this.setMonth=0;
        this.setDay=0;
        this.isSend=false;
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
}
