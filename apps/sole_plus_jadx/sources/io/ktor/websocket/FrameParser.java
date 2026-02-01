package io.ktor.websocket;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: FrameParser.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R$\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u001e\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010$0$0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lio/ktor/websocket/FrameParser;", "", "()V", "bodyReady", "", "getBodyReady", "()Z", "<set-?>", "fin", "getFin", "frameType", "Lio/ktor/websocket/FrameType;", "getFrameType", "()Lio/ktor/websocket/FrameType;", "lastOpcode", "", "", SessionDescription.ATTR_LENGTH, "getLength", "()J", "lengthLength", "mask", "getMask", "maskKey", "getMaskKey", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "opcode", "rsv1", "getRsv1", "rsv2", "getRsv2", "rsv3", "getRsv3", ServerProtocol.DIALOG_PARAM_STATE, "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/ktor/websocket/FrameParser$State;", "kotlin.jvm.PlatformType", "bodyComplete", "", TypedValues.AttributesType.S_FRAME, "bb", "Ljava/nio/ByteBuffer;", "handleStep", "parseHeader1", "parseLength", "parseMaskKey", SdkConstants.MotionSceneTags.STATE, "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrameParser {
    private boolean fin;
    private int lastOpcode;
    private long length;
    private int lengthLength;
    private boolean mask;
    private Integer maskKey;
    private int opcode;
    private boolean rsv1;
    private boolean rsv2;
    private boolean rsv3;
    private final AtomicReference<State> state = new AtomicReference<>(State.HEADER0);

    /* compiled from: FrameParser.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/websocket/FrameParser$State;", "", "(Ljava/lang/String;I)V", "HEADER0", "LENGTH", "MASK_KEY", "BODY", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum State {
        HEADER0,
        LENGTH,
        MASK_KEY,
        BODY
    }

    /* compiled from: FrameParser.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.HEADER0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.MASK_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[State.BODY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean getFin() {
        return this.fin;
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

    public final boolean getMask() {
        return this.mask;
    }

    public final long getLength() {
        return this.length;
    }

    public final Integer getMaskKey() {
        return this.maskKey;
    }

    public final FrameType getFrameType() {
        FrameType frameType = FrameType.INSTANCE.get(this.opcode);
        if (frameType != null) {
            return frameType;
        }
        throw new IllegalStateException("Unsupported opcode " + Integer.toHexString(this.opcode));
    }

    public final boolean getBodyReady() {
        return this.state.get() == State.BODY;
    }

    public final void bodyComplete() {
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.state, State.BODY, State.HEADER0)) {
            throw new IllegalStateException("It should be state BODY but it is " + this.state.get());
        }
        this.opcode = 0;
        this.length = 0L;
        this.lengthLength = 0;
        this.maskKey = null;
    }

    public final void frame(ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        if (!Intrinsics.areEqual(bb.order(), ByteOrder.BIG_ENDIAN)) {
            throw new IllegalArgumentException(("Buffer order should be BIG_ENDIAN but it is " + bb.order()).toString());
        }
        while (handleStep(bb)) {
        }
    }

    private final boolean handleStep(ByteBuffer bb) {
        State state = this.state.get();
        Intrinsics.checkNotNull(state);
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return parseHeader1(bb);
        }
        if (i == 2) {
            return parseLength(bb);
        }
        if (i == 3) {
            return parseMaskKey(bb);
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean parseHeader1(ByteBuffer bb) throws ProtocolViolationException {
        int i = 0;
        if (bb.remaining() < 2) {
            return false;
        }
        byte b = bb.get();
        byte b2 = bb.get();
        this.fin = (b & 128) != 0;
        this.rsv1 = (b & SignedBytes.MAX_POWER_OF_TWO) != 0;
        this.rsv2 = (b & 32) != 0;
        this.rsv3 = (b & 16) != 0;
        int i2 = b & 15;
        this.opcode = i2;
        if (i2 == 0 && this.lastOpcode == 0) {
            throw new ProtocolViolationException("Can't continue finished frames");
        }
        if (i2 == 0) {
            this.opcode = this.lastOpcode;
        } else if (this.lastOpcode != 0 && !getFrameType().getControlFrame()) {
            throw new ProtocolViolationException("Can't start new data frame before finishing previous one");
        }
        if (!getFrameType().getControlFrame()) {
            this.lastOpcode = this.fin ? 0 : this.opcode;
        } else if (!this.fin) {
            throw new ProtocolViolationException("control frames can't be fragmented");
        }
        this.mask = (b2 & 128) != 0;
        int i3 = b2 & 127;
        if (getFrameType().getControlFrame() && i3 > 125) {
            throw new ProtocolViolationException("control frames can't be larger than 125 bytes");
        }
        if (i3 == 126) {
            i = 2;
        } else if (i3 == 127) {
            i = 8;
        }
        this.lengthLength = i;
        this.length = i == 0 ? i3 : 0L;
        if (i > 0) {
            this.state.set(State.LENGTH);
        } else if (this.mask) {
            this.state.set(State.MASK_KEY);
        } else {
            this.state.set(State.BODY);
        }
        return true;
    }

    private final boolean parseLength(ByteBuffer bb) {
        long j;
        int iRemaining = bb.remaining();
        int i = this.lengthLength;
        if (iRemaining < i) {
            return false;
        }
        if (i == 2) {
            j = bb.getShort() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        } else if (i == 8) {
            j = bb.getLong();
        } else {
            throw new IllegalStateException();
        }
        this.length = j;
        this.state.set(this.mask ? State.MASK_KEY : State.BODY);
        return true;
    }

    private final boolean parseMaskKey(ByteBuffer bb) {
        if (bb.remaining() < 4) {
            return false;
        }
        this.maskKey = Integer.valueOf(bb.getInt());
        this.state.set(State.BODY);
        return true;
    }
}
