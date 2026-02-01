package com.mapbox.mapboxsdk.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.MapView;

/* loaded from: classes2.dex */
public class InfoWindow {
    static int mDescriptionId;
    static int mImageId;
    static int mSubDescriptionId;
    static int mTitleId;
    private Marker boundMarker;
    private boolean mIsVisible = false;
    private MapView mMapView;
    private View mView;

    public void onClose() {
    }

    public InfoWindow(int i, MapView mapView) {
        this.mMapView = mapView;
        this.mView = ((LayoutInflater) mapView.getContext().getSystemService("layout_inflater")).inflate(i, (ViewGroup) mapView.getParent(), false);
        if (mTitleId == 0) {
            setResIds(mapView.getContext());
        }
        this.mView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mapbox.mapboxsdk.views.InfoWindow.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    InfoWindow.this.close();
                }
                return true;
            }
        });
    }

    public InfoWindow(View view, MapView mapView) {
        this.mMapView = mapView;
        this.mView = view;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.mapbox.mapboxsdk.views.InfoWindow.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    InfoWindow.this.close();
                }
                return true;
            }
        });
    }

    public InfoWindow open(Marker marker, LatLng latLng, int i, int i2) {
        onOpen(marker);
        MapView.LayoutParams layoutParams = new MapView.LayoutParams(-2, -2, latLng, 8, i, i2);
        close();
        this.mMapView.addView(this.mView, layoutParams);
        this.mIsVisible = true;
        return this;
    }

    public InfoWindow close() {
        if (this.mIsVisible) {
            this.mIsVisible = false;
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
            this.boundMarker.blur();
            setBoundMarker(null);
            onClose();
        }
        return this;
    }

    public View getView() {
        return this.mView;
    }

    public MapView getMapView() {
        return this.mMapView;
    }

    public void onOpen(Marker marker) {
        ((TextView) this.mView.findViewById(mTitleId)).setText(marker.getTitle());
        ((TextView) this.mView.findViewById(mDescriptionId)).setText(marker.getDescription());
        TextView textView = (TextView) this.mView.findViewById(mSubDescriptionId);
        String subDescription = marker.getSubDescription();
        if ("".equals(subDescription)) {
            textView.setVisibility(8);
        } else {
            textView.setText(subDescription);
            textView.setVisibility(0);
        }
    }

    public InfoWindow setBoundMarker(Marker marker) {
        this.boundMarker = marker;
        return this;
    }

    public Marker getBoundMarker() {
        return this.boundMarker;
    }

    private static void setResIds(Context context) {
        String packageName = context.getPackageName();
        mTitleId = context.getResources().getIdentifier("id/tooltip_title", null, packageName);
        mDescriptionId = context.getResources().getIdentifier("id/tooltip_description", null, packageName);
        mSubDescriptionId = context.getResources().getIdentifier("id/tooltip_subdescription", null, packageName);
        mImageId = context.getResources().getIdentifier("id/tooltip_image", null, packageName);
    }
}
