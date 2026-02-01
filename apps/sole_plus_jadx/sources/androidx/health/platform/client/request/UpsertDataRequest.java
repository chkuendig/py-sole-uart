package androidx.health.platform.client.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.InvalidProtocolBufferException;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.request.UpsertDataRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpsertDataRequest.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/health/platform/client/request/UpsertDataRequest;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$UpsertDataRequest;", "dataPoints", "", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "(Ljava/util/List;)V", "getDataPoints", "()Ljava/util/List;", "proto", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$UpsertDataRequest;", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpsertDataRequest extends ProtoParcelable<RequestProto.UpsertDataRequest> {
    public static final Parcelable.Creator<UpsertDataRequest> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<DataProto.DataPoint> dataPoints;

    public final List<DataProto.DataPoint> getDataPoints() {
        return this.dataPoints;
    }

    public UpsertDataRequest(List<DataProto.DataPoint> dataPoints) {
        Intrinsics.checkNotNullParameter(dataPoints, "dataPoints");
        this.dataPoints = dataPoints;
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.UpsertDataRequest getProto() {
        RequestProto.UpsertDataRequest upsertDataRequestBuild = RequestProto.UpsertDataRequest.newBuilder().addAllDataPoint(this.dataPoints).build();
        Intrinsics.checkNotNullExpressionValue(upsertDataRequestBuild, "newBuilder()\n           …\n                .build()");
        return upsertDataRequestBuild;
    }

    /* compiled from: UpsertDataRequest.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/health/platform/client/request/UpsertDataRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/health/platform/client/request/UpsertDataRequest;", "fromProto", "proto", "Landroidx/health/platform/client/proto/RequestProto$UpsertDataRequest;", "fromProto$connect_client_release", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpsertDataRequest fromProto$connect_client_release(RequestProto.UpsertDataRequest proto) {
            Intrinsics.checkNotNullParameter(proto, "proto");
            List<DataProto.DataPoint> dataPointList = proto.getDataPointList();
            Intrinsics.checkNotNullExpressionValue(dataPointList, "proto.dataPointList");
            return new UpsertDataRequest(dataPointList);
        }
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<UpsertDataRequest>() { // from class: androidx.health.platform.client.request.UpsertDataRequest$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r4v8, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.UpsertDataRequest] */
            @Override // android.os.Parcelable.Creator
            public UpsertDataRequest createFromParcel(Parcel source) throws InvalidProtocolBufferException {
                Intrinsics.checkNotNullParameter(source, "source");
                int i = source.readInt();
                if (i != 0) {
                    if (i == 1) {
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], UpsertDataRequest>() { // from class: androidx.health.platform.client.request.UpsertDataRequest$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final UpsertDataRequest invoke(byte[] it) throws InvalidProtocolBufferException {
                                Intrinsics.checkNotNullParameter(it, "it");
                                RequestProto.UpsertDataRequest proto = RequestProto.UpsertDataRequest.parseFrom(it);
                                UpsertDataRequest.Companion companion2 = UpsertDataRequest.INSTANCE;
                                Intrinsics.checkNotNullExpressionValue(proto, "proto");
                                return companion2.fromProto$connect_client_release(proto);
                            }
                        });
                    }
                    throw new IllegalArgumentException("Unknown storage: " + i);
                }
                byte[] bArrCreateByteArray = source.createByteArray();
                if (bArrCreateByteArray == null) {
                    return null;
                }
                RequestProto.UpsertDataRequest proto = RequestProto.UpsertDataRequest.parseFrom(bArrCreateByteArray);
                UpsertDataRequest.Companion companion2 = UpsertDataRequest.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(proto, "proto");
                return companion2.fromProto$connect_client_release(proto);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UpsertDataRequest[] newArray(int size) {
                return new UpsertDataRequest[size];
            }
        };
    }
}
