package com.soletreadmills.sole_v2.ui.classes;

import android.util.Log;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._manager.AudioManagerHolder;
import com.soletreadmills.sole_v2._manager.AudioPlayerManager;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VideoSettingsViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001eR+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/VideoSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "<set-?>", "", "musicVolume", "getMusicVolume", "()F", "setMusicVolume", "(F)V", "musicVolume$delegate", "Landroidx/compose/runtime/MutableFloatState;", "prefs", "Lcom/soletreadmills/sole_v2/_sharedPreferences/MySharedPreferences;", "", "showSubtitles", "getShowSubtitles", "()Z", "setShowSubtitles", "(Z)V", "showSubtitles$delegate", "Landroidx/compose/runtime/MutableState;", "", "subtitleLanguage", "getSubtitleLanguage", "()Ljava/lang/String;", "setSubtitleLanguage", "(Ljava/lang/String;)V", "subtitleLanguage$delegate", "getDefaultLocale", "Ljava/util/Locale;", "getLanguage", "mapToSupportedLanguage", "code", "updateMusicVolume", "", "value", "updateShowSubtitles", "updateSubtitleLanguage", SdkConstants.ATTR_LOCALE, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class VideoSettingsViewModel extends ViewModel {
    public static final int $stable = 8;

    /* renamed from: musicVolume$delegate, reason: from kotlin metadata */
    private final MutableFloatState musicVolume;
    private final MySharedPreferences prefs;

    /* renamed from: showSubtitles$delegate, reason: from kotlin metadata */
    private final MutableState showSubtitles;

    /* renamed from: subtitleLanguage$delegate, reason: from kotlin metadata */
    private final MutableState subtitleLanguage;

    public VideoSettingsViewModel() {
        String userUuid;
        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
        this.prefs = companion;
        this.musicVolume = PrimitiveSnapshotStateKt.mutableFloatStateOf(companion.getMusicVolume());
        this.showSubtitles = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(companion.getShowSubtitles()), null, 2, null);
        LoginUserData loginUserData = Global.userData;
        this.subtitleLanguage = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(companion.getSubtitleLanguage((loginUserData == null || (userUuid = loginUserData.getUserUuid()) == null) ? "" : userUuid), null, 2, null);
    }

    private final void setMusicVolume(float f) {
        this.musicVolume.setFloatValue(f);
    }

    public final float getMusicVolume() {
        return this.musicVolume.getFloatValue();
    }

    private final void setShowSubtitles(boolean z) {
        this.showSubtitles.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSubtitles() {
        return ((Boolean) this.showSubtitles.getValue()).booleanValue();
    }

    private final void setSubtitleLanguage(String str) {
        this.subtitleLanguage.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getSubtitleLanguage() {
        return (String) this.subtitleLanguage.getValue();
    }

    public final void updateMusicVolume(float value) {
        setMusicVolume(value);
        this.prefs.setMusicVolume(value);
        AudioPlayerManager audioPlayerManager = AudioManagerHolder.INSTANCE.get();
        if (audioPlayerManager != null) {
            audioPlayerManager.setVolume(value);
        }
        Log.d("VideoSettingsViewModel", "音量更新為: " + value);
    }

    public final void updateShowSubtitles(boolean value) {
        setShowSubtitles(value);
        this.prefs.setShowSubtitles(value);
    }

    public final void updateSubtitleLanguage(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        String lowerCase = languageTag.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplace$default = StringsKt.replace$default(lowerCase, SdkConstants.RES_QUALIFIER_SEP, "_", false, 4, (Object) null);
        String loginUuid = Global.getLoginUuid();
        if (loginUuid == null) {
            loginUuid = "";
        }
        setSubtitleLanguage(mapToSupportedLanguage(strReplace$default));
        this.prefs.setSubtitleLanguage(getSubtitleLanguage(), loginUuid);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007f A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getLanguage() {
        /*
            r2 = this;
            java.lang.String r0 = r2.getSubtitleLanguage()
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case 3201: goto L73;
                case 3246: goto L67;
                case 3276: goto L5b;
                case 3383: goto L4f;
                case 3651: goto L43;
                case 115814250: goto L37;
                case 115814786: goto L2b;
                case 115862300: goto L22;
                case 115862836: goto L18;
                default: goto L16;
            }
        L16:
            goto L7f
        L18:
            java.lang.String r1 = "zh_tw"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L34
            goto L7f
        L22:
            java.lang.String r1 = "zh_cn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L40
            goto L7f
        L2b:
            java.lang.String r1 = "zh-tw"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L34
            goto L7f
        L34:
            java.lang.String r0 = "繁體中文"
            goto L81
        L37:
            java.lang.String r1 = "zh-cn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L40
            goto L7f
        L40:
            java.lang.String r0 = "简体中文"
            goto L81
        L43:
            java.lang.String r1 = "ru"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4c
            goto L7f
        L4c:
            java.lang.String r0 = "Русский"
            goto L81
        L4f:
            java.lang.String r1 = "ja"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L58
            goto L7f
        L58:
            java.lang.String r0 = "日本語"
            goto L81
        L5b:
            java.lang.String r1 = "fr"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L64
            goto L7f
        L64:
            java.lang.String r0 = "Français"
            goto L81
        L67:
            java.lang.String r1 = "es"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L70
            goto L7f
        L70:
            java.lang.String r0 = "Español"
            goto L81
        L73:
            java.lang.String r1 = "de"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7c
            goto L7f
        L7c:
            java.lang.String r0 = "Deutsch"
            goto L81
        L7f:
            java.lang.String r0 = "English"
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoSettingsViewModel.getLanguage():java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        if (r0.equals("zh-tw") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        if (r0.equals("zh-cn") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return new java.util.Locale("zh_tw");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return new java.util.Locale("zh_cn");
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        if (r0.equals("zh_tw") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        if (r0.equals("zh_cn") == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Locale getDefaultLocale() {
        /*
            r4 = this;
            java.lang.String r0 = r4.getSubtitleLanguage()
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            java.lang.String r2 = "zh_tw"
            java.lang.String r3 = "zh_cn"
            switch(r1) {
                case 3201: goto L88;
                case 3246: goto L79;
                case 3276: goto L6a;
                case 3383: goto L5b;
                case 3651: goto L4c;
                case 115814250: goto L3d;
                case 115814786: goto L2c;
                case 115862300: goto L24;
                case 115862836: goto L1c;
                default: goto L1a;
            }
        L1a:
            goto L97
        L1c:
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L36
            goto L97
        L24:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L46
            goto L97
        L2c:
            java.lang.String r1 = "zh-tw"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L36
            goto L97
        L36:
            java.util.Locale r0 = new java.util.Locale
            r0.<init>(r2)
            goto L9e
        L3d:
            java.lang.String r1 = "zh-cn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L46
            goto L97
        L46:
            java.util.Locale r0 = new java.util.Locale
            r0.<init>(r3)
            goto L9e
        L4c:
            java.lang.String r1 = "ru"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L55
            goto L97
        L55:
            java.util.Locale r0 = new java.util.Locale
            r0.<init>(r1)
            goto L9e
        L5b:
            java.lang.String r1 = "ja"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L64
            goto L97
        L64:
            java.util.Locale r0 = new java.util.Locale
            r0.<init>(r1)
            goto L9e
        L6a:
            java.lang.String r1 = "fr"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L73
            goto L97
        L73:
            java.util.Locale r0 = new java.util.Locale
            r0.<init>(r1)
            goto L9e
        L79:
            java.lang.String r1 = "es"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L82
            goto L97
        L82:
            java.util.Locale r0 = new java.util.Locale
            r0.<init>(r1)
            goto L9e
        L88:
            java.lang.String r1 = "de"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L91
            goto L97
        L91:
            java.util.Locale r0 = new java.util.Locale
            r0.<init>(r1)
            goto L9e
        L97:
            java.util.Locale r0 = new java.util.Locale
            java.lang.String r1 = "en"
            r0.<init>(r1)
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoSettingsViewModel.getDefaultLocale():java.util.Locale");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r4.equals("zh-cn") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r4.equals("zh_cn") == false) goto L32;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String mapToSupportedLanguage(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            java.lang.String r1 = "zh_tw"
            java.lang.String r2 = "zh_cn"
            switch(r0) {
                case 3201: goto L52;
                case 3246: goto L49;
                case 3276: goto L40;
                case 3383: goto L37;
                case 3651: goto L2e;
                case 115814250: goto L23;
                case 115814786: goto L1a;
                case 115862300: goto L13;
                case 115862836: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L5a
        Lc:
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L5c
            goto L5a
        L13:
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L2c
            goto L5a
        L1a:
            java.lang.String r0 = "zh-tw"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L5c
            goto L5a
        L23:
            java.lang.String r0 = "zh-cn"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L2c
            goto L5a
        L2c:
            r1 = r2
            goto L5c
        L2e:
            java.lang.String r1 = "ru"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L5c
            goto L5a
        L37:
            java.lang.String r1 = "ja"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L5c
            goto L5a
        L40:
            java.lang.String r1 = "fr"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L5c
            goto L5a
        L49:
            java.lang.String r1 = "es"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L5c
            goto L5a
        L52:
            java.lang.String r1 = "de"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L5c
        L5a:
            java.lang.String r1 = "en"
        L5c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoSettingsViewModel.mapToSupportedLanguage(java.lang.String):java.lang.String");
    }
}
