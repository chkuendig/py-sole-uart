package com.android.ddmlib.jdwp.packets;

import com.android.ddmlib.jdwp.JdwpPayload;
import com.android.ddmlib.jdwp.JdwpProtocol;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class CapabilitiesNewReply extends JdwpPayload {
    public static int CAN_REDEFINE_CLASSES_DEX_IDX = 31;
    public static int CAN_REDEFINE_CLASSES_IDX = 7;
    private ByteBuffer converted;

    @Override // com.android.ddmlib.jdwp.JdwpPayload
    public void parse(ByteBuffer buffer, JdwpProtocol protocol) {
        if (buffer.get(CAN_REDEFINE_CLASSES_DEX_IDX) != 0) {
            buffer.put(CAN_REDEFINE_CLASSES_IDX, (byte) 1);
            this.converted = buffer;
        }
        this.converted = buffer;
    }

    public ByteBuffer getConverted() {
        return this.converted;
    }
}
