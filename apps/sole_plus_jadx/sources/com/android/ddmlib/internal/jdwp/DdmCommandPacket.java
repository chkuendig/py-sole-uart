package com.android.ddmlib.internal.jdwp;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class DdmCommandPacket {
    private String mCommand;
    private int mLength;

    public DdmCommandPacket(ByteBuffer buffer) {
        if (buffer.position() < 4) {
            this.mLength = -1;
            return;
        }
        try {
            this.mLength = Integer.parseInt(new String(buffer.array(), 0, 4), 16);
            if (buffer.position() < this.mLength + 4) {
                this.mLength = -1;
            } else {
                this.mCommand = new String(buffer.array(), 4, this.mLength);
            }
        } catch (NumberFormatException unused) {
            this.mLength = -1;
        }
    }

    public int getLength() {
        return this.mLength;
    }

    public String getCommand() {
        return this.mCommand;
    }

    public int getTotalSize() {
        return this.mLength + 4;
    }
}
