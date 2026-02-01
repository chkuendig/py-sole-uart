package com.soletreadmills.sole_v2._tools;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SrtParser.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0004X\u008a\u008e\u0002"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/Global;", "", "()V", "getSubtitleLangStr", "", "app_release", "subtitleLanguage"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Global {
    public static final int $stable = 0;
    public static final Global INSTANCE = new Global();

    private Global() {
    }

    public final String getSubtitleLangStr() {
        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
        String loginUuid = com.soletreadmills.sole_v2.Global.getLoginUuid();
        if (loginUuid == null) {
            loginUuid = "";
        }
        MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(companion.getSubtitleLanguage(loginUuid), null, 2, null);
        if (Intrinsics.areEqual(getSubtitleLangStr$lambda$0(mutableStateMutableStateOf$default), "zh_tw")) {
            return "zh-TW";
        }
        if (Intrinsics.areEqual(getSubtitleLangStr$lambda$0(mutableStateMutableStateOf$default), "zh_cn")) {
            return "zh-CN";
        }
        return getSubtitleLangStr$lambda$0(mutableStateMutableStateOf$default);
    }

    private static final String getSubtitleLangStr$lambda$0(MutableState<String> mutableState) {
        return mutableState.getValue();
    }
}
