package com.mapbox.mapboxsdk.overlay;

import android.view.Menu;
import android.view.MenuItem;
import com.mapbox.mapboxsdk.views.MapView;

/* loaded from: classes2.dex */
public interface IOverlayMenuProvider {
    boolean isOptionsMenuEnabled();

    boolean onCreateOptionsMenu(Menu menu, int i, MapView mapView);

    boolean onOptionsItemSelected(MenuItem menuItem, int i, MapView mapView);

    boolean onPrepareOptionsMenu(Menu menu, int i, MapView mapView);

    void setOptionsMenuEnabled(boolean z);
}
