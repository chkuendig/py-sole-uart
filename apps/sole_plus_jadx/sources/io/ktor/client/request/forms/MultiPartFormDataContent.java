package io.ktor.client.request.forms;

import io.ktor.client.request.forms.PreparedPart;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: FormDataContent.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lio/ktor/client/request/forms/MultiPartFormDataContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "parts", "", "Lio/ktor/http/content/PartData;", "boundary", "", "contentType", "Lio/ktor/http/ContentType;", "(Ljava/util/List;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "BODY_OVERHEAD_SIZE", "", "BOUNDARY_BYTES", "", "LAST_BOUNDARY_BYTES", "PART_OVERHEAD_SIZE", "getBoundary", "()Ljava/lang/String;", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContentType", "()Lio/ktor/http/ContentType;", "rawParts", "Lio/ktor/client/request/forms/PreparedPart;", "writeTo", "", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {
    private final int BODY_OVERHEAD_SIZE;
    private final byte[] BOUNDARY_BYTES;
    private final byte[] LAST_BOUNDARY_BYTES;
    private final int PART_OVERHEAD_SIZE;
    private final String boundary;
    private final Long contentLength;
    private final ContentType contentType;
    private final List<PreparedPart> rawParts;

    /* compiled from: FormDataContent.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.request.forms.MultiPartFormDataContent", f = "FormDataContent.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 6}, l = {115, 116, 117, 122, 126, 130, 133}, m = "writeTo", n = {"this", "channel", "part", "this", "channel", "part", "this", "channel", "part", "this", "channel", "$this$use$iv", "closed$iv", "this", "channel", "this", "channel", "channel"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "I$0", "L$0", "L$1", "L$0", "L$1", "L$0"})
    /* renamed from: io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiPartFormDataContent.this.writeTo(null, this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MultiPartFormDataContent(List list, String str, ContentType contentType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        str = (i & 2) != 0 ? FormDataContentKt.generateBoundary() : str;
        this(list, str, (i & 4) != 0 ? ContentType.MultiPart.INSTANCE.getFormData().withParameter("boundary", str) : contentType);
    }

    public final String getBoundary() {
        return this.boundary;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public MultiPartFormDataContent(List<? extends PartData> parts, String boundary, ContentType contentType) {
        byte[] bArrEncodeToByteArray;
        byte[] bArrEncodeToByteArray2;
        PreparedPart channelPart;
        Intrinsics.checkNotNullParameter(parts, "parts");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.boundary = boundary;
        this.contentType = contentType;
        String str = "--" + boundary + "\r\n";
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            bArrEncodeToByteArray = StringsKt.encodeToByteArray(str);
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
            bArrEncodeToByteArray = CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
        }
        this.BOUNDARY_BYTES = bArrEncodeToByteArray;
        String str2 = "--" + boundary + "--\r\n";
        Charset charset2 = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset2, Charsets.UTF_8)) {
            bArrEncodeToByteArray2 = StringsKt.encodeToByteArray(str2);
        } else {
            CharsetEncoder charsetEncoderNewEncoder2 = charset2.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder2, "charset.newEncoder()");
            bArrEncodeToByteArray2 = CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder2, str2, 0, str2.length());
        }
        this.LAST_BOUNDARY_BYTES = bArrEncodeToByteArray2;
        this.BODY_OVERHEAD_SIZE = bArrEncodeToByteArray2.length;
        this.PART_OVERHEAD_SIZE = (FormDataContentKt.RN_BYTES.length * 2) + bArrEncodeToByteArray.length;
        List<? extends PartData> list = parts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                PartData partData = (PartData) it.next();
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
                for (Map.Entry<String, List<String>> entry : partData.getHeaders().entries()) {
                    BytePacketBuilder bytePacketBuilder2 = bytePacketBuilder;
                    io.ktor.utils.io.core.StringsKt.writeText$default(bytePacketBuilder2, entry.getKey() + ": " + CollectionsKt.joinToString$default(entry.getValue(), "; ", null, null, 0, null, null, 62, null), 0, 0, (Charset) null, 14, (Object) null);
                    OutputKt.writeFully$default((Output) bytePacketBuilder2, FormDataContentKt.RN_BYTES, 0, 0, 6, (Object) null);
                }
                String str3 = partData.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                Long lValueOf = str3 != null ? Long.valueOf(Long.parseLong(str3)) : null;
                if (partData instanceof PartData.FileItem) {
                    channelPart = new PreparedPart.InputPart(io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null), ((PartData.FileItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + this.PART_OVERHEAD_SIZE + r5.length) : null);
                } else if (partData instanceof PartData.BinaryItem) {
                    channelPart = new PreparedPart.InputPart(io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null), ((PartData.BinaryItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + this.PART_OVERHEAD_SIZE + r5.length) : null);
                } else if (!(partData instanceof PartData.FormItem)) {
                    if (partData instanceof PartData.BinaryChannelItem) {
                        channelPart = new PreparedPart.ChannelPart(io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null), ((PartData.BinaryChannelItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + this.PART_OVERHEAD_SIZE + r5.length) : null);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    BytePacketBuilder bytePacketBuilder3 = new BytePacketBuilder(null, 1, null);
                    try {
                        io.ktor.utils.io.core.StringsKt.writeText$default(bytePacketBuilder3, ((PartData.FormItem) partData).getValue(), 0, 0, (Charset) null, 14, (Object) null);
                        final byte[] bytes$default = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder3.build(), 0, 1, null);
                        Function0<ByteReadPacket> function0 = new Function0<ByteReadPacket>() { // from class: io.ktor.client.request.forms.MultiPartFormDataContent$rawParts$1$provider$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final ByteReadPacket invoke() {
                                byte[] bArr = bytes$default;
                                BytePacketBuilder bytePacketBuilder4 = new BytePacketBuilder(null, 1, null);
                                try {
                                    OutputKt.writeFully$default((Output) bytePacketBuilder4, bArr, 0, 0, 6, (Object) null);
                                    return bytePacketBuilder4.build();
                                } catch (Throwable th) {
                                    bytePacketBuilder4.release();
                                    throw th;
                                }
                            }
                        };
                        if (lValueOf == null) {
                            BytePacketBuilder bytePacketBuilder4 = bytePacketBuilder;
                            io.ktor.utils.io.core.StringsKt.writeText$default(bytePacketBuilder4, HttpHeaders.INSTANCE.getContentLength() + ": " + bytes$default.length, 0, 0, (Charset) null, 14, (Object) null);
                            OutputKt.writeFully$default((Output) bytePacketBuilder4, FormDataContentKt.RN_BYTES, 0, 0, 6, (Object) null);
                        }
                        channelPart = new PreparedPart.InputPart(io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null), function0, Long.valueOf(bytes$default.length + this.PART_OVERHEAD_SIZE + r4.length));
                    } catch (Throwable th) {
                        bytePacketBuilder3.release();
                        throw th;
                    }
                }
                arrayList.add(channelPart);
            } else {
                ArrayList arrayList2 = arrayList;
                this.rawParts = arrayList2;
                Long lValueOf2 = 0L;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        l = lValueOf2;
                        break;
                    }
                    Long size = ((PreparedPart) it2.next()).getSize();
                    if (size == null) {
                        break;
                    } else {
                        lValueOf2 = lValueOf2 != null ? Long.valueOf(lValueOf2.longValue() + size.longValue()) : null;
                    }
                }
                this.contentLength = l != null ? Long.valueOf(l.longValue() + this.BODY_OVERHEAD_SIZE) : l;
                return;
            }
        }
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.contentLength;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0 A[Catch: all -> 0x01ae, TryCatch #6 {all -> 0x01ae, blocks: (B:13:0x0031, B:42:0x00ca, B:44:0x00d0, B:48:0x00ec, B:51:0x0102, B:79:0x017f, B:83:0x0198, B:41:0x00c3), top: B:101:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0117 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011f A[Catch: all -> 0x00bc, TRY_LEAVE, TryCatch #4 {all -> 0x00bc, blocks: (B:55:0x011b, B:57:0x011f, B:62:0x0145, B:71:0x0154, B:73:0x0158, B:70:0x0153, B:30:0x0089, B:33:0x009e, B:36:0x00b5, B:68:0x0151, B:67:0x014e, B:64:0x0149, B:58:0x012b, B:61:0x0143, B:25:0x0071), top: B:101:0x0022, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0154 A[Catch: all -> 0x00bc, TryCatch #4 {all -> 0x00bc, blocks: (B:55:0x011b, B:57:0x011f, B:62:0x0145, B:71:0x0154, B:73:0x0158, B:70:0x0153, B:30:0x0089, B:33:0x009e, B:36:0x00b5, B:68:0x0151, B:67:0x014e, B:64:0x0149, B:58:0x012b, B:61:0x0143, B:25:0x0071), top: B:101:0x0022, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0194 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0198 A[Catch: all -> 0x01ae, TRY_LEAVE, TryCatch #6 {all -> 0x01ae, blocks: (B:13:0x0031, B:42:0x00ca, B:44:0x00d0, B:48:0x00ec, B:51:0x0102, B:79:0x017f, B:83:0x0198, B:41:0x00c3), top: B:101:0x0022 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0195 -> B:18:0x0047). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeTo(io.ktor.utils.io.ByteWriteChannel r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.MultiPartFormDataContent.writeTo(io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
