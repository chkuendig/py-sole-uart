package androidx.health.connect.client.records;

import androidx.health.connect.client.records.metadata.DeviceTypes;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: MealType.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/health/connect/client/records/MealType;", "", "()V", "BREAKFAST", "", "DINNER", "LUNCH", "MEAL_TYPE_BREAKFAST", "", "MEAL_TYPE_DINNER", "MEAL_TYPE_INT_TO_STRING_MAP", "", "MEAL_TYPE_LUNCH", "MEAL_TYPE_SNACK", "MEAL_TYPE_STRING_TO_INT_MAP", "MEAL_TYPE_UNKNOWN", "SNACK", DeviceTypes.UNKNOWN, "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MealType {
    public static final String BREAKFAST = "breakfast";
    public static final String DINNER = "dinner";
    public static final MealType INSTANCE = new MealType();
    public static final String LUNCH = "lunch";
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final Map<Integer, String> MEAL_TYPE_INT_TO_STRING_MAP;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final Map<String, Integer> MEAL_TYPE_STRING_TO_INT_MAP;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String SNACK = "snack";
    public static final String UNKNOWN = "unknown";

    private MealType() {
    }

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("unknown", 0), TuplesKt.to(BREAKFAST, 1), TuplesKt.to(LUNCH, 2), TuplesKt.to(DINNER, 3), TuplesKt.to(SNACK, 4));
        MEAL_TYPE_STRING_TO_INT_MAP = mapMapOf;
        MEAL_TYPE_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
    }
}
