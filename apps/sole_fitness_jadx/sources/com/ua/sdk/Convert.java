package com.ua.sdk;

/* loaded from: classes2.dex */
public final class Convert {
    public static final double FEET_IN_METER = 3.28084d;
    public static final long HOURS_IN_DAY = 24;
    public static final double INCH_IN_METER = 39.3701d;
    public static final double JOULES_IN_KCALORIE = 4184.0d;
    public static final int JOULES_TO_KJ = 1000;
    public static final double KCALORIES_IN_JOULE = 2.3900573E-4d;
    public static final double KJ_TO_LARGE_CALORIES = 0.239005736d;
    public static final double LBS_IN_KG = 2.20462d;
    public static final double METER_IN_KILOMETER = 1000.0d;
    public static final double METER_IN_MILE = 1609.344d;
    public static final double MILE_IN_KM = 0.621371d;
    public static final long MILLISECONDS_IN_DAY = 86400000;
    public static final long MILLISECONDS_IN_HOUR = 3600000;
    public static final long MILLISECONDS_IN_MINUTE = 60000;
    public static final long MILLISECONDS_IN_SECOND = 1000;
    public static final long MILLISECONDS_IN_WEEK = 604800000;
    public static final long MINUTES_IN_DAY = 1440;
    public static final long MINUTES_IN_HOUR = 60;
    public static final long SECONDS_IN_DAY = 86400;
    public static final long SECONDS_IN_HOUR = 3600;
    public static final long SECONDS_IN_MINUTE = 60;

    private Convert() {
    }

    public static Double inchToMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 39.3701d);
        }
        return null;
    }

    public static Double kilometerPerHourToMeterPerSec(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1000.0d) / 3600.0d);
        }
        return null;
    }

    public static Double kilometerToMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 1000.0d);
        }
        return null;
    }

    public static Double kilometerToMile(Double d) {
        if (d != null) {
            return meterToMile(kilometerToMeter(d));
        }
        return null;
    }

    public static Double kgToLbs(Double d) {
        return d != null ? Double.valueOf(d.doubleValue() * 2.20462d) : d;
    }

    public static Double lbsToKg(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 2.20462d);
        }
        return null;
    }

    public static Double meterToInch(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 39.3701d);
        }
        return null;
    }

    public static Double meterToFoot(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 3.28084d);
        }
        return null;
    }

    public static Double meterToKilometer(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 1000.0d);
        }
        return null;
    }

    public static Double meterToMile(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 1609.344d);
        }
        return null;
    }

    public static Double meterPerSecToMeterPerHour(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 3600.0d);
        }
        return null;
    }

    public static Double meterPerSecToMilePerHour(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 3600.0d) / 1609.344d);
        }
        return null;
    }

    public static Double meterPerSecToKilometerPerHour(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 3600.0d) / 1000.0d);
        }
        return null;
    }

    public static Double meterPerHourToMeterPerSecond(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 3600.0d);
        }
        return null;
    }

    public static Double meterPerHourToMilePerHour(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 1609.344d);
        }
        return null;
    }

    public static Double milePerHourToMeterPerSecond(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1609.344d) / 3600.0d);
        }
        return null;
    }

    public static Double milePerHourToMeterPerHour(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 1609.344d);
        }
        return null;
    }

    public static Double minPerMeterToSecPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 60.0d);
        }
        return null;
    }

    public static Double minPerMeterToMinPerMile(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 1609.344d);
        }
        return null;
    }

    public static Double mileToKilometer(Double d) {
        if (d != null) {
            return meterToKilometer(mileToMeter(d));
        }
        return null;
    }

    public static Double mileToMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 1609.344d);
        }
        return null;
    }

    public static Double minPerMileToSecPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 60.0d) / 1609.344d);
        }
        return null;
    }

    public static Double minPerMileToMinPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 1609.344d);
        }
        return null;
    }

    public static Double minPerKilometerToSecPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 60.0d) / 1000.0d);
        }
        return null;
    }

    public static Double secPerMeterToMinPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 60.0d);
        }
        return null;
    }

    public static Double secPerMeterToMinPerMile(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1609.344d) / 60.0d);
        }
        return null;
    }

    public static Double secPerMeterToMinPerKilometer(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1000.0d) / 60.0d);
        }
        return null;
    }

    public static Double caloriesToJoules(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 4184.0d);
        }
        return null;
    }

    public static Double joulesToCalories(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 2.3900573E-4d);
        }
        return null;
    }

    public static Double secondsPerMeterToMinPerMile(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1000.0d) / 37.28226d);
        }
        return null;
    }
}
