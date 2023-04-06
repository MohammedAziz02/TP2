package com.tp2.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

public class CalculAgeImpl implements ICalculAge{
    @Override
    public int calculer(Date d) {
        // calculate age based on current date
        long ageInMillis = new Date().getTime() - d.getTime();
        // convert milliseconds to years
        int age = (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
        return age;
    }
}
