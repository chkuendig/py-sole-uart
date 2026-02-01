package com.samsung.android.sdk.healthdata;

import com.android.SdkConstants;
import java.util.HashMap;
import java.util.UnknownFormatConversionException;

/* loaded from: classes5.dex */
public abstract class HealthDataUnit {
    public static final HealthDataUnit CELSIUS;
    public static final HealthDataUnit CENTIMETER;
    public static final HealthDataUnit FAHRENHEIT;
    public static final HealthDataUnit FLUID_OUNCE;
    public static final HealthDataUnit FOOT;
    public static final HealthDataUnit GRAM;
    public static final HealthDataUnit GRAMS_PER_DECILITER;
    public static final HealthDataUnit HBA1C_PERCENT;
    public static final HealthDataUnit INCH;
    public static final HealthDataUnit KELVIN;
    public static final HealthDataUnit KILOGRAM;
    public static final HealthDataUnit KILOMETER;
    public static final HealthDataUnit KILOPASCAL;
    public static final HealthDataUnit LITER;
    public static final HealthDataUnit METER;
    public static final HealthDataUnit MICROMOLES_PER_LITER;
    public static final HealthDataUnit MILE;
    public static final HealthDataUnit MILLIGRAMS_PER_DECILITER;
    public static final HealthDataUnit MILLILITER;
    public static final HealthDataUnit MILLIMETER;
    public static final HealthDataUnit MILLIMETER_OF_MERCURY;
    public static final HealthDataUnit MILLIMOLES_PER_LITER;
    public static final HealthDataUnit MILLIMOLES_PER_MOLE;
    public static final HealthDataUnit POUND;
    public static final HealthDataUnit RANKINE;
    public static final HealthDataUnit YARD;
    private static final HashMap<String, HealthDataUnit> a;
    protected String mUnit;
    protected int mUnitType;

