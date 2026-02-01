package com.ua.sdk.cache.database.definition;

import android.content.ContentValues;
import android.database.Cursor;
import com.ua.sdk.cache.database.LegacyEntityDatabase;
import java.util.Date;

/* loaded from: classes2.dex */
public class DateColumnDefinition extends ColumnDefinition<Date> {
    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public String getDbType() {
        return "INTEGER";
    }

    public DateColumnDefinition(int i, String str) {
        super(i, str);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Class<Date> getObjectType() {
        return Date.class;
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Date read(Cursor cursor) {
        return LegacyEntityDatabase.readDate(getColumnIndex(), cursor);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public void write(Date date, ContentValues contentValues) {
        LegacyEntityDatabase.writeDate(contentValues, getColumnName(), date);
    }
}
