package no.nordicsemi.android.ble;

import no.nordicsemi.android.ble.BleManagerHandler;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes6.dex */
public final /* synthetic */ class BleManagerHandler$$ExternalSyntheticLambda72 implements BleManagerHandler.Loggable {
    public final /* synthetic */ SecurityException f$0;

    public /* synthetic */ BleManagerHandler$$ExternalSyntheticLambda72(SecurityException securityException) {
        this.f$0 = securityException;
    }

    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
    public final String log() {
        return this.f$0.getLocalizedMessage();
    }
}
