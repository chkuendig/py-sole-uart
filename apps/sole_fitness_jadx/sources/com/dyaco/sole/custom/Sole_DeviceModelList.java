package com.dyaco.sole.custom;

import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class Sole_DeviceModelList {
    public static final int MODEL_40_MAXLEVEL = 40;
    public static final int MODEL_B74 = 16;
    public static final int MODEL_B94 = 18;
    public static final int MODEL_E25 = 22;
    public static final int MODEL_E35 = 23;
    public static final int MODEL_E55 = 24;
    public static final int MODEL_E95 = 25;
    public static final int MODEL_E95s = 27;
    public static final int MODEL_E96S = 64;
    public static final int MODEL_E98 = 26;
    public static final int MODEL_E98s = 28;
    public static final int MODEL_F63 = 144;
    public static final int MODEL_F65 = 145;
    public static final int MODEL_F80 = 146;
    public static final int MODEL_F85 = 147;
    public static final int MODEL_LCB = 20;
    public static final int MODEL_LCR = 21;
    public static final int MODEL_R72 = 17;
    public static final int MODEL_R92 = 19;
    public static final int MODEL_S77 = 148;
    public static final int MODEL_SC200 = 29;
    public static final int MODEL_SC200_NEW = 30;
    public static final int MODEL_SC300 = 31;
    public static final int MODEL_TT8 = 149;
    public static final String[] DEVICE_NAME_LIST = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "B74", "R72", "B94", "R92", "LCB", "LCR", "E25", "E35", "E55", "E95", "E98", "E95s", "E98s", "SC200", "SC200", "SC300", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "E96S", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "F63", "F65", "F80", "F85", "S77", "TT8"};
    public static float[] stepHeightInArr = {0.0f, 10.2f, 10.4f, 10.6f, 10.8f, 11.0f, 11.2f, 11.4f, 11.6f, 11.8f, 12.0f, 12.2f, 12.4f, 12.6f, 12.8f, 13.0f, 13.2f, 13.4f, 13.6f, 13.8f, 14.0f};
    public static float[] stepHeightCMArr = {0.0f, 26.5f, 27.0f, 27.5f, 28.0f, 28.5f, 29.0f, 29.5f, 30.0f, 30.5f, 31.0f, 31.5f, 32.0f, 32.5f, 33.0f, 33.5f, 34.0f, 34.5f, 35.0f, 35.5f, 36.0f};

    public static void handleDeviceModel() {
        if (ProtocolHandler.protocol == null) {
            return;
        }
        int i = ProtocolHandler.protocol.deviceType;
        if (i == 0) {
            DeviceModelList.MANUAL = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            DeviceModelList.HILL = new int[]{4, 5, 6, 6, 6, 7, 6, 7, 7, 8, 6, 7, 6, 7, 7, 6, 5, 4};
            DeviceModelList.FAT_BURN = new int[]{4, 5, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 6, 5, 4};
            DeviceModelList.CARDIO = new int[]{4, 5, 6, 6, 7, 6, 6, 7, 5, 6, 7, 6, 6, 8, 6, 7, 5, 4};
            DeviceModelList.STRENGTH = new int[]{5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 7, 7, 7, 6, 6, 6, 5, 5};
            DeviceModelList.INTERVAL = new int[]{4, 5, 6, 7, 5, 5, 7, 5, 6, 8, 5, 6, 8, 5, 6, 7, 5, 4};
            DeviceModelList.HEART_RATE = new int[0];
            DeviceModelList.USER = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, 0, R.string.display_program_name, R.string.display_calories, R.string.display_watts};
        } else if (i == 1) {
            DeviceModelList.MANUAL = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            DeviceModelList.HILL = new int[]{1, 2, 3, 3, 4, 4, 5, 5, 7, 7, 5, 5, 4, 4, 3, 3, 2, 1};
            DeviceModelList.FAT_BURN = new int[]{1, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 1};
            DeviceModelList.CARDIO = new int[]{1, 2, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 2, 1};
            DeviceModelList.STRENGTH = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 8, 8, 8, 2, 1};
            DeviceModelList.INTERVAL = new int[]{1, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 1};
            DeviceModelList.HEART_RATE = new int[0];
            DeviceModelList.USER = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, 0, R.string.display_program_name, R.string.display_calories, R.string.display_watts};
        } else if (i == 2) {
            DeviceModelList.MANUAL = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            DeviceModelList.HILL = new int[]{1, 2, 3, 3, 4, 4, 5, 5, 7, 7, 5, 5, 4, 4, 3, 3, 2, 1};
            DeviceModelList.FAT_BURN = new int[]{1, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 1};
            DeviceModelList.CARDIO = new int[]{1, 2, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 7, 6, 5, 6, 2, 1};
            DeviceModelList.STRENGTH = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 8, 8, 8, 2, 1};
            DeviceModelList.INTERVAL = new int[]{1, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 2, 7, 7, 2, 1};
            DeviceModelList.HEART_RATE = new int[0];
            DeviceModelList.USER = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30) {
                DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, R.string.display_program_name, R.string.display_calories};
            } else if (ProtocolHandler.protocol.deviceModel == 31) {
                DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, R.string.display_program_name, R.string.display_calories, R.string.vert_ft_mtr};
            } else {
                DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, R.string.display_program_name, R.string.display_calories, R.string.display_watts, R.string.display_rpm};
            }
        }
        int i2 = ProtocolHandler.protocol.deviceModel;
        if (i2 != 64) {
            switch (i2) {
                case 16:
                case 17:
                    DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio}, new int[]{R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user}};
                    DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.program_icon_manual, R.drawable.program_icon_hill, R.drawable.program_icon_fatburn, R.drawable.program_icon_cardio}, new int[]{R.drawable.program_icon_strength, R.drawable.program_icon_interval, R.drawable.program_icon_hr1, R.drawable.program_icon_hr2, R.drawable.program_icon_user}};
                    DeviceModelList.programUnselectedImages = new int[]{R.drawable.program_icon_manual, R.drawable.program_icon_hill, R.drawable.program_icon_fatburn, R.drawable.program_icon_cardio, R.drawable.program_icon_strength, R.drawable.program_icon_interval, R.drawable.program_icon_hr1, R.drawable.program_icon_hr2, R.drawable.program_icon_user};
                    DeviceModelList.programSelectedImages = new int[]{R.drawable.program_icon_manual_s, R.drawable.program_icon_hill_s, R.drawable.program_icon_fatburn_s, R.drawable.program_icon_cardio_s, R.drawable.program_icon_strength_s, R.drawable.program_icon_interval_s, R.drawable.program_icon_hr1_s, R.drawable.program_icon_hr2_s, R.drawable.program_icon_user_s};
                    DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE, DeviceModelList.USER};
                    DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time}};
                    DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user};
                    DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User};
                    DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.hr1_info, R.string.hr2_info, R.string.user_info};
                    DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user};
                    break;
                case 18:
                case 19:
                case 22:
                case 23:
                case 24:
                case 25:
                case 27:
                case 28:
                    DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.hill, R.string.strength, R.string.fat_burn, R.string.user1, R.string.hr1}, new int[]{R.string.manual, R.string.cardio, R.string.interval, R.string.user2, R.string.hr2}};
                    DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.program_icon_hill, R.drawable.program_icon_strength, R.drawable.program_icon_fatburn, R.drawable.program_icon_user1, R.drawable.program_icon_hr1}, new int[]{R.drawable.program_icon_manual, R.drawable.program_icon_cardio, R.drawable.program_icon_interval, R.drawable.program_icon_user2, R.drawable.program_icon_hr2}};
                    DeviceModelList.programUnselectedImages = new int[]{R.drawable.program_icon_hill, R.drawable.program_icon_manual, R.drawable.program_icon_strength, R.drawable.program_icon_cardio, R.drawable.program_icon_fatburn, R.drawable.program_icon_interval, R.drawable.program_icon_user1, R.drawable.program_icon_user2, R.drawable.program_icon_hr1, R.drawable.program_icon_hr2};
                    DeviceModelList.programSelectedImages = new int[]{R.drawable.program_icon_hill_s, R.drawable.program_icon_manual_s, R.drawable.program_icon_strength_s, R.drawable.program_icon_cardio_s, R.drawable.program_icon_fatburn_s, R.drawable.program_icon_interval_s, R.drawable.program_icon_user1_s, R.drawable.program_icon_user2_s, R.drawable.program_icon_hr1_s, R.drawable.program_icon_hr2_s};
                    DeviceModelList.programPosition = new int[][]{DeviceModelList.HILL, DeviceModelList.MANUAL, DeviceModelList.STRENGTH, DeviceModelList.CARDIO, DeviceModelList.FAT_BURN, DeviceModelList.INTERVAL, DeviceModelList.USER, DeviceModelList.USER, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE};
                    DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time, R.string.level}, new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}};
                    DeviceModelList.programTitleTexts = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                    DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Hill, DeviceModelList.PGName_Manual, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                    DeviceModelList.programInfoTexts = new int[]{R.string.hill_info, R.string.manual_info, R.string.strength_info, R.string.cardio_info, R.string.fat_burn_info, R.string.interval_info, R.string.user_info, R.string.user_info, R.string.hr1_info, R.string.hr2_info};
                    DeviceModelList.programTitleUpperTexts = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                    break;
                case 20:
                case 21:
                case 26:
                    DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.hill, R.string.strength, R.string.fat_burn, R.string.hr1}, new int[]{R.string.manual, R.string.cardio, R.string.interval, R.string.custom, R.string.hr2}};
                    DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.program_icon_hill, R.drawable.program_icon_strength, R.drawable.program_icon_fatburn, R.drawable.program_icon_hr1}, new int[]{R.drawable.program_icon_manual, R.drawable.program_icon_cardio, R.drawable.program_icon_interval, R.drawable.program_icon_custom, R.drawable.program_icon_hr2}};
                    DeviceModelList.programUnselectedImages = new int[]{R.drawable.program_icon_hill, R.drawable.program_icon_manual, R.drawable.program_icon_strength, R.drawable.program_icon_cardio, R.drawable.program_icon_fatburn, R.drawable.program_icon_interval, R.drawable.program_icon_custom, R.drawable.program_icon_hr1, R.drawable.program_icon_hr2};
                    DeviceModelList.programSelectedImages = new int[]{R.drawable.program_icon_hill_s, R.drawable.program_icon_manual_s, R.drawable.program_icon_strength_s, R.drawable.program_icon_cardio_s, R.drawable.program_icon_fatburn_s, R.drawable.program_icon_interval_s, R.drawable.program_icon_custom_s, R.drawable.program_icon_hr1_s, R.drawable.program_icon_hr2_s};
                    DeviceModelList.programPosition = new int[][]{DeviceModelList.HILL, DeviceModelList.MANUAL, DeviceModelList.STRENGTH, DeviceModelList.CARDIO, DeviceModelList.FAT_BURN, DeviceModelList.INTERVAL, DeviceModelList.USER, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE};
                    DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time, R.string.level}, new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}};
                    DeviceModelList.programTitleTexts = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.custom, R.string.hr1, R.string.hr2};
                    DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Hill, DeviceModelList.PGName_Manual, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_Custom, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                    DeviceModelList.programInfoTexts = new int[]{R.string.hill_info, R.string.manual_info, R.string.strength_info, R.string.cardio_info, R.string.fat_burn_info, R.string.interval_info, R.string.user_info, R.string.hr1_info, R.string.hr2_info};
                    DeviceModelList.programTitleUpperTexts = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.custom, R.string.hr1, R.string.hr2};
                    break;
                case 29:
                case 30:
                case 31:
                    break;
                default:
                    switch (i2) {
                        case 144:
                        case 145:
                        case 146:
                        case 147:
                        case 148:
                            DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.hill, R.string.strength, R.string.fat_burn, R.string.user1, R.string.hr1}, new int[]{R.string.manual, R.string.cardio, R.string.interval, R.string.user2, R.string.hr2}};
                            DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.program_icon_hill, R.drawable.program_icon_strength, R.drawable.program_icon_fatburn, R.drawable.program_icon_user1, R.drawable.program_icon_hr1}, new int[]{R.drawable.program_icon_manual, R.drawable.program_icon_cardio, R.drawable.program_icon_interval, R.drawable.program_icon_user2, R.drawable.program_icon_hr2}};
                            DeviceModelList.programUnselectedImages = new int[]{R.drawable.program_icon_hill, R.drawable.program_icon_manual, R.drawable.program_icon_strength, R.drawable.program_icon_cardio, R.drawable.program_icon_fatburn, R.drawable.program_icon_interval, R.drawable.program_icon_user1, R.drawable.program_icon_user2, R.drawable.program_icon_hr1, R.drawable.program_icon_hr2};
                            DeviceModelList.programSelectedImages = new int[]{R.drawable.program_icon_hill_s, R.drawable.program_icon_manual_s, R.drawable.program_icon_strength_s, R.drawable.program_icon_cardio_s, R.drawable.program_icon_fatburn_s, R.drawable.program_icon_interval_s, R.drawable.program_icon_user1_s, R.drawable.program_icon_user2_s, R.drawable.program_icon_hr1_s, R.drawable.program_icon_hr2_s};
                            DeviceModelList.programPosition = new int[][]{DeviceModelList.HILL, DeviceModelList.MANUAL, DeviceModelList.STRENGTH, DeviceModelList.CARDIO, DeviceModelList.FAT_BURN, DeviceModelList.INTERVAL, DeviceModelList.USER, DeviceModelList.USER, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE};
                            DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}};
                            DeviceModelList.programTitleTexts = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                            DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Hill, DeviceModelList.PGName_Manual, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                            DeviceModelList.programInfoTexts = new int[]{R.string.hill_info, R.string.manual_info, R.string.strength_info, R.string.cardio_info, R.string.fat_burn_info, R.string.interval_info, R.string.user_info, R.string.user_info, R.string.hr1_info, R.string.hr2_info};
                            DeviceModelList.programTitleUpperTexts = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                            break;
                        case 149:
                            DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.hill, R.string.strength, R.string.fat_burn, R.string.hr1}, new int[]{R.string.manual, R.string.cardio, R.string.interval, R.string.custom, R.string.hr2}};
                            DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.program_icon_hill, R.drawable.program_icon_strength, R.drawable.program_icon_fatburn, R.drawable.program_icon_hr1}, new int[]{R.drawable.program_icon_manual, R.drawable.program_icon_cardio, R.drawable.program_icon_interval, R.drawable.program_icon_custom, R.drawable.program_icon_hr2}};
                            DeviceModelList.programUnselectedImages = new int[]{R.drawable.program_icon_hill, R.drawable.program_icon_manual, R.drawable.program_icon_strength, R.drawable.program_icon_cardio, R.drawable.program_icon_fatburn, R.drawable.program_icon_interval, R.drawable.program_icon_custom, R.drawable.program_icon_hr1, R.drawable.program_icon_hr2};
                            DeviceModelList.programSelectedImages = new int[]{R.drawable.program_icon_hill_s, R.drawable.program_icon_manual_s, R.drawable.program_icon_strength_s, R.drawable.program_icon_cardio_s, R.drawable.program_icon_fatburn_s, R.drawable.program_icon_interval_s, R.drawable.program_icon_custom_s, R.drawable.program_icon_hr1_s, R.drawable.program_icon_hr2_s};
                            DeviceModelList.programPosition = new int[][]{DeviceModelList.HILL, DeviceModelList.MANUAL, DeviceModelList.STRENGTH, DeviceModelList.CARDIO, DeviceModelList.FAT_BURN, DeviceModelList.INTERVAL, DeviceModelList.USER, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE};
                            DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}};
                            DeviceModelList.programTitleTexts = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.custom, R.string.hr1, R.string.hr2};
                            DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Hill, DeviceModelList.PGName_Manual, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_Custom, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                            DeviceModelList.programInfoTexts = new int[]{R.string.hill_info, R.string.manual_info, R.string.strength_info, R.string.cardio_info, R.string.fat_burn_info, R.string.interval_info, R.string.user_info, R.string.hr1_info, R.string.hr2_info};
                            DeviceModelList.programTitleUpperTexts = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.custom, R.string.hr1, R.string.hr2};
                            break;
                    }
            }
            return;
        }
        DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength}, new int[]{R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2}};
        DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.program_icon_manual, R.drawable.program_icon_hill, R.drawable.program_icon_fatburn, R.drawable.program_icon_cardio, R.drawable.program_icon_strength}, new int[]{R.drawable.program_icon_interval, R.drawable.program_icon_user1, R.drawable.program_icon_user2, R.drawable.program_icon_hr1, R.drawable.program_icon_hr2}};
        DeviceModelList.programUnselectedImages = new int[]{R.drawable.program_icon_manual, R.drawable.program_icon_hill, R.drawable.program_icon_fatburn, R.drawable.program_icon_cardio, R.drawable.program_icon_strength, R.drawable.program_icon_interval, R.drawable.program_icon_user1, R.drawable.program_icon_user2, R.drawable.program_icon_hr1, R.drawable.program_icon_hr2};
        DeviceModelList.programSelectedImages = new int[]{R.drawable.program_icon_manual_s, R.drawable.program_icon_hill_s, R.drawable.program_icon_fatburn_s, R.drawable.program_icon_cardio_s, R.drawable.program_icon_strength_s, R.drawable.program_icon_interval_s, R.drawable.program_icon_user1_s, R.drawable.program_icon_user2_s, R.drawable.program_icon_hr1_s, R.drawable.program_icon_hr2_s};
        DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.USER, DeviceModelList.USER, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE};
        DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}};
        DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
        DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
        DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.user_info, R.string.user_info, R.string.hr1_info, R.string.hr2_info};
        DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
    }

    public static void handleDeviceModelExportUser(int i) {
        if (i != 64) {
            switch (i) {
                case 16:
                case 17:
                    DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user};
                    DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User};
                    break;
                case 18:
                case 19:
                case 22:
                case 23:
                case 24:
                case 25:
                case 27:
                case 28:
                    DeviceModelList.programTitleTextsExportUser = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                    DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Hill, DeviceModelList.PGName_Manual, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                    break;
                case 20:
                case 21:
                case 26:
                    DeviceModelList.programTitleTextsExportUser = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.custom, R.string.hr1, R.string.hr2};
                    DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Hill, DeviceModelList.PGName_Manual, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_Custom, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                    break;
                case 29:
                case 30:
                case 31:
                    break;
                default:
                    switch (i) {
                        case 144:
                        case 145:
                        case 146:
                        case 147:
                        case 148:
                            DeviceModelList.programTitleTextsExportUser = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
                            DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Hill, DeviceModelList.PGName_Manual, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                            break;
                        case 149:
                            Logger.d("model_tt8 = model_tt8");
                            DeviceModelList.programTitleTextsExportUser = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.custom, R.string.hr1, R.string.hr2};
                            DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Hill, DeviceModelList.PGName_Manual, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Interval, DeviceModelList.PGName_Custom, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                            break;
                    }
            }
        }
        DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
        DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
    }
}
