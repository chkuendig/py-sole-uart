package com.android.prefs;

import com.android.prefs.LocationValue;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractAndroidLocations.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e¨\u0006!"}, d2 = {"Lcom/android/prefs/VariableValue;", "Lcom/android/prefs/LocationValue;", "propertyName", "", "type", "Lcom/android/prefs/VariableType;", "path", "Ljava/nio/file/Path;", "correctPath", "(Ljava/lang/String;Lcom/android/prefs/VariableType;Ljava/nio/file/Path;Ljava/nio/file/Path;)V", "getCorrectPath", "()Ljava/nio/file/Path;", "getPath", "getPropertyName", "()Ljava/lang/String;", "queryType", "getQueryType", "getType", "()Lcom/android/prefs/VariableType;", "value", "getValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
final /* data */ class VariableValue implements LocationValue {
    private final Path correctPath;
    private final Path path;
    private final String propertyName;
    private final VariableType type;

    public static /* synthetic */ VariableValue copy$default(VariableValue variableValue, String str, VariableType variableType, Path path, Path path2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = variableValue.getPropertyName();
        }
        if ((i & 2) != 0) {
            variableType = variableValue.type;
        }
        if ((i & 4) != 0) {
            path = variableValue.path;
        }
        if ((i & 8) != 0) {
            path2 = variableValue.correctPath;
        }
        return variableValue.copy(str, variableType, path, path2);
    }

    public final String component1() {
        return getPropertyName();
    }

    /* renamed from: component2, reason: from getter */
    public final VariableType getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final Path getPath() {
        return this.path;
    }

    /* renamed from: component4, reason: from getter */
    public final Path getCorrectPath() {
        return this.correctPath;
    }

    public final VariableValue copy(String propertyName, VariableType type, Path path, Path correctPath) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(correctPath, "correctPath");
        return new VariableValue(propertyName, type, path, correctPath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VariableValue)) {
            return false;
        }
        VariableValue variableValue = (VariableValue) other;
        return Intrinsics.areEqual(getPropertyName(), variableValue.getPropertyName()) && this.type == variableValue.type && Intrinsics.areEqual(this.path, variableValue.path) && Intrinsics.areEqual(this.correctPath, variableValue.correctPath);
    }

    public int hashCode() {
        return (((((getPropertyName().hashCode() * 31) + this.type.hashCode()) * 31) + this.path.hashCode()) * 31) + this.correctPath.hashCode();
    }

    public String toString() {
        return "VariableValue(propertyName=" + getPropertyName() + ", type=" + this.type + ", path=" + this.path + ", correctPath=" + this.correctPath + ')';
    }

    public VariableValue(String propertyName, VariableType type, Path path, Path correctPath) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(correctPath, "correctPath");
        this.propertyName = propertyName;
        this.type = type;
        this.path = path;
        this.correctPath = correctPath;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public int compareTo(LocationValue locationValue) {
        return LocationValue.DefaultImpls.compareTo(this, locationValue);
    }

    @Override // com.android.prefs.LocationValue
    public String getPropertyName() {
        return this.propertyName;
    }

    public final VariableType getType() {
        return this.type;
    }

    public final Path getPath() {
        return this.path;
    }

    public final Path getCorrectPath() {
        return this.correctPath;
    }

    @Override // com.android.prefs.LocationValue
    public String getQueryType() {
        return this.type.getDisplayName();
    }

    @Override // com.android.prefs.LocationValue
    public String getValue() {
        return this.path.toString();
    }
}
