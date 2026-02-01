package com.ua.sdk.activitystory;

import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.UaLog;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryToutObject;
import com.ua.sdk.activitystory.object.ActivityStoryActigraphyObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryAdObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryCommentObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryGroupLeaderboardObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryGroupObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryHighlightImpl;
import com.ua.sdk.activitystory.object.ActivityStoryLikeObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryRepostObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryRouteObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryStatusObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryToutObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryUserObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryWorkoutObjectImpl;
import com.ua.sdk.location.Location;
import com.ua.sdk.location.LocationImpl;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.PrivacyHelper;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.ClientCookie;

/* loaded from: classes2.dex */
public class ActivityStoryObjectAdapter implements JsonSerializer<ActivityStoryObject>, JsonDeserializer<ActivityStoryObject> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActivityStoryObject deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Type type2;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("type");
        ActivityStoryToutObject.Subtype subtype = null;
        if (jsonElement2 == null) {
            return null;
        }
        String asString = jsonElement2.getAsString();
        if ("workout".equals(asString)) {
            type2 = ActivityStoryWorkoutObjectImpl.class;
        } else if ("user".equals(asString)) {
            type2 = ActivityStoryUserObjectImpl.class;
        } else if ("status".equals(asString)) {
            type2 = ActivityStoryStatusObjectImpl.class;
        } else if ("repost".equals(asString)) {
            type2 = ActivityStoryRepostObjectImpl.class;
        } else if ("group".equals(asString)) {
            type2 = ActivityStoryGroupObjectImpl.class;
        } else if ("group_leaderboard".equals(asString)) {
            type2 = ActivityStoryGroupLeaderboardObjectImpl.class;
        } else if ("route".equals(asString)) {
            type2 = ActivityStoryRouteObjectImpl.class;
        } else if ("actigraphy".equals(asString)) {
            type2 = ActivityStoryActigraphyObjectImpl.class;
        } else if (ClientCookie.COMMENT_ATTR.equals(asString)) {
            type2 = ActivityStoryCommentObjectImpl.class;
        } else {
            if ("ad".equals(asString)) {
                return new ActivityStoryAdObjectImpl();
            }
            if ("like".equals(asString)) {
                return new ActivityStoryLikeObjectImpl();
            }
            if ("tout".equals(asString)) {
                JsonElement jsonElement3 = asJsonObject.get("subtype");
                if (jsonElement3 != null && "find_friends".equals(jsonElement3.getAsString())) {
                    subtype = ActivityStoryToutObject.Subtype.FIND_FRIENDS;
                }
                return new ActivityStoryToutObjectImpl(subtype);
            }
            type2 = null;
        }
        if (type2 != null) {
            return (ActivityStoryObject) jsonDeserializationContext.deserialize(jsonElement, type2);
        }
        return null;
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ActivityStoryObject activityStoryObject, Type type, JsonSerializationContext jsonSerializationContext) {
        ActivityStoryToutObject.Subtype subtype;
        JsonObject asJsonObject = jsonSerializationContext.serialize(activityStoryObject, activityStoryObject.getClass()).getAsJsonObject();
        asJsonObject.addProperty("type", activityStoryObject.getType().toString().toLowerCase());
        if (activityStoryObject.getType() == ActivityStoryObject.Type.TOUT && (subtype = ((ActivityStoryToutObject) activityStoryObject).getSubtype()) != null && AnonymousClass1.$SwitchMap$com$ua$sdk$activitystory$ActivityStoryToutObject$Subtype[subtype.ordinal()] == 1) {
            asJsonObject.addProperty("subtype", "find_friends");
        }
        return asJsonObject;
    }

    /* renamed from: com.ua.sdk.activitystory.ActivityStoryObjectAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$activitystory$ActivityStoryToutObject$Subtype;

        static {
            int[] iArr = new int[ActivityStoryToutObject.Subtype.values().length];
            $SwitchMap$com$ua$sdk$activitystory$ActivityStoryToutObject$Subtype = iArr;
            try {
                iArr[ActivityStoryToutObject.Subtype.FIND_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    Location getLocation(JsonObject jsonObject, String str) {
        try {
            if (!jsonObject.has(str)) {
                return null;
            }
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonNull()) {
                return null;
            }
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new LocationImpl(getString(asJsonObject, UserDataStore.COUNTRY), getString(asJsonObject, "region"), getString(asJsonObject, "locality"), getString(asJsonObject, IntegrityManager.INTEGRITY_TYPE_ADDRESS));
        } catch (Throwable th) {
            UaLog.error("Unable to parse " + str, th);
            return null;
        }
    }

    List<ActivityStoryHighlight> getHighlights(JsonObject jsonObject, String str) {
        try {
            if (!jsonObject.has(str)) {
                return null;
            }
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonNull()) {
                return null;
            }
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            int size = asJsonArray.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                JsonObject asJsonObject = asJsonArray.get(i).getAsJsonObject();
                ActivityStoryHighlightImpl activityStoryHighlightImpl = new ActivityStoryHighlightImpl();
                String string = getString(asJsonObject, SDKConstants.PARAM_KEY);
                activityStoryHighlightImpl.setKey(string);
                activityStoryHighlightImpl.setPercentile(getDouble(asJsonObject, "percentile"));
                activityStoryHighlightImpl.setThumbnailUrl(getString(asJsonObject, "thumbnail_url"));
                if (jsonObject.has(string)) {
                    JsonElement jsonElement2 = jsonObject.get(string);
                    if (jsonElement2.isJsonPrimitive()) {
                        JsonPrimitive asJsonPrimitive = jsonElement2.getAsJsonPrimitive();
                        if (asJsonPrimitive.isNumber()) {
                            activityStoryHighlightImpl.setValue(asJsonPrimitive.getAsNumber());
                        }
                    }
                }
                arrayList.add(activityStoryHighlightImpl);
            }
            return arrayList;
        } catch (Throwable th) {
            UaLog.error("Unable to parse " + str, th);
            return null;
        }
    }

    String getString(JsonObject jsonObject, String str) {
        try {
            if (!jsonObject.has(str)) {
                return null;
            }
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonNull()) {
                return null;
            }
            return jsonElement.getAsString();
        } catch (Throwable th) {
            UaLog.error("Unable to parse " + str, th);
            return null;
        }
    }

    Privacy getPrivacy(JsonObject jsonObject, String str) {
        try {
            if (!jsonObject.has(str)) {
                return null;
            }
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonNull()) {
                return null;
            }
            return PrivacyHelper.getPrivacyFromId(jsonElement.getAsInt());
        } catch (Throwable th) {
            UaLog.error("Unable to parse " + str, th);
            return null;
        }
    }

    Double getDouble(JsonObject jsonObject, String str) {
        try {
            if (!jsonObject.has(str)) {
                return null;
            }
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonNull()) {
                return null;
            }
            return Double.valueOf(jsonElement.getAsDouble());
        } catch (Throwable th) {
            UaLog.error("Unable to parse " + str, th);
            return null;
        }
    }

    Integer getInteger(JsonObject jsonObject, String str) {
        try {
            if (!jsonObject.has(str)) {
                return null;
            }
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonNull()) {
                return null;
            }
            return Integer.valueOf(jsonElement.getAsInt());
        } catch (Throwable th) {
            UaLog.error("Unable to parse " + str, th);
            return null;
        }
    }
}
