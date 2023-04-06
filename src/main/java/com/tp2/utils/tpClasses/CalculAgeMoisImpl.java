package com.tp2.utils.tpClasses;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class CalculAgeMoisImpl implements ICalculAge {
    @Override
    public int calculer(Date d) {
        LocalDate dateDeNaissanceLD = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate maintenantLD = LocalDate.now();
        Period difference = Period.between(dateDeNaissanceLD, maintenantLD);
        int ageEnMois = difference.getYears() * 12 + difference.getMonths();
        return ageEnMois;
    }
}
