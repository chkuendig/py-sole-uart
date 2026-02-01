package com.ua.sdk.cache.database.definition;

import android.content.ContentValues;
import android.database.Cursor;
import com.ua.sdk.cache.database.LegacyEntityDatabase;

/* loaded from: classes2.dex */
public class BooleanColumnDefinition extends ColumnDefinition<Boolean> {
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public String getDbType() {
        return "INTEGER";
    }

    public BooleanColumnDefinition(int i, String str) {
        super(i, str);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Class<Boolean> getObjectType() {
        return Boolean.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Boolean read(Cursor cursor) {
        return LegacyEntityDatabase.readBoolean(getColumnIndex(), cursor);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public void write(Boolean bool, ContentValues contentValues) {
        LegacyEntityDatabase.writeBoolean(contentValues, getColumnName(), bool);
    }
}
