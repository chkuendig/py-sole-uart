package com.soletreadmills.sole_v2._roomDataBase.summaryTempData;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: SummaryTempDataDatabase.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataDatabase;", "Landroidx/room/RoomDatabase;", "()V", "summaryTempDataDao", "Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataDao;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SummaryTempDataDatabase extends RoomDatabase {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile SummaryTempDataDatabase INSTANCE;

    public abstract SummaryTempDataDao summaryTempDataDao();

    /* compiled from: SummaryTempDataDatabase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/soletreadmills/sole_v2/_roomDataBase/summaryTempData/SummaryTempDataDatabase;", "getDatabase", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized SummaryTempDataDatabase getDatabase(Context context) {
            SummaryTempDataDatabase summaryTempDataDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            summaryTempDataDatabase = SummaryTempDataDatabase.INSTANCE;
            if (summaryTempDataDatabase == null) {
                synchronized (this) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    SummaryTempDataDatabase summaryTempDataDatabase2 = (SummaryTempDataDatabase) Room.databaseBuilder(applicationContext, SummaryTempDataDatabase.class, "summary_temp_data_database").addCallback(new RoomDatabase.Callback() { // from class: com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase$Companion$getDatabase$1$instance$1
                        @Override // androidx.room.RoomDatabase.Callback
                        public void onCreate(SupportSQLiteDatabase db) {
                            Intrinsics.checkNotNullParameter(db, "db");
                            super.onCreate(db);
                            Timber.INSTANCE.d("Callback onCreate Version=" + db.getVersion(), new Object[0]);
                        }

                        @Override // androidx.room.RoomDatabase.Callback
                        public void onOpen(SupportSQLiteDatabase db) {
                            Intrinsics.checkNotNullParameter(db, "db");
                            super.onOpen(db);
                            Timber.INSTANCE.d("Callback onOpen Version=" + db.getVersion(), new Object[0]);
                        }

                        @Override // androidx.room.RoomDatabase.Callback
                        public void onDestructiveMigration(SupportSQLiteDatabase db) {
                            Intrinsics.checkNotNullParameter(db, "db");
                            super.onDestructiveMigration(db);
                            Timber.INSTANCE.d("Callback onDestructiveMigration Version=" + db.getVersion(), new Object[0]);
                        }
                    }).allowMainThreadQueries().fallbackToDestructiveMigration().enableMultiInstanceInvalidation().build();
                    Companion companion = SummaryTempDataDatabase.INSTANCE;
                    SummaryTempDataDatabase.INSTANCE = summaryTempDataDatabase2;
                    if (summaryTempDataDatabase2 != null) {
                        Timber.INSTANCE.d("getDatabase isOpen=" + summaryTempDataDatabase2.isOpen(), new Object[0]);
                    } else {
                        summaryTempDataDatabase2 = null;
                    }
                    summaryTempDataDatabase = summaryTempDataDatabase2;
                    if (summaryTempDataDatabase == null) {
                        throw new IllegalStateException("Database initialization failed");
                    }
                }
            }
            return summaryTempDataDatabase;
        }
    }
}
