package com.ua.sdk.cache.database.definition;

import android.content.ContentValues;
import android.database.Cursor;
import com.ua.sdk.cache.database.LegacyEntityDatabase;

/* loaded from: classes2.dex */
public class StringColumnDefinition extends ColumnDefinition<String> {
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public String getDbType() {
        return "TEXT";
    }

    public StringColumnDefinition(int i, String str) {
        super(i, str);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Class<String> getObjectType() {
        return String.class;
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public String read(Cursor cursor) {
        return LegacyEntityDatabase.readString(getColumnIndex(), cursor);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public void write(String str, ContentValues contentValues) {
        LegacyEntityDatabase.writeString(contentValues, getColumnName(), str);
    }
}
