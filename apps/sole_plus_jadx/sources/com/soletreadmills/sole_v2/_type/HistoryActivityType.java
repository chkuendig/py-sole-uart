package com.soletreadmills.sole_v2._type;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.sun.jna.platform.win32.WinError;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HistoryActivityType.kt */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0003\b\u0086\u0001\b\u0086\u0081\u0002\u0018\u0000 \u0099\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0099\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000J\u001f\u0010\u0013\u001a\u00020\b2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0014\"\u00020\u0000¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bxj\u0002\byj\u0002\bzj\u0002\b{j\u0002\b|j\u0002\b}j\u0002\b~j\u0002\b\u007fj\u0003\b\u0080\u0001j\u0003\b\u0081\u0001j\u0003\b\u0082\u0001j\u0003\b\u0083\u0001j\u0003\b\u0084\u0001j\u0003\b\u0085\u0001j\u0003\b\u0086\u0001j\u0003\b\u0087\u0001j\u0003\b\u0088\u0001j\u0003\b\u0089\u0001j\u0003\b\u008a\u0001j\u0003\b\u008b\u0001j\u0003\b\u008c\u0001j\u0003\b\u008d\u0001j\u0003\b\u008e\u0001j\u0003\b\u008f\u0001j\u0003\b\u0090\u0001j\u0003\b\u0091\u0001j\u0003\b\u0092\u0001j\u0003\b\u0093\u0001j\u0003\b\u0094\u0001j\u0003\b\u0095\u0001j\u0003\b\u0096\u0001j\u0003\b\u0097\u0001j\u0003\b\u0098\u0001¨\u0006\u009a\u0001"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "isLeafNode", "", "()Z", SdkConstants.ATTR_PARENT, "getParent", "()Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "getTitle", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "isInActivityType", "ascendantOrSelf", "isInAnyActivityTypes", "", "([Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;)Z", "ALL", DebugCoroutineInfoImplKt.RUNNING, "CYCLING", "ROWING", "ELLIPTICAL", "STRENGTH_AND_FUNCTION", "STRETCH_AND_RECOVERY", "WALKING_AND_HIKING", "STAIR_CLIMBING", "OTHER", "SPORTS", "SKATING_AND_SKIING", "OUTDOOR_LEISURE", "SWIMMING", "DANCE", "JUMP_ROPE", "EBIKING", "INDOOR_CYCLING", "OUTDOOR_CYCLING", "INDOOR_ROWING", "OPEN_WATER_ROWING", "INDOOR_RUNNING", "OUTDOOR_RUNNING", "SPECIAL_RUNNING", "FUNCTIONAL_TRAINING", "STRENGTH_TRAINING", "MINDFULLNESS", "HIKING", "WALKING", "BOARD_RIDING", "EXPLORATION", "PADDLING", "SKATING", "SKIING", "SNOWBOARDING", "COMBAT", "PRECISION_SPORTS", "RACKET_SPORTS", "TEAM_SPORTS", "OPEN_WATER_SWIMMING", "POOL_SWIMMING", "TREADMILL_RUNNING", "ROAD_BIKING", "YOGA", "STRETCHING", "TRAIL_RUNNING", "GOLF", "MOUNTAIN_BIKING", "HIIT", "PILATES", "GRAVEL_CYCLING", "BREATHWORK", "CROSS_COUNTRY_SKIING_WS", "VIRTUAL_RIDE", "RESORT_SKIING", "TRACK_RUNNING", "MULTI_SPORT", "TENNIS", "VIRTUAL_RUN", "STAND_UP_PADDLEBOARDING", "MEDITATION", "PICKLEBALL", "KAYAKING", "PADDELBALL", "SKATE_SKIING_WS", "E_BIKE_MOUNTAIN", "SOCCER", "MIXED_MARTIAL_ARTS", "BADMINTON", "BASKETBALL", "CYCLOCROSS", "BACKCOUNTRY_SKIING", "BOXING", "INDOOR_CLIMBING", "RESORT_SNOWBOARDING", "FLOOR_CLIMBING", "RECUMBENT_CYCLING", "BOATING", "DISC_GOLF", "BOULDERING", "ULTRA_RUN", "ICE_HOCKEY", "SPEED_WALKING", "VOLLEYBALL", "TABLE_TENNIS", "KITEBOARDING", "CASUAL_WALKING", "INLINE_SKATING", "SQUASH", "SKATING_WS", "SNOW_SHOE_WS", "FISHING", "SURFING", "RUCKING", "SOFTBALL", "SAILING", "AMERICAN_FOOTBALL", "RACQUETBALL", "WINDSURFING", "FIELD_HOCKEY", "SNORKELING", "STREET_RUNNING", "SNOWMOBILING_WS", "HUNTING", "ENDURO_MTB", "OBSTACLE_RUN", "RUGBY", "WAKEBOARDING", "BASEBALL", "ROCK_CLIMBING", "WHITEWATER_RAFTING", "ULTIMATE_DISC", "WAKESURFING", "WATER_TUBING", "BMX", "ARCHERY", "WATERSKIING", "BACKCOUNTRY_SNOWBOARDING", "CRICKET", "WATER_SPORTS", "WINTER_SPORTS", "PLATFORM_TENNIS", "DOWNHILL_BIKING", "LACROSSE", "WHEELCHAIR_PUSH_RUN", "WHEELCHAIR_PUSH_WALK", "TRACK_CYCLING", "CARDIO_WORKOUT", "FULL_SWEAT", "SCULPT", "UNDEFINED", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryActivityType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HistoryActivityType[] $VALUES;
    public static final HistoryActivityType ALL = new HistoryActivityType("ALL", 0, 0);
    public static final HistoryActivityType AMERICAN_FOOTBALL;
    public static final HistoryActivityType ARCHERY;
    public static final HistoryActivityType BACKCOUNTRY_SKIING;
    public static final HistoryActivityType BACKCOUNTRY_SNOWBOARDING;
    public static final HistoryActivityType BADMINTON;
    public static final HistoryActivityType BASEBALL;
    public static final HistoryActivityType BASKETBALL;
    public static final HistoryActivityType BMX;
    public static final HistoryActivityType BOARD_RIDING;
    public static final HistoryActivityType BOATING;
    public static final HistoryActivityType BOULDERING;
    public static final HistoryActivityType BOXING;
    public static final HistoryActivityType BREATHWORK;
    public static final HistoryActivityType CARDIO_WORKOUT;
    public static final HistoryActivityType CASUAL_WALKING;
    public static final HistoryActivityType COMBAT;
    public static final HistoryActivityType CRICKET;
    public static final HistoryActivityType CROSS_COUNTRY_SKIING_WS;
    public static final HistoryActivityType CYCLING;
    public static final HistoryActivityType CYCLOCROSS;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final HistoryActivityType DANCE;
    public static final HistoryActivityType DISC_GOLF;
    public static final HistoryActivityType DOWNHILL_BIKING;
    public static final HistoryActivityType EBIKING;
    public static final HistoryActivityType ELLIPTICAL;
    public static final HistoryActivityType ENDURO_MTB;
    public static final HistoryActivityType EXPLORATION;
    public static final HistoryActivityType E_BIKE_MOUNTAIN;
    public static final HistoryActivityType FIELD_HOCKEY;
    public static final HistoryActivityType FISHING;
    public static final HistoryActivityType FLOOR_CLIMBING;
    public static final HistoryActivityType FULL_SWEAT;
    public static final HistoryActivityType FUNCTIONAL_TRAINING;
    public static final HistoryActivityType GOLF;
    public static final HistoryActivityType GRAVEL_CYCLING;
    public static final HistoryActivityType HIIT;
    public static final HistoryActivityType HIKING;
    public static final HistoryActivityType HUNTING;
    public static final HistoryActivityType ICE_HOCKEY;
    public static final HistoryActivityType INDOOR_CLIMBING;
    public static final HistoryActivityType INDOOR_CYCLING;
    public static final HistoryActivityType INDOOR_ROWING;
    public static final HistoryActivityType INDOOR_RUNNING;
    public static final HistoryActivityType INLINE_SKATING;
    public static final HistoryActivityType JUMP_ROPE;
    public static final HistoryActivityType KAYAKING;
    public static final HistoryActivityType KITEBOARDING;
    public static final HistoryActivityType LACROSSE;
    public static final HistoryActivityType MEDITATION;
    public static final HistoryActivityType MINDFULLNESS;
    public static final HistoryActivityType MIXED_MARTIAL_ARTS;
    public static final HistoryActivityType MOUNTAIN_BIKING;
    public static final HistoryActivityType MULTI_SPORT;
    public static final HistoryActivityType OBSTACLE_RUN;
    public static final HistoryActivityType OPEN_WATER_ROWING;
    public static final HistoryActivityType OPEN_WATER_SWIMMING;
    public static final HistoryActivityType OTHER;
    public static final HistoryActivityType OUTDOOR_CYCLING;
    public static final HistoryActivityType OUTDOOR_LEISURE;
    public static final HistoryActivityType OUTDOOR_RUNNING;
    public static final HistoryActivityType PADDELBALL;
    public static final HistoryActivityType PADDLING;
    public static final HistoryActivityType PICKLEBALL;
    public static final HistoryActivityType PILATES;
    public static final HistoryActivityType PLATFORM_TENNIS;
    public static final HistoryActivityType POOL_SWIMMING;
    public static final HistoryActivityType PRECISION_SPORTS;
    public static final HistoryActivityType RACKET_SPORTS;
    public static final HistoryActivityType RACQUETBALL;
    public static final HistoryActivityType RECUMBENT_CYCLING;
    public static final HistoryActivityType RESORT_SKIING;
    public static final HistoryActivityType RESORT_SNOWBOARDING;
    public static final HistoryActivityType ROAD_BIKING;
    public static final HistoryActivityType ROCK_CLIMBING;
    public static final HistoryActivityType ROWING;
    public static final HistoryActivityType RUCKING;
    public static final HistoryActivityType RUGBY;
    public static final HistoryActivityType RUNNING;
    public static final HistoryActivityType SAILING;
    public static final HistoryActivityType SCULPT;
    public static final HistoryActivityType SKATE_SKIING_WS;
    public static final HistoryActivityType SKATING;
    public static final HistoryActivityType SKATING_AND_SKIING;
    public static final HistoryActivityType SKATING_WS;
    public static final HistoryActivityType SKIING;
    public static final HistoryActivityType SNORKELING;
    public static final HistoryActivityType SNOWBOARDING;
    public static final HistoryActivityType SNOWMOBILING_WS;
    public static final HistoryActivityType SNOW_SHOE_WS;
    public static final HistoryActivityType SOCCER;
    public static final HistoryActivityType SOFTBALL;
    public static final HistoryActivityType SPECIAL_RUNNING;
    public static final HistoryActivityType SPEED_WALKING;
    public static final HistoryActivityType SPORTS;
    public static final HistoryActivityType SQUASH;
    public static final HistoryActivityType STAIR_CLIMBING;
    public static final HistoryActivityType STAND_UP_PADDLEBOARDING;
    public static final HistoryActivityType STREET_RUNNING;
    public static final HistoryActivityType STRENGTH_AND_FUNCTION;
    public static final HistoryActivityType STRENGTH_TRAINING;
    public static final HistoryActivityType STRETCHING;
    public static final HistoryActivityType STRETCH_AND_RECOVERY;
    public static final HistoryActivityType SURFING;
    public static final HistoryActivityType SWIMMING;
    public static final HistoryActivityType TABLE_TENNIS;
    public static final HistoryActivityType TEAM_SPORTS;
    public static final HistoryActivityType TENNIS;
    public static final HistoryActivityType TRACK_CYCLING;
    public static final HistoryActivityType TRACK_RUNNING;
    public static final HistoryActivityType TRAIL_RUNNING;
    public static final HistoryActivityType TREADMILL_RUNNING;
    public static final HistoryActivityType ULTIMATE_DISC;
    public static final HistoryActivityType ULTRA_RUN;
    public static final HistoryActivityType UNDEFINED;
    public static final HistoryActivityType VIRTUAL_RIDE;
    public static final HistoryActivityType VIRTUAL_RUN;
    public static final HistoryActivityType VOLLEYBALL;
    public static final HistoryActivityType WAKEBOARDING;
    public static final HistoryActivityType WAKESURFING;
    public static final HistoryActivityType WALKING;
    public static final HistoryActivityType WALKING_AND_HIKING;
    public static final HistoryActivityType WATERSKIING;
    public static final HistoryActivityType WATER_SPORTS;
    public static final HistoryActivityType WATER_TUBING;
    public static final HistoryActivityType WHEELCHAIR_PUSH_RUN;
    public static final HistoryActivityType WHEELCHAIR_PUSH_WALK;
    public static final HistoryActivityType WHITEWATER_RAFTING;
    public static final HistoryActivityType WINDSURFING;
    public static final HistoryActivityType WINTER_SPORTS;
    public static final HistoryActivityType YOGA;
    private static final Map<HistoryActivityType, HistoryActivityType> parentOf;
    private final int code;

    /* compiled from: HistoryActivityType.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HistoryActivityType.values().length];
            try {
                iArr[HistoryActivityType.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HistoryActivityType.CYCLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HistoryActivityType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HistoryActivityType.STAIR_CLIMBING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HistoryActivityType.ROWING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HistoryActivityType.STRENGTH_AND_FUNCTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HistoryActivityType.STRETCH_AND_RECOVERY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[HistoryActivityType.WALKING_AND_HIKING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[HistoryActivityType.ALL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ HistoryActivityType[] $values() {
        return new HistoryActivityType[]{ALL, RUNNING, CYCLING, ROWING, ELLIPTICAL, STRENGTH_AND_FUNCTION, STRETCH_AND_RECOVERY, WALKING_AND_HIKING, STAIR_CLIMBING, OTHER, SPORTS, SKATING_AND_SKIING, OUTDOOR_LEISURE, SWIMMING, DANCE, JUMP_ROPE, EBIKING, INDOOR_CYCLING, OUTDOOR_CYCLING, INDOOR_ROWING, OPEN_WATER_ROWING, INDOOR_RUNNING, OUTDOOR_RUNNING, SPECIAL_RUNNING, FUNCTIONAL_TRAINING, STRENGTH_TRAINING, MINDFULLNESS, HIKING, WALKING, BOARD_RIDING, EXPLORATION, PADDLING, SKATING, SKIING, SNOWBOARDING, COMBAT, PRECISION_SPORTS, RACKET_SPORTS, TEAM_SPORTS, OPEN_WATER_SWIMMING, POOL_SWIMMING, TREADMILL_RUNNING, ROAD_BIKING, YOGA, STRETCHING, TRAIL_RUNNING, GOLF, MOUNTAIN_BIKING, HIIT, PILATES, GRAVEL_CYCLING, BREATHWORK, CROSS_COUNTRY_SKIING_WS, VIRTUAL_RIDE, RESORT_SKIING, TRACK_RUNNING, MULTI_SPORT, TENNIS, VIRTUAL_RUN, STAND_UP_PADDLEBOARDING, MEDITATION, PICKLEBALL, KAYAKING, PADDELBALL, SKATE_SKIING_WS, E_BIKE_MOUNTAIN, SOCCER, MIXED_MARTIAL_ARTS, BADMINTON, BASKETBALL, CYCLOCROSS, BACKCOUNTRY_SKIING, BOXING, INDOOR_CLIMBING, RESORT_SNOWBOARDING, FLOOR_CLIMBING, RECUMBENT_CYCLING, BOATING, DISC_GOLF, BOULDERING, ULTRA_RUN, ICE_HOCKEY, SPEED_WALKING, VOLLEYBALL, TABLE_TENNIS, KITEBOARDING, CASUAL_WALKING, INLINE_SKATING, SQUASH, SKATING_WS, SNOW_SHOE_WS, FISHING, SURFING, RUCKING, SOFTBALL, SAILING, AMERICAN_FOOTBALL, RACQUETBALL, WINDSURFING, FIELD_HOCKEY, SNORKELING, STREET_RUNNING, SNOWMOBILING_WS, HUNTING, ENDURO_MTB, OBSTACLE_RUN, RUGBY, WAKEBOARDING, BASEBALL, ROCK_CLIMBING, WHITEWATER_RAFTING, ULTIMATE_DISC, WAKESURFING, WATER_TUBING, BMX, ARCHERY, WATERSKIING, BACKCOUNTRY_SNOWBOARDING, CRICKET, WATER_SPORTS, WINTER_SPORTS, PLATFORM_TENNIS, DOWNHILL_BIKING, LACROSSE, WHEELCHAIR_PUSH_RUN, WHEELCHAIR_PUSH_WALK, TRACK_CYCLING, CARDIO_WORKOUT, FULL_SWEAT, SCULPT, UNDEFINED};
    }

    public static EnumEntries<HistoryActivityType> getEntries() {
        return $ENTRIES;
    }

    public static HistoryActivityType valueOf(String str) {
        return (HistoryActivityType) Enum.valueOf(HistoryActivityType.class, str);
    }

    public static HistoryActivityType[] values() {
        return (HistoryActivityType[]) $VALUES.clone();
    }

    private HistoryActivityType(String str, int i, int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        HistoryActivityType historyActivityType = new HistoryActivityType(DebugCoroutineInfoImplKt.RUNNING, 1, 1);
        RUNNING = historyActivityType;
        HistoryActivityType historyActivityType2 = new HistoryActivityType("CYCLING", 2, 2);
        CYCLING = historyActivityType2;
        HistoryActivityType historyActivityType3 = new HistoryActivityType("ROWING", 3, 3);
        ROWING = historyActivityType3;
        HistoryActivityType historyActivityType4 = new HistoryActivityType("ELLIPTICAL", 4, 4);
        ELLIPTICAL = historyActivityType4;
        HistoryActivityType historyActivityType5 = new HistoryActivityType("STRENGTH_AND_FUNCTION", 5, 5);
        STRENGTH_AND_FUNCTION = historyActivityType5;
        HistoryActivityType historyActivityType6 = new HistoryActivityType("STRETCH_AND_RECOVERY", 6, 6);
        STRETCH_AND_RECOVERY = historyActivityType6;
        HistoryActivityType historyActivityType7 = new HistoryActivityType("WALKING_AND_HIKING", 7, 7);
        WALKING_AND_HIKING = historyActivityType7;
        HistoryActivityType historyActivityType8 = new HistoryActivityType("STAIR_CLIMBING", 8, 8);
        STAIR_CLIMBING = historyActivityType8;
        HistoryActivityType historyActivityType9 = new HistoryActivityType("OTHER", 9, 9);
        OTHER = historyActivityType9;
        HistoryActivityType historyActivityType10 = new HistoryActivityType("SPORTS", 10, TypedValues.Custom.TYPE_FLOAT);
        SPORTS = historyActivityType10;
        HistoryActivityType historyActivityType11 = new HistoryActivityType("SKATING_AND_SKIING", 11, TypedValues.Custom.TYPE_COLOR);
        SKATING_AND_SKIING = historyActivityType11;
        HistoryActivityType historyActivityType12 = new HistoryActivityType("OUTDOOR_LEISURE", 12, TypedValues.Custom.TYPE_STRING);
        OUTDOOR_LEISURE = historyActivityType12;
        HistoryActivityType historyActivityType13 = new HistoryActivityType("SWIMMING", 13, TypedValues.Custom.TYPE_BOOLEAN);
        SWIMMING = historyActivityType13;
        HistoryActivityType historyActivityType14 = new HistoryActivityType("DANCE", 14, TypedValues.Custom.TYPE_DIMENSION);
        DANCE = historyActivityType14;
        HistoryActivityType historyActivityType15 = new HistoryActivityType("JUMP_ROPE", 15, TypedValues.Custom.TYPE_REFERENCE);
        JUMP_ROPE = historyActivityType15;
        HistoryActivityType historyActivityType16 = new HistoryActivityType("EBIKING", 16, 201);
        EBIKING = historyActivityType16;
        HistoryActivityType historyActivityType17 = new HistoryActivityType("INDOOR_CYCLING", 17, 202);
        INDOOR_CYCLING = historyActivityType17;
        HistoryActivityType historyActivityType18 = new HistoryActivityType("OUTDOOR_CYCLING", 18, 203);
        OUTDOOR_CYCLING = historyActivityType18;
        HistoryActivityType historyActivityType19 = new HistoryActivityType("INDOOR_ROWING", 19, 301);
        INDOOR_ROWING = historyActivityType19;
        HistoryActivityType historyActivityType20 = new HistoryActivityType("OPEN_WATER_ROWING", 20, 302);
        OPEN_WATER_ROWING = historyActivityType20;
        HistoryActivityType historyActivityType21 = new HistoryActivityType("INDOOR_RUNNING", 21, 101);
        INDOOR_RUNNING = historyActivityType21;
        HistoryActivityType historyActivityType22 = new HistoryActivityType("OUTDOOR_RUNNING", 22, 102);
        OUTDOOR_RUNNING = historyActivityType22;
        HistoryActivityType historyActivityType23 = new HistoryActivityType("SPECIAL_RUNNING", 23, 103);
        SPECIAL_RUNNING = historyActivityType23;
        HistoryActivityType historyActivityType24 = new HistoryActivityType("FUNCTIONAL_TRAINING", 24, TypedValues.PositionType.TYPE_TRANSITION_EASING);
        FUNCTIONAL_TRAINING = historyActivityType24;
        HistoryActivityType historyActivityType25 = new HistoryActivityType("STRENGTH_TRAINING", 25, TypedValues.PositionType.TYPE_DRAWPATH);
        STRENGTH_TRAINING = historyActivityType25;
        HistoryActivityType historyActivityType26 = new HistoryActivityType("MINDFULLNESS", 26, 601);
        MINDFULLNESS = historyActivityType26;
        HistoryActivityType historyActivityType27 = new HistoryActivityType("HIKING", 27, 701);
        HIKING = historyActivityType27;
        HistoryActivityType historyActivityType28 = new HistoryActivityType("WALKING", 28, 702);
        WALKING = historyActivityType28;
        HistoryActivityType historyActivityType29 = new HistoryActivityType("BOARD_RIDING", 29, 9031);
        BOARD_RIDING = historyActivityType29;
        HistoryActivityType historyActivityType30 = new HistoryActivityType("EXPLORATION", 30, 9032);
        EXPLORATION = historyActivityType30;
        HistoryActivityType historyActivityType31 = new HistoryActivityType("PADDLING", 31, 9033);
        PADDLING = historyActivityType31;
        HistoryActivityType historyActivityType32 = new HistoryActivityType("SKATING", 32, 9021);
        SKATING = historyActivityType32;
        HistoryActivityType historyActivityType33 = new HistoryActivityType("SKIING", 33, 9022);
        SKIING = historyActivityType33;
        HistoryActivityType historyActivityType34 = new HistoryActivityType("SNOWBOARDING", 34, 9023);
        SNOWBOARDING = historyActivityType34;
        HistoryActivityType historyActivityType35 = new HistoryActivityType("COMBAT", 35, 9011);
        COMBAT = historyActivityType35;
        HistoryActivityType historyActivityType36 = new HistoryActivityType("PRECISION_SPORTS", 36, 9012);
        PRECISION_SPORTS = historyActivityType36;
        HistoryActivityType historyActivityType37 = new HistoryActivityType("RACKET_SPORTS", 37, 9013);
        RACKET_SPORTS = historyActivityType37;
        HistoryActivityType historyActivityType38 = new HistoryActivityType("TEAM_SPORTS", 38, 9014);
        TEAM_SPORTS = historyActivityType38;
        HistoryActivityType historyActivityType39 = new HistoryActivityType("OPEN_WATER_SWIMMING", 39, 9041);
        OPEN_WATER_SWIMMING = historyActivityType39;
        HistoryActivityType historyActivityType40 = new HistoryActivityType("POOL_SWIMMING", 40, 9042);
        POOL_SWIMMING = historyActivityType40;
        HistoryActivityType historyActivityType41 = new HistoryActivityType("TREADMILL_RUNNING", 41, 10001);
        TREADMILL_RUNNING = historyActivityType41;
        HistoryActivityType historyActivityType42 = new HistoryActivityType("ROAD_BIKING", 42, 10002);
        ROAD_BIKING = historyActivityType42;
        HistoryActivityType historyActivityType43 = new HistoryActivityType("YOGA", 43, 10003);
        YOGA = historyActivityType43;
        HistoryActivityType historyActivityType44 = new HistoryActivityType("STRETCHING", 44, 10088);
        STRETCHING = historyActivityType44;
        HistoryActivityType historyActivityType45 = new HistoryActivityType("TRAIL_RUNNING", 45, 10004);
        TRAIL_RUNNING = historyActivityType45;
        HistoryActivityType historyActivityType46 = new HistoryActivityType("GOLF", 46, 10005);
        GOLF = historyActivityType46;
        HistoryActivityType historyActivityType47 = new HistoryActivityType("MOUNTAIN_BIKING", 47, 10006);
        MOUNTAIN_BIKING = historyActivityType47;
        HistoryActivityType historyActivityType48 = new HistoryActivityType("HIIT", 48, 10007);
        HIIT = historyActivityType48;
        HistoryActivityType historyActivityType49 = new HistoryActivityType("PILATES", 49, 10008);
        PILATES = historyActivityType49;
        HistoryActivityType historyActivityType50 = new HistoryActivityType("GRAVEL_CYCLING", 50, WinError.WSAEBADF);
        GRAVEL_CYCLING = historyActivityType50;
        HistoryActivityType historyActivityType51 = new HistoryActivityType("BREATHWORK", 51, 10010);
        BREATHWORK = historyActivityType51;
        HistoryActivityType historyActivityType52 = new HistoryActivityType("CROSS_COUNTRY_SKIING_WS", 52, 10011);
        CROSS_COUNTRY_SKIING_WS = historyActivityType52;
        HistoryActivityType historyActivityType53 = new HistoryActivityType("VIRTUAL_RIDE", 53, 10012);
        VIRTUAL_RIDE = historyActivityType53;
        HistoryActivityType historyActivityType54 = new HistoryActivityType("RESORT_SKIING", 54, WinError.WSAEACCES);
        RESORT_SKIING = historyActivityType54;
        HistoryActivityType historyActivityType55 = new HistoryActivityType("TRACK_RUNNING", 55, WinError.WSAEFAULT);
        TRACK_RUNNING = historyActivityType55;
        HistoryActivityType historyActivityType56 = new HistoryActivityType("MULTI_SPORT", 56, 10016);
        MULTI_SPORT = historyActivityType56;
        HistoryActivityType historyActivityType57 = new HistoryActivityType("TENNIS", 57, 10017);
        TENNIS = historyActivityType57;
        HistoryActivityType historyActivityType58 = new HistoryActivityType("VIRTUAL_RUN", 58, 10018);
        VIRTUAL_RUN = historyActivityType58;
        HistoryActivityType historyActivityType59 = new HistoryActivityType("STAND_UP_PADDLEBOARDING", 59, 10020);
        STAND_UP_PADDLEBOARDING = historyActivityType59;
        HistoryActivityType historyActivityType60 = new HistoryActivityType("MEDITATION", 60, 10021);
        MEDITATION = historyActivityType60;
        HistoryActivityType historyActivityType61 = new HistoryActivityType("PICKLEBALL", 61, WinError.WSAEINVAL);
        PICKLEBALL = historyActivityType61;
        HistoryActivityType historyActivityType62 = new HistoryActivityType("KAYAKING", 62, 10023);
        KAYAKING = historyActivityType62;
        HistoryActivityType historyActivityType63 = new HistoryActivityType("PADDELBALL", 63, WinError.WSAEMFILE);
        PADDELBALL = historyActivityType63;
        HistoryActivityType historyActivityType64 = new HistoryActivityType("SKATE_SKIING_WS", 64, 10025);
        SKATE_SKIING_WS = historyActivityType64;
        HistoryActivityType historyActivityType65 = new HistoryActivityType("E_BIKE_MOUNTAIN", 65, 10026);
        E_BIKE_MOUNTAIN = historyActivityType65;
        HistoryActivityType historyActivityType66 = new HistoryActivityType("SOCCER", 66, 10027);
        SOCCER = historyActivityType66;
        HistoryActivityType historyActivityType67 = new HistoryActivityType("MIXED_MARTIAL_ARTS", 67, 10028);
        MIXED_MARTIAL_ARTS = historyActivityType67;
        HistoryActivityType historyActivityType68 = new HistoryActivityType("BADMINTON", 68, 10029);
        BADMINTON = historyActivityType68;
        HistoryActivityType historyActivityType69 = new HistoryActivityType("BASKETBALL", 69, 10030);
        BASKETBALL = historyActivityType69;
        HistoryActivityType historyActivityType70 = new HistoryActivityType("CYCLOCROSS", 70, 10031);
        CYCLOCROSS = historyActivityType70;
        HistoryActivityType historyActivityType71 = new HistoryActivityType("BACKCOUNTRY_SKIING", 71, 10032);
        BACKCOUNTRY_SKIING = historyActivityType71;
        HistoryActivityType historyActivityType72 = new HistoryActivityType("BOXING", 72, 10033);
        BOXING = historyActivityType72;
        HistoryActivityType historyActivityType73 = new HistoryActivityType("INDOOR_CLIMBING", 73, 10034);
        INDOOR_CLIMBING = historyActivityType73;
        HistoryActivityType historyActivityType74 = new HistoryActivityType("RESORT_SNOWBOARDING", 74, WinError.WSAEWOULDBLOCK);
        RESORT_SNOWBOARDING = historyActivityType74;
        HistoryActivityType historyActivityType75 = new HistoryActivityType("FLOOR_CLIMBING", 75, WinError.WSAEINPROGRESS);
        FLOOR_CLIMBING = historyActivityType75;
        HistoryActivityType historyActivityType76 = new HistoryActivityType("RECUMBENT_CYCLING", 76, WinError.WSAEALREADY);
        RECUMBENT_CYCLING = historyActivityType76;
        HistoryActivityType historyActivityType77 = new HistoryActivityType("BOATING", 77, WinError.WSAENOTSOCK);
        BOATING = historyActivityType77;
        HistoryActivityType historyActivityType78 = new HistoryActivityType("DISC_GOLF", 78, WinError.WSAEDESTADDRREQ);
        DISC_GOLF = historyActivityType78;
        HistoryActivityType historyActivityType79 = new HistoryActivityType("BOULDERING", 79, WinError.WSAEMSGSIZE);
        BOULDERING = historyActivityType79;
        HistoryActivityType historyActivityType80 = new HistoryActivityType("ULTRA_RUN", 80, WinError.WSAEPROTOTYPE);
        ULTRA_RUN = historyActivityType80;
        HistoryActivityType historyActivityType81 = new HistoryActivityType("ICE_HOCKEY", 81, WinError.WSAENOPROTOOPT);
        ICE_HOCKEY = historyActivityType81;
        HistoryActivityType historyActivityType82 = new HistoryActivityType("SPEED_WALKING", 82, WinError.WSAEPROTONOSUPPORT);
        SPEED_WALKING = historyActivityType82;
        HistoryActivityType historyActivityType83 = new HistoryActivityType("VOLLEYBALL", 83, WinError.WSAESOCKTNOSUPPORT);
        VOLLEYBALL = historyActivityType83;
        HistoryActivityType historyActivityType84 = new HistoryActivityType("TABLE_TENNIS", 84, WinError.WSAEOPNOTSUPP);
        TABLE_TENNIS = historyActivityType84;
        HistoryActivityType historyActivityType85 = new HistoryActivityType("KITEBOARDING", 85, WinError.WSAEPFNOSUPPORT);
        KITEBOARDING = historyActivityType85;
        HistoryActivityType historyActivityType86 = new HistoryActivityType("CASUAL_WALKING", 86, WinError.WSAEAFNOSUPPORT);
        CASUAL_WALKING = historyActivityType86;
        HistoryActivityType historyActivityType87 = new HistoryActivityType("INLINE_SKATING", 87, WinError.WSAEADDRINUSE);
        INLINE_SKATING = historyActivityType87;
        HistoryActivityType historyActivityType88 = new HistoryActivityType("SQUASH", 88, WinError.WSAEADDRNOTAVAIL);
        SQUASH = historyActivityType88;
        HistoryActivityType historyActivityType89 = new HistoryActivityType("SKATING_WS", 89, WinError.WSAENETDOWN);
        SKATING_WS = historyActivityType89;
        HistoryActivityType historyActivityType90 = new HistoryActivityType("SNOW_SHOE_WS", 90, WinError.WSAENETUNREACH);
        SNOW_SHOE_WS = historyActivityType90;
        HistoryActivityType historyActivityType91 = new HistoryActivityType("FISHING", 91, WinError.WSAENETRESET);
        FISHING = historyActivityType91;
        HistoryActivityType historyActivityType92 = new HistoryActivityType("SURFING", 92, WinError.WSAECONNABORTED);
        SURFING = historyActivityType92;
        HistoryActivityType historyActivityType93 = new HistoryActivityType("RUCKING", 93, WinError.WSAECONNRESET);
        RUCKING = historyActivityType93;
        HistoryActivityType historyActivityType94 = new HistoryActivityType("SOFTBALL", 94, WinError.WSAENOBUFS);
        SOFTBALL = historyActivityType94;
        HistoryActivityType historyActivityType95 = new HistoryActivityType("SAILING", 95, WinError.WSAEISCONN);
        SAILING = historyActivityType95;
        HistoryActivityType historyActivityType96 = new HistoryActivityType("AMERICAN_FOOTBALL", 96, WinError.WSAENOTCONN);
        AMERICAN_FOOTBALL = historyActivityType96;
        HistoryActivityType historyActivityType97 = new HistoryActivityType("RACQUETBALL", 97, WinError.WSAESHUTDOWN);
        RACQUETBALL = historyActivityType97;
        HistoryActivityType historyActivityType98 = new HistoryActivityType("WINDSURFING", 98, WinError.WSAETOOMANYREFS);
        WINDSURFING = historyActivityType98;
        HistoryActivityType historyActivityType99 = new HistoryActivityType("FIELD_HOCKEY", 99, WinError.WSAETIMEDOUT);
        FIELD_HOCKEY = historyActivityType99;
        HistoryActivityType historyActivityType100 = new HistoryActivityType("SNORKELING", 100, WinError.WSAECONNREFUSED);
        SNORKELING = historyActivityType100;
        HistoryActivityType historyActivityType101 = new HistoryActivityType("STREET_RUNNING", 101, WinError.WSAELOOP);
        STREET_RUNNING = historyActivityType101;
        HistoryActivityType historyActivityType102 = new HistoryActivityType("SNOWMOBILING_WS", 102, WinError.WSAENAMETOOLONG);
        SNOWMOBILING_WS = historyActivityType102;
        HistoryActivityType historyActivityType103 = new HistoryActivityType("HUNTING", 103, WinError.WSAEHOSTDOWN);
        HUNTING = historyActivityType103;
        HistoryActivityType historyActivityType104 = new HistoryActivityType("ENDURO_MTB", 104, WinError.WSAEHOSTUNREACH);
        ENDURO_MTB = historyActivityType104;
        HistoryActivityType historyActivityType105 = new HistoryActivityType("OBSTACLE_RUN", 105, WinError.WSAENOTEMPTY);
        OBSTACLE_RUN = historyActivityType105;
        HistoryActivityType historyActivityType106 = new HistoryActivityType("RUGBY", 106, WinError.WSAEPROCLIM);
        RUGBY = historyActivityType106;
        HistoryActivityType historyActivityType107 = new HistoryActivityType("WAKEBOARDING", 107, WinError.WSAEUSERS);
        WAKEBOARDING = historyActivityType107;
        HistoryActivityType historyActivityType108 = new HistoryActivityType("BASEBALL", 108, WinError.WSAEDQUOT);
        BASEBALL = historyActivityType108;
        HistoryActivityType historyActivityType109 = new HistoryActivityType("ROCK_CLIMBING", 109, WinError.WSAESTALE);
        ROCK_CLIMBING = historyActivityType109;
        HistoryActivityType historyActivityType110 = new HistoryActivityType("WHITEWATER_RAFTING", 110, WinError.WSAEREMOTE);
        WHITEWATER_RAFTING = historyActivityType110;
        HistoryActivityType historyActivityType111 = new HistoryActivityType("ULTIMATE_DISC", 111, 10072);
        ULTIMATE_DISC = historyActivityType111;
        HistoryActivityType historyActivityType112 = new HistoryActivityType("WAKESURFING", 112, 10073);
        WAKESURFING = historyActivityType112;
        HistoryActivityType historyActivityType113 = new HistoryActivityType("WATER_TUBING", 113, 10074);
        WATER_TUBING = historyActivityType113;
        HistoryActivityType historyActivityType114 = new HistoryActivityType("BMX", 114, 10075);
        BMX = historyActivityType114;
        HistoryActivityType historyActivityType115 = new HistoryActivityType("ARCHERY", 115, 10076);
        ARCHERY = historyActivityType115;
        HistoryActivityType historyActivityType116 = new HistoryActivityType("WATERSKIING", 116, 10077);
        WATERSKIING = historyActivityType116;
        HistoryActivityType historyActivityType117 = new HistoryActivityType("BACKCOUNTRY_SNOWBOARDING", 117, 10078);
        BACKCOUNTRY_SNOWBOARDING = historyActivityType117;
        HistoryActivityType historyActivityType118 = new HistoryActivityType("CRICKET", 118, 10079);
        CRICKET = historyActivityType118;
        HistoryActivityType historyActivityType119 = new HistoryActivityType("WATER_SPORTS", 119, 10080);
        WATER_SPORTS = historyActivityType119;
        HistoryActivityType historyActivityType120 = new HistoryActivityType("WINTER_SPORTS", 120, 10081);
        WINTER_SPORTS = historyActivityType120;
        HistoryActivityType historyActivityType121 = new HistoryActivityType("PLATFORM_TENNIS", 121, 10082);
        PLATFORM_TENNIS = historyActivityType121;
        HistoryActivityType historyActivityType122 = new HistoryActivityType("DOWNHILL_BIKING", 122, 10083);
        DOWNHILL_BIKING = historyActivityType122;
        HistoryActivityType historyActivityType123 = new HistoryActivityType("LACROSSE", 123, 10084);
        LACROSSE = historyActivityType123;
        HistoryActivityType historyActivityType124 = new HistoryActivityType("WHEELCHAIR_PUSH_RUN", 124, 10085);
        WHEELCHAIR_PUSH_RUN = historyActivityType124;
        HistoryActivityType historyActivityType125 = new HistoryActivityType("WHEELCHAIR_PUSH_WALK", 125, 10086);
        WHEELCHAIR_PUSH_WALK = historyActivityType125;
        HistoryActivityType historyActivityType126 = new HistoryActivityType("TRACK_CYCLING", 126, 10087);
        TRACK_CYCLING = historyActivityType126;
        HistoryActivityType historyActivityType127 = new HistoryActivityType("CARDIO_WORKOUT", 127, 10090);
        CARDIO_WORKOUT = historyActivityType127;
        HistoryActivityType historyActivityType128 = new HistoryActivityType("FULL_SWEAT", 128, WinError.WSASYSNOTREADY);
        FULL_SWEAT = historyActivityType128;
        HistoryActivityType historyActivityType129 = new HistoryActivityType("SCULPT", 129, WinError.WSAVERNOTSUPPORTED);
        SCULPT = historyActivityType129;
        HistoryActivityType historyActivityType130 = new HistoryActivityType("UNDEFINED", 130, -1);
        UNDEFINED = historyActivityType130;
        HistoryActivityType[] historyActivityTypeArr$values = $values();
        $VALUES = historyActivityTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(historyActivityTypeArr$values);
        INSTANCE = new Companion(null);
        parentOf = MapsKt.mapOf(TuplesKt.to(historyActivityType, null), TuplesKt.to(historyActivityType2, null), TuplesKt.to(historyActivityType3, null), TuplesKt.to(historyActivityType4, null), TuplesKt.to(historyActivityType5, null), TuplesKt.to(historyActivityType6, null), TuplesKt.to(historyActivityType7, null), TuplesKt.to(historyActivityType8, null), TuplesKt.to(historyActivityType9, null), TuplesKt.to(historyActivityType10, historyActivityType9), TuplesKt.to(historyActivityType11, historyActivityType9), TuplesKt.to(historyActivityType12, historyActivityType9), TuplesKt.to(historyActivityType13, historyActivityType9), TuplesKt.to(historyActivityType14, historyActivityType9), TuplesKt.to(historyActivityType15, historyActivityType9), TuplesKt.to(historyActivityType16, historyActivityType2), TuplesKt.to(historyActivityType17, historyActivityType2), TuplesKt.to(historyActivityType18, historyActivityType2), TuplesKt.to(historyActivityType19, historyActivityType3), TuplesKt.to(historyActivityType20, historyActivityType3), TuplesKt.to(historyActivityType21, historyActivityType), TuplesKt.to(historyActivityType22, historyActivityType), TuplesKt.to(historyActivityType23, historyActivityType), TuplesKt.to(historyActivityType24, historyActivityType5), TuplesKt.to(historyActivityType25, historyActivityType5), TuplesKt.to(historyActivityType26, historyActivityType6), TuplesKt.to(historyActivityType27, historyActivityType7), TuplesKt.to(historyActivityType28, historyActivityType7), TuplesKt.to(historyActivityType29, historyActivityType12), TuplesKt.to(historyActivityType30, historyActivityType12), TuplesKt.to(historyActivityType31, historyActivityType12), TuplesKt.to(historyActivityType32, historyActivityType11), TuplesKt.to(historyActivityType33, historyActivityType11), TuplesKt.to(historyActivityType34, historyActivityType11), TuplesKt.to(historyActivityType35, historyActivityType10), TuplesKt.to(historyActivityType36, historyActivityType10), TuplesKt.to(historyActivityType37, historyActivityType10), TuplesKt.to(historyActivityType38, historyActivityType10), TuplesKt.to(historyActivityType39, historyActivityType13), TuplesKt.to(historyActivityType40, historyActivityType13), TuplesKt.to(historyActivityType41, historyActivityType21), TuplesKt.to(historyActivityType42, historyActivityType18), TuplesKt.to(historyActivityType43, historyActivityType6), TuplesKt.to(historyActivityType44, historyActivityType6), TuplesKt.to(historyActivityType45, historyActivityType22), TuplesKt.to(historyActivityType46, historyActivityType36), TuplesKt.to(historyActivityType47, historyActivityType18), TuplesKt.to(historyActivityType48, historyActivityType21), TuplesKt.to(historyActivityType49, historyActivityType24), TuplesKt.to(historyActivityType50, historyActivityType18), TuplesKt.to(historyActivityType51, historyActivityType26), TuplesKt.to(historyActivityType52, historyActivityType33), TuplesKt.to(historyActivityType53, historyActivityType17), TuplesKt.to(historyActivityType54, historyActivityType33), TuplesKt.to(historyActivityType55, historyActivityType22), TuplesKt.to(historyActivityType56, historyActivityType9), TuplesKt.to(historyActivityType57, historyActivityType37), TuplesKt.to(historyActivityType58, historyActivityType21), TuplesKt.to(historyActivityType59, historyActivityType31), TuplesKt.to(historyActivityType60, historyActivityType26), TuplesKt.to(historyActivityType61, historyActivityType37), TuplesKt.to(historyActivityType62, historyActivityType31), TuplesKt.to(historyActivityType63, historyActivityType37), TuplesKt.to(historyActivityType64, historyActivityType33), TuplesKt.to(historyActivityType65, historyActivityType16), TuplesKt.to(historyActivityType66, historyActivityType38), TuplesKt.to(historyActivityType67, historyActivityType35), TuplesKt.to(historyActivityType68, historyActivityType37), TuplesKt.to(historyActivityType69, historyActivityType38), TuplesKt.to(historyActivityType70, historyActivityType18), TuplesKt.to(historyActivityType71, historyActivityType33), TuplesKt.to(historyActivityType72, historyActivityType35), TuplesKt.to(historyActivityType73, historyActivityType24), TuplesKt.to(historyActivityType74, historyActivityType34), TuplesKt.to(historyActivityType75, historyActivityType27), TuplesKt.to(historyActivityType76, historyActivityType17), TuplesKt.to(historyActivityType77, historyActivityType30), TuplesKt.to(historyActivityType78, historyActivityType36), TuplesKt.to(historyActivityType79, historyActivityType24), TuplesKt.to(historyActivityType80, historyActivityType23), TuplesKt.to(historyActivityType81, historyActivityType38), TuplesKt.to(historyActivityType82, historyActivityType28), TuplesKt.to(historyActivityType83, historyActivityType38), TuplesKt.to(historyActivityType84, historyActivityType37), TuplesKt.to(historyActivityType85, historyActivityType29), TuplesKt.to(historyActivityType86, historyActivityType28), TuplesKt.to(historyActivityType87, historyActivityType32), TuplesKt.to(historyActivityType88, historyActivityType37), TuplesKt.to(historyActivityType89, historyActivityType32), TuplesKt.to(historyActivityType90, historyActivityType27), TuplesKt.to(historyActivityType91, historyActivityType30), TuplesKt.to(historyActivityType92, historyActivityType29), TuplesKt.to(historyActivityType93, historyActivityType27), TuplesKt.to(historyActivityType94, historyActivityType38), TuplesKt.to(historyActivityType95, historyActivityType30), TuplesKt.to(historyActivityType96, historyActivityType38), TuplesKt.to(historyActivityType97, historyActivityType37), TuplesKt.to(historyActivityType98, historyActivityType29), TuplesKt.to(historyActivityType99, historyActivityType38), TuplesKt.to(historyActivityType100, historyActivityType30), TuplesKt.to(historyActivityType101, historyActivityType22), TuplesKt.to(historyActivityType102, historyActivityType30), TuplesKt.to(historyActivityType103, historyActivityType30), TuplesKt.to(historyActivityType104, historyActivityType18), TuplesKt.to(historyActivityType105, historyActivityType23), TuplesKt.to(historyActivityType106, historyActivityType38), TuplesKt.to(historyActivityType107, historyActivityType29), TuplesKt.to(historyActivityType108, historyActivityType38), TuplesKt.to(historyActivityType109, historyActivityType24), TuplesKt.to(historyActivityType110, historyActivityType31), TuplesKt.to(historyActivityType111, historyActivityType38), TuplesKt.to(historyActivityType112, historyActivityType29), TuplesKt.to(historyActivityType113, historyActivityType30), TuplesKt.to(historyActivityType114, historyActivityType18), TuplesKt.to(historyActivityType115, historyActivityType36), TuplesKt.to(historyActivityType116, historyActivityType29), TuplesKt.to(historyActivityType117, historyActivityType34), TuplesKt.to(historyActivityType118, historyActivityType10), TuplesKt.to(historyActivityType119, historyActivityType12), TuplesKt.to(historyActivityType120, historyActivityType11), TuplesKt.to(historyActivityType121, historyActivityType10), TuplesKt.to(historyActivityType122, historyActivityType18), TuplesKt.to(historyActivityType123, historyActivityType10), TuplesKt.to(historyActivityType124, historyActivityType23), TuplesKt.to(historyActivityType125, historyActivityType28), TuplesKt.to(historyActivityType126, historyActivityType18), TuplesKt.to(historyActivityType127, historyActivityType9), TuplesKt.to(historyActivityType128, historyActivityType9), TuplesKt.to(historyActivityType129, historyActivityType24), TuplesKt.to(historyActivityType130, null));
    }

    public final String getTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                String string = context.getString(R.string.activity_running);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = context.getString(R.string.activity_cycling);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3:
                String string3 = context.getString(R.string.activity_elliptical);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = context.getString(R.string.activity_stepper);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 5:
                String string5 = context.getString(R.string.activity_rowing);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 6:
                String string6 = context.getString(R.string.activity_strength);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 7:
                String string7 = context.getString(R.string.activity_stretch);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            case 8:
                String string8 = context.getString(R.string.activity_walking);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return string8;
            case 9:
                String string9 = context.getString(R.string.activity_all);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                return string9;
            default:
                String string10 = context.getString(R.string.activity_others);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
        }
    }

    public final HistoryActivityType getParent() {
        return parentOf.get(this);
    }

    public final boolean isLeafNode() {
        return !CollectionsKt.toSet(CollectionsKt.filterNotNull(parentOf.values())).contains(this);
    }

    public final boolean isInActivityType(HistoryActivityType ascendantOrSelf) {
        if (ascendantOrSelf == null) {
            return false;
        }
        if (ascendantOrSelf == this) {
            return true;
        }
        for (HistoryActivityType parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent == ascendantOrSelf) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: HistoryActivityType.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/HistoryActivityType$Companion;", "", "()V", "parentOf", "", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "getParentOf", "()Ljava/util/Map;", "fromCode", "code", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HistoryActivityType fromCode(int code) {
            HistoryActivityType historyActivityType;
            HistoryActivityType[] historyActivityTypeArrValues = HistoryActivityType.values();
            int length = historyActivityTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    historyActivityType = null;
                    break;
                }
                historyActivityType = historyActivityTypeArrValues[i];
                if (historyActivityType.getCode() == code) {
                    break;
                }
                i++;
            }
            return historyActivityType == null ? HistoryActivityType.UNDEFINED : historyActivityType;
        }

        public final Map<HistoryActivityType, HistoryActivityType> getParentOf() {
            return HistoryActivityType.parentOf;
        }
    }

    public final boolean isInAnyActivityTypes(HistoryActivityType... ascendantOrSelf) {
        Intrinsics.checkNotNullParameter(ascendantOrSelf, "ascendantOrSelf");
        for (HistoryActivityType historyActivityType : ascendantOrSelf) {
            if (isInActivityType(historyActivityType)) {
                return true;
            }
        }
        return false;
    }
}
