package com.android.prefs;

import com.android.prefs.LocationValue;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractAndroidLocations.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/android/prefs/QueryResult;", "Lcom/android/prefs/LocationValue;", "global", "Lcom/android/prefs/Global;", "type", "Lcom/android/prefs/VariableType;", "path", "Ljava/nio/file/Path;", "(Lcom/android/prefs/Global;Lcom/android/prefs/VariableType;Ljava/nio/file/Path;)V", "getGlobal", "()Lcom/android/prefs/Global;", "getPath", "()Ljava/nio/file/Path;", "propertyName", "", "getPropertyName", "()Ljava/lang/String;", "queryType", "getQueryType", "getType", "()Lcom/android/prefs/VariableType;", "value", "getValue", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
final /* data */ class QueryResult implements LocationValue {
    private final Global global;
    private final Path path;
    private final VariableType type;

    public static /* synthetic */ QueryResult copy$default(QueryResult queryResult, Global global, VariableType variableType, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            global = queryResult.global;
        }
        if ((i & 2) != 0) {
            variableType = queryResult.type;
        }
        if ((i & 4) != 0) {
            path = queryResult.path;
        }
        return queryResult.copy(global, variableType, path);
    }

    /* renamed from: component1, reason: from getter */
    public final Global getGlobal() {
        return this.global;
    }

    /* renamed from: component2, reason: from getter */
    public final VariableType getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final Path getPath() {
        return this.path;
    }

    public final QueryResult copy(Global global, VariableType type, Path path) {
        Intrinsics.checkNotNullParameter(global, "global");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        return new QueryResult(global, type, path);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryResult)) {
            return false;
        }
        QueryResult queryResult = (QueryResult) other;
        return this.global == queryResult.global && this.type == queryResult.type && Intrinsics.areEqual(this.path, queryResult.path);
    }

    public int hashCode() {
        return (((this.global.hashCode() * 31) + this.type.hashCode()) * 31) + this.path.hashCode();
    }

    public String toString() {
        return "QueryResult(global=" + this.global + ", type=" + this.type + ", path=" + this.path + ')';
    }

    public QueryResult(Global global, VariableType type, Path path) {
        Intrinsics.checkNotNullParameter(global, "global");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        this.global = global;
        this.type = type;
        this.path = path;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public int compareTo(LocationValue locationValue) {
        return LocationValue.DefaultImpls.compareTo(this, locationValue);
    }

    public final Global getGlobal() {
        return this.global;
    }

    public final VariableType getType() {
        return this.type;
    }

    public final Path getPath() {
        return this.path;
    }

    @Override // com.android.prefs.LocationValue
    public String getPropertyName() {
        return this.global.getPropName();
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
