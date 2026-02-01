package androidx.health.platform.client.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.InvalidProtocolBufferException;
import androidx.health.platform.client.proto.RequestProto;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterForDataNotificationsRequest.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/health/platform/client/request/RegisterForDataNotificationsRequest;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$RegisterForDataNotificationsRequest;", "proto", "(Landroidx/health/platform/client/proto/RequestProto$RegisterForDataNotificationsRequest;)V", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$RegisterForDataNotificationsRequest;", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RegisterForDataNotificationsRequest extends ProtoParcelable<RequestProto.RegisterForDataNotificationsRequest> {
    public static final Parcelable.Creator<RegisterForDataNotificationsRequest> CREATOR;
    private final RequestProto.RegisterForDataNotificationsRequest proto;

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.RegisterForDataNotificationsRequest getProto() {
        return this.proto;
    }

    public RegisterForDataNotificationsRequest(RequestProto.RegisterForDataNotificationsRequest proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        this.proto = proto;
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<RegisterForDataNotificationsRequest>() { // from class: androidx.health.platform.client.request.RegisterForDataNotificationsRequest$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r4v6, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.RegisterForDataNotificationsRequest] */
            @Override // android.os.Parcelable.Creator
            public RegisterForDataNotificationsRequest createFromParcel(Parcel source) throws InvalidProtocolBufferException {
                Intrinsics.checkNotNullParameter(source, "source");
                int i = source.readInt();
                if (i != 0) {
                    if (i == 1) {
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], RegisterForDataNotificationsRequest>() { // from class: androidx.health.platform.client.request.RegisterForDataNotificationsRequest$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final RegisterForDataNotificationsRequest invoke(byte[] it) throws InvalidProtocolBufferException {
                                Intrinsics.checkNotNullParameter(it, "it");
                                RequestProto.RegisterForDataNotificationsRequest from = RequestProto.RegisterForDataNotificationsRequest.parseFrom(it);
                                Intrinsics.checkNotNullExpressionValue(from, "parseFrom(it)");
                                return new RegisterForDataNotificationsRequest(from);
                            }
                        });
                    }
                    throw new IllegalArgumentException("Unknown storage: " + i);
                }
                byte[] bArrCreateByteArray = source.createByteArray();
                if (bArrCreateByteArray == null) {
                    return null;
                }
                RequestProto.RegisterForDataNotificationsRequest from = RequestProto.RegisterForDataNotificationsRequest.parseFrom(bArrCreateByteArray);
                Intrinsics.checkNotNullExpressionValue(from, "parseFrom(it)");
                return new RegisterForDataNotificationsRequest(from);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RegisterForDataNotificationsRequest[] newArray(int size) {
                return new RegisterForDataNotificationsRequest[size];
            }
        };
    }
}
