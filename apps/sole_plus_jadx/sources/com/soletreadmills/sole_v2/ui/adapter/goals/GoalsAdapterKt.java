package com.soletreadmills.sole_v2.ui.adapter.goals;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.goal.GoalsStatsType;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoalsAdapter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"getGoalsColors", "Lkotlin/Triple;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "userGoalStatsType", "(Landroid/content/Context;Ljava/lang/Integer;)Lkotlin/Triple;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsAdapterKt {
    public static final Triple<Integer, Integer, Integer> getGoalsColors(Context context, Integer num) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        int id2 = GoalsStatsType.TotalDistance.getId();
        if (num != null && num.intValue() == id2) {
            i = R.color.colorStats_distance;
            i2 = R.color.colorStats_distance25;
            i3 = R.color.colorStats_distance16;
        } else {
            int id3 = GoalsStatsType.ActiveMinutes.getId();
            if (num != null && num.intValue() == id3) {
                i = R.color.colorStats_time;
                i2 = R.color.colorStats_time25;
                i3 = R.color.colorStats_time16;
            } else {
                int id4 = GoalsStatsType.WorkoutCounts.getId();
                if (num != null && num.intValue() == id4) {
                    i = R.color.colorStats_speed;
                    i2 = R.color.colorStats_speed25;
                    i3 = R.color.colorStats_speed16;
                } else {
                    int id5 = GoalsStatsType.TotalCalories.getId();
                    if (num != null && num.intValue() == id5) {
                        i = R.color.colorStats_calories;
                        i2 = R.color.colorStats_calories25;
                        i3 = R.color.colorStats_calories16;
                    } else {
                        int id6 = GoalsStatsType.TotalStrokes.getId();
                        if (num != null && num.intValue() == id6) {
                            i = R.color.colorStats_count;
                            i2 = R.color.colorStats_count25;
                            i3 = R.color.colorStats_count16;
                        } else {
                            int id7 = GoalsStatsType.TotalSteps.getId();
                            if (num != null && num.intValue() == id7) {
                                i = R.color.colorStats_count;
                                i2 = R.color.colorStats_count25;
                                i3 = R.color.colorStats_count16;
                            } else {
                                i = R.color.colorStats_speed;
                                i2 = R.color.colorStats_speed25;
                                i3 = R.color.colorStats_speed16;
                            }
                        }
                    }
                }
            }
        }
        return new Triple<>(Integer.valueOf(ContextCompat.getColor(context, i)), Integer.valueOf(ContextCompat.getColor(context, i2)), Integer.valueOf(ContextCompat.getColor(context, i3)));
    }
}
