package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.win32.W32APITypeMapper;

/* loaded from: classes4.dex */
public interface Ntifs extends WinDef, BaseTSD {
    public static final int MAXIMUM_REPARSE_DATA_BUFFER_SIZE = 16384;
    public static final int REPARSE_BUFFER_HEADER_SIZE = 8;
    public static final int SYMLINK_FLAG_RELATIVE = 1;

    @Structure.FieldOrder({"SubstituteNameOffset", "SubstituteNameLength", "PrintNameOffset", "PrintNameLength", "Flags", "PathBuffer"})
    public static class SymbolicLinkReparseBuffer extends Structure {
        public int Flags;
        public char[] PathBuffer;
        public short PrintNameLength;
        public short PrintNameOffset;
        public short SubstituteNameLength;
        public short SubstituteNameOffset;

        public static class ByReference extends SymbolicLinkReparseBuffer implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(Pointer pointer) {
                super(pointer);
            }
        }

        public static int sizeOf() {
            return Native.getNativeSize(MountPointReparseBuffer.class, null);
        }

        public SymbolicLinkReparseBuffer() {
            super(W32APITypeMapper.UNICODE);
            this.SubstituteNameOffset = (short) 0;
            this.SubstituteNameLength = (short) 0;
            this.PrintNameOffset = (short) 0;
            this.PrintNameLength = (short) 0;
            this.Flags = 0;
            this.PathBuffer = new char[8192];
        }

        public SymbolicLinkReparseBuffer(Pointer pointer) {
            super(pointer, 0, W32APITypeMapper.UNICODE);
            this.SubstituteNameOffset = (short) 0;
            this.SubstituteNameLength = (short) 0;
            this.PrintNameOffset = (short) 0;
            this.PrintNameLength = (short) 0;
            this.Flags = 0;
            this.PathBuffer = new char[8192];
            read();
        }

        public SymbolicLinkReparseBuffer(String str, String str2, int i) {
            this.SubstituteNameOffset = (short) 0;
            this.SubstituteNameLength = (short) 0;
            this.PrintNameOffset = (short) 0;
            this.PrintNameLength = (short) 0;
            this.Flags = 0;
            this.PathBuffer = new char[8192];
            this.PathBuffer = (str + str2).toCharArray();
            this.SubstituteNameOffset = (short) 0;
            this.SubstituteNameLength = (short) (str.length() * 2);
            this.PrintNameOffset = (short) (str.length() * 2);
            this.PrintNameLength = (short) (str2.length() * 2);
            this.Flags = i;
            write();
        }

        public SymbolicLinkReparseBuffer(short s, short s2, short s3, short s4, int i, String str) {
            this.PathBuffer = new char[8192];
            this.SubstituteNameOffset = s;
            this.SubstituteNameLength = s2;
            this.PrintNameOffset = s3;
            this.PrintNameLength = s4;
            this.Flags = i;
            this.PathBuffer = str.toCharArray();
            write();
        }

        public String getPrintName() {
            return String.copyValueOf(this.PathBuffer, this.PrintNameOffset / 2, this.PrintNameLength / 2);
        }

