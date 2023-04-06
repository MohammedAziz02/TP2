package com.tp2.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AgeCalculator {
    public static int calculateAge(Date d) {
        // calculate age based on current date
        long ageInMillis = new Date().getTime() - d.getTime();
        // convert milliseconds to years
        int age = (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
        return age;
    }
}
