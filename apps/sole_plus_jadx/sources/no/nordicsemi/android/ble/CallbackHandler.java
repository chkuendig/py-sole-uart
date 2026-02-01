package no.nordicsemi.android.ble;

/* loaded from: classes6.dex */
interface CallbackHandler {
    void post(Runnable runnable);

    void postDelayed(Runnable runnable, long j);

    void removeCallbacks(Runnable runnable);
}
