package com.sun.jna.platform.win32;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.platform.win32.WTypes;

/* loaded from: classes4.dex */
public interface ShTypes {

    @Structure.FieldOrder({"uType", "u"})
    public static class STRRET extends Structure {
        public static final int TYPE_CSTR = 2;
        public static final int TYPE_OFFSET = 1;
        public static final int TYPE_WSTR = 0;
        public UNION u;
        public int uType;

        public static class UNION extends Union {
            public byte[] cStr = new byte[260];
            public WTypes.LPWSTR pOleStr;
            public int uOffset;

            public static class ByReference extends UNION implements Structure.ByReference {
            }
        }

        public STRRET() {
        }

        public STRRET(Pointer pointer) {
            super(pointer);
            read();
        }

        @Override // com.sun.jna.Structure
        public void read() {
            super.read();
            int i = this.uType;
            if (i == 1) {
                this.u.setType("uOffset");
            } else if (i != 2) {
                this.u.setType("pOleStr");
            } else {
                this.u.setType("cStr");
            }
            this.u.read();
        }
    }
}
