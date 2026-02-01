package com.dyaco.sole.custom;

import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class Xterra_DeviceModelList {
    public static final String[] DEVICE_NAME_LIST = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FS5.8e", "FS5.3e", "", "XE88", "EC300", "XE78", "FE300", "FSX3500", "FSX1500", "FSX2500", "LE100", "LE500", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FE900", "EC1000", "EC900", "FE100", "CT100", "CT300", "CT500", "EC100", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "TR3.0", "TR6.45", "TR6.65", "TRX3500", "TRX4500", "IT80", "XT800 HRC", "XT900 HRC", "TRX7.5", "XTERRA3000"};
    public static final int MODEL_24_MAXLEVEL = 24;
    public static final int MODEL_32_MAXLEVEL = 32;
    public static final int MODEL_CT100 = 116;
    public static final int MODEL_CT300 = 117;
    public static final int MODEL_CT500 = 118;
    public static final int MODEL_EC100 = 119;
    public static final int MODEL_EC1000 = 113;
    public static final int MODEL_EC300 = 52;
    public static final int MODEL_EC900 = 114;
    public static final int MODEL_FE100 = 115;
    public static final int MODEL_FE300 = 54;
    public static final int MODEL_FE900 = 112;
    public static final int MODEL_FS5_3E = 49;
    public static final int MODEL_FS5_8E = 48;
    public static final int MODEL_FSX1500 = 56;
    public static final int MODEL_FSX2500 = 57;
    public static final int MODEL_FSX3500 = 55;
    public static final int MODEL_IT80 = 165;
    public static final int MODEL_LE100 = 58;
    public static final int MODEL_LE500 = 59;
    public static final int MODEL_SR146 = 50;
    public static final int MODEL_TR3_0 = 160;
    public static final int MODEL_TR6_45 = 161;
    public static final int MODEL_TR6_65 = 162;
    public static final int MODEL_TRX3500 = 163;
    public static final int MODEL_TRX4500 = 164;
    public static final int MODEL_TRX75 = 168;
    public static final int MODEL_XE78 = 53;
    public static final int MODEL_XE88 = 51;
    public static final int MODEL_XT800HRC = 166;
    public static final int MODEL_XT900HRC = 167;
    public static final int MODEL_XTERRA3000 = 169;

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
        switch (i2) {
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                break;
            default:
                switch (i2) {
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                        break;
                    default:
                        switch (i2) {
                            case 160:
                            case 161:
                            case 162:
                            case 163:
                            case 164:
                            case 165:
                            case 166:
                            case 167:
                            case 168:
                            case 169:
                                DeviceModelList.programTextsLocation = new int[][]{new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength}, new int[]{R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2}};
                                DeviceModelList.programImagesLocation = new int[][]{new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s}, new int[]{R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s}};
                                DeviceModelList.programUnselectedImages = new int[]{R.drawable.s_program_icon_manual, R.drawable.s_program_icon_hill, R.drawable.s_program_icon_fatburn, R.drawable.s_program_icon_cardio, R.drawable.s_program_icon_strength, R.drawable.s_program_icon_interval, R.drawable.s_program_icon_hr1, R.drawable.s_program_icon_hr2, R.drawable.s_program_icon_user, R.drawable.s_program_icon_user};
                                DeviceModelList.programSelectedImages = new int[]{R.drawable.s_program_icon_manual_s, R.drawable.s_program_icon_hill_s, R.drawable.s_program_icon_fatburn_s, R.drawable.s_program_icon_cardio_s, R.drawable.s_program_icon_strength_s, R.drawable.s_program_icon_interval_s, R.drawable.s_program_icon_hr1_s, R.drawable.s_program_icon_hr2_s, R.drawable.s_program_icon_user_s, R.drawable.s_program_icon_user_s};
                                DeviceModelList.programPosition = new int[][]{DeviceModelList.MANUAL, DeviceModelList.HILL, DeviceModelList.FAT_BURN, DeviceModelList.CARDIO, DeviceModelList.STRENGTH, DeviceModelList.INTERVAL, DeviceModelList.HEART_RATE, DeviceModelList.HEART_RATE, DeviceModelList.USER, DeviceModelList.USER};
                                DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time}, new int[]{R.string.time}};
                                DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
                                DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                                DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.hr1_info, R.string.hr2_info, R.string.user_info, R.string.user_info};
                                DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
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
        DeviceModelList.programSettingSize = new int[][]{new int[]{R.string.time}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.level}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time, R.string.target_hr}, new int[]{R.string.time}, new int[]{R.string.time}};
        DeviceModelList.programTitleTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
        DeviceModelList.programNames = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2};
        DeviceModelList.programInfoTexts = new int[]{R.string.manual_info, R.string.hill_info, R.string.fat_burn_info, R.string.cardio_info, R.string.strength_info, R.string.interval_info, R.string.hr1_info, R.string.hr2_info, R.string.user_info, R.string.user_info};
        DeviceModelList.programTitleUpperTexts = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
    }

    public static void handleDeviceModelExportUser(int i) {
        switch (i) {
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                break;
            default:
                switch (i) {
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                        break;
                    default:
                        switch (i) {
                            case 160:
                            case 161:
                            case 162:
                            case 163:
                            case 164:
                            case 165:
                            case 166:
                            case 167:
                            case 168:
                            case 169:
                                DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
                                DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2};
                                break;
                        }
                }
        }
        DeviceModelList.programTitleTextsExportUser = new int[]{R.string.manual, R.string.hill, R.string.fat_burn, R.string.cardio, R.string.strength, R.string.interval, R.string.hr1, R.string.hr2, R.string.user1, R.string.user2};
        DeviceModelList.programNamesExportUser = new String[]{DeviceModelList.PGName_Manual, DeviceModelList.PGName_Hill, DeviceModelList.PGName_FatBurn, DeviceModelList.PGName_Cardio, DeviceModelList.PGName_Strength, DeviceModelList.PGName_Interval, DeviceModelList.PGName_HR1, DeviceModelList.PGName_HR2, DeviceModelList.PGName_User1, DeviceModelList.PGName_User2};
    }
}
