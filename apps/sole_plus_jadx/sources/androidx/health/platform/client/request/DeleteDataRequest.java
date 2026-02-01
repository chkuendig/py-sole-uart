package androidx.health.platform.client.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.InvalidProtocolBufferException;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.request.DeleteDataRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteDataRequest.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u000f"}, d2 = {"Landroidx/health/platform/client/request/DeleteDataRequest;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$DeleteDataRequest;", "uids", "", "Landroidx/health/platform/client/proto/RequestProto$DataTypeIdPair;", "clientIds", "(Ljava/util/List;Ljava/util/List;)V", "getClientIds", "()Ljava/util/List;", "proto", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$DeleteDataRequest;", "getUids", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeleteDataRequest extends ProtoParcelable<RequestProto.DeleteDataRequest> {
    public static final Parcelable.Creator<DeleteDataRequest> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<RequestProto.DataTypeIdPair> clientIds;
    private final List<RequestProto.DataTypeIdPair> uids;

    public final List<RequestProto.DataTypeIdPair> getUids() {
        return this.uids;
    }

    public final List<RequestProto.DataTypeIdPair> getClientIds() {
        return this.clientIds;
    }

    public DeleteDataRequest(List<RequestProto.DataTypeIdPair> uids, List<RequestProto.DataTypeIdPair> clientIds) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(clientIds, "clientIds");
        this.uids = uids;
        this.clientIds = clientIds;
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.DeleteDataRequest getProto() {
        RequestProto.DeleteDataRequest deleteDataRequestBuild = RequestProto.DeleteDataRequest.newBuilder().addAllUids(this.uids).addAllClientIds(this.clientIds).build();
        Intrinsics.checkNotNullExpressionValue(deleteDataRequestBuild, "newBuilder()\n           …\n                .build()");
        return deleteDataRequestBuild;
    }

    /* compiled from: DeleteDataRequest.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/health/platform/client/request/DeleteDataRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/health/platform/client/request/DeleteDataRequest;", "fromProto", "proto", "Landroidx/health/platform/client/proto/RequestProto$DeleteDataRequest;", "fromProto$connect_client_release", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteDataRequest fromProto$connect_client_release(RequestProto.DeleteDataRequest proto) {
            Intrinsics.checkNotNullParameter(proto, "proto");
            List<RequestProto.DataTypeIdPair> uidsList = proto.getUidsList();
            Intrinsics.checkNotNullExpressionValue(uidsList, "proto.uidsList");
            List<RequestProto.DataTypeIdPair> clientIdsList = proto.getClientIdsList();
            Intrinsics.checkNotNullExpressionValue(clientIdsList, "proto.clientIdsList");
            return new DeleteDataRequest(uidsList, clientIdsList);
        }
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<DeleteDataRequest>() { // from class: androidx.health.platform.client.request.DeleteDataRequest$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r4v8, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.DeleteDataRequest] */
            @Override // android.os.Parcelable.Creator
            public DeleteDataRequest createFromParcel(Parcel source) throws InvalidProtocolBufferException {
                Intrinsics.checkNotNullParameter(source, "source");
                int i = source.readInt();
                if (i != 0) {
                    if (i == 1) {
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], DeleteDataRequest>() { // from class: androidx.health.platform.client.request.DeleteDataRequest$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final DeleteDataRequest invoke(byte[] it) throws InvalidProtocolBufferException {
                                Intrinsics.checkNotNullParameter(it, "it");
                                RequestProto.DeleteDataRequest proto = RequestProto.DeleteDataRequest.parseFrom(it);
                                DeleteDataRequest.Companion companion2 = DeleteDataRequest.INSTANCE;
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
                RequestProto.DeleteDataRequest proto = RequestProto.DeleteDataRequest.parseFrom(bArrCreateByteArray);
                DeleteDataRequest.Companion companion2 = DeleteDataRequest.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(proto, "proto");
                return companion2.fromProto$connect_client_release(proto);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DeleteDataRequest[] newArray(int size) {
                return new DeleteDataRequest[size];
            }
        };
    }
}
