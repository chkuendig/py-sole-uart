package com.sun.jna.platform.unix;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/* loaded from: classes4.dex */
public interface LibCAPI extends Reboot, Resource {
    public static final int HOST_NAME_MAX = 255;

    int close(int i);

    int getdomainname(byte[] bArr, int i);

    int getegid();

    String getenv(String str);

    int geteuid();

    int getgid();

    int gethostname(byte[] bArr, int i);

    int getloadavg(double[] dArr, int i);

    int getuid();

    int msync(Pointer pointer, size_t size_tVar, int i);

    int munmap(Pointer pointer, size_t size_tVar);

    int setdomainname(String str, int i);

    int setegid(int i);

    int setenv(String str, String str2, int i);

    int seteuid(int i);

    int setgid(int i);

    int sethostname(String str, int i);

    int setuid(int i);

    int unsetenv(String str);

    public static class size_t extends IntegerType {
        public static final size_t ZERO = new size_t();
        private static final long serialVersionUID = 1;

        public size_t() {
            this(0L);
        }

        public size_t(long j) {
            super(Native.SIZE_T_SIZE, j, true);
        }
    }

    public static class ssize_t extends IntegerType {
        public static final ssize_t ZERO = new ssize_t();
        private static final long serialVersionUID = 1;

        public ssize_t() {
            this(0L);
        }

        public ssize_t(long j) {
            super(Native.SIZE_T_SIZE, j, false);
        }
    }
}
