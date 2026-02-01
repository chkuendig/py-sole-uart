package com.ua.sdk.cache.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.LocalDate;
import com.ua.sdk.Reference;
import com.ua.sdk.Resource;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.cache.database.definition.ColumnDefinition;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Precondition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public abstract class LegacyEntityDatabase<T extends Resource> extends SQLiteOpenHelper implements DiskCache<T> {
    protected static final int ENTITY_DATABASE_VERSION = 0;
    private static final String KEY_LINK_FOREIGN_KEY = "foreign_key";
    private static final String KEY_LINK_HREF = "href";
    private static final String KEY_LINK_ID = "id";
    private static final String KEY_LINK_NAME = "name";
    private static final String KEY_LINK_RELATION = "relation";
    private static final String KEY_META_ID = "id";
    private static final String KEY_META_LAST_UPDATE_TIME_MS = "last_update_time_ms";
    private static final String KEY_META_PENDING_OPERATION = "pending_operation";
    private static final String TABLE_LINKS = "links";
    private static final String TABLE_META = "meta";
    private final String[] mEntityCols;
    private final String mEntityKeyCol;
    private final String mEntityTable;
    private static final Integer STATE_SYNCED = 0;
    private static final Integer STATE_CREATED = 1;
    private static final Integer STATE_MODIFIED = 2;
    private static final Integer STATE_DELETED = 4;

    private static int getCombinedVersion(int i, int i2) {
        return i | (i2 << 15);
    }

    private static int getMyVersion(int i) {
        return i & 8191;
    }

    private static int getSubVersion(int i) {
        return (i & 536805376) >> 15;
    }

    protected abstract void createEntityTable(SQLiteDatabase sQLiteDatabase);

    @Override // com.ua.sdk.cache.DiskCache
    public void deleteList(EntityListRef<T> entityListRef) {
    }

    protected abstract ContentValues getContentValuesFromEntity(T t);

    protected abstract T getEntityFromCursor(Cursor cursor);

    @Override // com.ua.sdk.cache.DiskCache
    public EntityList<T> getList(Reference reference) {
        return null;
    }

    public abstract void onEntityUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    protected LegacyEntityDatabase(Context context, String str, String str2, String[] strArr, String str3, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, getCombinedVersion(0, i));
        this.mEntityTable = str2;
        this.mEntityKeyCol = str3;
        this.mEntityCols = strArr;
        if (Arrays.binarySearch(strArr, "_id") < 0) {
            throw new IllegalArgumentException("entityCols do not contain _id");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        createMetaTables(sQLiteDatabase);
        createEntityTable(sQLiteDatabase);
    }

    private void createMetaTables(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE links(foreign_key INTEGER NOT NULL,relation TEXT,href TEXT,id TEXT,name TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE meta(id INTEGER PRIMARY KEY UNIQUE NOT NULL,pending_operation NUMERIC,last_update_time_ms NUMERIC)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        if (getMyVersion(i2) > getMyVersion(i)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS links");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS meta");
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

    private void insertOrReplaceMetadataAfterFetch(SQLiteDatabase sQLiteDatabase, long j) {
        insertOrReplaceMetadata(sQLiteDatabase, j, System.currentTimeMillis(), DiskCache.State.SYNCED);
    }

    private void insertOrReplaceMetadata(SQLiteDatabase sQLiteDatabase, long j, DiskCache.State state) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pending_operation", stateToDatabaseValue(state));
        if (sQLiteDatabase.update(TABLE_META, contentValues, "id=?", new String[]{String.valueOf(j)}) == 0) {
            contentValues.put("id", Long.valueOf(j));
            sQLiteDatabase.insert(TABLE_META, null, contentValues);
        }
    }

    private void insertOrReplaceMetadata(SQLiteDatabase sQLiteDatabase, long j, long j2, DiskCache.State state) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(j));
        contentValues.put("pending_operation", stateToDatabaseValue(state));
        contentValues.put(KEY_META_LAST_UPDATE_TIME_MS, Long.valueOf(j2));
        sQLiteDatabase.insertWithOnConflict(TABLE_META, null, contentValues, 5);
    }

    /* renamed from: com.ua.sdk.cache.database.LegacyEntityDatabase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
        int i = AnonymousClass1.$SwitchMap$com$ua$sdk$cache$DiskCache$State[state.ordinal()];
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

    private void bulkInsertLinks(SQLiteDatabase sQLiteDatabase, long j, ApiTransferObject apiTransferObject) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("INSERT INTO links VALUES (?,?,?,?,?);");
        try {
            Map<String, ArrayList<Link>> linkMap = apiTransferObject.getLinkMap();
            if (linkMap != null) {
                for (String str : linkMap.keySet()) {
                    for (Link link : linkMap.get(str)) {
                        sQLiteStatementCompileStatement.clearBindings();
                        sQLiteStatementCompileStatement.bindLong(1, j);
                        sQLiteStatementCompileStatement.bindString(2, str);
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
            try {
                long localId = getLocalId(readableDatabase, reference);
                if (localId < 0) {
                    return Collections.emptyMap();
                }
                return getLinkMap(readableDatabase, localId);
            } finally {
                close();
            }
        } catch (Throwable th) {
            UaLog.error("Unable to get link map.", th);
            return Collections.emptyMap();
        }
    }

    protected Map<String, ArrayList<Link>> getLinkMap(SQLiteDatabase sQLiteDatabase, long j) {
        Cursor cursorQuery = sQLiteDatabase.query(TABLE_LINKS, null, "foreign_key=?", new String[]{String.valueOf(j)}, null, null, null, null);
        HashMap map = new HashMap();
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(KEY_LINK_RELATION));
                Link link = new Link(cursorQuery.getString(cursorQuery.getColumnIndex("href")), cursorQuery.getString(cursorQuery.getColumnIndex("id")), cursorQuery.getString(cursorQuery.getColumnIndex("name")));
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
        int i3;
        Cursor cursorQuery = sQLiteDatabase.query(TABLE_LINKS, null, null, null, null, null, "foreign_key ASC", null);
        try {
            int columnIndex = cursorQuery.getColumnIndex(KEY_LINK_FOREIGN_KEY);
            int columnIndex2 = cursorQuery.getColumnIndex(KEY_LINK_RELATION);
            int columnIndex3 = cursorQuery.getColumnIndex("id");
            int columnIndex4 = cursorQuery.getColumnIndex("href");
            int columnIndex5 = cursorQuery.getColumnIndex("name");
            int i4 = 0;
            int size = list.size();
            long j = -1;
            long localId = -1;
            HashMap map = null;
            ApiTransferObject apiTransferObject = null;
            Link link = null;
            String string = null;
            while (i4 < size && !cursorQuery.isLast()) {
                if (apiTransferObject == null) {
                    apiTransferObject = (ApiTransferObject) list.get(i4);
                    map = new HashMap();
                    localId = apiTransferObject.getLocalId();
                }
                if (link == null) {
                    cursorQuery.moveToNext();
                    j = cursorQuery.getLong(columnIndex);
                    string = cursorQuery.getString(columnIndex2);
                    i = columnIndex;
                    i2 = columnIndex2;
                    i3 = columnIndex3;
                    link = new Link(cursorQuery.getString(columnIndex4), cursorQuery.getString(columnIndex3), cursorQuery.getString(columnIndex5));
                } else {
                    i = columnIndex;
                    i2 = columnIndex2;
                    i3 = columnIndex3;
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
                    i4++;
                    string = str;
                    columnIndex = i;
                    columnIndex2 = i2;
                    columnIndex3 = i3;
                    map = null;
                    apiTransferObject = null;
                }
                string = str;
                columnIndex = i;
                columnIndex2 = i2;
                columnIndex3 = i3;
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
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                deleteAllEntities(writableDatabase);
                deleteAllLinks(writableDatabase);
                deleteAllMetadata(writableDatabase);
                close();
            } catch (Throwable th) {
                close();
                throw th;
            }
        } finally {
        }
    }

    protected void deleteAllLinksWithId(SQLiteDatabase sQLiteDatabase, long j) {
        if (j < 0) {
            return;
        }
        sQLiteDatabase.delete(TABLE_LINKS, "foreign_key=?", new String[]{Long.toString(j)});
    }

    protected void deleteAllLinks(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DELETE FROM links");
    }

    protected void deleteAllMetadata(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DELETE FROM meta");
    }

    protected void deleteAllMetadataWithId(SQLiteDatabase sQLiteDatabase, long j) {
        if (j < 0) {
            return;
        }
        sQLiteDatabase.delete(TABLE_META, "id=?", new String[]{Long.toString(j)});
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected long getLocalId(SQLiteDatabase sQLiteDatabase, Reference reference) {
        long localId;
        String id;
        if (reference instanceof LinkEntityRef) {
            LinkEntityRef linkEntityRef = (LinkEntityRef) reference;
            if (linkEntityRef.checkCache()) {
                localId = linkEntityRef.getLocalId();
                if (localId < 0) {
                    localId = -1;
                }
            }
        }
        if (localId == -1 && (id = reference.getId()) != null) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #2 {all -> 0x00a5, blocks: (B:6:0x000b, B:8:0x0011, B:18:0x0039, B:22:0x0044, B:11:0x001e, B:13:0x002b), top: B:58:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009e A[Catch: all -> 0x00bf, DONT_GENERATE, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0005, B:35:0x009e, B:36:0x00a1, B:42:0x00af, B:48:0x00b8, B:49:0x00bb, B:50:0x00be, B:40:0x00a8), top: B:60:0x0005, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.ua.sdk.Resource] */
    @Override // com.ua.sdk.cache.DiskCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized T get(Reference reference) {
        Throwable th;
        T t;
        String str;
        String id;
        boolean z;
        Precondition.isNotNull(reference, "ref");
        Cursor cursor = null;
        t = null;
        ?? entityFromCursor = 0;
        T t2 = null;
        Cursor cursor2 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
            t = null;
        }
        if (reference instanceof LinkEntityRef) {
            if (((LinkEntityRef) reference).checkCache()) {
                long localId = ((LinkEntityRef) reference).getLocalId();
                if (localId >= 0) {
                    str = "_id";
                    id = String.valueOf(localId);
                }
                z = true;
                if (z) {
                }
                if (z) {
                }
            } else {
                str = null;
                id = null;
                z = false;
                if (z) {
                    if (str == null) {
                        str = this.mEntityKeyCol;
                        id = reference.getId();
                    }
                    if (id == null) {
                        z = false;
                    }
                }
                if (z) {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursorQuery = readableDatabase.query(this.mEntityTable, this.mEntityCols, str + "=?", new String[]{id}, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                entityFromCursor = getEntityFromCursor(cursorQuery);
                                boolean z2 = entityFromCursor instanceof ApiTransferObject;
                                t2 = entityFromCursor;
                                if (z2) {
                                    ((ApiTransferObject) entityFromCursor).setLinkMap(getLinkMap(readableDatabase, cursorQuery.getLong(cursorQuery.getColumnIndex("_id"))));
                                    t2 = entityFromCursor;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            t = entityFromCursor;
                            cursor = cursorQuery;
                            try {
                                UaLog.error("Unable to get entity.", th);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return t;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                close();
                            }
                        }
                    }
                    t = t2;
                    cursor2 = cursorQuery;
                } else {
                    t = null;
                }
            }
        }
        str = null;
        id = null;
        z = true;
        if (z) {
        }
        if (z) {
        }
        return t;
    }

    protected ContentValues getContentValuesFromEntity(long j, T t) {
        ContentValues contentValuesFromEntity = getContentValuesFromEntity(t);
        if (j >= 0) {
            contentValuesFromEntity.put("_id", Long.valueOf(j));
        } else if (contentValuesFromEntity.containsKey("_id")) {
            contentValuesFromEntity.remove("_id");
        }
        return contentValuesFromEntity;
    }

    protected long delete(SQLiteDatabase sQLiteDatabase, Reference reference) {
        int iDelete;
        long localId = getLocalId(sQLiteDatabase, reference);
        if (localId >= 0 && (iDelete = sQLiteDatabase.delete(this.mEntityTable, "_id=?", new String[]{Long.toString(localId)})) != 1) {
            UaLog.error("Failed to delete entity. refType=%s id=%s rowsChanged=%s", reference.getClass().getSimpleName(), Long.valueOf(localId), Integer.valueOf(iDelete));
        }
        return localId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected long insert(SQLiteDatabase sQLiteDatabase, T t) throws SQLException {
        long jInsert = sQLiteDatabase.insert(this.mEntityTable, "_id", getContentValuesFromEntity(-1L, t));
        deleteAllLinksWithId(sQLiteDatabase, jInsert);
        if (t instanceof ApiTransferObject) {
            ApiTransferObject apiTransferObject = (ApiTransferObject) t;
            apiTransferObject.setLocalId(jInsert);
            bulkInsertLinks(sQLiteDatabase, jInsert, apiTransferObject);
        }
        return jInsert;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void update(SQLiteDatabase sQLiteDatabase, long j, T t) throws SQLException {
        ContentValues contentValuesFromEntity = getContentValuesFromEntity(j, t);
        int iUpdate = sQLiteDatabase.update(this.mEntityTable, contentValuesFromEntity, "_id=" + j, null);
        if (iUpdate < 1) {
            UaLog.error("Failed to update entity. type=%s id=%s rowsChanged=%s", t.getClass().getSimpleName(), Long.valueOf(j), Integer.valueOf(iUpdate));
            return;
        }
        deleteAllLinksWithId(sQLiteDatabase, j);
        if (t instanceof ApiTransferObject) {
            ApiTransferObject apiTransferObject = (ApiTransferObject) t;
            apiTransferObject.setLocalId(j);
            bulkInsertLinks(sQLiteDatabase, j, apiTransferObject);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected long insertOrUpdate(SQLiteDatabase sQLiteDatabase, T t) throws SQLException {
        long jInsertWithOnConflict = sQLiteDatabase.insertWithOnConflict(this.mEntityTable, "_id", getContentValuesFromEntity(getLocalId(sQLiteDatabase, t.getRef()), t), 5);
        deleteAllLinksWithId(sQLiteDatabase, jInsertWithOnConflict);
        if (t instanceof ApiTransferObject) {
            ApiTransferObject apiTransferObject = (ApiTransferObject) t;
            apiTransferObject.setLocalId(jInsertWithOnConflict);
            bulkInsertLinks(sQLiteDatabase, jInsertWithOnConflict, apiTransferObject);
        }
        return jInsertWithOnConflict;
    }

    protected void deleteAllEntities(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DELETE FROM " + this.mEntityTable);
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void updateAfterFetch(T t) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                insertOrReplaceMetadataAfterFetch(writableDatabase, insertOrUpdate(writableDatabase, t));
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                th = th;
                try {
                    UaLog.error("Failed to update the cache after fetch.", th);
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                    }
                } finally {
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                    }
                    close();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void updateAfterFetch(EntityListRef<T> entityListRef, EntityList<T> entityList, boolean z) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            writableDatabase = null;
        }
        try {
            writableDatabase.beginTransaction();
            for (T t : entityList.getAll()) {
                long localId = getLocalId(writableDatabase, t.getRef());
                if (z) {
                    if (localId >= 0) {
                        update(writableDatabase, localId, t);
                    }
                } else if (localId >= 0) {
                    update(writableDatabase, localId, t);
                    insertOrReplaceMetadataAfterFetch(writableDatabase, localId);
                } else {
                    insertOrReplaceMetadataAfterFetch(writableDatabase, insert(writableDatabase, t));
                }
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable th2) {
            th = th2;
            try {
                UaLog.error("Failed to update the cache after fetch.", th);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            } finally {
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
                close();
            }
        }
    }

    private static void endTransaction(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            UaLog.error("Failed to end transaction.", th);
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void updateAfterCreate(long j, T t) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                update(writableDatabase, j, t);
                insertOrReplaceMetadataAfterFetch(writableDatabase, j);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                th = th;
                try {
                    UaLog.error("Failed to update the cache after create", th);
                    if (writableDatabase != null) {
                        endTransaction(writableDatabase);
                    }
                } finally {
                    if (writableDatabase != null) {
                        endTransaction(writableDatabase);
                    }
                    close();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized long putForCreate(T t) {
        long jInsertOrUpdate;
        SQLiteDatabase writableDatabase;
        jInsertOrUpdate = -1;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            writableDatabase = null;
        }
        try {
            writableDatabase.beginTransaction();
            jInsertOrUpdate = insertOrUpdate(writableDatabase, t);
            insertOrReplaceMetadata(writableDatabase, jInsertOrUpdate, DiskCache.State.CREATED);
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable th2) {
            th = th2;
            try {
                UaLog.error("Failed to put in cache for create.", th);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
                return jInsertOrUpdate;
            } finally {
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
                close();
            }
        }
        return jInsertOrUpdate;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void putForSave(T t) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                insertOrReplaceMetadata(writableDatabase, insertOrUpdate(writableDatabase, t), DiskCache.State.MODIFIED);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                th = th;
                try {
                    UaLog.error("Failed to put in cache for save.", th);
                    if (writableDatabase != null) {
                        endTransaction(writableDatabase);
                    }
                } finally {
                    if (writableDatabase != null) {
                        endTransaction(writableDatabase);
                    }
                    close();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void updateAfterSave(T t) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                insertOrReplaceMetadataAfterFetch(writableDatabase, insertOrUpdate(writableDatabase, t));
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                th = th;
                try {
                    UaLog.error("Failed to update the cache after save", th);
                    if (writableDatabase != null) {
                        endTransaction(writableDatabase);
                    }
                } finally {
                    if (writableDatabase != null) {
                        endTransaction(writableDatabase);
                    }
                    close();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void markForDelete(Reference reference) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            insertOrReplaceMetadata(writableDatabase, getLocalId(writableDatabase, reference), DiskCache.State.DELETED);
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized void delete(Reference reference) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            writableDatabase = null;
        }
        try {
            writableDatabase.beginTransaction();
            long jDelete = delete(writableDatabase, reference);
            deleteAllMetadataWithId(writableDatabase, jDelete);
            deleteAllLinksWithId(writableDatabase, jDelete);
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable th2) {
            th = th2;
            try {
                UaLog.error("Failed to update the cache after delete", th);
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
            } finally {
                if (writableDatabase != null) {
                    endTransaction(writableDatabase);
                }
                close();
            }
        }
    }

    @Override // com.ua.sdk.cache.DiskCache
    public synchronized long getLastSynced(Reference reference) {
        long j;
        j = -1;
        if (reference != null) {
            Cursor cursorQuery = null;
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                long localId = getLocalId(readableDatabase, reference);
                if (localId >= 0) {
                    cursorQuery = readableDatabase.query(TABLE_META, new String[]{KEY_META_LAST_UPDATE_TIME_MS}, "id=?", new String[]{Long.toString(localId)}, null, null, null);
                    if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                        j = cursorQuery.getLong(0);
                    }
                }
            } catch (Throwable th) {
                try {
                    UaLog.error("Unable to get last synced time.", th);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    close();
                }
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
            SQLiteDatabase readableDatabase = getReadableDatabase();
            long localId = getLocalId(readableDatabase, reference);
            if (localId >= 0) {
                cursorQuery = readableDatabase.query(TABLE_META, new String[]{"pending_operation"}, "id=?", new String[]{Long.toString(localId)}, null, null, null);
                if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                    stateStateFromDatabaseValue = stateFromDatabaseValue(cursorQuery.getInt(0));
                }
            }
        } catch (Throwable th) {
            try {
                UaLog.error("Unable to get cache state.", th);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                close();
            }
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
