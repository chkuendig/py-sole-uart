package com.mapbox.mapboxsdk.events;

import android.os.Handler;
import android.util.Log;

/* loaded from: classes2.dex */
public class DelayedMapListener implements MapListener {
    protected static final int DEFAULT_DELAY = 100;
    private static final String TAG = "DelayedMapListener";
    protected CallbackTask callback;
    protected long delay;
    protected Handler handler;
    MapListener wrappedListener;

    public DelayedMapListener(MapListener mapListener, long j) {
        this.wrappedListener = mapListener;
        this.delay = j;
        this.handler = new Handler();
        this.callback = null;
    }

    public DelayedMapListener(MapListener mapListener) {
        this(mapListener, 100L);
    }

    @Override // com.mapbox.mapboxsdk.events.MapListener
    public void onScroll(ScrollEvent scrollEvent) {
        dispatch(scrollEvent);
    }

    @Override // com.mapbox.mapboxsdk.events.MapListener
    public void onZoom(ZoomEvent zoomEvent) {
        dispatch(zoomEvent);
    }

    protected void dispatch(MapEvent mapEvent) {
        CallbackTask callbackTask = this.callback;
        if (callbackTask != null) {
            this.handler.removeCallbacks(callbackTask);
        }
        CallbackTask callbackTask2 = new CallbackTask(mapEvent);
        this.callback = callbackTask2;
        this.handler.postDelayed(callbackTask2, this.delay);
    }

    private class CallbackTask implements Runnable {
        private final MapEvent event;

        public CallbackTask(MapEvent mapEvent) {
            this.event = mapEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            MapEvent mapEvent = this.event;
            if (mapEvent instanceof ScrollEvent) {
                DelayedMapListener.this.wrappedListener.onScroll((ScrollEvent) this.event);
                return;
            }
            if (mapEvent instanceof ZoomEvent) {
                DelayedMapListener.this.wrappedListener.onZoom((ZoomEvent) this.event);
                return;
            }
            Log.i(DelayedMapListener.TAG, "Unknown event received: " + this.event);
        }
    }
}
