package com.soletreadmills.sole_v2._type;

import androidx.exifinterface.media.ExifInterface;
import com.soletreadmills.sole_v2._data.classes.CollectionActivityData;
import com.soletreadmills.sole_v2._data.classes.SessionActivityData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ActivityType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ActivityType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "TREADMILL", "CYCLING", "ELLIPTICAL", "ROWING", "SRVO", "FULL_SWEAT", "BOXING", "SCULPT", "STRETCHING", "YOGA", "MEDITATION", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActivityType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final ActivityType TREADMILL = new ActivityType("TREADMILL", 0, ExifInterface.GPS_DIRECTION_TRUE);
    public static final ActivityType CYCLING = new ActivityType("CYCLING", 1, "CY");
    public static final ActivityType ELLIPTICAL = new ActivityType("ELLIPTICAL", 2, "ELP");
    public static final ActivityType ROWING = new ActivityType("ROWING", 3, "RW");
    public static final ActivityType SRVO = new ActivityType("SRVO", 4, "SV");
    public static final ActivityType FULL_SWEAT = new ActivityType("FULL_SWEAT", 5, "FS");
    public static final ActivityType BOXING = new ActivityType("BOXING", 6, "BX");
    public static final ActivityType SCULPT = new ActivityType("SCULPT", 7, ExifInterface.LATITUDE_SOUTH);
    public static final ActivityType STRETCHING = new ActivityType("STRETCHING", 8, "ST");
    public static final ActivityType YOGA = new ActivityType("YOGA", 9, "YO");
    public static final ActivityType MEDITATION = new ActivityType("MEDITATION", 10, "M");

    private static final /* synthetic */ ActivityType[] $values() {
        return new ActivityType[]{TREADMILL, CYCLING, ELLIPTICAL, ROWING, SRVO, FULL_SWEAT, BOXING, SCULPT, STRETCHING, YOGA, MEDITATION};
    }

    public static EnumEntries<ActivityType> getEntries() {
        return $ENTRIES;
    }

    public static ActivityType valueOf(String str) {
        return (ActivityType) Enum.valueOf(ActivityType.class, str);
    }

    public static ActivityType[] values() {
        return (ActivityType[]) $VALUES.clone();
    }

    private ActivityType(String str, int i, String str2) {
        this.rawValue = str2;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    static {
        ActivityType[] activityTypeArr$values = $values();
        $VALUES = activityTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(activityTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ActivityType.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ActivityType$Companion;", "", "()V", "getAllCollectionActivityData", "", "Lcom/soletreadmills/sole_v2/_data/classes/CollectionActivityData;", "getAllRawValues", "", "", "getAllSessionActivityData", "Lcom/soletreadmills/sole_v2/_data/classes/SessionActivityData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<SessionActivityData> getAllSessionActivityData() {
            ActivityType[] activityTypeArrValues = ActivityType.values();
            ArrayList arrayList = new ArrayList(activityTypeArrValues.length);
            for (ActivityType activityType : activityTypeArrValues) {
                arrayList.add(new SessionActivityData(activityType, false));
            }
            return CollectionsKt.toMutableList((Collection) arrayList);
        }

        public final List<CollectionActivityData> getAllCollectionActivityData() {
            ActivityType[] activityTypeArrValues = ActivityType.values();
            ArrayList arrayList = new ArrayList(activityTypeArrValues.length);
            for (ActivityType activityType : activityTypeArrValues) {
                arrayList.add(new CollectionActivityData(activityType, false));
            }
            return CollectionsKt.toMutableList((Collection) arrayList);
        }

        public final List<String> getAllRawValues() {
            ActivityType[] activityTypeArrValues = ActivityType.values();
            ArrayList arrayList = new ArrayList(activityTypeArrValues.length);
            for (ActivityType activityType : activityTypeArrValues) {
                arrayList.add(activityType.getRawValue());
            }
            return arrayList;
        }
    }
}
