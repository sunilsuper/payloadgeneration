package com.org.generatepayload;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.org.generatepayload.impl.DateValidator;


public class DateValidatorUsingLocalDate implements DateValidator {
    
    @Override
    public boolean isValid(String dateStr)  {
        try {
            
            SimpleDateFormat date=new SimpleDateFormat("yyyy-mm-dd");
            Date s=date.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}