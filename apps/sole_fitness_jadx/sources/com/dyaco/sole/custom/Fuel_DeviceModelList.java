package com.dyaco.sole.custom;

import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class Fuel_DeviceModelList {
    public static final String[] DEVICE_NAME_LIST = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "MODEL_FE500NEW", "FE666", "FE600", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FE900", "EC1000", "EC900", "FE100", "CT100", "CT300", "CT500", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FT500", "", "FT520", ""};
    public static final int MODEL_CE900 = 102;
    public static final int MODEL_CT100 = 104;
    public static final int MODEL_CT300 = 105;
    public static final int MODEL_CT500 = 106;
    public static final int MODEL_EC1000 = 101;
    public static final int MODEL_FE100 = 103;
    public static final int MODEL_FE500 = 37;
    public static final int MODEL_FE500NEW = 38;
    public static final int MODEL_FE600 = 40;
    public static final int MODEL_FE666 = 39;
    public static final int MODEL_FE900 = 100;
    public static final int MODEL_FT335 = 177;
    public static final int MODEL_FT500 = 176;
    public static final int MODEL_FT520 = 178;
    public static final int MODEL_MAX_24 = 24;
    public static final int MODEL_MAX_32 = 32;

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
        } else if (i == 1 || i == 2) {
            DeviceModelList.MANUAL = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            DeviceModelList.HILL = new int[]{1, 2, 3, 3, 5, 5, 5, 7, 7, 9, 8, 7, 7, 5, 5, 5, 3, 3, 2, 1};
            DeviceModelList.FAT_BURN = new int[]{1, 2, 4, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 4, 2, 1};
            DeviceModelList.CARDIO = new int[]{1, 2, 5, 6, 8, 9, 8, 6, 6, 8, 9, 8, 6, 8, 9, 8, 6, 5, 2, 1};
            DeviceModelList.STRENGTH = new int[]{1, 2, 4, 5, 5, 7, 7, 7, 9, 9, 9, 9, 9, 9, 9, 9, 8, 6, 2, 1};
            DeviceModelList.INTERVAL = new int[]{1, 2, 4, 9, 9, 4, 4, 9, 9, 4, 4, 9, 9, 4, 4, 9, 9, 4, 2, 1};
            DeviceModelList.HEART_RATE = new int[0];
            DeviceModelList.USER = DeviceModelList.MANUAL;
            DeviceModelList.bottomParamTexts = new int[]{R.string.display_pulse, R.string.display_hr_percent, 0, R.string.display_program_name, R.string.display_calories, R.string.display_watts};
        }
        int i2 = ProtocolHandler.protocol.deviceModel;
        if (i2 == 0) {
            DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength}, new int[]{R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2}};
            DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s}, new int[]{R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s}};
            DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_strength, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_hr1, R.drawable.s_program_icon_hr2, R.drawable.s_program_icon_user, R.drawable.s_program_icon_user};
            DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s};
            DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE, DeviceModelList.USER, DeviceModelList.USER};
            DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time}, new int[]{R.string.time}};
            DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
            DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2};
            DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.hr1_info, R.string.hr2_info, R.string.user_info, R.string.user_info};
            DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
            return;
        }
        switch (i2) {
            case 37:
            case 38:
            case 39:
            case 40:
                break;
            default:
                switch (i2) {
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                        break;
                    default:
                        switch (i2) {
                        }
                        return;
                }
        }
        DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength}, new int[]{R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2}};
        DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s}, new int[]{R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s}};
        DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_strength, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_hr1, R.drawable.s_program_icon_hr2, R.drawable.s_program_icon_user, R.drawable.s_program_icon_user};
        DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s};
        DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE, DeviceModelList.USER, DeviceModelList.USER};
        DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time}, new int[]{R.string.time}};
        if (ProtocolHandler.protocol.deviceModel == 38 || ProtocolHandler.protocol.deviceModel == 39 || ProtocolHandler.protocol.deviceModel == 40 || ProtocolHandler.protocol.deviceModel == 100 || ProtocolHandler.protocol.deviceModel == 101 || ProtocolHandler.protocol.deviceModel == 102 || ProtocolHandler.protocol.deviceModel == 103 || ProtocolHandler.protocol.deviceModel == 104 || ProtocolHandler.protocol.deviceModel == 105 || ProtocolHandler.protocol.deviceModel == 106) {
            DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time}, new int[]{R.string.time}};
        }
        DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
        DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2};
        DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.hr1_info, R.string.hr2_info, R.string.user_info, R.string.user_info};
        DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
    }

    public static void handleDeviceModelExportUser(int i) {
        if (i == 0) {
            DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
            DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2};
            return;
        }
        switch (i) {
            case 37:
            case 38:
            case 39:
            case 40:
                break;
            default:
                switch (i) {
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                        break;
                    default:
                        switch (i) {
                        }
                        return;
                }
        }
        DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
        DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2};
    }
}
