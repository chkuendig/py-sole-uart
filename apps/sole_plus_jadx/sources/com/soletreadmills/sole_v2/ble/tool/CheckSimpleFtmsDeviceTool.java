package com.soletreadmills.sole_v2.ble.tool;

import com.soletreadmills.sole_v2.ble.SimpleFtmsDeviceName;

/* loaded from: classes5.dex */
public class CheckSimpleFtmsDeviceTool {
    public static boolean isSimpleFtmsDevice(String bleName) {
        return isTreadmill(bleName) || isBike(bleName) || isElliptical(bleName);
    }

    public static boolean isTreadmill(String bleName) {
        return isTreadmillSole(bleName) || isTreadmillXterra(bleName) || isTreadmillSpirit(bleName);
    }

    public static boolean isTreadmillSole(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SOLE_F63) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SOLE_F65) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SOLE_F80) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SOLE_F85) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SOLE_S77) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SOLE_TT8));
    }

    public static boolean isTreadmillXterra(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_TRX1000) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_TRX2500) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_TRX3500) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_TRX4500) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_TRX75) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_XT78) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_XT800_HRC) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_XT900_HRC) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_XTERRA_3000) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_XT96) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_XTERRA_XT98));
    }

    public static boolean isTreadmillSpirit(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_CT800) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_CT850) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_CT800ENT) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_CT850ENT) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_XT185) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_XT285) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_XT385) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_XT485) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.TREADMILL_SPIRIT_XT685));
    }

    public static boolean isElliptical(String bleName) {
        return isEllipticalSoleEjek(bleName) || isEllipticalSpiritEjek(bleName) || isEllipticalSoleCorestar(bleName) || isEllipticalSpiritCorestar(bleName);
    }

    public static boolean isEllipticalSoleEjek(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SOLE_EJEK_E55) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SOLE_EJEK_E95) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SOLE_EJEK_E95S) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SOLE_EJEK_E98));
    }

    public static boolean isEllipticalSpiritEjek(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_EJEK_CE800ENT) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_EJEK_XS895));
    }

    public static boolean isEllipticalSoleCorestar(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SOLE_CORESTAR_E25) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SOLE_CORESTAR_E35));
    }

    public static boolean isEllipticalSpiritCorestar(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_CE800) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_CE850) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_XE195) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_XE295) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_XE395) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_XE895) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_XG400) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_CS800));
    }

    public static boolean isBike(String bleName) {
        return isBikeSoleEjek(bleName) || isBikeSpiritEjek(bleName) || isBikeSoleCorestar(bleName) || isBikeSpiritCorestar(bleName) || isBikeXterraCorestar(bleName) || isBikeDirection(bleName);
    }

    public static boolean isBikeSoleEjek(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SOLE_EJEK_LCB) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SOLE_EJEK_LCR));
    }

    public static boolean isBikeSpiritEjek(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_EJEK_CR800ENT) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_EJEK_CU800ENT));
    }

    public static boolean isBikeSoleCorestar(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SOLE_CORESTAR_R92) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SOLE_CORESTAR_B94));
    }

    public static boolean isBikeSpiritCorestar(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_CORESTAR_CR800) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_CORESTAR_CU800) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_CORESTAR_XBR25) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_CORESTAR_XBR55) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_CORESTAR_XBU55) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_CORESTAR_XBR55ENT) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_CORESTAR_XBU55ENT) || bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_SPIRIT_CORESTAR_CRS800S));
    }

    public static boolean isBikeXterraCorestar(String bleName) {
        return bleName != null && bleName.toUpperCase().contains(SimpleFtmsDeviceName.BIKE_XTERRA_CORESTAR_SB4500);
    }

    public static boolean isBikeDirection(String bleName) {
        return bleName != null && (bleName.toUpperCase().contains("DT-3268") || bleName.toUpperCase().contains("DT-3268"));
    }
}
