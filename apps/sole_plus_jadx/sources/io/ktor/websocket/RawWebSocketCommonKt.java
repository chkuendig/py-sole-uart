package io.ktor.websocket;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.sun.jna.platform.win32.WinError;
import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a%\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"mask", "Lio/ktor/utils/io/core/ByteReadPacket;", "maskKey", "", "readFrame", "Lio/ktor/websocket/Frame;", "Lio/ktor/utils/io/ByteReadChannel;", "maxFrameSize", "", "lastOpcode", "(Lio/ktor/utils/io/ByteReadChannel;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFrame", "", "Lio/ktor/utils/io/ByteWriteChannel;", TypedValues.AttributesType.S_FRAME, "masking", "", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/websocket/Frame;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RawWebSocketCommonKt {

    /* compiled from: RawWebSocketCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {211, WinError.ERROR_LOCKED, WinError.ERROR_PIPE_BUSY, WinError.ERROR_NO_DATA, 240, 248}, m = "readFrame", n = {"$this$readFrame", "maxFrameSize", "lastOpcode", "$this$readFrame", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", "maskAndLength", "fin", "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", "maskAndLength", "fin", "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", "fin", SessionDescription.ATTR_LENGTH, "frameType", "flagsAndOpcode", "fin", "maskKey"}, s = {"L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "B$0", "L$0", "L$1", "J$0", "B$0", "B$1", "I$0", "L$0", "L$1", "J$0", "B$0", "B$1", "I$0", "L$0", "L$1", "J$0", "B$0", "I$0", "J$1", "L$0", "B$0", "I$0", "I$1"})
    /* renamed from: io.ktor.websocket.RawWebSocketCommonKt$readFrame$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        byte B$0;
        byte B$1;
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommonKt.readFrame(null, 0L, 0, this);
        }
    }

    /* compiled from: RawWebSocketCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {173, 183, 186, 187, 195, 200}, m = "writeFrame", n = {"$this$writeFrame", TypedValues.AttributesType.S_FRAME, "masking", SessionDescription.ATTR_LENGTH, "$this$writeFrame", TypedValues.AttributesType.S_FRAME, "masking", SessionDescription.ATTR_LENGTH, "formattedLength", "$this$writeFrame", TypedValues.AttributesType.S_FRAME, "masking", "$this$writeFrame", TypedValues.AttributesType.S_FRAME, "masking", "$this$writeFrame", "data", "maskKey"}, s = {"L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "I$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1, reason: invalid class name and case insensitive filesystem */
    static final class C12811 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C12811(Continuation<? super C12811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommonKt.writeFrame(null, null, false, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @io.ktor.util.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeFrame(io.ktor.utils.io.ByteWriteChannel r10, io.ktor.websocket.Frame r11, boolean r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.writeFrame(io.ktor.utils.io.ByteWriteChannel, io.ktor.websocket.Frame, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0201  */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    @io.ktor.util.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFrame(io.ktor.utils.io.ByteReadChannel r23, long r24, int r26, kotlin.coroutines.Continuation<? super io.ktor.websocket.Frame> r27) throws io.ktor.websocket.FrameTooBigException, io.ktor.websocket.ProtocolViolationException {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.readFrame(io.ktor.utils.io.ByteReadChannel, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final ByteReadPacket mask(ByteReadPacket byteReadPacket, int i) {
        DefaultAllocator defaultAllocator = DefaultAllocator.INSTANCE;
        ByteBuffer byteBufferMo8806allocgFvZug = defaultAllocator.mo8806allocgFvZug(4);
        try {
            byteBufferMo8806allocgFvZug.putInt(0, i);
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
            try {
                int remaining = (int) byteReadPacket.getRemaining();
                for (int i2 = 0; i2 < remaining; i2++) {
                    bytePacketBuilder.writeByte((byte) (byteReadPacket.readByte() ^ byteBufferMo8806allocgFvZug.get(i2 % 4)));
                }
                return bytePacketBuilder.build();
            } finally {
            }
        } finally {
            defaultAllocator.mo8807free3GNKZMM(byteBufferMo8806allocgFvZug);
        }
    }
}
