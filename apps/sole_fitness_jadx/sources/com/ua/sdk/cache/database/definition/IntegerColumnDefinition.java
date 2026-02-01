package com.ua.sdk.cache.database.definition;

import android.content.ContentValues;
import android.database.Cursor;
import com.ua.sdk.cache.database.LegacyEntityDatabase;

/* loaded from: classes2.dex */
public class IntegerColumnDefinition extends ColumnDefinition<Integer> {
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public String getDbType() {
        return "INTEGER";
    }

    public IntegerColumnDefinition(int i, String str) {
        super(i, str);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Class<Integer> getObjectType() {
        return Integer.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Integer read(Cursor cursor) {
        return LegacyEntityDatabase.readInteger(getColumnIndex(), cursor);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public void write(Integer num, ContentValues contentValues) {
        LegacyEntityDatabase.writeInteger(contentValues, getColumnName(), num);
    }
}
