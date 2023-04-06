package com.tp2.utils.tpClasses;

import java.util.Date;

public class CompareAgeImpl {

    public int comparer(Date d1, Date d2) {
        if (d1.before(d2)) {
            return 1;
        } else if (d1.equals(d2)) {
            return 0;
        } else {
            return -1;
        }
    }
}
