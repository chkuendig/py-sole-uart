package com.dyaco.sole.custom;

import android.util.Log;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class Spirit_DeviceModelList {
    public static final String[] DEVICE_NAME_LIST = {"XBR25", "XBR55", "XBU55", "XE195", "XE295", "XG400", "XE395", "XE895", "", "", "XS895", "JE002", "CDAB900", "CRW_900", "CVC800", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "CE800", "CR800", "CU800", "CE850", "CS800", "CRS800S", "", "", "", "", "", "", "", "IF700", "IF300", "RG500", "CE800ENT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "XT385", "XT285", "XT185", "XT485", "XT685", "XT385", "", "MT100T", "CT800", "CT800ENT", "CT850", "", "", "", "", "", "", "", "", "", "", ""};
    public static final int MODEL_CDAB900 = 12;
    public static final int MODEL_CE800 = 83;
    public static final int MODEL_CE800ENT = 99;
    public static final int MODEL_CE850 = 86;
    public static final int MODEL_CR800 = 84;
    public static final int MODEL_CRS800S = 88;
    public static final int MODEL_CRW_900 = 13;
    public static final int MODEL_CS800 = 87;
    public static final int MODEL_CT800 = 136;
    public static final int MODEL_CT800ENT = 137;
    public static final int MODEL_CT850 = 138;
    public static final int MODEL_CU800 = 85;
    public static final int MODEL_CVC800 = 14;
    public static final int MODEL_IF300 = 97;
    public static final int MODEL_IF700 = 96;
    public static final int MODEL_JE002 = 11;
    public static final int MODEL_MAX_18 = 18;
    public static final int MODEL_MT100T = 135;
    public static final int MODEL_RG500 = 98;
    public static final int MODEL_XBR25 = 0;
    public static final int MODEL_XBR55 = 1;
    public static final int MODEL_XBU55 = 2;
    public static final int MODEL_XE195 = 3;
    public static final int MODEL_XE295 = 4;
    public static final int MODEL_XE395 = 6;
    public static final int MODEL_XE895 = 7;
    public static final int MODEL_XG400 = 5;
    public static final int MODEL_XS895 = 10;
    public static final int MODEL_XT185 = 130;
    public static final int MODEL_XT285 = 129;
    public static final int MODEL_XT385 = 128;
    public static final int MODEL_XT385_TREADMILL = 133;
    public static final int MODEL_XT485 = 131;
    public static final int MODEL_XT685 = 132;

    /* JADX WARN: Removed duplicated region for block: B:26:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x04f3 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void handleDeviceModel() {
        if (ProtocolHandler.protocol == null) {
            return;
        }
        int i = ProtocolHandler.protocol.deviceType;
        if (i == 0) {
            DeviceModelList.MANUAL = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            DeviceModelList.HILL = new int[]{4, 5, 5, 6, 6, 6, 7, 6, 7, 7, 8, 6, 7, 6, 7, 7, 6, 5, 5, 4};
            DeviceModelList.FAT_BURN = new int[]{4, 5, 5, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 6, 5, 4};
            DeviceModelList.CARDIO = new int[]{4, 5, 5, 6, 6, 7, 6, 6, 7, 5, 6, 7, 6, 6, 8, 6, 7, 5, 5, 4};
            DeviceModelList.STRENGTH = new int[]{5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 7, 7, 7, 6, 6, 6, 5, 5, 5};
            DeviceModelList.INTERVAL = new int[]{4, 5, 5, 6, 7, 5, 5, 7, 5, 6, 8, 5, 6, 8, 5, 6, 7, 5, 5, 4};
            DeviceModelList.HEART_RATE = new int[0];
            DeviceModelList.CALORIES = new int[]{1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 2, 1};
            DeviceModelList.FUSION = new int[]{1, 2, 3, 6, 1, 1, 6, 1, 1, 6, 1, 1, 6, 1, 1, 6, 1, 1, 1, 1};
            DeviceModelList.USER = DeviceModelList.MANUAL;
            DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, 0, R.string.display_program_name, R.string.display_calories, R.string.display_watts};
        } else if (i == 1) {
            DeviceModelList.MANUAL = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            DeviceModelList.HILL = new int[]{1, 2, 3, 3, 5, 5, 5, 7, 7, 9, 9, 7, 7, 5, 5, 5, 3, 3, 2, 1};
            DeviceModelList.FAT_BURN = new int[]{1, 2, 4, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 4, 2, 1};
            DeviceModelList.CARDIO = new int[]{1, 2, 5, 6, 8, 9, 8, 6, 6, 8, 9, 8, 6, 8, 9, 8, 6, 5, 2, 1};
            DeviceModelList.STRENGTH = new int[]{1, 2, 4, 5, 5, 7, 7, 7, 9, 9, 9, 9, 9, 9, 9, 9, 8, 6, 2, 1};
            DeviceModelList.INTERVAL = new int[]{1, 2, 4, 9, 9, 4, 4, 9, 9, 4, 4, 9, 9, 4, 4, 9, 9, 4, 2, 1};
            DeviceModelList.HEART_RATE = new int[0];
            DeviceModelList.USER = DeviceModelList.MANUAL;
            DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, 0, R.string.display_program_name, R.string.display_calories, R.string.display_watts};
        } else if (i == 2) {
            DeviceModelList.MANUAL = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            if (ProtocolHandler.protocol.deviceModel == 11) {
                DeviceModelList.HILL = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 7, 7, 5, 5, 4, 4, 3, 3, 3, 2, 1};
                DeviceModelList.FAT_BURN = new int[]{1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 2, 1};
                DeviceModelList.CARDIO = new int[]{1, 2, 3, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 5, 2, 1};
                DeviceModelList.STRENGTH = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 8, 8, 8, 6, 4, 1};
                DeviceModelList.INTERVAL = new int[]{1, 2, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 2, 1};
            } else {
                DeviceModelList.HILL = new int[]{1, 2, 3, 3, 5, 5, 5, 7, 7, 9, 9, 7, 7, 5, 5, 5, 3, 3, 2, 1};
                DeviceModelList.FAT_BURN = new int[]{1, 2, 4, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 4, 2, 1};
                DeviceModelList.CARDIO = new int[]{1, 2, 5, 6, 8, 9, 8, 6, 6, 8, 9, 8, 6, 8, 9, 8, 6, 5, 2, 1};
                DeviceModelList.STRENGTH = new int[]{1, 2, 4, 5, 5, 7, 7, 7, 9, 9, 9, 9, 9, 9, 9, 9, 8, 6, 2, 1};
                DeviceModelList.INTERVAL = new int[]{1, 2, 4, 9, 9, 4, 4, 9, 9, 4, 4, 9, 9, 4, 4, 9, 9, 4, 2, 1};
            }
            DeviceModelList.HEART_RATE = new int[0];
            DeviceModelList.USER = DeviceModelList.MANUAL;
            DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, R.string.display_program_name, R.string.display_calories, R.string.display_watts, R.string.display_rpm};
        }
        Log.e("checkXT385", ProtocolHandler.protocol.deviceModel + " | ");
        int i2 = ProtocolHandler.protocol.deviceModel;
        if (i2 != 135) {
            switch (i2) {
                case 0:
                case 3:
                    DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.cardio, R.string.hill, R.string.fat_burn, R.string.interval, R.string.hr1}, new int[0]};
                    DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s}, new int[0]};
                    DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_hr1};
                    DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s};
                    DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.CARDIO, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.INTERVAL, DeviceModelList.HEART_RATE};
                    DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.target_hr}};
                    DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.cardio, R.string.hill, R.string.fat_burn, R.string.interval, R.string.hr1};
                    DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1};
                    DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.cardio_info, R.string.hill_info, R.string.fat_burn_info, R.string.interval_info, R.string.hr1_info};
                    DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.cardio, R.string.hill, R.string.fat_burn, R.string.interval, R.string.hr1};
                    break;
                case 1:
                case 2:
                case 4:
                case 5:
                    DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength}, new int[]{R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2}};
                    DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s}, new int[]{R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s}};
                    DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_strength, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_hr1, R.drawable.s_program_icon_hr2, R.drawable.s_program_icon_user, R.drawable.s_program_icon_user};
                    DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s};
                    DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE, DeviceModelList.USER, DeviceModelList.USER};
                    DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time}, new int[]{R.string.time}};
                    DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
                    DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                    DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.hr1_info, R.string.hr2_info, R.string.user_info, R.string.user_info};
                    DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
                    break;
                case 6:
                case 7:
                    DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength}, new int[]{R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2}};
                    DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s}, new int[]{R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s}};
                    DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_strength, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_user, R.drawable.s_program_icon_user, R.drawable.s_program_icon_hr1, R.drawable.s_program_icon_hr2};
                    DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s};
                    DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.USER, DeviceModelList.USER, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE};
                    if (ProtocolHandler.protocol.deviceModel == 11) {
                        DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}};
                    } else {
                        DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}};
                    }
                    DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                    DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                    DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.user_info, R.string.user_info, R.string.hr1_info, R.string.hr2_info};
                    DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                    break;
                default:
                    switch (i2) {
                        case 10:
                        case 11:
                            break;
                        default:
                            switch (i2) {
                                case 96:
                                case 97:
                                case 98:
                                    break;
                                default:
                                    switch (i2) {
                                        case 130:
                                            DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval}, new int[0]};
                                            DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s}, new int[0]};
                                            DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_strength, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_hr1, R.drawable.s_program_icon_hr2, R.drawable.s_program_icon_user, R.drawable.s_program_icon_user};
                                            DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s};
                                            DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL};
                                            DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}};
                                            DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval};
                                            DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval};
                                            DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info};
                                            DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval};
                                            break;
                                        case 131:
                                        case 132:
                                            DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval}, new int[]{R.string.calorie, R.string.fusion, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2}};
                                            DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s}, new int[]{R.drawable.s_program_icon_calorie_s, R.drawable.s_program_icon_fusion_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s}};
                                            DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_strength, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_calorie, R.drawable.s_program_icon_fusion, R.drawable.s_program_icon_user, R.drawable.s_program_icon_user, R.drawable.s_program_icon_hr1, R.drawable.s_program_icon_hr2};
                                            DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_calorie_s, R.drawable.s_program_icon_fusion_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s};
                                            DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.CALORIES, DeviceModelList.FUSION, DeviceModelList.USER, DeviceModelList.USER, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE};
                                            DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_calories}, new int[]{R.string.time, R.string.fusion_interval, R.string.fusion_recover}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}};
                                            DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.calorie, R.string.fusion, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                                            DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                                            DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.calorie_info, R.string.fusion_info, R.string.user_info, R.string.user_info, R.string.hr1_info, R.string.hr2_info};
                                            DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.calorie_upper, R.string.fusion_upper, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                                            break;
                                    }
                            }
                        case 12:
                        case 13:
                            break;
                    }
            }
            return;
        }
        DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength}, new int[]{R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2}};
        DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s}, new int[]{R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s}};
        DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_strength, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_hr1, R.drawable.s_program_icon_hr2, R.drawable.s_program_icon_user, R.drawable.s_program_icon_user};
        DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s};
        DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE, DeviceModelList.USER, DeviceModelList.USER};
        DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time}, new int[]{R.string.time}};
        DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
        DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2};
        DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.hr1_info, R.string.hr2_info, R.string.user_info, R.string.user_info};
        DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void handleDeviceModelExportUser(int i) {
        if (i != 12 && i != 13) {
            if (i != 135) {
                switch (i) {
                    case 0:
                    case 3:
                        break;
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                        DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
                        DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                        return;
                    case 6:
                    case 7:
                        DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                        DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                        return;
                    default:
                        switch (i) {
                            case 96:
                            case 97:
                            case 98:
                                break;
                            default:
                                switch (i) {
                                    case 130:
                                        DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval};
                                        DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval};
                                        break;
                                    case 131:
                                    case 132:
                                        DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.calorie, R.string.fusion, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                                        DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                                        break;
                                }
                        }
                }
            }
            DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
            DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2};
            return;
        }
        DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.cardio, R.string.hill, R.string.fat_burn, R.string.interval, R.string.hr1};
        DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1};
    }
}