        public String getSubstituteName() {
            return String.copyValueOf(this.PathBuffer, this.SubstituteNameOffset / 2, this.SubstituteNameLength / 2);
        }
    }

    @Structure.FieldOrder({"SubstituteNameOffset", "SubstituteNameLength", "PrintNameOffset", "PrintNameLength", "PathBuffer"})
    public static class MountPointReparseBuffer extends Structure {
        public char[] PathBuffer;
        public short PrintNameLength;
        public short PrintNameOffset;
        public short SubstituteNameLength;
        public short SubstituteNameOffset;

        public static class ByReference extends MountPointReparseBuffer implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(Pointer pointer) {
                super(pointer);
            }
        }

        public static int sizeOf() {
            return Native.getNativeSize(MountPointReparseBuffer.class, null);
        }

        public MountPointReparseBuffer() {
            super(W32APITypeMapper.UNICODE);
            this.SubstituteNameOffset = (short) 0;
            this.SubstituteNameLength = (short) 0;
            this.PrintNameOffset = (short) 0;
            this.PrintNameLength = (short) 0;
            this.PathBuffer = new char[8192];
        }

        public MountPointReparseBuffer(Pointer pointer) {
            super(pointer, 0, W32APITypeMapper.UNICODE);
            this.SubstituteNameOffset = (short) 0;
            this.SubstituteNameLength = (short) 0;
            this.PrintNameOffset = (short) 0;
            this.PrintNameLength = (short) 0;
            this.PathBuffer = new char[8192];
            read();
        }

        public MountPointReparseBuffer(String str, String str2) {
            this.SubstituteNameOffset = (short) 0;
            this.SubstituteNameLength = (short) 0;
            this.PrintNameOffset = (short) 0;
            this.PrintNameLength = (short) 0;
            this.PathBuffer = new char[8192];
            this.PathBuffer = (str + str2).toCharArray();
            this.SubstituteNameOffset = (short) 0;
            this.SubstituteNameLength = (short) str.length();
            this.PrintNameOffset = (short) (str.length() * 2);
            this.PrintNameLength = (short) (str2.length() * 2);
            write();
        }

        public MountPointReparseBuffer(short s, short s2, short s3, short s4, String str) {
            this.PathBuffer = new char[8192];
            this.SubstituteNameOffset = s;
            this.SubstituteNameLength = s2;
            this.PrintNameOffset = s3;
            this.PrintNameLength = s4;
            this.PathBuffer = str.toCharArray();
            write();
        }
    }

    @Structure.FieldOrder({"DataBuffer"})
    public static class GenericReparseBuffer extends Structure {
        public byte[] DataBuffer;

        public static class ByReference extends GenericReparseBuffer implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(Pointer pointer) {
                super(pointer);
            }
        }

        public static int sizeOf() {
            return Native.getNativeSize(GenericReparseBuffer.class, null);
        }

        public GenericReparseBuffer() {
            this.DataBuffer = new byte[16384];
        }

        public GenericReparseBuffer(Pointer pointer) {
            super(pointer);
            this.DataBuffer = new byte[16384];
            read();
        }

        public GenericReparseBuffer(String str) {
            this.DataBuffer = new byte[16384];
            this.DataBuffer = str.getBytes();
            write();
        }
    }

    @Structure.FieldOrder({"ReparseTag", "ReparseDataLength", "Reserved", "u"})
    public static class REPARSE_DATA_BUFFER extends Structure {
        public short ReparseDataLength;
        public int ReparseTag;
        public short Reserved;
        public REPARSE_UNION u;

        public static class ByReference extends REPARSE_DATA_BUFFER implements Structure.ByReference {
            public ByReference() {
            }

            public ByReference(Pointer pointer) {
                super(pointer);
            }
        }

        public static class REPARSE_UNION extends Union {
            public GenericReparseBuffer genericReparseBuffer;
            public MountPointReparseBuffer mountPointReparseBuffer;
            public SymbolicLinkReparseBuffer symLinkReparseBuffer;

            public static class ByReference extends REPARSE_UNION implements Structure.ByReference {
            }

            public REPARSE_UNION() {
            }

            public REPARSE_UNION(Pointer pointer) {
                super(pointer);
            }
        }

        public static int sizeOf() {
            return Native.getNativeSize(REPARSE_DATA_BUFFER.class, null);
        }

        public int getSize() {
            return this.ReparseDataLength + 8;
        }

        public REPARSE_DATA_BUFFER() {
            this.ReparseTag = 0;
            this.ReparseDataLength = (short) 0;
            this.Reserved = (short) 0;
        }

        public REPARSE_DATA_BUFFER(int i, short s) {
            this.ReparseTag = i;
            this.Reserved = s;
            this.ReparseDataLength = (short) 0;
            write();
        }

        public REPARSE_DATA_BUFFER(int i, short s, SymbolicLinkReparseBuffer symbolicLinkReparseBuffer) {
            this.ReparseDataLength = (short) 0;
            this.ReparseTag = i;
            this.Reserved = s;
            this.ReparseDataLength = (short) symbolicLinkReparseBuffer.size();
            this.u.setType(SymbolicLinkReparseBuffer.class);
            this.u.symLinkReparseBuffer = symbolicLinkReparseBuffer;
            write();
        }

        public REPARSE_DATA_BUFFER(Pointer pointer) {
            super(pointer);
            this.ReparseTag = 0;
            this.ReparseDataLength = (short) 0;
            this.Reserved = (short) 0;
            read();
        }

        @Override // com.sun.jna.Structure
        public void read() {
            super.read();
            int i = this.ReparseTag;
            if (i == -1610612733) {
                this.u.setType(MountPointReparseBuffer.class);
            } else if (i != -1610612724) {
                this.u.setType(GenericReparseBuffer.class);
            } else {
                this.u.setType(SymbolicLinkReparseBuffer.class);
            }
            this.u.read();
        }
    }
}
