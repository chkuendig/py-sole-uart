package com.soletreadmills.sole_v2.ui.pair;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.soletreadmills.sole_v2._type.ConnectProgramNameType;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectProgramViewModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "inclineProFileListGlobal", "", "", "getInclineProFileListGlobal", "()Ljava/util/List;", "setInclineProFileListGlobal", "(Ljava/util/List;)V", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "speedOrLevelListGlobal", "getSpeedOrLevelListGlobal", "setSpeedOrLevelListGlobal", "type", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "getType", "()Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "setType", "(Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectProgramViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private List<Integer> inclineProFileListGlobal;
    private BleFtmsMachineType machineType;
    private List<Integer> speedOrLevelListGlobal;
    private ConnectProgramNameType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectProgramViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        ArrayList arrayList = new ArrayList(20);
        for (int i = 0; i < 20; i++) {
            arrayList.add(5);
        }
        this.speedOrLevelListGlobal = arrayList;
        ArrayList arrayList2 = new ArrayList(20);
        for (int i2 = 0; i2 < 20; i2++) {
            arrayList2.add(1);
        }
        this.inclineProFileListGlobal = arrayList2;
    }

    public final BleFtmsMachineType getMachineType() {
        return this.machineType;
    }

    public final void setMachineType(BleFtmsMachineType bleFtmsMachineType) {
        this.machineType = bleFtmsMachineType;
    }

    public final ConnectProgramNameType getType() {
        return this.type;
    }

    public final void setType(ConnectProgramNameType connectProgramNameType) {
        this.type = connectProgramNameType;
    }

    public final List<Integer> getSpeedOrLevelListGlobal() {
        return this.speedOrLevelListGlobal;
    }

    public final void setSpeedOrLevelListGlobal(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.speedOrLevelListGlobal = list;
    }

    public final List<Integer> getInclineProFileListGlobal() {
        return this.inclineProFileListGlobal;
    }

    public final void setInclineProFileListGlobal(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.inclineProFileListGlobal = list;
    }
}
