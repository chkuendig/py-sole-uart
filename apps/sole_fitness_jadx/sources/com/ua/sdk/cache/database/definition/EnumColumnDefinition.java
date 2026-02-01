package com.ua.sdk.cache.database.definition;

import android.content.ContentValues;
import android.database.Cursor;
import com.ua.sdk.cache.database.LegacyEntityDatabase;
import java.lang.Enum;

/* loaded from: classes2.dex */
public class EnumColumnDefinition<T extends Enum<T>> extends ColumnDefinition<T> {
    private Class<T> clazz;

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public String getDbType() {
        return "TEXT";
    }

    public EnumColumnDefinition(int i, String str, Class<T> cls) {
        super(i, str);
        this.clazz = cls;
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public Class<T> getObjectType() {
        return this.clazz;
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public T read(Cursor cursor) {
        return (T) LegacyEntityDatabase.readEnum(getColumnIndex(), cursor, this.clazz);
    }

    @Override // com.ua.sdk.cache.database.definition.ColumnDefinition
    public void write(T t, ContentValues contentValues) {
        LegacyEntityDatabase.writeEnum(contentValues, getColumnName(), t);
    }
}
