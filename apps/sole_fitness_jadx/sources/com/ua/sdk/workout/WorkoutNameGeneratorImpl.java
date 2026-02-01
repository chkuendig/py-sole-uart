package com.ua.sdk.workout;

import android.content.Context;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutNameGeneratorImpl implements WorkoutNameGenerator {
    @Override // com.ua.sdk.workout.WorkoutNameGenerator
    public String generateName(User user, ActivityType activityType, Context context, Date date, Double d) throws NullPointerException {
        Precondition.isNotNull(activityType, "activity type");
        return activityType.getName();
    }
}
