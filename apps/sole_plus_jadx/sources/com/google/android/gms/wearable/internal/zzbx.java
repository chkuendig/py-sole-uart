package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzbx extends InputStream {
    private final InputStream zza;

    @Nullable
    private volatile zzbi zzb;

    public zzbx(InputStream inputStream) {
        this.zza = (InputStream) Preconditions.checkNotNull(inputStream);
    }

    private final int zzb(int i) throws ChannelIOException {
        if (i != -1) {
            return i;
        }
        zzbi zzbiVar = this.zzb;
        if (zzbiVar == null) {
            return -1;
        }
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", zzbiVar.zza, zzbiVar.zzb);
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.zza.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.zza.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.zza.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i = this.zza.read();
        zzb(i);
        return i;
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        this.zza.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        return this.zza.skip(j);
    }

    final void zza(zzbi zzbiVar) {
        this.zzb = (zzbi) Preconditions.checkNotNull(zzbiVar);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i = this.zza.read(bArr);
        zzb(i);
        return i;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zza.read(bArr, i, i2);
        zzb(i3);
        return i3;
    }
}
