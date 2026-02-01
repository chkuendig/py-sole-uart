package com.ua.sdk.cache.database.definition;

import android.content.ContentValues;
import android.database.Cursor;
import com.ua.sdk.cache.database.LegacyEntityDatabase;

/* loaded from: classes2.dex */
public class DoubleColumnDefinition extends ColumnDefinition<Double> {
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public String getDbType() {
        return "REAL";
    }

    public DoubleColumnDefinition(int i, String str) {
        super(i, str);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Class<Double> getObjectType() {
        return Double.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Double read(Cursor cursor) {
        return LegacyEntityDatabase.readDouble(getColumnIndex(), cursor);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public void write(Double d, ContentValues contentValues) {
        LegacyEntityDatabase.writeDouble(contentValues, getColumnName(), d);
    }
}
