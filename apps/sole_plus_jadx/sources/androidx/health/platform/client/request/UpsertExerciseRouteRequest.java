package androidx.health.platform.client.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.InvalidProtocolBufferException;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.request.UpsertExerciseRouteRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpsertExerciseRouteRequest.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/health/platform/client/request/UpsertExerciseRouteRequest;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$UpsertExerciseRouteRequest;", "sessionUid", "", "route", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "(Ljava/lang/String;Landroidx/health/platform/client/proto/DataProto$DataPoint;)V", "proto", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$UpsertExerciseRouteRequest;", "getRoute", "()Landroidx/health/platform/client/proto/DataProto$DataPoint;", "getSessionUid", "()Ljava/lang/String;", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpsertExerciseRouteRequest extends ProtoParcelable<RequestProto.UpsertExerciseRouteRequest> {
    public static final Parcelable.Creator<UpsertExerciseRouteRequest> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DataProto.DataPoint route;
    private final String sessionUid;

    public final DataProto.DataPoint getRoute() {
        return this.route;
    }

    public final String getSessionUid() {
        return this.sessionUid;
    }

    public UpsertExerciseRouteRequest(String sessionUid, DataProto.DataPoint route) {
        Intrinsics.checkNotNullParameter(sessionUid, "sessionUid");
        Intrinsics.checkNotNullParameter(route, "route");
        this.sessionUid = sessionUid;
        this.route = route;
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.UpsertExerciseRouteRequest getProto() {
        RequestProto.UpsertExerciseRouteRequest upsertExerciseRouteRequestBuild = RequestProto.UpsertExerciseRouteRequest.newBuilder().setSessionUid(this.sessionUid).setExerciseRoute(this.route).build();
        Intrinsics.checkNotNullExpressionValue(upsertExerciseRouteRequestBuild, "newBuilder()\n           …\n                .build()");
        return upsertExerciseRouteRequestBuild;
    }

    /* compiled from: UpsertExerciseRouteRequest.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/health/platform/client/request/UpsertExerciseRouteRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/health/platform/client/request/UpsertExerciseRouteRequest;", "fromProto", "proto", "Landroidx/health/platform/client/proto/RequestProto$UpsertExerciseRouteRequest;", "fromProto$connect_client_release", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpsertExerciseRouteRequest fromProto$connect_client_release(RequestProto.UpsertExerciseRouteRequest proto) {
            Intrinsics.checkNotNullParameter(proto, "proto");
            String sessionUid = proto.getSessionUid();
            Intrinsics.checkNotNullExpressionValue(sessionUid, "proto.sessionUid");
            DataProto.DataPoint exerciseRoute = proto.getExerciseRoute();
            Intrinsics.checkNotNullExpressionValue(exerciseRoute, "proto.exerciseRoute");
            return new UpsertExerciseRouteRequest(sessionUid, exerciseRoute);
        }
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<UpsertExerciseRouteRequest>() { // from class: androidx.health.platform.client.request.UpsertExerciseRouteRequest$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r4v8, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.UpsertExerciseRouteRequest] */
            @Override // android.os.Parcelable.Creator
            public UpsertExerciseRouteRequest createFromParcel(Parcel source) throws InvalidProtocolBufferException {
                Intrinsics.checkNotNullParameter(source, "source");
                int i = source.readInt();
                if (i != 0) {
                    if (i == 1) {
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], UpsertExerciseRouteRequest>() { // from class: androidx.health.platform.client.request.UpsertExerciseRouteRequest$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final UpsertExerciseRouteRequest invoke(byte[] it) throws InvalidProtocolBufferException {
                                Intrinsics.checkNotNullParameter(it, "it");
                                RequestProto.UpsertExerciseRouteRequest proto = RequestProto.UpsertExerciseRouteRequest.parseFrom(it);
                                UpsertExerciseRouteRequest.Companion companion2 = UpsertExerciseRouteRequest.INSTANCE;
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
                RequestProto.UpsertExerciseRouteRequest proto = RequestProto.UpsertExerciseRouteRequest.parseFrom(bArrCreateByteArray);
                UpsertExerciseRouteRequest.Companion companion2 = UpsertExerciseRouteRequest.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(proto, "proto");
                return companion2.fromProto$connect_client_release(proto);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UpsertExerciseRouteRequest[] newArray(int size) {
                return new UpsertExerciseRouteRequest[size];
            }
        };
    }
}
