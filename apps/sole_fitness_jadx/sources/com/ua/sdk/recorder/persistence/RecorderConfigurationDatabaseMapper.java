package com.ua.sdk.recorder.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.ua.sdk.EntityRef;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.activitytype.ActivityTypeRef;
import com.ua.sdk.cache.database.definition.ColumnDefinition;
import com.ua.sdk.cache.database.definition.DateColumnDefinition;
import com.ua.sdk.cache.database.definition.LocalIdColumnDefinition;
import com.ua.sdk.cache.database.definition.StringColumnDefinition;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.recorder.BluetoothSensorDataSourceConfiguration;
import com.ua.sdk.recorder.DataSourceConfiguration;
import com.ua.sdk.recorder.DataSourceConfigurationList;
import com.ua.sdk.recorder.DataSourceConfigurationListParser;
import com.ua.sdk.recorder.DataSourceConfigurationListWriter;
import com.ua.sdk.recorder.DerivedDataSourceConfiguration;
import com.ua.sdk.recorder.LocationSensorDataSourceConfiguration;
import com.ua.sdk.recorder.RecorderConfiguration;
import com.ua.sdk.recorder.RecorderConfigurationImpl;
import com.ua.sdk.user.User;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class RecorderConfigurationDatabaseMapper {
    public static final ColumnDefinition<String> ACTIVITY_TYPE_ID;
    protected static final ColumnDefinition[] COLUMNS;
    public static final ColumnDefinition<String> CONFIGURATION;
    public static final ColumnDefinition<Date> CREATE_DATE;
    public static final ColumnDefinition<Long> LOCAL_ID;
    public static final ColumnDefinition<String> NAME;
    public static final ColumnDefinition<Date> UPDATE_DATE;
    public static final ColumnDefinition<String> USER_ID;

    static {
        LocalIdColumnDefinition localIdColumnDefinition = new LocalIdColumnDefinition(0, "_id");
        LOCAL_ID = localIdColumnDefinition;
        StringColumnDefinition stringColumnDefinition = new StringColumnDefinition(1, "name");
        NAME = stringColumnDefinition;
        StringColumnDefinition stringColumnDefinition2 = new StringColumnDefinition(2, "user_id");
        USER_ID = stringColumnDefinition2;
        StringColumnDefinition stringColumnDefinition3 = new StringColumnDefinition(3, ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID);
        ACTIVITY_TYPE_ID = stringColumnDefinition3;
        DateColumnDefinition dateColumnDefinition = new DateColumnDefinition(4, "create_date");
        CREATE_DATE = dateColumnDefinition;
        DateColumnDefinition dateColumnDefinition2 = new DateColumnDefinition(5, "update_date");
        UPDATE_DATE = dateColumnDefinition2;
        StringColumnDefinition stringColumnDefinition4 = new StringColumnDefinition(6, "configuration");
        CONFIGURATION = stringColumnDefinition4;
        COLUMNS = new ColumnDefinition[]{localIdColumnDefinition, stringColumnDefinition, stringColumnDefinition2, stringColumnDefinition3, dateColumnDefinition, dateColumnDefinition2, stringColumnDefinition4};
    }

    protected static ContentValues getContentValues(String str, String str2, String str3, Date date, Date date2, DataSourceConfigurationList dataSourceConfigurationList) {
        ContentValues contentValues = new ContentValues();
        NAME.write(str, contentValues);
        USER_ID.write(str2, contentValues);
        ACTIVITY_TYPE_ID.write(str3, contentValues);
        CREATE_DATE.write(date, contentValues);
        UPDATE_DATE.write(date2, contentValues);
        CONFIGURATION.write(getConfigurationOutputStream(dataSourceConfigurationList), contentValues);
        return contentValues;
    }

    protected static ContentValues getUpdateValues(Date date, DataSourceConfigurationList dataSourceConfigurationList) {
        ContentValues contentValues = new ContentValues();
        UPDATE_DATE.write(date, contentValues);
        if (dataSourceConfigurationList != null) {
            CONFIGURATION.write(getConfigurationOutputStream(dataSourceConfigurationList), contentValues);
        }
        return contentValues;
    }

    protected static String getConfigurationOutputStream(DataSourceConfigurationList dataSourceConfigurationList) {
        DataSourceConfigurationListWriter dataSourceConfigurationListWriter = new DataSourceConfigurationListWriter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            dataSourceConfigurationListWriter.write(dataSourceConfigurationList, byteArrayOutputStream);
        } catch (UaException e) {
            UaLog.error("Unable to serialize message producer configuration", (Throwable) e);
        }
        return byteArrayOutputStream.toString();
    }

    protected static List<RecorderConfiguration> getCachedConfigurations(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                RecorderConfigurationImpl recorderConfigurationImpl = new RecorderConfigurationImpl();
                recorderConfigurationImpl.setName(NAME.read(cursor));
                recorderConfigurationImpl.setActivityTypeRef(ActivityTypeRef.getBuilder().setActivityTypeId(ACTIVITY_TYPE_ID.read(cursor)).build());
                recorderConfigurationImpl.setUserRef((EntityRef<User>) new LinkEntityRef(USER_ID.read(cursor), "ref"));
                try {
                    DataSourceConfigurationList dataSourceConfigurationList = new DataSourceConfigurationListParser().parse(new ByteArrayInputStream(CONFIGURATION.read(cursor).getBytes()));
                    if (!dataSourceConfigurationList.isBluetoothDataSourceConfigurationEmpty()) {
                        Iterator<BluetoothSensorDataSourceConfiguration> it = dataSourceConfigurationList.getBluetoothDataSourceConfigurations().iterator();
                        while (it.hasNext()) {
                            recorderConfigurationImpl.addDataSource((DataSourceConfiguration) it.next());
                        }
                    }
                    if (!dataSourceConfigurationList.isLocationDataSourceConfigurationEmpty()) {
                        Iterator<LocationSensorDataSourceConfiguration> it2 = dataSourceConfigurationList.getLocationDataSourceConfigurations().iterator();
                        while (it2.hasNext()) {
                            recorderConfigurationImpl.addDataSource((DataSourceConfiguration) it2.next());
                        }
                    }
                    if (!dataSourceConfigurationList.isDerivedDataSourceConfigurationEmpty()) {
                        Iterator<DerivedDataSourceConfiguration> it3 = dataSourceConfigurationList.getDerivedDataSourceConfigurations().iterator();
                        while (it3.hasNext()) {
                            recorderConfigurationImpl.addDataSource((DataSourceConfiguration) it3.next());
                        }
                    }
                } catch (UaException e) {
                    UaLog.error("error parsing message producer configurations", (Throwable) e);
                }
                arrayList.add(recorderConfigurationImpl);
            } while (cursor.moveToNext());
            cursor.close();
            return arrayList;
        }
        cursor.close();
        return null;
    }
}
