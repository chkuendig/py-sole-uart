package com.soletreadmills.sole_v2.ble.tool;

import com.android.SdkConstants;
import com.soletreadmills.sole_v2.ble.BleTools;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes5.dex */
public class SimpleFtmsSimulationTool {
    private static Long currentTimeMillisOld;
    private static final String[] lcbDataStrArr = {"C0-00-00-00-08-00", "01-02-58-00", "C0-00-00-00-0A-00", "01-02-5B-00"};
    private static int lcbDataIndex = 0;
    private static final String[] dt3268DataStrArr = {"FE-0B-00-00-00-00-90-00-00-00-00-00-00-00-00-66-00-00-00-00-00-00-00-00-00-00-00", "FE-0B-00-00-00-00-8E-00-00-00-00-00-00-00-00-64-00-00-00-00-00-00-00-00-00-00-00", "FE-0B-00-00-00-00-90-00-00-00-00-00-00-00-00-66-00-00-00-00-00-00-00-00-00-00-00", "FE-0B-00-00-00-00-90-00-00-00-00-00-00-00-00-64-00-00-00-00-00-00-00-00-00-00-00"};
    private static int dt326DataIndex = 0;
    private static final String[] e95sDataStrArr = {"01-02-55-00", "C0-00-00-00-03-00", "01-02-58-00", "C0-00-00-00-03-00"};
    private static int e95sDataIndex = 0;

    public static Data getLcbSimulationData() {
        if (currentTimeMillisOld == null) {
            lcbDataIndex = 0;
        } else if (System.currentTimeMillis() - currentTimeMillisOld.longValue() > 1) {
            lcbDataIndex++;
        }
        currentTimeMillisOld = Long.valueOf(System.currentTimeMillis());
        int i = lcbDataIndex;
        String[] strArr = lcbDataStrArr;
        if (i >= strArr.length) {
            lcbDataIndex = 0;
        }
        return new Data(BleTools.hexToBytes(strArr[lcbDataIndex].replaceAll(SdkConstants.RES_QUALIFIER_SEP, "")));
    }

    public static Data getDt3268SimulationData() {
        if (currentTimeMillisOld == null) {
            dt326DataIndex = 0;
        } else if (System.currentTimeMillis() - currentTimeMillisOld.longValue() > 1) {
            dt326DataIndex++;
        }
        currentTimeMillisOld = Long.valueOf(System.currentTimeMillis());
        int i = dt326DataIndex;
        String[] strArr = dt3268DataStrArr;
        if (i >= strArr.length) {
            dt326DataIndex = 0;
        }
        return new Data(BleTools.hexToBytes(strArr[dt326DataIndex].replaceAll(SdkConstants.RES_QUALIFIER_SEP, "")));
    }

    public static Data getE95sSimulationData() {
        if (currentTimeMillisOld == null) {
            e95sDataIndex = 0;
        } else if (System.currentTimeMillis() - currentTimeMillisOld.longValue() > 1) {
            e95sDataIndex++;
        }
        currentTimeMillisOld = Long.valueOf(System.currentTimeMillis());
        int i = e95sDataIndex;
        String[] strArr = e95sDataStrArr;
        if (i >= strArr.length) {
            e95sDataIndex = 0;
        }
        return new Data(BleTools.hexToBytes(strArr[e95sDataIndex].replaceAll(SdkConstants.RES_QUALIFIER_SEP, "")));
    }
}
