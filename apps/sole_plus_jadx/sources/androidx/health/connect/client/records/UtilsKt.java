package androidx.health.connect.client.records;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.healthdata.HealthConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a9\u0010\u0007\u001a\u00020\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b2\u0006\u0010\n\u001a\u0002H\b2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\f\u001a1\u0010\r\u001a\u00020\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b2\u0006\u0010\u000e\u001a\u0002H\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u000f\u001a1\u0010\u0010\u001a\u00020\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b2\u0006\u0010\u000e\u001a\u0002H\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u000f\u001a$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012H\u0000¨\u0006\u0014"}, d2 = {"requireNonNegative", "", "value", "", "name", "", "", "requireInRange", ExifInterface.GPS_DIRECTION_TRUE, "", HealthConstants.HeartRate.MIN, "max", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/String;)V", "requireNotLess", "other", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/String;)V", "requireNotMore", "reverse", "", "", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UtilsKt {
    public static final <T extends Comparable<? super T>> void requireNotLess(T t, T other, String name) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(name, "name");
        if (t.compareTo(other) < 0) {
            throw new IllegalArgumentException((name + " must not be less than " + other + ", currently " + t + '.').toString());
        }
    }

    public static final <T extends Comparable<? super T>> void requireNotMore(T t, T other, String name) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(name, "name");
        if (t.compareTo(other) > 0) {
            throw new IllegalArgumentException((name + " must not be more than " + other + ", currently " + t + '.').toString());
        }
    }

    public static final void requireNonNegative(long j, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (j < 0) {
            throw new IllegalArgumentException((name + " must not be negative").toString());
        }
    }

    public static final void requireNonNegative(double d, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (d < AudioStats.AUDIO_AMPLITUDE_NONE) {
            throw new IllegalArgumentException((name + " must not be negative").toString());
        }
    }

    public static final Map<Integer, String> reverse(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Set<Map.Entry<String, Integer>> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
        }
        return linkedHashMap;
    }

    public static final <T extends Comparable<? super T>> void requireInRange(T t, T min, T max, String name) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(min, "min");
        Intrinsics.checkNotNullParameter(max, "max");
        Intrinsics.checkNotNullParameter(name, "name");
        requireNotLess(t, min, name);
        requireNotMore(t, max, name);
    }
}
