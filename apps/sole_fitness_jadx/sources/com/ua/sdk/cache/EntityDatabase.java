package com.ua.sdk.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.provider.BaseColumns;
import com.ua.oss.de.greenrobot.dao.DbUtils;
import com.ua.sdk.Entity;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.LocalDate;
import com.ua.sdk.Reference;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.cache.database.definition.ColumnDefinition;
import com.ua.sdk.internal.AbstractEntityList;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.LinkListRef;
import com.ua.sdk.internal.Precondition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public abstract class EntityDatabase<T extends Entity> extends SQLiteOpenHelper implements DiskCache<T> {
    protected static final int ENTITY_DATABASE_VERSION = 0;
    protected final Context mContext;
    private final String[] mEntityCols;
    private final String mEntityKeyCol;
    private final String mEntityName;
    protected final String mEntityTable;
    private final String mLinksTable;
    private final String mListJoinTable;
    private final String mListTable;
    protected final String mMetaTable;
    protected static final Integer STATE_SYNCED = 0;
    protected static final Integer STATE_CREATED = 1;
    protected static final Integer STATE_MODIFIED = 2;
    protected static final Integer STATE_DELETED = 4;

    public static final class LINKS {
        public static final String TABLE_SUFFIX = "_links";

        public static final class COLS implements BaseColumns {
            public static final String ENTITY_ID = "entity_id";
            public static final String ENTITY_LIST_ID = "entity_list_id";
            public static final String HREF = "link_href";
            public static final String ID = "link_id";
            public static final String KEY = "link_key";
            public static final String NAME = "link_name";
            public static final String _ID = "_id";
        }
    }

    public static final class LIST {
        public static final String TABLE_SUFFIX = "_list";

        public static final class COLS {
            public static final String REMOTE_ID = "remote_id";
            public static final String TOTAL_COUNT = "total_count";
            public static final String _ID = "_id";
        }
    }

    public static final class LIST_JOIN {
        public static final String TABLE_SUFFIX = "_list_join";

        public static final class COLS {
            public static final String ENTITY_ID = "entity_id";
            public static final String ENTITY_LIST_ID = "entity_list_id";
            public static final String _ID = "_id";
        }
    }

    public static final class META {
        public static final String TABLE_SUFFIX = "_meta";

        public static final class COLS {
            public static final String ENTITY_ID = "entity_id";
            public static final String ENTITY_LIST_ID = "entity_list_id";
            public static final String OPTIONS = "options";
            public static final String PENDING_OPERATION = "pending_operation";
            public static final String UPDATE_TIME = "update_time";
            public static final String _ID = "_id";
        }
    }

    private static int getCombinedVersion(int i, int i2) {
        return i | (i2 << 15);
    }

    private static int getMyVersion(int i) {
        return i & 32767;
    }

    private static int getSubVersion(int i) {
        return (i & 536838144) >> 15;
    }

    protected abstract AbstractEntityList<T> createEntityList(long j, String str, int i);

    protected abstract void createEntityTable(SQLiteDatabase sQLiteDatabase);

    protected abstract ContentValues getContentValuesFromEntity(T t);

    protected abstract T getEntityFromCursor(Cursor cursor);

    public abstract void onEntityUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    protected void postSaveEntity(long j, T t) {
    }

    protected void preDeleteAll(SQLiteDatabase sQLiteDatabase) {
    }

    protected void preDeleteEntity(long j) {
    }

    protected EntityDatabase(Context context, String str, String str2, String[] strArr, String str3, int i) {
        super(context, str2, (SQLiteDatabase.CursorFactory) null, getCombinedVersion(0, i));
        this.mEntityName = str;
        this.mEntityTable = str + "_entity";
        this.mEntityKeyCol = str3;
        this.mEntityCols = strArr;
        this.mContext = context;
        this.mMetaTable = str + META.TABLE_SUFFIX;
        this.mListTable = str + LIST.TABLE_SUFFIX;
        this.mListJoinTable = str + LIST_JOIN.TABLE_SUFFIX;
        this.mLinksTable = str + LINKS.TABLE_SUFFIX;
        if (Arrays.binarySearch(strArr, "_id") < 0) {
            throw new IllegalArgumentException("entityCols do not contain _id");
        }
    }

    protected void executeSqlScript(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        try {
            UaLog.debug("Ran %d statements.", Integer.valueOf(DbUtils.executeSqlScript(this.mContext, sQLiteDatabase, this.mEntityName, str)));
        } catch (IOException e) {
            UaLog.error(str2, (Throwable) e);
            throw new RuntimeException(str2, e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (Build.VERSION.SDK_INT >= 16) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
        } else {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        createEntityTable(sQLiteDatabase);
        createMetaTables(sQLiteDatabase);
    }

    private void createMetaTables(SQLiteDatabase sQLiteDatabase) {
        executeSqlScript(sQLiteDatabase, "cache/entity_common/1_entity_common_create_table.sql", String.format("Fatal error, unable to initialize meta tables for %s database.", this.mEntityName));
    }

    protected void deleteEntitiesWithNullRemoteId(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (this.mEntityKeyCol != null) {
            sQLiteDatabase.execSQL("DELETE FROM " + this.mEntityTable + " WHERE " + this.mEntityKeyCol + " IS NULL AND _id IN ( SELECT entity_id FROM " + this.mMetaTable + " WHERE " + META.COLS.PENDING_OPERATION + " = " + STATE_SYNCED + ")");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        if (getMyVersion(i2) > getMyVersion(i)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.mEntityName + LINKS.TABLE_SUFFIX);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.mEntityName + META.TABLE_SUFFIX);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.mEntityName + LIST.TABLE_SUFFIX);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.mEntityName + LIST_JOIN.TABLE_SUFFIX);
            createMetaTables(sQLiteDatabase);
        }
        int subVersion = getSubVersion(i2);
        int subVersion2 = getSubVersion(i);
        if (subVersion > subVersion2) {
            onEntityUpgrade(sQLiteDatabase, subVersion2, subVersion);
        }
    }

    public static String buildCreateStatement(String str, ColumnDefinition[] columnDefinitionArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append(" (");
        int i = 0;
        while (i < columnDefinitionArr.length) {
            ColumnDefinition columnDefinition = columnDefinitionArr[i];
            sb.append(columnDefinition.getColumnName());
            sb.append(StringUtils.SPACE);
            sb.append(columnDefinition.getDbType());
            i++;
            if (i < columnDefinitionArr.length) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static String[] buildColumnNames(ColumnDefinition[] columnDefinitionArr) {
        String[] strArr = new String[columnDefinitionArr.length];
        for (int i = 0; i < columnDefinitionArr.length; i++) {
            strArr[i] = columnDefinitionArr[i].getColumnName();
        }
        return strArr;
    }

    private void insertOrReplaceMetadataAfterFetch(SQLiteDatabase sQLiteDatabase, String str, long j, int i) {
        insertOrReplaceMetadata(sQLiteDatabase, str, j, DiskCache.State.SYNCED, i, true);
    }

    private void insertOrUpdateMetadataState(SQLiteDatabase sQLiteDatabase, String str, long j, DiskCache.State state, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(META.COLS.PENDING_OPERATION, stateToDatabaseValue(state));
        contentValues.put("options", Integer.valueOf(i));
        if (sQLiteDatabase.update(this.mMetaTable, contentValues, str.equals("entity_id") ? "options=? AND entity_id=? AND entity_list_id IS NULL" : "options=? AND entity_list_id=? AND entity_id IS NULL", new String[]{String.valueOf(i), String.valueOf(j)}) == 0) {
            contentValues.put(str, Long.valueOf(j));
            sQLiteDatabase.insert(this.mMetaTable, null, contentValues);
        }
    }

    private void insertOrReplaceMetadata(SQLiteDatabase sQLiteDatabase, String str, long j, DiskCache.State state, int i, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(META.COLS.PENDING_OPERATION, stateToDatabaseValue(state));
        contentValues.put("options", Integer.valueOf(i));
        contentValues.put(str, Long.valueOf(j));
        if (z) {
            contentValues.put(META.COLS.UPDATE_TIME, Long.valueOf(System.currentTimeMillis()));
        }
        Cursor cursorQuery = sQLiteDatabase.query(this.mMetaTable, null, str.equals("entity_id") ? "options=? AND entity_id=? AND entity_list_id IS NULL" : "options=? AND entity_list_id=? AND entity_id IS NULL", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, null);
        try {
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                long jUpdate = sQLiteDatabase.update(this.mMetaTable, contentValues, "_id=?", new String[]{String.valueOf(cursorQuery.getLong(0))});
                UaLog.debug("Updated %s metadata rows", Long.valueOf(jUpdate));
                if (jUpdate > 1) {
                    UaLog.warn("Updated more than 1 entity meta row! Updated: " + jUpdate);
                }
            } else {
                UaLog.debug("Inserting metadata values: " + contentValues);
                long jInsert = sQLiteDatabase.insert(this.mMetaTable, null, contentValues);
                if (jInsert == -1) {
                    throw new RuntimeException("Fatal error! Could not store metadata for entity.");
                }
                UaLog.debug("Inserted or overwrote metadata row: " + jInsert);
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* renamed from: com.ua.sdk.cache.EntityDatabase$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$cache$DiskCache$State;

        static {
            int[] iArr = new int[DiskCache.State.values().length];
            $SwitchMap$com$ua$sdk$cache$DiskCache$State = iArr;
            try {
                iArr[DiskCache.State.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$cache$DiskCache$State[DiskCache.State.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$cache$DiskCache$State[DiskCache.State.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ua$sdk$cache$DiskCache$State[DiskCache.State.SYNCED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ua$sdk$cache$DiskCache$State[DiskCache.State.DELETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private Integer stateToDatabaseValue(DiskCache.State state) {
        if (state == null) {
            return null;
        }
        int i = AnonymousClass2.$SwitchMap$com$ua$sdk$cache$DiskCache$State[state.ordinal()];
        if (i == 2) {
            return STATE_CREATED;
        }
        if (i == 3) {
            return STATE_MODIFIED;
        }
        if (i == 4) {
            return STATE_SYNCED;
        }
        if (i != 5) {
            return null;
        }
        return STATE_DELETED;
    }

    private DiskCache.State stateFromDatabaseValue(int i) {
        if (i == STATE_CREATED.intValue()) {
            return DiskCache.State.CREATED;
        }
        if (i == STATE_DELETED.intValue()) {
            return DiskCache.State.DELETED;
        }
        if (i == STATE_MODIFIED.intValue()) {
            return DiskCache.State.MODIFIED;
        }
        if (i == STATE_SYNCED.intValue()) {
            return DiskCache.State.SYNCED;
        }
        return DiskCache.State.NONE;
    }

    private void bulkInsertLinks(SQLiteDatabase sQLiteDatabase, String str, long j, ApiTransferObject apiTransferObject) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("INSERT INTO " + this.mLinksTable + "(" + str + ", " + LINKS.COLS.KEY + ", " + LINKS.COLS.HREF + ", " + LINKS.COLS.ID + ", " + LINKS.COLS.NAME + ") VALUES (?,?,?,?,?);");
        try {
            Map<String, ArrayList<Link>> linkMap = apiTransferObject.getLinkMap();
            if (linkMap != null) {
                for (String str2 : linkMap.keySet()) {
                    for (Link link : linkMap.get(str2)) {
                        sQLiteStatementCompileStatement.clearBindings();
                        sQLiteStatementCompileStatement.bindLong(1, j);
                        sQLiteStatementCompileStatement.bindString(2, str2);
                        nullSafeBind(sQLiteStatementCompileStatement, 3, link.getHref());
                        nullSafeBind(sQLiteStatementCompileStatement, 4, link.getId());
                        nullSafeBind(sQLiteStatementCompileStatement, 5, link.getName());
                        sQLiteStatementCompileStatement.execute();
                    }
                }
            }
        } finally {
            sQLiteStatementCompileStatement.close();
        }
    }

    private void nullSafeBind(SQLiteStatement sQLiteStatement, int i, String str) {
        if (str != null) {
            sQLiteStatement.bindString(i, str);
        } else {
            sQLiteStatement.bindNull(i);
        }
    }

    public synchronized Map<String, ArrayList<Link>> getLinkMap(Reference reference) {
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            long listLocalId = -1;
            try {
                if (reference instanceof EntityRef) {
                    listLocalId = getEntityLocalId(readableDatabase, (EntityRef) reference);
                } else if (reference instanceof EntityListRef) {
                    listLocalId = getListLocalId(readableDatabase, (EntityListRef) reference);
                }
                if (listLocalId < 0) {
                    return Collections.emptyMap();
                }
                return getLinkMap(readableDatabase, getForeignKeyCol(reference), listLocalId);
            } finally {
                close();
            }
        } catch (Exception e) {
            UaLog.error("Unable to get link map.", (Throwable) e);
            return Collections.emptyMap();
        }
    }

    protected Map<String, ArrayList<Link>> getLinkMap(SQLiteDatabase sQLiteDatabase, String str, long j) {
        Cursor cursorQuery = sQLiteDatabase.query(this.mLinksTable, null, str + "=?", new String[]{String.valueOf(j)}, null, null, null, null);
        HashMap map = new HashMap();
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(LINKS.COLS.KEY));
                Link link = new Link(cursorQuery.getString(cursorQuery.getColumnIndex(LINKS.COLS.HREF)), cursorQuery.getString(cursorQuery.getColumnIndex(LINKS.COLS.ID)), cursorQuery.getString(cursorQuery.getColumnIndex(LINKS.COLS.NAME)));
                ArrayList arrayList = (ArrayList) map.get(string);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(string, arrayList);
                }
                arrayList.add(link);
            } finally {
                cursorQuery.close();
            }
        }
        return map;
    }

    protected <T extends ApiTransferObject> void setAllLinkMaps(SQLiteDatabase sQLiteDatabase, List<T> list) {
        int i;
        int i2;
        Cursor cursorQuery = sQLiteDatabase.query(this.mLinksTable, null, null, null, null, null, "entity_id ASC", null);
        try {
            int columnIndex = cursorQuery.getColumnIndex("entity_id");
            int columnIndex2 = cursorQuery.getColumnIndex(LINKS.COLS.KEY);
            int columnIndex3 = cursorQuery.getColumnIndex(LINKS.COLS.ID);
            int columnIndex4 = cursorQuery.getColumnIndex(LINKS.COLS.HREF);
            int columnIndex5 = cursorQuery.getColumnIndex(LINKS.COLS.NAME);
            int i3 = 0;
            int size = list.size();
            long j = -1;
            long localId = -1;
            ApiTransferObject apiTransferObject = null;
            Link link = null;
            HashMap map = null;
            String string = null;
            while (i3 < size && (link != null || !cursorQuery.isLast())) {
                if (apiTransferObject == null) {
                    apiTransferObject = (ApiTransferObject) list.get(i3);
                    map = new HashMap();
                    localId = apiTransferObject.getLocalId();
                }
                if (link == null) {
                    cursorQuery.moveToNext();
                    j = cursorQuery.getLong(columnIndex);
                    string = cursorQuery.getString(columnIndex2);
                    i = columnIndex;
                    i2 = columnIndex2;
                    link = new Link(cursorQuery.getString(columnIndex4), cursorQuery.getString(columnIndex3), cursorQuery.getString(columnIndex5));
                } else {
                    i = columnIndex;
                    i2 = columnIndex2;
                }
                String str = string;
                if (localId == j) {
                    ArrayList arrayList = (ArrayList) map.get(str);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map.put(str, arrayList);
                    }
                    arrayList.add(link);
                } else if (localId < j) {
                    if (!map.isEmpty()) {
                        apiTransferObject.setLinkMap(map);
                    }
                    i3++;
                    string = str;
                    columnIndex = i;
                    columnIndex2 = i2;
                    apiTransferObject = null;
                    map = null;
                }
                string = str;
                columnIndex = i;
                columnIndex2 = i2;
                link = null;
            }
            if (apiTransferObject != null && map != null) {
                apiTransferObject.setLinkMap(map);
            }
        } finally {
            cursorQuery.close();
        }
    }

    public synchronized void deleteAll() {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Exception e) {
            UaLog.error("Unable to delete all entities.", (Throwable) e);
        }
        try {
            preDeleteAll(writableDatabase);
            deleteAllEntities(writableDatabase);
            deleteAllLinks(writableDatabase);
            deleteAllMetadata(writableDatabase);
            deleteAllLists(writableDatabase);
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    protected void deleteAllLinksWithId(SQLiteDatabase sQLiteDatabase, String str, long j) {
        if (j < 0) {
            return;
        }
        sQLiteDatabase.delete(this.mLinksTable, str + "=?", new String[]{Long.toString(j)});
    }

    protected void deleteAllLinks(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DELETE FROM " + this.mLinksTable);
    }

    protected void deleteAllLists(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DELETE FROM " + this.mListTable);
        sQLiteDatabase.execSQL("DELETE FROM " + this.mListJoinTable);
    }

    protected void deleteAllMetadata(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DELETE FROM " + this.mMetaTable);
    }

    protected void deleteAllMetadataWithId(SQLiteDatabase sQLiteDatabase, String str, long j) {
        if (j < 0) {
            return;
        }
        sQLiteDatabase.delete(this.mMetaTable, str + "=?", new String[]{Long.toString(j)});
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected long getEntityLocalId(SQLiteDatabase sQLiteDatabase, EntityRef entityRef) {
        long localId;
        String id;
        if (entityRef instanceof LinkEntityRef) {
            LinkEntityRef linkEntityRef = (LinkEntityRef) entityRef;
            if (linkEntityRef.checkCache()) {
                localId = linkEntityRef.getLocalId();
                if (localId < 0) {
                    localId = -1;
                }
            }
        }
        if (localId == -1 && entityRef != null && (id = entityRef.getId()) != null) {
            Cursor cursorQuery = sQLiteDatabase.query(this.mEntityTable, new String[]{"_id"}, this.mEntityKeyCol + "= '" + id + "'", null, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    localId = cursorQuery.getLong(0);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return localId;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long getListLocalId(SQLiteDatabase sQLiteDatabase, EntityListRef entityListRef) {
        long localId;
        String href;
        if (entityListRef instanceof LinkListRef) {
            LinkListRef linkListRef = (LinkListRef) entityListRef;
            if (linkListRef.checkCache()) {
                localId = linkListRef.getLocalId();
                if (localId < 0) {
                    localId = -1;
                }
            }
        }
        if (localId == -1 && (href = entityListRef.getHref()) != null) {
            Cursor cursorQuery = sQLiteDatabase.query(this.mListTable, new String[]{"_id"}, "remote_id= '" + href + "'", null, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    localId = cursorQuery.getLong(0);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return localId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031 A[Catch: all -> 0x00a7, Exception -> 0x00a9, TRY_LEAVE, TryCatch #2 {all -> 0x00a7, blocks: (B:5:0x0007, B:7:0x000b, B:12:0x0019, B:14:0x0026, B:17:0x0031, B:22:0x003e, B:29:0x0093, B:36:0x00a0, B:34:0x009c, B:35:0x009f, B:42:0x00aa), top: B:53:0x0007, outer: #0, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[Catch: all -> 0x00b6, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:9:0x0014, B:19:0x0039, B:30:0x0096, B:37:0x00a3, B:46:0x00b2, B:47:0x00b5, B:5:0x0007, B:7:0x000b, B:12:0x0019, B:14:0x0026, B:17:0x0031, B:22:0x003e, B:29:0x0093, B:36:0x00a0, B:34:0x009c, B:35:0x009f, B:42:0x00aa), top: B:51:0x0001, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003e A[Catch: all -> 0x00a7, Exception -> 0x00a9, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00a7, blocks: (B:5:0x0007, B:7:0x000b, B:12:0x0019, B:14:0x0026, B:17:0x0031, B:22:0x003e, B:29:0x0093, B:36:0x00a0, B:34:0x009c, B:35:0x009f, B:42:0x00aa), top: B:53:0x0007, outer: #0, inners: #1 }] */
    @Override // com.ua.sdk.cache.DiskCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized T get(Reference reference) {
        String id;
        String str;
        Precondition.isNotNull(reference, "ref");
        try {
            try {
                if (!(reference instanceof LinkEntityRef)) {
                    id = null;
                    str = null;
                    if (str == null) {
                        str = this.mEntityKeyCol;
                        id = reference.getId();
                    }
                    if (id != null) {
                        return null;
                    }
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursorQuery = readableDatabase.query(this.mEntityTable, this.mEntityCols, str + "=?", new String[]{id}, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                T t = (T) getEntityFromCursor(cursorQuery);
                                if (t instanceof ApiTransferObject) {
                                    ((ApiTransferObject) t).setLinkMap(getLinkMap(readableDatabase, "entity_id", cursorQuery.getLong(cursorQuery.getColumnIndex("_id"))));
                                }
                                return t;
                            }
                        } finally {
                            cursorQuery.close();
                        }
                    }
                } else {
                    if (!((LinkEntityRef) reference).checkCache()) {
                        return null;
                    }
                    long localId = ((LinkEntityRef) reference).getLocalId();
                    if (localId >= 0) {
                        str = "_id";
                        id = String.valueOf(localId);
                    }
                    if (str == null) {
                    }
                    if (id != null) {
                    }
                }
            } catch (Exception e) {
                UaLog.error("Unable to get entity.", (Throwable) e);
            }
            return null;
        } finally {
            close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    @Override // com.ua.sdk.cache.DiskCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized EntityList<T> getList(Reference reference) {
        AbstractEntityList<T> abstractEntityListCreateEntityList;
        Precondition.isNotNull(reference, "ref");
        String href = reference.getHref();
        if (href == null) {
            return null;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursorQuery = readableDatabase.query(this.mListTable, new String[]{"_id", LIST.COLS.REMOTE_ID, LIST.COLS.TOTAL_COUNT}, LIST.COLS.REMOTE_ID + "=?", new String[]{href}, null, null, null, null);
        long j = -1;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    j = cursorQuery.getLong(0);
                    abstractEntityListCreateEntityList = createEntityList(j, cursorQuery.getString(1), cursorQuery.getInt(2));
                } else {
                    abstractEntityListCreateEntityList = null;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (abstractEntityListCreateEntityList == null) {
            return null;
        }
        abstractEntityListCreateEntityList.setLinkMap(getLinkMap(readableDatabase, "entity_list_id", j));
        getEntitiesForList(readableDatabase, abstractEntityListCreateEntityList, j);
        return abstractEntityListCreateEntityList;
    }

    void getEntitiesForList(SQLiteDatabase sQLiteDatabase, AbstractEntityList<T> abstractEntityList, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        for (int i = 0; i < this.mEntityCols.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("e.");
            sb.append(this.mEntityCols[i]);
        }
        sb.append(" FROM ");
        sb.append(this.mListJoinTable);
        sb.append(" AS j INNER JOIN ");
        sb.append(this.mEntityTable);
        sb.append(" AS e ON j.");
        sb.append("entity_id");
        sb.append(" = e._id WHERE j.");
        sb.append("entity_list_id");
        sb.append(" = ");
        sb.append(j);
        sb.append(" ORDER BY j._id ASC;");
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        ArrayList arrayList = new ArrayList();
        while (cursorRawQuery.moveToNext()) {
            try {
                Object entityFromCursor = getEntityFromCursor(cursorRawQuery);
                abstractEntityList.add(entityFromCursor);
                arrayList.add((ApiTransferObject) entityFromCursor);
            } catch (Throwable th) {
                cursorRawQuery.close();
                throw th;
            }
        }
        cursorRawQuery.close();
        Collections.sort(arrayList, new Comparator<ApiTransferObject>() { // from class: com.ua.sdk.cache.EntityDatabase.1
            @Override // java.util.Comparator
            public int compare(ApiTransferObject apiTransferObject, ApiTransferObject apiTransferObject2) {
                return (int) (apiTransferObject.getLocalId() - apiTransferObject2.getLocalId());
            }
        });
        setAllLinkMaps(sQLiteDatabase, arrayList);
    }

    protected ContentValues getContentValuesFromEntity(long j, T t) {
        EntityRef ref;
        String id;
        ContentValues contentValuesFromEntity = getContentValuesFromEntity(t);
        if (j >= 0) {
            contentValuesFromEntity.put("_id", Long.valueOf(j));
        } else {
            contentValuesFromEntity.remove("_id");
        }
        String str = this.mEntityKeyCol;
        if (str != null && contentValuesFromEntity.get(str) == null && (ref = t.getRef()) != null && (id = ref.getId()) != null) {
            contentValuesFromEntity.put(this.mEntityKeyCol, id);
        }
        return contentValuesFromEntity;
    }

    protected long deleteEntity(SQLiteDatabase sQLiteDatabase, EntityRef<T> entityRef) {
        int iDelete;
        long entityLocalId = getEntityLocalId(sQLiteDatabase, entityRef);
        preDeleteEntity(entityLocalId);
        if (entityLocalId >= 0 && (iDelete = sQLiteDatabase.delete(this.mEntityTable, "_id=?", new String[]{Long.toString(entityLocalId)})) != 1) {
            UaLog.error("Failed to delete entity. refType=%s id=%s rowsChanged=%s", entityRef.getClass().getSimpleName(), Long.valueOf(entityLocalId), Integer.valueOf(iDelete));
        }
        return entityLocalId;
    }

    public long deleteList(SQLiteDatabase sQLiteDatabase, EntityListRef<T> entityListRef) {
        int iDelete;
        long listLocalId = getListLocalId(sQLiteDatabase, entityListRef);
        if (listLocalId >= 0 && (iDelete = sQLiteDatabase.delete(this.mListTable, "_id=?", new String[]{Long.toString(listLocalId)})) != 1) {
            UaLog.error("Failed to delete entity list. refType=%s id=%s rowsChanged=%s", entityListRef.getClass().getSimpleName(), Long.valueOf(listLocalId), Integer.valueOf(iDelete));
        }
        return listLocalId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected long insert(SQLiteDatabase sQLiteDatabase, T t) throws SQLException {
        long jInsert = sQLiteDatabase.insert(this.mEntityTable, null, getContentValuesFromEntity(-1L, t));
        deleteAllLinksWithId(sQLiteDatabase, "entity_id", jInsert);
        if (t instanceof ApiTransferObject) {
            ApiTransferObject apiTransferObject = (ApiTransferObject) t;
            apiTransferObject.setLocalId(jInsert);
            bulkInsertLinks(sQLiteDatabase, "entity_id", jInsert, apiTransferObject);
        }
        postSaveEntity(jInsert, t);
        return jInsert;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void update(SQLiteDatabase sQLiteDatabase, long j, T t) throws SQLException {
        ContentValues contentValuesFromEntity = getContentValuesFromEntity(j, t);
        int iUpdate = sQLiteDatabase.update(this.mEntityTable, contentValuesFromEntity, "_id=" + j, null);
        if (iUpdate >= 1) {
            deleteAllLinksWithId(sQLiteDatabase, "entity_id", j);
            if (t instanceof ApiTransferObject) {
                ApiTransferObject apiTransferObject = (ApiTransferObject) t;
                apiTransferObject.setLocalId(j);
                bulkInsertLinks(sQLiteDatabase, "entity_id", j, apiTransferObject);
            }
        } else {
            UaLog.error("Failed to update entity. type=%s id=%s rowsChanged=%s", t.getClass().getSimpleName(), Long.valueOf(j), Integer.valueOf(iUpdate));
        }
        postSaveEntity(j, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected long insertOrUpdate(SQLiteDatabase sQLiteDatabase, T t) throws SQLException {
        long entityLocalId = getEntityLocalId(sQLiteDatabase, t.getRef());
        ContentValues contentValuesFromEntity = getContentValuesFromEntity(entityLocalId, t);
        if (entityLocalId > 0) {
            UaLog.debug("Updating existing entity with localId=%s", Long.valueOf(entityLocalId));
            sQLiteDatabase.update(this.mEntityTable, contentValuesFromEntity, "_id=?", new String[]{String.valueOf(entityLocalId)});
        } else {
            UaLog.debug("Adding a new entity using values: %s", contentValuesFromEntity);
            entityLocalId = sQLiteDatabase.insert(this.mEntityTable, null, contentValuesFromEntity);
        }
        deleteAllLinksWithId(sQLiteDatabase, "entity_id", entityLocalId);
        if (t instanceof ApiTransferObject) {
            ApiTransferObject apiTransferObject = (ApiTransferObject) t;
            apiTransferObject.setLocalId(entityLocalId);
            bulkInsertLinks(sQLiteDatabase, "entity_id", entityLocalId, apiTransferObject);
        }
        postSaveEntity(entityLocalId, t);
        return entityLocalId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long insertOrUpdateList(SQLiteDatabase sQLiteDatabase, EntityListRef<T> entityListRef, EntityList<T> entityList) throws SQLException, NullPointerException {
        Precondition.isNotNull(entityListRef, "entityList.getRef()");
        String href = entityListRef.getHref();
        Precondition.isNotNull(href, "entityList.getRef().getHref()");
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("INSERT OR REPLACE INTO " + this.mListTable + "(" + LIST.COLS.REMOTE_ID + ", " + LIST.COLS.TOTAL_COUNT + ") VALUES (?,?);");
        try {
            nullSafeBind(sQLiteStatementCompileStatement, 1, href);
            nullSafeBind(sQLiteStatementCompileStatement, 2, String.valueOf(entityList.getTotalCount()));
            long jExecuteInsert = sQLiteStatementCompileStatement.executeInsert();
            sQLiteStatementCompileStatement.close();
            bulkInsertLinks(sQLiteDatabase, "entity_list_id", jExecuteInsert, (ApiTransferObject) entityList);
            return jExecuteInsert;
        } catch (Throwable th) {
            sQLiteStatementCompileStatement.close();
            throw th;
        }
    }

    protected void deleteAllEntities(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DELETE FROM " + this.mEntityTable);
    }

    protected int getEntityOptions(Reference reference) {
        if (reference instanceof LinkEntityRef) {
            return ((LinkEntityRef) reference).getOptions();
        }
        UaLog.warn("Entity's ref not an instance of LinkEntityRef, so options aren't available (using default of 0).");
        return 0;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void updateAfterFetch(T t) {
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                insertOrReplaceMetadataAfterFetch(writableDatabase, "entity_id", insertOrUpdate(writableDatabase, t), getEntityOptions(t.getRef()));
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                UaLog.error("Failed to update the cache after fetch.", (Throwable) e);
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
            }
        } finally {
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
            close();
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void updateAfterFetch(EntityListRef<T> entityListRef, EntityList<T> entityList, boolean z) {
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                if (!z) {
                    long jInsertOrUpdateList = insertOrUpdateList(writableDatabase, entityListRef, entityList);
                    insertOrReplaceMetadataAfterFetch(writableDatabase, "entity_list_id", jInsertOrUpdateList, 0);
                    int size = entityList.getSize();
                    long[] jArr = new long[size];
                    for (int i = 0; i < size; i++) {
                        T t = entityList.get(i);
                        long entityLocalId = getEntityLocalId(writableDatabase, t.getRef());
                        if (entityLocalId >= 0) {
                            update(writableDatabase, entityLocalId, t);
                        } else {
                            entityLocalId = insert(writableDatabase, t);
                        }
                        long j = entityLocalId;
                        jArr[i] = j;
                        insertOrReplaceMetadataAfterFetch(writableDatabase, "entity_id", j, getEntityOptions(t.getRef()));
                    }
                    deleteListJoins(writableDatabase, jInsertOrUpdateList);
                    bulkInsertListJoin(writableDatabase, jInsertOrUpdateList, jArr);
                } else {
                    for (T t2 : entityList.getAll()) {
                        long entityLocalId2 = getEntityLocalId(writableDatabase, t2.getRef());
                        if (entityLocalId2 >= 0) {
                            update(writableDatabase, entityLocalId2, t2);
                        }
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                UaLog.error("Failed to update the cache after fetch.", (Throwable) e);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            }
        } finally {
            if (writableDatabase != null) {
                endTransaction(writableDatabase);
            }
            close();
        }
    }

    private void deleteListJoins(SQLiteDatabase sQLiteDatabase, long j) throws SQLException {
        sQLiteDatabase.execSQL("DELETE FROM " + this.mListJoinTable + " WHERE entity_list_id = " + j);
    }

    private void bulkInsertListJoin(SQLiteDatabase sQLiteDatabase, long j, long[] jArr) throws SQLException {
        if (jArr == null || jArr.length == 0) {
            return;
        }
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("INSERT OR IGNORE INTO " + this.mListJoinTable + " (entity_list_id, entity_id) VALUES (?,?);");
        for (long j2 : jArr) {
            try {
                sQLiteStatementCompileStatement.clearBindings();
                sQLiteStatementCompileStatement.bindLong(1, j);
                sQLiteStatementCompileStatement.bindLong(2, j2);
                sQLiteStatementCompileStatement.execute();
            } finally {
                sQLiteStatementCompileStatement.close();
            }
        }
    }

    private static void endTransaction(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e) {
            UaLog.error("Failed to end transaction.", (Throwable) e);
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void updateAfterCreate(long j, T t) {
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                update(writableDatabase, j, t);
                insertOrReplaceMetadataAfterFetch(writableDatabase, "entity_id", j, getEntityOptions(t.getRef()));
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                UaLog.error("Failed to update the cache after create", (Throwable) e);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            }
        } finally {
            if (writableDatabase != null) {
                endTransaction(writableDatabase);
            }
            close();
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized long putForCreate(T t) {
        long jInsertOrUpdate;
        jInsertOrUpdate = -1;
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                jInsertOrUpdate = insertOrUpdate(writableDatabase, t);
                insertOrUpdateMetadataState(writableDatabase, "entity_id", jInsertOrUpdate, DiskCache.State.CREATED, getEntityOptions(t.getRef()));
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                UaLog.error("Failed to put in cache for create.", (Throwable) e);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            }
        } finally {
            if (writableDatabase != null) {
                endTransaction(writableDatabase);
            }
            close();
        }
        return jInsertOrUpdate;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void putForSave(T t) {
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                insertOrUpdateMetadataState(writableDatabase, "entity_id", insertOrUpdate(writableDatabase, t), DiskCache.State.MODIFIED, getEntityOptions(t.getRef()));
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                UaLog.error("Failed to put in cache for save.", (Throwable) e);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            }
        } finally {
            if (writableDatabase != null) {
                endTransaction(writableDatabase);
            }
            close();
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void updateAfterSave(T t) {
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                insertOrReplaceMetadataAfterFetch(writableDatabase, "entity_id", insertOrUpdate(writableDatabase, t), getEntityOptions(t.getRef()));
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                UaLog.error("Failed to update the cache after save", (Throwable) e);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            }
        } finally {
            if (writableDatabase != null) {
                endTransaction(writableDatabase);
            }
            close();
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void markForDelete(Reference reference) {
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                insertOrUpdateMetadataState(writableDatabase, "entity_id", getEntityLocalId(writableDatabase, (EntityRef) reference), DiskCache.State.DELETED, getEntityOptions(reference));
            } catch (Exception e) {
                UaLog.error("Failed to mark the cache for delete.", (Throwable) e);
            }
        } finally {
            close();
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void delete(Reference reference) {
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                long jDeleteEntity = deleteEntity(writableDatabase, (EntityRef) reference);
                deleteAllMetadataWithId(writableDatabase, "entity_id", jDeleteEntity);
                deleteAllLinksWithId(writableDatabase, "entity_id", jDeleteEntity);
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                UaLog.error("Failed to update the cache after delete", (Throwable) e);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            }
        } finally {
            if (writableDatabase != null) {
                endTransaction(writableDatabase);
            }
            close();
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void deleteList(EntityListRef<T> entityListRef) {
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                long jDeleteList = deleteList(writableDatabase, entityListRef);
                deleteAllMetadataWithId(writableDatabase, "entity_list_id", jDeleteList);
                deleteAllLinksWithId(writableDatabase, "entity_list_id", jDeleteList);
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                UaLog.error("Failed to update the cache after delete", (Throwable) e);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            }
        } finally {
            if (writableDatabase != null) {
                endTransaction(writableDatabase);
            }
            close();
        }
    }

    private static String getForeignKeyCol(Reference reference) {
        return reference instanceof EntityListRef ? "entity_list_id" : "entity_id";
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized long getLastSynced(Reference reference) {
        if (reference == null) {
            return -1L;
        }
        if (reference instanceof EntityRef) {
            return getLastEntitySynced((EntityRef) reference);
        }
        if (reference instanceof EntityListRef) {
            return getLastEntityListSynced((EntityListRef) reference);
        }
        UaLog.error("Unknown reference type: " + reference.getClass().getCanonicalName());
        return -1L;
    }

    private synchronized long getLastEntityListSynced(EntityListRef entityListRef) {
        long j;
        j = -1;
        if (entityListRef != null) {
            Cursor cursorQuery = null;
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    long listLocalId = getListLocalId(readableDatabase, entityListRef);
                    if (listLocalId >= 0) {
                        cursorQuery = readableDatabase.query(this.mMetaTable, new String[]{META.COLS.UPDATE_TIME}, getForeignKeyCol(entityListRef) + "=?", new String[]{Long.toString(listLocalId)}, null, null, null);
                        if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                            j = cursorQuery.getLong(0);
                        }
                    }
                } catch (Exception e) {
                    UaLog.error("Unable to get last synced time.", (Throwable) e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                close();
            }
        }
        return j;
    }

    private synchronized long getLastEntitySynced(EntityRef entityRef) {
        long j;
        j = -1;
        if (entityRef != null) {
            Cursor cursorQuery = null;
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    long entityLocalId = getEntityLocalId(readableDatabase, entityRef);
                    if (entityLocalId >= 0) {
                        cursorQuery = readableDatabase.query(this.mMetaTable, new String[]{META.COLS.UPDATE_TIME}, getForeignKeyCol(entityRef) + "=?", new String[]{Long.toString(entityLocalId)}, null, null, null);
                        if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                            j = cursorQuery.getLong(0);
                        }
                    }
                } catch (Exception e) {
                    UaLog.error("Unable to get last synced time.", (Throwable) e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                close();
            }
        }
        return j;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public long getCacheAge(Reference reference) {
        if (reference == null) {
            return -1L;
        }
        long lastSynced = getLastSynced(reference);
        if (lastSynced >= 0) {
            return System.currentTimeMillis() - lastSynced;
        }
        return -1L;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized DiskCache.State getState(Reference reference) {
        DiskCache.State stateStateFromDatabaseValue;
        stateStateFromDatabaseValue = DiskCache.State.NONE;
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                long entityLocalId = getEntityLocalId(readableDatabase, (EntityRef) reference);
                if (entityLocalId >= 0) {
                    cursorQuery = readableDatabase.query(this.mMetaTable, new String[]{META.COLS.PENDING_OPERATION}, getForeignKeyCol(reference) + "=?", new String[]{Long.toString(entityLocalId)}, null, null, null);
                    if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                        stateStateFromDatabaseValue = stateFromDatabaseValue(cursorQuery.getInt(0));
                    }
                }
            } catch (Exception e) {
                UaLog.error("Unable to get cache state.", (Throwable) e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            close();
        }
        return stateStateFromDatabaseValue;
    }

    public static String readString(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }

    public static Boolean readBoolean(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Boolean.valueOf(cursor.getInt(i) == 1);
    }

    public static Integer readInteger(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    public static Long readLong(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }

    public static Double readDouble(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }

    public static Date readDate(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return new Date(cursor.getLong(i));
    }

    public static LocalDate readLocalDate(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return LocalDate.fromString(cursor.getString(i));
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Ljava/lang/Enum<TT;>;>(ILandroid/database/Cursor;Ljava/lang/Class<TT;>;)TT; */
    public static Enum readEnum(int i, Cursor cursor, Class cls) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Enum.valueOf(cls, cursor.getString(i));
    }

    public static void writeString(ContentValues contentValues, String str, String str2) {
        if (str2 == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, str2);
        }
    }

    public static void writeBoolean(ContentValues contentValues, String str, Boolean bool) {
        if (bool == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, bool);
        }
    }

    public static void writeInteger(ContentValues contentValues, String str, Integer num) {
        if (num == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, num);
        }
    }

    public static void writeLong(ContentValues contentValues, String str, Long l) {
        if (l == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, l);
        }
    }

    public static void writeDouble(ContentValues contentValues, String str, Double d) {
        if (d == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, d);
        }
    }

    public static void writeDate(ContentValues contentValues, String str, Date date) {
        if (date == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, Long.valueOf(date.getTime()));
        }
    }

    public static void writeLocalDate(ContentValues contentValues, String str, LocalDate localDate) {
        if (localDate == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, localDate.toString());
        }
    }

    public static void writeEnum(ContentValues contentValues, String str, Enum<?> r2) {
        if (r2 == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, r2.toString());
        }
    }
}
