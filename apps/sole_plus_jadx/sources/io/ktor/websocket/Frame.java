package io.ktor.websocket;

import io.ktor.util.NIOKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputPrimitivesKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.DisposableHandle;

/* compiled from: Frame.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \"2\u00020\u0001:\u0006 !\"#$%BG\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u0006\u0010\u001d\u001a\u00020\u0000J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017\u0082\u0001\u0005&'()*¨\u0006+"}, d2 = {"Lio/ktor/websocket/Frame;", "", "fin", "", "frameType", "Lio/ktor/websocket/FrameType;", "data", "", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "rsv1", "rsv2", "rsv3", "(ZLio/ktor/websocket/FrameType;[BLkotlinx/coroutines/DisposableHandle;ZZZ)V", "buffer", "Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", "getData", "()[B", "getDisposableHandle", "()Lkotlinx/coroutines/DisposableHandle;", "getFin", "()Z", "getFrameType", "()Lio/ktor/websocket/FrameType;", "getRsv1", "getRsv2", "getRsv3", "copy", "toString", "", "Binary", "Close", "Companion", "Ping", "Pong", "Text", "Lio/ktor/websocket/Frame$Binary;", "Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/Frame$Ping;", "Lio/ktor/websocket/Frame$Pong;", "Lio/ktor/websocket/Frame$Text;", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class Frame {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] Empty = new byte[0];
    private final ByteBuffer buffer;
    private final byte[] data;
    private final DisposableHandle disposableHandle;
    private final boolean fin;
    private final FrameType frameType;
    private final boolean rsv1;
    private final boolean rsv2;
    private final boolean rsv3;

    public /* synthetic */ Frame(boolean z, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, frameType, bArr, disposableHandle, z2, z3, z4);
    }

    private Frame(boolean z, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z2, boolean z3, boolean z4) {
        this.fin = z;
        this.frameType = frameType;
        this.data = bArr;
        this.disposableHandle = disposableHandle;
        this.rsv1 = z2;
        this.rsv2 = z3;
        this.rsv3 = z4;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(data)");
        this.buffer = byteBufferWrap;
    }

    public final boolean getFin() {
        return this.fin;
    }

    public final FrameType getFrameType() {
        return this.frameType;
    }

    public /* synthetic */ Frame(boolean z, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, frameType, bArr, (i & 8) != 0 ? NonDisposableHandle.INSTANCE : disposableHandle, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, null);
    }

    public final byte[] getData() {
        return this.data;
    }

    public final DisposableHandle getDisposableHandle() {
        return this.disposableHandle;
    }

    public final boolean getRsv1() {
        return this.rsv1;
    }

    public final boolean getRsv2() {
        return this.rsv2;
    }

    public final boolean getRsv3() {
        return this.rsv3;
    }

    public final ByteBuffer getBuffer() {
        return this.buffer;
    }

    /* compiled from: Frame.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/websocket/Frame$Binary;", "Lio/ktor/websocket/Frame;", "fin", "", "buffer", "Ljava/nio/ByteBuffer;", "(ZLjava/nio/ByteBuffer;)V", "data", "", "(Z[B)V", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(ZLio/ktor/utils/io/core/ByteReadPacket;)V", "rsv1", "rsv2", "rsv3", "(Z[BZZZ)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Binary extends Frame {
        public /* synthetic */ Binary(boolean z, byte[] bArr, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, bArr, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, byte[] data, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.BINARY, data, NonDisposableHandle.INSTANCE, z2, z3, z4, null);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, ByteBuffer buffer) {
            this(z, NIOKt.moveToByteArray(buffer));
            Intrinsics.checkNotNullParameter(buffer, "buffer");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, byte[] data) {
            this(z, data, false, false, false);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, ByteReadPacket packet) {
            this(z, StringsKt.readBytes$default(packet, 0, 1, null));
            Intrinsics.checkNotNullParameter(packet, "packet");
        }
    }

    /* compiled from: Frame.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/Frame$Text;", "Lio/ktor/websocket/Frame;", "fin", "", "data", "", "(Z[B)V", "text", "", "(Ljava/lang/String;)V", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(ZLio/ktor/utils/io/core/ByteReadPacket;)V", "buffer", "Ljava/nio/ByteBuffer;", "(ZLjava/nio/ByteBuffer;)V", "rsv1", "rsv2", "rsv3", "(Z[BZZZ)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Text extends Frame {
        public /* synthetic */ Text(boolean z, byte[] bArr, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, bArr, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(boolean z, byte[] data, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.TEXT, data, NonDisposableHandle.INSTANCE, z2, z3, z4, null);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(boolean z, byte[] data) {
            this(z, data, false, false, false);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(boolean z, ByteReadPacket packet) {
            this(z, StringsKt.readBytes$default(packet, 0, 1, null));
            Intrinsics.checkNotNullParameter(packet, "packet");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(boolean z, ByteBuffer buffer) {
            this(z, NIOKt.moveToByteArray(buffer));
            Intrinsics.checkNotNullParameter(buffer, "buffer");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Text(String text) {
            byte[] bArrEncodeToByteArray;
            Intrinsics.checkNotNullParameter(text, "text");
            Charset charset = Charsets.UTF_8;
            if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                bArrEncodeToByteArray = kotlin.text.StringsKt.encodeToByteArray(text);
            } else {
                CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
                bArrEncodeToByteArray = CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, text, 0, text.length());
            }
            this(true, bArrEncodeToByteArray);
        }
    }

    /* compiled from: Frame.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/Frame;", "reason", "Lio/ktor/websocket/CloseReason;", "(Lio/ktor/websocket/CloseReason;)V", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "()V", "buffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "data", "", "([B)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Close extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Close(byte[] data) {
            super(true, FrameType.CLOSE, data, NonDisposableHandle.INSTANCE, false, false, false, null);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Close(ByteReadPacket packet) {
            this(StringsKt.readBytes$default(packet, 0, 1, null));
            Intrinsics.checkNotNullParameter(packet, "packet");
        }

        public Close() {
            this(Frame.Empty);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Close(ByteBuffer buffer) {
            this(NIOKt.moveToByteArray(buffer));
            Intrinsics.checkNotNullParameter(buffer, "buffer");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Close(CloseReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
            try {
                OutputPrimitivesKt.writeShort(bytePacketBuilder, reason.getCode());
                StringsKt.writeText$default(bytePacketBuilder, reason.getMessage(), 0, 0, (Charset) null, 14, (Object) null);
                this(bytePacketBuilder.build());
            } catch (Throwable th) {
                bytePacketBuilder.release();
                throw th;
            }
        }
    }

    /* compiled from: Frame.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/websocket/Frame$Pong;", "Lio/ktor/websocket/Frame;", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "buffer", "Ljava/nio/ByteBuffer;", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "(Ljava/nio/ByteBuffer;Lkotlinx/coroutines/DisposableHandle;)V", "(Ljava/nio/ByteBuffer;)V", "data", "", "([BLkotlinx/coroutines/DisposableHandle;)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Pong extends Frame {
        public /* synthetic */ Pong(byte[] bArr, NonDisposableHandle nonDisposableHandle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, (i & 2) != 0 ? NonDisposableHandle.INSTANCE : nonDisposableHandle);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pong(byte[] data, DisposableHandle disposableHandle) {
            super(true, FrameType.PONG, data, disposableHandle, false, false, false, null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(disposableHandle, "disposableHandle");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Pong(ByteReadPacket packet) {
            this(StringsKt.readBytes$default(packet, 0, 1, null), NonDisposableHandle.INSTANCE);
            Intrinsics.checkNotNullParameter(packet, "packet");
        }

        public /* synthetic */ Pong(ByteBuffer byteBuffer, NonDisposableHandle nonDisposableHandle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(byteBuffer, (i & 2) != 0 ? NonDisposableHandle.INSTANCE : nonDisposableHandle);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Pong(ByteBuffer buffer, DisposableHandle disposableHandle) {
            this(NIOKt.moveToByteArray(buffer), disposableHandle);
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            Intrinsics.checkNotNullParameter(disposableHandle, "disposableHandle");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Pong(ByteBuffer buffer) {
            this(NIOKt.moveToByteArray(buffer), NonDisposableHandle.INSTANCE);
            Intrinsics.checkNotNullParameter(buffer, "buffer");
        }
    }

    /* compiled from: Frame.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/websocket/Frame$Ping;", "Lio/ktor/websocket/Frame;", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "buffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "data", "", "([B)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Ping extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ping(byte[] data) {
            super(true, FrameType.PING, data, NonDisposableHandle.INSTANCE, false, false, false, null);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Ping(ByteReadPacket packet) {
            this(StringsKt.readBytes$default(packet, 0, 1, null));
            Intrinsics.checkNotNullParameter(packet, "packet");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Ping(ByteBuffer buffer) {
            this(NIOKt.moveToByteArray(buffer));
            Intrinsics.checkNotNullParameter(buffer, "buffer");
        }
    }

    public String toString() {
        return "Frame " + this.frameType + " (fin=" + this.fin + ", buffer len = " + this.data.length + ')';
    }

    public final Frame copy() {
        Companion companion = INSTANCE;
        boolean z = this.fin;
        FrameType frameType = this.frameType;
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return companion.byType(z, frameType, bArrCopyOf, this.rsv1, this.rsv2, this.rsv3);
    }

    /* compiled from: Frame.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/Frame$Companion;", "", "()V", "Empty", "", "byType", "Lio/ktor/websocket/Frame;", "fin", "", "frameType", "Lio/ktor/websocket/FrameType;", "data", "rsv1", "rsv2", "rsv3", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: Frame.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FrameType.values().length];
                try {
                    iArr[FrameType.BINARY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FrameType.TEXT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FrameType.CLOSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FrameType.PING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[FrameType.PONG.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Frame byType(boolean fin, FrameType frameType, byte[] data, boolean rsv1, boolean rsv2, boolean rsv3) {
            Intrinsics.checkNotNullParameter(frameType, "frameType");
            Intrinsics.checkNotNullParameter(data, "data");
            int i = WhenMappings.$EnumSwitchMapping$0[frameType.ordinal()];
            if (i == 1) {
                return new Binary(fin, data, rsv1, rsv2, rsv3);
            }
            if (i == 2) {
                return new Text(fin, data, rsv1, rsv2, rsv3);
            }
            if (i == 3) {
                return new Close(data);
            }
            if (i == 4) {
                return new Ping(data);
            }
            if (i == 5) {
                return new Pong(data, NonDisposableHandle.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
