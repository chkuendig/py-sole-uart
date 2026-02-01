package com.ua.sdk.group.objective;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes2.dex */
public class CriteriaGsonAdapter implements JsonDeserializer<Criteria>, JsonSerializer<Criteria> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Criteria deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        CriteriaItem sortCriteriaItem;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        CriteriaImpl criteriaImpl = new CriteriaImpl();
        for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            String key = entry.getKey();
            if (CriteriaTypes.ACTIVITY_TYPE.equals(key)) {
                sortCriteriaItem = new ActivityTypeCriteriaItem();
                sortCriteriaItem.setValue(Integer.valueOf(entry.getValue().getAsInt()));
            } else if (CriteriaTypes.SORT.equals(key)) {
                sortCriteriaItem = new SortCriteriaItem();
                sortCriteriaItem.setValue(entry.getValue().getAsString());
            } else {
                CriteriaItemImpl criteriaItemImpl = new CriteriaItemImpl();
                criteriaItemImpl.setValue(entry.getValue().toString());
                criteriaItemImpl.name = key;
                criteriaItemImpl.setValue(entry.getValue().toString());
                sortCriteriaItem = criteriaItemImpl;
            }
            criteriaImpl.addCriteriaItem(sortCriteriaItem);
        }
        return criteriaImpl;
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Criteria criteria, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;
        for (String str : criteriaImpl.criteria.keySet()) {
            if (CriteriaTypes.ACTIVITY_TYPE.equals(str)) {
                jsonObject.add(str, new JsonPrimitive((Integer) criteriaImpl.criteria.get(str).getValue()));
            } else if (CriteriaTypes.SORT.equals(str)) {
                jsonObject.add(str, new JsonPrimitive((String) criteriaImpl.criteria.get(str).getValue()));
            } else {
                jsonObject.add(str, new JsonPrimitive((String) criteriaImpl.criteria.get(str).getValue()));
            }
        }
        return jsonObject;
    }
}
