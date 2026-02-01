package com.ua.sdk.page.association;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class PageAssociationAdapter implements JsonSerializer<PageAssociation>, JsonDeserializer<PageAssociation> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public PageAssociation deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return PageAssociationTransferObject.toPageAssocaitionImpl((PageAssociationTransferObject) jsonDeserializationContext.deserialize(jsonElement, PageAssociationTransferObject.class));
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(PageAssociation pageAssociation, Type type, JsonSerializationContext jsonSerializationContext) {
        PageAssociationTransferObject pageAssociationTransferObjectFromPageAssocaition = PageAssociationTransferObject.fromPageAssocaition(pageAssociation);
        return jsonSerializationContext.serialize(pageAssociationTransferObjectFromPageAssocaition, pageAssociationTransferObjectFromPageAssocaition.getClass());
    }
}
