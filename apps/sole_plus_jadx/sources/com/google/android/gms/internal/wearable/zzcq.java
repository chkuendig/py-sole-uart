package com.google.android.gms.internal.wearable;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class zzcq extends IOException {
    private zzdn zza;

    public zzcq(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    static zzcp zza() {
        return new zzcp("Protocol message tag had invalid wire type.");
    }

    static zzcq zzb() {
        return new zzcq("Protocol message contained an invalid tag (zero).");
    }

    static zzcq zzc() {
        return new zzcq("Protocol message had invalid UTF-8.");
    }

    static zzcq zzd() {
        return new zzcq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzcq zze() {
        return new zzcq("Failed to parse the message.");
    }

    static zzcq zzg() {
        return new zzcq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzcq zzf(zzdn zzdnVar) {
        this.zza = zzdnVar;
        return this;
    }

    public zzcq(String str) {
        super(str);
        this.zza = null;
    }
}
