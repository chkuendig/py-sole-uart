package com.ua.sdk.internal;

import com.ua.sdk.LocalDate;
import com.ua.sdk.MetabolicEnergyCalculator;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.activitytype.WorkoutMetsSpeed;
import com.ua.sdk.user.Gender;
import com.ua.sdk.user.User;
import com.ua.sdk.util.Convert;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class MetabolicEnergyCalculatorImpl implements MetabolicEnergyCalculator {
    @Override // com.ua.sdk.MetabolicEnergyCalculator
    public double calculateJoules(User user, ActivityType activityType, double d, double d2) throws NullPointerException {
        Precondition.isNotNull(user, "User");
        Double weight = user.getWeight();
        Double height = user.getHeight();
        Precondition.isNotNull(user.getBirthdate(), "User's birthdate");
        int iExtractAge = extractAge(user.getBirthdate());
        if (iExtractAge < 13) {
            throw new IllegalArgumentException("User's age must be > 13");
        }
        Gender gender = user.getGender();
        Precondition.isNotNull(weight, "User's weight");
        Precondition.isNotNull(height, "User's height");
        Precondition.isNotNull(gender, "User's gender");
        Precondition.isNotNull(activityType, "Activity Type");
        return getMets(d, d2, activityType, height, weight, gender, iExtractAge) * weight.doubleValue() * (d / 3600.0d) * 4184.0d;
    }

    private double getMets(double d, double d2, ActivityType activityType, Double d3, Double d4, Gender gender, int i) {
        double dDoubleValue;
        Double speedAwareMets;
        if (d2 > 1.0d && d > 1.0d && (speedAwareMets = getSpeedAwareMets(Double.valueOf(Convert.meterPerSecToMilePerHour(Double.valueOf(d2 / d)).doubleValue()), activityType.getMetsSpeed())) != null) {
            dDoubleValue = speedAwareMets.doubleValue();
        } else {
            dDoubleValue = activityType.getMetsValue().doubleValue();
        }
        return dDoubleValue * (3.5d / ((((getHarrisBenedictRmr(d3, d4, gender, i) / 1440.0d) / 5.0d) * 1000.0d) / d4.doubleValue()));
    }

    private Double getSpeedAwareMets(Double d, String str) throws JSONException {
        WorkoutMetsSpeed workoutMetsSpeed;
        Double dLinearInterpolateMets;
        List<WorkoutMetsSpeed> speedList = WorkoutMetsSpeed.parseSpeedList(str);
        if (speedList.size() < 2) {
            return null;
        }
        WorkoutMetsSpeed workoutMetsSpeed2 = speedList.get(0);
        int i = 1;
        WorkoutMetsSpeed workoutMetsSpeed3 = null;
        while (true) {
            if (i >= speedList.size()) {
                WorkoutMetsSpeed workoutMetsSpeed4 = workoutMetsSpeed3;
                workoutMetsSpeed = workoutMetsSpeed2;
                workoutMetsSpeed2 = workoutMetsSpeed4;
                break;
            }
            workoutMetsSpeed = speedList.get(i);
            if (workoutMetsSpeed.getSpeedMilesPerHour().doubleValue() > d.doubleValue()) {
                break;
            }
            i++;
            workoutMetsSpeed3 = workoutMetsSpeed2;
            workoutMetsSpeed2 = workoutMetsSpeed;
        }
        if (d.doubleValue() < workoutMetsSpeed2.getSpeedMilesPerHour().doubleValue()) {
            dLinearInterpolateMets = workoutMetsSpeed2.getMets();
        } else if (d.doubleValue() > workoutMetsSpeed.getSpeedMilesPerHour().doubleValue()) {
            dLinearInterpolateMets = workoutMetsSpeed.getMets();
        } else {
            dLinearInterpolateMets = linearInterpolateMets(workoutMetsSpeed2, workoutMetsSpeed, d);
        }
        if (dLinearInterpolateMets.doubleValue() < 0.0d) {
            return null;
        }
        return dLinearInterpolateMets;
    }

    public Double linearInterpolateMets(WorkoutMetsSpeed workoutMetsSpeed, WorkoutMetsSpeed workoutMetsSpeed2, Double d) {
        Double dValueOf = Double.valueOf((workoutMetsSpeed2.getMets().doubleValue() - workoutMetsSpeed.getMets().doubleValue()) / (workoutMetsSpeed2.getSpeedMilesPerHour().doubleValue() - workoutMetsSpeed.getSpeedMilesPerHour().doubleValue()));
        return Double.valueOf((dValueOf.doubleValue() * d.doubleValue()) + Double.valueOf(workoutMetsSpeed2.getMets().doubleValue() - (dValueOf.doubleValue() * workoutMetsSpeed2.getSpeedMilesPerHour().doubleValue())).doubleValue());
    }

    private double getHarrisBenedictRmr(Double d, Double d2, Gender gender, int i) {
        double dDoubleValue;
        double d3;
        double dDoubleValue2 = d.doubleValue() * 100.0d;
        if (gender == Gender.MALE) {
            dDoubleValue = (d2.doubleValue() * 13.7516d) + 66.473d + (dDoubleValue2 * 5.0033d);
            d3 = 6.755d;
        } else {
            dDoubleValue = (d2.doubleValue() * 9.5634d) + 655.0955d + (dDoubleValue2 * 1.8496d);
            d3 = 4.6756d;
        }
        return dDoubleValue - (i * d3);
    }

    private static int extractAge(LocalDate localDate) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Locale.US);
        gregorianCalendar.set(1, localDate.getYear());
        gregorianCalendar.set(2, localDate.getMonth());
        gregorianCalendar.set(5, localDate.getDayOfMonth());
        Calendar calendar = getCalendar(new Date());
        int i = calendar.get(1) - gregorianCalendar.get(1);
        return (gregorianCalendar.get(2) > calendar.get(2) || (gregorianCalendar.get(2) == calendar.get(2) && gregorianCalendar.get(5) > calendar.get(5))) ? i - 1 : i;
    }

    private static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.setTime(date);
        return calendar;
    }
}
