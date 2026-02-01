package com.ua.sdk.cache.database.definition;

import android.content.ContentValues;
import android.database.Cursor;
import com.ua.sdk.cache.database.LegacyEntityDatabase;

/* loaded from: classes2.dex */
public class LocalIdColumnDefinition extends ColumnDefinition<Long> {
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public String getDbType() {
        return "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL";
    }

    public LocalIdColumnDefinition(int i, String str) {
        super(i, str);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Class<Long> getObjectType() {
        return Long.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Long read(Cursor cursor) {
        return LegacyEntityDatabase.readLong(getColumnIndex(), cursor);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public void write(Long l, ContentValues contentValues) {
        LegacyEntityDatabase.writeLong(contentValues, getColumnName(), l);
    }
}
