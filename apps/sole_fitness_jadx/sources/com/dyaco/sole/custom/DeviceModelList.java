package com.dyaco.sole.custom;

import com.soletreadmills.sole.R;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceModelList {
    public static int[] CALORIES = null;
    public static int[] CARDIO = null;
    public static final String[] DEVICE_NAME_LIST;
    public static int[] FAT_BURN = null;
    public static int[] FUSION = null;
    public static int[] HEART_RATE = null;
    public static int[] HILL = null;
    public static int[] INTERVAL = null;
    public static int[] MANUAL = null;
    public static final int MODEL_TYPE_BIKE = 1;
    public static final int MODEL_TYPE_ELLIPTICAL = 2;
    public static final int MODEL_TYPE_TREADMILL = 0;
    public static String PGName_Bike;
    public static String PGName_Calories;
    public static String PGName_Cardio;
    public static String PGName_Custom;
    public static String PGName_FatBurn;
    public static String PGName_Fitness;
    public static String PGName_Fusion;
    public static String PGName_HR1;
    public static String PGName_HR2;
    public static String PGName_Hill;
    public static String PGName_Interval;
    public static String PGName_Manual;
    public static String PGName_Run;
    public static String PGName_Strength;
    public static String PGName_User;
    public static String PGName_User1;
    public static String PGName_User2;
    public static String PGName_Walk;
    public static int[] STRENGTH;
    public static int[] USER;
    public static int[] bottomParamTexts;
    public static int[] programAllOldResIDExportUser;
    public static int[] programAllTitleTextsExportUser;
    public static int[][] programImagesLocation;
    public static int[] programInfoTexts;
    public static String[] programNames;
    public static String[] programNamesExportUser;
    public static String[] programNamesForOutdoor;
    public static int[][] programPosition;
    public static int[] programSelectedImages;
    public static int[][] programSettingSize;
    public static Map<String, Integer> programTexts;
    public static int[][] programTextsLocation;
    public static int[] programTitleTexts;
    public static int[] programTitleTextsExportUser;
    public static int[] programTitleUpperTexts;
    public static int[] programUnselectedImages;

    static {
        String[] strArr;
        if (Global.BRAND == 0) {
            strArr = Sole_DeviceModelList.DEVICE_NAME_LIST;
        } else if (Global.BRAND == 1) {
            strArr = Spirit_DeviceModelList.DEVICE_NAME_LIST;
        } else {
            strArr = Global.BRAND == 2 ? Xterra_DeviceModelList.DEVICE_NAME_LIST : Fuel_DeviceModelList.DEVICE_NAME_LIST;
        }
        DEVICE_NAME_LIST = strArr;
        PGName_Manual = "PGName_Manual";
        PGName_Hill = "PGName_Hill";
        PGName_FatBurn = "PGName_FatBurn";
        PGName_Cardio = "PGName_Cardio";
        PGName_Strength = "PGName_Strength";
        PGName_Interval = "PGName_Interval";
        PGName_HR1 = "PGName_HR1";
        PGName_HR2 = "PGName_HR2";
        PGName_User = "PGName_User";
        PGName_User1 = "PGName_User1";
        PGName_User2 = "PGName_User2";
        PGName_Custom = "PGName_Custom";
        PGName_Fitness = "PGName_Fitness";
        PGName_Calories = "PGName_Calories";
        PGName_Fusion = "PGName_Fusion";
        PGName_Walk = "PGName_Walk";
        PGName_Run = "PGName_Run";
        PGName_Bike = "PGName_Bike";
        programNamesForOutdoor = new String[]{"PGName_Walk", "PGName_Run", "PGName_Bike"};
        programTexts = new HashMap();
        programAllTitleTextsExportUser = new int[]{R.string.hill, R.string.manual, R.string.strength, R.string.cardio, R.string.fat_burn, R.string.interval, R.string.user1, R.string.user2, R.string.hr1, R.string.hr2};
        programAllOldResIDExportUser = new int[]{R.drawable.all_icon_a_ble_0, R.drawable.all_title_a_display1, R.drawable.com_facebook_button_send_icon_blue, R.drawable.abc_list_selector_disabled_holo_light, R.drawable.all_btn_a_1, R.drawable.all_item_a_btn_1, R.drawable.common_google_signin_btn_icon_light_normal_background, R.drawable.common_google_signin_btn_text_dark, R.drawable.all_icon_a_ble_1, R.drawable.all_icon_a_ble_1_sole_plus};
    }

    public static void handleDeviceModel() {
        programTexts.put(PGName_Manual, Integer.valueOf(R.string.manual));
        programTexts.put(PGName_Hill, Integer.valueOf(R.string.hill));
        programTexts.put(PGName_FatBurn, Integer.valueOf(R.string.fat_burn));
        programTexts.put(PGName_Cardio, Integer.valueOf(R.string.cardio));
        programTexts.put(PGName_Strength, Integer.valueOf(R.string.strength));
        programTexts.put(PGName_Interval, Integer.valueOf(R.string.interval));
        programTexts.put(PGName_HR1, Integer.valueOf(R.string.hr1));
        programTexts.put(PGName_HR2, Integer.valueOf(R.string.hr2));
        programTexts.put(PGName_User, Integer.valueOf(R.string.user));
        programTexts.put(PGName_User1, Integer.valueOf(R.string.user1));
        programTexts.put(PGName_User2, Integer.valueOf(R.string.user2));
        programTexts.put(PGName_Custom, Integer.valueOf(R.string.custom));
        programTexts.put(PGName_Fitness, Integer.valueOf(R.string.fitness_test));
        programTexts.put(PGName_Calories, Integer.valueOf(R.string.calorie));
        programTexts.put(PGName_Fusion, Integer.valueOf(R.string.fusion));
        programTexts.put(PGName_Walk, Integer.valueOf(R.string.walk));
        programTexts.put(PGName_Run, Integer.valueOf(R.string.run));
        programTexts.put(PGName_Bike, Integer.valueOf(R.string.bike));
    }
}
