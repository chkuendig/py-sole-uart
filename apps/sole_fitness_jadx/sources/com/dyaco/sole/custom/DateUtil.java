package com.dyaco.sole.custom;

import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class DateUtil {
    public static int countAge(String str) {
        return new DateTime().getYear() - DateTime.parse(str).getYear();
    }
}
