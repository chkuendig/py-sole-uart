package com.ua.sdk.recorder;

import com.ua.sdk.workout.Workout;
import com.ua.sdk.workout.WorkoutNameGenerator;

/* loaded from: classes2.dex */
public interface RecorderWorkoutConverter {
    Workout generateWorkout(WorkoutNameGenerator workoutNameGenerator);

    Workout generateWorkout(String str);
}
