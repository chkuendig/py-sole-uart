package com.samsung.android.sdk.healthdata;

import android.app.Activity;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import com.blankj.utilcode.constant.CacheConstants;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.internal.database.BulkCursorDescriptor;
import com.samsung.android.sdk.internal.database.BulkCursorToCursorAdaptor;
import com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl;
import com.samsung.android.sdk.internal.healthdata.DeleteRequestImpl;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;
import com.samsung.android.sdk.internal.healthdata.InsertRequestImpl;
import com.samsung.android.sdk.internal.healthdata.IpcUtil;
import com.samsung.android.sdk.internal.healthdata.ReadRequestImpl;
import com.samsung.android.sdk.internal.healthdata.RemoteConnectionException;
import com.samsung.android.sdk.internal.healthdata.StreamUtil;
import com.samsung.android.sdk.internal.healthdata.UpdateRequestImpl;
import com.samsung.android.sdk.internal.healthdata.query.AndFilter;
import com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter;
import com.samsung.android.sdk.internal.healthdata.query.NotFilter;
import com.samsung.android.sdk.internal.healthdata.query.NumberArrayFilter;
import com.samsung.android.sdk.internal.healthdata.query.OrFilter;
import com.samsung.android.sdk.internal.healthdata.query.StringArrayFilter;
import com.samsung.android.sdk.internal.healthdata.query.StringFilter;
import com.samsung.android.sdk.internal.interfaces.ParcelFdSupplier;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class HealthDataResolver {
    private final HealthDataStore a;
    private final Handler b;

    public static class AggregateResult extends HealthResultHolder.BaseResult implements Iterable<HealthData>, Closeable {
        public static final Parcelable.Creator<AggregateResult> CREATOR = new a();
        private final BulkCursorDescriptor d;
        private final String e;
        private Cursor f;

        static class a implements Parcelable.Creator<AggregateResult> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public AggregateResult createFromParcel(Parcel parcel) {
                return new AggregateResult(parcel, (a) null);
            }

            @Override // android.os.Parcelable.Creator
            public AggregateResult[] newArray(int i) {
                return new AggregateResult[i];
            }
        }

        /* synthetic */ AggregateResult(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Cursor resultCursor = getResultCursor();
            if (resultCursor == null) {
                return;
            }
            if (resultCursor.isClosed()) {
                throw new IllegalStateException("calling close() when ReadResult or ResultCursor is already closed");
            }
            resultCursor.close();
        }

        public String getDataType() {
            return this.e;
        }

        public Cursor getResultCursor() {
            if (this.d == null) {
                return null;
            }
            synchronized (this) {
                if (this.f == null) {
                    BulkCursorToCursorAdaptor bulkCursorToCursorAdaptor = new BulkCursorToCursorAdaptor();
                    bulkCursorToCursorAdaptor.initialize(this.d);
                    this.f = bulkCursorToCursorAdaptor;
                }
            }
            return this.f;
        }

        @Override // java.lang.Iterable
        public Iterator<HealthData> iterator() {
            Cursor resultCursor = getResultCursor();
            return resultCursor == null ? Collections.emptyIterator() : new d(null, null, resultCursor, null);
        }

        @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.e);
            parcel.writeParcelable(this.d, i);
        }

        public AggregateResult(String str, int i, int i2) {
            super(i, i2);
            this.e = str;
            this.d = null;
        }

        public AggregateResult(String str, int i, BulkCursorDescriptor bulkCursorDescriptor) {
            super(i, bulkCursorDescriptor != null ? bulkCursorDescriptor.count : 0);
            this.e = str;
            this.d = bulkCursorDescriptor;
        }

        public AggregateResult(String str, BulkCursorDescriptor bulkCursorDescriptor) {
            super(bulkCursorDescriptor != null ? 1 : 4, bulkCursorDescriptor != null ? bulkCursorDescriptor.count : 0);
            this.e = str;
            this.d = bulkCursorDescriptor;
        }

        private AggregateResult(Parcel parcel) {
            super(parcel);
            this.e = parcel.readString();
            this.d = (BulkCursorDescriptor) parcel.readParcelable(BulkCursorDescriptor.class.getClassLoader());
        }
    }

    public interface DeleteRequest {

        public static class Builder {
            private String a;
            private Filter b;
            private List<String> c;
            private boolean d = false;
            private String e;
            private String f;
            private long g;
            private long h;

            public DeleteRequest build() {
                String str = this.a;
                if (str == null || "".equals(str)) {
                    throw new IllegalStateException("No data type or invalid data type is specified");
                }
                List<String> list = this.c;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == null) {
                            throw new IllegalStateException("Null device uuid");
                        }
                    }
                }
                if (this.d && (this.e == null || this.f == null || this.g >= this.h)) {
                    throw new IllegalStateException("Illegal local time range is specified");
                }
                return new DeleteRequestImpl(this.a, this.b, this.c, this.e, this.f, Long.valueOf(this.g), Long.valueOf(this.h));
            }

            public Builder setDataType(String str) {
                this.a = str;
                return this;
            }

            public Builder setFilter(Filter filter) {
                this.b = filter;
                return this;
            }

            public Builder setLocalTimeRange(String str, String str2, long j, long j2) {
                this.d = true;
                this.e = str;
                this.f = str2;
                this.g = j;
                this.h = j2;
                return this;
            }

            public Builder setSourceDevices(List<String> list) {
                this.c = list;
                return this;
            }
        }
    }

    public interface InsertRequest {

        public static class Builder {
            private String a;

            public InsertRequest build() {
                String str = this.a;
                if (str == null || "".equals(str)) {
                    throw new IllegalStateException("No data type or invalid data type is specified");
                }
                return new InsertRequestImpl(this.a);
            }

            public Builder setDataType(String str) {
                this.a = str;
                return this;
            }
        }

        void addHealthData(HealthData healthData);

        void addHealthData(List<HealthData> list);
    }

    public interface ReadRequest {

        public static class Builder {
            private String a;
            private String b;
            private Filter c;
            private String d;
            private SortOrder e;
            private List<String> f;
            private String[] l;
            private String t;
            private String u;
            private long v;
            private long w;
            private long g = -1;
            private long h = -1;
            private int i = 0;
            private int j = -1;
            private int k = 0;
            private final List<ReadRequestImpl.Projection> m = new ArrayList();
            private String n = null;
            private String o = null;
            private long p = -1;
            private boolean q = false;
            private boolean r = false;
            private boolean s = false;

            public ReadRequest build() {
                String str;
                if (this.q && this.p < 0) {
                    throw new IllegalStateException("Illegal setTimeAfter value is specified");
                }
                if (this.r && this.h < 0) {
                    throw new IllegalStateException("Illegal setTimeBefore value is specified");
                }
                String str2 = this.a;
                if (str2 == null || "".equals(str2)) {
                    throw new IllegalStateException("No data type or invalid data type is specified");
                }
                if (this.s && (this.t == null || this.u == null || this.v >= this.w)) {
                    throw new IllegalStateException("Illegal local time range is specified");
                }
                if (this.o != null) {
                    throw new IllegalStateException(this.o);
                }
                if (this.n != null) {
                    throw new IllegalStateException(this.n);
                }
                for (ReadRequestImpl.Projection projection : this.m) {
                    if (projection.getAlias() == null || projection.getAlias().isEmpty()) {
                        throw new IllegalStateException("Null or empty alias for read request is not allowed");
                    }
                }
                List<String> list = this.f;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == null) {
                            throw new IllegalStateException("Null device uuid");
                        }
                    }
                }
                String str3 = this.d;
                if (str3 != null) {
                    if (this.e != null) {
                        str3 = this.d + " " + this.e.toSqlLiteral();
                    }
                    str = str3;
                } else {
                    str = null;
                }
                if (this.k != 1) {
                    this.j = 0;
                } else {
                    if (this.j <= 0) {
                        throw new IllegalStateException("Wrong count (zero or negative number)");
                    }
                    if (this.i < 0) {
                        throw new IllegalStateException("Wrong offset (negative number)");
                    }
                }
                int size = this.m.size();
                String[] strArr = this.l;
                if (strArr == null || strArr.length == 0) {
                    return new ReadRequestImpl(this.a, this.b, this.c, size > 0 ? this.m : null, this.f, (byte) 1, str, this.g, this.h, this.i, this.j, this.p, this.t, this.u, Long.valueOf(this.v), Long.valueOf(this.w));
                }
                ArrayList arrayList = new ArrayList(this.l.length);
                for (String str4 : this.l) {
                    int i = 0;
                    while (i < size) {
                        String property = this.m.get(i).getProperty();
                        if (str4 != null && str4.equalsIgnoreCase(property)) {
                            break;
                        }
                        i++;
                    }
                    if (i < size) {
                        arrayList.add(this.m.remove(i));
                        size--;
                    } else {
                        arrayList.add(new ReadRequestImpl.Projection(str4, null));
                    }
                }
                if (size == 0 || this.m.size() <= 0) {
                    return new ReadRequestImpl(this.a, this.b, this.c, arrayList, this.f, (byte) 0, str, this.g, this.h, this.i, this.j, this.p, this.t, this.u, Long.valueOf(this.v), Long.valueOf(this.w));
                }
                throw new IllegalStateException("Not matched aliases");
            }

            public Builder setDataType(String str) {
                this.a = str;
                return this;
            }

            public Builder setFilter(Filter filter) {
                this.c = filter;
                return this;
            }

            public Builder setLocalTimeRange(String str, String str2, long j, long j2) {
                this.s = true;
                this.t = str;
                this.u = str2;
                this.v = j;
                this.w = j2;
                return this;
            }

            public Builder setPackageName(String str) {
                this.b = str;
                return this;
            }

            public Builder setProperties(String[] strArr) {
                if (strArr == null) {
                    this.l = null;
                } else {
                    this.l = new String[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        String str = strArr[i];
                        if (str == null || str.isEmpty()) {
                            this.n = "Null or empty property for read request is not allowed";
                            break;
                        }
                        this.l[i] = str;
                    }
                }
                return this;
            }

            public Builder setPropertyAlias(String str, String str2) {
                try {
                    this.m.add(new ReadRequestImpl.Projection(str, str2));
                } catch (IllegalArgumentException e) {
                    this.o = e.getMessage();
                }
                return this;
            }

            public Builder setResultCount(int i, int i2) {
                this.i = i;
                this.j = i2;
                this.k = 1;
                return this;
            }

            public Builder setSort(String str, SortOrder sortOrder) {
                this.d = str;
                this.e = sortOrder;
                return this;
            }

            public Builder setSourceDevices(List<String> list) {
                this.f = list;
                return this;
            }

            public Builder setTimeAfter(long j) {
                this.p = j;
                this.q = true;
                return this;
            }

            public Builder setTimeBefore(long j) {
                this.h = j;
                this.r = true;
                return this;
            }
        }
    }

    public static class ReadResult extends HealthResultHolder.BaseResult implements Iterable<HealthData>, Closeable {
        public static final Parcelable.Creator<ReadResult> CREATOR = new a();
        private final BulkCursorDescriptor d;
        private final String e;
        private Cursor f;
        private IDataResolver g;
        private String h;

        static class a implements Parcelable.Creator<ReadResult> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public ReadResult createFromParcel(Parcel parcel) {
                return new ReadResult(parcel, (a) null);
            }

            @Override // android.os.Parcelable.Creator
            public ReadResult[] newArray(int i) {
                return new ReadResult[i];
            }
        }

        /* synthetic */ ReadResult(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Cursor resultCursor = getResultCursor();
            if (resultCursor == null) {
                return;
            }
            if (resultCursor.isClosed()) {
                throw new IllegalStateException("calling close() when ReadResult or ResultCursor is already closed");
            }
            resultCursor.close();
        }

        public String getDataType() {
            return this.e;
        }

        public Cursor getResultCursor() {
            if (this.d == null) {
                return null;
            }
            synchronized (this) {
                if (this.f == null) {
                    BulkCursorToCursorAdaptor bulkCursorToCursorAdaptor = new BulkCursorToCursorAdaptor();
                    bulkCursorToCursorAdaptor.initialize(this.d);
                    bulkCursorToCursorAdaptor.setFileTransferChannel(this.g, this.h);
                    this.f = bulkCursorToCursorAdaptor;
                }
            }
            return this.f;
        }

        @Override // java.lang.Iterable
        public Iterator<HealthData> iterator() {
            Cursor resultCursor = getResultCursor();
            return resultCursor == null ? Collections.emptyIterator() : new d(this.g, this.h, resultCursor, this);
        }

        public ReadResult setResolver(IDataResolver iDataResolver) {
            if (this.g == null) {
                this.g = iDataResolver;
            }
            return this;
        }

        public void setResultId(String str) {
            if (this.h == null) {
                this.h = str;
            }
        }

        @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.e);
            parcel.writeParcelable(this.d, 0);
        }

        public ReadResult(String str, int i, int i2) {
            super(i, i2);
            this.e = str;
            this.d = null;
        }

        public ReadResult(String str, int i, BulkCursorDescriptor bulkCursorDescriptor) {
            super(i, bulkCursorDescriptor != null ? bulkCursorDescriptor.count : 0);
            this.e = str;
            this.d = bulkCursorDescriptor;
        }

        public ReadResult(String str, BulkCursorDescriptor bulkCursorDescriptor) {
            super(1, bulkCursorDescriptor != null ? bulkCursorDescriptor.count : 0);
            this.e = str;
            this.d = bulkCursorDescriptor;
        }

        private ReadResult(Parcel parcel) {
            super(parcel);
            this.e = parcel.readString();
            this.d = (BulkCursorDescriptor) parcel.readParcelable(BulkCursorDescriptor.class.getClassLoader());
        }
    }

    public enum SortOrder {
        ASC { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.SortOrder.1
            @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.SortOrder
            public String toSqlLiteral() {
                return "ASC";
            }
        },
        DESC { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.SortOrder.2
            @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.SortOrder
            public String toSqlLiteral() {
                return "DESC";
            }
        };

        public abstract String toSqlLiteral();

        /* synthetic */ SortOrder(a aVar) {
            this();
        }
    }

    public interface UpdateRequest {

        public static class Builder {
            private String a;
            private HealthData b;
            private Filter c;
            private List<String> d;
            private boolean e = false;
            private String f;
            private String g;
            private long h;
            private long i;

            public UpdateRequest build() {
                String str = this.a;
                if (str == null || "".equals(str) || this.b == null) {
                    throw new IllegalStateException("at least valid one of data type or health data object is not specified");
                }
                List<String> list = this.d;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == null) {
                            throw new IllegalStateException("Null device uuid");
                        }
                    }
                }
                if (this.e && (this.f == null || this.g == null || this.h >= this.i)) {
                    throw new IllegalStateException("Illegal local time range is specified");
                }
                return new UpdateRequestImpl(this.a, this.b, this.c, this.d, this.f, this.g, Long.valueOf(this.h), Long.valueOf(this.i));
            }

            public Builder setDataType(String str) {
                this.a = str;
                return this;
            }

            public Builder setFilter(Filter filter) {
                this.c = filter;
                return this;
            }

            public Builder setHealthData(HealthData healthData) {
                this.b = healthData;
                return this;
            }

            public Builder setLocalTimeRange(String str, String str2, long j, long j2) {
                this.e = true;
                this.f = str;
                this.g = str2;
                this.h = j;
                this.i = j2;
                return this;
            }

            public Builder setSourceDevices(List<String> list) {
                this.d = list;
                return this;
            }
        }
    }

    class a implements ParcelFdSupplier {
        final /* synthetic */ IDataResolver a;
        final /* synthetic */ InsertRequestImpl b;
        final /* synthetic */ String c;

        a(HealthDataResolver healthDataResolver, IDataResolver iDataResolver, InsertRequestImpl insertRequestImpl, String str) {
            this.a = iDataResolver;
            this.b = insertRequestImpl;
            this.c = str;
        }

        @Override // com.samsung.android.sdk.internal.interfaces.ParcelFdSupplier
        public ParcelFileDescriptor get(String str, String str2) throws RemoteException {
            return this.a.requestBlobTransferChannel(HealthDataStore.getClientPackageName(), this.b.getDataType(), str, this.c, str2);
        }
    }

    class b implements ParcelFdSupplier {
        final /* synthetic */ IDataResolver a;
        final /* synthetic */ InsertRequestImpl b;
        final /* synthetic */ String c;

        b(HealthDataResolver healthDataResolver, IDataResolver iDataResolver, InsertRequestImpl insertRequestImpl, String str) {
            this.a = iDataResolver;
            this.b = insertRequestImpl;
            this.c = str;
        }

        @Override // com.samsung.android.sdk.internal.interfaces.ParcelFdSupplier
        public ParcelFileDescriptor get(String str, String str2) throws RemoteException {
            return this.a.requestBlobTransferChannel(HealthDataStore.getClientPackageName(), this.b.getDataType(), str, this.c, str2);
        }
    }

    class c implements ParcelFdSupplier {
        final /* synthetic */ IDataResolver a;
        final /* synthetic */ UpdateRequestImpl b;
        final /* synthetic */ String c;

        c(HealthDataResolver healthDataResolver, IDataResolver iDataResolver, UpdateRequestImpl updateRequestImpl, String str) {
            this.a = iDataResolver;
            this.b = updateRequestImpl;
            this.c = str;
        }

        @Override // com.samsung.android.sdk.internal.interfaces.ParcelFdSupplier
        public ParcelFileDescriptor get(String str, String str2) throws RemoteException {
            return this.a.requestBlobTransferChannel(HealthDataStore.getClientPackageName(), this.b.getDataType(), str, this.c, str2);
        }
    }

    private static class d implements Iterator<HealthData> {
        private final IDataResolver a;
        private final String b;
        private final Cursor c;
        private final Object d;

        d(IDataResolver iDataResolver, String str, Cursor cursor, Object obj) {
            this.a = iDataResolver;
            this.b = str;
            this.c = cursor;
            this.d = obj;
            cursor.moveToPosition(-1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c.isClosed()) {
                throw new IllegalStateException("calling hasNext() when ReadResult or ResultCursor is closed");
            }
            return this.c.getCount() > 0 && !this.c.isLast();
        }

        @Override // java.util.Iterator
        public HealthData next() {
            if (this.c.isClosed()) {
                throw new IllegalStateException("calling next() when ReadResult or ResultCursor is closed");
            }
            if (!hasNext() || !this.c.moveToNext()) {
                throw new NoSuchElementException("calling next() when no next element present");
            }
            HealthData healthData = new HealthData(this.a, this.b, this.d);
            for (int i = 0; i < this.c.getColumnCount(); i++) {
                int type = this.c.getType(i);
                if (type == 1) {
                    healthData.putLong(this.c.getColumnName(i), this.c.getLong(i));
                } else if (type == 2) {
                    healthData.putDouble(this.c.getColumnName(i), this.c.getDouble(i));
                } else if (type == 3) {
                    healthData.putString(this.c.getColumnName(i), this.c.getString(i));
                } else if (type == 4) {
                    healthData.putBlob(this.c.getColumnName(i), this.c.getBlob(i));
                }
            }
            return healthData;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove() not supported");
        }
    }

    public HealthDataResolver(HealthDataStore healthDataStore, Handler handler) {
        this.a = healthDataStore;
        this.b = handler;
    }

    private IDataResolver a() {
        try {
            IDataResolver iDataResolver = HealthDataStore.getInterface(this.a).getIDataResolver();
            if (iDataResolver != null) {
                return iDataResolver;
            }
            throw new IllegalStateException("IDataResolver is null");
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    private Looper b() {
        Handler handler = this.b;
        Looper looper = handler != null ? handler.getLooper() : Looper.myLooper();
        if (looper != null) {
            return looper;
        }
        throw new IllegalStateException("This thread has no looper");
    }

    public HealthResultHolder<AggregateResult> aggregate(AggregateRequest aggregateRequest) {
        if (!(aggregateRequest instanceof AggregateRequestImpl)) {
            throw new IllegalArgumentException("Invalid aggregate request");
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        AggregateRequestImpl aggregateRequestImpl = (AggregateRequestImpl) aggregateRequest;
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<AggregateResult> healthResultHolderMakeResultHolder = IpcUtil.makeResultHolder(forwardAsync, looperB);
            iDataResolverA.aggregateData2(this.a.a().getPackageName(), forwardAsync, aggregateRequestImpl);
            return healthResultHolderMakeResultHolder;
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthResultHolder<HealthResultHolder.BaseResult> delete(DeleteRequest deleteRequest) {
        if (!(deleteRequest instanceof DeleteRequestImpl)) {
            throw new IllegalArgumentException("Invalid request instance");
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        DeleteRequestImpl deleteRequestImpl = (DeleteRequestImpl) deleteRequest;
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<HealthResultHolder.BaseResult> healthResultHolderMakeResultHolder = IpcUtil.makeResultHolder(forwardAsync, looperB);
            iDataResolverA.deleteData2(this.a.a().getPackageName(), forwardAsync, deleteRequestImpl);
            return healthResultHolderMakeResultHolder;
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthResultHolder<HealthResultHolder.BaseResult> deleteWithPermission(DeleteRequest deleteRequest, Activity activity) {
        if (!(deleteRequest instanceof DeleteRequestImpl)) {
            throw new IllegalArgumentException("Invalid request instance");
        }
        if (activity == null) {
            throw new IllegalArgumentException("Invalid activity instance");
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        DeleteRequestImpl deleteRequestImpl = (DeleteRequestImpl) deleteRequest;
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<HealthResultHolder.BaseResult> healthResultHolderMakeResultHolder = IpcUtil.makeResultHolder(forwardAsync, looperB);
            activity.startActivity(iDataResolverA.deleteDataWithPermission(this.a.a().getPackageName(), forwardAsync, deleteRequestImpl));
            return healthResultHolderMakeResultHolder;
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthResultHolder<HealthResultHolder.BaseResult> insert(InsertRequest insertRequest) throws IOException {
        if (!(insertRequest instanceof InsertRequestImpl)) {
            throw new IllegalArgumentException("Invalid request instance");
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        InsertRequestImpl insertRequestImpl = (InsertRequestImpl) insertRequest;
        if (insertRequestImpl.isEmpty()) {
            return IpcUtil.createAndSetResult(new HealthResultHolder.BaseResult(1, 0), looperB);
        }
        try {
            String string = UUID.randomUUID().toString();
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync(string);
            HealthResultHolder<HealthResultHolder.BaseResult> healthResultHolderMakeResultHolder = IpcUtil.makeResultHolder(forwardAsync, looperB);
            iDataResolverA.insertData2(this.a.a().getPackageName(), forwardAsync, insertRequestImpl);
            StreamUtil.sendStreamIfPresent(new a(this, iDataResolverA, insertRequestImpl, string), insertRequestImpl.getItems(), new Handler(looperB));
            return healthResultHolderMakeResultHolder;
        } catch (TransactionTooLargeException e) {
            throw new IllegalArgumentException(e.toString());
        } catch (RemoteException e2) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e2));
        }
    }

    public HealthResultHolder<HealthResultHolder.BaseResult> insertWithPermission(InsertRequest insertRequest, Activity activity) throws IOException {
        if (!(insertRequest instanceof InsertRequestImpl)) {
            throw new IllegalArgumentException("Invalid request instance");
        }
        if (activity == null) {
            throw new IllegalArgumentException("Invalid activity instance");
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        InsertRequestImpl insertRequestImpl = (InsertRequestImpl) insertRequest;
        if (insertRequestImpl.isEmpty()) {
            return IpcUtil.createAndSetResult(new HealthResultHolder.BaseResult(1, 0), looperB);
        }
        try {
            String string = UUID.randomUUID().toString();
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync(string);
            HealthResultHolder<HealthResultHolder.BaseResult> healthResultHolderMakeResultHolder = IpcUtil.makeResultHolder(forwardAsync, looperB);
            activity.startActivity(iDataResolverA.insertDataWithPermission(this.a.a().getPackageName(), forwardAsync, insertRequestImpl));
            StreamUtil.sendStreamIfPresent(new b(this, iDataResolverA, insertRequestImpl, string), insertRequestImpl.getItems(), new Handler(looperB));
            return healthResultHolderMakeResultHolder;
        } catch (TransactionTooLargeException e) {
            throw new IllegalArgumentException(e.toString());
        } catch (RemoteException e2) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e2));
        }
    }

    public HealthResultHolder<ReadResult> read(ReadRequest readRequest) {
        if (!(readRequest instanceof ReadRequestImpl)) {
            throw new IllegalArgumentException("Invalid request instance");
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        ReadRequestImpl readRequestImpl = (ReadRequestImpl) readRequest;
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<ReadResult> healthResultHolderMakeReadResultHolder = IpcUtil.makeReadResultHolder(forwardAsync, looperB, iDataResolverA);
            iDataResolverA.readData2(this.a.a().getPackageName(), forwardAsync, readRequestImpl);
            return healthResultHolderMakeReadResultHolder;
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthResultHolder<ReadResult> readWithPermission(ReadRequest readRequest, Activity activity) {
        if (!(readRequest instanceof ReadRequestImpl)) {
            throw new IllegalArgumentException("Invalid request instance");
        }
        if (activity == null) {
            throw new IllegalArgumentException("Invalid activity instance");
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        ReadRequestImpl readRequestImpl = (ReadRequestImpl) readRequest;
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<ReadResult> healthResultHolderMakeReadResultHolder = IpcUtil.makeReadResultHolder(forwardAsync, looperB, iDataResolverA);
            activity.startActivity(iDataResolverA.readDataWithPermission(this.a.a().getPackageName(), forwardAsync, readRequestImpl));
            return healthResultHolderMakeReadResultHolder;
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthResultHolder<HealthResultHolder.BaseResult> update(UpdateRequest updateRequest) throws IOException {
        if (!(updateRequest instanceof UpdateRequestImpl)) {
            throw new IllegalArgumentException("Invalid request instance");
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        UpdateRequestImpl updateRequestImpl = (UpdateRequestImpl) updateRequest;
        try {
            String string = UUID.randomUUID().toString();
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync(string);
            HealthResultHolder<HealthResultHolder.BaseResult> healthResultHolderMakeResultHolder = IpcUtil.makeResultHolder(forwardAsync, looperB);
            iDataResolverA.updateData2(this.a.a().getPackageName(), forwardAsync, updateRequestImpl);
            StreamUtil.sendStreamIfPresent(new c(this, iDataResolverA, updateRequestImpl, string), Collections.singletonList(updateRequestImpl.getDataObject()), new Handler(looperB));
            return healthResultHolderMakeResultHolder;
        } catch (TransactionTooLargeException e) {
            throw new IllegalArgumentException(e.toString());
        } catch (RemoteException e2) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e2));
        }
    }

    public interface AggregateRequest {

        /* JADX WARN: Enum visitor error
        jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SUM' uses external variables
        	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
        	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
         */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        public static abstract class AggregateFunction {
            public static final AggregateFunction AVG;
            public static final AggregateFunction COUNT;
            public static final AggregateFunction MAX;
            public static final AggregateFunction MIN;
            public static final AggregateFunction SUM;
            private static final /* synthetic */ AggregateFunction[] b;
            private final int a;

            static {
                int i = 0;
                AggregateFunction aggregateFunction = new AggregateFunction("SUM", i, i) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.1
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                    public String toSqlLiteral() {
                        return "SUM";
                    }
                };
                SUM = aggregateFunction;
                int i2 = 1;
                AggregateFunction aggregateFunction2 = new AggregateFunction("MIN", i2, i2) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.2
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                    public String toSqlLiteral() {
                        return "MIN";
                    }
                };
                MIN = aggregateFunction2;
                int i3 = 2;
                AggregateFunction aggregateFunction3 = new AggregateFunction("MAX", i3, i3) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.3
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                    public String toSqlLiteral() {
                        return "MAX";
                    }
                };
                MAX = aggregateFunction3;
                int i4 = 3;
                AggregateFunction aggregateFunction4 = new AggregateFunction("AVG", i4, i4) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.4
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                    public String toSqlLiteral() {
                        return "AVG";
                    }
                };
                AVG = aggregateFunction4;
                int i5 = 4;
                AggregateFunction aggregateFunction5 = new AggregateFunction("COUNT", i5, i5) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.5
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                    public String toSqlLiteral() {
                        return "COUNT";
                    }
                };
                COUNT = aggregateFunction5;
                b = new AggregateFunction[]{aggregateFunction, aggregateFunction2, aggregateFunction3, aggregateFunction4, aggregateFunction5};
            }

            /* synthetic */ AggregateFunction(String str, int i, int i2, a aVar) {
                this(str, i, i2);
            }

            public static AggregateFunction from(int i) {
                if (i < 0 || i > 4) {
                    throw new IllegalArgumentException("Invalid range : " + i);
                }
                return values()[i];
            }

            public static AggregateFunction valueOf(String str) {
                return (AggregateFunction) Enum.valueOf(AggregateFunction.class, str);
            }

            public static AggregateFunction[] values() {
                return (AggregateFunction[]) b.clone();
            }

            public int getValue() {
                return this.a;
            }

            public abstract String toSqlLiteral();

            private AggregateFunction(String str, int i, int i2) {
                this.a = i2;
            }
        }

        /* JADX WARN: Enum visitor error
        jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'MINUTELY' uses external variables
        	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
        	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
         */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        public static abstract class TimeGroupUnit {
            public static final TimeGroupUnit DAILY;
            public static final TimeGroupUnit HOURLY;
            public static final TimeGroupUnit MINUTELY;
            public static final TimeGroupUnit MONTHLY;
            public static final TimeGroupUnit WEEKLY;
            private static final /* synthetic */ TimeGroupUnit[] b;
            private final int a;

            static {
                int i = 0;
                TimeGroupUnit timeGroupUnit = new TimeGroupUnit("MINUTELY", i, i) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.1
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                    public String toSqlLiteral(String str, String str2, int i2) {
                        int i3 = i2 * 60;
                        return "strftime('%Y-%m-%d %H:%M', (strftime('%s', " + str + "/1000" + (str2 != null ? Marker.ANY_NON_NULL_MARKER + str2 + "/1000, 'unixepoch'" : ", 'unixepoch', 'localtime'") + ")/(" + i3 + "))*(" + i3 + "), 'unixepoch')";
                    }
                };
                MINUTELY = timeGroupUnit;
                int i2 = 1;
                TimeGroupUnit timeGroupUnit2 = new TimeGroupUnit("HOURLY", i2, i2) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.2
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                    public String toSqlLiteral(String str, String str2, int i3) {
                        StringBuilder sbAppend = new StringBuilder("strftime('%Y-%m-%d %H', (strftime('%s', ").append(str).append("/1000").append(str2 != null ? Marker.ANY_NON_NULL_MARKER + str2 + "/1000, 'unixepoch'" : ", 'unixepoch', 'localtime'").append(")/(");
                        int i4 = i3 * CacheConstants.HOUR;
                        return sbAppend.append(i4).append("))*(").append(i4).append("), 'unixepoch')").toString();
                    }
                };
                HOURLY = timeGroupUnit2;
                int i3 = 2;
                TimeGroupUnit timeGroupUnit3 = new TimeGroupUnit("DAILY", i3, i3) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.3
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                    public String toSqlLiteral(String str, String str2, int i4) {
                        return "strftime('%Y-%m-%d', strftime('%s', " + str + "/1000" + (str2 != null ? Marker.ANY_NON_NULL_MARKER + str2 + "/1000, 'unixepoch'" : ", 'unixepoch', 'localtime'") + "), 'unixepoch')";
                    }
                };
                DAILY = timeGroupUnit3;
                int i4 = 3;
                TimeGroupUnit timeGroupUnit4 = new TimeGroupUnit("WEEKLY", i4, i4) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.4
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                    public String toSqlLiteral(String str, String str2, int i5) {
                        return "strftime('%Y-%W', strftime('%s', " + str + "/1000" + (str2 != null ? Marker.ANY_NON_NULL_MARKER + str2 + "/1000, 'unixepoch'" : ", 'unixepoch', 'localtime'") + "), 'unixepoch')";
                    }
                };
                WEEKLY = timeGroupUnit4;
                int i5 = 4;
                TimeGroupUnit timeGroupUnit5 = new TimeGroupUnit("MONTHLY", i5, i5) { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.5
                    {
                        a aVar = null;
                    }

                    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                    public String toSqlLiteral(String str, String str2, int i6) {
                        String str3 = str2 != null ? Marker.ANY_NON_NULL_MARKER + str2 + "/1000, 'unixepoch'" : ", 'unixepoch', 'localtime'";
                        return i6 != 3 ? i6 != 6 ? "strftime('%Y-%m', datetime(strftime('%s', " + str + "/1000" + str3 + "), 'unixepoch'))" : "strftime('%Y', strftime('%s', " + str + "/1000" + str3 + "), 'unixepoch') || '-' || CASE  WHEN strftime('%m', strftime('%s', " + str + "/1000" + str3 + "), 'unixepoch') <= '06' THEN '01' ELSE '07' END" : "strftime('%Y', strftime('%s', " + str + "/1000" + str3 + "), 'unixepoch') || '-' || CASE strftime('%m', strftime('%s', " + str + "/1000" + str3 + "), 'unixepoch') WHEN '01' THEN '01' WHEN '02' THEN '01' WHEN '03' THEN '01' WHEN '04' THEN '04' WHEN '05' THEN '04' WHEN '06' THEN '04'  WHEN '07' THEN '07' WHEN  '08' THEN '07' WHEN '09' THEN '07'  WHEN '10' THEN '10' WHEN '11' THEN '10' WHEN '12' THEN '10' END";
                    }
                };
                MONTHLY = timeGroupUnit5;
                b = new TimeGroupUnit[]{timeGroupUnit, timeGroupUnit2, timeGroupUnit3, timeGroupUnit4, timeGroupUnit5};
            }

            /* synthetic */ TimeGroupUnit(String str, int i, int i2, a aVar) {
                this(str, i, i2);
            }

            public static TimeGroupUnit from(int i) {
                if (i < 0 || i > MONTHLY.getValue()) {
                    throw new IllegalArgumentException("Invalid range : " + i);
                }
                return values()[i];
            }

            public static TimeGroupUnit valueOf(String str) {
                return (TimeGroupUnit) Enum.valueOf(TimeGroupUnit.class, str);
            }

            public static TimeGroupUnit[] values() {
                return (TimeGroupUnit[]) b.clone();
            }

            public int getValue() {
                return this.a;
            }

            public abstract String toSqlLiteral(String str, String str2, int i);

            private TimeGroupUnit(String str, int i, int i2) {
                this.a = i2;
            }
        }

        public static class Builder {
            private AggregateRequestImpl.TimeGroup e;
            private String g;
            private String h;
            private Filter i;
            private List<String> j;
            private String k;
            private SortOrder l;
            private String p;
            private String q;
            private long r;
            private long s;
            private final List<AggregateRequestImpl.AggregatePair> a = new ArrayList();
            private String b = null;
            private final List<AggregateRequestImpl.Group> c = new ArrayList();
            private String d = null;
            private String f = null;
            private long m = -1;
            private long n = -1;
            private boolean o = false;

            public Builder addFunction(AggregateFunction aggregateFunction, String str, String str2) {
                try {
                    this.a.add(new AggregateRequestImpl.AggregatePair(aggregateFunction, str, str2));
                } catch (IllegalArgumentException e) {
                    this.b = e.getMessage();
                }
                return this;
            }

            public Builder addGroup(String str, String str2) {
                try {
                    this.c.add(new AggregateRequestImpl.Group(str, str2));
                } catch (IllegalArgumentException e) {
                    this.d = e.getMessage();
                }
                return this;
            }

            public AggregateRequest build() {
                String str = this.g;
                if (str == null || "".equals(str)) {
                    throw new IllegalStateException("No data type or invalid data type is specified");
                }
                if (this.o && (this.p == null || this.q == null || this.r >= this.s)) {
                    throw new IllegalStateException("Illegal local time range is specified");
                }
                if (this.a.size() <= 0) {
                    throw new IllegalStateException("No aggregate function is included");
                }
                if (this.b != null) {
                    throw new IllegalStateException(this.b);
                }
                if (this.f != null) {
                    throw new IllegalStateException(this.f);
                }
                if (this.d != null) {
                    throw new IllegalStateException(this.d);
                }
                List<String> list = this.j;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == null) {
                            throw new IllegalStateException("Null device uuid");
                        }
                    }
                }
                String str2 = this.k;
                if (str2 == null) {
                    str2 = null;
                } else if (this.l != null) {
                    str2 = this.k + " " + this.l.toSqlLiteral();
                }
                return new AggregateRequestImpl(this.g, this.h, this.a, this.c, this.e, this.i, this.j, str2, this.m, this.n, this.p, this.q, Long.valueOf(this.r), Long.valueOf(this.s));
            }

            public Builder setDataType(String str) {
                this.g = str;
                return this;
            }

            public Builder setFilter(Filter filter) {
                this.i = filter;
                return this;
            }

            public Builder setLocalTimeRange(String str, String str2, long j, long j2) {
                this.o = true;
                this.p = str;
                this.q = str2;
                this.r = j;
                this.s = j2;
                return this;
            }

            public Builder setPackageName(String str) {
                this.h = str;
                return this;
            }

            public Builder setSort(String str, SortOrder sortOrder) {
                this.k = str;
                this.l = sortOrder;
                return this;
            }

            public Builder setSourceDevices(List<String> list) {
                this.j = list;
                return this;
            }

            public Builder setTimeGroup(TimeGroupUnit timeGroupUnit, int i, String str, String str2) {
                try {
                    this.e = new AggregateRequestImpl.TimeGroup(timeGroupUnit, i, str, null, str2);
                } catch (IllegalArgumentException e) {
                    this.f = e.getMessage();
                }
                return this;
            }

            public Builder setTimeGroup(TimeGroupUnit timeGroupUnit, int i, String str, String str2, String str3) {
                try {
                    this.e = new AggregateRequestImpl.TimeGroup(timeGroupUnit, i, str, str2, str3);
                } catch (IllegalArgumentException e) {
                    this.f = e.getMessage();
                }
                return this;
            }
        }
    }

    public static abstract class Filter implements Parcelable {
        public static final Parcelable.Creator<Filter> CREATOR = new a();
        protected List<Filter> mFilters = new ArrayList();
        protected ParcelType mType;

        protected enum ParcelType implements Parcelable {
            COMPARABLE { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public Filter a(Parcel parcel) {
                    return new ComparisonFilter(parcel);
                }
            },
            STRING { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.2
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public Filter a(Parcel parcel) {
                    return new StringFilter(parcel);
                }
            },
            STRING_ARRAY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.3
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public Filter a(Parcel parcel) {
                    return new StringArrayFilter(parcel);
                }
            },
            NUMBER_ARRAY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.4
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public Filter a(Parcel parcel) {
                    return new NumberArrayFilter(parcel);
                }
            },
            AND { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.5
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public Filter a(Parcel parcel) {
                    return new AndFilter(parcel);
                }
            },
            OR { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.6
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public Filter a(Parcel parcel) {
                    return new OrFilter(parcel);
                }
            },
            NOT { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.7
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public Filter a(Parcel parcel) {
                    return new NotFilter(parcel);
                }
            };

            public static final Parcelable.Creator<ParcelType> CREATOR = new a();

            static class a implements Parcelable.Creator<ParcelType> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                public ParcelType createFromParcel(Parcel parcel) {
                    return ParcelType.values()[parcel.readInt()];
                }

                @Override // android.os.Parcelable.Creator
                public ParcelType[] newArray(int i) {
                    return new ParcelType[i];
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public abstract Filter a(Parcel parcel);

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(ordinal());
            }

            /* synthetic */ ParcelType(a aVar) {
                this();
            }
        }

        static class a implements Parcelable.Creator<Filter> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public Filter createFromParcel(Parcel parcel) {
                int iDataPosition = parcel.dataPosition();
                ParcelType parcelType = (ParcelType) parcel.readParcelable(ParcelType.class.getClassLoader());
                parcel.setDataPosition(iDataPosition);
                return parcelType.a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Filter[] newArray(int i) {
                return new Filter[i];
            }
        }

        protected Filter() {
        }

        public static Filter and(Filter filter, Filter... filterArr) {
            if (filter == null || filterArr == null) {
                throw new IllegalArgumentException("Filter arguments for and method should not be null");
            }
            return new AndFilter(filter, filterArr);
        }

        protected static void checkFilter(Filter filter) {
            if (filter == null) {
                throw new IllegalArgumentException("Invalid filter instance");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> Filter eq(String str, T t) {
            if (str == null) {
                throw new IllegalArgumentException("Invalid property or value");
            }
            if (t == 0) {
                return new ComparisonFilter(ComparisonFilter.Operator.EQ, str, null);
            }
            if (t instanceof Number) {
                return new ComparisonFilter(ComparisonFilter.Operator.EQ, str, (Number) t);
            }
            if (t instanceof String) {
                return new StringFilter(str, (String) t);
            }
            throw new IllegalArgumentException("Invalid type of value");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Comparable<T>> Filter greaterThan(String str, T t) {
            if (str == null || !(t instanceof Number)) {
                throw new IllegalArgumentException("Invalid property or value");
            }
            return new ComparisonFilter(ComparisonFilter.Operator.GREATER_THAN, str, (Number) t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Comparable<T>> Filter greaterThanEquals(String str, T t) {
            if (str == null || !(t instanceof Number)) {
                throw new IllegalArgumentException("Invalid property or value");
            }
            return new ComparisonFilter(ComparisonFilter.Operator.GREATER_THAN_EQUALS, str, (Number) t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> Filter in(String str, T[] tArr) {
            if (TextUtils.isEmpty(str) || tArr == 0 || tArr.length == 0) {
                throw new IllegalArgumentException("Invalid property or values");
            }
            if (tArr instanceof Number[]) {
                return new NumberArrayFilter(str, (Number[]) tArr);
            }
            if (tArr instanceof String[]) {
                return new StringArrayFilter(str, (String[]) tArr);
            }
            throw new IllegalArgumentException("Invalid type of value");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Comparable<T>> Filter lessThan(String str, T t) {
            if (str == null || !(t instanceof Number)) {
                throw new IllegalArgumentException("Invalid property or value");
            }
            return new ComparisonFilter(ComparisonFilter.Operator.LESS_THAN, str, (Number) t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Comparable<T>> Filter lessThanEquals(String str, T t) {
            if (str == null || !(t instanceof Number)) {
                throw new IllegalArgumentException("Invalid property or value");
            }
            return new ComparisonFilter(ComparisonFilter.Operator.LESS_THAN_EQUALS, str, (Number) t);
        }

        public static Filter not(Filter filter) {
            return new NotFilter(filter);
        }

        public static Filter or(Filter filter, Filter... filterArr) {
            if (filter == null || filterArr == null) {
                throw new IllegalArgumentException("Filter arguments for or method should not be null");
            }
            return new OrFilter(filter, filterArr);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public List<Filter> getFilters() {
            return this.mFilters;
        }

        protected void readFromParcel(Parcel parcel) {
            this.mType = (ParcelType) parcel.readParcelable(ParcelType.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mType, 0);
        }

        protected Filter(Parcel parcel) {
            readFromParcel(parcel);
        }
    }
}
