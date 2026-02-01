package com.sun.jna.platform.win32;

import com.sun.jna.platform.win32.Sspi;

/* loaded from: classes4.dex */
public class SspiUtil {

    public static class ManagedSecBufferDesc extends Sspi.SecBufferDesc {
        private final Sspi.SecBuffer[] secBuffers;

        public ManagedSecBufferDesc(int i, byte[] bArr) {
            Sspi.SecBuffer secBuffer = new Sspi.SecBuffer(i, bArr);
            Sspi.SecBuffer[] secBufferArr = {secBuffer};
            this.secBuffers = secBufferArr;
            this.pBuffers = secBuffer.getPointer();
            this.cBuffers = secBufferArr.length;
        }

        public ManagedSecBufferDesc(int i, int i2) {
            Sspi.SecBuffer secBuffer = new Sspi.SecBuffer(i, i2);
            Sspi.SecBuffer[] secBufferArr = {secBuffer};
            this.secBuffers = secBufferArr;
            this.pBuffers = secBuffer.getPointer();
            this.cBuffers = secBufferArr.length;
        }

        public ManagedSecBufferDesc(int i) {
            this.cBuffers = i;
            Sspi.SecBuffer[] secBufferArr = (Sspi.SecBuffer[]) new Sspi.SecBuffer().toArray(i);
            this.secBuffers = secBufferArr;
            this.pBuffers = secBufferArr[0].getPointer();
            this.cBuffers = secBufferArr.length;
        }

        public Sspi.SecBuffer getBuffer(int i) {
            return this.secBuffers[i];
        }

        @Override // com.sun.jna.Structure
        public void write() {
            for (Sspi.SecBuffer secBuffer : this.secBuffers) {
                secBuffer.write();
            }
            writeField("ulVersion");
            writeField("pBuffers");
            writeField("cBuffers");
        }

        @Override // com.sun.jna.Structure
        public void read() {
            for (Sspi.SecBuffer secBuffer : this.secBuffers) {
                secBuffer.read();
            }
        }
    }
}
