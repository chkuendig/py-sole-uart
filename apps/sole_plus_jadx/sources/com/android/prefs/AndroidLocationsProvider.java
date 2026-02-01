package com.android.prefs;

import java.nio.file.Path;
import kotlin.Metadata;

/* compiled from: AndroidLocationsProvider.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038fX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/android/prefs/AndroidLocationsProvider;", "", "avdLocation", "Ljava/nio/file/Path;", "getAvdLocation", "()Ljava/nio/file/Path;", "gradleAvdLocation", "getGradleAvdLocation", "prefsLocation", "getPrefsLocation", "userHomeLocation", "getUserHomeLocation", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface AndroidLocationsProvider {
    Path getAvdLocation() throws AndroidLocationsException;

    Path getGradleAvdLocation() throws AndroidLocationsException;

    Path getPrefsLocation() throws AndroidLocationsException;

    Path getUserHomeLocation();
}
