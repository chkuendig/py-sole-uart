package com.soletreadmills.sole_v2._data.classes;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.soletreadmills.sole_v2._type.ClassType;
import com.sun.jna.platform.win32.WinNT;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesData.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0002\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001cJ\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010N\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00109J\u000b\u0010O\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u008a\u0002\u0010[\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\\J\u0013\u0010]\u001a\u00020\u00152\b\u0010^\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003J\u0006\u0010`\u001a\u00020\u0006J\r\u0010a\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010bJ\r\u0010c\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010bJ\t\u0010d\u001a\u00020eHÖ\u0001J\t\u0010f\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0013\u00102\u001a\u0004\u0018\u0001038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010 R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010:\u001a\u0004\b\u0014\u00109R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b\u0016\u00109\"\u0004\b;\u0010<R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u0010 R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bA\u0010 R\u0013\u0010B\u001a\u0004\u0018\u00010C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bF\u0010 ¨\u0006g"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "", "accessories", "", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesAccessoriesData;", "background_url", "", "class_id", "class_name", "class_type", "class_type_icon_url", "class_type_name", "collections", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionsData;", "description", "difficulty", "duration", "favorite_id", "instructor_avatar_url", "instructor_name", "is_done", "", "is_favorite", "music_genre", "publish_time_millis", "", "video_id", "workout_type", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getAccessories", "()Ljava/util/List;", "getBackground_url", "()Ljava/lang/String;", "classType", "Lcom/soletreadmills/sole_v2/_type/ClassType;", "getClassType", "()Lcom/soletreadmills/sole_v2/_type/ClassType;", "getClass_id", "getClass_name", "getClass_type", "getClass_type_icon_url", "getClass_type_name", "getCollections", "getDescription", "getDifficulty", "difficultyStr", "Lcom/soletreadmills/sole_v2/_data/classes/DifficultyType;", "getDifficultyStr", "()Lcom/soletreadmills/sole_v2/_data/classes/DifficultyType;", "getDuration", "durationStr", "Lcom/soletreadmills/sole_v2/_data/classes/DurationType;", "getDurationStr", "()Lcom/soletreadmills/sole_v2/_data/classes/DurationType;", "getFavorite_id", "getInstructor_avatar_url", "getInstructor_name", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "set_favorite", "(Ljava/lang/Boolean;)V", "getMusic_genre", "getPublish_time_millis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVideo_id", "workoutType", "Lcom/soletreadmills/sole_v2/_data/classes/ClassWorkoutType;", "getWorkoutType", "()Lcom/soletreadmills/sole_v2/_data/classes/ClassWorkoutType;", "getWorkout_type", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "equals", "other", "getCollectionData", "getDate", "getDumbbells", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getMusicStr", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ClassesData {
    public static final int $stable = 8;
    private final List<ClassesAccessoriesData> accessories;
    private final String background_url;
    private final String class_id;
    private final String class_name;
    private final String class_type;
    private final String class_type_icon_url;
    private final String class_type_name;
    private final List<ClassCollectionsData> collections;
    private final String description;
    private final String difficulty;
    private final String duration;
    private final String favorite_id;
    private final String instructor_avatar_url;
    private final String instructor_name;
    private final Boolean is_done;
    private Boolean is_favorite;
    private final String music_genre;
    private final Long publish_time_millis;
    private final String video_id;
    private final String workout_type;

    public ClassesData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, WinNT.NLS_VALID_LOCALE_MASK, null);
    }

    public final List<ClassesAccessoriesData> component1() {
        return this.accessories;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDifficulty() {
        return this.difficulty;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* renamed from: component12, reason: from getter */
    public final String getFavorite_id() {
        return this.favorite_id;
    }

    /* renamed from: component13, reason: from getter */
    public final String getInstructor_avatar_url() {
        return this.instructor_avatar_url;
    }

    /* renamed from: component14, reason: from getter */
    public final String getInstructor_name() {
        return this.instructor_name;
    }

    /* renamed from: component15, reason: from getter */
    public final Boolean getIs_done() {
        return this.is_done;
    }

    /* renamed from: component16, reason: from getter */
    public final Boolean getIs_favorite() {
        return this.is_favorite;
    }

    /* renamed from: component17, reason: from getter */
    public final String getMusic_genre() {
        return this.music_genre;
    }

    /* renamed from: component18, reason: from getter */
    public final Long getPublish_time_millis() {
        return this.publish_time_millis;
    }

    /* renamed from: component19, reason: from getter */
    public final String getVideo_id() {
        return this.video_id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBackground_url() {
        return this.background_url;
    }

    /* renamed from: component20, reason: from getter */
    public final String getWorkout_type() {
        return this.workout_type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClass_id() {
        return this.class_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getClass_name() {
        return this.class_name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getClass_type() {
        return this.class_type;
    }

    /* renamed from: component6, reason: from getter */
    public final String getClass_type_icon_url() {
        return this.class_type_icon_url;
    }

    /* renamed from: component7, reason: from getter */
    public final String getClass_type_name() {
        return this.class_type_name;
    }

    public final List<ClassCollectionsData> component8() {
        return this.collections;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final ClassesData copy(List<ClassesAccessoriesData> accessories, String background_url, String class_id, String class_name, String class_type, String class_type_icon_url, String class_type_name, List<ClassCollectionsData> collections, String description, String difficulty, String duration, String favorite_id, String instructor_avatar_url, String instructor_name, Boolean is_done, Boolean is_favorite, String music_genre, Long publish_time_millis, String video_id, String workout_type) {
        return new ClassesData(accessories, background_url, class_id, class_name, class_type, class_type_icon_url, class_type_name, collections, description, difficulty, duration, favorite_id, instructor_avatar_url, instructor_name, is_done, is_favorite, music_genre, publish_time_millis, video_id, workout_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassesData)) {
            return false;
        }
        ClassesData classesData = (ClassesData) other;
        return Intrinsics.areEqual(this.accessories, classesData.accessories) && Intrinsics.areEqual(this.background_url, classesData.background_url) && Intrinsics.areEqual(this.class_id, classesData.class_id) && Intrinsics.areEqual(this.class_name, classesData.class_name) && Intrinsics.areEqual(this.class_type, classesData.class_type) && Intrinsics.areEqual(this.class_type_icon_url, classesData.class_type_icon_url) && Intrinsics.areEqual(this.class_type_name, classesData.class_type_name) && Intrinsics.areEqual(this.collections, classesData.collections) && Intrinsics.areEqual(this.description, classesData.description) && Intrinsics.areEqual(this.difficulty, classesData.difficulty) && Intrinsics.areEqual(this.duration, classesData.duration) && Intrinsics.areEqual(this.favorite_id, classesData.favorite_id) && Intrinsics.areEqual(this.instructor_avatar_url, classesData.instructor_avatar_url) && Intrinsics.areEqual(this.instructor_name, classesData.instructor_name) && Intrinsics.areEqual(this.is_done, classesData.is_done) && Intrinsics.areEqual(this.is_favorite, classesData.is_favorite) && Intrinsics.areEqual(this.music_genre, classesData.music_genre) && Intrinsics.areEqual(this.publish_time_millis, classesData.publish_time_millis) && Intrinsics.areEqual(this.video_id, classesData.video_id) && Intrinsics.areEqual(this.workout_type, classesData.workout_type);
    }

    public int hashCode() {
        List<ClassesAccessoriesData> list = this.accessories;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.background_url;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.class_id;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.class_name;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.class_type;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.class_type_icon_url;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.class_type_name;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<ClassCollectionsData> list2 = this.collections;
        int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str7 = this.description;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.difficulty;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.duration;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.favorite_id;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.instructor_avatar_url;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.instructor_name;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Boolean bool = this.is_done;
        int iHashCode15 = (iHashCode14 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.is_favorite;
        int iHashCode16 = (iHashCode15 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str13 = this.music_genre;
        int iHashCode17 = (iHashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Long l = this.publish_time_millis;
        int iHashCode18 = (iHashCode17 + (l == null ? 0 : l.hashCode())) * 31;
        String str14 = this.video_id;
        int iHashCode19 = (iHashCode18 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.workout_type;
        return iHashCode19 + (str15 != null ? str15.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClassesData(accessories=");
        sb.append(this.accessories).append(", background_url=").append(this.background_url).append(", class_id=").append(this.class_id).append(", class_name=").append(this.class_name).append(", class_type=").append(this.class_type).append(", class_type_icon_url=").append(this.class_type_icon_url).append(", class_type_name=").append(this.class_type_name).append(", collections=").append(this.collections).append(", description=").append(this.description).append(", difficulty=").append(this.difficulty).append(", duration=").append(this.duration).append(", favorite_id=");
        sb.append(this.favorite_id).append(", instructor_avatar_url=").append(this.instructor_avatar_url).append(", instructor_name=").append(this.instructor_name).append(", is_done=").append(this.is_done).append(", is_favorite=").append(this.is_favorite).append(", music_genre=").append(this.music_genre).append(", publish_time_millis=").append(this.publish_time_millis).append(", video_id=").append(this.video_id).append(", workout_type=").append(this.workout_type).append(')');
        return sb.toString();
    }

    public ClassesData(List<ClassesAccessoriesData> list, String str, String str2, String str3, String str4, String str5, String str6, List<ClassCollectionsData> list2, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool, Boolean bool2, String str13, Long l, String str14, String str15) {
        this.accessories = list;
        this.background_url = str;
        this.class_id = str2;
        this.class_name = str3;
        this.class_type = str4;
        this.class_type_icon_url = str5;
        this.class_type_name = str6;
        this.collections = list2;
        this.description = str7;
        this.difficulty = str8;
        this.duration = str9;
        this.favorite_id = str10;
        this.instructor_avatar_url = str11;
        this.instructor_name = str12;
        this.is_done = bool;
        this.is_favorite = bool2;
        this.music_genre = str13;
        this.publish_time_millis = l;
        this.video_id = str14;
        this.workout_type = str15;
    }

    public /* synthetic */ ClassesData(List list, String str, String str2, String str3, String str4, String str5, String str6, List list2, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool, Boolean bool2, String str13, Long l, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : bool, (i & 32768) != 0 ? null : bool2, (i & 65536) != 0 ? null : str13, (i & 131072) != 0 ? null : l, (i & 262144) != 0 ? null : str14, (i & 524288) != 0 ? null : str15);
    }

    public final List<ClassesAccessoriesData> getAccessories() {
        return this.accessories;
    }

    public final String getBackground_url() {
        return this.background_url;
    }

    public final String getClass_id() {
        return this.class_id;
    }

    public final String getClass_name() {
        return this.class_name;
    }

    public final String getClass_type() {
        return this.class_type;
    }

    public final String getClass_type_icon_url() {
        return this.class_type_icon_url;
    }

    public final String getClass_type_name() {
        return this.class_type_name;
    }

    public final List<ClassCollectionsData> getCollections() {
        return this.collections;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDifficulty() {
        return this.difficulty;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getFavorite_id() {
        return this.favorite_id;
    }

    public final String getInstructor_avatar_url() {
        return this.instructor_avatar_url;
    }

    public final String getInstructor_name() {
        return this.instructor_name;
    }

    public final Boolean is_done() {
        return this.is_done;
    }

    public final Boolean is_favorite() {
        return this.is_favorite;
    }

    public final void set_favorite(Boolean bool) {
        this.is_favorite = bool;
    }

    public final String getMusic_genre() {
        return this.music_genre;
    }

    public final Long getPublish_time_millis() {
        return this.publish_time_millis;
    }

    public final String getVideo_id() {
        return this.video_id;
    }

    public final String getWorkout_type() {
        return this.workout_type;
    }

    public final ClassType getClassType() {
        return ClassType.INSTANCE.fromRaw(this.class_type);
    }

    public final DurationType getDurationStr() {
        return DurationType.INSTANCE.fromRaw(this.duration);
    }

    public final DifficultyType getDifficultyStr() {
        return DifficultyType.INSTANCE.fromRaw(this.difficulty);
    }

    public final ClassWorkoutType getWorkoutType() {
        return ClassWorkoutType.INSTANCE.fromRaw(this.workout_type);
    }

    public final String getMusicStr(Composer composer, int i) {
        composer.startReplaceGroup(1578753121);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1578753121, i, -1, "com.soletreadmills.sole_v2._data.classes.ClassesData.getMusicStr (ClassesData.kt:189)");
        }
        String str = this.music_genre;
        String str2 = (str == null || str.length() == 0) ? "—" : "music_" + this.music_genre;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return str2;
    }

    public final String getDate() {
        String yMDFormat;
        Long l = this.publish_time_millis;
        return (l == null || (yMDFormat = ClassesDataKt.toYMDFormat(l.longValue())) == null) ? "—" : yMDFormat;
    }

    public final List<ClassCollectionsData> getCollectionData() {
        List<ClassCollectionsData> list = this.collections;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.collections;
    }

    public final String getDumbbells(Composer composer, int i) {
        composer.startReplaceGroup(-1084710125);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1084710125, i, -1, "com.soletreadmills.sole_v2._data.classes.ClassesData.getDumbbells (ClassesData.kt:203)");
        }
        List<ClassesAccessoriesData> list = this.accessories;
        ArrayList arrayListEmptyList = null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (ClassesAccessoriesData classesAccessoriesData : list) {
                Integer amount = classesAccessoriesData.getAmount();
                DumbbellsLevelType weight_level = classesAccessoriesData.getWeight_level();
                String title = weight_level != null ? weight_level.getTitle() : null;
                String str = (amount == null || title == null) ? null : amount + ' ' + title;
                if (str != null) {
                    arrayList.add(str);
                }
            }
            arrayListEmptyList = arrayList;
        }
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        String strJoinToString$default = arrayListEmptyList.isEmpty() ? "—" : CollectionsKt.joinToString$default(arrayListEmptyList, "\n", null, null, 0, null, null, 62, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return strJoinToString$default;
    }
}
