package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
abstract class zzgp extends zzgo {
    private boolean zza;

    zzgp(zzfv zzfvVar) {
        super(zzfvVar);
        this.zzs.zzD();
    }

    protected void zzaA() {
    }

    protected abstract boolean zzf();

    protected final void zzu() {
        if (!zzx()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzf()) {
            return;
        }
        this.zzs.zzB();
        this.zza = true;
    }

    public final void zzw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaA();
        this.zzs.zzB();
        this.zza = true;
    }

    final boolean zzx() {
        return this.zza;
    }
}