    private static class a0 extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("cm")) {
                return (d / 1.09361329338d) * 100.0d;
            }
            if (str.equalsIgnoreCase("ft")) {
                return d / 0.3333333d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_IN)) {
                return d * 36.0d;
            }
            if (str.equalsIgnoreCase("m")) {
                return d / 1.09361329338d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_MM)) {
                return (d / 1.09361329338d) * 1000.0d;
            }
            if (str.equalsIgnoreCase("mi")) {
                return d / 1760.0d;
            }
            if (str.equalsIgnoreCase("km")) {
                return (d / 1.09361329338d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("yd")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private a0() {
            this.mUnit = "yd";
            this.mUnitType = 1;
        }
    }

    private static class b extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("C")) {
                return d;
            }
            if (str.equalsIgnoreCase("F")) {
                return ((d * 9.0d) / 5.0d) + 32.0d;
            }
            if (str.equalsIgnoreCase("K")) {
                return d + 273.15d;
            }
            if (str.equalsIgnoreCase("R")) {
                return ((d + 273.15d) * 9.0d) / 5.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private b() {
            this.mUnit = "C";
            this.mUnitType = 3;
        }
    }

    private static class c extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("cm")) {
                return d;
            }
            if (str.equalsIgnoreCase("ft")) {
                return (d * 3.280839895013d) / 100.0d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_IN)) {
                return (d * 39.37007874016d) / 100.0d;
            }
            if (str.equalsIgnoreCase("m")) {
                return d / 100.0d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_MM)) {
                return d * 10.0d;
            }
            if (str.equalsIgnoreCase("mi")) {
                return (d * 6.21371192E-4d) / 100.0d;
            }
            if (str.equalsIgnoreCase("km")) {
                return d / 100000.0d;
            }
            if (str.equalsIgnoreCase("yd")) {
                return (d * 1.09361329338d) / 100.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private c() {
            this.mUnit = "cm";
            this.mUnitType = 1;
        }
    }

    private static class d extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            double d2;
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("C")) {
                d2 = d - 32.0d;
            } else {
                if (str.equalsIgnoreCase("F")) {
                    return d;
                }
                if (!str.equalsIgnoreCase("K")) {
                    if (str.equalsIgnoreCase("R")) {
                        return d + 459.67d;
                    }
                    throw new UnknownFormatConversionException("No conversion is defined");
                }
                d2 = d + 459.67d;
            }
            return (d2 * 5.0d) / 9.0d;
        }

        private d() {
            this.mUnit = "F";
            this.mUnitType = 3;
        }
    }

    private static class e extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("L")) {
                return (d / 0.033814022701843d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("mL")) {
                return d / 0.033814022701843d;
            }
            if (str.equalsIgnoreCase("fl. oz.")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private e() {
            this.mUnit = "fl. oz.";
            this.mUnitType = 7;
        }
    }

    private static class f extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("cm")) {
                return (d / 3.280839895013d) * 100.0d;
            }
            if (str.equalsIgnoreCase("ft")) {
                return d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_IN)) {
                return d * 12.0d;
            }
            if (str.equalsIgnoreCase("m")) {
                return d / 3.280839895013d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_MM)) {
                return (d / 3.280839895013d) * 1000.0d;
            }
            if (str.equalsIgnoreCase("mi")) {
                return d * 1.893939E-4d;
            }
            if (str.equalsIgnoreCase("km")) {
                return (d / 3.280839895013d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("yd")) {
                return d * 0.3333333d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private f() {
            this.mUnit = "ft";
            this.mUnitType = 1;
        }
    }

    private static class g extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("g")) {
                return d;
            }
            if (str.equalsIgnoreCase("kg")) {
                return d / 1000.0d;
            }
            if (str.equalsIgnoreCase("lb")) {
                return (d * 2.2046215d) / 1000.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private g() {
            this.mUnit = "g";
            this.mUnitType = 2;
        }
    }

    private static class h extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("mmol/L")) {
                return (d / 18.015588d) * 1000.0d;
            }
            if (str.equalsIgnoreCase("umol/L")) {
                return (d / 18.015588d) * 1000000.0d;
            }
            if (str.equalsIgnoreCase("g/dL")) {
                return d;
            }
            if (str.equalsIgnoreCase("mg/dL")) {
                return d * 1000.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private h() {
            this.mUnit = "g/dL";
            this.mUnitType = 4;
        }
    }

    private static class i extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("mmol/mol")) {
                return (d * 10.93d) - 23.5d;
            }
            if (str.equalsIgnoreCase("%")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private i() {
            this.mUnit = "%";
            this.mUnitType = 5;
        }
    }

    private static class j extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("cm")) {
                return (d / 39.37007874016d) * 100.0d;
            }
            if (str.equalsIgnoreCase("ft")) {
                return d / 12.0d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_IN)) {
                return d;
            }
            if (str.equalsIgnoreCase("m")) {
                return d / 39.37007874016d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_MM)) {
                return (d / 39.37007874016d) * 1000.0d;
            }
            if (str.equalsIgnoreCase("mi")) {
                return d / 63360.0d;
            }
            if (str.equalsIgnoreCase("km")) {
                return (d / 39.37007874016d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("yd")) {
                return d / 36.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private j() {
            this.mUnit = SdkConstants.UNIT_IN;
            this.mUnitType = 1;
        }
    }

    private static class k extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("C")) {
                return d - 273.15d;
            }
            if (str.equalsIgnoreCase("F")) {
                return ((d * 9.0d) / 5.0d) - 459.67d;
            }
            if (str.equalsIgnoreCase("K")) {
                return d;
            }
            if (str.equalsIgnoreCase("R")) {
                return d * 1.8d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private k() {
            this.mUnit = "K";
            this.mUnitType = 3;
        }
    }

    private static class l extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("g")) {
                return d * 1000.0d;
            }
            if (str.equalsIgnoreCase("kg")) {
                return d;
            }
            if (str.equalsIgnoreCase("lb")) {
                return d / 0.45359237d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private l() {
            this.mUnit = "kg";
            this.mUnitType = 2;
        }
    }

    private static class m extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("cm")) {
                return d * 100000.0d;
            }
            if (str.equalsIgnoreCase("ft")) {
                return d * 3.280839895013d * 1000.0d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_IN)) {
                return d * 39.37007874016d * 1000.0d;
            }
            if (str.equalsIgnoreCase("m")) {
                return d * 1000.0d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_MM)) {
                return d * 1000000.0d;
            }
            if (str.equalsIgnoreCase("mi")) {
                return d * 6.21371192E-4d * 1000.0d;
            }
            if (str.equalsIgnoreCase("km")) {
                return d;
            }
            if (str.equalsIgnoreCase("yd")) {
                return d * 1.09361329338d * 1000.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private m() {
            this.mUnit = "km";
            this.mUnitType = 1;
        }
    }

    private static class n extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("mmHg")) {
                return d * 7.5006d;
            }
            if (str.equalsIgnoreCase("kPa")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private n() {
            this.mUnit = "kPa";
            this.mUnitType = 6;
        }
    }

    private static class o extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("L")) {
                return d;
            }
            if (str.equalsIgnoreCase("mL")) {
                return d * 1000.0d;
            }
            if (str.equalsIgnoreCase("fl. oz.")) {
                return d * 0.033814022701843d * 1000.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private o() {
            this.mUnit = "L";
            this.mUnitType = 7;
        }
    }

    private static class p extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            double d2;
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("cm")) {
                d2 = 100.0d;
            } else if (str.equalsIgnoreCase("ft")) {
                d2 = 3.280839895013d;
            } else if (str.equalsIgnoreCase(SdkConstants.UNIT_IN)) {
                d2 = 39.37007874016d;
            } else {
                if (str.equalsIgnoreCase("m")) {
                    return d;
                }
                if (str.equalsIgnoreCase(SdkConstants.UNIT_MM)) {
                    return d * 1000.0d;
                }
                if (str.equalsIgnoreCase("mi")) {
                    d2 = 6.21371192E-4d;
                } else {
                    if (str.equalsIgnoreCase("km")) {
                        return d / 1000.0d;
                    }
                    if (!str.equalsIgnoreCase("yd")) {
                        throw new UnknownFormatConversionException("No conversion is defined");
                    }
                    d2 = 1.09361329338d;
                }
            }
            return d * d2;
        }

        private p() {
            this.mUnit = "m";
            this.mUnitType = 1;
        }
    }

    private static class q extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("mg/dL")) {
                return (d * 18.015588d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("g/dL")) {
                return (d * 18.015588d) / 1000000.0d;
            }
            if (str.equalsIgnoreCase("mmol/L")) {
                return d / 1000.0d;
            }
            if (str.equalsIgnoreCase("umol/L")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private q() {
            this.mUnit = "umol/L";
            this.mUnitType = 4;
        }
    }

    private static class r extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("cm")) {
                return (d / 6.21371192E-4d) * 100.0d;
            }
            if (str.equalsIgnoreCase("ft")) {
                return d / 1.893939E-4d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_IN)) {
                return d * 63360.0d;
            }
            if (str.equalsIgnoreCase("m")) {
                return d / 6.21371192E-4d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_MM)) {
                return (d / 6.21371192E-4d) * 1000.0d;
            }
            if (str.equalsIgnoreCase("mi")) {
                return d;
            }
            if (str.equalsIgnoreCase("km")) {
                return (d / 6.21371192E-4d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("yd")) {
                return d * 1760.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private r() {
            this.mUnit = "mi";
            this.mUnitType = 1;
        }
    }

    private static class s extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("mmol/L")) {
                return d / 18.015588d;
            }
            if (str.equalsIgnoreCase("umol/L")) {
                return (d / 18.015588d) * 1000.0d;
            }
            if (str.equalsIgnoreCase("g/dL")) {
                return d / 1000.0d;
            }
            if (str.equalsIgnoreCase("mg/dL")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private s() {
            this.mUnit = "mg/dL";
            this.mUnitType = 4;
        }
    }

    private static class t extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("kPa")) {
                return d / 7.5006d;
            }
            if (str.equalsIgnoreCase("mmHg")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private t() {
            this.mUnit = "mmHg";
            this.mUnitType = 6;
        }
    }

    private static class u extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("L")) {
                return d / 1000.0d;
            }
            if (str.equalsIgnoreCase("mL")) {
                return d;
            }
            if (str.equalsIgnoreCase("fl. oz.")) {
                return d * 0.033814022701843d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private u() {
            this.mUnit = "mL";
            this.mUnitType = 7;
        }
    }

    private static class v extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("cm")) {
                return d / 10.0d;
            }
            if (str.equalsIgnoreCase("ft")) {
                return (d * 3.280839895013d) / 1000.0d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_IN)) {
                return (d * 39.37007874016d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("m")) {
                return d / 1000.0d;
            }
            if (str.equalsIgnoreCase(SdkConstants.UNIT_MM)) {
                return d;
            }
            if (str.equalsIgnoreCase("mi")) {
                return (d * 6.21371192E-4d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("km")) {
                return d / 1000000.0d;
            }
            if (str.equalsIgnoreCase("yd")) {
                return (d * 1.09361329338d) / 1000.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private v() {
            this.mUnit = SdkConstants.UNIT_MM;
            this.mUnitType = 1;
        }
    }

    private static class w extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("mg/dL")) {
                return d * 18.015588d;
            }
            if (str.equalsIgnoreCase("g/dL")) {
                return (d * 18.015588d) / 1000.0d;
            }
            if (str.equalsIgnoreCase("mmol/L")) {
                return d;
            }
            if (str.equalsIgnoreCase("umol/L")) {
                return d * 1000.0d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private w() {
            this.mUnit = "mmol/L";
            this.mUnitType = 4;
        }
    }

    private static class x extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("%")) {
                return (d + 23.5d) / 10.93d;
            }
            if (str.equalsIgnoreCase("mmol/mol")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private x() {
            this.mUnit = "mmol/mol";
            this.mUnitType = 5;
        }
    }

    private static class y extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("g")) {
                return d * 1000.0d * 0.45359237d;
            }
            if (str.equalsIgnoreCase("kg")) {
                return d * 0.45359237d;
            }
            if (str.equalsIgnoreCase("lb")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private y() {
            this.mUnit = "lb";
            this.mUnitType = 2;
        }
    }

    private static class z extends HealthDataUnit {
        @Override // com.samsung.android.sdk.healthdata.HealthDataUnit
        public double convertTo(double d, HealthDataUnit healthDataUnit) {
            String str = healthDataUnit.mUnit;
            if (str.equalsIgnoreCase("C")) {
                return ((d - 491.67d) * 5.0d) / 9.0d;
            }
            if (str.equalsIgnoreCase("F")) {
                return d - 459.67d;
            }
            if (str.equalsIgnoreCase("K")) {
                return (d * 5.0d) / 9.0d;
            }
            if (str.equalsIgnoreCase("R")) {
                return d;
            }
            throw new UnknownFormatConversionException("No conversion is defined");
        }

        private z() {
            this.mUnit = "R";
            this.mUnitType = 3;
        }
    }

    static {
        HashMap<String, HealthDataUnit> map = new HashMap<>();
        a = map;
        b bVar = new b();
        CELSIUS = bVar;
        c cVar = new c();
        CENTIMETER = cVar;
        g gVar = new g();
        GRAM = gVar;
        k kVar = new k();
        KELVIN = kVar;
        l lVar = new l();
        KILOGRAM = lVar;
        m mVar = new m();
        KILOMETER = mVar;
        p pVar = new p();
        METER = pVar;
        v vVar = new v();
        MILLIMETER = vVar;
        d dVar = new d();
        FAHRENHEIT = dVar;
        f fVar = new f();
        FOOT = fVar;
        j jVar = new j();
        INCH = jVar;
        r rVar = new r();
        MILE = rVar;
        y yVar = new y();
        POUND = yVar;
        z zVar = new z();
        RANKINE = zVar;
        a0 a0Var = new a0();
        YARD = a0Var;
        h hVar = new h();
        GRAMS_PER_DECILITER = hVar;
        s sVar = new s();
        MILLIGRAMS_PER_DECILITER = sVar;
        w wVar = new w();
        MILLIMOLES_PER_LITER = wVar;
        q qVar = new q();
        MICROMOLES_PER_LITER = qVar;
        x xVar = new x();
        MILLIMOLES_PER_MOLE = xVar;
        i iVar = new i();
        HBA1C_PERCENT = iVar;
        t tVar = new t();
        MILLIMETER_OF_MERCURY = tVar;
        n nVar = new n();
        KILOPASCAL = nVar;
        o oVar = new o();
        LITER = oVar;
        u uVar = new u();
        MILLILITER = uVar;
        e eVar = new e();
        FLUID_OUNCE = eVar;
        map.put(bVar.getUnitName(), bVar);
        map.put(cVar.getUnitName(), cVar);
        map.put(gVar.getUnitName(), gVar);
        map.put(kVar.getUnitName(), kVar);
        map.put(lVar.getUnitName(), lVar);
        map.put(mVar.getUnitName(), mVar);
        map.put(pVar.getUnitName(), pVar);
        map.put(vVar.getUnitName(), vVar);
        map.put(dVar.getUnitName(), dVar);
        map.put(fVar.getUnitName(), fVar);
        map.put(jVar.getUnitName(), jVar);
        map.put(rVar.getUnitName(), rVar);
        map.put(yVar.getUnitName(), yVar);
        map.put(zVar.getUnitName(), zVar);
        map.put(a0Var.getUnitName(), a0Var);
        map.put(hVar.getUnitName(), hVar);
        map.put(sVar.getUnitName(), sVar);
        map.put(qVar.getUnitName(), qVar);
        map.put(wVar.getUnitName(), wVar);
        map.put(xVar.getUnitName(), xVar);
        map.put(iVar.getUnitName(), iVar);
        map.put(tVar.getUnitName(), tVar);
        map.put(nVar.getUnitName(), nVar);
        map.put(oVar.getUnitName(), oVar);
        map.put(uVar.getUnitName(), uVar);
        map.put(eVar.getUnitName(), eVar);
    }

    protected HealthDataUnit() {
    }

    public static double convert(double d2, String str, String str2) {
        return valueOf(str).convertTo(d2, str2);
    }

    public static void registerDataUnit(HealthDataUnit healthDataUnit) {
        if (healthDataUnit == null) {
            throw new IllegalArgumentException("improper unit conversion object");
        }
        String str = healthDataUnit.mUnit;
        HashMap<String, HealthDataUnit> map = a;
        if (map.containsKey(str)) {
            throw new IllegalArgumentException("unit " + str + " already registered");
        }
        map.put(str, healthDataUnit);
    }

    public static HealthDataUnit valueOf(String str) {
        HealthDataUnit healthDataUnit = a.get(str);
        if (healthDataUnit != null) {
            return healthDataUnit;
        }
        throw new UnknownFormatConversionException("No unit conversion allowed for " + str);
    }

    public double convertTo(double d2, HealthDataUnit healthDataUnit) {
        throw new UnknownFormatConversionException("No conversion is defined");
    }

    public String getUnitName() {
        return this.mUnit;
    }

    public boolean isCompatible(HealthDataUnit healthDataUnit) {
        if (healthDataUnit != null) {
            return this.mUnitType == healthDataUnit.mUnitType;
        }
        throw new IllegalArgumentException("improper unit object");
    }

    public boolean matchUnitName(String str) {
        return this.mUnit.equals(str);
    }

    public final double convertTo(double d2, String str) {
        return convertTo(d2, valueOf(str));
    }

    public static boolean isCompatible(String str, String str2) {
        try {
            return valueOf(str).isCompatible(valueOf(str2));
        } catch (UnknownFormatConversionException unused) {
            return false;
        }
    }
}
