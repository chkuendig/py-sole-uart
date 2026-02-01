package com.ua.sdk.util;

/* loaded from: classes2.dex */
public final class Convert {
    public static final long HOURS_IN_DAY = 24;
    public static final double INCH_IN_METER = 39.3701d;
    public static final double LBS_IN_KG = 2.20462d;
    public static final double METER_IN_KILOMETER = 1000.0d;
    public static final double METER_IN_MILE = 1609.344d;
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

    public static final Double inchToMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 39.3701d);
        }
        return null;
    }

    public static final Double kilometerPerHourToMeterPerSec(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1000.0d) / 3600.0d);
        }
        return null;
    }

    public static final Double kilometerToMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 1000.0d);
        }
        return null;
    }

    public static final Double kilometerToMile(Double d) {
        if (d != null) {
            return meterToMile(kilometerToMeter(d));
        }
        return null;
    }

    public static final Double kgToLbs(Double d) {
        return d != null ? Double.valueOf(d.doubleValue() * 2.20462d) : d;
    }

    public static final Double lbsToKg(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 2.20462d);
        }
        return null;
    }

    public static final Double meterToInch(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 39.3701d);
        }
        return null;
    }

    public static final Double meterToKilometer(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 1000.0d);
        }
        return null;
    }

    public static final Double meterToMile(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 1609.344d);
        }
        return null;
    }

    public static final Double meterPerSecToMeterPerHour(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 3600.0d);
        }
        return null;
    }

    public static final Double meterPerSecToMilePerHour(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 3600.0d) / 1609.344d);
        }
        return null;
    }

    public static final Double meterPerSecToKilometerPerHour(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 3600.0d) / 1000.0d);
        }
        return null;
    }

    public static final Double meterPerHourToMeterPerSecond(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 3600.0d);
        }
        return null;
    }

    public static final Double meterPerHourToMilePerHour(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 1609.344d);
        }
        return null;
    }

    public static final Double milePerHourToMeterPerSecond(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1609.344d) / 3600.0d);
        }
        return null;
    }

    public static final Double milePerHourToMeterPerHour(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 1609.344d);
        }
        return null;
    }

    public static final Double minPerMeterToSecPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 60.0d);
        }
        return null;
    }

    public static final Double minPerMeterToMinPerMile(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 1609.344d);
        }
        return null;
    }

    public static final Double mileToKilometer(Double d) {
        if (d != null) {
            return meterToKilometer(mileToMeter(d));
        }
        return null;
    }

    public static final Double mileToMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() * 1609.344d);
        }
        return null;
    }

    public static final Double minPerMileToSecPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 60.0d) / 1609.344d);
        }
        return null;
    }

    public static final Double minPerMileToMinPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 1609.344d);
        }
        return null;
    }

    public static final Double minPerKilometerToSecPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 60.0d) / 1000.0d);
        }
        return null;
    }

    public static final Double secPerMeterToMinPerMeter(Double d) {
        if (d != null) {
            return Double.valueOf(d.doubleValue() / 60.0d);
        }
        return null;
    }

    public static final Double secPerMeterToMinPerMile(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1609.344d) / 60.0d);
        }
        return null;
    }

    public static final Double secPerMeterToMinPerKilometer(Double d) {
        if (d != null) {
            return Double.valueOf((d.doubleValue() * 1000.0d) / 60.0d);
        }
        return null;
    }
}
