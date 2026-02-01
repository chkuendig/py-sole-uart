package com.soletreadmills.sole_v2.ble.tool;

import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes5.dex */
public class CheckSimpleFtmsDataTool {
    public static boolean isSimpleTreadmillData(final FtmsBaseData ftmsBaseData, Data data) {
        return ftmsBaseData != null && (ftmsBaseData instanceof TreadmillData) && CheckSimpleFtmsDeviceTool.isTreadmill(ftmsBaseData.getBleName()) && ftmsBaseData.getElapsedTime() == null && data.getValue() != null && data.getValue().length < 10;
    }

    public static boolean isSimpleBikeEjekData(final FtmsBaseData ftmsBaseData, Data data) {
        if (ftmsBaseData != null && (ftmsBaseData instanceof IndoorBikeData)) {
            return (CheckSimpleFtmsDeviceTool.isBikeSoleEjek(ftmsBaseData.getBleName()) || CheckSimpleFtmsDeviceTool.isBikeSpiritEjek(ftmsBaseData.getBleName())) && ftmsBaseData.getElapsedTime() == null && data.getValue() != null && data.getValue().length < 10;
        }
        return false;
    }

    public static boolean isSimpleBikeCorestarData(final FtmsBaseData ftmsBaseData, Data data) {
        if (ftmsBaseData != null && (ftmsBaseData instanceof IndoorBikeData)) {
            return (CheckSimpleFtmsDeviceTool.isBikeSoleCorestar(ftmsBaseData.getBleName()) || CheckSimpleFtmsDeviceTool.isBikeSpiritCorestar(ftmsBaseData.getBleName()) || CheckSimpleFtmsDeviceTool.isBikeXterraCorestar(ftmsBaseData.getBleName())) && ftmsBaseData.getElapsedTime() == null && data.getValue() != null && data.getValue().length < 10;
        }
        return false;
    }

    public static boolean isSimpleBikeDirectionData(final FtmsBaseData ftmsBaseData, Data data) {
        if (ftmsBaseData != null && (ftmsBaseData instanceof IndoorBikeData)) {
            return CheckSimpleFtmsDeviceTool.isBikeDirection(ftmsBaseData.getBleName());
        }
        return false;
    }

    public static boolean isSimpleEllipticalEjekData(final FtmsBaseData ftmsBaseData, Data data) {
        if (ftmsBaseData == null) {
            return false;
        }
        if ((ftmsBaseData instanceof CrossTrainerData) || (ftmsBaseData instanceof IndoorBikeData)) {
            return (CheckSimpleFtmsDeviceTool.isEllipticalSoleEjek(ftmsBaseData.getBleName()) || CheckSimpleFtmsDeviceTool.isEllipticalSpiritEjek(ftmsBaseData.getBleName())) && ftmsBaseData.getElapsedTime() == null && data.getValue() != null && data.getValue().length < 10;
        }
        return false;
    }

    public static boolean isSimpleEllipticalCorestarData(final FtmsBaseData ftmsBaseData, Data data) {
        if (ftmsBaseData != null && (ftmsBaseData instanceof CrossTrainerData)) {
            return CheckSimpleFtmsDeviceTool.isEllipticalSoleCorestar(ftmsBaseData.getBleName()) || CheckSimpleFtmsDeviceTool.isEllipticalSpiritCorestar(ftmsBaseData.getBleName());
        }
        return false;
    }
}
