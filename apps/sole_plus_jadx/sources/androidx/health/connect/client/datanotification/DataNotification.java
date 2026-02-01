package androidx.health.connect.client.datanotification;

import android.content.Intent;
import androidx.health.connect.client.impl.converters.datatype.DataTypeConverterKt;
import androidx.health.connect.client.records.Record;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.utils.IntentExtKt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: DataNotification.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u001d\b\u0002\u0012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006R\u001f\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/datanotification/DataNotification;", "", "dataTypes", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "(Ljava/util/Set;)V", "getDataTypes", "()Ljava/util/Set;", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataNotification {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_DATA_TYPES = "com.google.android.healthdata.extra.DATA_TYPES";
    private final Set<KClass<? extends Record>> dataTypes;

    public /* synthetic */ DataNotification(Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(set);
    }

    @JvmStatic
    public static final DataNotification from(Intent intent) {
        return INSTANCE.from(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DataNotification(Set<? extends KClass<? extends Record>> set) {
        this.dataTypes = set;
    }

    public final Set<KClass<? extends Record>> getDataTypes() {
        return this.dataTypes;
    }

    /* compiled from: DataNotification.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/health/connect/client/datanotification/DataNotification$Companion;", "", "()V", "EXTRA_DATA_TYPES", "", "from", "Landroidx/health/connect/client/datanotification/DataNotification;", "intent", "Landroid/content/Intent;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DataNotification from(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            List protoMessages = IntentExtKt.getProtoMessages(intent, DataNotification.EXTRA_DATA_TYPES, DataNotification$Companion$from$dataTypes$1.INSTANCE);
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (protoMessages == null) {
                return null;
            }
            HashSet hashSet = new HashSet();
            Iterator it = protoMessages.iterator();
            while (it.hasNext()) {
                hashSet.add(DataTypeConverterKt.toDataTypeKClass((DataProto.DataType) it.next()));
            }
            return new DataNotification(hashSet, defaultConstructorMarker);
        }
    }
}
