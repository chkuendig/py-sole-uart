package com.android.ddmlib.jdwp;

import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import com.android.ddmlib.jdwp.packets.CapabilitiesNewReply;
import com.android.ddmlib.jdwp.packets.IdSizesReply;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class JdwpProtocol {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private IdSizesReply mIdSizes;

    public long readObjectId(ByteBuffer buffer) {
        return readId(buffer, this.mIdSizes.objectIDSize);
    }

    public long readRefTypeId(ByteBuffer buffer) {
        return readId(buffer, this.mIdSizes.refTypeIDSize);
    }

    public long readMethodId(ByteBuffer buffer) {
        return readId(buffer, this.mIdSizes.methodIDSize);
    }

    public long readFieldId(ByteBuffer buffer) {
        return readId(buffer, this.mIdSizes.fieldIDSize);
    }

    private long readId(ByteBuffer buffer, int size) {
        int i;
        if (size == 1) {
            i = buffer.get();
        } else if (size == 2) {
            i = buffer.getShort();
        } else {
            if (size != 4) {
                if (size == 8) {
                    return buffer.getLong();
                }
                throw new IllegalArgumentException("Unsupported Id size: " + size);
            }
            i = buffer.getInt();
        }
        return i;
    }

    public String readString(ByteBuffer buffer) {
        byte[] bArr = new byte[buffer.getInt()];
        buffer.get(bArr);
        return new String(bArr, Charsets.UTF_8);
    }

    public void incoming(JdwpPacket packet, JdwpPipe pipe) {
        if (packet.is(1, 7)) {
            pipe.addReplyInterceptor(packet.getId(), new JdwpInterceptor() { // from class: com.android.ddmlib.jdwp.JdwpProtocol.1
                @Override // com.android.ddmlib.jdwp.JdwpInterceptor
                public JdwpPacket intercept(JdwpPipe pipe2, JdwpPacket packet2) {
                    JdwpProtocol.this.mIdSizes = new IdSizesReply();
                    JdwpProtocol.this.mIdSizes.parse(packet2.getPayload(), JdwpProtocol.this);
                    return packet2;
                }
            });
        } else if (packet.is(1, 17)) {
            pipe.addReplyInterceptor(packet.getId(), new JdwpInterceptor() { // from class: com.android.ddmlib.jdwp.JdwpProtocol.2
                @Override // com.android.ddmlib.jdwp.JdwpInterceptor
                public JdwpPacket intercept(JdwpPipe pipe2, JdwpPacket packet2) {
                    CapabilitiesNewReply capabilitiesNewReply = new CapabilitiesNewReply();
                    capabilitiesNewReply.parse(packet2.getPayload(), JdwpProtocol.this);
                    packet2.setPayload(capabilitiesNewReply.getConverted());
                    return packet2;
                }
            });
        }
    }
}
